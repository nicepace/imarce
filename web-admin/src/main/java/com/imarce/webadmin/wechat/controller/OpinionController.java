/**
 * @Title: OpinionController.java
 * @Package com.imarce.wechat.controller
 * @Description: TODO
 * Copyright: Copyright (c) 2015
 * Company:琅琊科技
 *
 * @author 琅琊科技技术部-Administrator
 * @date 2016年6月16日 下午3:10:15
 * @version V1.0
 */
package com.imarce.webadmin.wechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imarce.core.service.Result;
import com.imarce.wechat.entity.Opinion;
import com.imarce.webadmin.service.impl.OpinionService;

@Controller
@RequestMapping(value = "/opinion")
public class OpinionController {
    @Autowired
    private OpinionService opinionService;
    /**
     * 
     * @Description: 发布一条建议
     * @param    
     * @return   String
     * @throws
     */
    @RequestMapping("/insert_opinion")
    @ResponseBody
    public Result insertOpinion(String  opinion){
        Opinion op = new Opinion();
        op.setOpinion( opinion );
        return opinionService.insertOpinion( op );
    }
}
