package com.meli.dentinhosmongo.controller;

import com.meli.dentinhosmongo.dto.ScheduleDTO;
import com.meli.dentinhosmongo.entity.Schedule;
import com.meli.dentinhosmongo.entity.enums.ScheduleStatus;
import com.meli.dentinhosmongo.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/create/{dentistMp}/{patientDni}/{data}")
    public Schedule setSchedule(@PathVariable String patientDni,
                                @PathVariable String dentistMp,
                                @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime data) {
        return this.scheduleService.setSchedule(patientDni, dentistMp, data);
    }

    @GetMapping("/{codeMp}")
    public List<ScheduleDTO> getScheduleByDentist(@PathVariable String codeMp) {
        return this.scheduleService.getScheduleByDentist(codeMp);
    }

    @GetMapping("status/{status}")
    public List<ScheduleDTO> getScheduleByStatus(@PathVariable ScheduleStatus status) {
        return this.scheduleService.getScheduleByStatus(status);
    }

}
