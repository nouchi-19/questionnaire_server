package jp.ac.dendai.sie.usd.student.usecase.service;

import jp.ac.dendai.sie.usd.domain.model.User;

/**
 * Created by guest1 on 2018/10/25.
 */
public interface CheckSubjectService {
    Boolean checkSubject(Long subjectId, User student);
}
