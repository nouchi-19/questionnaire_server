package jp.ac.dendai.sie.usd.student.adapter.mappers;

import jp.ac.dendai.sie.usd.student.model.response.AggregateRes;
import jp.ac.dendai.sie.usd.student.model.response.AnswerRes;
import jp.ac.dendai.sie.usd.student.model.response.QuestionnaireRes;

import java.util.List;

public interface AggregateMapper {
    AggregateRes toRes(QuestionnaireRes questionnaireRes, List<AnswerRes> answerList, Long courseNumber);
}
