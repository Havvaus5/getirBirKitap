package com.getir.demo.service;

import com.getir.demo.model.dto.AuthorDTO;
import com.getir.demo.model.entity.Author;


public interface AuthorService {

    Author getAuthor(Long autorId);

    Author getAuthor(AuthorDTO authorDTO);
}
