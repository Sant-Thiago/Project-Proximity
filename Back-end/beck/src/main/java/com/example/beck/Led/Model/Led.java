package com.example.beck.Led.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Table
@Entity(name = "Led")
public class Led {
    
    @NotNull
    @GeneratedValue(strategy=GenerationType.UUID)
    private Long Id;

    @NotNull
    private Long minBrightnessPercent;
}
