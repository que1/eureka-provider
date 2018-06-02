package com.test.spring.cloud.eureka.provider.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

/**
 * ProjectName: com.test.spring.cloud.eureka.client.api
 * ClassName:   HelloController
 * Copyright:
 * Company:     xunlei
 * @author:     queyiwen
 * @version:    1.0
 * @since:      jdk 1.7
 * Create at:   2018/5/29
 * Description:
 * <p>
 * <p>
 * Modification History:
 * Date       Author      Version      Description
 * -------------------------------------------------------------
 *
 *
 */
@RestController
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello() {
        List<String> serviceList = this.discoveryClient.getServices();
        for (String serviceName : serviceList) {
            logger.info("service-name: " + serviceName);
        }
        return "hello world";
    }


    @RequestMapping(value = "/hystrix", method = RequestMethod.GET)
    public String hystrix() {
        logger.info("...start...");

        int sleepTime = new Random().nextInt(1200);
        logger.info("...sleep: " + sleepTime + "ms...");
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            logger.error(e.getMessage(), e);
        }
        logger.info("...end...");
        return "hystrix test";
    }

}
