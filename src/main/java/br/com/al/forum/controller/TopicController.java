package br.com.al.forum.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.al.forum.controller.dto.TopicDto;
import br.com.al.forum.model.Course;
import br.com.al.forum.model.Topic;

@RestController
public class TopicController {

    @RequestMapping("/topic")
    public List<TopicDto> list() {
        Topic topic = new Topic("First", "This first topic.", new Course("Spring", "Programming"));
        return TopicDto.convert(Arrays.asList(topic, topic, topic));
    }
}
