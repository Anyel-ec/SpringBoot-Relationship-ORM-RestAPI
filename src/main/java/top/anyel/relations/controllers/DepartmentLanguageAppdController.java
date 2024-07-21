package top.anyel.relations.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.anyel.relations.models.DepartmentLanguageAppd;
import top.anyel.relations.models.DepartmentLanguageKeyAppd;
import top.anyel.relations.services.DepartmentLanguageAppdService;

import java.util.List;

@RestController
@RequestMapping("/departmentLanguagesAppd")
public class DepartmentLanguageAppdController {
    @Autowired
    private DepartmentLanguageAppdService departmentLanguageAppdService;

    @GetMapping
    public List<DepartmentLanguageAppd> getAllDepartmentLanguages() {
        return departmentLanguageAppdService.getAllDepartmentLanguages();
    }

    @GetMapping("/{departmentId}/{languageId}")
    public ResponseEntity<DepartmentLanguageAppd> getDepartmentLanguageById(@PathVariable Integer departmentId, @PathVariable Integer languageId) {
        DepartmentLanguageKeyAppd id = new DepartmentLanguageKeyAppd();
        id.setDepartmentIdAppd(departmentId);
        id.setLanguageIdAppd(languageId);
        return departmentLanguageAppdService.getDepartmentLanguageById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public DepartmentLanguageAppd createDepartmentLanguage(@RequestBody DepartmentLanguageAppd departmentLanguageAppd) {
        return departmentLanguageAppdService.saveDepartmentLanguage(departmentLanguageAppd);
    }

    @PutMapping("/{departmentId}/{languageId}")
    public ResponseEntity<DepartmentLanguageAppd> updateDepartmentLanguage(@PathVariable Integer departmentId, @PathVariable Integer languageId, @RequestBody DepartmentLanguageAppd departmentLanguageAppd) {
        DepartmentLanguageKeyAppd id = new DepartmentLanguageKeyAppd();
        id.setDepartmentIdAppd(departmentId);
        id.setLanguageIdAppd(languageId);
        return departmentLanguageAppdService.getDepartmentLanguageById(id)
                .map(existingDepartmentLanguage -> {
                    departmentLanguageAppd.setIdAppd(existingDepartmentLanguage.getIdAppd());
                    return ResponseEntity.ok(departmentLanguageAppdService.saveDepartmentLanguage(departmentLanguageAppd));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{departmentId}/{languageId}")
    public ResponseEntity<Void> deleteDepartmentLanguage(@PathVariable Integer departmentId, @PathVariable Integer languageId) {
        DepartmentLanguageKeyAppd id = new DepartmentLanguageKeyAppd();
        id.setDepartmentIdAppd(departmentId);
        id.setLanguageIdAppd(languageId);
        departmentLanguageAppdService.deleteDepartmentLanguage(id);
        return ResponseEntity.noContent().build();
    }
}
