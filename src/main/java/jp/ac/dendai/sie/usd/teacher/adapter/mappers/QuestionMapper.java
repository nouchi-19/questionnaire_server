package jp.ac.dendai.sie.usd.teacher.adapter.mappers;

import jp.ac.dendai.sie.usd.domain.model.Question;
import jp.ac.dendai.sie.usd.teacher.model.request.QuestionReq;
import jp.ac.dendai.sie.usd.teacher.model.response.QuestionRes;

/**
 * Created by guest1 on 2018/10/25.
 */
public interface QuestionMapper {
    Question toDomain(QuestionReq questionReq);
    QuestionRes toRes(Question question);
}
