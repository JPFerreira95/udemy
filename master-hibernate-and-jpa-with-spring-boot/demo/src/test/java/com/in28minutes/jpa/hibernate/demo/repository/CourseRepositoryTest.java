package com.in28minutes.jpa.hibernate.demo.repository;

import com.in28minutes.jpa.hibernate.demo.DemoApplication;
import com.in28minutes.jpa.hibernate.demo.entity.Course;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class) // Allows JUnit to have access to the Spring application, otherwise the tests will fail
@SpringBootTest(classes = DemoApplication.class)
class CourseRepositoryTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepository courseRepository;

	@Test
	public void findById_basic() {
		Course course = courseRepository.findById(1001L);
		assertEquals("JPA in 100 Steps", course.getName());
	}

	@Test
	@DirtiesContext // After running the test, spring will reset the data. Invalidating the changes made by the method
	public void deleteById_basic() {
		assertTrue(courseRepository.deleteById(1001L)); // This is changing the state of the data
	}

	@Test
	@DirtiesContext
	public void save_basicNameUpdate() {
		// Get a course
		Course course = courseRepository.findById(1001L);
		assertEquals("JPA in 100 Steps", course.getName());

		// Update details
		course.setName("JPA in 50 Steps - Updated");

		// save changes
		courseRepository.save(course);

		// Check value
		Course course1 = courseRepository.findById(1001L);
		assertEquals("JPA in 50 Steps - Updated", course1.getName());
	}

	@Test
	@DirtiesContext
	public void playWithEntityManager() {
		logger.info("playWithEntityManager - start");
	}


}
