package service;

import data.ExamRepository;
import data.GradeRepository;

public class ExamService {
    ExamRepository examCRUD = new ExamRepository();
    GradeRepository gradeRepo = new GradeRepository();
    public void outputExam(Long id){
        System.out.println(examCRUD.retrieve(id).get());
        examCRUD.getSubExams(id).forEach(exam ->
                                System.out.println("--->"+exam
                                                         +gradeRepo.getGradeByExamId(exam.getId())
                                                         +"\n"));
    }
}
