package shop.ysh.shcom.service.impl;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j2;
import shop.ysh.shcom.domain.dto.ImgDTO;
import shop.ysh.shcom.domain.dto.ProductDTO;
import shop.ysh.shcom.domain.entity.Img;
import shop.ysh.shcom.domain.entity.Product;
import shop.ysh.shcom.domain.repository.ImgRepository;
import shop.ysh.shcom.domain.repository.ProductRepository;
import shop.ysh.shcom.service.ItemService;

@Service
@Log4j2
public class ItemSeriviceImpl implements ItemService {
	
	@Value("${ysh.shcom.upload.Path}")
	private String uploadPath;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ImgRepository imgRepository;

	public void upload(ProductDTO productDTO, ImgDTO imgDTO) {
		
		log.info(">>>" + productDTO.getP_name());
		
		Product product = new Product(productDTO.getP_name()
									, productDTO.getP_content()
									, productDTO.getP_cost());
		
		productRepository.save(product);
		log.info("결과" + product.getP_num());
		uploadImg(product, imgDTO);
	}
	
	public void uploadImg(Product product, ImgDTO imgDTO) {
		
		log.info(">>>" + product.getP_num());
			
		log.info("imageDTO: " + imgDTO);
		
			imgDTO.getFile().forEach(mutipartFile -> {
			String originalName = mutipartFile.getOriginalFilename();
			log.info("originalName : " + originalName);//파일 이름
			
			String uuid = UUID.randomUUID().toString();
			String i_name = uuid + "_" + originalName;
			
			Path savePath = Paths.get(uploadPath, i_name);//저장 경로
			
			try {
				mutipartFile.transferTo(savePath);//로컬 파일 시스템에 임시 복사
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			//해당하는 product_p_num
			//productRepository.findById();
			
			//DB저장
			Img img = new Img(i_name, savePath.toString(), product.getP_num());
			imgRepository.save(img);
		});
	}
}
