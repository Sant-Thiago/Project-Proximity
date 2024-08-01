package com.example.beck.Led.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.beck.Led.Model.Led;
import com.example.beck.Led.Repository.LedRepository;

@Service
public class LedService {
    
    @Autowired
    LedRepository ledRepository;    

    public Led getLed(Long id) {
        Optional<Led> optionalLed = ledRepository.findById(id);
        if (optionalLed.isEmpty()) {
            throw new Error(); 
        }
        return optionalLed.get();
    }

    public Led setLed(Led led) {
        Led ledSave = ledRepository.save(led);
        return ledSave;
    }
}
