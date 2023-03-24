package shop.ysh.shcom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
	
	@GetMapping("/shcom")
	public String main() {
		return "layout/main";
	}
	
	@GetMapping("/admin/regProduct")
	public String regProduct() {
		return "admin/upload";
	}
	
}
