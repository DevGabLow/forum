package br.com.al.forum.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.al.forum.model.Topic;

public class TopicDto {

    private Long id;
    private String title;
    private String message;
    private LocalDateTime createdAt;

    public TopicDto(Topic topic) {
        this.id = topic.getId();
        this.title = topic.getTitle();
        this.message = topic.getMessage();
        this.createdAt = topic.getCreatedAt();
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

    public static List<TopicDto> convert(List<Topic> topics) {
        return topics.stream().map(TopicDto::new).collect(Collectors.toList());
    }
}
