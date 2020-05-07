package jp.ac.dendai.sie.usd.infrastructure.db.mongo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MongoManagementId {
    @Id
    private ObjectId objectId;
    private Long idNumber;
    private String name;

    public MongoManagementId create() {
        MongoManagementId mongoManagementId = new MongoManagementId(
                this.objectId,
                this.idNumber,
                this.name
        );
        return mongoManagementId;
    }
}
