package com.pwojtowicz.pam.Perk;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerkService {

    private final PerkRepository perkRepository;

    @Autowired
    public PerkService(PerkRepository perkRepository) {
        this.perkRepository = perkRepository;
    }

    public List<Perk> getAllPerks() {
        return perkRepository.findAll();
    }

    public Perk getPerkById(Long id) {
        return perkRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Perk not found -> id: " + id));
    }

    public Perk addPerk(Perk perk) {
        return perkRepository.save(perk);
    }

    public Perk updatePerk(Long id, Perk perk) {
        Perk existingPerk = perkRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Perk not found -> id: " + id));
        existingPerk.setName(perk.getName());
        existingPerk.setRooms(perk.getRooms());
        return perkRepository.save(existingPerk);
    }

    public void deletePerk(Long id) {
        Perk perk = perkRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Perk not found -> id: " + id));
        perkRepository.delete(perk);
    }
}