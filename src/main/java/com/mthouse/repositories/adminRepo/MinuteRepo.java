package com.mthouse.repositories.adminRepo;

import com.mthouse.entities.admin.Meeting_minute;
import org.springframework.data.repository.CrudRepository;

public interface MinuteRepo extends CrudRepository<Meeting_minute, Integer> {

    public Iterable<Meeting_minute> findByMinuteTakerId(int minuteTakerId);
}
