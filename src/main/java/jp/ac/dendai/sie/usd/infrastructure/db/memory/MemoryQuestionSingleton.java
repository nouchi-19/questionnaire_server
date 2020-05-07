package jp.ac.dendai.sie.usd.infrastructure.db.memory;

import jp.ac.dendai.sie.usd.domain.model.Question;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guest1 on 2018/10/26.
 */
public class MemoryQuestionSingleton {
    private static  MemoryQuestionSingleton memoryQuestionSingleton = new MemoryQuestionSingleton();
    @Getter @Setter
    private List<Question> questionList = new ArrayList<>();
    private MemoryQuestionSingleton() {}
    public static MemoryQuestionSingleton getInstance() {
        return memoryQuestionSingleton;
    }
}