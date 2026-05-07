/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;
import objek.LogAbsensi;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 *
 * @author ADVAN
 */
    public class KoneksiMongo {
        private static MongoClient mongoClient;
        private static final String DATABASE_NAME = "RFID_Maskapai_Penerbangan";

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

    public static MongoDatabase getDatabase() {
        if (mongoClient == null) {
            // Konfigurasi CodecRegistry untuk pemetaan POJO otomatis (Standard Industry)
            CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(
                MongoClientSettings.getDefaultCodecRegistry(),
                CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build())
            );

            // Inisiasi koneksi ke MongoDB Localhost (Driver 5.0.0)
            mongoClient = MongoClients.create("mongodb://localhost:27017");
            
            // Mengembalikan database dengan registry yang sudah dikonfigurasi
            return mongoClient.getDatabase(DATABASE_NAME).withCodecRegistry(pojoCodecRegistry);
        }
        return mongoClient.getDatabase(DATABASE_NAME);
    }
}
