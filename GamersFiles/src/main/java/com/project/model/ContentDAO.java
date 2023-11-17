package com.project.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.project.database.SqlSessionManager;

public class ContentDAO {
	// 세션 생성해 줄 Factory 생성
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();

	// connection, close, ... sql문 실행
	SqlSession sqlSession = sqlSessionFactory.openSession(true);

	// 데이터 생성
	public int insertContent(ContentDTO cdto) {
		int cnt = 0;

		try {
			cnt = sqlSession.insert("com.project.database.MemberMapper.insertContent", cdto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return cnt;
	}

	// 데이터 조회
	public ContentDTO selectContent(ContentDTO cdto) {
		ContentDTO select = null;
		try {
			select = sqlSession.selectOne("com.project.database.MemberMapper.selectContent", cdto);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return select;

	}

	// 데이터 중복 체크
	public boolean contentCheck(String inputC) {
		boolean isCheck = false;
		try {
			isCheck = sqlSession.selectOne("com.project.database.MemberMapper.contentCheck", inputC);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return isCheck; // true or false

	}

	// 데이터 수정
	public int updateContent(ContentDTO cdto) {
		int cnt = 0;
		try {
			cnt = sqlSession.update("com.project.database.MemberMapper.updateContent", cdto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return cnt;
	}

	// 데이터 리스트
	public List<ContentDTO> contentList() {
		List<ContentDTO> contents = null;
		try {
			contents = sqlSession.selectList("com.project.database.MemberMapper.contentList");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return contents;
	}

	// 데이터 삭제
	public int deleteContent(int c_num) {
		int cnt = 0;
		try {
			cnt = sqlSession.delete("com.project.database.MemberMapper.deleteContent", c_num);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return cnt;
	}
}
