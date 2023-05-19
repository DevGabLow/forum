package br.com.al.forum.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.al.forum.controller.dto.DetailTopicDto;
import br.com.al.forum.controller.dto.TopicDto;
import br.com.al.forum.controller.form.TopicForm;
import br.com.al.forum.controller.form.UpdateTopicForm;
import br.com.al.forum.model.Topic;
import br.com.al.forum.repository.CourseRepository;
import br.com.al.forum.repository.TopicRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    public List<TopicDto> list(String courseName) {
        if (courseName == null) {
            List<Topic> topics = topicRepository.findAll();
            return TopicDto.convert(topics);
        } else {
            List<Topic> topics = topicRepository.findByCourseName(courseName);
            return TopicDto.convert(topics);
        }
    }

    @PostMapping
    @Transactional
    public ResponseEntity<TopicDto> create(@RequestBody @Valid TopicForm form, UriComponentsBuilder uriBuilder) {
        Topic topic = form.convert(courseRepository);
        topicRepository.save(topic);
        URI uri = uriBuilder.path("/topics/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicDto(topic));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicDto> update(@PathVariable Long id, @RequestBody @Valid UpdateTopicForm form) {

        Optional<Topic> optional = topicRepository.findById(id);
        if (optional.isPresent()) {
            Topic topic = form.update(id, topicRepository);
            return ResponseEntity.ok(new TopicDto(topic));

        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remove(@PathVariable Long id) {
        Optional<Topic> topic = topicRepository.findById(id);
        if (topic.isPresent()) {
            topicRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailTopicDto> findOne(@PathVariable Long id) {
        Optional<Topic> topic = topicRepository.findById(id);
        if (topic.isPresent()) {
            return ResponseEntity.ok(new DetailTopicDto(topic.get()));
        }
        return ResponseEntity.notFound().build();
    }
}
