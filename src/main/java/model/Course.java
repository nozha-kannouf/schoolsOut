package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private boolean active;
    private String code;
    @Lob
    private String description;
    @Column(name = "imageurl")
    private String imageURL;
    @OneToMany(mappedBy = "course", targetEntity = Module.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Module> modules;

}
