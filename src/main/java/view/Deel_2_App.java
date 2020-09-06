package view;

import data.ExamRepository;
import data.GradeRepository;
import data.PersonRepository;
import model.Exam;
import model.Grade;
import model.Person;
import service.ExamService;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Deel_2_App {
    public static void main(String[] args) {
        ExamRepository examRepository = new ExamRepository();
        PersonRepository personRepository = new PersonRepository();
        Grade grade = Grade.builder().gradeValue(BigDecimal.valueOf(75))
                                     .absent(false)
                                     .Comment("Comment over grade")
                                     .internalComment("Comment internalComment")
                                     .postponed(false)
                                     .person(personRepository.retrieve(29).get())//   Person.builder().id(29).build())
                                     .exam(examRepository.retrieve(29L).get())//Exam.builder().id(29L).build())
                                     .date(LocalDate.now())
                                     .build();

        GradeRepository gradeRepo = new GradeRepository();
        gradeRepo.create(grade);
        ExamService es= new ExamService();
        //es.outputExam(28L);
    }
}
