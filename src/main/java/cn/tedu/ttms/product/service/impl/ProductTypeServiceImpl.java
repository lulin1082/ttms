package cn.tedu.ttms.product.service.impl;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import cn.tedu.ttms.common.exception.SaveRuntimeException;
import cn.tedu.ttms.common.exception.UpdateRuntimeException;
import cn.tedu.ttms.product.dao.ProductTypeDao;
import cn.tedu.ttms.product.entity.ProductType;
import cn.tedu.ttms.product.service.ProductTypeService;
import org.springframework.stereotype.Service;


@Service("productTypeService")
public class ProductTypeServiceImpl implements ProductTypeService{
    @Resource
	private ProductTypeDao productTypeDao;
	@Override
	public List<Map<String, Object>> findObjects() {
		return productTypeDao.findObjects();
	}
	@Override
	public List<Map<String, Object>> findTreeNodes() {
		List<Map<String,Object>> map= productTypeDao.findTreeNodes();
	    System.out.println("map="+map);
	    return map;
	}
	@Override
	public void saveObject(ProductType type) {
		int rows=productTypeDao.insertObject(type);
		if(rows==-1)
		throw new SaveRuntimeException("save error");
	}
	/**根据id查找分类信息*/
	@Override
	public Map<String,Object> findObjectById(Long id) {
		if(id==null)
	    throw new RuntimeException("id can not be null");
		Map<String,Object> map= productTypeDao.findObjectById(id);
		return map;
	}
	/**更新产品分类信息*/
	@Override
	public void updateObject(ProductType type) {
		int rows=productTypeDao.updateObject(type);
		if(rows==-1)
		throw new UpdateRuntimeException("更新失败");
	}

}
