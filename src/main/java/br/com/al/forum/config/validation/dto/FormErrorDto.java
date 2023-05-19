package br.com.al.forum.config.validation.dto;

public class FormErrorDto {

    private String input;

    private String error;

    public FormErrorDto() {
    }

    public FormErrorDto(String input, String error) {
        this.input = input;
        this.error = error;
    }

    public String getInput() {
        return input;
    }

    public String getError() {
        return error;
    }

}
