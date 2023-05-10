package in.pramod.project.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.pramod.project.binding.UserLoginForm;
import in.pramod.project.binding.UserSignUpForm;
import in.pramod.project.entity.BlogUserEntity;
import in.pramod.project.repo.BlogUserRepo;
import jakarta.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements userService {
	@Autowired
	private BlogUserRepo userRepo;
	@Autowired
	private HttpSession session;

	@Override
	public String login(UserLoginForm loginForm) {
		BlogUserEntity byEmailAndPassword = userRepo.findByEmailAndPassword(loginForm.getEmail(),
				loginForm.getPassword());
		if (byEmailAndPassword == null) {
			return "Invalid Login Credential";
		}
		Integer userId = byEmailAndPassword.getUserId();
		session.setAttribute("userId",userId );

		return "success";
	}

	@Override
	public boolean signup(UserSignUpForm signupForm) {

		BlogUserEntity byEmail = userRepo.findByEmail(signupForm.getEmail());

		if (byEmail == null) {

			BlogUserEntity userEntity = new BlogUserEntity();
			if (signupForm != null)
				BeanUtils.copyProperties(signupForm, userEntity);
			userRepo.save(userEntity);
			return true;
		}

		return false;
	}

}
