package shop.ysh.shcom.domain.entity;

import lombok.Getter;

@Getter
public class Product {

	private int p_num;
	
	private String p_name;
	
	private String p_content;
	
	private String p_cost;
	
	public Product(String p_name, String p_content, String p_cost) {
		this.p_name = p_name;
		this.p_content = p_content;
		this.p_cost = p_cost;
	};
}
