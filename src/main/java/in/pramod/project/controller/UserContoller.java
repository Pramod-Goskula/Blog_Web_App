package in.pramod.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.pramod.project.binding.UserLoginForm;
import in.pramod.project.binding.UserSignUpForm;
import in.pramod.project.service.userService;

@Controller
public class UserContoller {
	@Autowired
	private userService service;

	@GetMapping("/login")
	public String loginPage(Model model) {

		model.addAttribute("loginForm", new UserLoginForm());

		return "login";
	}

	@PostMapping("/login")
	public String loginPageData(@ModelAttribute("loginForm") UserLoginForm loginForm, Model model) {
		String status = service.login(loginForm);
		if (status.contains("success")) {
			model.addAttribute("success", "Login Success");
			return "redirect:/dashboard";
		} else {
			model.addAttribute("error", status);
		}
		System.out.println(loginForm);
		return "login";
	}

	@GetMapping("/signup")
	public String sigupPage(Model model) {

		model.addAttribute("signupForm", new UserSignUpForm());
		return "signup";
	}

	@PostMapping("/signup")
	public String signupPageData(@ModelAttribute("signupForm") UserSignUpForm signupForm, Model model) {
		if (null != signupForm && !signupForm.getEmail().equals("")) {
			boolean status = service.signup(signupForm);
			if (status) {
				model.addAttribute("success", " Registration successfully ,Please Login");
			} else {
				model.addAttribute("error", "Email Already exists,Try to Login ");
			}
		} else {

			model.addAttribute("error", "Signup Failed Enter Details");
		}
		return "signup";
	}
}
