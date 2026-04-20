package com.maskapai.pky.objek;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADVAN
 */
public class StaffMaskapai {
    
    private String uidKartu;
    private String idStaff;
    private String namaLengkap;
    private String jabatan;
    private String status;
    private String asal;
    private String tempatTinggal;
    
    public StaffMaskapai(){
        
    }

    public StaffMaskapai(String uidKartu, String idStaff, String namaLengkap, String jabatan, String status, String asal, String tempatTinggal) {
        this.uidKartu = uidKartu;
        this.idStaff = idStaff;
        this.namaLengkap = namaLengkap;
        this.jabatan = jabatan;
        this.status = status;
        this.asal = asal;
        this.tempatTinggal = tempatTinggal;
    }
    

    public String getUidKartu() {
        return uidKartu;
    }

    public void setUidKartu(String uidKartu) {
        this.uidKartu = uidKartu;
    }

    public String getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(String idStaff) {
        this.idStaff = idStaff;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAsal() {
        return asal;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }

    public String getTempatTinggal() {
        return tempatTinggal;
    }

    public void setTempatTinggal(String tempatTinggal) {
        this.tempatTinggal = tempatTinggal;
    }
    
    public String toString() {
        return "StaffMaskapai{" + 
                "uidRfid=" + uidKartu + 
                ", idStaff=" + idStaff + 
                ", namaLengkap=" + namaLengkap + 
                ", jabatan=" + jabatan + 
                ", status=" + status + 
                ", asal=" + asal + 
                ", tempatTinggal=" + tempatTinggal + '}';
                
    }
}
