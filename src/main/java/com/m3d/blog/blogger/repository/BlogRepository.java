package com.m3d.blog.blogger.repository;

import com.m3d.blog.blogger.entity.Blog;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {

}