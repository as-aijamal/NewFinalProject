package peaksoft.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.CascadeType.REMOVE;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "course_name")
    private String courseName;
    private String duration;

    @ManyToOne(cascade = {PERSIST, REFRESH, DETACH, MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToMany(cascade = {PERSIST, MERGE, REFRESH, DETACH, REMOVE}, fetch = FetchType.LAZY, mappedBy = "courses")
    private List<Group> groups;

    @OneToOne(cascade = {PERSIST, REFRESH, MERGE, DETACH, REMOVE}, fetch = FetchType.EAGER, mappedBy = "course")
    private Teacher teacher;

}
