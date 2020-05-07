package jp.ac.dendai.sie.usd.student.infrastructure.repository.db.memory;

import jp.ac.dendai.sie.usd.domain.model.Question;
import jp.ac.dendai.sie.usd.domain.model.Questionnaire;
import jp.ac.dendai.sie.usd.domain.model.Subject;
import jp.ac.dendai.sie.usd.infrastructure.db.memory.MemoryQuestionSingleton;
import jp.ac.dendai.sie.usd.student.usecase.repository.QuestionRepository;

import javax.ws.rs.NotFoundException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by guest1 on 2018/10/28.
 */
public class MemoryQuestionRepositoryImp implements QuestionRepository {
    MemoryQuestionSingleton memoryQuestionSingleton = MemoryQuestionSingleton.getInstance();

    @Override
    public List<Question> findAnyByQuestionnaireId(Long questionnaireId) {
        Optional<Questionnaire> questionnaire = new MemoryQuestionnaireRepositoryImp().findByQuestionnaireId(questionnaireId);
        return memoryQuestionSingleton.getQuestionList().stream().filter(question -> question.getQuestionnaireId().equals(questionnaire.orElseThrow(() -> new NotFoundException("questionnaireIdが見つかりません:MemoryQuestionRepositoryImp")).getQuestionnaireId())).collect(Collectors.toList());
    }

    @Override
    public List<Question> findAnyBySubjectId(Long subjectId) {
        List<Questionnaire> questionnaireList = new MemoryQuestionnaireRepositoryImp().findAnyBySubjectId(subjectId);
        return questionnaireList
                .stream()
                .map(questionnaire -> findAnyByQuestionnaireId(questionnaire.getQuestionnaireId()))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    @Override
    public List<Question> findAnyByStudentId(String studentId) {
        List<Subject> subjectList = new MemorySubjectRepositoryImp().findAnyByStudentId(studentId);
        return subjectList
                .stream()
                .map(subject -> findAnyBySubjectId(subject.getSubjectId()))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
