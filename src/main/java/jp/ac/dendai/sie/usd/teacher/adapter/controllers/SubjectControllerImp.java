package jp.ac.dendai.sie.usd.teacher.adapter.controllers;

import jp.ac.dendai.sie.usd.teacher.adapter.mappers.SubjectMapper;
import jp.ac.dendai.sie.usd.teacher.model.request.SubjectReq;
import jp.ac.dendai.sie.usd.teacher.model.request.UserInformationReq;
import jp.ac.dendai.sie.usd.teacher.model.response.SubjectRes;
import jp.ac.dendai.sie.usd.teacher.adapter.mappers.UserInformationMapper;
import jp.ac.dendai.sie.usd.teacher.model.response.UserInformationRes;
import jp.ac.dendai.sie.usd.teacher.usecase.service.CreateSubjectService;
import jp.ac.dendai.sie.usd.teacher.usecase.service.DeleteSubjectService;
import jp.ac.dendai.sie.usd.teacher.usecase.service.GetStudentService;
import jp.ac.dendai.sie.usd.teacher.usecase.service.GetSubjectService;

import javax.inject.Inject;
import java.util.List;

public class SubjectControllerImp implements SubjectController {
    @Inject
    GetSubjectService getSubjectService;

    @Inject
    CreateSubjectService createSubjectService;
    //Mapper
    @Inject
    SubjectMapper subjectMapper;

    @Inject
    DeleteSubjectService deleteSubjectService;

    @Inject
    GetStudentService getStudentService;

    @Inject
    UserInformationMapper userInformationMapper;

    @Override
    public Long createSubject(SubjectReq subjectReq, UserInformationReq userInformationReq) {
        return createSubjectService.insert(subjectMapper.toDomain(subjectReq, userInformationReq));
    }

    @Override
    public List<SubjectRes> getSubjectList(UserInformationReq userInformationReq) {
        return getSubjectService.getSubjectList(userInformationMapper.toDomain(userInformationReq));
    }

    @Override
    public SubjectRes getSubject(Long subjectId, UserInformationReq userInformationReq) {
        return getSubjectService.getSubject(subjectId, userInformationMapper.toDomain(userInformationReq));
    }

    @Override
    public void delete(Long subjectId) {
        deleteSubjectService.delete(subjectId);
    }

    @Override
    public List<UserInformationRes> getStudentList(Long subjectId, UserInformationReq userInformationReq) {
        return getStudentService.getStudentList(subjectId);
    }

}
