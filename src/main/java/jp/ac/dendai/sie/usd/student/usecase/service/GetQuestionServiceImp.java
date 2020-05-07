package jp.ac.dendai.sie.usd.student.usecase.service;

import jp.ac.dendai.sie.usd.student.usecase.repository.QuestionRepository;

import javax.inject.Inject;

/**
 * Created by guest1 on 2018/10/25.
 */
public class GetQuestionServiceImp{
//    implements getQuestionService

    @Inject
    QuestionRepository questionRepository;

//    @Override
//    public List<QuestionRes> getQuestionList(Long questionnaireId) {
//        List<Question> questionList = questionRepository.findAnyByQuestionnaireIdAndStudentId(questionnaireId);
//        return null;
//    }
//
//    @Override
//    public QuestionRes getQuestion(Long questionId) {
//        Question question = questionRepository.findByQuestionId(questionId)
//                .orElseThrow(() -> new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity("指定したquestionIdが存在しません.").build()));
//        return null;
//    }
}
