package com.kamaleshwaran.portfolio.controller;

import com.kamaleshwaran.portfolio.model.Project;
import com.kamaleshwaran.portfolio.repository.ProjectRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin(origins = "*")
public class ProjectController {

    private final ProjectRepository projectRepository;

    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        return ResponseEntity.ok(projectRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        return ResponseEntity.status(HttpStatus.CREATED).body(projectRepository.save(project));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project updated) {
        return projectRepository.findById(id)
                .map(project -> {
                    project.setTitle(updated.getTitle());
                    project.setCategory(updated.getCategory());
                    project.setFeatured(updated.isFeatured());
                    project.setImage(updated.getImage());
                    project.setTagline(updated.getTagline());
                    project.setDescription(updated.getDescription());
                    project.setHighlightsJson(updated.getHighlightsJson());
                    project.setTechJson(updated.getTechJson());
                    project.setGithubUrl(updated.getGithubUrl());
                    project.setLiveUrl(updated.getLiveUrl());
                    project.setPresetTag(updated.getPresetTag());
                    return ResponseEntity.ok(projectRepository.save(project));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        if (projectRepository.existsById(id)) {
            projectRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
