package jp.ac.dendai.sie.usd.student.adapter.mappers;

import jp.ac.dendai.sie.usd.domain.model.Result;
import jp.ac.dendai.sie.usd.student.model.request.UserInformationReq;
import jp.ac.dendai.sie.usd.student.model.response.AnswerRes;
import jp.ac.dendai.sie.usd.student.model.response.QuestionnaireRes;
import jp.ac.dendai.sie.usd.student.model.response.ResultRes;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by guest1 on 2018/10/26.
 */
public class ResultMapperImp implements ResultMapper {

    @Override
    public Result toDomain(Long questionnaireId, UserInformationReq userInformationReq) {
        return new Result(null, questionnaireId, new UserInformationMapperImp().toDomain(userInformationReq), TimeGetter.getNowTime());
    }

    @Override
    public ResultRes toRes(Result result, QuestionnaireRes questionnaireRes, List<AnswerRes> answerResList) {
        return new ResultRes(
                result.getResultId(),
                questionnaireRes,
                new UserInformationMapperImp().toRes(result.getStudent()),
                answerResList,
                result.getResponseTime()
        );
    }
}
