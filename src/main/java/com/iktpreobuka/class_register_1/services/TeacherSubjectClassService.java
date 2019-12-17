package com.iktpreobuka.class_register_1.services;

import java.util.List;

import com.iktpreobuka.class_register_1.entities.SchoolClassEntity;
import com.iktpreobuka.class_register_1.entities.TeacherSubjectClassEntity;
import com.iktpreobuka.class_register_1.entities.TeacherSubjectEntity;

public interface TeacherSubjectClassService {

	TeacherSubjectClassEntity saveTeacherSubjectClass(TeacherSubjectClassEntity teachSubClass);

	List<SchoolClassEntity> findByTeacherSubject(TeacherSubjectEntity teachSub);

	TeacherSubjectClassEntity findByTeacherSubjectAndSchoolCLass(TeacherSubjectEntity teachSub,
			SchoolClassEntity schoolClass);

}
