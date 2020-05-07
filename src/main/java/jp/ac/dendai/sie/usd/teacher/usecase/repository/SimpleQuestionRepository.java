package jp.ac.dendai.sie.usd.teacher.usecase.repository;


import jp.ac.dendai.sie.usd.domain.model.SimpleQuestion;

import java.util.List;

public interface SimpleQuestionRepository {
    Long insert(SimpleQuestion simpleQuestion);
    List<SimpleQuestion> findAnyByQuestionnaireId(Long questionnaireId);
}
