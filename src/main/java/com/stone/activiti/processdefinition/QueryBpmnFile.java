package com.stone.activiti.processdefinition;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.apache.commons.io.IOUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * QueryBpmnFile:
 * 1. 从Activiti的act_ge_bytearray表中读取两个资源文件
 * 2. 将两个资源文件存到指定路径
 *
 * @author Stone
 * @version V1.0
 * @date 2020/3/30
 **/
public class QueryBpmnFile {

    public static void main(String[] args) throws IOException {
        // 1. 创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 2. 创建RepositoryService对象
        RepositoryService repositoryService = processEngine.getRepositoryService();

        // 3. 创建ProcessDefinitionQuery对象
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();

        // 4. 设置条件，进行查询获取流程定义
        ProcessDefinition processDefinition = processDefinitionQuery.processDefinitionKey("myProcess_1").singleResult();

        // 5. 从流程定义信息中得到部署Id，png图片资源名称和bpmn文件名称
        String deploymentId = processDefinition.getDeploymentId();
        String diagramResourceName = processDefinition.getDiagramResourceName();
        String resourceName = processDefinition.getResourceName();

        // 6. 通过RepositoryService的方法，实现读取图片信息及文件信息
        InputStream pngIs = repositoryService.getResourceAsStream(deploymentId, diagramResourceName);
        InputStream bpmnIs = repositoryService.getResourceAsStream(deploymentId, resourceName);

        // 7. 构建输出流
        OutputStream pngOs = new FileOutputStream("D:\\temp\\diagram\\holiday.png");
        OutputStream bpmnOs = new FileOutputStream("D:\\temp\\diagram\\holiday.bpmn");

        // 8. 输入流，输出流转换
        IOUtils.copy(pngIs,pngOs);
        IOUtils.copy(bpmnIs,bpmnOs);

        // 9. 关闭流
        pngOs.close();
        bpmnOs.close();
        pngIs.close();
        bpmnIs.close();
    }
}
