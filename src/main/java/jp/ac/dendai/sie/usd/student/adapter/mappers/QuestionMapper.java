package jp.ac.dendai.sie.usd.student.adapter.mappers;

import jp.ac.dendai.sie.usd.domain.model.Question;
import jp.ac.dendai.sie.usd.student.model.response.QuestionRes;

/**
 * Created by guest1 on 2018/10/25.
 */
public interface QuestionMapper {
    QuestionRes toRes(Question question);
}
