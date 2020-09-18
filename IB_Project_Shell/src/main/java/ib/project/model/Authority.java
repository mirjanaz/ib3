package ib.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
//@Table(name="Authority")
public class Authority implements GrantedAuthority {



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "authority_id", unique = true, nullable = false)
	private Long idd;
	
	@Column(name = "authority", unique = false, nullable = false)
	private String name;
	
	@JsonIgnore
	public Long getId() {
		return idd;
	}

	public void setId(Long idd) {
		this.idd = idd;
	}
	
	@Override
	public String getAuthority() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@JsonIgnore
	public String getName() {
		return name;
	}
}
