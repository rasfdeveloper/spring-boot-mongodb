package com.renatofranco.workshopmongo.services;

import com.renatofranco.workshopmongo.domain.Post;
import com.renatofranco.workshopmongo.domain.User;
import com.renatofranco.workshopmongo.dto.UserDTO;
import com.renatofranco.workshopmongo.repository.PostRepository;
import com.renatofranco.workshopmongo.repository.UserRepository;
import com.renatofranco.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;


    public Post findById(String id){
        Optional<Post> user = postRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Post não encontrado"));
    }

    public List<Post> findByTitle(String text){
        return postRepository.findByTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate){
        maxDate = new Date(maxDate.getTime() +24 * 60 * 60 * 1000);
        return postRepository.fullSearch(text, minDate, maxDate);
    }

}
