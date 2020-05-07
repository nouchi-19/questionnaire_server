package jp.ac.dendai.sie.usd.student.infrastructure.repository.db.memory;

import jp.ac.dendai.sie.usd.infrastructure.db.memory.MemoryIdStore;
import jp.ac.dendai.sie.usd.domain.model.Answer;
import jp.ac.dendai.sie.usd.domain.model.Result;
import jp.ac.dendai.sie.usd.domain.model.User;
import jp.ac.dendai.sie.usd.infrastructure.db.memory.MemoryAnswerSingleton;
import jp.ac.dendai.sie.usd.student.usecase.repository.AnswerRepository;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by guest1 on 2018/10/29.
 */
public class MemoryAnswerRepositoryImp implements AnswerRepository {
    MemoryAnswerSingleton memoryAnswerSingleton = MemoryAnswerSingleton.getInstance();
    MemoryIdStore memoryIdStore = MemoryIdStore.getInstance();

    @Override
    public Long insert(Answer answer) {
        answer.setAnswerId(memoryIdStore.createId("answerId"));
        memoryAnswerSingleton.getAnswerList().add(answer);
        return answer.getAnswerId();
    }

    @Override
    public List<Long> insertMany(List<Answer> answerList) {
        //todo
        return null;
    }


    @Override
    public List<Answer> findAnyByResultId(Long resultId) {
        return memoryAnswerSingleton.getAnswerList().stream().filter(answer -> answer.getResultId().equals(resultId)).collect(Collectors.toList());
    }

    @Override
    public List<Answer> findAnyByQuestionnaireId(Long questionnaireId) {
        List<Result> resultList = new MemoryResultRepositoryImp().findAnyByQuestionnaireId(questionnaireId);
        return resultList.stream().map(result -> findAnyByResultId(result.getResultId())).flatMap(Collection::stream).collect(Collectors.toList());
    }

    @Override
    public List<Answer> findAnyByQuestionnaireIdAndStudentId(Long questionnaireId, String studentId) {
        List<Result> resultList = new MemoryResultRepositoryImp().findAnyByQuestionnaireIdAndStudentId(questionnaireId, studentId);
        return resultList.stream().map(result -> findAnyByResultId(result.getResultId())).flatMap(Collection::stream).collect(Collectors.toList());
    }

    @Override
    public List<Answer> findAnyByQuestionnaireIdNewAnswers(Long questionnaireId) {
        System.out.println("findAnyByQuestionnaireIdNewAnswers");
        List<Result> resultList = new MemoryResultRepositoryImp().findAnyByQuestionnaireId(questionnaireId);
        List<User> studentList = new ArrayList<>();
        List<Result> distinctResultList = new ArrayList<>();
        for(Result result: resultList.stream().sorted(Comparator.comparing(Result::getResponseTime).reversed()).collect(Collectors.toList())) {
            if(!studentList.contains(result.getStudent())) {
                studentList.add(result.getStudent());
                distinctResultList.add(result);
            }
        }
        return distinctResultList.stream().map(result -> findAnyByResultId(result.getResultId())).flatMap(Collection::stream).collect(Collectors.toList());
    }

    @Override
    public void deleteAnswer(Long answerId) {
        //todo create
    }

}
