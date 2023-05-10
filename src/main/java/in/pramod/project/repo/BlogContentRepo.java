package in.pramod.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.pramod.project.entity.BlogContentEntity;

public interface BlogContentRepo  extends JpaRepository<BlogContentEntity, Integer>{

}
