package shop.ysh.shcom.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ImgResultDTO {

	private String i_name;
	
	private String i_path;

	public ImgResultDTO(String i_name, String i_path) {
		this.i_name = i_name;
		this.i_path = i_path;
	}

	

}
