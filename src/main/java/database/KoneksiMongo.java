/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;
import objek.LogAbsensi;
import org.bson.Document;

/**
 *
 * @author ADVAN
 */
    public class KoneksiMongo {

        public static void simpanLogAbsensi(LogAbsensi log) {
        try {
            MongoClient client = MongoClients.create("mongodb://localhost:27017");
            MongoDatabase db = client.getDatabase("absensi_db");
            MongoCollection<Document> col = db.getCollection("absensi");

            col.insertOne(log.toDocument());

            System.out.println("Log absensi masuk DB!");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
        
    public static List<LogAbsensi> getAllAbsensi() {
        List<LogAbsensi> list = new ArrayList<>();

        try {
            MongoClient client = MongoClients.create("mongodb://localhost:27017");
            MongoDatabase db = client.getDatabase("absensi_db");
            MongoCollection<Document> col = db.getCollection("absensi");

            for (Document doc : col.find()) {
                LogAbsensi log = new LogAbsensi();
                log.setIdLog(doc.getString("idLog"));
                log.setUidKartu(doc.getString("uidKartu"));
                log.setWaktuTap(java.time.LocalDateTime.parse(doc.getString("waktuTap")));
                log.setStatus(doc.getString("status"));

                list.add(log);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return list;
    }
}
