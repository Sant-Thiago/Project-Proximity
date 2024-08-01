package com.example.beck.Led.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.beck.Led.Model.InfoLed;

@Repository
public interface InfoLedRepository extends JpaRepository<InfoLed, Long>{}
