package com.zucc.blog.controller;


import com.zucc.blog.common.Result;
import com.zucc.blog.common.ResultGenerator;
import com.zucc.blog.entity.Comment;
import com.zucc.blog.service.CommentLikeService;
import com.zucc.blog.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/comment")
@Api(tags = "评论模块")
public class CommentController {

    private  final CommentService commentService;
    private  final CommentLikeService commentLikeService;

    public CommentController(CommentService commentService, CommentLikeService commentLikeService) {
        this.commentService=commentService;
        this.commentLikeService=commentLikeService;
    }


    @PostMapping("/addComment")
    @ApiOperation(value = "添加评论" , notes = "")
    public Result<Comment> addComment(
            @ApiParam("添加")
            @RequestBody Comment comment
            ){
        return ResultGenerator.genSuccess(commentService.addComment(comment));
    }

    @PostMapping("/findartcomment2")
    @ApiOperation(value = "根据文章id搜索评论",notes = "")
    public Result<List<Comment>> findAllByArticleId(
            @ApiParam("搜索id")
            @RequestParam Long articleId
    ){
        return ResultGenerator.genSuccess(commentService.findAllByArticleId(articleId));
    }

    @PostMapping("/findAllCommentid")
    @ApiOperation(value = "根据文章id搜索评论带姓名",notes = "")
    public Result<List<Map<Long, Object>>> findUserCommentByArticleIdLikeSql2(
            @ApiParam(value = "articleId")
            @RequestParam Long articleId
    ){
        return ResultGenerator.genSuccess(commentService.findUserCommentByArticleIdLikeSql2(articleId));
    }

    @PostMapping("/likecomment")
    @ApiOperation(value = "点赞评论")
    public Result<Integer> likeComment(
            @ApiParam("点赞评论用户id") @RequestParam Long accountId,
            @ApiParam("评论id") @RequestParam Long commentId
    ){
        if (commentLikeService.findCommentLike(accountId,commentId)){
            commentLikeService.deleteCommentLike(accountId,commentId);
        } else {
            commentLikeService.addCommentLike(accountId,commentId);
        }
        return commentLikeService.findAllCommentLikeByComment(commentId);
    }

}
