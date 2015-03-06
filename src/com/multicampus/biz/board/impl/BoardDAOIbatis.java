package com.multicampus.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.multicampus.biz.board.BoardVO;

// DAO(Data Access Object)
@Repository
public class BoardDAOIbatis {
	
	
	// 내부적으로 JDBC Template 메소드들을 이용해서 connection 등 해줌
	@Autowired
	private SqlMapClientTemplate ibatis;
	
	// 글 등록
	public void insertBoard(BoardVO vo){
		ibatis.insert("insertBoard", vo);
	}
	
	// 글 수정
	public void updateBoard(BoardVO vo){
		ibatis.update("updateBoard", vo);
	}	
	
	// 글 삭제
	public void deleteBoard(BoardVO vo){
		ibatis.delete("deleteBoard", vo);
	}
	
	// 글 상세 조회
	public BoardVO getBoard(BoardVO vo){
		return (BoardVO) ibatis.queryForObject("getBoard", vo);
	}
	
	// 글 목록 조회
	public List<BoardVO> getBoardList(BoardVO vo){
		System.out.println(vo.getSearchCondition());
		System.out.println(vo.getSearchKeyword());
		return ibatis.queryForList("getBoardList", vo);
	}	
}



