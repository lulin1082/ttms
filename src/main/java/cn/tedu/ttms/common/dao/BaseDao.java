package cn.tedu.ttms.common.dao;

import cn.tedu.ttms.common.web.PageObject;
import cn.tedu.ttms.system.entity.User;
import org.apache.ibatis.annotations.Param;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Map;

/**类上定义的泛型用于约束类中方法的
 * 参数类型,方法的返回值类型或属性类型*/

public interface  BaseDao<T> {

	int insertObject(@Param("entity") T t);
	int updateObject(@Param("entity")T t);



	int save(@Param("entity")T t);
	int saveObject(Map<String, Object> map);

	int getRowCounts(@Param(value="entity") T t);

/*
	int deletObject(Integer id);
*/
	int deletObject(Long id);


	int changeState(@Param("id")Long id, @Param("valid")Integer valid);
/*
	int changeState(@Param("id")Integer id, @Param("valid")Integer valid);
*/

	int validById(@Param(value="ids")String[] ids,@Param(value="valid")Integer valid);


/*
	List<Integer> findRelatedIdListById(Integer id);
*/
	List<Integer> findRelatedIdListById(Long id);

	List<Map<String,Object>> findObjects(@Param(value="entity") T entity, @Param(value="pageObject") PageObject pageObject);
 	Map<String,Object> findObjectById(Long id);

	T findById(@Param(value = "id") Long id);
}
