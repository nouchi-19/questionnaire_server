package jp.ac.dendai.sie.usd.teacher.adapter.mappers;

import jp.ac.dendai.sie.usd.domain.model.Subject;
import jp.ac.dendai.sie.usd.teacher.model.request.SubjectReq;
import jp.ac.dendai.sie.usd.teacher.model.request.UserInformationReq;
import jp.ac.dendai.sie.usd.teacher.model.response.QuestionnaireRes;
import jp.ac.dendai.sie.usd.teacher.model.response.SubjectRes;

import java.util.List;

/**
 * Created by guest1 on 2018/10/25.
 */
public interface SubjectMapper {
    Subject toDomain(SubjectReq subjectReq, UserInformationReq teacher);
    SubjectRes toRes(Subject subject, List<QuestionnaireRes> questionnaireResList);
}
