package com.example.beck.Led.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.beck.Led.Model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {}
   