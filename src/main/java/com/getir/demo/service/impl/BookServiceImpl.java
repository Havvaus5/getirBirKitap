package com.getir.demo.service.impl;

import com.getir.demo.mapper.BookMapper;
import com.getir.demo.model.dto.BookDTO;
import com.getir.demo.model.dto.StockDTO;
import com.getir.demo.model.dto.UpdateBookDTO;
import com.getir.demo.model.entity.Author;
import com.getir.demo.model.entity.Book;
import com.getir.demo.repository.BookRepository;
import com.getir.demo.service.AuthorService;
import com.getir.demo.service.BookService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional(value = Transactional.TxType.REQUIRED, rollbackOn = Exception.class)
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    private final BookMapper bookMapper;

    private final AuthorService authorService;

    @Override
    public String save(BookDTO bookDTO) {
        Author author = authorService.getAuthor(bookDTO.getAuthorDTO());
        Book book = bookMapper.map(bookDTO);
        book.setAuthor(author);
        Book save = bookRepository.save(book);
        return String.format("Kitap id: %s, author id: %s ile sisteme kaydedilmiştir.", save.getId(), author.getId());
    }

    @Override
    public List<StockDTO> getStocks() {
        List<Book> books = bookRepository.findAll();
        return bookMapper.map(books);
    }

    @Override
    public String updateStock(UpdateBookDTO bookDTO) {
        bookRepository.updateStock(bookDTO.getBookId(), bookDTO.getStockQuantity());
        return "Stoklar güncellenmiştir.";
    }
}
