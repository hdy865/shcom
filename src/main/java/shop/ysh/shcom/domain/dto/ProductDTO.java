package shop.ysh.shcom.domain.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDTO {

    private String p_name;
	
	private String p_content;
	
	private String p_cost;
	
	private List<ImgDTOList> imgDTOList;
	
}
