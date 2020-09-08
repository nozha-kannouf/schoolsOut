package model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//@Getter@Setter@RequiredArgsConstructor@EqualsAndHashCode
@Data
@AllArgsConstructor
@NoArgsConstructor
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
            cascade = {CascadeType.MERGE})
    @JoinColumn(name = "examGroup_id", referencedColumnName = "id")
    //@ToString.Exclude
    private Exam examGroup;

    @OneToMany(mappedBy = "examGroup",
            fetch = FetchType.EAGER,
            targetEntity = Exam.class,
            cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    private List<Exam> subExams;

    @Override
    public String toString() {
        String result= null;

        if( module!= null && examGroup != null )
        result= "Exam{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", weight=" + weight +
                ", total=" + total +
                ", description='" + description + '\'' +
                ", module= "+  module.getName() + "("+module.getId()+")"+
                ", examGroup= " + examGroup.getName() + "("+examGroup.getId()+")"+
                ", subExams=" + Arrays.asList(subExams.toArray()).stream().map(e->"\n--->"+e).collect(Collectors.toList())+
                '}';

        if( module== null && examGroup != null )
        result = "Exam{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", date=" + date +
                    ", weight=" + weight +
                    ", total=" + total +
                    ", description='" + description + '\'' +
                    ", module= null" +
                    ", examGroup=" + examGroup.getName() + "("+examGroup.getId()+")"+
                    ", subExams=" + Arrays.asList(subExams.toArray()).stream().map(e->"\n--->"+e).collect(Collectors.toList())+
                    '}';
        if( module!= null && examGroup == null )
            result = "Exam{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", date=" + date +
                    ", weight=" + weight +
                    ", total=" + total +
                    ", description='" + description + '\'' +
                    ", module= " + module.getName() + "("+module.getId()+")"+
                    ", examGroup=null"+
                    ", subExams=" + Arrays.asList(subExams.toArray()).stream().map(e->"\n--->"+e).collect(Collectors.toList())+
                    '}';
        if( module== null && examGroup == null )
            result = "Exam{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", date=" + date +
                    ", weight=" + weight +
                    ", total=" + total +
                    ", description='" + description + '\'' +
                    ", module= null"+
                    ", examGroup=null"+
                    ", subExams=" + Arrays.asList(subExams.toArray()).stream().map(e->"\n--->"+e).collect(Collectors.toList())+
                    '}';
    return result;
    }
}
