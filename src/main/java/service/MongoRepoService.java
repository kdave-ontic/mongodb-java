package service;

import com.mongodb.*;
import com.mongodb.util.JSON;

import java.util.ArrayList;
import java.util.List;


public class MongoRepoService implements RepoService {

    /**
     * Connect with database
     *
     * @return returns (@code collection)
     */
    private static DBCollection getCollection() throws MongoClientException {
        MongoClient mongoClient = new MongoClient();
        DB db = mongoClient.getDB("UserDetail");
        return db.getCollection("UserCollection");
    }

    /**
     * @param id user id
     * @return returns (@code cursor) for which email match with input email address
     */
    private static DBCursor getCursor(String id) throws MongoCursorNotFoundException {
        DBCollection collection = MongoRepoService.getCollection();
        DBObject query = new BasicDBObject("id", id);
        return collection.find(query);
    }

    @Override
    public String insert(String document) throws NullPointerException {
        if (document == null) {
            throw new NullPointerException();
        }
        DBCollection collection = getCollection();
        DBObject object = (DBObject) JSON.parse(document);
        collection.insert(object);
        return document;
    }

    @Override
    public String remove(String id) throws NullPointerException {
        if (id == null) {
            throw new NullPointerException();
        }
        DBCollection collection = MongoRepoService.getCollection();
        DBCursor cursor = MongoRepoService.getCursor(id);

        if (cursor.count() > 0) { // user exits
//            List<BasicDBObject> obj = new ArrayList<>();
//            BasicDBObject query = new BasicDBObject();
//            for(Filters itr : usrFilters) {
//                obj.add(new BasicDBObject(itr.getKey(),itr.getValue()));
//            }
//            query.put("$and",obj);
//            cursor = MongoDb.getCollection().find(query);
            DBObject found = cursor.one();
            if (found != null) {
                collection.remove(found);
                found.removeField("_id");
                return found.toString();
            } else {
                return null;
            }
        } else { // user does'n exist
            return null;
        }
    }

    @Override
    public String update(String id, List<Filter> query) {
        DBCollection collection = MongoRepoService.getCollection();
        DBCursor cursor = MongoRepoService.getCursor(id);

        if (cursor.count() > 0) { // user exists
            DBObject update = new BasicDBObject();
            for (Filter itr : query) {
                update.put("$set", new BasicDBObject(itr.getKey(), itr.getValue()));
            }
            collection.update(new BasicDBObject("id", id), update);
            cursor = MongoRepoService.getCursor(id);
            DBObject updatedDocumet = cursor.one();
            if(updatedDocumet != null) {
                updatedDocumet.removeField("_id");
                return updatedDocumet.toString();
            } else {
                return null;
            }
        } else { // user doesn't exists
            return null;
        }
    }

    @Override
    public List<String> getAll() {
        DBCollection collection = MongoRepoService.getCollection();
        DBCursor itrDocument = collection.find();
        List<String> documents = new ArrayList<>();
        if (itrDocument.count() > 0) {
            for (DBObject itr : itrDocument) {
                DBObject cur = itr;
                cur.removeField("_id");
                documents.add(cur.toString());
            }
            return documents;
        } else {
            return null;
        }
    }

    @Override
    public String get(List<Filter> filters) {
        List<BasicDBObject> obj = new ArrayList<>();
        BasicDBObject query = new BasicDBObject();
        for (Filter itr : filters) {
            obj.add(new BasicDBObject(itr.key, itr.value));
        }
        query.put("$and", obj);
        DBCursor cursor = MongoRepoService.getCollection().find(query);
        DBObject found = cursor.one();
        if (found != null) {
            found.removeField("_id");
            return found.toString();
        } else {
            return null;
        }
    }

    @Override
    public void clearDB() {
        DBCollection collection = getCollection();
        collection.remove(new BasicDBObject());
    }

}
