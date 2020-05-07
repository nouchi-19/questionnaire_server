package jp.ac.dendai.sie.usd.teacher.usecase.service;

import jp.ac.dendai.sie.usd.teacher.model.response.UserInformationRes;
import jp.ac.dendai.sie.usd.teacher.usecase.presenter.UserInformationPresenter;
import jp.ac.dendai.sie.usd.teacher.usecase.repository.SubjectRepository;

import javax.inject.Inject;
import java.util.List;

public class GetStudentServiceImp implements GetStudentService{

    @Inject
    UserInformationPresenter userInformationPresenter;

    @Inject
    SubjectRepository subjectRepository;

    @Override
    public List<UserInformationRes> getStudentList(Long subjectId) {
        return userInformationPresenter.toUserInformationRes(subjectRepository.findAnyByUser(subjectId));
    }
}
