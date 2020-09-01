package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Lob
    private String description;
    private String code;
    @Column(name = "imageurl")
    private String imageURL;
    private boolean active;
    @OneToMany(mappedBy = "course")
    List<Module> modules;

    public Long getId() {
        return id;
    }

    public Course setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Course setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Course setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Course setCode(String code) {
        this.code = code;
        return this;
    }

    public String getImageURL() {
        return imageURL;
    }

    public Course setImageURL(String imageURL) {
        this.imageURL = imageURL;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public Course setActive(boolean active) {
        this.active = active;
        return this;
    }

    public List<Module> getModules() {
        return modules;
    }

    public Course setModules(List<Module> modules) {
        this.modules = modules;
        return this;
    }
}
