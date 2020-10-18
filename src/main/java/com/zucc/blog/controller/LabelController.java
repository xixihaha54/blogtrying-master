package com.zucc.blog.controller;


import com.zucc.blog.common.Result;
import com.zucc.blog.common.ResultGenerator;
import com.zucc.blog.entity.Label;
import com.zucc.blog.service.LabelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/label")
@Api(tags = "标签模块")
public class LabelController {
    private final LabelService labelServicve;

    public LabelController(LabelService labelServicve) {this.labelServicve=labelServicve;}

    @PostMapping("/addLabel")
    @ApiOperation(value = "添加标签" , notes = "")
    public Result<Label> addLabel(
            @ApiParam("添加")
            @RequestBody Label label
    ){
        return ResultGenerator.genSuccess(labelServicve.addLabel(label));
    }
}
