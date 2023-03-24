package shop.ysh.shcom.domain.repository;

import org.apache.ibatis.annotations.Mapper;

import shop.ysh.shcom.domain.entity.Product;

@Mapper
public interface ProductRepository {

	void save(Product product);

}
