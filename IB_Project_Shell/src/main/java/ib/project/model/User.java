package ib.project.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ib.project.model.*;

@Entity
@Table(name="user")
public class User implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idd", unique = true, nullable = false)
	private Long idd;
	
	@Column(name = "username", unique = true, nullable = false)
	private String username;
	
	//@JsonIgnore
	@Column(name = "pass", unique = false, nullable = false)
	private String pass;
	
	
	@Column(name = "email", unique = false, nullable = true)
	private String email;
	
	@Column(name = "enabled", unique = false, nullable = false)
	private boolean enabled;
	
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "authorities_users", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "authority_id"))
	private Set<Authority> authority;

	public User() {
		
	}

	public User(String username, String pass, Set<Authority> authority) {
		super();
		this.username = username;
		this.pass = pass;
		this.authority = authority;
	}

	

	public User(String username, String pass) {
		super();
		this.username = username;
		this.pass = pass;
	}



	public Long getId() {
		return idd;
	}

	public void setId(Long id) {
		this.idd = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return pass;
	}

	public void setPassword(String pass) {
		
        this.pass = pass;
	}
	

	

	public Set<Authority> getAuthority() {
		return authority;
	}

	public void setAuthority(Set<Authority> authority) {
		this.authority = authority;
	}
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	@Override
	public String toString() {
		return "User id=" + idd + ", KorisnikoIMe=" + username + ", pass=" + pass + ".";
	}
	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authority;
    }

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@JsonIgnore
    public String getAuthoritiesAsString() {
    	StringBuilder sb = new StringBuilder();
    	
    	for (Authority authority : this.authority) {
    		sb.append(authority.getName() + " ");
    	}
    	
    	return sb.toString();
    }

}
