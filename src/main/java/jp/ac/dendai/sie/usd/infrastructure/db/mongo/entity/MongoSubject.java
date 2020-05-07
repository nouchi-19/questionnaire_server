package jp.ac.dendai.sie.usd.infrastructure.db.mongo.entity;

import com.mongodb.Mongo;
import jp.ac.dendai.sie.usd.domain.model.Subject;
import jp.ac.dendai.sie.usd.domain.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MongoSubject {
    @Id
    private Long subjectId;
    private String subjectTitle;
    private MongoUser teacher;

    public Subject toDomain() {
        return new Subject(
                this.subjectId,
                this.subjectTitle,
                this.teacher.toDomain()
        );
    }

    public static MongoSubject fromDomain(Subject subject) {
        return new MongoSubject(
                subject.getSubjectId(),
                subject.getSubjectTitle(),
                MongoUser.fromDomain(subject.getTeacher())
        );
    }
}
