package com.example.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import com.example.model.User;
import com.example.service.UserService;

public class UserAction extends MappingDispatchAction{
	
	private UserService userService;
	
	public UserAction() {
		userService = new UserService();
	}

	public ActionForward getAllUser(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		List<User> user = userService.getListUser();
		request.setAttribute("listUser", user);
		return mapping.findForward("getAllUser");
	}
	
	public ActionForward addUserPost(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		User user = (User)form;
		int result = userService.addUser(user);
		if(result<=0){
			request.setAttribute("message-addUser", "Something wrong! Cannot add user");
		}else{
			request.setAttribute("message-addUser", "Add new user success!");
		}
		
		return mapping.findForward("addUserPost");
	}
	
	public ActionForward editUser(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		int id = Integer.valueOf(request.getParameter("userId"));
		User user = userService.getByUserId(id);
		request.setAttribute("user", user);
		return mapping.findForward("editUser");
	}
	
	public ActionForward editUserPost(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		User user = (User)form;
		int result = userService.editUser(user);
		if(result <= 0){
			request.setAttribute("message-editUser", "Something wrong! Cannot edit user");
		}else{
			request.setAttribute("message-editUser", "Edit user sucess!");
		}
		return mapping.findForward("editUserPost");
	}
	
	public ActionForward deleteUser(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		int id = Integer.valueOf(request.getParameter("userId"));
		userService.deleteUser(id);
		
		return mapping.findForward("deleteUser");
	}
}
