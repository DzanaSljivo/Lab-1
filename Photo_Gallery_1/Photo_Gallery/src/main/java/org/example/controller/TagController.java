package org.example.controller;
import org.example.model.Photo;
import org.example.model.Tag;
import org.example.repository.PhotoRepository;
import org.example.repository.TagRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tags")
public class TagController {

    private final TagRepository tagRepository;
    private final PhotoRepository photoRepository;

    public TagController(TagRepository tagRepository, PhotoRepository photoRepository) {
        this.tagRepository = tagRepository;
        this.photoRepository = photoRepository;
    }

    // Prikaz svih tagova
    @GetMapping
    public String getTags(Model model) {
        model.addAttribute("tags", tagRepository.findAll());
        return "tags";
    }

    // Dodavanje novog taga
    @PostMapping("/add")
    public String addTag(@RequestParam String name) {
        Tag tag = new Tag();
        tag.setName(name);
        tagRepository.save(tag);
        return "redirect:/tags";
    }

    // Brisanje taga
    @PostMapping("/delete/{id}")
    public String deleteTag(@PathVariable Long id) {
        tagRepository.deleteById(id);
        return "redirect:/tags";
    }

    // Edit taga
    @GetMapping("/edit/{id}")
    public String editTag(@PathVariable Long id, Model model) {
        Tag tag = tagRepository.findById(id).orElse(null);
        if (tag == null) {
            model.addAttribute("error", "Tag ne postoji!");
            return "redirect:/tags";
        }
        model.addAttribute("tag", tag);
        return "tag-edit";
    }

    @PostMapping("/update/{id}")
    public String updateTag(@PathVariable Long id, @RequestParam String name) {
        Tag tag = tagRepository.findById(id).orElse(null);
        if (tag == null) return "redirect:/tags";

        tag.setName(name);
        tagRepository.save(tag);
        return "redirect:/tags";
    }

    // Prikaz fotografija za tag
    @GetMapping("/{id}/photos")
    public String getPhotosForTag(@PathVariable Long id, Model model) {
        Tag tag = tagRepository.findById(id).orElse(null);
        if (tag == null) {
            model.addAttribute("error", "Tag ne postoji!");
            return "redirect:/tags";
        }

        model.addAttribute("tag", tag);
        model.addAttribute("photos", tag.getPhotos());
        return "photos-by-tag";
    }

    // Forma za dodavanje taga na fotografiju (sigurno)
    @GetMapping("/addToPhoto/{photoId}")
    public String addTagToPhotoForm(@PathVariable Long photoId, Model model) {
        Photo photo = photoRepository.findById(photoId).orElse(null);
        if (photo == null) {
            model.addAttribute("error", "Fotografija ne postoji!");
            model.addAttribute("tags", tagRepository.findAll());
            return "tags"; // ili neka stranica sa listom fotografija
        }

        model.addAttribute("photo", photo);
        model.addAttribute("tags", tagRepository.findAll());
        return "add-tag-to-photo";
    }

    // POST za dodavanje taga na fotografiju (sigurno)
    @PostMapping("/addToPhoto")
    public String addTagToPhoto(@RequestParam Long photoId,
                                @RequestParam Long tagId,
                                Model model) {

        Photo photo = photoRepository.findById(photoId).orElse(null);
        Tag tag = tagRepository.findById(tagId).orElse(null);

        if (photo == null || tag == null) {
            model.addAttribute("error", "Fotografija ili tag ne postoji!");
            model.addAttribute("tags", tagRepository.findAll());
            return "add-tag-to-photo";
        }

        photo.getTags().add(tag);
        photoRepository.save(photo);

        return "redirect:/photos";
    }
}