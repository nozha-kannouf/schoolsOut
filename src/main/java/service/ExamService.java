package service;

import data.ExamCRUDOperations;

public class ExamService {
    ExamCRUDOperations examCRUD = new ExamCRUDOperations();
    public void outputExam(Long id){
        System.out.println(examCRUD.retrieve(id).get());
    }
}
