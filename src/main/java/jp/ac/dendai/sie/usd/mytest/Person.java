package jp.ac.dendai.sie.usd.mytest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    public long personid;
    public String name;
    public LocalDateTime localDateTime;
    public List<TestUser> testUserList;


}
