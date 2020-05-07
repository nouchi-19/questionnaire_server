package jp.ac.dendai.sie.usd.student;


import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import jp.ac.dendai.sie.usd.filter.CORSResponseFilter;
import jp.ac.dendai.sie.usd.filter.ConstraintViolationExceptionMapper;
import jp.ac.dendai.sie.usd.filter.JacksonConfigurator;
import jp.ac.dendai.sie.usd.student.adapter.controllers.*;
import jp.ac.dendai.sie.usd.student.adapter.mappers.*;
import jp.ac.dendai.sie.usd.student.adapter.presenters.*;
import jp.ac.dendai.sie.usd.student.infrastructure.repository.db.mongo.*;
import jp.ac.dendai.sie.usd.student.usecase.presenter.*;
import jp.ac.dendai.sie.usd.student.usecase.repository.*;
import jp.ac.dendai.sie.usd.student.usecase.service.*;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("student/api")
public class StudentApiConfig extends ResourceConfig {
    public StudentApiConfig() {
        packages(this.getClass().getPackage().getName())
//        packages("jp.ac.dendai.sie.usd")
                .register(ConstraintViolationExceptionMapper.class)
                .register(CORSResponseFilter.class)
                .register(JacksonConfigurator.class)
                .register(JacksonJsonProvider.class)
                .register(new AbstractBinder() {
                    @Override
                    protected void configure() {
                        //Controllers
                        bind(SubjectControllerImp.class).to(SubjectController.class);
                        bind(QuestionnaireControllerImp.class).to(QuestionnaireController.class);
                        bind(ResultControllerImp.class).to(ResultController.class);
                        bind(AggregateControllerImp.class).to(AggregateController.class);
                        bind(SimpleQuestionControllerImp.class).to(SimpleQuestionController.class);
                        bind(SimpleAnswerControllerImp.class).to(SimpleAnswerController.class);

                        //Presenters
                        bind(SubjectPresenterImp.class).to(SubjectPresenter.class);
                        bind(QuestionnairePresenterImp.class).to(QuestionnairePresenter.class);
                        bind(ResultPresenterImp.class).to(ResultPresenter.class);
                        bind(AggregatePresenterImp.class).to(AggregatePresenter.class);
                        bind(SimpleQuestionPresenterImp.class).to(SimpleQuestionPresenter.class);
                        bind(SimpleAnswerPresenterImp.class).to(SimpleAnswerPresenter.class);

                        //Mappers
                        bind(UserInformationMapperImp.class).to(UserInformationMapper.class);
                        bind(SubjectMapperImp.class).to(SubjectMapper.class);
                        bind(QuestionnaireMapperImp.class).to(QuestionnaireMapper.class);
                        bind(QuestionMapperImp.class).to(QuestionMapper.class);
                        bind(ResultMapperImp.class).to(ResultMapper.class);
                        bind(AnswerMapperImp.class).to(AnswerMapper.class);
                        bind(AggregateMapperImp.class).to(AggregateMapper.class);
                        bind(SimpleQuestionMapperImp.class).to(SimpleQuestionMapper.class);
                        bind(SimpleAnswerMapperImp.class).to(SimpleAnswerMapper.class);

                        //Service
                        bind(MongoSetUpServiceImp.class).to(SetUpService.class);

                        bind(GetSubjectServiceImp.class).to(GetSubjectService.class);
                        bind(RegistrationSubjectServiceImp.class).to(RegistrationSubjectService.class);
                        bind(GetQuestionnaireServiceImp.class).to(GetQuestionnaireService.class);
                        bind(CreateResultServiceImp.class).to(CreateResultService.class);
                        bind(GetResultServiceImp.class).to(GetResultService.class);
                        bind(GetAggregateServiceImp.class).to(GetAggregateService.class);
                        bind(GetSimpleQuestionServiceImp.class).to(GetSimpleQuestionService.class);
                        bind(CreateSimpleAnswerServiceImp.class).to(CreateSimpleAnswerService.class);
                        bind(GetSimpleAnswerServiceImp.class).to(GetSimpleAnswerService.class);
                        bind(GetSimpleAnswerAggregateServiceImp.class).to(GetSimpleAnswerAggregateService.class);

                        //Repository
                        //memory
//                        bind(MemorySubjectRepositoryImp.class).to(SubjectRepository.class);
//                        bind(MemoryQuestionnaireRepositoryImp.class).to(QuestionnaireRepository.class);
//                        bind(MemoryQuestionRepositoryImp.class).to(QuestionRepository.class);
//                        bind(MemoryResultRepositoryImp.class).to(ResultRepository.class);
//                        bind(MemoryAnswerRepositoryImp.class).to(AnswerRepository.class);

                        //mongo
                        bind(MongoSubjectRepositoryImp.class).to(SubjectRepository.class);
                        bind(MongoQuestionnaireRepositoryImp.class).to(QuestionnaireRepository.class);
                        bind(MongoQuestionRepositoryImp.class).to(QuestionRepository.class);
                        bind(MongoResultRepositoryImp.class).to(ResultRepository.class);
                        bind(MongoAnswerRepositoryImp.class).to(AnswerRepository.class);
                        bind(MongoSimpleQuestionRepositoryImp.class).to(SimpleQuestionRepository.class);
                        bind(MongoSimpleAnswerRepositoryImp.class).to(SimpleAnswerRepository.class);




//                        bindAsContract(AnswerDao.class);
//                        bindAsContract(IdStoreDao.class);
//                        bindAsContract(QuestionDao.class);
//                        bindAsContract(QuestionnaireDao.class);
//                        bindAsContract(RegistrationDao.class);
//                        bindAsContract(ResultDao.class);
//                        bindAsContract(SubjectDao.class);



//                        bind(LocalHostConfig.class).to(MongoConfig.class);

                        //adapter
                        //controller
//                        bind(AnswerControllerImp.class).to(AnswerController.class);
//                        bind(QuestionnaireControllerImp.class).to(QuestionnaireController.class);
//                        //presenter
//                        bind(QuestionnairePresenterImp.class).to(QuestionnairePresenter.class);
//                        //service
//                        bind(AddAnswerServiceImp.class).to(AddAnswerService.class);
//                        bind(GetAnswerServiceImp.class).to(GetAnswerService.class);
//                        bind(GetQuestionnaireServiceImp.class).to(GetQuestionnaireServiceImp.class);
//
//                        bind(AnswerRepositoryImp.class).to(AnswerRepository.class);
//                        bind(QuestionnaireRepositoryImp.class).to(QuestionnaireRepository.class);
//
//                        bindAsContract(MemoryAnswerData.class).in(Singleton.class);
//                        bindAsContract(MemoryQuestionnaireData.class).in(Singleton.class);



                    }

                });
    }
}
