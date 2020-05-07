package jp.ac.dendai.sie.usd.infrastructure.db.memory;

import jp.ac.dendai.sie.usd.domain.model.Questionnaire;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guest1 on 2018/10/26.
 */
public class MemoryQuestionnaireSingleton {
    private static MemoryQuestionnaireSingleton memoryQuestionnaireSingleton = new MemoryQuestionnaireSingleton();
    @Getter @Setter
    private List<Questionnaire> questionnaireList = new ArrayList<>();
    private MemoryQuestionnaireSingleton() {}
    public static MemoryQuestionnaireSingleton getInstance() {
        return memoryQuestionnaireSingleton;
    }
}