package com.project.Band_Search.service;
import com.project.Band_Search.models.Post;
import com.project.Band_Search.repository.PostPaginationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements IService<Post>{
    @Autowired
    private PostPaginationRepository postRepository;

    @Override
    public Page<Post> findAll(Pageable pageable) {
        return postRepository.findAll(pageable);
    }
}
