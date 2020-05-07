package jp.ac.dendai.sie.usd.student.adapter.controllers;

import jp.ac.dendai.sie.usd.student.model.request.ResultReq;
import jp.ac.dendai.sie.usd.student.model.request.UserInformationReq;
import jp.ac.dendai.sie.usd.student.model.response.ResultRes;

import java.util.List;

/**
 * Created by guest1 on 2018/10/26.
 */
public interface ResultController {
    Long createResult(Long subjectId, Long questionnaireId, ResultReq resultReq, UserInformationReq userInformationReq);
    List<ResultRes> getResultList(Long subjectId, Long questionnaireId, UserInformationReq userInformationReq);
    ResultRes getResult(Long subjectId, Long questionnaireId, Long resultId, UserInformationReq userInformationReq);
}
