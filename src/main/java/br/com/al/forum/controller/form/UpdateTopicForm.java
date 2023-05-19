package br.com.al.forum.controller.form;

import org.hibernate.validator.constraints.Length;

import br.com.al.forum.model.Course;
import br.com.al.forum.model.Topic;
import br.com.al.forum.repository.CourseRepository;
import br.com.al.forum.repository.TopicRepository;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UpdateTopicForm {

    @NotNull
    @NotBlank
    @Length(min = 5)
    private String title;
    @NotNull
    @NotBlank
    @Length(min = 10)
    private String message;

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

    public Topic update(Long id, TopicRepository topicRepository) {
        Topic topic = topicRepository.getReferenceById(id);
        topic.setTitle(this.title);
        topic.setMessage(this.message);
        return topic;
    }

}
