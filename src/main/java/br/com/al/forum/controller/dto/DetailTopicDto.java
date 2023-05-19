package br.com.al.forum.controller.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.al.forum.model.Answer;
import br.com.al.forum.model.Topic;
import br.com.al.forum.model.TopicStatus;

public class DetailTopicDto {

    private Long id;
    private String title;
    private String message;
    private LocalDateTime createdAt;
    private String authorName;
    private TopicStatus status;
    private List<AnswerDto> answers;

    public DetailTopicDto(Topic topic) {
        this.id = topic.getId();
        this.title = topic.getTitle();
        this.message = topic.getMessage();
        this.createdAt = topic.getCreatedAt();
        this.authorName = topic.getAuthor().getName();
        this.status = topic.getStatus();
        this.answers = new ArrayList<>();
        this.answers.addAll(topic.getAnswers().stream().map(AnswerDto::new).collect(Collectors.toList()));
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getAuthorName() {
        return authorName;
    }

    public TopicStatus getStatus() {
        return status;
    }

    public List<AnswerDto> getAnswers() {
        return answers;
    }

    public static List<DetailTopicDto> convert(List<Topic> topics) {
        return topics.stream().map(DetailTopicDto::new).collect(Collectors.toList());
    }
}
