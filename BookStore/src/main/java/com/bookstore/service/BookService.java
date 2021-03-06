package com.bookstore.service;

import java.util.List;

import com.bookstore.model.BookVO;
import com.bookstore.model.Criteria;

public interface BookService {
	
	/* 상품 검색 */
	public List<BookVO> getGoodsList(Criteria cri);
	
	/* 상품 총 갯수 */
	public int goodsGetTotal(Criteria cri);

}
