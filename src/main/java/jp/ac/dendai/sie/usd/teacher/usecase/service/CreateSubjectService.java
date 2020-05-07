package jp.ac.dendai.sie.usd.teacher.usecase.service;

import jp.ac.dendai.sie.usd.domain.model.Subject;

public interface CreateSubjectService {
    Long insert(Subject subject);
}
