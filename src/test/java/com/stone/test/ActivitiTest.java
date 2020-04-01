package com.stone.test;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.junit.Test;

/**
 * ActivitiTest: 生成Activiti表
 *
 * @author Stone
 * @version V1.0
 * @date 2020/3/26
 **/
public class ActivitiTest {

    @Test
    public void testGenTable() {
        // 1. 创建ProcessEngineConfiguration对象
        ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");

        // 2. 创建ProcessEngine对象，生成对应的表
        ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
    }

}
