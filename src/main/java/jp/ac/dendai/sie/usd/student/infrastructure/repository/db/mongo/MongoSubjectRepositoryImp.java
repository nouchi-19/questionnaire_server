package jp.ac.dendai.sie.usd.student.infrastructure.repository.db.mongo;

import jp.ac.dendai.sie.usd.domain.model.Subject;
import jp.ac.dendai.sie.usd.domain.model.User;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.config.MongoDBHelper;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.dao.RegistrationDao;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.dao.SubjectDao;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.entity.MongoRegistration;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.entity.MongoSubject;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.entity.MongoUser;
import jp.ac.dendai.sie.usd.student.usecase.repository.SubjectRepository;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MongoSubjectRepositoryImp implements SubjectRepository {

    private SubjectDao subjectDao;

    private RegistrationDao registrationDao;

    private Datastore datastore = MongoDBHelper.getDatastore();

    public MongoSubjectRepositoryImp() {
        subjectDao = new SubjectDao(MongoSubject.class, this.datastore);
        registrationDao = new RegistrationDao(MongoRegistration.class, this.datastore);
    }

    @Override
    public Optional<Subject> findBySubjectId(Long subjectId) {
        Optional<Subject> subject = Optional.empty();
        if(subjectId != null) {
            Query<MongoSubject> query = subjectDao.createQuery().filter("subjectId", subjectId);
            Optional<MongoSubject> mongoSubject = Optional.ofNullable(subjectDao.find(query).get());
            subject = mongoSubject.map(MongoSubject::toDomain);
        }
        return subject;
    }

    @Override
    public List<Subject> findAnyByStudentId(String studentId) {
        Query<MongoRegistration> queryRegistration = registrationDao.createQuery().filter("userList.userId", studentId);
        List<Long> subjectIdList = registrationDao.find(queryRegistration).asList().stream().map(MongoRegistration::getSubjectId).collect(Collectors.toList());
        List<Query<MongoSubject>> querySubjectList = subjectIdList.stream().map(subjectId -> subjectDao.createQuery().filter("subjectId", subjectId)).collect(Collectors.toList());
        List<Subject> subjectList = new ArrayList<>();
        for(Query<MongoSubject> querySubject: querySubjectList) {
            subjectList.addAll(subjectDao.find(querySubject).asList().stream().map(MongoSubject::toDomain).collect(Collectors.toList()));
        }
        return subjectList;
    }

    @Override
    public void registrationStudent(Long subjectId, User student) {
        Query<MongoRegistration> query = registrationDao.createQuery().filter("subjectId", subjectId);
        MongoRegistration mongoRegistration = registrationDao.find(query).get();
//        System.out.println(mongoRegistration);
        Boolean flg = false;
        if(mongoRegistration.getUserList() == null) {
            mongoRegistration.setUserList(new ArrayList<>());
        }
        System.out.println(mongoRegistration);
        for(MongoUser mongoUser :mongoRegistration.getUserList()) {
            if(mongoUser.equals(MongoUser.fromDomain(student))) {
                flg = true;
            }
        }
        if(!flg) {
            mongoRegistration.getUserList().add(MongoUser.fromDomain(student));
        }
//        registrationDao.update(query, registrationDao.createUpdateOperations().addToSet("userList", registrationDao.createUpdateOperations().addToSet("userList", mongoRegistration.getUserList())));
        registrationDao.save(mongoRegistration);
    }

    @Override
    public Boolean permissionStudentId(Long subjectId, String studentId) {
//      ?
        return null;
    }

    @Override
    public Long courseNumber(Long subjectId) {
        Query<MongoRegistration> query = registrationDao.createQuery().filter("subjectId", subjectId);
        MongoRegistration mongoRegistration = registrationDao.find(query).get();
        return (long) mongoRegistration.getUserList().size();
    }
}
