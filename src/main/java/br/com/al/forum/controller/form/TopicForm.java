package br.com.al.forum.controller.form;

import org.hibernate.validator.constraints.Length;

import br.com.al.forum.model.Course;
import br.com.al.forum.model.Topic;
import br.com.al.forum.repository.CourseRepository;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TopicForm {

    @NotNull
    @NotBlank
    @Length(min = 5)
    private String title;
    @NotNull
    @NotBlank
    @Length(min = 10)
    private String message;
    @NotNull
    @NotBlank
    private String courseName;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Topic convert(CourseRepository courseRepository) {
        Course course = courseRepository.findByName(courseName);
        return new Topic(title, message, course);
    }

}
