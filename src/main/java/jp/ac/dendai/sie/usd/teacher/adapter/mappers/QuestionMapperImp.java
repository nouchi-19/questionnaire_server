package jp.ac.dendai.sie.usd.teacher.adapter.mappers;

import jp.ac.dendai.sie.usd.domain.model.Question;
import jp.ac.dendai.sie.usd.domain.model.QuestionType;
import jp.ac.dendai.sie.usd.teacher.model.request.QuestionReq;
import jp.ac.dendai.sie.usd.teacher.model.response.QuestionRes;

/**
 * Created by guest1 on 2018/10/26.
 */
public class QuestionMapperImp implements QuestionMapper {

    @Override
    public Question toDomain(QuestionReq questionReq) {
        return new Question(
                null,
                questionReq.getQuestionNumber(),
                questionReq.getQuestionTitle(),
                questionReq.getRequired(),
                QuestionType.valueOf(questionReq.getQuestionType().name()),
                questionReq.getOptionList(),
                null
        );
//        private Long questionId;
//        private Long questionNumber;
//        private String questionTitle;
//        private Boolean required;
//        private QuestionType questionType;
//        private List<String> optionList;
//        private Long questionnaireId;
    }

    @Override
    public QuestionRes toRes(Question question) {
        return new QuestionRes(
                question.getQuestionId(),
                question.getQuestionNumber(),
                question.getQuestionTitle(),
                question.getRequired(),
                question.getQuestionType().toString(),
                question.getOptionList()
        );
    }
}
