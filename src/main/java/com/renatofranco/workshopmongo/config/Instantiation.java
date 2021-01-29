package com.renatofranco.workshopmongo.config;

import com.renatofranco.workshopmongo.domain.Post;
import com.renatofranco.workshopmongo.domain.User;
import com.renatofranco.workshopmongo.dto.AuthorDTO;
import com.renatofranco.workshopmongo.repository.PostRepository;
import com.renatofranco.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("21/12/2020"), "Partiu viagem", "Vou viajar, abraço!", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("23/12/2020"), "Bom dia!", "Acordei feliz!!", new AuthorDTO(maria));

        postRepository.saveAll(Arrays.asList(post1, post2));

    }

}
