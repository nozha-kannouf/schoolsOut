package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "user")
public class User {
    @Id
    private String login;
    private String passwordHash;
    private boolean active;
    @OneToOne
    private Person person;

}
