package view;

import data.*;
import model.*;
import model.Module;

import java.time.LocalDate;
import java.util.List;

public class App {
    public static void main(String[] args) {
        UserCRUD userCRUD = new UserCRUD();
        PersonCRUD personCRUD = new PersonCRUD();
        CourseCRUD courseCRUD = new CourseCRUD();
        ModuleCRUD moduleCRUD = new ModuleCRUD();
        ExamCRUD examCRUD = new ExamCRUD();

        Exam exam1= Exam.builder().date(LocalDate.now()).description("description exam1").name("exam1").total(60).weight(30).build();

        Module module1 = Module.builder().description("description module1").name("module1").exams(List.of(exam1)).build();

        Course course1 = Course.builder().active(true).code("codeCourse1").description("description course1").imageURL("url to course1").name("course1").modules(List.of(module1, module1)).build();
        Course course2 = Course.builder().active(true).code("codeCourse2").description("description course2").imageURL("url to course2").name("course2").modules(List.of(module1)).build();

        Person person1 = Person.builder().familyName("kannouf").firstName("Nozha").gender(Gender.FEMALE).course(course1).build();
        Person person2 = Person.builder().familyName("Lahri").firstName("amine").gender(Gender.MALE).course(course2).build();

        User user1 = User.builder().login("login3").passwordHash("password1").active(true).person(person1).build();
        User user2 = User.builder().login("login4").passwordHash("password2").active(true).person(person2).build();

        examCRUD.create(exam1);
        moduleCRUD.create(module1);
        courseCRUD.create(course1);
        courseCRUD.create(course2);
        userCRUD.create(user1);
        userCRUD.create(user2);
        personCRUD.create(person1);
        personCRUD.create(person2);



    }
}
