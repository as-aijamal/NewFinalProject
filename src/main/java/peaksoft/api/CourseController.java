package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.request.CompanyRequest;
import peaksoft.dto.request.CourseRequest;
import peaksoft.dto.response.CompanyResponse;
import peaksoft.dto.response.CourseResponse;
import peaksoft.model.Company;
import peaksoft.model.Course;
import peaksoft.service.CompanyService;
import peaksoft.service.CourseService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses/{id}")
public class CourseController {

    private final CourseService courseService;
    private final CompanyService companyService;

    @PostMapping()
    public CourseResponse saveCourse(@RequestBody CourseRequest courseRequest, @PathVariable("id") Long id) {
       courseRequest.setCompany(companyService.getCompanyById(id));
        return courseService.saveCourse(courseRequest,id);
    }

    @PatchMapping("/update/{id}")
    public CourseResponse updateCourse(@PathVariable Long id, @RequestBody CourseRequest courseRequest) {
        return courseService.updateCourse(id, courseRequest);
    }

    @GetMapping("/get/{id}")
    public Optional<Course> getCourseById(@PathVariable Long id) {
        return courseService.findById(id);
    }

    @GetMapping()
    public List<CourseResponse> getAllCourses(List<Course>courseList) {
        return courseService.getCourses(courseList);
    }

    @DeleteMapping("{id}")
    public void deleteCourse(@PathVariable Long id){
        courseService.deleteCourse(id);
    }
}
