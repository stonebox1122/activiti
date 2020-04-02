package com.stone.activiti.grouptask;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

/**
 * GroupTaskSetAssigneeToOther: 任务交接，将任务转交给其他候选人
 *
 * @author Stone
 * @version V1.0
 * @date 2020/3/27
 **/
public class GroupTaskSetAssigneeToOther {

    public static void main(String[] args) {
        // 1. 创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 2. 得到TaskService对象
        TaskService taskService = processEngine.getTaskService();

        // 3. 根据流程定义的key和任务负责人来实现任务查询，如果wangwu是负责人才可以归还组任务
        Task task = taskService.createTaskQuery()
                .processDefinitionKey("holiday4")
                .taskAssignee("wangwu")
                .singleResult();

        System.out.println(task);

        // 4. 交接任务给lishi，也是候选人lishi拾取任务的过程
        if (task != null) {
            taskService.setAssignee(task.getId(), "lishi");
        }

    }
}
