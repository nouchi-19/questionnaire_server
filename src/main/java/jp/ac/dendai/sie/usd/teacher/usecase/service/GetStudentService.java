package jp.ac.dendai.sie.usd.teacher.usecase.service;

import jp.ac.dendai.sie.usd.teacher.model.response.UserInformationRes;

import java.util.List;

public interface GetStudentService {
    List<UserInformationRes> getStudentList(Long subjectId);
}
