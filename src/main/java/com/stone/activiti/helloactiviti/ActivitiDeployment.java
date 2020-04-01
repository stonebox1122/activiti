package com.stone.activiti.helloactiviti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;

/**
 * ActivitiDeployment: 定义流程的部署
 *
 * @author Stone
 * @version V1.0
 * @date 2020/3/27
 **/
public class ActivitiDeployment {

    public static void main(String[] args) {
        // 1. 创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 2. 创建RepositoryService对象
        RepositoryService repositoryService = processEngine.getRepositoryService();

        // 3. 进行部署
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("diagram/holiday2.bpmn")
                .addClasspathResource("diagram/holiday2.png")
                .name("请假流程")
                .deploy();

        System.out.println(deployment.getId());
        System.out.println(deployment.getName());
    }
}
