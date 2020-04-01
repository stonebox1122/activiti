package com.stone.activiti.processinstance;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * SuspendSingleProcessInstance: 单个流程实例挂起与激活
 *
 * @author Stone
 * @version V1.0
 * @date 2020/3/30
 **/
public class SuspendSingleProcessInstance {

    public static void main(String[] args) {
        // 1. 创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 2. 创建RuntimeService对象
        RuntimeService runtimeService = processEngine.getRuntimeService();

        // 3. 创建ProcessInstance对象
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processDefinitionKey("myProcess_1").singleResult();

        // 4. 获取状态及Id
        boolean suspended = processInstance.isSuspended();
        String processInstanceId = processInstance.getId();

        // 5. 根据状态进行激活或者挂起
        if (suspended) {
            runtimeService.activateProcessInstanceById(processInstanceId);
            System.out.println("流程实例" + processInstanceId + "激活");
        } else {
            runtimeService.suspendProcessInstanceById(processInstanceId);
            System.out.println("流程实例" + processInstanceId + "挂起");
        }

    }
}
