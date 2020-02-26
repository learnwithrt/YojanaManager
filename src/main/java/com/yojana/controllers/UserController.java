package com.yojana.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yojana.entities.User;
import com.yojana.services.UserService;

@Controller
public class UserController {
	@Autowired
	UserService service;
	// @Value("${spring.application.name}")
	// String appName;

	@GetMapping("/login.html")
	public String showLogin() {
		// model.addAttribute("appName", appName);
		return "login";
	}
	@GetMapping("/logout.html")
	public String logoutUser(HttpServletRequest request) {
		// model.addAttribute("appName", appName);
		request.getSession().invalidate();
		return "redirect:/index.html";
	}
	@GetMapping("/signup.html")
	public String showRegister() {
		// model.addAttribute("appName", appName);
		return "SignUp";
	}

	@GetMapping("/user/avatar/")
	public void showUserAvatar(HttpServletResponse response, HttpServletRequest request) throws IOException {
		String user_id = (String) request.getSession().getAttribute("user_id");
		User user = service.get(user_id);
		response.setContentType("image/jpeg");
		InputStream is = new ByteArrayInputStream(user.getUser_photo());
		IOUtils.copy(is, response.getOutputStream());
	}

	@PostMapping(value = "/registerUser.html")
	public String register(Model model, @RequestParam("user_id") String id, @RequestParam("user_pwd") String pwd,
			@RequestParam("user_mail") String email, @RequestParam("gender") String gender,
			@RequestParam("user_pic") MultipartFile pic, @RequestParam("user_name") String name,
			HttpServletRequest request) {
		User user = null;
		try {
			user = new User(id, gender.charAt(0), name, email, pic.getBytes(), pwd);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		service.save(user);
		return "redirect:/login.html";
	}

	@PostMapping(value = "/loginCheck.html", produces = MediaType.TEXT_PLAIN_VALUE)
	public @ResponseBody String login(Model model, @RequestParam("user_id") String id,
			@RequestParam("user_pwd") String pwd, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		int res = service.loginUser(id, pwd);
		if (res == 1) {
			session = request.getSession(true);
			session.setAttribute("user_id", id);
			model.addAttribute("userName", id);
			return "OK";
		}
		return "fail";
	}
}
