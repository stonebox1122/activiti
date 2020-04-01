package com.stone.activiti.personaltask;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

import java.util.HashMap;
import java.util.Map;

/**
 * ExpressionAssign: 通过表达式进行流程处理人分配
 *
 * @author Stone
 * @version V1.0
 * @date 2020/3/31
 **/
public class ExpressionAssign {

    public static void main(String[] args) {
        // 1. 创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 2. 创建RuntimeService对象
        RuntimeService runtimeService = processEngine.getRuntimeService();

        // 3. 设置assignee的值，用户可以在界面上设置流程的执行人
        Map<String, Object> map = new HashMap<>();
        map.put("assignee0","zhangsan");
        map.put("assignee1","lisi");
        map.put("assignee2","wangwu");

        // 3. 创建ProcessInstance对象
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myProcess_2", map);
    }
}
