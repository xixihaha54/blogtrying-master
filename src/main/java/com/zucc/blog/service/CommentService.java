package com.zucc.blog.service;

import com.zucc.blog.entity.Comment;

import java.util.List;
import java.util.Map;

public interface CommentService {

    Comment addComment(Comment comment);

    List<Comment> findAllByArticleId(Long articleid);

    List<Map<Long, Object>> findUserCommentByArticleIdLikeSql2(Long articleId);
  //  List<Comment> deleteComment(Long uid);

}
