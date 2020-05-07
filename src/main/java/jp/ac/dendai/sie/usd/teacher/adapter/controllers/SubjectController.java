package jp.ac.dendai.sie.usd.teacher.adapter.controllers;

import jp.ac.dendai.sie.usd.teacher.model.request.SubjectReq;
import jp.ac.dendai.sie.usd.teacher.model.request.UserInformationReq;
import jp.ac.dendai.sie.usd.teacher.model.response.SubjectRes;
import jp.ac.dendai.sie.usd.teacher.model.response.UserInformationRes;

import java.util.List;

public interface SubjectController {
    Long createSubject(SubjectReq subjectReq, UserInformationReq userInformationReq);

    List<SubjectRes> getSubjectList(UserInformationReq userInformationReq);

    SubjectRes getSubject(Long subjectId, UserInformationReq userInformationReq);

    void delete(Long subjectId);

    List<UserInformationRes> getStudentList(Long subjectId, UserInformationReq userInformationReq);
}
