package com.getir.demo.config;


import com.getir.demo.model.entity.Author;
import com.getir.demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {

    private AuthorRepository authorRepository;


    @Autowired
    public DataLoader(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;

        loadAuthors();
    }

    private void loadAuthors() {
        authorRepository.save(new Author("Victor", "Hugo"));
        authorRepository.save(new Author("Cemal", "Süreyya"));

    }
}
