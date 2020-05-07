package jp.ac.dendai.sie.usd.teacher;


import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import jp.ac.dendai.sie.usd.filter.CORSResponseFilter;
import jp.ac.dendai.sie.usd.filter.ConstraintViolationExceptionMapper;
import jp.ac.dendai.sie.usd.filter.JacksonConfigurator;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.entity.MongoSimpleQuestion;
import jp.ac.dendai.sie.usd.teacher.infrastructure.repository.db.mongo.*;
import jp.ac.dendai.sie.usd.teacher.adapter.controllers.*;
import jp.ac.dendai.sie.usd.teacher.adapter.mappers.*;
import jp.ac.dendai.sie.usd.teacher.adapter.presenters.*;
import jp.ac.dendai.sie.usd.teacher.usecase.presenter.*;
import jp.ac.dendai.sie.usd.teacher.usecase.repository.*;
import jp.ac.dendai.sie.usd.teacher.usecase.service.*;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("teacher/api")
public class TeacherApiConfig extends ResourceConfig {
    public TeacherApiConfig() {
        packages(this.getClass().getPackage().getName())
                .register(ConstraintViolationExceptionMapper.class)
                .register(CORSResponseFilter.class)
                .register(JacksonConfigurator.class)
                .register(JacksonJsonProvider.class)
                .register(new AbstractBinder() {
                    @Override
                    protected void configure() {
                        bind(SubjectControllerImp.class).to(SubjectController.class);
                        bind(QuestionnaireControllerImp.class).to(QuestionnaireController.class);
                        bind(ResultControllerImp.class).to(ResultController.class);
//                        bind(AggregateControllerImp.class).to(AggregateController.class);
                        bind(SimpleQuestionControllerImp.class).to(SimpleQuestionController.class);
                        bind(SimpleAnswerControllerImp.class).to(SimpleAnswerController.class);

                        //Presenters
                        bind(SubjectPresenterImp.class).to(SubjectPresenter.class);
                        bind(QuestionnairePresenterImp.class).to(QuestionnairePresenter.class);
                        bind(ResultPresenterImp.class).to(ResultPresenter.class);
                        bind(SimpleQuestionPresenterImp.class).to(SimpleQuestionPresenter.class);
                        bind(SimpleAnswerPresenterImp.class).to(SimpleAnswerPresenter.class);
                        bind(UserInformationPresenterImp.class).to(UserInformationPresenter.class);

                        //Mappers
                        bind(UserInformationMapperImp.class).to(UserInformationMapper.class);
                        bind(SubjectMapperImp.class).to(SubjectMapper.class);
                        bind(QuestionnaireMapperImp.class).to(QuestionnaireMapper.class);
                        bind(QuestionMapperImp.class).to(QuestionMapper.class);
                        bind(ResultMapperImp.class).to(ResultMapper.class);
                        bind(AnswerMapperImp.class).to(AnswerMapper.class);
                        bind(SimpleQuestionMapperImp.class).to(SimpleQuestionMapper.class);
                        bind(SimpleAnswerMapperImp.class).to(SimpleAnswerMapper.class);

                        //Service
                        bind(MongoSetUpServiceImp.class).to(SetUpService.class);

                        bind(CreateSubjectServiceImp.class).to(CreateSubjectService.class);
                        bind(CreateQuestionnaireServiceImp.class).to(CreateQuestionnaireService.class);
                        bind(GetSubjectServiceImp.class).to(GetSubjectService.class);
                        bind(GetQuestionnaireServiceImp.class).to(GetQuestionnaireService.class);
                        bind(GetResultServiceImp.class).to(GetResultService.class);
//                        bind(GetAggregateServiceImp.class).to(GetAggregateService.class);
                        bind(GetSimpleQuestionServiceImp.class).to(GetSimpleQuestionService.class);
                        bind(CreateSimpleQuestionServiceImp.class).to(CreateSimpleQuestionService.class);
                        bind(GetSimpleAnswerServiceImp.class).to(GetSimpleAnswerService.class);
                        bind(DeleteQuestionnaireServiceImp.class).to(DeleteQuestionnaireService.class);
                        bind(DeleteSubjectServiceImp.class).to(DeleteSubjectService.class);
                        bind(GetStudentServiceImp.class).to(GetStudentService.class);

                        //Repository

                        //mongo
                        bind(MongoSubjectRepositoryImp.class).to(SubjectRepository.class);
                        bind(MongoQuestionnaireRepositoryImp.class).to(QuestionnaireRepository.class);
                        bind(MongoQuestionRepositoryImp.class).to(QuestionRepository.class);
                        bind(MongoResultRepositoryImp.class).to(ResultRepository.class);
                        bind(MongoAnswerRepositoryImp.class).to(AnswerRepository.class);
                        bind(MongoSimpleQuestionRepositoryImp.class).to(SimpleQuestionRepository.class);
                        bind(MongoSimpleAnswerRepositoryImp.class).to(SimpleAnswerRepository.class);
//                        bind(QuestionnaireControllerImp.class).to(QuestionnaireController.class);
//                        bind(AddQuestionnaireServiceImp.class).to(AddQuestionnaireService.class);
//                        bind(QuestionnairePresenterImp.class).to(QuestionnairePresenter.class);
//                        bind(QuestionnaireRepositoryImp.class).to(QuestionnaireRepository.class);
//                        bindAsContract(MemoryQuestionnaireData.class).in(Singleton.class);

                    }
                });

    }
}
