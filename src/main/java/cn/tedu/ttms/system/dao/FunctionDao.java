package cn.tedu.ttms.system.dao;

import cn.tedu.ttms.common.dao.BaseDao;
import cn.tedu.ttms.system.entity.Function;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author: lulin
 * @Date: 3/23/2019 11:14 AM
 * @Version 1.0
 */
@Repository

public interface FunctionDao extends BaseDao<Function> {
    List<Map<String,Object>> findTreeData();
    int hasChild(Long functionId);
    List< Map<String ,Object> > findObject();
    Long findParentId(@Param("id") Long id);
}
