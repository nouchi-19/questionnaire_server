package jp.ac.dendai.sie.usd.infrastructure.db.memory;

import jp.ac.dendai.sie.usd.infrastructure.db.mongo.entity.ManagementIdEntity;
import lombok.Getter;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

public class MemoryIdStore {
    private static MemoryIdStore memoryIdStore = new MemoryIdStore();
    @Getter
    private List<ManagementIdEntity> idEntityList = new ArrayList<>();
    private MemoryIdStore() {
        add("answerId");
        add("subjectId");
        add("questionnaireId");
        add("questionId");
        add("resultId");
    }
    public static MemoryIdStore getInstance() {
        return memoryIdStore;
    }
    private void add(String id) {
        ManagementIdEntity managementIdEntity = new ManagementIdEntity();
        managementIdEntity.setId(0L);
        managementIdEntity.setName(id);
        idEntityList.add(managementIdEntity);
    }

    public Long createId (String name) {
        System.out.println("ssss");
        for(ManagementIdEntity idEntity: idEntityList) {
            System.out.println(idEntity.getId()  + " " + idEntity.getName());
            if(idEntity.getName().equals(name)) {

                Long l = idEntity.getId();
                idEntity.setId(idEntity.getId() + 1);
                return l;
            }
        }
        throw new WebApplicationException(Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("id作番でミスってるよ").build());
    }
}
