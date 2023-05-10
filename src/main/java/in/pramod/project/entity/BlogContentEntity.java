package in.pramod.project.entity;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name="Blog_Content")
public class BlogContentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer blogId;
	private String blogTitle;
	private String blogDesp;
	@Lob
	private String blogContent;
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDate blogCreatedDate;
	@UpdateTimestamp
	@Column(insertable = false)
	private LocalDate blogUpdatedDate;
	@ManyToOne
	@JoinColumn(name = "userId")
	private BlogUserEntity user;
	@OneToMany(mappedBy = "blogContent",cascade = CascadeType.REMOVE)
	private List<CommentsEntity> comments;
}
