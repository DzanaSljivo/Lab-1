package org.example.model;

import org.example.model.Album;

public class Photo {
    private Long id;
    private String title;
    private String filename;
    private boolean available;
    private Album album; // null ako nije dodana u album

    public Photo() {}

    // Konstruktor koji ti treba
    public Photo(Long id, String title, String filename, boolean available) {
        this.id = id;
        this.title = title;
        this.filename = filename;
        this.available = available;
        this.album = null;
    }

    // Getteri i setteri
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getFilename() { return filename; }
    public void setFilename(String filename) { this.filename = filename; }

    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    public Album getAlbum() { return album; }
    public void setAlbum(Album album) { this.album = album; }
}