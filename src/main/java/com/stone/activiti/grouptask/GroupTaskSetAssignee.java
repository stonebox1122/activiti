package com.stone.activiti.grouptask;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import java.util.List;

/**
 * GroupTaskSetAssignee: 拾取组任务，将候选人转化为任务执行人
 *
 * @author Stone
 * @version V1.0
 * @date 2020/3/27
 **/
public class GroupTaskSetAssignee {

    public static void main(String[] args) {
        // 1. 创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 2. 得到TaskService对象
        TaskService taskService = processEngine.getTaskService();

        // 3. 根据流程定义的key和候选人来实现当前组任务列表查询
        Task task = taskService.createTaskQuery()
                .processDefinitionKey("holiday4")
                .taskCandidateUser("wangwu")
                .singleResult();

        // 4. 拾取组任务
        if (task != null) {
            taskService.claim(task.getId(), "wangwu");
        }

    }
}
