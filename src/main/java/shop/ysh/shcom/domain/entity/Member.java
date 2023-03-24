package shop.ysh.shcom.domain.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter //select시 필요
public class Member {

	private int m_num;
	
	private String m_name;
	
	private String m_email;
	
	private String m_password;
	
	private String m_phone;
	
	private String m_adress;
	
	private String m_role;
	
	public Member(String m_name, String m_email, String m_password, String m_phone,
			String m_role) {
		this.m_name = m_name;
		this.m_email = m_email;
		this.m_password = m_password;
		this.m_phone = m_phone;
		this.m_role = m_role;
	}
	
	
}
