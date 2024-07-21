package top.anyel.relations.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "departments_languagesAppd")
public class DepartmentLanguageAppd {

    @EmbeddedId
    private DepartmentLanguageKeyAppd idAppd;

    @ManyToOne
    @MapsId("departmentIdAppd")
    @JoinColumn(name = "department_idAppd", insertable = false, updatable = false)
    private DepartmentAppd departmentAppd;

    @ManyToOne
    @MapsId("languageIdAppd")
    @JoinColumn(name = "language_idAppd", insertable = false, updatable = false)
    private LanguageAppd languageAppd;

    private String descriptionAppd;
    private String nameAppd;

}
