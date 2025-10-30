package org.example.data;

import org.springframework.stereotype.Component;
import org.example.model.Album;
import org.example.model.Photo;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class DemoData {

    private final Map<Long, Album> albums = new LinkedHashMap<>();
    private final Map<Long, Photo> photos = new LinkedHashMap<>();
    private long albumSeq = 1;
    private long photoSeq = 100;

    public DemoData() {
        // Kreiranje albuma sa naslovnom slikom
        saveAlbum(new Album(null, "Odmor 2023", "Fotografije sa ljetnog odmora", "city.jpg"));
        saveAlbum(new Album(null, "Priroda", "Fotografije prirode i planina", "nature.jpg"));
        saveAlbum(new Album(null, "Porodica", "Porodične uspomene", "portrait.jpg"));

        // Kreiranje fotografija

        savePhoto(new Photo(null, "Pogled na planinu", "nature.jpg", true));
        savePhoto(new Photo(null, "Rođendanska zabava", "portrait.jpg", true));
        savePhoto(new Photo(null, "Šetnja šumom", "nature.jpg", true));
        savePhoto(new Photo(null, "Dječja igra u dvorištu", "portrait.jpg", true));
    }

    // Svi albumi
    public List<Album> findAllAlbums() {
        return new ArrayList<>(albums.values());
    }

    // Sve fotografije
    public List<Photo> findAllPhotos() {
        return new ArrayList<>(photos.values());
    }

    public Optional<Album> findAlbumById(Long id) {
        return Optional.ofNullable(albums.get(id));
    }

    public Optional<Photo> findPhotoById(Long id) {
        return Optional.ofNullable(photos.get(id));
    }

    public Album saveAlbum(Album a) {
        if (a.getId() == null) a.setId(albumSeq++);
        albums.put(a.getId(), a);
        return a;
    }

    public Photo savePhoto(Photo p) {
        if (p.getId() == null) p.setId(photoSeq++);
        photos.put(p.getId(), p);
        return p;
    }

    public List<Photo> availablePhotos() {
        return photos.values().stream().filter(Photo::isAvailable).collect(Collectors.toList());
    }

    public List<Photo> findPhotosInAlbum(Long albumId) {
        return photos.values().stream()
                .filter(p -> p.getAlbum() != null && Objects.equals(p.getAlbum().getId(), albumId))
                .collect(Collectors.toList());
    }

    public boolean addPhotoToAlbum(Long albumId, Long photoId) {
        var albumOpt = findAlbumById(albumId);
        var photoOpt = findPhotoById(photoId);
        if (albumOpt.isEmpty() || photoOpt.isEmpty()) return false;

        Photo photo = photoOpt.get();
        if (photo.getAlbum() != null) return false;

        photo.setAlbum(albumOpt.get());
        photo.setAvailable(false);
        albumOpt.get().addPhoto(photo);
        return true;
    }

    public boolean removePhotoFromAlbum(Long photoId) {
        var photoOpt = findPhotoById(photoId);
        if (photoOpt.isEmpty()) return false;

        Photo photo = photoOpt.get();
        if (photo.getAlbum() == null) return false;

        photo.getAlbum().removePhoto(photo);
        photo.setAlbum(null);
        photo.setAvailable(true);
        return true;
    }
}
