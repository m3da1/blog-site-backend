package com.m3d.blog.blogger.controller;

import com.m3d.blog.blogger.model.BlogDTO;
import com.m3d.blog.blogger.model.GenericResponse;
import com.m3d.blog.blogger.service.BlogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blog")
@CrossOrigin
public class BloggerController {

    @Autowired
    private BlogService blogservice;

    @GetMapping
    public GenericResponse<?> findall() {
        return blogservice.findAll();
    }

    @GetMapping("/{id:[\\d]+}")
    public GenericResponse<?> findOne(@PathVariable("id") long id) {
        return blogservice.findById(id);
    }

    @PostMapping
    public GenericResponse<?> generateBlog(@RequestBody BlogDTO blog) {
        return blogservice.createBlog(blog);
    }

    @PutMapping("/{id:[\\d]+}")
    public GenericResponse<?> updateBlog(@PathVariable("id") long id, @RequestBody BlogDTO blog) {
        return blogservice.updateBlog(id, blog);
    }

    @DeleteMapping("/{id:[\\d]+}")
    public GenericResponse<?> deleteBlog(@PathVariable("id") long id) {
        return blogservice.deleteBlog(id);
    }
}