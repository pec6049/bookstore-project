package com.bookstore.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bookstore.mapper.AttachMapper;
import com.bookstore.model.AttachImageVO;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class BookController {
	
	@Autowired
	private AttachMapper attachMapper;

	@RequestMapping(value="/main", method=RequestMethod.GET)
	public void mainPageGET() {
		log.info("메인 페이지 진입");
	}
	
	@GetMapping("/display")
	public ResponseEntity<byte[]> getImage(String fileName) {
		log.info("getImage()........" + fileName);
		
		File file = new File("C:\\Users\\PC\\Desktop\\bookstore-project\\upload\\" + fileName);
		
		ResponseEntity<byte[]> result = null;
		
		try {
			HttpHeaders header = new HttpHeaders();
			header.add("Content-type", Files.probeContentType(file.toPath()));
			
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/* 이미지 정보 반환 */
	@GetMapping(value="/getAttachList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<AttachImageVO>> getAttachList(int bookId){
		
		log.info("getAttachList.........." + bookId);
		
		return new ResponseEntity<List<AttachImageVO>>(attachMapper.getAttachList(bookId), HttpStatus.OK);
	}

}
