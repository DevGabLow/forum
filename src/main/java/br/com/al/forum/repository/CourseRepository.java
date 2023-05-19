package br.com.al.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.al.forum.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Course findByName(String name);
}
