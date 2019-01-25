package cn.tedu.ttms.product.dao;

import java.util.List;
import java.util.Map;

import cn.tedu.ttms.common.dao.BaseDao;
import cn.tedu.ttms.product.entity.ProductType;
/**产品分类*/


public interface ProductTypeDao extends 
    BaseDao<ProductType>{
	List<Map<String,Object>> findObjects();
	
	/**查找zTree nodes 节点*/
	List<Map<String,Object>> findTreeNodes();
	
	Map<String,Object> findObjectById(Integer id);
	
}

