package jp.ac.dendai.sie.usd.teacher.adapter.mappers;

import jp.ac.dendai.sie.usd.domain.model.Answer;
import jp.ac.dendai.sie.usd.teacher.model.response.AnswerRes;
import jp.ac.dendai.sie.usd.teacher.model.response.QuestionRes;

public interface AnswerMapper {
//    Answer toDomain(AnswerReq answerReq);
    AnswerRes toRes(Answer answer, QuestionRes questionRes);
}
