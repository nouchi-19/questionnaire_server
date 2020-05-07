package jp.ac.dendai.sie.usd.infrastructure.db.memory;

import jp.ac.dendai.sie.usd.domain.model.Result;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guest1 on 2018/10/26.
 */
public class MemoryResultSingleton {
    private static MemoryResultSingleton memoryResultSingleton  = new MemoryResultSingleton();
    @Getter @Setter
    private List<Result> resultList = new ArrayList<>();
    private MemoryResultSingleton() {}
    public static MemoryResultSingleton getInstance() {
        return memoryResultSingleton;
    }
}
