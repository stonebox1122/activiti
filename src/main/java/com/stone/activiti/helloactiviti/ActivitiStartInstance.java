package com.stone.activiti.helloactiviti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * ActivitiStartInstance: 流程实例启动
 *
 * @author Stone
 * @version V1.0
 * @date 2020/3/27
 **/
public class ActivitiStartInstance {

    public static void main(String[] args) {
        // 1. 创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 2. 创建RuntimeService对象
        RuntimeService runtimeService = processEngine.getRuntimeService();

        // 3. 创建流程实例
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myProcess_1");

        System.out.println(processInstance.getProcessDefinitionId());
        System.out.println(processInstance.getId());

    }
}
