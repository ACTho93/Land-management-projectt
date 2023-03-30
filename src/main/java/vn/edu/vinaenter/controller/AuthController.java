package vn.edu.vinaenter.controller;


import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("auth")
public class AuthController {

	@Autowired
	private BCryptPasswordEncoder bCrypt;
	
	@Autowired
	
//	public AuthController (BCryptPasswordEncoder bCryptPasswordEncoder) {
//		this.bCrypt = bCryptPasswordEncoder;
//	}
	
	@GetMapping("login")
	public String login() {
		
		return "auth/login";
		
	}
	
	@ResponseBody
	@GetMapping("mahoa")
	public String mahoa() {
		String pass = bCrypt.encode("123456");
		/*
		 * if (bCrypt.matches("12345",
		 * "$2a$10$2BVTyHUqCmamm1jdghiU1u7VgUzEQKCmS.Tb5PENUCHvOUYFBNQrm")) { return
		 * "true"; } else { return "false"; }
		 */
		return pass;
	
	}
	
//	
//	
//	@PostMapping("login")
//	public String login1(@RequestParam String username,HttpServletRequest request,ModelMap modelMap) {
//		
//		HttpSession session = request.getSession();
//		
//		System.out.println("username: "+username);
//		
//		User userLogin = userDAO.existUser(username);
//		
//		System.out.println("userLogin: "+userLogin);
//		
//		if(userLogin != null) {
//			session.setAttribute("userLogin", userLogin);
//			return "redirect:/admin/land/add";
//		} else {
//			return "redirect:/admin/land/add";
//		}
//		
//		
//	}
	
}
