package in.pramod.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.pramod.project.binding.DashboardForm;
import in.pramod.project.binding.PostContentForm;
import in.pramod.project.entity.BlogContentEntity;
import in.pramod.project.entity.BlogUserEntity;
import in.pramod.project.repo.BlogContentRepo;
import in.pramod.project.repo.BlogUserRepo;
import jakarta.servlet.http.HttpSession;

@Service
public class BlogContentServiceImpl implements BlogContentSerive {
	@Autowired
	private HttpSession session;
	@Autowired
	private BlogContentRepo contentRepo;
	@Autowired
	private BlogUserRepo userRepo;

	@Override
	public boolean newPostContent(Integer userId, PostContentForm newPostContentForm) {

		if (userId != null) {

			BlogContentEntity contentEntity = new BlogContentEntity();
			BeanUtils.copyProperties(newPostContentForm, contentEntity);
			BlogUserEntity userEntity = userRepo.findById(userId).get();
			System.out.println(contentEntity);
			contentEntity.setUser(userEntity);
			contentRepo.save(contentEntity);
			return true;
		}

		return false;
	}

	@Override
	public List<BlogContentEntity> dashboard() {

		DashboardForm dashboardForm = new DashboardForm();
		Integer userId = (Integer) session.getAttribute("userId");
		Optional<BlogUserEntity> findById = userRepo.findById(userId);
		if (findById.isPresent()) {
			BlogUserEntity userEntity = findById.get();
			List<BlogContentEntity> content = userEntity.getContent();
			
//			BeanUtils.copyProperties(content, dashboardForm);
//			System.out.println(dashboardForm);
			
			return content;
		}
		return null;
	}

}
