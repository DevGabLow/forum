package br.com.al.forum.controller.dto;

import java.time.LocalDateTime;

import br.com.al.forum.model.Answer;

public class AnswerDto {

    private Long id;

    private String message;

    private LocalDateTime createdAt;

    private String authorName;

    public AnswerDto(Answer answer) {
        this.id = answer.getId();
        this.message = answer.getMessage();
        this.createdAt = answer.getCreatedAt();
        this.authorName = answer.getAuthor().getName();
    }

    public Long getId() {
        return id;
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

}
