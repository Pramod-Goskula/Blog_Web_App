package in.pramod.project.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name = "Blog_Comments")
public class CommentsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer commentId;
	private String commentedName;
	private String commentedEmail;
	@Lob
	private String commentContent;
	@CreationTimestamp
	private LocalDate commentCreated;
	@ManyToOne
	@JoinColumn(name = "blogId")
	private BlogContentEntity blogContent;

}
