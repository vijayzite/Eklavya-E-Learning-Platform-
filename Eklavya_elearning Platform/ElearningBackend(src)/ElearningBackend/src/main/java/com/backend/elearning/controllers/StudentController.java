package com.backend.elearning.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.elearning.models.Course;
import com.backend.elearning.models.CourseByCatIdData;
import com.backend.elearning.models.EnrolledCourseData;
import com.backend.elearning.models.EnrolledCourses;
import com.backend.elearning.services.EnrolledCoursesService;
import com.backend.elearning.services.StudentService;

@RestController
@RequestMapping("/api/elearning")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private EnrolledCoursesService enrolledCoursesService;
	
	@PostMapping("student/getcourses/{courseCatId}")
	public List<CourseByCatIdData> getCoursesListByCatID(@PathVariable Long courseCatId) {

		List<CourseByCatIdData> cList = new ArrayList<CourseByCatIdData>();

		List<Course> cl = studentService.getAllCoursesListByCatId(courseCatId);

		for (Course course : cl) {

			CourseByCatIdData cd = new CourseByCatIdData();

			cd.setCourseId(course.getCourseId());
			cd.setCourseTitle(course.getCourseTitle());
			cd.setCourseDesc(course.getCourseDesc());
			cd.setCourseType(course.getCourseType());
			cd.setCoursePrice(course.getCoursePrice());
			cd.setCourseCategory(course.getCourseCategory().getCourseCatId());
			cd.setUser(course.getUser().getUserId());
			cd.setIsDisabled(false);

			cList.add(cd);

		}
		return cList;
	}
	
	@PostMapping("/student/enrolled/courses/{userId}")
	public List<EnrolledCourseData> getEnrolledCoursesList(@PathVariable Long userId) {

		List<EnrolledCourseData> cList = new ArrayList<EnrolledCourseData>();

		List<EnrolledCourses> cl = enrolledCoursesService.getEnrollmentByUserID(userId);

		for (EnrolledCourses course : cl) {

			EnrolledCourseData cd = new EnrolledCourseData();

			cd.setEnrollId(course.getEnrollId());
			cd.setCourseTitle(course.getCourseTitle());
			cd.setCourseType(course.getCourseType());
			cd.setuId(course.getuId());
			cd.setcId(course.getcId()); // course id

			cList.add(cd);

		}

		return cList;

	}

	// save course enrollment and email
	@PostMapping("/student/enrollment")
	public String saveCourseEnrollment(@RequestBody EnrolledCourses course) {

		// enroll list of courses
		enrolledCoursesService.saveCourseEnroll(course);

		// send email

		return "Course enrolled successfully";

	}
}
