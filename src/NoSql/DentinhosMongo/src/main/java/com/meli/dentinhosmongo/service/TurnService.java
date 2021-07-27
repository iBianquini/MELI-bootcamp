package com.meli.dentinhosmongo.service;

import com.meli.dentinhosmongo.dto.TurnCreationDTO;
import com.meli.dentinhosmongo.dto.TurnRetrievalDTO;
import com.meli.dentinhosmongo.dto.UserRetrievalDTO;
import com.meli.dentinhosmongo.entity.Dentist;
import com.meli.dentinhosmongo.entity.Turn;
import com.meli.dentinhosmongo.entity.User;
import com.meli.dentinhosmongo.repository.TurnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TurnService {

    private final UserService userService;
    private final TurnRepository turnRepository;

    @Autowired
    public TurnService(UserService userService, TurnRepository turnRepository) {
        this.userService = userService;
        this.turnRepository = turnRepository;
    }

    public Turn createTurn(TurnCreationDTO turnCreationDTO) {
        Turn turn = Turn.castToEntity(turnCreationDTO);
        this.validateDentistInsertion(turnCreationDTO.getDentistsMP(), turn);
        return this.turnRepository.save(turn);
    }

    public void setDentistToTurn(String turnId, List<String> dentistsMp) {
        Turn turn = this.getDentist(turnId);
        this.validateDentistInsertion(dentistsMp, turn);
        this.turnRepository.save(turn);
    }

    private void validateDentistInsertion(List<String> dentistsMp, Turn turn) {
        if (dentistsMp != null && !dentistsMp.isEmpty()) {
            List<Dentist> dentistsToPersist = userService.getDentistsByCodeMp(dentistsMp);
            turn.setDentistsToTurn(dentistsToPersist);
        }
    }

    private Turn getDentist(String turnId) {
        Optional<Turn> turn = this.turnRepository.findById(turnId);
        if (turn.isPresent())
            return turn.get();
        throw new RuntimeException("Turno não encontrado");
    }

    public List<TurnRetrievalDTO> getAllTurns() {
        List<Turn> turns = this.turnRepository.findAll();
        return this.castTurnsToDTO(turns);
    }

    public List<TurnRetrievalDTO> getTurnByDentistLastName(String lastName) {
        Dentist dentist = this.userService.getDentistByLastName(lastName);

        List<Turn> turns = this.turnRepository.findTurnByDentistsContains(dentist);

        return this.castTurnsToDTO(turns);

    }

    private List<TurnRetrievalDTO> castTurnsToDTO(List<Turn> turns) {
        List<TurnRetrievalDTO> turnRetrievalDTOs = new ArrayList<>();
        for (Turn turn : turns) {
            List<UserRetrievalDTO> userDTOs = User.castToUserDTO(turn.getDentists());
            turnRetrievalDTOs.add(turn.castToRetrievalDTO(userDTOs));
        }

        return turnRetrievalDTOs;
    }

}
