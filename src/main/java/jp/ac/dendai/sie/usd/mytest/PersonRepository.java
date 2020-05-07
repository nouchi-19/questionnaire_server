package jp.ac.dendai.sie.usd.mytest;

import jp.ac.dendai.sie.usd.infrastructure.db.mongo.config.LocalHostConfig;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.config.MongoConfig;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.config.MongoDBHelper;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.config.VirtualHostConfig;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PersonRepository {

//    private String host = "localhost";
//    private int port = 27017;
//    private MongoClient client = new MongoClient(host, port);
//
//    private String databaseName = "test";
//
//    private Morphia morphia = new Morphia();
//    @Inject
//    MongoConfig mongoConfig = new VirtualHostConfig();

    Datastore datastore = MongoDBHelper.getDatastore();
//    private PersonDAO personDAO = new PersonDAO(Person.class, mongoConfig.getClient(), mongoConfig.getMorphia(), mongoConfig.getDatabaseName());
    private PersonDAO personDAO = new PersonDAO(Person.class, datastore);
//    private PersonDAO personDAO = new PersonDAO(Person.class, client, morphia, databaseName);
    public void test() {
        List<TestUser> testUserList = new ArrayList<>();
        testUserList.add(new TestUser(0));
        Person person = new Person(0, "person", LocalDateTime.now(), testUserList);
        personDAO.save(person);

        Query<Person> q = personDAO.createQuery().filter("personid", 0);
        Person person1 = personDAO.find(q).get();

        person1.getTestUserList().add(new TestUser(1));
        personDAO.update(q, personDAO.createUpdateOperations().addToSet("testUserList", person1.getTestUserList()));
    }

    public void test2() {
        System.out.println(personDAO.find().asList());
        Query<Person> q = personDAO.createQuery().filter("testUserList.userId", 0);
        Person person = personDAO.find(q).get();
        System.out.println(person);
    }
}
