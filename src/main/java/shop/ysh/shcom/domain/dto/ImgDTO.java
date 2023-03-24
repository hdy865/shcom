package shop.ysh.shcom.domain.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ImgDTO {
	
	private List<MultipartFile> file;
}
