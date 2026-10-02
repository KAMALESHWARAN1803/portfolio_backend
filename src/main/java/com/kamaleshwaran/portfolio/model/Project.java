package com.kamaleshwaran.portfolio.model;

import jakarta.persistence.*;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String slug; // hospital-whatsapp-backend, etc.
    private String title;
    private String category;
    private boolean featured = true;
    private String image;
    
    @Column(length = 500)
    private String tagline;

    @Column(length = 2000)
    private String description;

    @Column(length = 2000)
    private String highlightsJson; // stored as JSON array string or comma separated

    @Column(length = 1000)
    private String techJson; // stored as JSON array string or comma separated

    private String githubUrl;
    private String liveUrl;
    private String presetTag = "ALL"; // ALL, JAVA_BACKEND, AWS_CLOUD, FULLSTACK

    public Project() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSlug() { return slug; }
    public void setSlug(String slug) { this.slug = slug; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public boolean isFeatured() { return featured; }
    public void setFeatured(boolean featured) { this.featured = featured; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public String getTagline() { return tagline; }
    public void setTagline(String tagline) { this.tagline = tagline; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getHighlightsJson() { return highlightsJson; }
    public void setHighlightsJson(String highlightsJson) { this.highlightsJson = highlightsJson; }

    public String getTechJson() { return techJson; }
    public void setTechJson(String techJson) { this.techJson = techJson; }

    public String getGithubUrl() { return githubUrl; }
    public void setGithubUrl(String githubUrl) { this.githubUrl = githubUrl; }

    public String getLiveUrl() { return liveUrl; }
    public void setLiveUrl(String liveUrl) { this.liveUrl = liveUrl; }

    public String getPresetTag() { return presetTag; }
    public void setPresetTag(String presetTag) { this.presetTag = presetTag; }
}
