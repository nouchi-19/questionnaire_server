package jp.ac.dendai.sie.usd.student.adapter.mappers;

import jp.ac.dendai.sie.usd.domain.model.Result;
import jp.ac.dendai.sie.usd.student.model.request.UserInformationReq;
import jp.ac.dendai.sie.usd.student.model.response.AnswerRes;
import jp.ac.dendai.sie.usd.student.model.response.QuestionnaireRes;
import jp.ac.dendai.sie.usd.student.model.response.ResultRes;

import java.util.List;

/**
 * Created by guest1 on 2018/10/26.
 */
public interface ResultMapper {
    Result toDomain(Long questionnaireId, UserInformationReq userInformationReq);
    ResultRes toRes(Result result, QuestionnaireRes questionnaireRes, List<AnswerRes> answerResList);
}
