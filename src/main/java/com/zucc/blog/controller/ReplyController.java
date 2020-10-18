package com.zucc.blog.controller;


import com.zucc.blog.common.Result;
import com.zucc.blog.common.ResultGenerator;
import com.zucc.blog.entity.Reply;
import com.zucc.blog.service.ReplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/reply")
@Api(tags = "回复模块")
public class ReplyController {
    private final ReplyService replyService;
    public ReplyController(ReplyService replyService) {this.replyService=replyService;}

    @PostMapping("/addReply")
    @ApiOperation(value = "添加回复" , notes = "")
    public Result<Reply> addReply(
            @ApiParam("添加")
            @RequestBody Reply reply
    ){
        return ResultGenerator.genSuccess(replyService.addReply(reply));
    }

    @PostMapping("/findAllReplyid")
    @ApiOperation(value = "根据评论id搜索回复带姓名",notes = "")
    public Result<List<Map<Long,Object>>> findReplysByCommentIdLikeSql2(
            @ApiParam(value = "commentId")
            @RequestParam Long commentId
    ){
        return ResultGenerator.genSuccess(replyService.findReplysByCommentIdLikeSql2(commentId));
    }
}
