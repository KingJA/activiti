package com.kingja.activiti;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
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
public class Part1_Deployment {
    @Autowired
    private RepositoryService repositoryService;

    @Test
    public void initDeploymentBPMN() {
        String fileName="BPMN/Part4_Task.bpmn";
        String pngName="BPMN/Part1_Deployment.png";
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource(fileName)
                .addClasspathResource(pngName)
                .name("流程部署测试Task")
                .deploy();
        System.out.println(deployment.getName());
    }

    @Test
    public void initDeploymentZIP() {
        InputStream fileInputStrean = this.getClass().getClassLoader().getResourceAsStream("BPMN/Part1_DeploymentV2" +
                ".zip");
        ZipInputStream zip = new ZipInputStream(fileInputStrean);
        Deployment deployment = repositoryService.createDeployment()
                .addZipInputStream(zip)
                .name("流程部署测试ZIP")
                .deploy();
        System.out.println(deployment.getName());
    }

    @Test
    public void getDeployments() {
        List<Deployment> list = repositoryService.createDeploymentQuery().list();
        for (Deployment deployment : list) {
            System.out.println("Id : "+deployment.getId()+" Name : "+deployment.getName()+" DeploymentTime : "+deployment.getDeploymentTime()+" key : "+deployment.getKey());
        }
    }
}
