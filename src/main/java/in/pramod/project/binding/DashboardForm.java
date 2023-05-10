package in.pramod.project.binding;

import jakarta.persistence.Lob;
import lombok.Data;

@Data
public class DashboardForm {
	private String blogTitle;
	private String blogDesp;
	@Lob
	private String blogContent;
	private String blogCreatedDate;
}
