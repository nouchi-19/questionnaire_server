package jp.ac.dendai.sie.usd.student.adapter.mappers;

import jp.ac.dendai.sie.usd.domain.model.Subject;
import jp.ac.dendai.sie.usd.student.model.response.QuestionnaireRes;
import jp.ac.dendai.sie.usd.student.model.response.SubjectRes;

import java.util.List;

public class SubjectMapperImp implements SubjectMapper{

    @Override
    public SubjectRes toRes(Subject subject, List<QuestionnaireRes> questionnaireResList) {
        return new SubjectRes(
                subject.getSubjectId(),
                subject.getSubjectTitle(),
                questionnaireResList,
                new UserInformationMapperImp().toRes(subject.getTeacher())
        );
    }
}
