package com.seguo.service;


import com.seguo.dto.PostDto;
import com.seguo.entity.Post;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface PostService {
    Page<Post> findAll(int pageNumber, int pageSize);

    void savePost(PostDto postDto);

    Optional<Post> findById(Long id);


}
