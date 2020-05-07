package jp.ac.dendai.sie.usd.infrastructure.db.memory;

import jp.ac.dendai.sie.usd.domain.model.Subject;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guest1 on 2018/10/26.
 */
public class MemorySubjectSingleton {
    private static MemorySubjectSingleton memorySubjectSingleton = new MemorySubjectSingleton();
    @Getter @Setter
    private List<Subject> subjectList = new ArrayList<>();
    private MemorySubjectSingleton() {}
    public static MemorySubjectSingleton getInstance() {
        return memorySubjectSingleton;
    }
}
