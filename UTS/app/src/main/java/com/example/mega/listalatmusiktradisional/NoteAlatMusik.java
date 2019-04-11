package com.example.mega.listalatmusiktradisional;

public class NoteAlatMusik {
    private String nama_alatmusik, asal_provinsi, deskripsi_alatmusik;

    public NoteAlatMusik(String nama_alatmusik, String asal_provinsi, String deskripsi_alatmusik) {
        this.nama_alatmusik = nama_alatmusik;
        this.asal_provinsi = asal_provinsi;
        this.deskripsi_alatmusik = deskripsi_alatmusik;
    }

    public String getNama_alatmusik() {
        return nama_alatmusik;
    }

    public void setNama_alatmusik(String nama_alatmusik) {
        this.nama_alatmusik = nama_alatmusik;
    }

    public String getAsal_provinsi() {
        return asal_provinsi;
    }

    public void setAsal_provinsi(String asal_provinsi) {
        this.asal_provinsi = asal_provinsi;
    }

    public String getDeskripsi_alatmusik() {
        return deskripsi_alatmusik;
    }

    public void setDeskripsi_alatmusik(String deskripsi_alatmusik) {
        this.deskripsi_alatmusik = deskripsi_alatmusik;
    }
}
