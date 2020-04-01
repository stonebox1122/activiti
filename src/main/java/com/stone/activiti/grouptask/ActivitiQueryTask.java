package com.stone.activiti.grouptask;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import java.util.List;

/**
 * ActivitiQueryTask: 查询当前用户的任务列表
 *
 * @author Stone
 * @version V1.0
 * @date 2020/3/27
 **/
public class ActivitiQueryTask {

    public static void main(String[] args) {
        // 1. 创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 2. 得到TaskService对象
        TaskService taskService = processEngine.getTaskService();

        // 3. 根据流程定义的key和负责人assignee来实现当前用户的任务列表查询
        List<Task> taskList = taskService.createTaskQuery()
                .processDefinitionKey("holiday4")
                .taskAssignee("wangwu")
                .list();

        // 4. 输出任务列表
        for (Task task : taskList) {
            System.out.println("流程实例Id："+task.getProcessInstanceId());
            System.out.println("任务Id："+task.getId());
            System.out.println("任务名称："+task.getName());
            System.out.println("任务负责人："+task.getAssignee());
        }
    }
}
