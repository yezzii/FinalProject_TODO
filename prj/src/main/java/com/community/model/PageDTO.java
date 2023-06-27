package com.community.model;

import lombok.Data;

@Data
public class PageDTO {
	
	private int page;			// 현재 페이지
	private int rowsize;		// 한 페이지당 보여질 게시물 수
	private int totalRecord;	// DB상 테이블 전체 게시물 수
	private int startNo;		// 해당 페이지 시작 번호
	private int endNo;			// 해당 페이지 끝 번호
	private int startBlock;		// 해당 페이지 시작 블럭
	private int endBlock;		// 해당 페이지 끝 블럭
	private int allPage;		// 전체 페이지 수
	private int block = 3;		// 하단에 보여질 최대 페이지 수
	
//	검색 관련 멤버 선언
	private String field;
	private String keyword;
	private String head;
	
//	기본 생성자
	public PageDTO() { }
	
//	인자 생성자
	public PageDTO(int page, int rowsize, int totalRecord) {
		
		this.page = page;
		this.rowsize = rowsize;
		this.totalRecord = totalRecord;
		
//		해당 페이지 시작 번호
		this.startNo = (this.page * this.rowsize) - (this.rowsize - 1);
		
//		해당 페이지 끝 번호
		this.endNo = (this.page * this.rowsize);
		
//		해당 페이지 시작 블럭
		this.startBlock = (((this.page - 1) / this.block) * this.block) + 1;
		
//		해당 페이지 끝 블럭
		this.endBlock = (((this.page - 1) / this.block) * this.block) + this.block;
		
//		전체 페이지 수
		this.allPage = (int)Math.ceil(this.totalRecord / (double)this.rowsize);
		
		if(this.endBlock > this.allPage) {
			this.endBlock = this.allPage;
		}
		
	}	
	
//	페이징 처리 인자 생성자
	public PageDTO(int page, int rowsize, int totalRecord, String head, String field, String keyword) {
		
		this(page, rowsize, totalRecord);
		this.head = head;
		this.field = field;
		this.keyword = keyword;
		
	}	
	
}