package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "familyname")
    private String familyName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @OneToOne
    private User user;
    @OneToMany
    private List<Course> courses;

    public Integer getId() {
        return id;
    }

    public Person setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Person setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getFamilyName() {
        return familyName;
    }

    public Person setFamilyName(String familyName) {
        this.familyName = familyName;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public Person setGender(Gender gender) {
        this.gender = gender;
        return this;
    }


    public User getUser() {
        return user;
    }

    public Person setUser(User user) {
        this.user = user;
        return this;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public Person setCourses(List<Course> courses) {
        this.courses = courses;
        return this;
    }
}
