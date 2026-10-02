package com.kamaleshwaran.portfolio.data;

import com.kamaleshwaran.portfolio.model.*;
import com.kamaleshwaran.portfolio.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    private final AdminUserRepository adminUserRepository;
    private final DeveloperProfileRepository profileRepository;
    private final SkillRepository skillRepository;
    private final ProjectRepository projectRepository;
    private final ExperienceRepository experienceRepository;
    private final PasswordEncoder passwordEncoder;

    public DataSeeder(AdminUserRepository adminUserRepository,
                      DeveloperProfileRepository profileRepository,
                      SkillRepository skillRepository,
                      ProjectRepository projectRepository,
                      ExperienceRepository experienceRepository,
                      PasswordEncoder passwordEncoder) {
        this.adminUserRepository = adminUserRepository;
        this.profileRepository = profileRepository;
        this.skillRepository = skillRepository;
        this.projectRepository = projectRepository;
        this.experienceRepository = experienceRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        seedAdminUser();
        seedDeveloperProfile();
        seedSkills();
        seedProjects();
        seedExperience();
    }

    private void seedAdminUser() {
        AdminUser existingAdmin = adminUserRepository.findByUsername("Kamalesh").orElse(null);

        if (existingAdmin != null) {
            existingAdmin.setPassword(passwordEncoder.encode("Kamal@123"));
            existingAdmin.setRole("ADMIN");
            adminUserRepository.save(existingAdmin);
            return;
        }

        AdminUser admin = new AdminUser("Kamalesh", passwordEncoder.encode("Kamal@123"), "ADMIN");
        adminUserRepository.save(admin);
    }

    private void seedDeveloperProfile() {
        if (profileRepository.count() == 0) {
            DeveloperProfile profile = new DeveloperProfile();
            profile.setName("KAMALESHWARAN S");
            profile.setTitle("Full Stack Software Developer (Java, Spring Boot & AWS)");
            profile.setStatus("Available for High-Impact Roles");
            profile.setLocation("Salem, Tamil Nadu, India");
            profile.setEmail("kamaleshwaransing2005@gmail.com");
            profile.setPhone("+91 9715191354");
            profile.setGithub("https://github.com/KAMALESHWARAN1803");
            profile.setLinkedin("https://linkedin.com");
            profile.setTwitter("https://twitter.com");
            profile.setLeetcode("https://leetcode.com");
            profile.setSummary("Passionate Full-Stack Engineer with hands-on experience building Java, Spring Boot RESTful APIs, and deploying production backend microservices onto AWS Cloud infrastructure (EC2, S3, RDS), along with React, HTML, CSS, and JavaScript on the frontend. Active open-source contributor with projects spanning automated WhatsApp-integrated hospital booking engines, ERP systems, and student doubt resolution portals. Proficient in SQL, Spring Data JPA, cloud deployments, and Agile collaborative development.");
            profile.setPhotoUrl("/developer_avatar.png");
            profile.setActivePreset("FULLSTACK");
            profileRepository.save(profile);
        }
    }

    private void seedSkills() {
        if (skillRepository.count() == 0) {
            List<Skill> initialSkills = List.of(
                // Backend & Cloud
                new Skill("Java (17+)", 92, "Backend & Cloud", "Server"),
                new Skill("Spring Boot", 90, "Backend & Cloud", "Cpu"),
                new Skill("AWS Cloud (EC2 / S3 / RDS)", 88, "Backend & Cloud", "Cloud"),
                new Skill("RESTful APIs", 94, "Backend & Cloud", "Network"),
                new Skill("Spring Data JPA / Hibernate", 88, "Backend & Cloud", "Database"),
                new Skill("Spring MVC & Security", 85, "Backend & Cloud", "ShieldCheck"),

                // Cloud & DevOps Tools
                new Skill("AWS (EC2, RDS, S3, IAM)", 88, "Cloud & DevOps Tools", "Cloud"),
                new Skill("Cloud Backend Deployment", 90, "Cloud & DevOps Tools", "Zap"),
                new Skill("Docker & Containerization", 82, "Cloud & DevOps Tools", "Box"),
                new Skill("Git & GitHub Actions", 90, "Cloud & DevOps Tools", "GitBranch"),

                // Languages
                new Skill("Java", 92, "Languages", "Code2"),
                new Skill("JavaScript (ES6+)", 88, "Languages", "FileCode2"),
                new Skill("SQL (MySQL / PostgreSQL)", 86, "Languages", "Database"),
                new Skill("HTML5 / CSS3", 92, "Languages", "Layout"),
                new Skill("C / C++", 75, "Languages", "Terminal"),

                // Frontend & Web
                new Skill("React.js", 88, "Frontend & Web", "Layers"),
                new Skill("HTML5 & CSS3", 94, "Frontend & Web", "Layout"),
                new Skill("JavaScript / ES6+", 88, "Frontend & Web", "FileCode2"),
                new Skill("Tailwind CSS & Responsive UI", 85, "Frontend & Web", "Palette"),
                new Skill("Vite & Modern Tooling", 86, "Frontend & Web", "Settings"),

                // Databases & Tools
                new Skill("MySQL", 88, "Databases & Tools", "Database"),
                new Skill("PostgreSQL", 84, "Databases & Tools", "Database"),
                new Skill("Git & GitHub", 90, "Databases & Tools", "GitBranch"),
                new Skill("Postman API Testing", 88, "Databases & Tools", "CheckCircle2"),
                new Skill("Maven & Build Tools", 85, "Databases & Tools", "Box"),
                new Skill("VS Code & IntelliJ IDEA", 92, "Databases & Tools", "Settings")
            );
            skillRepository.saveAll(initialSkills);
        }
    }

    private void seedProjects() {
        if (projectRepository.count() == 0) {
            Project p1 = new Project();
            p1.setSlug("hospital-whatsapp-backend");
            p1.setTitle("Hospital Appointment WhatsApp Booking Backend");
            p1.setCategory("Java, Spring Boot & AWS");
            p1.setFeatured(true);
            p1.setImage("/project_whatsapp_booking.png");
            p1.setTagline("Automated WhatsApp-integrated hospital appointment scheduling backend engine in Java Spring Boot, deployed on AWS Cloud.");
            p1.setDescription("Engineered a seamless hospital appointment booking system using Java Spring Boot RESTful APIs, integrating WhatsApp messaging workflows for real-time patient appointment confirmation, queue scheduling, doctor slot management, and automated status notifications. Pushed and deployed live backend services onto AWS Cloud.");
            p1.setHighlightsJson("[\"Designed modular Spring Boot REST controllers and service layers with Spring Data JPA & MySQL persistence.\",\"Deployed Spring Boot backend microservice and relational database instance onto AWS Cloud (EC2 / RDS).\",\"Webhook messaging integration with WhatsApp for automated patient appointment confirmations.\",\"Implemented appointment status lifecycle management, doctor slot scheduling, and robust error handling.\"]");
            p1.setTechJson("[\"Java\",\"Spring Boot\",\"AWS (EC2/RDS)\",\"Spring Data JPA\",\"REST API\",\"WhatsApp API\",\"MySQL\",\"Git\"]");
            p1.setGithubUrl("https://github.com/KAMALESHWARAN1803/Hospital_appointment_whatsapp_backend");
            p1.setLiveUrl("https://github.com/KAMALESHWARAN1803/Hospital_appointment_whatsapp_backend");
            p1.setPresetTag("JAVA_BACKEND");

            Project p2 = new Project();
            p2.setSlug("erp-system-basic");
            p2.setTitle("Enterprise Resource Planning (ERP) System");
            p2.setCategory("Full-Stack");
            p2.setFeatured(true);
            p2.setImage("/project_erp_system.png");
            p2.setTagline("Scalable ERP system basic prototype for enterprise workflow, inventory, and role management.");
            p2.setDescription("Designed and developed an Enterprise Resource Planning system prototype for managing business operations, client data, inventory tracking, role-based resource access, and operational workflow status.");
            p2.setHighlightsJson("[\"Dynamic business management dashboard built with modern JavaScript and HTML5/CSS3 layouts.\",\"Configured client administration modules, inventory tracking views, and operational task tracking.\",\"Structured REST API endpoint integration ensuring clean separation of concerns and fast responsiveness.\"]");
            p2.setTechJson("[\"JavaScript\",\"HTML5\",\"CSS3\",\"Node.js\",\"Express.js\",\"REST APIs\",\"Git\"]");
            p2.setGithubUrl("https://github.com/KAMALESHWARAN1803/ver1_ERP_basic");
            p2.setLiveUrl("https://github.com/KAMALESHWARAN1803/ver1_ERP_basic");
            p2.setPresetTag("FULLSTACK");

            Project p3 = new Project();
            p3.setSlug("doubt-portal-eatek");
            p3.setTitle("Doubt Resolution Portal (EAtek)");
            p3.setCategory("Frontend & Web");
            p3.setFeatured(true);
            p3.setImage("/project_doubt_portal.png");
            p3.setTagline("Interactive academic Q&A and student doubt resolution web platform.");
            p3.setDescription("A responsive web platform designed to allow students to submit academic queries, filter doubts by subject categories, track resolution status, and receive structured feedback from mentors.");
            p3.setHighlightsJson("[\"Intuitive, mobile-responsive user interface with dynamic subject tagging and search capabilities.\",\"Structured mentor response board featuring status badges (Pending, Under Review, Resolved).\",\"Clean client-side form validation and accessible web UI components.\"]");
            p3.setTechJson("[\"HTML5\",\"CSS3\",\"JavaScript\",\"Responsive Design\",\"Git\"]");
            p3.setGithubUrl("https://github.com/KAMALESHWARAN1803/doubt_portal_EAtek");
            p3.setLiveUrl("https://github.com/KAMALESHWARAN1803/doubt_portal_EAtek");
            p3.setPresetTag("FULLSTACK");

            Project p4 = new Project();
            p4.setSlug("techeazy-fullstack-suite");
            p4.setTitle("TechEazy Full-Stack Enterprise Suite");
            p4.setCategory("Full-Stack & AWS");
            p4.setFeatured(true);
            p4.setImage("/project_techeazy_fullstack.png");
            p4.setTagline("Comprehensive full-stack application suite with Java Spring Boot REST services, AWS Cloud backend, and React web app.");
            p4.setDescription("An end-to-end full-stack development repository showcasing enterprise design patterns, Java Spring Boot REST API web services deployed on AWS Cloud, relational database persistence, and dynamic web interfaces.");
            p4.setHighlightsJson("[\"Scalable Spring MVC controller and service layer architecture following best backend practices.\",\"Deployed backend services to AWS EC2 cloud instance with relational MySQL database integration.\",\"Complete CRUD REST API endpoints integrated with relational database backend and frontend UI components.\",\"Developed with test-driven concepts and Agile version control workflows.\"]");
            p4.setTechJson("[\"Java\",\"Spring Boot\",\"AWS (EC2/RDS)\",\"React.js\",\"REST API\",\"SQL / MySQL\",\"HTML/CSS\",\"Git\"]");
            p4.setGithubUrl("https://github.com/KAMALESHWARAN1803/tech_eazy_fullstack_kamaleshwaran1803");
            p4.setLiveUrl("https://github.com/KAMALESHWARAN1803/tech_eazy_fullstack_kamaleshwaran1803");
            p4.setPresetTag("AWS_CLOUD");

            projectRepository.saveAll(List.of(p1, p2, p3, p4));
        }
    }

    private void seedExperience() {
        if (experienceRepository.count() == 0) {
            Experience exp = new Experience();
            exp.setRole("Full Stack Java & AWS Developer");
            exp.setCompany("TechEazy Fullstack Training & Open Source");
            exp.setPeriod("2025 — Present");
            exp.setType("Full-Time / Hands-on Project Developer");
            exp.setLocation("India");
            exp.setDescription("Developing end-to-end full stack software applications using Java Spring Boot REST APIs, AWS Cloud infrastructure, relational databases, and modern web frontends.");
            exp.setAchievementsJson("[\"Built and deployed an automated WhatsApp hospital appointment booking system backend using Java Spring Boot and REST Webhooks onto AWS Cloud (EC2 / RDS).\",\"Engineered basic Enterprise Resource Planning (ERP) platform modules for business resource and workflow management.\",\"Configured cloud relational database persistence with AWS RDS and Spring Data JPA.\",\"Developed an interactive student doubt resolution portal for real-time query categorization and mentor guidance.\",\"Implemented RESTful web services with robust controller-service-repository layered architecture.\"]");
            exp.setTechJson("[\"Java\",\"Spring Boot\",\"AWS (EC2/RDS)\",\"Spring Data JPA\",\"REST APIs\",\"MySQL\",\"React\",\"JavaScript\",\"Git\"]");
            experienceRepository.save(exp);
        }
    }
}
