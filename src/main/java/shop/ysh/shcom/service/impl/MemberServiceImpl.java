package shop.ysh.shcom.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import shop.ysh.shcom.domain.dto.MemberRegDTO;
import shop.ysh.shcom.domain.entity.Member;
import shop.ysh.shcom.domain.repository.MemberRepository;
import shop.ysh.shcom.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository memberRepository; 
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void regUser(MemberRegDTO memberRegDTO) {
		
		//DTO->MEMBER
		Member member = new Member(
				memberRegDTO.getM_name(),
				memberRegDTO.getM_email(),
				passwordEncoder.encode(memberRegDTO.getM_password()),
				memberRegDTO.getM_phone(),
				memberRegDTO.getM_role()
				);

		memberRepository.regUser(member);
		
	}

}
