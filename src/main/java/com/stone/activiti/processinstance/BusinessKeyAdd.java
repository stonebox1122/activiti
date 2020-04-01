package com.stone.activiti.processinstance;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * BusinessKeyAdd: 流程实例启动，添加businessKey
 *
 * @author Stone
 * @version V1.0
 * @date 2020/3/27
 **/
public class BusinessKeyAdd {

    public static void main(String[] args) {
        // 1. 创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 2. 创建RuntimeService对象
        RuntimeService runtimeService = processEngine.getRuntimeService();

        // 3. 创建流程实例，同时还要指定业务标识businessKey
        // 第一个参数为流程定义key，第二个参数为业务标识key（例如请假表的id）
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myProcess_1","1001");

        System.out.println(processInstance.getBusinessKey());
    }
}
