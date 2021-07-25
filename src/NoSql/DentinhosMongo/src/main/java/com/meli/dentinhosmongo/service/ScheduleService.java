package com.meli.dentinhosmongo.service;

import com.meli.dentinhosmongo.dto.ScheduleDTO;
import com.meli.dentinhosmongo.entity.Dentist;
import com.meli.dentinhosmongo.entity.Schedule;
import com.meli.dentinhosmongo.entity.User;
import com.meli.dentinhosmongo.entity.enums.ScheduleStatus;
import com.meli.dentinhosmongo.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final UserService userService;

    @Autowired
    public ScheduleService(ScheduleRepository scheduleRepository, UserService userService) {
        this.scheduleRepository = scheduleRepository;
        this.userService = userService;
    }

    public List<ScheduleDTO> getScheduleByDentist(String codeMp) {
        List<Schedule> schedules = this.scheduleRepository.getScheduleByDentist_CodeMp(codeMp);
        List<ScheduleDTO> scheduleDTOs = new ArrayList<>();

        for (Schedule schedule : schedules) {
            scheduleDTOs.add(schedule.castToScheduleDTO());
        }

        return scheduleDTOs;
    }

    public Schedule setSchedule(String patientDni, String dentistMp, LocalDateTime data) {
        User patient = this.userService.getPatientByDni(patientDni);

        Dentist dentist = this.userService.getDentistByMp(dentistMp);

        Schedule schedule = new Schedule(data, ScheduleStatus.PENDENTE, patient, dentist);

        return this.scheduleRepository.save(schedule);
    }

    public List<ScheduleDTO> getScheduleByStatus(ScheduleStatus status) {
        List<Schedule> schedules = this.scheduleRepository.getScheduleByScheduleStatus(status);

        List<ScheduleDTO> scheduleDTOs = new ArrayList<>();

        for (Schedule schedule : schedules) {
            scheduleDTOs.add(schedule.castToScheduleDTO());
        }

        return scheduleDTOs;
    }
}
