package com.stone.activiti.processvariable;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

import java.util.HashMap;
import java.util.Map;

/**
 * HolidayStartInstanceWithoutVar: 流程实例启动，不设置流程变量的值
 *
 * @author Stone
 * @version V1.0
 * @date 2020/3/27
 **/
public class HolidayStartInstanceWithoutVar {

    public static void main(String[] args) {
        // 1. 创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 2. 创建RuntimeService对象
        RuntimeService runtimeService = processEngine.getRuntimeService();

//        // 3. 定义全局变量
//        Map<String, Object> variables = new HashMap<>();
//        Holiday holiday = new Holiday();
//        holiday.setNum(1F);
//        variables.put("holiday",holiday);

        // 4. 启动流程实例，不设置全局变量
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("holiday_3");

        System.out.println(processInstance.getProcessDefinitionId());
        System.out.println(processInstance.getId());

    }
}
