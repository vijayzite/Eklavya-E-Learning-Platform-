package com.backend.elearning.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "approve")
public class Approve {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long apvId;

	@Column(name = "qualification")
	private String qualification;

	@Column(name = "experience")
	private String experience;

	@Column(name = "certifications")
	private String certifications;

	@Column(name = "description")
	private String desc;
	
	@Column(name = "u_status")
	private String status;
	
	@Column(name = "user_id")
	private Long uiId;

	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getUiId() {
		return uiId;
	}

	public void setUiId(Long uiId) {
		this.uiId = uiId;
	}

	public Long getApvId() {
		return apvId;
	}

	public void setApvId(Long apvId) {
		this.apvId = apvId;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getExp() {
		return experience;
	}

	public void setExp(String experience) {
		this.experience = experience;
	}

	public String getCerti() {
		return certifications;
	}

	public void setCerti(String certifications) {
		this.certifications = certifications;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
