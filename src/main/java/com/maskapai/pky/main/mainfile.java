package com.maskapai.pky.main;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import com.maskapai.pky.objek.LogAbsensi;
import com.maskapai.pky.objek.StaffMaskapai;

public class mainfile {

    public static void main(String[] args) {

        ArrayList<StaffMaskapai> daftarStaff = new ArrayList<>();

        StaffMaskapai s1 = new StaffMaskapai();
        s1.setUidKartu("111");
        s1.setIdStaff("S001");
        s1.setNamaLengkap("gembul");
        s1.setJabatan("Pilot");
        s1.setStatus("Aktif");

        StaffMaskapai s2 = new StaffMaskapai();
        s2.setUidKartu("222");
        s2.setIdStaff("S002");
        s2.setNamaLengkap("gemblong");
        s2.setJabatan("Crew");
        s2.setStatus("Aktif");

        StaffMaskapai s3 = new StaffMaskapai();
        s3.setUidKartu("333");
        s3.setIdStaff("S003");
        s3.setNamaLengkap("ahmeng");
        s3.setJabatan("Ground Staff");
        s3.setStatus("Nonaktif");

        daftarStaff.add(s1);
        daftarStaff.add(s2);
        daftarStaff.add(s3);

        Scanner input = new Scanner(System.in);

        System.out.print("Scan kartu (masukkan UID): ");
        String inputUid = input.nextLine();
        
        boolean ditemukan = false;

        for (StaffMaskapai s : daftarStaff) {
            if (inputUid.equals(s.getUidKartu())) {

                if (s.getStatus().equalsIgnoreCase("Aktif")) {
                    System.out.println("Terverifikasi: " + s.getNamaLengkap());

                    LogAbsensi log = new LogAbsensi();
                    log.setIdLog("LOG001");
                    log.setUidKartu(inputUid);
                    log.setWaktuTap(LocalDateTime.now());
                    log.setStatus("BERHASIL");

                    System.out.println(log);

                } else {
                    System.out.println("Akses ditolak (Nonaktif)");

                    LogAbsensi log = new LogAbsensi();
                    log.setIdLog("LOG002");
                    log.setUidKartu(inputUid);
                    log.setWaktuTap(LocalDateTime.now());
                    log.setStatus("GAGAL");

                    System.out.println(log);
                }

                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Kartu tidak terdaftar");

            LogAbsensi log = new LogAbsensi();
            log.setIdLog("LOG003");
            log.setUidKartu(inputUid);
            log.setWaktuTap(LocalDateTime.now());
            log.setStatus("GAGAL");

            System.out.println(log);
        }
    }
}