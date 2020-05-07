package jp.ac.dendai.sie.usd.infrastructure.db.mongo.entity;

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
public class MongoUser {
    @Id
    private String userId;
    private String firstName;
    private String lastName;

    public User toDomain() {
        return new User(
                this.userId,
                this.firstName,
                this.lastName
        );
    }

    public static MongoUser fromDomain(User user) {
        return new MongoUser(
                user.getUserId(),
                user.getFirstName(),
                user.getLastName()
        );
    }
}
