package com.mthouse.services.admin;

import com.mthouse.entities.admin.Meeting_minute;
import com.mthouse.repositories.adminRepo.MinuteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MinuteService {

    @Autowired
    private MinuteRepo minuteRepo;

    @Transactional(readOnly = true)
    public Iterable<Meeting_minute> getAll(){
        return minuteRepo.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Meeting_minute> getById(int id){
        return minuteRepo.findById(id);
    }

    @Transactional(readOnly = true)
    public Iterable<Meeting_minute> getByTaker(int minuteTaker){
        return minuteRepo.findByMinuteTakerId(minuteTaker);
    }

    @Transactional
    public Meeting_minute create (Meeting_minute m){
        m.setMeetingDate();
        return minuteRepo.save(m);
    }

    @Transactional
    public Meeting_minute update(Meeting_minute m){
        return minuteRepo.save(m);
    }

    @Transactional
    public void delete (int id){
        minuteRepo.deleteById(id);
    }
}
