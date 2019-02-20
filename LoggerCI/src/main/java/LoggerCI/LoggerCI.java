package LoggerCI;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

import java.util.Date;

public class LoggerCI {
    static String ip = "localhost";
    static int port = 27017;
    static Mongo mongo = new Mongo(ip, port);
    static DB db = mongo.getDB("Logs");

    public static void main(String... args) {
        StringBuilder stringBuilder = new StringBuilder();

        for (String arg : args) {
            stringBuilder.append(arg + " ");
        }

        String resultInfo = stringBuilder.toString();

        if (resultInfo.length() > 0) {
            DBCollection col = db.getCollection("CI");
            BasicDBObject doc = new BasicDBObject();
            doc.put("date", new Date().toString());
            doc.put("text", resultInfo);
            col.insert(doc);
        }

    }
}
