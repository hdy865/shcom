package shop.ysh.shcom.domain.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AuthMemberDTO implements UserDetails{

	private static final long serialVersionUID = 1L;
	
	private String m_email;
	
	private String m_password;
	
	private String m_role;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add( new SimpleGrantedAuthority(getRole()) );
		return authorities;
	}
	
	private String getRole() {
		return this.m_role;
	}

	@Override
	public String getPassword() {
		return this.m_password;
	}

	@Override
	public String getUsername() {
		return this.m_email;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
