package com.in28minutes.springboot.learnjpaandhibernate.course.jdbc;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    private final CourseJdbcRepository courseJdbcRepository;

    @Override
    public void run(String... args) throws Exception {
        courseJdbcRepository.insert(Course.builder().name("Learn JPA and Hibernate").author("in28minutes").build());
        courseJdbcRepository.insert(Course.builder().name("Learn ORM").author("in28minutes1").build());
        courseJdbcRepository.delete(1L);

        System.out.println(courseJdbcRepository.findById(4));
        System.out.println(courseJdbcRepository.findById(5));
        System.out.println(courseJdbcRepository.findById(7));
    }
}
