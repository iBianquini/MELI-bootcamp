package com.meli.dentinhosmongo.service;

import com.meli.dentinhosmongo.dto.UserDTO;
import com.meli.dentinhosmongo.entity.Dentist;
import com.meli.dentinhosmongo.entity.User;
import com.meli.dentinhosmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AddressService addressService;

    @Autowired
    public UserService(UserRepository userRepository, AddressService addressService) {
        this.userRepository = userRepository;
        this.addressService = addressService;
    }


    public User createUser(UserDTO userDTO) {
        if (userDTO.getAddress() != null) {
            userDTO.setAddress(this.addressService.checkAddress(userDTO.getAddress()));
        }

        if (userDTO.getCodeMp() == null || userDTO.getCodeMp().isEmpty())
            return this.createPatient(userDTO);
        else
            return this.createDentist(userDTO);
    }

    public List<Dentist> getDentistsByCodeMp(List<String> dentistsMp) {
        return this.userRepository.findByCodeMpIn(dentistsMp);
    }

    public User getPatientByDni(String patientDni) {
        User patient = this.userRepository.findByDni(patientDni);
        if (patient != null)
            return patient;
        throw new RuntimeException("Paciente não encontrado.");
    }

    public Dentist getDentistByMp(String dentistMp) {
        Dentist dentist = this.userRepository.findByCodeMp(dentistMp);
        if (dentist != null)
            return dentist;
        throw new RuntimeException("Dentista não encontrado.");
    }

    public Dentist getDentistByLastName(String lastName) {
        Dentist dentist = this.userRepository.findByLastName(lastName);
        if (dentist != null)
            return dentist;
        throw new RuntimeException("Dentista não encontrado.");
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
