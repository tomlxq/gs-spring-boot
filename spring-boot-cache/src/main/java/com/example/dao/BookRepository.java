package com.example.dao;

import com.example.entity.Book;

public interface BookRepository {

    Book getById(String id);

}