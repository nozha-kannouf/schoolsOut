package service;

import data.ExamRepository;
import data.GradeRepository;
import model.Exam;
import java.util.stream.Collectors;

public class ExamService {
    ExamRepository examCRUD = new ExamRepository();
    GradeRepository gradeRepo = new GradeRepository();

    //Get Exams with subExams without grades
    public Exam outputExam(Long id){
        return examCRUD.retrieve(id).get();

    }
    public String getExamWithGrades(Long id){
        String result= null;
        Exam exam = examCRUD.retrieve(id).get();
        if( exam.getModule()!= null && exam.getExamGroup() != null )
            result= "Exam{" +
                    "id=" + id +
                    ", name='" + exam.getName() + '\'' +
                    ", date=" + exam.getDate() +
                    ", weight=" + exam.getWeight() +
                    ", total=" + exam.getTotal() +
                    ", description='" + exam.getDescription() + '\'' +
                    ", module= "+  exam.getModule().getName() + "("+exam.getModule().getId()+")"+
                    ", examGroup= " + exam.getExamGroup().getName() + "("+exam.getExamGroup().getId()+")"+
                    //", subExams=" + Arrays.asList(exam.getSubExams().toArray()).stream().map(e->"\n--->"+e).collect(Collectors.toList())+
                    ", subExams=" + exam.getSubExams().stream().map(e->"\n--->"+e+gradeRepo.getGradeByExamId(e.getId())).collect(Collectors.toList())+
                    ", grades"+ gradeRepo.getGradeByExamId(id)+
                    '}';

        if( exam.getModule()== null && exam.getExamGroup() != null )
            result = "Exam{" +
                    "id=" + id +
                    ", name='" + exam.getName() + '\'' +
                    ", date=" + exam.getDate() +
                    ", weight=" + exam.getWeight() +
                    ", total=" + exam.getTotal() +
                    ", description='" + exam.getDescription() + '\'' +
                    ", module= null" +
                    ", examGroup=" + exam.getExamGroup().getName() + "("+exam.getExamGroup().getId()+")"+
                    ", subExams=" + exam.getSubExams().stream().map(e->"\n--->"+e+gradeRepo.getGradeByExamId(e.getId())).collect(Collectors.toList())+
                    ", grades"+ gradeRepo.getGradeByExamId(id)+
                    '}';
        if( exam.getModule()!= null && exam.getExamGroup() == null )
            result = "Exam{" +
                    "id=" + id +
                    ", name='" + exam.getName() + '\'' +
                    ", date=" + exam.getDate() +
                    ", weight=" + exam.getWeight() +
                    ", total=" + exam.getTotal() +
                    ", description='" + exam.getDescription() + '\'' +
                    ", module= " + exam.getModule().getName() + "("+exam.getModule().getId()+")"+
                    ", examGroup=null"+
                    ", subExams=" + exam.getSubExams().stream().map(e->"\n--->"+e+gradeRepo.getGradeByExamId(e.getId())).collect(Collectors.toList())+
                    ", grades"+ gradeRepo.getGradeByExamId(id)+
                    '}';
        if( exam.getModule()== null && exam.getExamGroup() == null )
            result = "Exam{" +
                    "id=" + id +
                    ", name='" + exam.getName() + '\'' +
                    ", date=" + exam.getDate() +
                    ", weight=" + exam.getWeight() +
                    ", total=" + exam.getTotal() +
                    ", description='" + exam.getDescription() + '\'' +
                    ", module= null"+
                    ", examGroup=null"+
                    ", subExams=" + exam.getSubExams().stream().map(e->"\n--->"+e+gradeRepo.getGradeByExamId(e.getId())).collect(Collectors.toList())+
                    ", grades"+ gradeRepo.getGradeByExamId(id)+
                    '}';
        return result;
    }
}
