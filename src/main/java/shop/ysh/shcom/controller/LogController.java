package shop.ysh.shcom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import shop.ysh.shcom.domain.dto.MemberRegDTO;
import shop.ysh.shcom.service.MemberService;

@Controller
public class LogController {
	
	@Autowired
	private MemberService memberService;

	//로그인 페이지로 이동
	@GetMapping("/shcom/login")
	public String loginPage() {
		return "log/form-login";
	}
	
	//회원가입 페이지로 이동
	@GetMapping("/shcom/signup")
	public String signupPage() {
		return "log/signup";
	}
	
	//회원가입 처리 메소드
	@PostMapping("/shcom/signup")
	public String memberReg(MemberRegDTO memberRegDTO) {
		memberService.regUser(memberRegDTO);
		return "redirect:/shcom";
	}
}
