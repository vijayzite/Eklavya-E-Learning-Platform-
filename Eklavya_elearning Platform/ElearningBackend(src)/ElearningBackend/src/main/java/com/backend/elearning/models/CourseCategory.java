package com.backend.elearning.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="course_category")
public class CourseCategory {

	  @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Integer course_cat_id;
	  
	  @Column
	    private String course_cat_name;

	    @OneToMany(mappedBy = "courseCategory")
		private List<Course> cources;

		public CourseCategory() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		public CourseCategory(Integer i) {
			super();
			this.course_cat_id = i;
			// TODO Auto-generated constructor stub
		}


		public CourseCategory(Integer course_cat_id, String course_cat_name, List<Course> cources) {
			super();
			this.course_cat_id = course_cat_id;
			this.course_cat_name = course_cat_name;
			this.cources = cources;
		}


		public Integer getCourseCatId() {
			return course_cat_id;
		}


		public void setCourseCatId(Integer courseCatId) {
			this.course_cat_id = courseCatId;
		}


		public String getCourseCatName() {
			return course_cat_name;
		}


		public void setCourseCatName(String course_cat_name) {
			this.course_cat_name = course_cat_name;
		}


		public List<Course> getCources() {
			return cources;
		}


		public void setCources(List<Course> cources) {
			this.cources = cources;
		}


		@Override
		public String toString() {
			return "CourseCategory [courseCatId=" + course_cat_id + ", courseCatName=" + course_cat_name + ", cources="
					+ cources + "]";
		}

	    
	    
	
}
