package com.kingja.activiti;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * Description:TODO
 * Create Time:2020/8/26 0026 下午 3:03
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@SpringBootTest
public class Part3_ProcessInstance {
    @Autowired
    private RuntimeService runtimeService;

    /**
     * 初始化流程实例
     */
    @Test
    public void initProcessInstance() {
        //1. 获取页面表单填报的内容，请假时间，请假事由，String formData
        //2. formData写入业务表，返回业务表主键ID=businessKey
        //3. 把业务数据与Activiti7流程数据关联
//        act_ru_execution 会增加两条数据，开始和结束节点
        ProcessInstance processInstance=runtimeService.startProcessInstanceByKey("myProcess_Task","bk002");
        System.out.println("流程实例Id："+processInstance.getProcessDefinitionId());


    }


    /**
     * 获取流程实例
     */
    @Test
    public void getProcessInstances() {
        List<ProcessInstance> list = runtimeService.createProcessInstanceQuery().list();
        for (ProcessInstance processInstance : list) {
            System.out.println("----------流程实例----------");
            System.out.println("ProcessInstanceId : "+processInstance.getProcessInstanceId());
            System.out.println("ProcessDefinitionId : "+processInstance.getProcessDefinitionId());
            System.out.println("isEnded : "+processInstance.isEnded());
            System.out.println("isSuspended : "+processInstance.isSuspended());

        }
    }

    /**
     * 暂定与激活流程实例
     */
    @Test
    public void activitieProcessInstance() {
//        runtimeService.suspendProcessInstanceById("ad652470-e778-11ea-8c97-b8975aed9046");
//        System.out.println("挂起流程实例");
        runtimeService.activateProcessInstanceById("ad652470-e778-11ea-8c97-b8975aed9046");
        System.out.println("激活流程实例");
    }

    /**
     * 删除流程定义
     */
    @Test
    public void delDefinition() {
        runtimeService.deleteProcessInstance("ad652470-e778-11ea-8c97-b8975aed9046","测试删除");
        System.out.println("删除流程实例");
    }
}
