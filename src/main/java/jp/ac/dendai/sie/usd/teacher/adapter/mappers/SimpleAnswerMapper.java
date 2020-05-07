package jp.ac.dendai.sie.usd.teacher.adapter.mappers;

import jp.ac.dendai.sie.usd.domain.model.SimpleAnswer;
import jp.ac.dendai.sie.usd.teacher.model.response.SimpleAnswerRes;
import jp.ac.dendai.sie.usd.teacher.model.response.SimpleQuestionRes;

public interface SimpleAnswerMapper {
    SimpleAnswerRes toRes(SimpleAnswer simpleAnswer, SimpleQuestionRes simpleQuestionRes);

}
