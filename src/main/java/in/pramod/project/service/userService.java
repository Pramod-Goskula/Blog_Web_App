package in.pramod.project.service;

import in.pramod.project.binding.UserLoginForm;
import in.pramod.project.binding.UserSignUpForm;

public interface userService {
	
	public String login(UserLoginForm loginForm);
	public boolean signup(UserSignUpForm signupForm);

}
