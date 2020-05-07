package jp.ac.dendai.sie.usd.teacher.usecase.service;

import jp.ac.dendai.sie.usd.domain.model.SimpleQuestion;

public interface CreateSimpleQuestionService {
    Long insert(SimpleQuestion simpleQuestion);
}
