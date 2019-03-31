package cn.tedu.ttms.system.service;

import cn.tedu.ttms.system.entity.Function;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: lulin
 * @Date: 3/24/2019 7:25 PM
 * @Version 1.0
 */
@Service
public interface FunctionService {

    List<Map<String, Object>> findTreeData();

    void save(Function entity);

    Map<String,Object> findFunctionById(Long functionId);

    List<Map<String, Object>>  findObjects();

    void updateFunction(Function entity);

    void deleteFunction(Long functionId);
}
