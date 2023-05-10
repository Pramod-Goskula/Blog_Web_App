package in.pramod.project.service;

import java.util.List;

import in.pramod.project.binding.PostContentForm;
import in.pramod.project.entity.BlogContentEntity;

public interface BlogContentSerive {
	
	public boolean newPostContent(Integer userId ,PostContentForm newPostContentForm);
	
	public List<BlogContentEntity> dashboard();
}
