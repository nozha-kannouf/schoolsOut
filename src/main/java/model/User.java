package model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    private String login;
    private String passwordHash;
    private boolean active;
    @OneToOne(mappedBy = "user")
    private Person person;

    public String getLogin() {
        return login;
    }

    public User setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public User setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public User setActive(boolean active) {
        this.active = active;
        return this;
    }

    public Person getPerson() {
        return person;
    }

    public User setPerson(Person person) {
        this.person = person;
        return this;
    }
}
