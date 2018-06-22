package com.test.spring.cloud.eureka.provider.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ProjectName: com.test.spring.cloud.eureka.provider.api
 * ClassName:   TestController
 * Copyright:
 * Company:     xunlei
 *
 * @author: queyiwen
 * @version: 1.0
 * @since: jdk 1.7
 * Create at:   2018/6/22
 * Description:
 * <p>
 * <p>
 * Modification History:
 * Date       Author      Version      Description
 * -------------------------------------------------------------
 */
@RestController
@RequestMapping(value = "/test/api")
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(NlpController.class);

    @PostMapping(value = "/textfilter-post")
    @ResponseBody
    public String filterPost(HttpServletRequest request, HttpServletResponse response) {
        String param1 = request.getParameter("param1");
        String param2 = request.getParameter("param2");
        logger.info("/textfilter-post, param1: " + param1 + ", param2: " + param2);
        return "{\"noPass\":\"0.111\",\"pass\":\"0.888\"}";
    }

}
