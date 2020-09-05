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

        //createTest(userCRUD,personCRUD,courseCRUD,moduleCRUD,examCRUD);

        //retrieveTest(userCRUD,personCRUD,courseCRUD,moduleCRUD,examCRUD);

        deleteTest(userCRUD,personCRUD,courseCRUD,moduleCRUD,examCRUD);

        //updateTest(userCRUD,personCRUD,courseCRUD,moduleCRUD,examCRUD);

    }

    private static void updateTest(UserCRUDOperations userCRUD, PersonCRUDOperations personCRUD, CourseCRUDOperations courseCRUD, ModuleCRUDOperations moduleCRUD, ExamCRUDOperations examCRUD) {
        User user = User.builder().login("login17").passwordHash("passwordUpdated").active(true).build();
       // Person person = Person.builder().id(12).familyName("lahriUpdated").gender(Gender.MALE).firstName("amineUpdated").course(course).build();
        Module module2 = Module.builder().id(15L).build();
        Course course = Course.builder().id(19L).active(true).code("INFO248Updated").description("description course1 updated").imageURL("url to course1").name("Algorithme Updated").build();
        Module module1 = Module.builder().id(7L).description("module updated").course(course).build();
        Exam exam= Exam.builder().id(1L).module(module1).date(LocalDate.now()).description("description exam1 updated").name("exam1 updated").total(60).weight(30).build();




        //userCRUD.update(user);//ok
        //personCRUD.update(person);//ok
        //courseCRUD.update(course);//ok
        //moduleCRUD.update(module1);//ok
        //examCRUD.update(exam);//ok
    }

    private static void deleteTest(UserCRUDOperations userCRUD, PersonCRUDOperations personCRUD, CourseCRUDOperations courseCRUD, ModuleCRUDOperations moduleCRUD, ExamCRUDOperations examCRUD) {
        Course course = Course.builder().id(25L).active(true).code("INFO248").description("description course1").imageURL("url to course1").name("Algorithme").build();

        model.Module module1 = Module.builder().id(27L).course(course).description("xxxx").name("Securité Informatique").build();

        Exam exam1= Exam.builder().id(52L).module(module1).date(LocalDate.now()).description("description exam1").name("exam1").total(60).weight(30).build();

        Person person1 = Person.builder().id(18).course(course).familyName("Geudens").firstName("Patrick").gender(Gender.MALE).build();

        User user1 = User.builder().login("login12").passwordHash("password2").person(person1).active(true).build();

        //userCRUD.delete(user1);//ok
        //personCRUD.delete(person1);//ok
        //moduleCRUD.delete(module1);// ok
        //courseCRUD.delete(course); // oK
       //examCRUD.delete(exam1);// OK

    }


    private static void createTest(UserCRUDOperations userCRUD, PersonCRUDOperations personCRUD, CourseCRUDOperations courseCRUD,
                                   ModuleCRUDOperations moduleCRUD, ExamCRUDOperations examCRUD){
        //Test of create operations

        Course course1 = Course.builder().active(true).code("INFO248").description("description course1").imageURL("url to course1").name("Algorithme").build();
        Course course2 = Course.builder().active(true).code("INFO56").description("description course2").imageURL("url to course2").name("Réseaux Informatique").build();

        model.Module module1 = Module.builder().course(course1).description("description module").name("Informatique").build();

        Exam exam1= Exam.builder().module(module1).date(LocalDate.now()).description("description exam1").name("exam1").total(60).weight(30).build();


        Person person1 = Person.builder().familyName("Geudens").firstName("Patrick").gender(Gender.MALE).course(course1).build();
        Person person2 = Person.builder().familyName("DS").firstName("Pearl").gender(Gender.FEMALE).course(course2).build();

        User user1 = User.builder().login("login20").passwordHash("password1").active(true).person(person1).build();

        courseCRUD.create(course1).ifPresentOrElse(
                                                    course -> System.out.println("The course is registered..!"),
                                                    () -> System.err.println("Error: course could NOT be saved.."));
        courseCRUD.create(course2).ifPresentOrElse(
                                                    course -> System.out.println("The course is registered..!"),
                                                    () -> System.err.println("Error: course could NOT be saved.."));

        moduleCRUD.create(module1).ifPresentOrElse(
                                                    module -> System.out.println("The module is registered..!"),
                                                    () -> System.err.println("Error: module could NOT be saved.."));
        examCRUD.create(exam1).ifPresentOrElse(
                                                exam -> System.out.println("The exam is registered..!"),
                                                () -> System.err.println("Error: exam could NOT be saved.."));

        personCRUD.create(person1).ifPresentOrElse(
                                                    person -> System.out.println("The person is registered..!"),
                                                    () -> System.err.println("Error: person could NOT be saved.."));
        personCRUD.create(person2).ifPresentOrElse(
                                                    exam -> System.out.println("The person is registered..!"),
                                                    () -> System.err.println("Error: person could NOT be saved.."));
        userCRUD.create(user1).ifPresentOrElse(
                                                user -> System.out.println("The user is registered..!"),
                                                () -> System.err.println("Error: user could NOT be saved.."));
    }

    private static void retrieveTest(UserCRUDOperations userCRUD, PersonCRUDOperations personCRUD, CourseCRUDOperations courseCRUD,
                                     ModuleCRUDOperations moduleCRUD, ExamCRUDOperations examCRUD){
        //Test of retrieve operations
        //There is no login190 in the DB
        userCRUD.retrieve("login190").ifPresentOrElse(
                                                            user -> System.out.println("The user : "+ user + ", exist in the DB"),
                                                            () -> System.err.println("Error: user is NOT found.."));


        personCRUD.retrieve(53).ifPresentOrElse(
                                                        person -> System.out.println("The person : "+ person + ", exist in the DB"),
                                                        () -> System.err.println("Error: person is NOT found.."));
        courseCRUD.retrieve(13L).ifPresentOrElse(
                                                     course -> System.out.println("The course : "+ course + ", exist in the DB"),
                                                     () -> System.err.println("Error: course is NOT found.."));
        moduleCRUD.retrieve(21L).ifPresentOrElse(
                                                        module -> System.out.println("The module : "+ module + ", exist in the DB"),
                                                        () -> System.err.println("Error: module is NOT found.."));
        examCRUD.retrieve(46L).ifPresentOrElse(
                                                    exam -> System.out.println("The exam : "+ exam + ", exist in the DB"),
                                                    () -> System.err.println("Error: exam is NOT found.."));

    }
}
