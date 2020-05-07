package jp.ac.dendai.sie.usd.student.adapter.mappers;

import jp.ac.dendai.sie.usd.domain.model.Questionnaire;
import jp.ac.dendai.sie.usd.domain.model.Result;
import jp.ac.dendai.sie.usd.domain.model.Subject;
import jp.ac.dendai.sie.usd.student.model.response.QuestionRes;
import jp.ac.dendai.sie.usd.student.model.response.QuestionnaireRes;

import java.util.List;

/**
 * Created by guest1 on 2018/10/25.
 */
public interface QuestionnaireMapper {
    QuestionnaireRes toRes(Questionnaire questionnaire, Subject subject, List<QuestionRes> questionResList, List<Result> resultList);
}