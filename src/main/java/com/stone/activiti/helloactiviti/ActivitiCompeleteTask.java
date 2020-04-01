package com.stone.activiti.helloactiviti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import java.util.List;

/**
 * ActivitiCompeleteTask: 完成当前用户的任务
 *
 * @author Stone
 * @version V1.0
 * @date 2020/3/27
 **/
public class ActivitiCompeleteTask {

    public static void main(String[] args) {
        // 1. 创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 2. 得到TaskService对象
        TaskService taskService = processEngine.getTaskService();

        // 3. 根据流程定义的key和负责人assignee来实现当前用户的任务列表查询
        List<Task> taskList = taskService.createTaskQuery()
                .processDefinitionKey("myProcess_2")
                .taskAssignee("zhangsan")
                .list();

        // 4. 处理任务
        for (Task task : taskList) {
            taskService.complete(task.getId());
        }
    }
}
