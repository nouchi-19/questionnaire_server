package jp.ac.dendai.sie.usd.infrastructure.db.memory;

import jp.ac.dendai.sie.usd.domain.model.Answer;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guest1 on 2018/10/26.
 */
public class MemoryAnswerSingleton {
    private static MemoryAnswerSingleton memoryAnswerSingleton = new MemoryAnswerSingleton();
    @Getter @Setter
    private List<Answer> answerList = new ArrayList<>();
    private MemoryAnswerSingleton() {}
    public static MemoryAnswerSingleton getInstance() {
        return memoryAnswerSingleton;
    }
}
