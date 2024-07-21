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

    @GetMapping("/{departmentIdAppd}/{languageIdAppd}")
    public ResponseEntity<DepartmentLanguageAppd> getDepartmentLanguageById(@PathVariable Integer departmentIdAppd, @PathVariable Integer languageIdAppd) {
        DepartmentLanguageKeyAppd idAppd = new DepartmentLanguageKeyAppd(departmentIdAppd, languageIdAppd);
        return departmentLanguageAppdService.getDepartmentLanguageById(idAppd)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public List<DepartmentLanguageAppd> createDepartmentLanguages(@RequestBody List<DepartmentLanguageAppd> departmentLanguagesAppd) {
        for (DepartmentLanguageAppd dl : departmentLanguagesAppd) {
            DepartmentLanguageKeyAppd idAppd = new DepartmentLanguageKeyAppd(dl.getDepartmentAppd().getDepartmentIdAppd(), dl.getLanguageAppd().getLanguageIdAppd());
            dl.setIdAppd(idAppd);
        }
        return departmentLanguageAppdService.saveDepartmentLanguages(departmentLanguagesAppd);
    }

    @PutMapping("/{departmentIdAppd}/{languageIdAppd}")
    public ResponseEntity<DepartmentLanguageAppd> updateDepartmentLanguage(@PathVariable Integer departmentIdAppd, @PathVariable Integer languageIdAppd, @RequestBody DepartmentLanguageAppd departmentLanguageAppd) {
        DepartmentLanguageKeyAppd idAppd = new DepartmentLanguageKeyAppd(departmentIdAppd, languageIdAppd);
        return departmentLanguageAppdService.getDepartmentLanguageById(idAppd)
                .map(existingDepartmentLanguage -> {
                    departmentLanguageAppd.setIdAppd(existingDepartmentLanguage.getIdAppd());
                    return ResponseEntity.ok(departmentLanguageAppdService.saveDepartmentLanguage(departmentLanguageAppd));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{departmentIdAppd}/{languageIdAppd}")
    public ResponseEntity<Void> deleteDepartmentLanguage(@PathVariable Integer departmentIdAppd, @PathVariable Integer languageIdAppd) {
        DepartmentLanguageKeyAppd idAppd = new DepartmentLanguageKeyAppd(departmentIdAppd, languageIdAppd);
        departmentLanguageAppdService.deleteDepartmentLanguage(idAppd);
        return ResponseEntity.noContent().build();
    }
}
