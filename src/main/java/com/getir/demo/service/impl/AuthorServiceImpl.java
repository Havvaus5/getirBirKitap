package com.getir.demo.service.impl;

import com.getir.demo.exception.GetirException;
import com.getir.demo.model.entity.Author;
import com.getir.demo.repository.AuthorRepository;
import com.getir.demo.service.AuthorService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional(value = Transactional.TxType.REQUIRED, rollbackOn = Exception.class)
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public Author getAuthor(Long autorId) {
        Optional<Author> optionalAuthor = authorRepository.findById(autorId);
        optionalAuthor.orElseThrow(() -> new GetirException("Yazar sistemde bulunamadı. Lütfen geçerli bir authorId giriniz"));
        return optionalAuthor.get();
    }
}
