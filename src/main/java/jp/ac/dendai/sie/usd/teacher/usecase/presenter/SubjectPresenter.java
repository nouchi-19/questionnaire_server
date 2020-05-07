package jp.ac.dendai.sie.usd.teacher.usecase.presenter;

import jp.ac.dendai.sie.usd.domain.model.Question;
import jp.ac.dendai.sie.usd.domain.model.Questionnaire;
import jp.ac.dendai.sie.usd.domain.model.Result;
import jp.ac.dendai.sie.usd.domain.model.Subject;
import jp.ac.dendai.sie.usd.teacher.model.response.SubjectRes;

import java.util.List;

public interface SubjectPresenter {
    List<SubjectRes> toSubjectRes(List<Subject> subjectList, List<Questionnaire> questionnaireList, List<Question> questionList);
    SubjectRes toSubjectRes(Subject subject, List<Questionnaire> questionnaireList, List<Question> questionList);

}