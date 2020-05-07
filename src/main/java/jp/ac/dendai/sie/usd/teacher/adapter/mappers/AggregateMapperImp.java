package jp.ac.dendai.sie.usd.teacher.adapter.mappers;

import jp.ac.dendai.sie.usd.teacher.model.response.AggregateRes;
import jp.ac.dendai.sie.usd.teacher.model.response.AnswerRes;
import jp.ac.dendai.sie.usd.teacher.model.response.QuestionnaireRes;

import java.util.List;

public class AggregateMapperImp implements AggregateMapper {
    @Override
    public AggregateRes toRes(QuestionnaireRes questionnaireRes, List<AnswerRes> answerResList, Long courseNumber) {
        return new AggregateRes(
//                questionnaireRes,
//                answerResList,
//                courseNumber
        );
    }
}
