package com.blog.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.blog.dao.PostDaoImplementation;
import com.blog.dao.UserDaoImplementation;
import com.blog.model.Comment;
import com.blog.model.Post;
import com.blog.model.User;

@Controller
public class HomeController {

	@Autowired
	private UserDaoImplementation userDao;
	@Autowired
	private PostDaoImplementation postDao;
	private Path path;
	
	@RequestMapping("/")
	public String home() {
		return "login";
	}
	
	@RequestMapping("/addPost")
	public String addPost(Model model,@RequestParam("userId")String email) {
		model.addAttribute("post", new Post());
		model.addAttribute("link", "addPost/processPost");
//		model.addAttribute("email", email);
		System.out.println(email);
		return "addPost";
	}
	
	@RequestMapping("/addPost/processPost")
	public ModelAndView addPostProcess(@Valid @ModelAttribute("post") Post post, BindingResult bindResult,
			 HttpServletRequest request)  {
		if(bindResult.hasErrors() || post.getCategory().equals("0") || post.getPostImage().isEmpty()  ) {
			System.out.println("error");
			System.out.println(bindResult.getObjectName());
			System.out.println(bindResult.getFieldError());
			ModelAndView model = new ModelAndView("addPost");
			model.addObject("link","");
			if(post.getCategory().equals("0") ) {
				model.addObject("errorMessage","is Required");
			}
			if(post.getPostImage().isEmpty() ) {
				model.addObject("errorFile","is Required");
			}
			return model;
		} else {	
			HttpSession session = request.getSession();
			String email=(String) session.getAttribute("email");
//			session.setAttribute("", post);
			String date = getDate();
			post.setDate(date);
			User user = userDao.getUser(email); // /blog/src/main/webapp/resources/image
			post.setAuthor(user.getUserName());
			System.out.println("-------------------------");
			System.out.println(user);
			user.add(post);
			int id=postDao.addPost(post);
		
			MultipartFile postImg= post.getPostImage();
//            String rootDirectory = request.getSession().getServletContext().getRealPath("/");
//            System.out.println(postImg);
//			System.out.println(rootDirectory); E:\my project\blog\src\main\webapp\resources\image
            path= Paths.get("E:\\my project\\blog\\src\\main\\webapp\\resources\\image\\"+id+".png");
//            System.out.println(rootDirectory+"\\resources\\image\\"+id+".png");
            if(postImg != null && !postImg.isEmpty()){
                try{
                    File file = new File(path.toString());
                    postImg.transferTo(file);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
			
			ModelAndView model = new ModelAndView("post");
			
			model.addObject("post",post);
			return model;
		}	
	}
	
	@RequestMapping("/viewPost")
	public String showPost(@RequestParam("postId") int id, Model model) {
		System.out.println("---------------");
		Post post=postDao.getPost(id);
		model.addAttribute("post",post);
		model.addAttribute("comment", new Comment());
		return "post";
	}
	
	@RequestMapping("/addComment")
	public String addComment(@RequestParam("postId") int postId, @ModelAttribute("comment") Comment comment) {
		System.out.println("---------------");
		System.out.println(comment);
		System.out.println(postId);
		return "post";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrim = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrim);
	}
	
	public String getDate() {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		return date;
	}
	
	
	
}
