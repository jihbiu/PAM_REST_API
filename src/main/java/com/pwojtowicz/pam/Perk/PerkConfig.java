package com.pwojtowicz.pam.Perk;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.List;

@Configuration
@DependsOn("hotelConfig")
public class PerkConfig {

    private final PerkRepository perkRepository;

    @Autowired
    public PerkConfig(PerkRepository perkRepository) {
        this.perkRepository = perkRepository;
    }

    @PostConstruct
    public void initPerks() {
        List<Perk> perks = List.of(
                new Perk("Wanna"),
                new Perk("Balkon"),
                new Perk("Widok na morze"),
                new Perk("Klimatyzacja"),
                new Perk("Łazienka"),
                new Perk("TV"),
                new Perk("Bezpłatne WiFi")
        );

        perkRepository.saveAll(perks);
    }
}



