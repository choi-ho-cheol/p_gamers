package com.project.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.project.database.SqlSessionManager;

public class GroupDAO {
	// 세션 생성해 줄 Factory 생성
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();

	// connection, close, ... sql문 실행
	SqlSession sqlSession = sqlSessionFactory.openSession(true);

	// 데이터 생성
	public int joinGroup(GroupDTO gdto) {
		int cnt = 0;

		try {
			cnt = sqlSession.insert("com.project.database.MemberMapper.joinMember", gdto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return cnt;
	}

	// 데이터 조회
	public GroupDTO loginGroup(GroupDTO gdto) {
		GroupDTO login = null;
		try {
			login = sqlSession.selectOne("com.project.database.MemberMapper.loginMember", gdto);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return login;

	}

	// 데이터 중복 체크
	public boolean groupCheck(String inputG) {
		boolean isCheck = false;
		try {
			isCheck = sqlSession.selectOne("com.project.database.MemberMapper.emailCheck", inputG);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return isCheck; // true or false

	}

	// 데이터 수정
	public int updateGroup(GroupDTO gdto) {
		int cnt = 0;
		try {
			cnt = sqlSession.update("com.project.database.MemberMapper.updateMember", gdto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return cnt;
	}

	// 데이터 리스트
	public List<GroupDTO> allGroup() {
		List<GroupDTO> groups = null;
		try {
			groups = sqlSession.selectList("com.project.database.MemberMapper.allMember");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return groups;
	}

	// 데이터 삭제
	public int delGroup(String m_email) {
		int cnt = 0;
		try {
			cnt = sqlSession.delete("com.project.database.MemberMapper.delMember", m_email);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return cnt;
	}
}
