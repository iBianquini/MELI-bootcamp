package com.meli.dentinhosmongo.repository;

import com.meli.dentinhosmongo.entity.Schedule;
import com.meli.dentinhosmongo.entity.enums.ScheduleStatus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends MongoRepository<Schedule, String> {

    List<Schedule> getScheduleByDentist_CodeMp(String codeMp);

    List<Schedule> getScheduleByScheduleStatus(ScheduleStatus scheduleStatus);
}
