package jp.ac.dendai.sie.usd.teacher.adapter.controllers;

import jp.ac.dendai.sie.usd.teacher.model.request.UserInformationReq;
import jp.ac.dendai.sie.usd.teacher.model.response.ResultRes;

import java.util.List;

/**
 * Created by guest1 on 2018/10/26.
 */
public interface ResultController {
    List<ResultRes> getResultList(Long subjectId, Long questionnaireId, UserInformationReq userInformationReq);
    ResultRes getResult(Long subjectId, Long questionnaireId, Long resultId, UserInformationReq userInformationReq);
}
