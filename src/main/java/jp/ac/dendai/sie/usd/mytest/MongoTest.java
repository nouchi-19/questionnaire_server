package jp.ac.dendai.sie.usd.mytest;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoTest {
    private String host = "mongodb";
    private int port = 27017;
    private MongoClient client = new MongoClient(host, port);

    private String databaseName = "test2";
    private MongoDatabase database = client.getDatabase(databaseName);

    private String collectionName = "studentList";
    private MongoCollection<Document> coll = database.getCollection(collectionName);
    public void addTest() {

        Document doc = new Document();

        doc.append("id", "15jk162");
        doc.append("name", "take");
        doc.append("number", 1);
        doc.append("admin", true);
        coll.insertOne(doc);

        Document doc2 = new Document();

        doc2.append("id", "15jk163");
        doc2.append("name", "tago");
        doc2.append("number", 2);
        doc2.append("admin", false);
        coll.insertOne(doc2);
    }

    public void getTest() {
        BasicDBObject query = new BasicDBObject();
        FindIterable<Document> find = coll.find();
        MongoCursor<Document> cursor = find.iterator();
        try {
            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }
        long count = coll.countDocuments(query);
        System.out.println(count + "件");
    }




}
