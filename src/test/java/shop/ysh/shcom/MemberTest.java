package shop.ysh.shcom;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.multipart.MultipartFile;

import shop.ysh.shcom.domain.entity.Member;
import shop.ysh.shcom.domain.repository.MemberRepository;

@SpringBootTest
public class MemberTest {

	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Test
	public void saveADMIN() {
	}
}
