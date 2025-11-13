package org.example.controller;

import org.example.model.Tag;
import org.example.repository.TagRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tags")
public class TagRestController {

    private final TagRepository tagRepository;

    public TagRestController(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    // Dohvat svih tagova
    @GetMapping
    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    // Dodavanje novog taga
    @PostMapping
    public Tag createTag(@RequestBody Tag tag) {
        return tagRepository.save(tag);
    }

    // Brisanje taga po ID
    @DeleteMapping("/{id}")
    public void deleteTag(@PathVariable Long id) {
        tagRepository.deleteById(id);
    }

    // Dohvat jednog taga po ID
    @GetMapping("/{id}")
    public Tag getTagById(@PathVariable Long id) {
        return tagRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tag ne postoji sa ID: " + id));
    }
}
