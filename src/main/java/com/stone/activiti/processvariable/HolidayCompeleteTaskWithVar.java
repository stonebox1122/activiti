package com.stone.activiti.processvariable;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import java.util.HashMap;
import java.util.Map;

/**
 * HolidayCompeleteTask: 完成当前用户的任务
 *
 * @author Stone
 * @version V1.0
 * @date 2020/3/27
 **/
public class HolidayCompeleteTaskWithVar {

    public static void main(String[] args) {
        // 1. 创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 2. 得到TaskService对象
        TaskService taskService = processEngine.getTaskService();

        // 3. 根据流程定义的key和负责人assignee来实现当前用户的任务列表查询
        // 执行人顺序为zhangsan->lisi->wangwu->zhaoliu，因为请假天数为5，会走到部门经理wangwu
        Task task = taskService.createTaskQuery()
                .processDefinitionKey("holiday_3")
//                .taskAssignee("zhangsan")
//                .taskAssignee("lisi")
//                .taskAssignee("wangwu")
                .taskAssignee("zhaoliu")
                .singleResult();

        // 4. 定义全局变量
//        Map<String, Object> variables = new HashMap<>();
//        Holiday holiday = new Holiday();
//        holiday.setNum(5F);
//        variables.put("holiday",holiday);

        // 5. 处理任务，并设置流程变量的值
        if (task != null) {
            taskService.complete(task.getId());
            System.out.println(task.getAssignee() + "：任务执行完毕");
        }
    }
}
