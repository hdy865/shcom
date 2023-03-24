package shop.ysh.shcom.domain.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import shop.ysh.shcom.domain.dto.AuthMemberDTO;
import shop.ysh.shcom.domain.entity.Member;

@Mapper
@Repository
public interface MemberRepository {

	void regUser(Member member);

	UserDetails findByEmail(String username);

}
