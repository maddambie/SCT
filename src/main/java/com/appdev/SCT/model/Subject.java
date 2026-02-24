package com.appdev.SCT.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String subject_code;
    private String subject;
    private String courseid;
    private int major;
    private int unit;
    private int year_level;
    private String semester;

    // Constructors
    public Subject() {}

    public Subject(String subject_code, String subject,String courseid, int major, int creditUnits, int year_level, String semester) {
        this.subject_code = subject_code ;
        this.subject = subject;
        this.courseid = courseid;
        this.major = major;
        this.unit = unit;
        this.year_level = year_level;
        this.semester = semester;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSubject_code() { return subject_code; }
    public void setSubject_code(String subject_code) { this.subject_code = subject_code; }

    public String getSubject() { return subject; }
    public void setSubject(String Subject) { this.subject = subject; }

    public String getCourseidt() { return courseid; }
    public void setCourseid(String courseid) { this.courseid = courseid; }
    
    public int getMajor() { return major; }
    public void setMajor(int major) { this.major = major; }
    
    public int getUnit() { return unit; }
    public void setUnit(int unit) { this.unit = unit; }

    public int getYear_level() { return year_level; }
    public void setYear_level(int year_level) { this.year_level = year_level; }
    
    public String getSemester() { return semester; }
    public void setSemester(String semester) { this.semester = semester; }
}
