package in.pramod.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.pramod.project.binding.PostContentForm;
import in.pramod.project.entity.BlogContentEntity;
import in.pramod.project.service.BlogContentSerive;
import jakarta.servlet.http.HttpSession;

@Controller
public class BlogController {
	@Autowired
	private HttpSession session;
	@Autowired
	private BlogContentSerive blogService;
	
	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		
		return "index";
	}
	
	@GetMapping("/dashboard")
	public String dashboardPage(Model model) {
		
	List<BlogContentEntity> content = blogService.dashboard();
	model.addAttribute("blogContent", content);
		
		return "dashboard";
	}
	@GetMapping("/newpost")
	public String blogNewPostPage(Model model) {
		
		model.addAttribute("newPostForm", new PostContentForm());
		
		return "newpost";
		
	}
	
	@PostMapping("Posted")
	public String blogNewPostSave(@ModelAttribute("newPostForm") PostContentForm newPostForm,Model model) {
		if(null!=newPostForm & !newPostForm.getBlogTitle().equals("")) {
			Integer userId = (Integer) session.getAttribute("userId");
			System.out.println(userId);
			blogService.newPostContent(userId, newPostForm);
			return "redirect:/dashboard";
		}
		else {
			model.addAttribute("error","Enter Blog Details");
		}
		
		System.out.println(newPostForm);
		
		return "newpost";
	}
	

}
