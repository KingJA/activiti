package com.kingja.activiti;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipInputStream;

/**
 * Description:TODO
 * Create Time:2020/8/26 0026 下午 3:03
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@SpringBootTest
public class Part2_ProcessDefinition {
    @Autowired
    private RepositoryService repositoryService;

    /**
     * 删除流程定义
     */
    @Test
    public void delDefinition() {
        String pdID="a92f1cc5-e76d-11ea-929b-b8975aed9046";
        //true 删除所有， false 保留历史
        repositoryService.deleteDeployment(pdID,true);
        System.out.println("删除流程定义成功");
    }

    /**
     * 查询流程定义
     */
    @Test
    public void getDeployments() {
        List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().list();
        for (ProcessDefinition pd : list) {
            System.out.println("Name : " + pd.getName() + " Key : " + pd.getKey() + " ResourceName : " + pd.getResourceName() + " DeploymentId : " + pd.getDeploymentId() + " Version : " + pd.getVersion());
        }
    }
}
