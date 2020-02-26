package com.yojana.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yojana.entities.Project;
import com.yojana.entities.Task;
import com.yojana.entities.User;
import com.yojana.services.ProjectService;
import com.yojana.services.TaskService;
import com.yojana.services.UserService;

@Controller
public class TaskController {
	@Autowired
	UserService service;
	@Autowired
	ProjectService projService;
	@Autowired
	TaskService taskService;

	@GetMapping("/project/{id}/add_task")
	public String showNewTask(Model model, @PathVariable String id,HttpServletRequest request) {
		if(request.getSession(false)==null) {
			return "redirect:/login.html";
		}
		List<User> user = new ArrayList<>();
		List<User> users = service.listAll();
		Project project = projService.get(Integer.parseInt(id));
		model.addAttribute("userList", users);
		model.addAttribute("user", user);
		model.addAttribute("project", project);
		List<Task> tasks = taskService.getInfo(Integer.parseInt(id));
		List<Task> task = new ArrayList<>();
		model.addAttribute("taskList", tasks);
		model.addAttribute("task", task);
		return "new_task";
	}

	@PostMapping("/newTask.html")
	public String addTask(Model model, @RequestParam("task_name") String name,
			@RequestParam("task_desc") String desc, @RequestParam("proj_id") String proj_id,
			@RequestParam("task_start_date") String start_date, @RequestParam("task_end_date") String end_date,
			@RequestParam("task_manager") String manager,@RequestParam("task_parent") String parent, HttpServletRequest request) {
		Task task = null;
			task = new Task(name, Integer.parseInt(proj_id), LocalDate.parse(start_date, DateTimeFormatter.ofPattern("dd-MM-yyyy")), 
					LocalDate.parse(end_date, DateTimeFormatter.ofPattern("dd-MM-yyyy")), desc, manager,Integer.parseInt(parent));
		taskService.save(task);
		return "redirect:/project/"+proj_id+"/view_tasks";
	}
	@PostMapping("updateTask.html")
	public String updateTask(Model model, @RequestParam("task_id") String id,@RequestParam("task_name") String name,
			@RequestParam("task_desc") String desc, @RequestParam("proj_id") String proj_id,
			@RequestParam("task_start_date") String start_date, @RequestParam("task_end_date") String end_date,
			@RequestParam("task_manager") String manager,@RequestParam("task_parent") String parent, HttpServletRequest request) {
		Task task=taskService.get(Integer.parseInt(id));
		task.setProject_ID(Integer.parseInt(proj_id));
		task.setT_assigned_to(manager);
		task.setT_description(desc);
		task.setT_end_date(LocalDate.parse(end_date, DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		task.setT_start_date(LocalDate.parse(start_date, DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		task.setT_parent(Integer.parseInt(parent));
		task.setT_Name(name);
		taskService.save(task);
		return "redirect:/project/"+proj_id+"/view_tasks";
	}
	@GetMapping("/project/{id}/view_tasks")
	public String showTasks(@PathVariable String id,Model model,HttpServletRequest request) {
		if(request.getSession(false)==null) {
			return "login";
		}
		List<Task> tasks = taskService.getInfo(Integer.parseInt(id));
		List<Task> task = new ArrayList<>();
		model.addAttribute("taskList", tasks);
		model.addAttribute("task", task);
		model.addAttribute("project",projService.get(Integer.parseInt(id)));
		return "task_manager";
	}
	@GetMapping("project/{project_id}/task/{id}/edit")
	public String updateTaskDetails(@PathVariable String project_id,@PathVariable String id,Model model,HttpServletRequest request) {
		if(request.getSession(false)==null) {
			return "login";
		}
		Task task = taskService.get(Integer.parseInt(id));
		model.addAttribute("task",task);
		List<Task> tasks = taskService.getInfo(Integer.parseInt(project_id));
		List<Task> taskData = new ArrayList<>();
		tasks.remove(taskService.get(Integer.parseInt(id)));
		model.addAttribute("taskList", tasks);
		model.addAttribute("taskData", taskData);
		Project project = projService.get(Integer.parseInt(project_id));
		model.addAttribute("project", project);
		List<User> user = new ArrayList<>();
		List<User> users = service.listAll();
		model.addAttribute("userList", users);
		model.addAttribute("user", user);
		return "edit_task";
	}
	@GetMapping("project/{project_id}/task/{id}/delete")
	public String deleteTask(@PathVariable String project_id,@PathVariable String id) {
		taskService.delete(Integer.parseInt(id));
		//taskService.deleteTasks(Integer.parseInt(id));
		return "redirect:/project/"+project_id+"/view_tasks";
	}

}
