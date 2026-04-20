/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.maskapai.pky.objek;

import java.time.LocalDateTime;

/**
 *
 * @author ADVAN
 */
public class LogAbsensi {
    private String idLog;
    private String uidKartu;
    private LocalDateTime waktuTap;
    private String status;
    
    public LogAbsensi() {
        //
    }

    public LogAbsensi(String idLog, String uidKartu, LocalDateTime waktuTap, String status) {
        this.idLog = idLog;
        this.uidKartu = uidKartu;
        this.waktuTap = waktuTap;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIdLog() {
        return idLog;
    }

    public void setIdLog(String idLog) {
        this.idLog = idLog;
    }

    public String getUidKartu() {
        return uidKartu;
    }

    public void setUidKartu(String uidRfid) {
        this.uidKartu = uidRfid;
    }

    public LocalDateTime getWaktuTap() {
        return waktuTap;
    }

    public void setWaktuTap(LocalDateTime waktuTap) {
        this.waktuTap = waktuTap;
    }
    
    @Override
    public String toString() {
        return "LogAbsensi{" +
                "idLog='" + idLog + '\'' +
                ", uidKartu='" + uidKartu + '\'' +
                ", waktuTap=" + waktuTap +
                ", status='" + status + '\'' +
                '}';
    }
    
}
