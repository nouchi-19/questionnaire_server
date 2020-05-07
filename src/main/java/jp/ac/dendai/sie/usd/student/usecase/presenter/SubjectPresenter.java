package jp.ac.dendai.sie.usd.student.usecase.presenter;

import jp.ac.dendai.sie.usd.domain.model.Question;
import jp.ac.dendai.sie.usd.domain.model.Questionnaire;
import jp.ac.dendai.sie.usd.domain.model.Result;
import jp.ac.dendai.sie.usd.domain.model.Subject;
import jp.ac.dendai.sie.usd.student.model.response.SubjectRes;

import java.util.List;

public interface SubjectPresenter {
    List<SubjectRes> toSubjectRes(List<Subject> subjectList, List<Questionnaire> questionnaireList, List<Question> questionList, List<Result> resultList);
    SubjectRes toSubjectRes(Subject subject, List<Questionnaire> questionnaireList, List<Question> questionList, List<Result> resultList);

}