package com.bookstore.mapper;

import java.util.List;

import com.bookstore.model.AuthorVO;
import com.bookstore.model.Criteria;

public interface AuthorMapper {

	/* 작가 등록 */
    public void authorEnroll(AuthorVO author);
    
    /* 작가 목록 */
    public List<AuthorVO> authorGetList(Criteria cri);
}
