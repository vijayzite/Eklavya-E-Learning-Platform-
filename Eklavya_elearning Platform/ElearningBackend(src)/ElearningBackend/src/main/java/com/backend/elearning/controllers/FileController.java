package com.backend.elearning.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.backend.elearning.fileupload.FileResponce;
import com.backend.elearning.models.Course;
import com.backend.elearning.models.SubTopic;
import com.backend.elearning.models.SubTopicData;
import com.backend.elearning.models.Chapter;
import com.backend.elearning.models.User;
import com.backend.elearning.services.FileService;
import com.backend.elearning.services.InstructorService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/elearning")
public class FileController {

    @Autowired
    private FileService fileService;
    @Autowired
	private InstructorService instructorService;

    @Value("${project.image}")
    private String imagePath; // getting file path from properties where image will store

    @PostMapping("/file/uploadimg")
    public ResponseEntity<FileResponce> uploadFile(@RequestParam("image") MultipartFile image,
                                                    @RequestParam("courseId") Course courseId,
                                                    @RequestParam("userId") User userId,
                                                    @RequestParam("chapterId") Chapter chapterId,
                                                    @RequestParam("subtId") SubTopic subtId) {
    	System.out.println("file moule responce:");
		System.out.println("cid:" + courseId.getCourseId());
//		System.out.println("cid:" + userID);
		System.out.println("file name full:" + image.getOriginalFilename());

		String fileName = null;
        try {
            fileName = fileService.uploadImage(imagePath, image, courseId, userId, chapterId, subtId);
            return new ResponseEntity<>(new FileResponce(fileName, "Image uploaded successfully"), HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(new FileResponce(null, "Failed to upload image"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping("/subtdata/{sId}")
	public List<SubTopicData> getSubtsInCourseBySID(@PathVariable Long sId) {

		List<SubTopicData> stopicList = new ArrayList<SubTopicData>();

		//List<SubTopic> cl = studentService.getAllSubtListByChaptId(sId);
		
		 List<String> stList = instructorService.getSubtopicListByCourseID(sId);

		for (String sbt : stList) {
		
			SubTopicData stdata = new SubTopicData();
		

			// split
			String[] arrOfStr = sbt.split(",");
			String id = arrOfStr[0];
			String tit = arrOfStr[1];
			// String indno = arrOfStr[2];

			stdata.setSubtId(Long.parseLong(id));
			stdata.setSubtTitle(tit);
		//stdata.setSubtIndexNo(indno);
		//stdata.setSubtId(sbt.getSubtId());
		//stdata.setSubtId(sbt.getSubtId());
		
		//System.out.println(sbt.getSubtTitle());
		//	stopicList.add(stopicList );
			stopicList.add(stdata);
		
		}
//		for (String subt : cl) {
//
//			SubTopicData cd = new SubTopicData();
//
//			cd.setSubtId(subt.getSubtId());
//			cd.setSubtTitle(subt.getSubtTitle());
//			cList.add(cd);
//			
//		}
		return stopicList;
}

 // download image
// 	@GetMapping(value = "/download/{imageName}", produces = MediaType.MULTIPART_FORM_DATA_VALUE)
// 	public void downloadImage(@PathVariable("imageName") String imageName, HttpServletResponse response)
// 			throws IOException {
// 		System.out.println("in download file");
// 		InputStream resource = fileService.getResources(imagePath, imageName);
// 		response.setContentType(MediaType.MULTIPART_FORM_DATA_VALUE);
//
// 		StreamUtils.copy(resource, response.getOutputStream());
// 	}
}

