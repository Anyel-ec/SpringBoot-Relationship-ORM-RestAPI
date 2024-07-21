package top.anyel.relations.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.anyel.relations.models.LanguageAppd;
import top.anyel.relations.repositories.LanguageAppdRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageAppdService {
    @Autowired
    private LanguageAppdRepository languageAppdRepository;

    public List<LanguageAppd> getAllLanguages() {
        return languageAppdRepository.findAll();
    }

    public Optional<LanguageAppd> getLanguageById(Integer id) {
        return languageAppdRepository.findById(id);
    }

    public LanguageAppd saveLanguage(LanguageAppd languageAppd) {
        return languageAppdRepository.save(languageAppd);
    }

    public List<LanguageAppd> saveLanguages(List<LanguageAppd> languagesAppd) {
        return languageAppdRepository.saveAll(languagesAppd);
    }

    public void deleteLanguage(Integer id) {
        languageAppdRepository.deleteById(id);
    }
}
