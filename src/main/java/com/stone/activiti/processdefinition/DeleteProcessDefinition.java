package com.stone.activiti.processdefinition;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;

import java.util.List;

/**
 * DeleteProcessDefinition: 删除已经部署的流程定义信息
 *
 * @author Stone
 * @version V1.0
 * @date 2020/3/30
 **/
public class DeleteProcessDefinition {

    public static void main(String[] args) {
        // 1. 创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 2. 创建RepositoryService对象
        RepositoryService repositoryService = processEngine.getRepositoryService();

        // 3. 执行删除流程定义，参数为流程部署Id
        // 如果repositoryService.deleteDeployment("1", true)设置为true，则级联删除，即使该流程有流程实例启动也可以删除
        // 此时先删除没有完成的流程节点，最后就可以删除流程定义信息
        repositoryService.deleteDeployment("35001");
    }
}
