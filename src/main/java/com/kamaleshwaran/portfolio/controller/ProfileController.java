package com.kamaleshwaran.portfolio.controller;

import com.kamaleshwaran.portfolio.model.DeveloperProfile;
import com.kamaleshwaran.portfolio.repository.DeveloperProfileRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/profile")
@CrossOrigin(origins = "*")
public class ProfileController {

    private final DeveloperProfileRepository profileRepository;

    public ProfileController(DeveloperProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @GetMapping
    public ResponseEntity<DeveloperProfile> getProfile() {
        return profileRepository.findAll().stream().findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<DeveloperProfile> updateProfile(@RequestBody DeveloperProfile updated) {
        DeveloperProfile profile = profileRepository.findAll().stream().findFirst()
                .orElse(new DeveloperProfile());

        if (updated.getName() != null) profile.setName(updated.getName());
        if (updated.getTitle() != null) profile.setTitle(updated.getTitle());
        if (updated.getStatus() != null) profile.setStatus(updated.getStatus());
        if (updated.getLocation() != null) profile.setLocation(updated.getLocation());
        if (updated.getEmail() != null) profile.setEmail(updated.getEmail());
        if (updated.getPhone() != null) profile.getPhone();
        if (updated.getSummary() != null) profile.setSummary(updated.getSummary());
        if (updated.getPhotoUrl() != null) profile.setPhotoUrl(updated.getPhotoUrl());
        if (updated.getPhotoCropSize() != null) profile.setPhotoCropSize(updated.getPhotoCropSize());
        if (updated.getGithub() != null) profile.setGithub(updated.getGithub());
        if (updated.getLinkedin() != null) profile.setLinkedin(updated.getLinkedin());
        if (updated.getTwitter() != null) profile.setTwitter(updated.getTwitter());
        if (updated.getLeetcode() != null) profile.setLeetcode(updated.getLeetcode());
        if (updated.getActivePreset() != null) profile.setActivePreset(updated.getActivePreset());

        return ResponseEntity.ok(profileRepository.save(profile));
    }

    @PostMapping("/preset")
    public ResponseEntity<DeveloperProfile> switchPreset(@RequestBody Map<String, String> body) {
        String preset = body.get("preset"); // FULLSTACK, JAVA_BACKEND, AWS_CLOUD, DEFAULT
        DeveloperProfile profile = profileRepository.findAll().stream().findFirst()
                .orElse(new DeveloperProfile());
        
        if (preset != null) {
            profile.setActivePreset(preset);
            profileRepository.save(profile);
        }
        return ResponseEntity.ok(profile);
    }
}
