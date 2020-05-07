package jp.ac.dendai.sie.usd.teacher.usecase.service;

import jp.ac.dendai.sie.usd.teacher.model.response.SimpleQuestionRes;

import java.util.List;

public interface GetSimpleQuestionService {
    List<SimpleQuestionRes> getSimpleQuestionList(Long questionnaireId);
}
