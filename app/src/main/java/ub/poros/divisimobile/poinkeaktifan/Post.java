package ub.poros.divisimobile.poinkeaktifan;

public class Post {
    private String nama, deskripsi;
    private Integer poin;

    public Post() {
    }

    public Post(String nama, String deskripsi, Integer poin) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.poin = poin;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public Integer getPoin() {
        return poin;
    }

    public void setPoin(Integer poin) {
        this.poin = poin;
    }
}
