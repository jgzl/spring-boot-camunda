package com.github.jgzl.framework.service;

import com.google.common.collect.Maps;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.*;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
@AllArgsConstructor
public class TaskOperatorService {

    private RuntimeService runtimeService;

    private TaskService taskService;

    private HistoryService historyService;

    private RepositoryService repositoryService;

    private ManagementService managementService;

    private IdentityService identityService;

    public void startProcess(String processDefinitionKey,Map<String,Object> variables){
        this.startProcess(processDefinitionKey,null,variables);
    }

    public void startProcess(String processDefinitionKey,String businessKey,Map<String,Object> variables){
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey, businessKey, variables);
        log.debug("流程实例id为:{}",processInstance.getId());
        log.debug("流程定义id为:{}",processInstance.getProcessDefinitionId());
    }

    public void complete(String taskId,Map<String,Object> variables){
        taskService.complete(taskId,variables);
        log.debug("");
    }
}
