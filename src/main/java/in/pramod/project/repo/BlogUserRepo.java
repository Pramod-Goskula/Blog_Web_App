package in.pramod.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.pramod.project.entity.BlogUserEntity;

public interface BlogUserRepo extends JpaRepository<BlogUserEntity, Integer> {
	
	
	public  BlogUserEntity findByEmail(String email);
	
	public BlogUserEntity  findByEmailAndPassword(String email, String password);
}
