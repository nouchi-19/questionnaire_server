package jp.ac.dendai.sie.usd.infrastructure.db.mongo.entity;

import jp.ac.dendai.sie.usd.domain.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MongoRegistration {
    @Id
    private ObjectId objectId;
    private Long subjectId;
    private List<MongoUser> userList;

}
