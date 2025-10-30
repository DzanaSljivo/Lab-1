package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Album {
    private Long id;
    private String naziv;
    private String opis;
    private String coverImage; // slika koja se prikazuje kao cover albuma
    private List<Photo> fotografije = new ArrayList<>();

    public Album() {}

    // Konstruktor za id, naziv, opis i coverImage
    public Album(Long id, String naziv, String opis, String coverImage) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.coverImage = coverImage;
    }

    // Getteri i setteri
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNaziv() { return naziv; }
    public void setNaziv(String naziv) { this.naziv = naziv; }

    public String getOpis() { return opis; }
    public void setOpis(String opis) { this.opis = opis; }

    public String getCoverImage() { return coverImage; }
    public void setCoverImage(String coverImage) { this.coverImage = coverImage; }

    public List<Photo> getFotografije() { return fotografije; }
    public void setFotografije(List<Photo> fotografije) { this.fotografije = fotografije; }

    // Maksimalno 10 slika po albumu
    public boolean canAddMore() {
        return fotografije.size() < 10;
    }

    // Dodaj fotografiju u album
    public void addPhoto(Photo p) {
        if (canAddMore()) fotografije.add(p);
    }

    // Ukloni fotografiju iz albuma
    public void removePhoto(Photo p) {
        fotografije.remove(p);
    }
}
