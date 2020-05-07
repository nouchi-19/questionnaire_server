package jp.ac.dendai.sie.usd.student.usecase.service;

import jp.ac.dendai.sie.usd.domain.model.User;
import jp.ac.dendai.sie.usd.student.model.response.SimpleQuestionRes;

import java.util.List;

public interface GetSimpleQuestionService {
    List<SimpleQuestionRes> getSimpleQuestionListNoAnswer(Long subjectId, User student, Boolean answered);
    List<SimpleQuestionRes> getSimpleQuestionList(Long questionnaireId);
}
