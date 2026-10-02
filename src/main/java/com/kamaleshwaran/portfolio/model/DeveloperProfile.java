package com.kamaleshwaran.portfolio.model;

import jakarta.persistence.*;

@Entity
@Table(name = "developer_profiles")
public class DeveloperProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String title;
    private String status;
    private String location;
    private String email;
    private String phone;
    private String github;
    private String linkedin;
    private String twitter;
    private String leetcode;

    @Column(length = 2000)
    private String summary;

    @Lob
    private String photoUrl;
    private String photoCropSize = "SQUARE";
    private String activePreset = "FULLSTACK"; // DEFAULT, FULLSTACK, JAVA_BACKEND, AWS_CLOUD

    public DeveloperProfile() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getGithub() { return github; }
    public void setGithub(String github) { this.github = github; }

    public String getLinkedin() { return linkedin; }
    public void setLinkedin(String linkedin) { this.linkedin = linkedin; }

    public String getTwitter() { return twitter; }
    public void setTwitter(String twitter) { this.twitter = twitter; }

    public String getLeetcode() { return leetcode; }
    public void setLeetcode(String leetcode) { this.leetcode = leetcode; }

    public String getSummary() { return summary; }
    public void setSummary(String summary) { this.summary = summary; }

    public String getPhotoUrl() { return photoUrl; }
    public void setPhotoUrl(String photoUrl) { this.photoUrl = photoUrl; }

    public String getPhotoCropSize() { return photoCropSize == null ? "SQUARE" : photoCropSize; }
    public void setPhotoCropSize(String photoCropSize) { this.photoCropSize = photoCropSize; }

    public String getActivePreset() { return activePreset; }
    public void setActivePreset(String activePreset) { this.activePreset = activePreset; }
}
