package jp.ac.dendai.sie.usd.teacher.adapter.mappers;

import jp.ac.dendai.sie.usd.domain.model.Subject;
import jp.ac.dendai.sie.usd.teacher.model.request.SubjectReq;
import jp.ac.dendai.sie.usd.teacher.model.request.UserInformationReq;
import jp.ac.dendai.sie.usd.teacher.model.response.QuestionnaireRes;
import jp.ac.dendai.sie.usd.teacher.model.response.SubjectRes;
import jp.ac.dendai.sie.usd.teacher.model.response.UserInformationRes;

import java.util.List;

public class SubjectMapperImp implements SubjectMapper {

    @Override
    public Subject toDomain(SubjectReq subjectReq, UserInformationReq teacher) {
        return new Subject(
                null,
                subjectReq.getSubjectTitle(),
                new UserInformationMapperImp().toDomain(teacher)
        );
    }

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
