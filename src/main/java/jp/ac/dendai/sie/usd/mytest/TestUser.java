package jp.ac.dendai.sie.usd.mytest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mongodb.morphia.annotations.Entity;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestUser {

    private int userId;
}
