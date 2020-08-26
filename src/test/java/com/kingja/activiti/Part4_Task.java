package com.kingja.activiti;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
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
public class Part4_Task {
    @Autowired
    private TaskService taskService;

    /**
     * 任务查询
     */
    @Test
    public void getTasks() {
        List<Task> list = taskService.createNativeTaskQuery().list();
        for (Task task : list) {
            System.out.println("Id : "+task.getId());
            System.out.println("Name : "+task.getName());
            System.out.println("Assignee : "+task.getAssignee());
        }
    }

    /**
     * 任务我的待办查询
     */
    @Test
    public void getTasksByAssignee() {
    }

    /**
     * 执行任务
     */
    @Test
    public void completeTask() {
    }

    /**
     * 获取任务
     */
    @Test
    public void chaimTask() {
    }
}
