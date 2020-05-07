package jp.ac.dendai.sie.usd.mytest;

import jp.ac.dendai.sie.usd.domain.model.Questionnaire;

import java.util.ArrayList;
import java.util.List;


public class QuestionnaireListRepository {
    private List<Questionnaire> questionnaireList = new ArrayList<>();
    private List<Questionnaire> demoList = new ArrayList<>();
    public void addQuestionnaire(Questionnaire questionnaire) {
        this.questionnaireList.add(questionnaire);
    }

    public List<Questionnaire> getQuestionnaireList() {
        return this.questionnaireList;
    }

    public void addDemo(Questionnaire questionnaire) {
        this.demoList.add(questionnaire);
    }

    public List<Questionnaire> getDemoList() {
        return this.demoList;
    }
}
