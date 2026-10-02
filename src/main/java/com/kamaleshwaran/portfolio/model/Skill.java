package com.kamaleshwaran.portfolio.model;

import jakarta.persistence.*;

@Entity
@Table(name = "skills")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int level; // 0 to 100
    private String category; // Backend & Cloud, Cloud & DevOps Tools, Languages, Frontend & Web, Databases & Tools
    private String icon; // Server, Cpu, Cloud, Network, Database, ShieldCheck, Zap, Box, GitBranch, etc.

    public Skill() {}

    public Skill(String name, int level, String category, String icon) {
        this.name = name;
        this.level = level;
        this.category = category;
        this.icon = icon;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getIcon() { return icon; }
    public void setIcon(String icon) { this.icon = icon; }
}
