package jp.ac.dendai.sie.usd.student.adapter.presenters;

import jp.ac.dendai.sie.usd.domain.model.Question;
import jp.ac.dendai.sie.usd.domain.model.Questionnaire;
import jp.ac.dendai.sie.usd.domain.model.Result;
import jp.ac.dendai.sie.usd.domain.model.Subject;
import jp.ac.dendai.sie.usd.student.adapter.mappers.QuestionMapper;
import jp.ac.dendai.sie.usd.student.adapter.mappers.QuestionnaireMapper;
import jp.ac.dendai.sie.usd.student.adapter.mappers.SubjectMapper;
import jp.ac.dendai.sie.usd.student.model.response.QuestionRes;
import jp.ac.dendai.sie.usd.student.model.response.QuestionnaireRes;
import jp.ac.dendai.sie.usd.student.model.response.SubjectRes;
import jp.ac.dendai.sie.usd.student.usecase.presenter.SubjectPresenter;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SubjectPresenterImp implements SubjectPresenter {
    @Inject
    SubjectMapper subjectMapper;

    @Inject
    QuestionnaireMapper questionnaireMapper;

    @Inject
    QuestionMapper questionMapper;

    @Override
    public List<SubjectRes> toSubjectRes(List<Subject> subjectList, List<Questionnaire> questionnaireList, List<Question> questionList, List<Result> resultList) {
        //todo refactor
        //key:subjectId
        Map<Long, List<Questionnaire>> questionnaireListMap = questionnaireList.stream().collect(Collectors.groupingBy(Questionnaire::getSubjectId));
        //key:questionnaireId
        Map<Long, List<Question>> questionListMap = questionList.stream().collect(Collectors.groupingBy(Question::getQuestionnaireId));
        List<SubjectRes> subjectResList = new ArrayList<>();


        for (Subject subject : subjectList) {
            List<QuestionnaireRes> questionnaireResList = new ArrayList<>();
            List<Questionnaire> questionnaireList1 = questionnaireListMap.get(subject.getSubjectId());
            if(questionnaireList1 == null ) {
                questionnaireList1 = new ArrayList<>();
            }
            for (Questionnaire questionnaire : questionnaireList1) {

                System.out.println(questionnaireList1);
                List<Question> qList = questionListMap
                        .get(questionnaire.getQuestionnaireId());
                if(qList == null) {
                    qList = new ArrayList<>();
                }
                List<QuestionRes> questionResList = qList.stream()
                        .map(question -> questionMapper.toRes(question))
                        .collect(Collectors.toList());
                List<Result> resultList1 = resultList.stream().filter(result -> questionnaire.getQuestionnaireId().equals(result.getQuestionnaireId())).collect(Collectors.toList());
                questionnaireResList.add(questionnaireMapper.toRes(questionnaire, subject, questionResList, resultList1));
            }
            subjectResList.add(subjectMapper.toRes(subject, questionnaireResList));
        }
        return subjectResList;
    }

    @Override
    public SubjectRes toSubjectRes(Subject subject, List<Questionnaire> questionnaireList, List<Question> questionList, List<Result> resultList) {
        //todo refactor
        List<QuestionnaireRes> questionnaireResList = new ArrayList<>();
        Map<Long, List<Question>> questionListMap = questionList.stream().collect(Collectors.groupingBy(Question::getQuestionnaireId));
        for (Questionnaire questionnaire : questionnaireList) {
            List<QuestionRes> questionResList = questionListMap.get(questionnaire.getQuestionnaireId()).stream().map(question -> questionMapper.toRes(question)).collect(Collectors.toList());
            List<Result> resultList1 = resultList.stream().filter(result -> questionnaire.getQuestionnaireId().equals(result.getQuestionnaireId())).collect(Collectors.toList());
            questionnaireResList.add(questionnaireMapper.toRes(questionnaire, subject, questionResList, resultList1));
        }
        return subjectMapper.toRes(subject, questionnaireResList);
    }
}
