package in.pramod.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.pramod.project.entity.CommentsEntity;

public interface CommentsRepo extends JpaRepository<CommentsEntity, Integer> {

}
