package com.zucc.blog.service.impl;

import com.zucc.blog.dao.CommentRepository;
import com.zucc.blog.entity.Comment;
import com.zucc.blog.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {this.commentRepository=commentRepository;}

    @Override
    public Comment addComment(Comment comment){
        Comment comment1 = commentRepository.save(comment);
        return comment1;
    }

    @Override
    public List<Comment> findAllByArticleId(Long articleid){
        List<Comment> comment2 = commentRepository.findAllByArticleId(articleid);
        return comment2;
    }

    @Override
    public List<Map<Long, Object>> findUserCommentByArticleIdLikeSql2(Long articleId){
        List<Map<Long, Object>> userComments = commentRepository.findUserCommentByArticleIdLikeSql2(articleId);

        return commentRepository.findUserCommentByArticleIdLikeSql2(articleId);
    }

//    @Override
//    public List<Comment> deleteComment(Long uid) {
//        Comment comment =commentRepository.deleteById(uid);
//        return ResultGenerator.genResult(200,"删除成功",uid);
//    }
}
