

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

import com.backend.elearning.models.Approve;
import com.backend.elearning.models.User;
import com.backend.elearning.models.UserData;
import com.backend.elearning.services.RegisterService;
import com.backend.elearning.repositories.CourseRepository;
import com.backend.elearning.repositories.EnrollDetailsRepository;
import com.backend.elearning.repositories.OrderRepository;
import com.backend.elearning.repositories.RegisterRepository;

@RestController	
@RequestMapping("/api/elearning")
public class AuthController {
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
    @Autowired
    private RegisterService registerService;

	@Autowired
	private EnrollDetailsRepository enrollDetailsRepository;
    
    @Autowired
	private RegisterRepository registerRepository;

    @PostMapping("/register")
	public String userRegistration(@RequestBody User userToRegister) {
		System.out.println("request hit" + userToRegister.toString());
		return registerService.register(userToRegister);
	}
    
    @PostMapping("/login")
    public String userLogin(@RequestBody User obj) {
		System.out.println("inside login");
		String username = obj.getUserName();
		String uname = registerService.getUserName(username);
		System.out.println(username + " " + uname);
		
		if (uname == null) {
			return "";
		} else if(uname.equals(username)) {
			String pass = obj.getPass();
			String pwd = registerService.getPassword(uname);
			if (pwd == null) {
				return "";
			}
			if (pwd.equals(pass)) {
				// get role id
				Integer roleid = registerService.getUserRoleId(uname);
				return uname;
			} else {
				return "";
			}
		}else {
			return "";
		}
	}

    @PostMapping("/rolename")
	public String getUserRoleName(@RequestBody User user) {
		System.out.println("rolename=" + user.getUserName());
		return registerService.getUserRoleName(user.getUserName());
	}

    @PostMapping("/user/getuid/{userInfo}")
	public String getUserIdByUserName(@PathVariable String userInfo) {
		String result = registerService.getUserIDByUserName(userInfo);
		return result;
	}

	@PostMapping("/getuid")
	public String getUserIdByUserName(@RequestBody User user) {
		System.out.println("username=" + user.getUserName());
		String result = registerService.getUserIDByUserName(user.getUserName());
		System.out.println(result);
		return result;
	}
	
//	@GetMapping("/admin/users")
//	public List<UserData> getAllUsers() {
//
//		List<UserData> userList = new ArrayList<UserData>();
//
//		List<User> uList = registerService.getAllUsersList();
//
//		for (User us : uList) {
//
//			UserData u = new UserData();
//
//			u.setUserId(us.getUserId());
//			u.setUserName(us.getUserName());
//			u.setFirstName(us.getFirstName());
//			u.setLastName(us.getLastName());
//			u.setPhoneNo(us.getPhoneNo());
//			u.setEmail(us.getEmail());
//
//			userList.add(u);
//		}
//
//		return userList;
//	}
	
	@DeleteMapping("admin/deleteuser/{id}")
	public String deleteUser(@PathVariable Long id) {
		registerService.deleteUserByID(id);
		return "User with id " + id + " has been deleted successfully.";
	}
	
	@GetMapping("/admin/inctruct/count")
	public String getTotalInstrutors() {
		return registerRepository.getUserCount(2);
	}

	@GetMapping("/admin/students/count")
	public String getTotalStudents() {
		return registerRepository.getUserCount(3);
	}

	@GetMapping("/admin/totalcourscnt/")
	public String getTotalCourses() {
		return courseRepository.getCourseCount();
	}

	@GetMapping("/instruct/totalcourses/{uid}")
	public String getTotalCoursesByInstructId(@PathVariable Long uid) {
		System.out.println("in c count");
		return courseRepository.getCourseCountByInstructorId(uid);
	}

	@GetMapping("/instruct/enroll/{uid}")
	public String getTotalEnrollByInstructId(@PathVariable Long uid) {
		return courseRepository.getCourseCountByInstructorId(uid);
	}
	
	@GetMapping("/revenue/{uid}")
	public Float getTotalRevenuByInstructId(@PathVariable Long uid) {
		System.out.println("revenue: " + uid + " " + orderRepository.getTotalSumById(uid));
		return enrollDetailsRepository.findTotalRevenue(uid);
	}
}
