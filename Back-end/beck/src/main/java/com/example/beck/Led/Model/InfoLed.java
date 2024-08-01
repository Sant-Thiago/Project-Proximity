package com.example.beck.Led.Model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Table
@Entity(name="Info_Led")
public class InfoLed {
    
    @NotNull
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long Id;

    @NotBlank
    @ManyToOne
    private Led led;

    @NotBlank
    private Date Data;

    @NotBlank
    private Boolean StatusLed;
    
    @NotNull
    private Double UnconsumedEnergy;
    
    @NotNull
    private Double SavedMoney;
}
