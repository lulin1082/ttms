package cn.tedu.ttms.common.controller;

import cn.tedu.ttms.common.web.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: lulin
 * @Date: 4/1/2019 5:50 PM
 * @Version 1.0
 */
@Controller
@RequestMapping("/")
public class UnauthorizedController {

    @RequestMapping("unauthorized")
    @ResponseBody
    public JsonResult unauthorized(){
        return new JsonResult(  );
    }

}
