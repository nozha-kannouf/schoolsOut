package view;

import data.*;
import model.*;
import model.Module;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        UserCRUDOperations userCRUD = new UserCRUDOperations();
        PersonCRUDOperations personCRUD = new PersonCRUDOperations();
        CourseCRUDOperations courseCRUD = new CourseCRUDOperations();
        ModuleCRUDOperations moduleCRUD = new ModuleCRUDOperations();
        ExamCRUDOperations examCRUD = new ExamCRUDOperations();

        Course course1 = Course.builder().active(true).code("codeCourse1").description("description course1").imageURL("url to course1").name("course1").build();
        Course course2 = Course.builder().active(true).code("codeCourse2").description("description course2").imageURL("url to course2").name("course2").build();

        model.Module module1 = Module.builder().course(course1).description("description module1").name("module1").build();

        Exam exam1= Exam.builder().module(module1).date(LocalDate.now()).description("description exam1").name("exam1").total(60).weight(30).build();


        Person person1 = Person.builder().familyName("kannouf").firstName("Nozha").gender(Gender.FEMALE).course(course1).build();
        Person person2 = Person.builder().familyName("Lahri").firstName("amine").gender(Gender.MALE).course(course2).build();

        User user1 = User.builder().login("login15").passwordHash("password1").active(true).person(person1).build();
        User user2 = User.builder().login("login16").passwordHash("password2").active(true).person(person2).build();


        courseCRUD.create(course1);
        courseCRUD.create(course2);

        moduleCRUD.create(module1);
        examCRUD.create(exam1);

        personCRUD.create(person1);
        personCRUD.create(person2);
        userCRUD.create(user1);
        userCRUD.create(user2);

    }
}
