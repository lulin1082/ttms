package cn.tedu.ttms.system.controller;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: lulin
 * @Date: 3/31/2019 6:29 PM
 * @Version 1.0
 */
@Component
@RequestMapping("/org")
public class OrganizationController {



    @RequestMapping("/editUI")
    public String editUI(){
        return "system/org_edit";
    }

    @RequestMapping("/listUI")
    public String listUI(){
        return  "system/org_list";
    }
   /* findObjects
    save
    update
            findById
    doValidById*/
}
