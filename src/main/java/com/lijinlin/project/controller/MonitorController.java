package com.lijinlin.project.controller;

import com.lijinlin.project.controller.monitor.Api;
import com.lijinlin.project.controller.monitor.AuthResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lijinlin
 * @date2021年05月14日 16:27
 */
@RestController
public class MonitorController {


    @RequestMapping("/getAuthentication")
    public AuthResponse getAuthentication() {
        //获取身份认证
        AuthResponse res = null;
        try {
            res = Api.auth();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
