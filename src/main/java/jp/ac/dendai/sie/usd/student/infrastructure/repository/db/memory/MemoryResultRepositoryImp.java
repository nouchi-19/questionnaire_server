package jp.ac.dendai.sie.usd.student.infrastructure.repository.db.memory;

import jp.ac.dendai.sie.usd.infrastructure.db.memory.MemoryIdStore;
import jp.ac.dendai.sie.usd.domain.model.Questionnaire;
import jp.ac.dendai.sie.usd.domain.model.Result;
import jp.ac.dendai.sie.usd.domain.model.Subject;
import jp.ac.dendai.sie.usd.infrastructure.db.memory.MemoryResultSingleton;
import jp.ac.dendai.sie.usd.student.usecase.repository.ResultRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by guest1 on 2018/10/29.
 */
public class MemoryResultRepositoryImp implements ResultRepository {
    MemoryResultSingleton memoryResultSingleton = MemoryResultSingleton.getInstance();
    MemoryIdStore memoryIdStore = MemoryIdStore.getInstance();

    @Override
    public Long insert(Result result) {
        result.setResultId(memoryIdStore.createId("resultId"));
//        result.setResponseTime(LocalDateTime.now());
        memoryResultSingleton.getResultList().add(result);
        return result.getResultId();
    }

    @Override
    public Optional<Result> findByResultId(Long resultId) {
        return memoryResultSingleton.getResultList().stream().filter(result -> result.getResultId().equals(resultId)).findFirst();
    }

    @Override
    public List<Result> findAnyByQuestionnaireId(Long questionnaireId) {
        return memoryResultSingleton.getResultList().stream().filter(result -> result.getQuestionnaireId().equals(questionnaireId)).collect(Collectors.toList());
    }

    @Override
    public List<Result> findAnyByQuestionnaireIdAndStudentId(Long questionnaireId, String studentId) {
        return memoryResultSingleton.getResultList().stream().filter(result -> result.getStudent().getUserId().equals(studentId)).filter(result -> result.getQuestionnaireId().equals(questionnaireId)).collect(Collectors.toList());
    }

    @Override
    public List<Result> findAnyBySubjectIdAndStudentId(Long subjectId, String studentId) {
        List<Result> resultList = new ArrayList<>();
        List<Questionnaire> questionnaireList = new MemoryQuestionnaireRepositoryImp().findAnyBySubjectId(subjectId);
        for(Questionnaire questionnaire :questionnaireList) {
            resultList.addAll(findAnyByQuestionnaireIdAndStudentId(questionnaire.getQuestionnaireId(), studentId));
        }
        return resultList;
    }

    @Override
    public List<Result> findAnyByStudentId(String studentId) {
        List<Result> resultList = new ArrayList<>();
        List<Subject> subjectList = new MemorySubjectRepositoryImp().findAnyByStudentId(studentId);
        for(Subject subject : subjectList) {
            List<Questionnaire> questionnaireList = new MemoryQuestionnaireRepositoryImp().findAnyBySubjectId(subject.getSubjectId());
            for(Questionnaire questionnaire :questionnaireList) {
                resultList.addAll(findAnyByQuestionnaireIdAndStudentId(questionnaire.getQuestionnaireId(), studentId));
            }
        }
        return resultList;
    }
}
