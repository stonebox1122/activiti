package com.stone.activiti.grouptask;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

/**
 * ReturnGroupTask: 归还组任务，实际上就是讲任务执行人设置为null
 *
 * @author Stone
 * @version V1.0
 * @date 2020/3/27
 **/
public class ReturnGroupTask {

    public static void main(String[] args) {
        // 1. 创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 2. 得到TaskService对象
        TaskService taskService = processEngine.getTaskService();

        // 3. 校验wangwu是否是该任务的负责人，如果是负责人才可以归还组任务
        Task task = taskService.createTaskQuery()
                .processDefinitionKey("holiday4")
                .taskAssignee("lishi")
                .singleResult();

        // 4. 拾取组任务
        if (task != null) {
            taskService.setAssignee(task.getId(), null);
        }

    }
}
