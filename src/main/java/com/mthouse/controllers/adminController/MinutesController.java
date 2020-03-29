package com.mthouse.controllers.adminController;

import com.mthouse.entities.admin.Meeting_minute;
import com.mthouse.services.admin.MinuteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/minute")
public class MinutesController {

    @Autowired
    private MinuteService minuteService;

    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public String test (){
        return "Meeting minute controller works";
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Meeting_minute> getAll(){
        return minuteService.getAll();
    }

    @GetMapping(value ="/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Meeting_minute> getById(@PathVariable int id){
        return minuteService.getById(id);
    }

    @GetMapping(value = "/uplaoder/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Meeting_minute> getByTaker(@PathVariable int id){
        return minuteService.getByTaker(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Meeting_minute create (@RequestBody Meeting_minute m){
        return minuteService.create(m);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Meeting_minute update (@RequestBody Meeting_minute m){
        return minuteService.update(m);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete (@PathVariable int id){
        minuteService.delete(id);
    }
}
