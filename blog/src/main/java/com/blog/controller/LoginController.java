package com.blog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.blog.dao.PostDaoImplementation;
import com.blog.dao.UserDao;
import com.blog.dao.UserDaoImplementation;
import com.blog.model.Post;
import com.blog.model.User;

@Controller
public class LoginController {
	
	@Autowired
	private UserDaoImplementation userDao;
	@Autowired
	private PostDaoImplementation postDao;

	@RequestMapping("/showLoginPage")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.invalidate();
		return "login";
	}
	
	@RequestMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("user", new User());
		return "signup";
	}
	
	@PostMapping("/processSignup")
	public String processSignup(@ModelAttribute ("user") User user) {
		System.out.println(user);
		userDao = new UserDaoImplementation();
		userDao.addUser(user);
		return "message";
	}
	
	@PostMapping("/processLogin")
	public ModelAndView processLogin(@RequestParam ("email")String email, @RequestParam ("password")String password, HttpServletRequest req) throws InterruptedException {
//		System.out.println(email+"\n"+ password);
		UserDaoImplementation userDao = new UserDaoImplementation();
		User user=userDao.getUser(email, password);
//		System.out.println(user);
		ModelAndView mv=null;
		if( user == null) {
			 mv = new ModelAndView("message");
			 mv.addObject("message", "Wrong user or password");
		} else {
			List<Post> allPost=postDao.getAllPost();
//			System.out.println(allPost);
			HttpSession session= req.getSession();
			session.setAttribute("user", user);
			session.setAttribute("email", user.getEmail());
			session.setAttribute("allPost", allPost);
			mv = new ModelAndView("home");
//			mv.addObject("allPost", allPost);
//			mv.addObject("userName", user.getUserName());
			
		}
		
		return mv;
	}
	
}
