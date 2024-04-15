package com.backend.elearning.models;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ord_id;

	@Column(name = "username")
	private String username;

	@Column(name = "total_amt")
	private Float totalAmt;

	@Column(name = "ord_date")
	private String ordDate;

	@ManyToOne
	private User user;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "course_id")
	private Course course;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(Integer ord_id) {
		super();
		this.ord_id = ord_id;
		// TODO Auto-generated constructor stub
	}

	public Order(Integer ord_id,Course course, String username, Float totalAmt, String ordDate, User user) {
		super();
		this.ord_id = ord_id;
		this.username = username;
		this.totalAmt = totalAmt;
		this.ordDate = ordDate;
		this.user = user;
		this.course=course;
	}
	
	
	public Integer getOrd_id() {
		return ord_id;
	}

	public void setOrd_id(Integer ord_id) {
		this.ord_id = ord_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Integer getOrdId() {
		return ord_id;
	}

	public void setOrdId(Integer ord_id) {
		this.ord_id = ord_id;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public Float getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(Float totalAmt) {
		this.totalAmt = totalAmt;
	}

	public String getOrdDate() {
		return ordDate;
	}

	public void setOrdDate(String ordDate) {
		this.ordDate = ordDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}


