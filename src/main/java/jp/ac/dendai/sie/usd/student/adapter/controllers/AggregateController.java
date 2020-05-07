package jp.ac.dendai.sie.usd.student.adapter.controllers;

import jp.ac.dendai.sie.usd.student.model.request.UserInformationReq;
import jp.ac.dendai.sie.usd.student.model.response.AggregateRes;

public interface AggregateController {
    AggregateRes  getAggregate(Long subjectId, Long questionnaireId, UserInformationReq userInformationReq);
}
