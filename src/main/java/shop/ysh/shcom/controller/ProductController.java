package shop.ysh.shcom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j2;
import shop.ysh.shcom.domain.dto.ImgDTO;
import shop.ysh.shcom.domain.dto.ProductDTO;
import shop.ysh.shcom.service.ItemService;

@Controller
@Log4j2
public class ProductController {
	
	@Autowired
	private ItemService itemService;
	
	@PostMapping("/admin/upload")
	public void uplodProdut(ProductDTO productDTO, ImgDTO imgDTO) {
		
		itemService.upload(productDTO, imgDTO);
		
	}
	
	
}