package com.pwojtowicz.pam.Perk;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerkRepository extends JpaRepository<Perk, Long> {
}
