package com.pwojtowicz.pam.Perk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/perks")
public class PerkController {

    private final PerkService perkService;

    @Autowired
    public PerkController(PerkService perkService) {
        this.perkService = perkService;
    }

    @GetMapping("/getall")
    public List<Perk> getAllPerks() {
        return perkService.getAllPerks();
    }

    @GetMapping("/byid/{id}")
    public Perk getPerkById(@PathVariable Long id) {
        return perkService.getPerkById(id);
    }

    @PostMapping("add")
    public Perk addPerk(@RequestBody Perk perk) {
        return perkService.addPerk(perk);
    }

    @PutMapping("/update/{id}")
    public Perk updatePerk(@PathVariable Long id, @RequestBody Perk perk) {
        return perkService.updatePerk(id, perk);
    }

    @DeleteMapping("/del/{id}")
    public void deletePerk(@PathVariable Long id) {
        perkService.deletePerk(id);
    }
}
