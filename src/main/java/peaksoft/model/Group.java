package peaksoft.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.CascadeType.PERSIST;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "group_name")
    private String groupName;
    private String dateOfStart;
    private String dateOfFinish;
    @Transient
    private String courseName;

    @ManyToMany(cascade = {REFRESH,MERGE,PERSIST}, fetch = FetchType.EAGER)
    @JoinTable(name = "course_group", joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;

    @OneToMany(cascade = ALL, fetch = FetchType.LAZY, mappedBy = "groups")
    private List<Student> students;

    @ManyToOne(cascade = {REFRESH,MERGE,DETACH,PERSIST})
    @JoinColumn(name = "company_id")
    private Company company;

    public void setCourses(Course course) {
        if (courses == null) {
            courses = new ArrayList<>();
        }
        courses.add(course);
    }
}
