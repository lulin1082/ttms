package cn.tedu.ttms.system.service.impl;

import cn.tedu.ttms.common.exception.SaveRuntimeException;
import cn.tedu.ttms.common.exception.UpdateRuntimeException;
import cn.tedu.ttms.system.dao.FunctionDao;
import cn.tedu.ttms.system.dao.RoleFunctionDao;
import cn.tedu.ttms.system.entity.Function;
import cn.tedu.ttms.system.service.FunctionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author: lulin
 * @Date: 3/24/2019 7:45 PM
 * @Version 1.0
 */
@Service
public class FunctionServiceImpl implements FunctionService {


    @Resource
    FunctionDao functionDao;

    @Resource
    RoleFunctionDao roleFunctionDao;

    @Override
    public List<Map<String, Object>> findTreeData() {
        List<Map<String, Object>> findTreeData = functionDao.findTreeData();
        return findTreeData;
    }

    @Override
    public void save(Function entity) {
        if(functionDao.save(entity)<1){
            throw new SaveRuntimeException("Function 插入不成功");
        }
    }

    @Override
    public Map<String, Object> findFunctionById(Long functionId) {

        if(functionId==null)
            throw new NullPointerException("id 不能为空");
        Map<String, Object> function = functionDao.findObjectById(functionId);

        if(function==null || function.size()==0){
            throw new RuntimeException("修改菜单信息过程中获取菜单信息失败！");
        }
        return function;

    }

    @Override
    public List<Map<String, Object>> findObjects() {

        List<Map<String, Object>> functions=functionDao.findObject();
        return  functions;
    }

    @Override
    public void updateFunction(Function entity) {


            if (functionDao.updateObject(entity) > 0) {
                return;
            }

            throw new UpdateRuntimeException("tms update fail");

    }


    @Override
    public void deleteFunction(Long functionId) {


        if(functionDao.hasChild(functionId)>0){
            Long parentid=functionDao.findParentId(functionId);
            if(functionDao.deletObject(functionId)>0){
                roleFunctionDao.findRelatedIdListById(functionId);
            }
            deleteFunction(parentid);
        }else {
            return;
        }
        throw new RuntimeException("delete fail");


       /* if(menuId==null){
            throw new NullPointerException("删除菜单，菜单id不能为空！");
        }
        int count = menuDao.hasChild(menuId);
        if(count!=0){
            throw new RuntimeException("请先删除子菜单或按钮！");
        }
        int i = menuDao.deletObject(menuId);
        if(i!=1){
            throw new RuntimeException("删除菜单失败！");
        }*/

    }


}
