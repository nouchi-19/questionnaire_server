package jp.ac.dendai.sie.usd.student.adapter.controllers;

import jp.ac.dendai.sie.usd.student.adapter.mappers.UserInformationMapper;
import jp.ac.dendai.sie.usd.student.model.request.UserInformationReq;
import jp.ac.dendai.sie.usd.student.model.response.SubjectRes;
import jp.ac.dendai.sie.usd.student.usecase.service.GetSubjectService;
import jp.ac.dendai.sie.usd.student.usecase.service.RegistrationSubjectService;

import javax.inject.Inject;
import java.util.List;

public class SubjectControllerImp implements SubjectController {
    @Inject
    GetSubjectService getSubjectService;

    @Inject
    RegistrationSubjectService registrationSubjectService;

    //Mapper
    @Inject
    UserInformationMapper userInformationMapper;

    @Override
    public void registrationSubject(Long subjectId, UserInformationReq userInformationReq) {
        registrationSubjectService.registrationSubject(subjectId, userInformationMapper.toDomain(userInformationReq));
    }
    @Override
    public List<SubjectRes> getSubjectList(UserInformationReq userInformationReq) {
        return getSubjectService.getSubjectList(userInformationMapper.toDomain(userInformationReq));
    }

    @Override
    public SubjectRes getSubject(Long subjectId, UserInformationReq userInformationReq) {
        return getSubjectService.getSubject(subjectId, userInformationMapper.toDomain(userInformationReq));
    }
}
