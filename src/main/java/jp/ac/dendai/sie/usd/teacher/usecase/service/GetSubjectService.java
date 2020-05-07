package jp.ac.dendai.sie.usd.teacher.usecase.service;

import jp.ac.dendai.sie.usd.domain.model.Subject;
import jp.ac.dendai.sie.usd.domain.model.User;
import jp.ac.dendai.sie.usd.teacher.model.response.SubjectRes;

import java.util.List;

public interface GetSubjectService {
    List<SubjectRes> getSubjectList(User teacher);

    SubjectRes getSubject(Long subjectId, User teacher);

    Subject tryGet(Long subjectId, User teacjer);
}
