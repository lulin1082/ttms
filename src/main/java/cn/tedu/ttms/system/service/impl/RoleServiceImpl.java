package cn.tedu.ttms.system.service.impl;

import cn.tedu.ttms.common.web.PageObject;
import cn.tedu.ttms.common.web.SpringListUtil;
import cn.tedu.ttms.system.dao.*;
import cn.tedu.ttms.system.entity.Role;
import cn.tedu.ttms.system.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: lulin
 * @Date: 3/24/2019 7:37 PM
 * @Version 1.0
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    UsersDao userDao;
    @Resource
    RoleDao roleDao;
    @Resource
    UserRoleDao userRoleDao;
    @Resource
    RoleFunctionDao roleFunctionDao;
    @Resource
    FunctionDao functionDao;

    @Override
    public Map<String, Object> findObjects(Role role, PageObject pageObj) {
        List<Map<String,Object>> list=roleDao.findObjects(role,pageObj);
        pageObj.setRowCount(roleDao.getRowCounts(role));
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("list", list);
        map.put("pageObj",pageObj);
        return map;
    }

    @Override
    public List<Map<String, Object>> loadMenuTree() {
        return functionDao.findTreeData();

    }

    @Override
    public void save(Role role, String menuIdList) {
        /*String []ids=menuIdList.split(",");
        roleFunctionDao.saveRoleList(role.getId(),ids);*/

        if(role==null){
            throw new NullPointerException("添加角色，角色对象不能为空!");
        }
        //保存角色信息
        int i = roleDao.save(role);
        if(i!=1){
            throw new RuntimeException("添加角色失败！");
        }
        //保存角色菜单关系
        //将String类型的menuIdList 转换为List<Integer>
        List<Integer> listInt = null;
        listInt = SpringListUtil.parseIntegerList(menuIdList, listInt);
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("roleId", role.getId());
        map.put("menuIdList", listInt);
        //int counts = roleFunctionDao.save(map);

        String []list=menuIdList.split(",");
        int counts=roleFunctionDao.saveRoleList(role.getId(),list);

        if(counts!=listInt.size()){
            throw new RuntimeException("添加角色授权失败！");
        }
    }

    @Override
    public Map<String, Object> findRoleById(Long roleId) {
        if(roleId==null){
            throw new NullPointerException("修改角色信息，角色id不能为空！");
        }
        Map<String, Object> map = roleDao.findObjectById(roleId);
        if(map==null || map.size()==0){
            throw new RuntimeException("修改角色信息查询失败！");
        }
        List<Integer> menuIdList = roleFunctionDao.findRelatedIdListById(roleId);
        if(menuIdList==null || menuIdList.size()==0){
            throw new RuntimeException("修改角色信息,查询角色权限失败！");
        }

        map.put("menuIdList", menuIdList);
        return map;
    }

    @Override
    public void updateRole(Role role, String menuIdList) {

  /*      if(roleFunctionDao.deletObject(role.getId())>0) {

            String[] ids = menuIdList.split(",");
            roleFunctionDao.saveRoleList(role.getId(), ids);
        }
        throw  new UpdateRuntimeException("role menuIdlist fail");
*/

        if(role==null){
            throw new NullPointerException("修改角色信息，角色对象不能为空！");
        }
        int i = roleDao.updateObject(role);   //更新角色名称和备注
        if(i!=1){
            throw new RuntimeException("更新角色信息失败！");
        }
        //更新角色菜单关系   - 先删除后添加
        //将String类型的menuIdList 转换为List<Integer>
        List<Integer> listInt = null;
        listInt = SpringListUtil.parseIntegerList(menuIdList, listInt);

        int counts = roleFunctionDao.deletObject(role.getId());
        if(counts<1){
            throw new RuntimeException("修改更新角色信息失败！");
        }
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("roleId", role.getId());
        map.put("menuIdList", listInt);
        int cous = roleFunctionDao.saveObject(map);
        if(cous!=listInt.size()){
            throw new RuntimeException("修改更新角色授权失败！");
        }
    }

    @Override
    public void deleteRole(Long roleId) {
           /* if(roleDao.deletObject(roleId)>0){
                   roleFunctionDao.deletObject(roleId);
             }
            throw new RuntimeException("delete fail");*/

        System.err.println(roleId);
        if(roleId==null){
            throw new NullPointerException("删除角色信息，角色id不能为空！");
        }
        //查看是否有用户占用此角色
        int counts = userRoleDao.isExist(roleId);
        if(counts!=0){
            throw new RuntimeException("该角色已被用户占用，不能删除！");
        }
        //删除角色信息
        int i = roleDao.deletObject(roleId);
        if(i!=1){
            throw new RuntimeException("删除角色信息失败！");
        }
        //删除角色菜单关系
        int rows = roleFunctionDao.deletObject(roleId);
        if(rows==0){
            throw new RuntimeException("删除角色菜单关系失败！");
        }

    }


}
