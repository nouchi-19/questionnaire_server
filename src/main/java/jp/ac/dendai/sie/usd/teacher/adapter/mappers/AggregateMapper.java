package jp.ac.dendai.sie.usd.teacher.adapter.mappers;

import jp.ac.dendai.sie.usd.teacher.model.response.AggregateRes;
import jp.ac.dendai.sie.usd.teacher.model.response.AnswerRes;
import jp.ac.dendai.sie.usd.teacher.model.response.QuestionnaireRes;

import java.util.List;

public interface AggregateMapper {
    AggregateRes toRes(QuestionnaireRes questionnaireRes, List<AnswerRes> answerList, Long courseNumber);
}
