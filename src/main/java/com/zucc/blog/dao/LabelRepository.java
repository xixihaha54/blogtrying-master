package com.zucc.blog.dao;

import com.zucc.blog.entity.Label;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabelRepository extends JpaRepository<Label,Long> {
}
