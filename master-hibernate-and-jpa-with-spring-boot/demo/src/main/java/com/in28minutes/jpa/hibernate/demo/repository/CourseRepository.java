package com.in28minutes.jpa.hibernate.demo.repository;

import com.in28minutes.jpa.hibernate.demo.entity.Course;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CourseRepository {

    @Autowired
    private EntityManager em;

    public Course findById(Long id){
        return em.find(Course.class, id);
    }

    public Course save(Course course) {
        if(course.getId() == null) {
            em.persist(course);
        } else {
            em.merge(course);
        }

        return course;
    }

    public boolean deleteById(Long id) {
        try{
            Course course = findById(id);
            em.remove(course);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public void playWithEntityManager() {
        // While we are in a transaction (@Transaction) entity manager will keep track of the changes e will persist
        // them in the database without needing to call the save method afterward
        Course course = new Course("Web Services in 100 Steps");
        em.persist(course);
        em.flush(); // The changes up to this point are saved in the database

        /*
         * The course will be removed from the persistence context which means that the further
         * changes will not be applied to the entity
         */
        // em.detach(course);

        course.setName("Web Services in 100 Steps - Updated");

        /*
         * The content of the course entity will be refreshed with it is present in the database.
         * Which means that any change applied that was not yet saved in the database will be reversed.
         */
        em.refresh(course);
    }

}
