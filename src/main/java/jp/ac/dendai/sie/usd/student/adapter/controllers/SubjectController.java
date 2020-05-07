package jp.ac.dendai.sie.usd.student.adapter.controllers;

import jp.ac.dendai.sie.usd.student.model.request.UserInformationReq;
import jp.ac.dendai.sie.usd.student.model.response.SubjectRes;

import java.util.List;

public interface SubjectController {

    void registrationSubject(Long subjectId, UserInformationReq userInformationReq);

    List<SubjectRes> getSubjectList(UserInformationReq userInformationReq);

    SubjectRes getSubject(Long subjectId, UserInformationReq userInformationReq);
}
