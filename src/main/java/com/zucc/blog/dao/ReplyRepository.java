package com.zucc.blog.dao;

import com.zucc.blog.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface ReplyRepository extends JpaRepository<Reply,Long> {

    @Query(value = "select t.account,t.name,d.uid,d.comment_id,d.content from t_user t left join t_reply d on t.uid=d.account_id where d.comment_id = ?", nativeQuery = true)
    List<Map<Long, Object>> findReplysByCommentIdLikeSql2(@Param(value = "commentId") Long commentId);

//    @Transactional
//    @Modifying
//    @Query(value = "delete from t_comment a left join t_reply b left join where ", nativeQuery = true)
//    void deleteByUidTrue(Long id);
}
