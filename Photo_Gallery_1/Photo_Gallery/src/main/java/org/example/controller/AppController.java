package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.example.data.DemoData;
import org.example.model.Album;
import org.example.model.Photo;

@Controller
public class AppController {

    private final DemoData data;

    public AppController(DemoData data) {
        this.data = data;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/albums";
    }

    @GetMapping("/albums")
    public String albums(Model model) {
        model.addAttribute("albums", data.findAllAlbums());
        return "albums";
    }

    @GetMapping("/photos")
    public String photos(Model model) {
        model.addAttribute("photos", data.findAllPhotos());
        return "photos";
    }

    @GetMapping("/albums/action/{id}")
    public String albumAction(@PathVariable Long id, Model model) {
        var albumOpt = data.findAlbumById(id);
        if (albumOpt.isEmpty()) {
            return "redirect:/albums";
        }
        model.addAttribute("album", albumOpt.get());
        model.addAttribute("availablePhotos", data.availablePhotos());
        model.addAttribute("albumPhotos", data.findPhotosInAlbum(id));
        return "action";
    }

    @PostMapping("/albums/action/addPhoto")
    public String addPhoto(@RequestParam Long albumId, @RequestParam Long photoId) {
        data.addPhotoToAlbum(albumId, photoId);
        return "redirect:/albums/action/" + albumId;
    }

    @PostMapping("/photos/remove")
    public String removePhoto(@RequestParam Long photoId, @RequestParam(required = false) Long albumId) {
        var photo = data.findPhotoById(photoId);
        if (albumId == null && photo.isPresent() && photo.get().getAlbum() != null) {
            albumId = photo.get().getAlbum().getId();
        }
        data.removePhotoFromAlbum(photoId);
        return (albumId != null)
                ? "redirect:/albums/action/" + albumId
                : "redirect:/photos";
    }
}