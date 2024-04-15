package com.backend.elearning.services;

import java.util.List;

import com.backend.elearning.models.Course;
import com.backend.elearning.models.SubTopic;
import com.backend.elearning.models.Chapter;


public interface StudentService {

	public List<Course> getAllCoursesListByCatId(Long id);
	
	
	
}
