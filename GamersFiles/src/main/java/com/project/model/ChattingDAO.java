package com.project.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.project.database.SqlSessionManager;

public class ChattingDAO {
	// 세션 생성해 줄 Factory 생성
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();

	// connection, close, ... sql문 실행
	SqlSession sqlSession = sqlSessionFactory.openSession(true);

	// 데이터 생성
	public int insertChatting(ChattingDTO wdto) {
		int cnt = 0;

		try {
			cnt = sqlSession.insert("com.project.database.MemberMapper.insertChatting", wdto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return cnt;
	}

	// 데이터 조회
	public ChattingDTO selectChatting(ChattingDTO wdto) {
		ChattingDTO select = null;
		try {
			select = sqlSession.selectOne("com.project.database.MemberMapper.selectChatting", wdto);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return select;

	}

	// 데이터 중복 체크
	public boolean chattingCheck(String inputW) {
		boolean isCheck = false;
		try {
			isCheck = sqlSession.selectOne("com.project.database.MemberMapper.chattingCheck", inputW);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return isCheck; // true or false

	}

	// 데이터 수정
	public int updateChatting(ChattingDTO wdto) {
		int cnt = 0;
		try {
			cnt = sqlSession.update("com.project.database.MemberMapper.updateChatting", wdto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return cnt;
	}

	// 데이터 리스트
	public List<ChattingDTO> chattingList() {
		List<ChattingDTO> contents = null;
		try {
			contents = sqlSession.selectList("com.project.database.MemberMapper.chattingList");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return contents;
	}

	// 데이터 삭제
	public int deleteChatting(int w_num) {
		int cnt = 0;
		try {
			cnt = sqlSession.delete("com.project.database.MemberMapper.deleteChatting", w_num);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return cnt;
	}

}
