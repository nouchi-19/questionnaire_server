package jp.ac.dendai.sie.usd.student.usecase.service;

import jp.ac.dendai.sie.usd.domain.model.Subject;
import jp.ac.dendai.sie.usd.domain.model.User;
import jp.ac.dendai.sie.usd.student.model.response.SubjectRes;

import java.util.List;

public interface GetSubjectService {
    List<SubjectRes> getSubjectList(User student);

    SubjectRes getSubject(Long subjectId, User student);

    Subject tryGet(Long subjectId, User student);
}
