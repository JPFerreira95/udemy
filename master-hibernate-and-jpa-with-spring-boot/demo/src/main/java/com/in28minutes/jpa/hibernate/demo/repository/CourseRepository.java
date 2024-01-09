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

    public boolean deleteById(Long id) {
        try{
            Course course = findById(id);
            em.remove(course);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
