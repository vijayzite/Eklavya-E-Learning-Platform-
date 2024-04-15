package com.backend.elearning.models;

import java.util.List;

public class CourseData {

	private Long courseId;

	private String courseTitle;

	private String courseDesc;

	private String courseType;

	private Float coursePrice;

	private String courseThumbPath;

	private String introVideoPath;

	private Long user;

	private Integer courseCategory;

	private List<Chapter> chapters;

	private List<SubTopic> subtopics;

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getCourseDesc() {
		return courseDesc;
	}

	public void setCourseDesc(String courseDesc) {
		this.courseDesc = courseDesc;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public Float getCoursePrice() {
		return coursePrice;
	}

	public void setCoursePrice(Float coursePrice) {
		this.coursePrice = coursePrice;
	}

	public String getCourseThumbPath() {
		return courseThumbPath;
	}

	public void setCourseThumbPath(String courseThumbPath) {
		this.courseThumbPath = courseThumbPath;
	}

	public String getIntroVideoPath() {
		return introVideoPath;
	}

	public void setIntroVideoPath(String introVideoPath) {
		this.introVideoPath = introVideoPath;
	}

	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
	}

	public Integer getCourseCategory() {
		return courseCategory;
	}

	public void setCourseCategory(Integer courseCategory) {
		this.courseCategory = courseCategory;
	}

	public List<Chapter> getTopics() {
		return chapters;
	}

	public void setTopics(List<Chapter> topics) {
		this.chapters = chapters;
	}

	public List<SubTopic> getSubtopics() {
		return subtopics;
	}

	public void setSubtopics(List<SubTopic> subtopics) {
		this.subtopics = subtopics;
	}

}
