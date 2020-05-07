package jp.ac.dendai.sie.usd.student.adapter.mappers;

import jp.ac.dendai.sie.usd.domain.model.SimpleQuestion;
import jp.ac.dendai.sie.usd.student.model.response.SimpleQuestionRes;

public interface SimpleQuestionMapper {
    SimpleQuestionRes toRes(SimpleQuestion simpleQuestion);
}