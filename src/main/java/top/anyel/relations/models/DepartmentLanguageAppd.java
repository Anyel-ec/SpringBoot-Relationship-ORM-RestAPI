package top.anyel.relations.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "departments_languagesAppd")
@Data
public class DepartmentLanguageAppd {

    @EmbeddedId
    private DepartmentLanguageKeyAppd idAppd;

    @ManyToOne
    @MapsId("departmentIdAppd")
    @JoinColumn(name = "department_idAppd", nullable = false)
    private DepartmentAppd departmentAppd;

    @ManyToOne
    @MapsId("languageIdAppd")
    @JoinColumn(name = "language_idAppd", nullable = false)
    private LanguageAppd languageAppd;

    @Column(name = "description_appd")
    private String descriptionAppd;

    @Column(name = "name_appd")
    private String nameAppd;
}
