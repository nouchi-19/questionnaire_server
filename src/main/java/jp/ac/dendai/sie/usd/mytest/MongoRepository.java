package jp.ac.dendai.sie.usd.mytest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import jp.ac.dendai.sie.usd.domain.model.Questionnaire;
import org.bson.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MongoRepository {
//    private List<QuestionnaireReq> questionnaireList = new ArrayList<>();
//    private List<QuestionnaireReq> demoList = new ArrayList<>();

    private String host = "mongodb";
    private int port = 27017;
    private MongoClient cliant = new MongoClient(host, port);

    private String databaseName = "test";
    private MongoDatabase database = cliant.getDatabase(databaseName);

    private String collectionName1 = "studentRep";
    private MongoCollection<Document> collStudent = database.getCollection(collectionName1);

    private String collectionName2 = "teacherRep";
    private MongoCollection<Document> collTeacher = database.getCollection(collectionName2);

    public void addQuestionnaire(Questionnaire questionnaire) {
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(questionnaire);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        Document document = Document.parse(json);
        System.out.println(json);
        System.out.println(document);
        collStudent.insertOne(document);
    }

    public List<Questionnaire> getQuestionnaireList() {
        List<Questionnaire> questionnaireList = new ArrayList<>();
        BasicDBObject query = new BasicDBObject();
        FindIterable<Document> find = collStudent.find();
        MongoCursor<Document> cursor = find.iterator();
        try {
            while (cursor.hasNext()) {
                String json = cursor.next().toJson();
                ObjectMapper objectMapper = new ObjectMapper();
                Questionnaire questionnaire = null;
                try {
                    questionnaire = objectMapper.readValue(json, Questionnaire.class);
                } catch (IOException e) {
                    e.printStackTrace();
                }
//                System.out.println(cursor.next().toJson());
                System.out.println(questionnaire);
                questionnaireList.add(questionnaire);
            }
        } finally {
        }
        return questionnaireList;
    }

    public void addDemo(Questionnaire questionnaire) {
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(questionnaire);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        Document document = Document.parse(json);
        collTeacher.insertOne(document);
    }

    public List<Questionnaire> getDemoList() {
        List<Questionnaire> questionnaireList = new ArrayList<>();
        BasicDBObject query = new BasicDBObject();
        FindIterable<Document> find = collTeacher.find();
        MongoCursor<Document> cursor = find.iterator();
        try {
            while (cursor.hasNext()) {
                String json = cursor.next().toJson();
                ObjectMapper objectMapper = new ObjectMapper();
                Questionnaire questionnaire = null;
                try {
                    questionnaire = objectMapper.readValue(json, Questionnaire.class);
                } catch (IOException e) {
                    e.printStackTrace();
                }
//                System.out.println(cursor.next().toJson());
                System.out.println(questionnaire);
                questionnaireList.add(questionnaire);
            }
        } finally {
        }
        return questionnaireList;
    }
}
