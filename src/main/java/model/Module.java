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
@Table(name = "module")
public class Module {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Lob
    private String description;
    @ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "id", nullable = false)
    private Course course;
    @OneToMany(mappedBy = "module",fetch = FetchType.EAGER, targetEntity = Exam.class, cascade = CascadeType.ALL)
    private List<Exam> exams;

}
