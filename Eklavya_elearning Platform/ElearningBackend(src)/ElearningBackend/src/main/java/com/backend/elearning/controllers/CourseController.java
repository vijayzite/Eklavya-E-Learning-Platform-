package com.backend.elearning.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.elearning.models.Course;
import com.backend.elearning.models.CourseData;
import com.backend.elearning.models.EnrolledCourseData;
import com.backend.elearning.models.EnrolledCourses;
import com.backend.elearning.models.SubTopic;
import com.backend.elearning.models.SubTopicData;
import com.backend.elearning.models.User;
import com.backend.elearning.repositories.ApproveRepository;
import com.backend.elearning.repositories.CourseRepository;
import com.backend.elearning.models.Approve;
import com.backend.elearning.models.ApproveData;
import com.backend.elearning.models.Chapter;
import com.backend.elearning.models.ChaptersData;
import com.backend.elearning.services.ApproveService;
import com.backend.elearning.services.CourseService;
import com.backend.elearning.services.EnrolledCoursesService;
import com.backend.elearning.services.InstructorService;

@RestController
@RequestMapping("/api/elearning")
public class CourseController {

    @Autowired
    private InstructorService instructorService;
   
	@Autowired
	private CourseRepository courseRepository;
	

	@Autowired
	private ApproveRepository aprooveRepository;

    @Autowired
    private CourseService courseService;
    
    @Autowired
	private ApproveService approveService;
    

	@Autowired
	private EnrolledCoursesService enrolledCoursesService;

    @PostMapping("/addcourse")
    public String addNewCourse(@RequestBody Course course) {
        return instructorService.saveCourse(course);
    }

    @PostMapping("/addchapter")
    public String addNewChapter(@RequestBody Chapter chapter) {
        return instructorService.saveChapter(chapter);
    }

    @PostMapping("/addsubtopic")
    public String addNewSubtopic(@RequestBody SubTopic subtopic) {
        return instructorService.saveSubtopic(subtopic);
    }
    
    @PostMapping("/getcourses")
	public List<String> getCoursesList(@RequestBody User user) {
		System.out.println("id:" + user.getUserId());
		return instructorService.getCoursesListByInstructorID(user.getUserId());
	}

	@PostMapping("/getchapters")
	public List<String> getChaptersList(@RequestBody Course course) {
		System.out.println("id:" + course.getCourseId());
		return instructorService.getChaptersListByCourseID(course.getCourseId());
	}
	
	public List<SubTopicData> getSubtsInCourseBySID(@PathVariable Long sId) {

		List<SubTopicData> stopicList = new ArrayList<SubTopicData>();

//		List<SubTopic> cl = studentService.getAllSubtListByChaptId(sId);

		List<String> stList = instructorService.getSubtopicListByCourseID(sId);

		for (String sbt : stList) {
////		
			SubTopicData stdata = new SubTopicData();
////		

			// split
			String[] arrOfStr = sbt.split(",");

			String id = arrOfStr[0];
			String tit = arrOfStr[1];
			// String indno = arrOfStr[2];

			stdata.setSubtId(Long.parseLong(id));
			stdata.setSubtTitle(tit);
//		stdata.setSubtIndexNo(indno);
////		stdata.setSubtId(sbt.getSubtId());
////		stdata.setSubtId(sbt.getSubtId());
////		
//		System.out.println(sbt.getSubtTitle());
//		stopicList.add(stopicList );
			stopicList.add(stdata);
////		
		}

//		for (String subt : cl) {
//
//			SubTopicData cd = new SubTopicData();
//
//			cd.setSubtId(subt.getSubtId());
//			cd.setSubtTitle(subt.getSubtTitle());
//			
//
//			cList.add(cd);
//
//			
//			
//		}

		return stopicList;

	}
	
