package jp.ac.dendai.sie.usd.student.usecase.service;

import jp.ac.dendai.sie.usd.domain.model.SimpleAnswer;
import jp.ac.dendai.sie.usd.domain.model.User;
import jp.ac.dendai.sie.usd.student.model.response.SimpleAnswerRes;

import java.util.List;

public interface GetSimpleAnswerService {
    List<SimpleAnswerRes> getSimpleAnswerList(Long questionnaireId, User student);
}
