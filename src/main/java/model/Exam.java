package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

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
    @ManyToOne(cascade = CascadeType.ALL)
    private Module module;

}
