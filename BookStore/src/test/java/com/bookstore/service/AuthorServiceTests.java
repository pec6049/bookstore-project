package com.bookstore.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bookstore.model.AuthorVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class AuthorServiceTests {

    @Autowired
    private AuthorService service;
    
    /*
    @Test
    public void authorEnrollTest() throws Exception {
        AuthorVO author = new AuthorVO();
        
        author.setNationId("01");
        author.setAuthorName("테스트");
        author.setAuthorIntro("테스트 소개");
        
        service.authorEnroll(author);
    }
    */
    
    /* 작가 상세 페이지 */
	@Test
	public void authorGetDetailTest() throws Exception {
		int authorId = 20;
		
		log.info("author......." + service.authorGetDetail(authorId));
	}
	
}
