package view;

import service.ExamService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Map;

public class Deel_2_App {
    public static void main(String[] args) {

        ExamService es= new ExamService();
        es.outputExam(28L);
    }
}
