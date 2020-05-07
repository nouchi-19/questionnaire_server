package jp.ac.dendai.sie.usd.infrastructure.db.memory;

import jp.ac.dendai.sie.usd.domain.model.Subject;
import jp.ac.dendai.sie.usd.domain.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by guest1 on 2018/10/26.
 */
public class MemoryRegistrationMapSingleton {
    private static MemoryRegistrationMapSingleton memoryRegistrationMapSingleton = new MemoryRegistrationMapSingleton();
    @Getter @Setter
    private Map<Subject, List<User>> registrationMap = new HashMap<>();
    private MemoryRegistrationMapSingleton() {}
    public static MemoryRegistrationMapSingleton getInstance() {
        return memoryRegistrationMapSingleton;
    }
}
