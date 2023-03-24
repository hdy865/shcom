package shop.ysh.shcom.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import shop.ysh.shcom.domain.dto.ImgDTO;
import shop.ysh.shcom.domain.dto.ProductDTO;
import shop.ysh.shcom.domain.entity.Product;

public interface ItemService {
	
	void upload(ProductDTO productDTO, ImgDTO imgDTO);
	
}
