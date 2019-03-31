package cn.tedu.ttms.system.service.impl;

import cn.tedu.ttms.common.exception.UpdateRuntimeException;
import cn.tedu.ttms.common.web.PageObject;
import cn.tedu.ttms.common.web.SpringListUtil;
import cn.tedu.ttms.system.dao.RoleDao;
import cn.tedu.ttms.system.dao.UsersDao;
import cn.tedu.ttms.system.dao.UserRoleDao;
import cn.tedu.ttms.system.entity.User;
import cn.tedu.ttms.system.entity.UserRole;
import cn.tedu.ttms.system.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Author: lulin
 * @Date: 3/24/2019 7:38 PM
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UsersDao userDao;

    @Resource
    RoleDao roleDao;

    @Resource
    UserRoleDao userRoleDao;

    @Override
    public  Map<String, Object> findObjects(User user, PageObject pageObject) {
        List<Map<String, Object>> list =  userDao.findObjects(user, pageObject);
        pageObject.setRowCount(userDao.getRowCounts(user));
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("list", list);
        map.put("pageObj",pageObject);
        return map;
    }

    @Override
    public List<Map<String, Object>> findRoleList() {

        List<Map<String,Object>> roleList = roleDao.findRoleList();
        if(roleList==null || roleList.size()==0){
            throw new RuntimeException("获取角色列表失败！");
        }
        return roleList;
    }

    @Override
    public void saveUser(User user, String roleIdList) {

        Long userid=user.getId();
        UserRole userRole =new UserRole();
        String []roleId =roleIdList.split(",");
        int isExist=userDao.isExist(user.getUsername());
        //  userDao.findObjectById(user.getId());
        if(userDao.getRowCounts(user)>0)
            for(String id:roleId){
                userRole.setUser_id(userid);
                userRole.setRole_id(Long.parseLong(id));
                userRoleDao.save(userRole);
            }


    }

    @Override
    public Map<String, Object> findUserById(Long userId) {

        Map<String, Object> user=  userDao.findObjectById(userId);

        return user;
    }

    @Override
    public void updateUser(User user, String roleIdList) {
        /*Long userid=user.getId();
        UserRole userRole =new UserRole();
        String []roleId =roleIdList.split(",");
        int isExist=userDao.isExist(user.getUsername());
        //  userDao.findObjectById(user.getId());
        if(userDao.getRowCounts(user)>0)
            for(String id:roleId){
                userRole.setUser_id(userid);
                userRole.setRole_id(Long.parseLong(id));
                userRoleDao.updateObject(userRole);
            }*/

        if(user==null){
            throw new NullPointerException("保存用户信息，用户对象不能为空！");
        }
        String saltStr = UUID.randomUUID().toString();
        ByteSource salt = ByteSource.Util.bytes(saltStr);
        String pwd = new SimpleHash("MD5",user.getPassword(),salt).toString();
//		String pwd = HashUtil.hashMD5Base64(salt, user.getPassword());
        user.setPassword(pwd);
        user.setSalt(saltStr);
        //保存用户信息
        int i = userDao.save(user);
        if(i!=1){
            throw new RuntimeException("保存用户信息失败！");
        }
        //保存用户角色信息
        //将接受到的roleIdList转换为List<Integer>
        List<Integer> listInt = null;
        listInt = SpringListUtil.parseIntegerList(roleIdList, listInt);

        Map<String, Object> map = new HashMap<String,Object>();
        map.put("userId", user.getId());
        map.put("roleIdList",listInt);

        int counts = userRoleDao.saveObject(map);
        if(counts!=listInt.size()){
            throw new RuntimeException("保存用户角色失败！");
        }
    }

    @Override
    public void changeState(Long userId, Integer valid) {
        if(userId==null){
            throw new RuntimeException("修改用户状态，用户id不能为空！");
        }
        if(valid==null){
            throw new RuntimeException("修改用户状态，valid值不能为空！");
        }
        if( userDao.changeState(userId,valid)<1){
            throw new UpdateRuntimeException("切换用户启用禁用状态失败！");
        }
    }

    @Override
    public List<String> findPermission(Long userId) {
        if(userId==null){
            throw new NullPointerException("查询用户权限用户id不能为空！");
        }
        return userDao.findPermission(userId);
    }

    @Override
    public List<Map<String, Object>> menuList() {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("currentUser");
        return userDao.menuList(user.getId());
    }

    @Override
    public List<String> findRole(Long userId) {
        if(userId==null){
            throw new NullPointerException("用户不存在");
        }
        return userDao.findRole(userId);
    }

    @Override
    public User findUserByName(String name) {
        if(name==null){
            throw new NullPointerException("名字不能为空");
        }
        User user=userDao.findObjectByName(name);
        if(user==null){
            throw new NullPointerException( name+"不存在");
        }
        return user;
    }

}
