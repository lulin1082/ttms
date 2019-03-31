package cn.tedu.ttms.system.controller;

import cn.tedu.ttms.common.web.JsonResult;
import cn.tedu.ttms.system.entity.Function;
import cn.tedu.ttms.system.service.FunctionService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import java.util.Map;

/**
 * @Author: lulin
 * @Date: 3/24/2019 12:33 AM
 * @Version 1.0
 */
@Controller
@RequestMapping("/function")
public class FunctionController {


    @Autowired
    private FunctionService functionService;

    @RequestMapping("listUI")
    //@RequiresPermissions("sys:function:view")
    public String listUI(){
        return "system/function_list";
    }

    /**
     * 查找所有菜单
     *
     * @return
     */
    @RequestMapping("findObjects")
    @ResponseBody
    public JsonResult findObjects(){
        List<Map<String, Object>> list = functionService.findObjects();
        return new JsonResult(list);
    }

    /**
     * 新增
     */
    @RequestMapping("editUI")
    public String editUI(){
        return "system/function_edit";
    }

    /**
     * 加载选择菜单树结构
     */
    @RequestMapping("treeUI")
    @ResponseBody
    public JsonResult treeUI(){
        List<Map<String, Object>> list = functionService.findTreeData();
        return new JsonResult(list);
    }

    /**
     * 添加菜单
     */
    @RequestMapping("addFunction")
    @ResponseBody
    public JsonResult save(Function entity){
        functionService.save(entity);
        return new JsonResult();
    }

    /**
     * 根据id查询菜单信息
     */
    @RequestMapping("findFunctionById")
    @ResponseBody
    public JsonResult findFunctionById(Long functionId){
        Map<String, Object> map = functionService.findFunctionById(functionId);
        return new JsonResult(map);
    }

    /**
     * updateFunction
     */
    @RequestMapping("updateFunction")
    @ResponseBody
    public JsonResult updateFunction(Function entity){
        functionService.updateFunction(entity);
        return new JsonResult();
    }

    /**
     * 判断要删除的菜单是否有子菜单
     */
    @RequestMapping("deleteFunction")
    @ResponseBody
    public JsonResult deleteFunction(Long functionId){
        functionService.deleteFunction(functionId);
        return new JsonResult();
    }
}
