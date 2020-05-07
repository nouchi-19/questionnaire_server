package jp.ac.dendai.sie.usd.student.adapter.mappers;

import jp.ac.dendai.sie.usd.domain.model.Questionnaire;
import jp.ac.dendai.sie.usd.domain.model.Result;
import jp.ac.dendai.sie.usd.domain.model.Subject;
import jp.ac.dendai.sie.usd.student.model.response.QuestionRes;
import jp.ac.dendai.sie.usd.student.model.response.QuestionnaireRes;
import jp.ac.dendai.sie.usd.student.model.response.SubjectInformationRes;

import java.util.List;

/**
 * Created by guest1 on 2018/10/26.
 */
public class QuestionnaireMapperImp implements QuestionnaireMapper{
    @Override
    public QuestionnaireRes toRes(Questionnaire questionnaire, Subject subject, List<QuestionRes> questionResList, List<Result> resultList) {
        Boolean submission = false;
        Integer size = resultList.size();
        if(!size.equals(0)) {
            submission = true;
        }
        return new QuestionnaireRes(
                questionnaire.getQuestionnaireId(),
                questionnaire.getQuestionnaireTitle(),
                new SubjectInformationRes(
                        subject.getSubjectId(),
                        subject.getSubjectTitle(),
                        new UserInformationMapperImp().toRes(subject.getTeacher())
                ),
                submission,
                questionResList,
                questionnaire.getCreateTime()
        );
    }
}
