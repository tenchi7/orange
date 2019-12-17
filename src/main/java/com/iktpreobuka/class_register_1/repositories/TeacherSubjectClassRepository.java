package com.iktpreobuka.class_register_1.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.class_register_1.entities.SchoolClassEntity;
import com.iktpreobuka.class_register_1.entities.TeacherSubjectClassEntity;
import com.iktpreobuka.class_register_1.entities.TeacherSubjectEntity;

public interface TeacherSubjectClassRepository extends CrudRepository<TeacherSubjectClassEntity, Integer> {
	
	List<TeacherSubjectClassEntity> findByTeacherSubject(TeacherSubjectEntity teacherSubject);
	
	TeacherSubjectClassEntity findByTeacherSubjectAndSchoolClass(TeacherSubjectEntity teacherSubject, SchoolClassEntity schoolClass);

}
