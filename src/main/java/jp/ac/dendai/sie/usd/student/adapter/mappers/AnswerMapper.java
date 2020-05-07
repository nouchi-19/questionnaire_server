package jp.ac.dendai.sie.usd.student.adapter.mappers;

import jp.ac.dendai.sie.usd.domain.model.Answer;
import jp.ac.dendai.sie.usd.student.model.request.AnswerReq;
import jp.ac.dendai.sie.usd.student.model.response.AnswerRes;
import jp.ac.dendai.sie.usd.student.model.response.QuestionRes;
public interface AnswerMapper {
    Answer toDomain(AnswerReq answerReq);
    AnswerRes toRes(Answer answer, QuestionRes questionRes);
}
