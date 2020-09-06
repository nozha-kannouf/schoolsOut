package model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "exam")
public class Exam {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private LocalDate date;
    private int weight;
    private int total;
    @Lob
    private String description;

    @ManyToOne(targetEntity = model.Module.class,
               fetch = FetchType.EAGER,
               cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    @JoinColumn(name = "module_id")
    private Module module;

    @ManyToOne(targetEntity = Exam.class,
            fetch = FetchType.EAGER,
            cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    @JoinColumn(name = "examGroup_id", referencedColumnName = "id")
    @ToString.Exclude
    private Exam examGroup;

    @OneToMany(mappedBy = "examGroup",
            fetch = FetchType.EAGER,
            targetEntity = Exam.class,
            cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    @ToString.Exclude
    private List<Exam> subExams;

}
