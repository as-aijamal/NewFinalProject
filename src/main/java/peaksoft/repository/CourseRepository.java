package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long > {
}
