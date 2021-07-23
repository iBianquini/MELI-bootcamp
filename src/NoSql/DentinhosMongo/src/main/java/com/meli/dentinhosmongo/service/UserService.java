package com.meli.dentinhosmongo.service;

import com.meli.dentinhosmongo.dto.UserDTO;
import com.meli.dentinhosmongo.entity.Dentist;
import com.meli.dentinhosmongo.entity.User;
import com.meli.dentinhosmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(UserDTO userDTO) {
        if (userDTO.getCodeMp() == null || !userDTO.getCodeMp().isEmpty())
            return this.createPatient(userDTO);
        else
            return this.createDentist(userDTO);
    }


    private User createPatient(UserDTO userDTO) {
        User patient = User.castToPatient(userDTO);

        return this.userRepository.save(patient);
    }

    private Dentist createDentist(UserDTO userDTO) {
        Dentist dentist = Dentist.castToDentist(userDTO);
        return this.userRepository.save(dentist);
    }
}
