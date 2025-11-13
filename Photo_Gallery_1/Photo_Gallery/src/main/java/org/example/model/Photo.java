package org.example.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String imageUrl;

    private boolean available;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

    // Mijenjamo pojedinačni tag u listu tagova za Many-to-Many vezu
    @ManyToMany
    @JoinTable(
            name = "photo_tag",
            joinColumns = @JoinColumn(name = "photo_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags;

    // Default constructor
    public Photo() {}

    // Konstruktor sa osnovnim poljima
    public Photo(String title, String description, String imageUrl) {
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.available = true;
    }

    // Konstruktor sa boolean poljem
    public Photo(String title, String description, String imageUrl, boolean available) {
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.available = available;
    }

    // Getteri i setteri
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    public Album getAlbum() { return album; }
    public void setAlbum(Album album) { this.album = album; }

    public List<Tag> getTags() { return tags; }
    public void setTags(List<Tag> tags) { this.tags = tags; }
}