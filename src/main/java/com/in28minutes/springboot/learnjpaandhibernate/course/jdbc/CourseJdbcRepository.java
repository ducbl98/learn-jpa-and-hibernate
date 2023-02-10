package com.in28minutes.springboot.learnjpaandhibernate.course.jdbc;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CourseJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    private static String INSERT_COURSE = "INSERT INTO COURSE (NAME, AUTHOR) VALUES (?, ?)";
    private static String DELETE_COURSE = "DELETE FROM COURSE WHERE ID = ?";
    private static String SELECT_COURSE = "SELECT * FROM COURSE WHERE ID = ?";

    public void insert(Course course) {
        jdbcTemplate.update(INSERT_COURSE, course.getName(), course.getAuthor());
    }

    public void delete(long id) {
        jdbcTemplate.update(DELETE_COURSE, id);
    }

    public Course findById(long id) {
        return jdbcTemplate.queryForObject(SELECT_COURSE, new Object[] {id}, (rs, rowNum ) -> {
            Course course = new Course();
            course.setId(rs.getLong("id"));
            course.setName(rs.getString("name"));
            course.setAuthor(rs.getString("author"));
            return course;
        });
    }
}
