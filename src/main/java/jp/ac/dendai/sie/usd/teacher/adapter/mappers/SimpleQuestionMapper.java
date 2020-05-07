package jp.ac.dendai.sie.usd.teacher.adapter.mappers;

import jp.ac.dendai.sie.usd.domain.model.SimpleQuestion;
import jp.ac.dendai.sie.usd.teacher.model.request.SimpleQuestionReq;
import jp.ac.dendai.sie.usd.teacher.model.response.SimpleQuestionRes;

public interface SimpleQuestionMapper {
    SimpleQuestion toDomain(Long questionnaireId, SimpleQuestionReq simpleQuestionReq);
    SimpleQuestionRes toRes(SimpleQuestion simpleQuestion);
}