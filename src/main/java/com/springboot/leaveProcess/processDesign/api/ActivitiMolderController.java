package com.springboot.leaveProcess.processDesign.api;

import com.common.vo.Result;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.Process;
import org.activiti.editor.constants.ModelDataJsonConstants;
import org.activiti.editor.language.json.converter.BpmnJsonConverter;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @Author:adayang
 * @Describe:
 * @Date:2019/1/22 11:17
 * @Modify by:
 */
@Api(tags = "流程模型相关操作",description = "流程模型创建发布等操作")
@RestController
@RequestMapping("/processOperate")
public class ActivitiMolderController {

    @Autowired
    ProcessEngine processEngine;
    @Autowired
    ObjectMapper objectMapper;
//    @Autowired
//    RepositoryService repositoryService;

    @ApiOperation(value = "创建一个空模型")
    @PostMapping("/createEmptyProcessMolder")
    public Result createEmptyProcessMolder() throws UnsupportedEncodingException {
        //创建一个资源service
        RepositoryService repositoryService = processEngine.getRepositoryService();
        //创建一个空模型
        Model model = repositoryService.newModel();
        //设置一些公用参数
        String name = "new process1";
        String description = "一个新的流程";
        String key = "process";
        int revision = 1;
        ObjectNode modelNode = objectMapper.createObjectNode();
        modelNode.put(ModelDataJsonConstants.MODEL_NAME,name);
        modelNode.put(ModelDataJsonConstants.MODEL_DESCRIPTION,description);
        modelNode.put(ModelDataJsonConstants.MODEL_REVISION,revision);

        model.setName(name);
        model.setKey(key);
        model.setMetaInfo(modelNode.toString());

        repositoryService.saveModel(model);
        String id = model.getId();
        ObjectNode editorNode = objectMapper.createObjectNode();
        editorNode.put("id", "canvas");
        editorNode.put("resourceId", "canvas");
        ObjectNode stencilsetNode  = objectMapper.createObjectNode();
        stencilsetNode.put("namespace",
                "http://b3mn.org/stencilset/bpmn2.0#");
        editorNode.put("stencilset",stencilsetNode);
        repositoryService.addModelEditorSource(id,editorNode.toString().getBytes());

        return new Result("sucess","请求成功",id);
    }

    @ApiOperation(value = "获取所有模型")
    @PostMapping("/getAllModel")
    public List<Model> getAllModel(){
        RepositoryService repositoryService = processEngine.getRepositoryService();
        List<Model> modelList = repositoryService.createModelQuery().orderByCreateTime().desc().list();
        return modelList;
    }

    @ApiOperation("根据模型id发布模型")
    @PostMapping("/publicModel")
    public Result publicModel(String modelId) throws Exception{
        RepositoryService repositoryService = processEngine.getRepositoryService();
        //通过modelId找到模型
        Model modelData = repositoryService.getModel(modelId);
        System.out.println(modelId + "--" + modelData.getId());
        //返回这个model的byte数组
        byte[] modelByte = repositoryService.getModelEditorSource(modelData.getId());
        //判断这个数组是否为空
        if(modelByte == null){
            return new Result("error","模型不存在，请创建模型",modelId);
        }
        //将model的byte数组转换为jsonNode，在转化为bpmnModel
        JsonNode modelNode = new ObjectMapper().readTree(modelByte);
        BpmnModel modelBpmnModel = new BpmnJsonConverter().convertToBpmnModel(modelNode);
        List<Process> modelProcesses = modelBpmnModel.getProcesses();
        if(modelProcesses.size() == 0){
            return new Result("error","请给模型设置至少一个流程",modelId);
        }
        //将modelByte转化为xml文件
        byte[] modelXml = new BpmnXMLConverter().convertToXML(modelBpmnModel);
        //模型名称
        String modelName =  modelData.getName() + ".bpmn20.xml";
        DeploymentBuilder deploymentBuilder = repositoryService.createDeployment()
                .name(modelData.getName())
                .addString(modelName,new String(modelXml,"UTF-8"));
        Deployment deployment = deploymentBuilder.deploy();
        modelData.setDeploymentId(deployment.getId());
        repositoryService.saveModel(modelData);
        return new Result("SUCCESS","发布模型成功，模型" + modelId + "的发布id为："+deployment.getId(),null);
    }
}
