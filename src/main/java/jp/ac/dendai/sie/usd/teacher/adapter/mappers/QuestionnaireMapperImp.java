package jp.ac.dendai.sie.usd.teacher.adapter.mappers;

import jp.ac.dendai.sie.usd.domain.model.Questionnaire;
import jp.ac.dendai.sie.usd.domain.model.Result;
import jp.ac.dendai.sie.usd.domain.model.Subject;
import jp.ac.dendai.sie.usd.teacher.model.request.QuestionnaireReq;
import jp.ac.dendai.sie.usd.teacher.model.response.QuestionRes;
import jp.ac.dendai.sie.usd.teacher.model.response.QuestionnaireRes;
import jp.ac.dendai.sie.usd.teacher.model.response.SubjectInformationRes;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by guest1 on 2018/10/26.
 */
public class QuestionnaireMapperImp implements QuestionnaireMapper {
    @Override
    public Questionnaire toDomain(Long subjectId, QuestionnaireReq questionnaireReq) {
        return new Questionnaire(
                null,
                questionnaireReq.getQuestionnaireTitle(),
                subjectId,
                TimeGetter.getNowTime(),
                false
        );
    }

    @Override
    public QuestionnaireRes toRes(Questionnaire questionnaire, Subject subject, List<QuestionRes> questionResList) {
        return new QuestionnaireRes(
                questionnaire.getQuestionnaireId(),
                questionnaire.getQuestionnaireTitle(),
                new SubjectInformationRes(
                        subject.getSubjectId(),
                        subject.getSubjectTitle(),
                        new UserInformationMapperImp().toRes(subject.getTeacher())
                ),
                questionResList,
                questionnaire.getCreateTime(),
                questionnaire.getRelease()
        );
    }
}
