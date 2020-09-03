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

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Course.class)
    private Course course;

    @OneToMany(mappedBy = "module",fetch = FetchType.EAGER, targetEntity = Exam.class)
    private List<Exam> exams;

}
