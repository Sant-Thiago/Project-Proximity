package com.example.beck.Led.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.beck.Led.Model.InfoLed;
import com.example.beck.Led.Repository.InfoLedRepository;

@Service
public class InfoLedService {
    
    @Autowired
    InfoLedRepository infoLedRepository;

    public InfoLed getInfoLed(Long id) {
        Optional<InfoLed> optionalInfoLed = infoLedRepository.findById(id);
        if (optionalInfoLed.isEmpty()) {
            throw new Error(); 
        }
        return optionalInfoLed.get();
    }

    public InfoLed setInfoLed(InfoLed infoLed) {
        InfoLed infoLedSave = infoLedRepository.save(infoLed);
        return infoLedSave;
    } 
}
