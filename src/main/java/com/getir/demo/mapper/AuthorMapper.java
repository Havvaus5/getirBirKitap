package com.getir.demo.mapper;

import com.getir.demo.model.dto.AuthorDTO;
import com.getir.demo.model.entity.Author;
import org.mapstruct.Mapper;

@Mapper
public interface AuthorMapper {

    Author map(AuthorDTO authorDTO);
}
