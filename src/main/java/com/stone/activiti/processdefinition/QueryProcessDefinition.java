package com.stone.activiti.processdefinition;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;

import java.util.List;

/**
 * QueryProcessDefinition: 查询流程定义信息
 *
 * @author Stone
 * @version V1.0
 * @date 2020/3/30
 **/
public class QueryProcessDefinition {

    public static void main(String[] args) {
        // 1. 创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 2. 创建RepositoryService对象
        RepositoryService repositoryService = processEngine.getRepositoryService();

        // 3. 创建ProcessDefinitionQuery对象
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();

        // 4. 设置条件，进行查询
        List<ProcessDefinition> list = processDefinitionQuery.processDefinitionKey("myProcess_1")
                .orderByProcessDefinitionVersion()
                .desc().list();

        // 5. 输出流程定义信息
        for (ProcessDefinition processDefinition : list) {
            System.out.println("流程部署Id：" + processDefinition.getDeploymentId());
            System.out.println("流程定义Id：" + processDefinition.getId());
            System.out.println("流程定义名称：" + processDefinition.getName());
            System.out.println("流程定义Key：" + processDefinition.getKey());
            System.out.println("流程定义版本：" + processDefinition.getVersion());
        }
    }
}
