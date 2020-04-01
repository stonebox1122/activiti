package com.stone.activiti.processvariable;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;

/**
 * SetGlobalVar:
 *
 * @author Stone
 * @version V1.0
 * @date 2020/4/1
 **/
public class SetGlobalVar {

    public static void main(String[] args) {
//        setGlobalVariableByExecutionId();
        setGlobalVariableByTaskId();
    }

    public static void setGlobalVariableByExecutionId(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();

        //当前流程实例执行id，通常设置为当前执行的流程实例的id
        String executionId="62501";
        Holiday holiday = new Holiday();
        holiday.setNum(3F);

        //通过流程实例 id设置流程变量
        runtimeService.setVariable(executionId, "holiday", holiday);

        // 一次设置多个值
        // runtimeService.setVariables(executionId, variables)
    }

    public static void setGlobalVariableByTaskId(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();

        //当前待办任务id
        String taskId=taskService.createTaskQuery()
                .processDefinitionKey("holiday_3")
                .taskAssignee("zhangsan").singleResult().getId();
        Holiday holiday = new Holiday();
        holiday.setNum(4F);

        //通过任务设置流程变量
        taskService.setVariable(taskId, "holiday", holiday);

        //一次设置多个值
        //taskService.setVariables(taskId, variables)
    }
}
