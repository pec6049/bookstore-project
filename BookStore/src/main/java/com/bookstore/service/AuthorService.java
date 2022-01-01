package com.bookstore.service;

import com.bookstore.model.AuthorVO;

public interface AuthorService {
	
	/* 작가 등록 */
    public void authorEnroll(AuthorVO author) throws Exception;

}
