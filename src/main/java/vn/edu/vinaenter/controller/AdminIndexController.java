package vn.edu.vinaenter.controller;


import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import vn.edu.vinaenter.model.bean.User;
import vn.edu.vinaenter.model.dao.CategoryDAO;
import vn.edu.vinaenter.model.dao.ContactDAO;
import vn.edu.vinaenter.model.dao.LandDAO;
import vn.edu.vinaenter.model.dao.UserDAO;

@Controller
public class AdminIndexController {

	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private LandDAO landDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private ContactDAO contactDAO;
	
	@GetMapping("admincp")
	public String index(HttpServletRequest request,ModelMap modelMap, Principal principal ) {
		
		
		int countCat = categoryDAO.count();
		modelMap.addAttribute("countCat", countCat);
		
		int countland = landDAO.count();
		modelMap.addAttribute("countland", countland);
		
		int countuser = userDAO.count();
		modelMap.addAttribute("countuser", countuser);
		
		int countcontact = contactDAO.count();
		modelMap.addAttribute("countcontact", countcontact);
		
		
		HttpSession session = request.getSession();
		
		User userLogin = userDAO.existUser(principal.getName());
		
		if(userLogin != null) {
			session.setAttribute("userLogin", userLogin);
		} 
		
		return "cland.admin.index.index";
	}
	
}
