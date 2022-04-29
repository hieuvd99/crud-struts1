package com.example.model;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class User extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String username;
	private String phone;
	private String email;
	
	
	public User() {
	}

	public User(int id, String username, String phone, String email) {
		this.id = id;
		this.username = username;
		this.phone = phone;
		this.email = email;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors actionErrors = new ActionErrors();
		
		if(getUsername() == null || getUsername().length()==0) {
			actionErrors.add("user.name.required", new ActionMessage("username.not.entered"));
		}
		if(getPhone() == null || getPhone().length()==0) {
			actionErrors.add("user.phone.required", new ActionMessage("phone.not.entered"));
		}
		if(getUsername() == null || getUsername().length()==0) {
			actionErrors.add("user.email.required", new ActionMessage("email.not.entered"));
		}
		
		return actionErrors;
	}
}
