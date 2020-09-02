package com.m3d.blog.blogger.service;

import java.time.LocalDateTime;
import java.util.List;

import com.m3d.blog.blogger.entity.Blog;
import com.m3d.blog.blogger.model.BlogDTO;
import com.m3d.blog.blogger.model.GenericResponse;
import com.m3d.blog.blogger.repository.BlogRepository;

import org.springframework.stereotype.Service;

@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public GenericResponse<?> findAll() {
        GenericResponse<Iterable<Blog>> resp = new GenericResponse<>(1, "No Data Found");
        List<Blog> blogs = blogRepository.findAll();
        if (!blogs.isEmpty()) {
            resp.setStatus(0);
            resp.setMessage("Success");
            resp.setData(blogs);
        }
        return resp;
    }

    public GenericResponse<?> findById(long id) {
        GenericResponse<Blog> resp = new GenericResponse<>(1, "No Data Found");
        Blog blog = blogRepository.findById(id).orElse(null);
        if (blog != null) {
            resp.setStatus(0);
            resp.setMessage("Success");
            resp.setData(blog);
        }
        return resp;
    }

    public GenericResponse<?> createBlog(BlogDTO blogDTO) {
        GenericResponse<Blog> resp = new GenericResponse<>(1, "Blog creation failed");
        Blog b = new Blog();
        b.setCreatedDate(LocalDateTime.now());
        b.setDescription(blogDTO.getDescription());
        b.setName(blogDTO.getName());
        if (blogRepository.save(b) != null) {
            resp.setStatus(0);
            resp.setMessage("Success");
        }
        return resp;
    }

    public GenericResponse<?> updateBlog(long id, BlogDTO blogDTO) {
        GenericResponse<Blog> resp = new GenericResponse<>(1, "Blog update failed");
        Blog blog = blogRepository.findById(id).orElse(null);
        if (blog == null) {
            resp = new GenericResponse<>(1, "No Data Found");
            return resp;
        }
        blog.setName(blogDTO.getName());
        blog.setDescription(blogDTO.getDescription());
        if (blogRepository.save(blog) != null) {
            resp.setStatus(0);
            resp.setMessage("Success");
        }
        return resp;
    }

    public GenericResponse<?> deleteBlog(long id) {
        GenericResponse<Blog> resp = new GenericResponse<>(1, "Blog deletion failed");
        Blog blog = blogRepository.findById(id).orElse(null);
        if (blog == null) {
            resp = new GenericResponse<>(1, "No Data Found");
            return resp;
        }
        blogRepository.deleteById(id);
        resp.setStatus(0);
        resp.setMessage("Success");
        return resp;
    }
}