package jp.ac.dendai.sie.usd.student.infrastructure.repository.db.memory;

import jp.ac.dendai.sie.usd.domain.model.Subject;
import jp.ac.dendai.sie.usd.domain.model.User;
import jp.ac.dendai.sie.usd.infrastructure.db.memory.MemoryRegistrationMapSingleton;
import jp.ac.dendai.sie.usd.infrastructure.db.memory.MemorySubjectSingleton;
import jp.ac.dendai.sie.usd.student.usecase.repository.SubjectRepository;

import javax.ws.rs.NotFoundException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by guest1 on 2018/10/28.
 */
public class MemorySubjectRepositoryImp implements SubjectRepository {

    MemorySubjectSingleton memorySubjectSingleton = MemorySubjectSingleton.getInstance();
    MemoryRegistrationMapSingleton memoryRegistrationMapSingleton = MemoryRegistrationMapSingleton.getInstance();

    @Override
    public Optional<Subject> findBySubjectId(Long subjectId) {
        return memorySubjectSingleton.getSubjectList().stream().filter(subject -> subject.getSubjectId().equals(subjectId)).findFirst();
    }

    @Override
    public List<Subject> findAnyByStudentId(String studentId) {
        List<Subject> subjectList = new ArrayList<>();
        for(Map.Entry<Subject, List<User>> map: memoryRegistrationMapSingleton.getRegistrationMap().entrySet()) {
            if (map.getValue().stream().map(user -> user.getUserId()).collect(Collectors.toList()).contains(studentId)){
               subjectList.add(map.getKey());
            }
        }

        return subjectList;
    }

    @Override
    public void registrationStudent(Long subjectId, User student) {
        Optional<Subject> subject = memorySubjectSingleton.getSubjectList().stream().filter(sub -> sub.getSubjectId().equals(subjectId)).findFirst();
        List<User> userList = memoryRegistrationMapSingleton.getRegistrationMap().get(subject.orElseThrow(
                NotFoundException::new
        ));
        Boolean flg = false;
        for(User user : userList) {
            if(user.equals(student)) {
                flg = true;
            }
        }
        if(!flg) {
            userList.add(student);
        }
    }

    @Override
    public Boolean permissionStudentId(Long subjectId, String studentId) {
        //?
        return null;
    }

    @Override
    public Long courseNumber(Long subjectId) {
        Optional<Subject> subject = memorySubjectSingleton.getSubjectList().stream().filter(sub -> sub.getSubjectId().equals(subjectId)).findFirst();
        List<User> user = memoryRegistrationMapSingleton.getRegistrationMap().get(subject.orElseThrow(NotFoundException::new));
        Integer i = user.size();
        return i.longValue();
    }
}
