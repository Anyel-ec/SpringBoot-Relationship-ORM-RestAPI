package top.anyel.relations.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.anyel.relations.models.DepartmentLanguageAppd;
import top.anyel.relations.models.DepartmentLanguageKeyAppd;
import top.anyel.relations.repositories.DepartmentLanguageAppdRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentLanguageAppdService {
    @Autowired
    private DepartmentLanguageAppdRepository departmentLanguageAppdRepository;

    public List<DepartmentLanguageAppd> getAllDepartmentLanguages() {
        return departmentLanguageAppdRepository.findAll();
    }

    public Optional<DepartmentLanguageAppd> getDepartmentLanguageById(DepartmentLanguageKeyAppd idAppd) {
        return departmentLanguageAppdRepository.findById(idAppd);
    }

    public DepartmentLanguageAppd saveDepartmentLanguage(DepartmentLanguageAppd departmentLanguageAppd) {
        return departmentLanguageAppdRepository.save(departmentLanguageAppd);
    }

    public List<DepartmentLanguageAppd> saveDepartmentLanguages(List<DepartmentLanguageAppd> departmentLanguagesAppd) {
        return departmentLanguageAppdRepository.saveAll(departmentLanguagesAppd);
    }

    public void deleteDepartmentLanguage(DepartmentLanguageKeyAppd idAppd) {
        departmentLanguageAppdRepository.deleteById(idAppd);
    }
}
