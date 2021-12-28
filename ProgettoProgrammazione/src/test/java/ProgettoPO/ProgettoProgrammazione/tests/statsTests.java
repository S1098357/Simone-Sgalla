package ProgettoPO.ProgettoProgrammazione.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ProgettoPO.ProgettoProgrammazione.entities.Comment;
import ProgettoPO.ProgettoProgrammazione.services.*;
import ProgettoPO.ProgettoProgrammazione.statsFilters.CommentStats;


class statsTests {
	
	private CommentStats stats = new CommentStats();
	CommentServiceImpl commentService = new CommentServiceImpl();
	Vector <Comment> lista = new Vector<Comment>();
	
	@BeforeEach
	void setUp() throws Exception {
		lista = this.commentService.getAllComments();
	};

	
	@AfterEach
	void tearDown() throws Exception {};
	
	
	@Test
	void test() {
		assertEquals (stats.mediaOrario(lista), "13:27");
	}
	
	@Test
	void test1() {
		assertEquals (stats.orarioMax(lista), "23:45");
	}
	
	@Test
	void test2 () {
		assertEquals (stats.orarioMin(lista), "7:25");
	}

	@Test 
	void test3() {
		assertEquals (stats.mediaLike(lista), "0.7");
	}
	
	
}
