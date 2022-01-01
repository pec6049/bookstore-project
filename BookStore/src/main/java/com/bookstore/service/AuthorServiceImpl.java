package com.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.mapper.AuthorMapper;
import com.bookstore.model.AuthorVO;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
    AuthorMapper authorMapper;
	
	@Override
    public void authorEnroll(AuthorVO author) throws Exception {
        authorMapper.authorEnroll(author);
    }
	
}
