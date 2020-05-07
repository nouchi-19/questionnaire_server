package jp.ac.dendai.sie.usd.student.infrastructure.repository.db.memory;

import jp.ac.dendai.sie.usd.domain.model.Questionnaire;
import jp.ac.dendai.sie.usd.domain.model.Subject;
import jp.ac.dendai.sie.usd.infrastructure.db.memory.MemoryQuestionnaireSingleton;
import jp.ac.dendai.sie.usd.student.usecase.repository.QuestionnaireRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by guest1 on 2018/10/28.
 */
public class MemoryQuestionnaireRepositoryImp implements QuestionnaireRepository {
    MemoryQuestionnaireSingleton memoryQuestionnaireSingleton = MemoryQuestionnaireSingleton.getInstance();

    @Override
    public Optional<Questionnaire> findByQuestionnaireId(Long questionnaireId) {
        return memoryQuestionnaireSingleton.getQuestionnaireList().stream().filter(questionnaire -> questionnaire.getQuestionnaireId().equals(questionnaireId)).findFirst();

    }

    @Override
    public List<Questionnaire> findAnyBySubjectId(Long subjectId) {
        return memoryQuestionnaireSingleton.getQuestionnaireList().stream().filter(questionnaire -> questionnaire.getSubjectId().equals(subjectId)).collect(Collectors.toList());
    }

    @Override
    public List<Questionnaire> findAnyByStudentId(String studentId) {
        List<Subject> subjectList = new MemorySubjectRepositoryImp().findAnyByStudentId(studentId);
        return subjectList.stream().map(subject -> findAnyBySubjectId(subject.getSubjectId())).flatMap(Collection::stream).collect(Collectors.toList());
    }
}
