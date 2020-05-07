package jp.ac.dendai.sie.usd.teacher.infrastructure.repository.db.mongo;

import jp.ac.dendai.sie.usd.domain.model.Subject;
import jp.ac.dendai.sie.usd.domain.model.User;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.config.MongoDBHelper;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.dao.IdStoreDao;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.dao.RegistrationDao;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.dao.SubjectDao;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.entity.*;
import jp.ac.dendai.sie.usd.teacher.usecase.repository.SubjectRepository;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import sun.nio.cs.ext.ISCII91;

import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MongoSubjectRepositoryImp implements SubjectRepository {

    private IdStoreDao idStoreDao;

    private SubjectDao subjectDao;

    private RegistrationDao registrationDao;

    private Datastore datastore = MongoDBHelper.getDatastore();

    public MongoSubjectRepositoryImp() {
        subjectDao = new SubjectDao(MongoSubject.class, this.datastore);
        registrationDao = new RegistrationDao(MongoRegistration.class, this.datastore);
        idStoreDao = new IdStoreDao(MongoManagementId.class, this.datastore);
    }

    @Override
    public Long insert(Subject subject) {
        subject.setSubjectId(idStoreDao.create("subjectId"));
        subjectDao.save(MongoSubject.fromDomain(subject));
        registrationDao.save(new MongoRegistration(null, subject.getSubjectId(), new ArrayList<>()));
        return subject.getSubjectId();
    }

    @Override
    public void delete(Long subjectId) {
        subjectDao.deleteById(subjectId);
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
    public List<Subject> findAnyByTeacherId(String teacherId) {
//        Query<MongoRegistration> queryRegistration = registrationDao.createQuery().filter("userList.userId", studentId);
//        List<Long> subjectIdList = registrationDao.find(queryRegistration).asList().stream().map(MongoRegistration::getSubjectId).collect(Collectors.toList());
//        List<Query<MongoSubject>> querySubjectList = subjectIdList.stream().map(subjectId -> subjectDao.createQuery().filter("subjectId", subjectId)).collect(Collectors.toList());
//        List<Subject> subjectList = new ArrayList<>();
//        for(Query<MongoSubject> querySubject: querySubjectList) {
//            subjectList.addAll(subjectDao.find(querySubject).asList().stream().map(MongoSubject::toDomain).collect(Collectors.toList()));
//        }
        Query<MongoSubject> subjectQuery = subjectDao.createQuery().filter("teacher.userId", teacherId);
        List<Subject> subjectList = subjectDao.find(subjectQuery).asList().stream().map(MongoSubject::toDomain).collect(Collectors.toList());
        return subjectList;
    }

//    @Override
//    public void registrationStudent(Long subjectId, User teacher) {
//        Query<MongoRegistration> query = registrationDao.createQuery().filter("subjectId", subjectId);
//        MongoRegistration mongoRegistration = registrationDao.find(query).get();
//        System.out.println(mongoRegistration);
//        Boolean flg = false;
//        if(mongoRegistration.getUserList() == null) {
//            mongoRegistration.setUserList(new ArrayList<>());
//        }
//        System.out.println(mongoRegistration);
//        for(MongoUser mongoUser :mongoRegistration.getUserList()) {
//            if(mongoUser.equals(MongoUser.fromDomain(student))) {
//                flg = true;
//            }
//        }
//        if(!flg) {
//            mongoRegistration.getUserList().add(MongoUser.fromDomain(student));
//        }
////        registrationDao.update(query, registrationDao.createUpdateOperations().addToSet("userList", registrationDao.createUpdateOperations().addToSet("userList", mongoRegistration.getUserList())));
//        registrationDao.save(mongoRegistration);
//    }

    @Override
    public Boolean permissionStudentId(Long subjectId, String teacherId) {
//      ?
        return null;
    }

    @Override
    public Long courseNumber(Long subjectId) {
        Query<MongoRegistration> query = registrationDao.createQuery().filter("subjectId", subjectId);
        MongoRegistration mongoRegistration = registrationDao.find(query).get();
        return (long) mongoRegistration.getUserList().size();
    }

    @Override
    public List<User> findAnyByUser(Long subjectId) {
        Query<MongoRegistration> query = registrationDao.createQuery().filter("subjectId", subjectId);
        Optional<MongoRegistration> opMongoRegistration = Optional.ofNullable(registrationDao.find(query).get());
//        List<MongoUser> userList = opMongoRegistration.map(MongoRegistration::getUserList).orElseThrow(() -> new NotFoundException("履修者が見つかりません"));
        List<MongoUser> userList = opMongoRegistration.map(MongoRegistration::getUserList).orElse(new ArrayList<>());
        return userList.stream().map(MongoUser::toDomain).collect(Collectors.toList());
    }
}