	// get chapters data for perticular course
		@PostMapping("/chaptersdata/{cId}")
		public List<ChaptersData> getChaptersInCourseByCID(@PathVariable Long cId) {

			List<ChaptersData> cList = new ArrayList<ChaptersData>();

			List<Chapter> cl = instructorService.getChapListByCourseID(cId);

			for (Chapter ch : cl) {

				ChaptersData cd = new ChaptersData();

				cd.setChapterId(ch.getChapterId());
				cd.setChapterTitle(ch.getChapterTitle());
				cd.setChapterIndexNo(ch.getChapterIndexNo());
				cd.setChapterDesc(ch.getChapterDesc());
				cd.setChapterThumbPath(ch.getChapterThumbPath());
				cd.setChapterFilePath(ch.getChapterFilePath());
				cd.setChapterVideoPath(ch.getChapterVideoPath());
				// cd.setCourseId(ch.getChapterId());

				// set subtopics list
				List<SubTopicData> stopicList = new ArrayList<SubTopicData>();

				List<String> stList = instructorService.getSubtopicListByCourseID(ch.getChapterId());

				System.out.println("chapter" + stList.toString());

				for (String sbt : stList) {
////					
					SubTopicData stdata = new SubTopicData();
////					

					// split
					String[] arrOfStr = sbt.split(",");

					String id = arrOfStr[0];
					String tit = arrOfStr[1];
					String indno = arrOfStr[2];

					stdata.setSubtId(Long.parseLong(id));
					stdata.setSubtTitle(tit);
					stdata.setSubtIndexNo(indno);
////					stdata.setSubtId(sbt.getSubtId());
////					stdata.setSubtId(sbt.getSubtId());
////					
//					System.out.println(sbt.getSubtTitle());
//					stopicList.add(stopicList );
					stopicList.add(stdata);
////					
				}

				cd.setSubtpics(stopicList);

				cList.add(cd);

			}

			return cList;

		}

		@GetMapping("/admin/courses")
		public List<CourseData> getPlantsList() {

			List<CourseData> cList = new ArrayList<CourseData>();

			List<Course> cl = courseRepository.findAll();

			for (Course course : cl) {

				CourseData cd = new CourseData();

				cd.setCourseId(course.getCourseId());
				cd.setCourseTitle(course.getCourseTitle());
				cd.setCourseDesc(course.getCourseDesc());
				cd.setCourseType(course.getCourseType());
				cd.setCoursePrice(course.getCoursePrice());
				cd.setCourseCategory(course.getCourseCategory().getCourseCatId());
				cd.setUser(course.getUser().getUserId());

				cList.add(cd);

			}

			return cList;

		}
		
		// delete
		@DeleteMapping("/admin/deleteplant/{id}")
		public String deletePlant(@PathVariable Long id) {
			return courseService.deleteCourseByID(id);
		}
		
		@GetMapping("/admin/approve/instructor")
		public List<ApproveData> getApproveList() {
			System.out.println("in call");

			List<ApproveData> cList = new ArrayList<ApproveData>();

			List<Approve> aList = approveService.getApproveListByUserID();

			for (Approve apr : aList) {

				ApproveData cd = new ApproveData();

				cd.setApvId(apr.getApvId());
				cd.setCerti(apr.getCerti());
				cd.setDesc(apr.getDesc());
				cd.setQualification(apr.getQualification());
				cd.setExp(apr.getExp()); // course id
				cd.setStatus(apr.getStatus()); // course id
				cd.setUiId(apr.getUiId()); // course id

				cList.add(cd);
			}
			return cList;
		}
		
		@PostMapping("/instructor/getapprove")
		public String getApprove(@RequestBody Approve approve) {

			aprooveRepository.save(approve);
			return "Your request submitted for approval.";
		}
		
		@PutMapping("/admin/approveuser")
		public String setApproveRequest(@RequestBody Approve approve) {

			aprooveRepository.save(approve);
			return "User approved sucessfully.";
		}

		@GetMapping("/admin/aprovestatus/{uid}")
		public String getApproveStatus(@PathVariable Long uid) {
			return aprooveRepository.findUserStatus(uid);
		}
//		
//		@PostMapping("/student/enrolled/courses/{userId}")
//		public List<EnrolledCourseData> getEnrolledCoursesList(@PathVariable Long userId) {
//
//			List<EnrolledCourseData> cList = new ArrayList<EnrolledCourseData>();
//
//			List<EnrolledCourses> cl = enrolledCoursesService.getEnrollmentByUserID(userId);
//
//			for (EnrolledCourses course : cl) {
//
//				EnrolledCourseData cd = new EnrolledCourseData();
//
//				cd.setEnrollId(course.getEnrollId());
//				cd.setCourseTitle(course.getCourseTitle());
//				cd.setCourseType(course.getCourseType());
//				cd.setuId(course.getuId());
//				cd.setcId(course.getcId()); // course id
//
//				cList.add(cd);
//
//			}
//
//			return cList;
//		}
		
		
}
