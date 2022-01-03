package com.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bookstore.model.AuthorVO;
import com.bookstore.model.Criteria;
import com.bookstore.model.PageDTO;
import com.bookstore.service.AuthorService;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
    private AuthorService authorService;

	/* 관리자 메인 페이지 이동 */
    @RequestMapping(value="main", method = RequestMethod.GET)
    public void adminMainGET() throws Exception {
        log.info("관리자 페이지 이동");
    }
    
    /* 상품 등록 페이지 접속 */
    @RequestMapping(value = "goodsManage", method = RequestMethod.GET)
    public void goodsManageGET() throws Exception {
    	log.info("상품 등록 페이지 접속");
    }
    
    /* 상품 등록 페이지 접속 */
    @RequestMapping(value = "goodsEnroll", method = RequestMethod.GET)
    public void goodsEnrollGET() throws Exception {
    	log.info("상품 등록 페이지 접속");
    }
    
    /* 작가 등록 페이지 접속 */
    @RequestMapping(value = "authorEnroll", method = RequestMethod.GET)
    public void authorEnrollGET() throws Exception {
    	log.info("작가 등록 페이지 접속");
    }
    
    /* 작가 관리 페이지 접속 */
    @RequestMapping(value = "authorManage", method = RequestMethod.GET)
    public void authorManageGET(Criteria cri, Model model) throws Exception {
    	log.info("작가 관리 페이지 접속........." + cri);
    	
    	/* 작가 목록 출력 데이터 */
        List list = authorService.authorGetList(cri);
        
        if(!list.isEmpty()) {
        	model.addAttribute("list", list);	//작가 존재
        } else {
        	model.addAttribute("listCheck", "empty");	//작가가 존재하지 않을 경우
        }
        
        /* 페이지 이동 인터페이스 데이터 */
        model.addAttribute("pageMaker", new PageDTO(cri, authorService.authorGetTotal(cri)));
    }
    
    /* 작가 등록 */
    @RequestMapping(value="authorEnroll.do", method = RequestMethod.POST)
    public String authorEnrollPOST(AuthorVO author, RedirectAttributes rttr) throws Exception{
    	log.info("authorEnroll :" +  author);
        
        authorService.authorEnroll(author);  //작가 등록 쿼리 수행
        rttr.addFlashAttribute("enroll_result", author.getAuthorName());
        
        return "redirect:/admin/authorManage";
    }
    
    /* 작가 상세 페이지 */
	@GetMapping({"/authorDetail", "/authorModify"})
	public void authorGetInfoGET(int authorId, Criteria cri, Model model) throws Exception {
		log.info("authorDetail......." + authorId);
		
		/* 작가 관리 페이지 정보 */
		model.addAttribute("cri", cri);
		
		/* 선택 작가 정보 */
		model.addAttribute("authorInfo", authorService.authorGetDetail(authorId));
	}
	
	/* 작가 정보 수정 */
	@PostMapping("/authorModify")
	public String authorModifyPOST(AuthorVO author, RedirectAttributes rttr) throws Exception {
		log.info("authorModifyPOST......." + author);
		
		int result = authorService.authorModify(author);
		rttr.addFlashAttribute("modify_result", result);
		
		return "redirect:/admin/authorManage";
	}
	
}
