package shop.ysh.shcom.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j2;
import shop.ysh.shcom.domain.dto.ImgDTOList;
import shop.ysh.shcom.domain.dto.ImgResultDTO;
import shop.ysh.shcom.domain.dto.ProductDTO;
import shop.ysh.shcom.service.ItemService;

@Controller
@Log4j2
public class ProductController {
	
	@Value("${ysh.shcom.upload.Path}")
	private String uploadPath;
	
	@Autowired
	private ItemService itemService;
	
	@PostMapping("/admin/upload")
	public void uplodProdut(ProductDTO productDTO) {
		
		itemService.upload(productDTO);
		
	}
	
	@PostMapping("/admin/uploadAjax")
	public ResponseEntity<List<ImgResultDTO>> uploadAjax(MultipartFile[] uploadFiles) {
		
		
		List<ImgResultDTO> resultDTOList = new ArrayList<>(); 
		
		for(MultipartFile uploadFile : uploadFiles) {
			String originalName = uploadFile.getOriginalFilename();
			log.info("originalName : " + originalName);//파일 이름
			
			String uuid = UUID.randomUUID().toString();
			String i_name = uuid + "_" + originalName;
			log.info("i_name : " + i_name);//파일 이름
			Path savePath = Paths.get(uploadPath, i_name);//저장 경로
			log.info("savePath : " + savePath);//파일 이름
			try {
				uploadFile.transferTo(savePath);//로컬 파일 시스템에 임시 복사
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			resultDTOList.add(new ImgResultDTO(i_name, savePath.toString()));
		}
		
		return new ResponseEntity<>(resultDTOList, HttpStatus.OK);
	}
	
	@GetMapping("/admin/display")
	public ResponseEntity<byte[]> displayAjax(String fileName) {
		System.out.println(">>>" + fileName);
		
		ResponseEntity<byte[]> result = null;
		
		try {
			String srcFileName = URLDecoder.decode(fileName, "UTF-8");
			
			log.info("srcFileName : " + srcFileName);
			
			File file = new File(uploadPath+File.separator+srcFileName);
			
			log.info("file:" + file);
			
			HttpHeaders header = new HttpHeaders();
			
			//MIME 타입처리
			header.add("Content-Type", Files.probeContentType(file.toPath()));
			//파일 데이터 처리
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return result;
	}
	
	@PostMapping("/upload/removeFile")
	public ResponseEntity<Boolean> removeFile(String fileName) {
		
		String srcFileName = null;
		try {
			srcFileName = URLDecoder.decode(fileName, "UTF-8");
			File file = new File(uploadPath + File.separator + srcFileName);
			
			boolean result = file.delete();
//			File thumbnail = new File(file.getParent(), "s_" + file.getName());
//			
//			result = thumbnail.delete();
			
			return new ResponseEntity<>(result, HttpStatus.OK);
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}