package com.kamaleshwaran.portfolio.controller;

import com.kamaleshwaran.portfolio.model.Experience;
import com.kamaleshwaran.portfolio.repository.ExperienceRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experiences")
@CrossOrigin(origins = "*")
public class ExperienceController {

    private final ExperienceRepository experienceRepository;

    public ExperienceController(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    @GetMapping
    public ResponseEntity<List<Experience>> getAllExperiences() {
        return ResponseEntity.ok(experienceRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Experience> createExperience(@RequestBody Experience experience) {
        return ResponseEntity.status(HttpStatus.CREATED).body(experienceRepository.save(experience));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Experience> updateExperience(@PathVariable Long id, @RequestBody Experience updated) {
        return experienceRepository.findById(id)
                .map(exp -> {
                    exp.setRole(updated.getRole());
                    exp.setCompany(updated.getCompany());
                    exp.setPeriod(updated.getPeriod());
                    exp.setType(updated.getType());
                    exp.setLocation(updated.getLocation());
                    exp.setDescription(updated.getDescription());
                    exp.setAchievementsJson(updated.getAchievementsJson());
                    exp.setTechJson(updated.getTechJson());
                    return ResponseEntity.ok(experienceRepository.save(exp));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExperience(@PathVariable Long id) {
        if (experienceRepository.existsById(id)) {
            experienceRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
