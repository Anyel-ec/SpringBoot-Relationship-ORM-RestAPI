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

    public Optional<DepartmentLanguageAppd> getDepartmentLanguageById(DepartmentLanguageKeyAppd id) {
        return departmentLanguageAppdRepository.findById(id);
    }

    public DepartmentLanguageAppd saveDepartmentLanguage(DepartmentLanguageAppd departmentLanguageAppd) {
        return departmentLanguageAppdRepository.save(departmentLanguageAppd);
    }

    public void deleteDepartmentLanguage(DepartmentLanguageKeyAppd id) {
        departmentLanguageAppdRepository.deleteById(id);
    }
}
