package jp.ac.dendai.sie.usd.student.adapter.mappers;

import jp.ac.dendai.sie.usd.domain.model.Answer;
import jp.ac.dendai.sie.usd.student.model.request.AnswerReq;
import jp.ac.dendai.sie.usd.student.model.response.AnswerRes;
import jp.ac.dendai.sie.usd.student.model.response.QuestionRes;

/**
 * Created by guest1 on 2018/10/26.
 */
public class AnswerMapperImp implements AnswerMapper{

    @Override
    public Answer toDomain(AnswerReq answerReq) {
        return new Answer(null, answerReq.getQuestionId(), answerReq.getResponseList(), null);
    }

    @Override
    public AnswerRes toRes(Answer answer, QuestionRes questionRes) {
        return new AnswerRes(answer.getAnswerId(),
                questionRes,
                answer.getResponseList()
        );
    }
}
