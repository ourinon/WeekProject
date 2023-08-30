package org.comstudy.myApp;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.comstudy.myApp.entity.BoardEntity;

public class JPAClient {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BoardWeb");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			
			BoardEntity board = new BoardEntity();
//			board.setSeq(0L);
			board.setTitle("JPA 제목33");
			board.setWriter("관리자33");
			board.setContent("JPA 글 등록 테스트 내용33");
			board.setDate(new Date());
			board.setCnt(0L);
			em.persist(board);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}

	}
}
