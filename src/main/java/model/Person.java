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

    @ManyToOne
    private Course course;

}
