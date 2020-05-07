package jp.ac.dendai.sie.usd.student.adapter.mappers;

import jp.ac.dendai.sie.usd.domain.model.Subject;
import jp.ac.dendai.sie.usd.student.model.response.QuestionnaireRes;
import jp.ac.dendai.sie.usd.student.model.response.SubjectRes;

import java.util.List;

/**
 * Created by guest1 on 2018/10/25.
 */
public interface SubjectMapper {
    SubjectRes toRes(Subject subject, List<QuestionnaireRes> questionnaireResList);
}
