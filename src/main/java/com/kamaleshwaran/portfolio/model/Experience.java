package com.kamaleshwaran.portfolio.model;

import jakarta.persistence.*;

@Entity
@Table(name = "experiences")
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String role;
    private String company;
    private String period;
    private String type;
    private String location;

    @Column(length = 1500)
    private String description;

    @Column(length = 2000)
    private String achievementsJson;

    @Column(length = 1000)
    private String techJson;

    public Experience() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public String getPeriod() { return period; }
    public void setPeriod(String period) { this.period = period; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getAchievementsJson() { return achievementsJson; }
    public void setAchievementsJson(String achievementsJson) { this.achievementsJson = achievementsJson; }

    public String getTechJson() { return techJson; }
    public void setTechJson(String techJson) { this.techJson = techJson; }
}
