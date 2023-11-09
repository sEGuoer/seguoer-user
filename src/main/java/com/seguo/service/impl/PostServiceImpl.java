package com.seguo.service.impl;

import com.seguo.dto.PostDto;
import com.seguo.entity.Post;
import com.seguo.entity.User;
import com.seguo.repository.PostRepository;
import com.seguo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepository postRepository;

    @Override
    public Page<Post> findAll(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        return this.postRepository.findAll(pageable);
    }
    @Override
    public void savePost(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());
        post.setCover(postDto.getCover());
        post.setUser(new User(postDto.getUser_id()));
        postRepository.save(post);
    }
}
