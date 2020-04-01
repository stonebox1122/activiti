package com.stone.activiti.processdefinition;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricActivityInstanceQuery;

import java.util.List;

/**
 * HistoryQuery: 历史数据的查询
 *
 * @author Stone
 * @version V1.0
 * @date 2020/3/30
 **/
public class HistoryQuery {

    public static void main(String[] args) {
        // 1. 创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 2. 创建HistoryService对象
        HistoryService historyService = processEngine.getHistoryService();

        // 3. 创建HistoricActivityInstanceQuery对象
        HistoricActivityInstanceQuery historicActivityInstanceQuery = historyService.createHistoricActivityInstanceQuery();

        // 4. 执行查询
        List<HistoricActivityInstance> list = historicActivityInstanceQuery
                .processInstanceId("2501")
                .orderByHistoricActivityInstanceStartTime()
                .asc()
                .list();

        for (HistoricActivityInstance historicActivityInstance : list) {
            System.out.println(historicActivityInstance.getActivityId());
            System.out.println(historicActivityInstance.getActivityName());
            System.out.println(historicActivityInstance.getProcessDefinitionId());
            System.out.println(historicActivityInstance.getProcessInstanceId());
            System.out.println("===================");
        }

    }
}
