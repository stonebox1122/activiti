package com.stone.activiti.processinstance;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;

import java.util.List;

/**
 * SuspendAllProcessInstance: 全部流程实例挂起与激活
 *
 * @author Stone
 * @version V1.0
 * @date 2020/3/30
 **/
public class SuspendAllProcessInstance {

    public static void main(String[] args) {
        // 1. 创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 2. 创建RepositoryService对象
        RepositoryService repositoryService = processEngine.getRepositoryService();

        // 3. 创建ProcessDefinition对象
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .processDefinitionKey("myProcess_1").singleResult();

        // 4. 获取状态及Id
        boolean suspended = processDefinition.isSuspended();
        String processDefinitionId = processDefinition.getId();

        // 5. 根据状态进行激活或者挂起
        if (suspended) {
            repositoryService.activateProcessDefinitionById(processDefinitionId, true, null);
            System.out.println("流程定义" + processDefinitionId + "激活");
        } else {
            repositoryService.suspendProcessDefinitionById(processDefinitionId, true, null);
            System.out.println("流程定义" + processDefinitionId + "挂起");
        }

    }
}
