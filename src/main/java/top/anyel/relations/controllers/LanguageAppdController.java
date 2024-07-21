package top.anyel.relations.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.anyel.relations.models.LanguageAppd;
import top.anyel.relations.services.LanguageAppdService;

import java.util.List;

@RestController
@RequestMapping("/languagesAppd")
public class LanguageAppdController {
    @Autowired
    private LanguageAppdService languageAppdService;

    @GetMapping
    public List<LanguageAppd> getAllLanguages() {
        return languageAppdService.getAllLanguages();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LanguageAppd> getLanguageById(@PathVariable Integer id) {
        return languageAppdService.getLanguageById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public List<LanguageAppd> createLanguages(@RequestBody List<LanguageAppd> languagesAppd) {
        return languageAppdService.saveLanguages(languagesAppd);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LanguageAppd> updateLanguage(@PathVariable Integer id, @RequestBody LanguageAppd languageAppd) {
        return languageAppdService.getLanguageById(id)
                .map(existingLanguage -> {
                    languageAppd.setLanguageIdAppd(existingLanguage.getLanguageIdAppd());
                    return ResponseEntity.ok(languageAppdService.saveLanguage(languageAppd));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLanguage(@PathVariable Integer id) {
        languageAppdService.deleteLanguage(id);
        return ResponseEntity.noContent().build();
    }
}
