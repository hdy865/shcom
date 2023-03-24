package shop.ysh.shcom.domain.repository;

import org.apache.ibatis.annotations.Mapper;

import shop.ysh.shcom.domain.entity.Img;

@Mapper
public interface ImgRepository {

	void save(Img img);

}
