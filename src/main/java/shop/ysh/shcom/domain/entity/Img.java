package shop.ysh.shcom.domain.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Img {

	private int i_num;
	
	private String i_name;
	
	private String i_path;
	
	private int product_p_num;
	
	public Img(String i_name, String i_path, int product_p_num) {
		this.i_name = i_name;
		this.i_path = i_path;
		this.product_p_num = product_p_num;		
	}
}
