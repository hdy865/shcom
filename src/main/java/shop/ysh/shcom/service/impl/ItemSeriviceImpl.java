package shop.ysh.shcom.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
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

	public void upload(ProductDTO productDTO) {
		
		log.info(">>>" + productDTO.getP_name());
		
		Product product = new Product(productDTO.getP_name()
									, productDTO.getP_content()
									, productDTO.getP_cost());
		
		productRepository.save(product);
		log.info("결과" + product.getP_num());
		int p_num = product.getP_num();
//		uploadImg(product);
		productDTO.getImgDTOList().forEach(img -> {
			String i_name = img.getI_name();
			String i_path = img.getI_path();
			
		
			
			//해당하는 product_p_num
			//productRepository.findById();
			
			//DB저장
			Img result = new Img(i_name, i_path, p_num);
			log.info("결과2" + p_num);
			imgRepository.save(result);
		});
	}
	
//	public void uploadImg(Product product) {
//		
//		log.info(">>>" + product.getp_num());
//			
//		log.info("imageDTO: " + imgDTO);
//		
//			imgDTO.getFile().forEach(mutipartFile -> {
//			String originalName = mutipartFile.getOriginalFilename();
//			log.info("originalName : " + originalName);//파일 이름
//			
//			String uuid = UUID.randomUUID().toString();
//			String i_name = uuid + "_" + originalName;
//			
//			Path savePath = Paths.get(uploadPath, i_name);//저장 경로
//			
//			try {
//				mutipartFile.transferTo(savePath);//로컬 파일 시스템에 임시 복사
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			
//			//해당하는 product_p_num
//			//productRepository.findById();
//			
//			//DB저장
//			Img img = new Img(i_name, savePath.toString(), product.getp_num());
//			imgRepository.save(img);
//		});
//	}
	

}
