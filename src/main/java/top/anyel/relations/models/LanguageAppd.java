package top.anyel.relations.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "languagesAppd")
public class LanguageAppd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer languageIdAppd;

    private String nameAppd;
    private String codeAppd;

    @OneToMany(mappedBy = "languageAppd")
    private List<DepartmentLanguageAppd> departmentLanguagesAppd;
}
