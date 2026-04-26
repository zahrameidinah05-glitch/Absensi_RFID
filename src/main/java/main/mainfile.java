package main;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import objek.LogAbsensi;
import objek.StaffMaskapai;
import database.KoneksiMongo;
import javax.swing.JFrame;
import view.MainForm;

public class MainFile {
        public static void main(String[] args) {
         javax.swing.SwingUtilities.invokeLater(() -> {
             JFrame frame = new JFrame("Scan RFID");
             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

             frame.setContentPane(new MainForm()); // pasang panel dulu

             frame.pack(); // 🔥 ini penting (auto size sesuai layout)
             frame.setLocationRelativeTo(null); // baru center

             frame.setVisible(true);
         });
     }
}