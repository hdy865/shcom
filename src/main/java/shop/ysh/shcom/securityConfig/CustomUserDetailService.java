package shop.ysh.shcom.securityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import shop.ysh.shcom.domain.repository.MemberRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private MemberRepository memberRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails result = memberRepository.findByEmail(username);
		//System.out.println(">>>" + result.getUsername() + ">>>" + result.getPassword());

//		List<GrantedAuthority> authorities = new ArrayList<>();
//		authorities.add( new SimpleGrantedAuthority(result.getRole()) );

		return new User(result.getUsername(), 
						result.getPassword(), 
						result.getAuthorities());
	}

}
