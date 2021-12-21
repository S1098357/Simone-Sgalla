package ProgettoPO.ProgettoProgrammazione.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ProgettoPO.ProgettoProgrammazione.StatsFilters.CommentStats;
import ProgettoPO.ProgettoProgrammazione.entities.Comment;
import ProgettoPO.ProgettoProgrammazione.entities.CommentMethods;
import ProgettoPO.ProgettoProgrammazione.exceptions.InvalidName;
import ProgettoPO.ProgettoProgrammazione.services.*;


class statsTests {
	
	private CommentStats stats = new CommentStats();
	CommentServiceImpl commentService = new CommentServiceImpl();
	Vector <CommentMethods> lista = this.commentService.getAllComments();
	
	@BeforeEach
	void setUp() throws Exception {};

	
	@AfterEach
	void tearDown() throws Exception {};
	
	
	@Test
	void test() {
		assertEquals (stats.mediaOrario(lista), "13:28");
	}
	
	@Test
	void test1() {
		assertEquals (stats.orarioMax(lista), "23:45");
	}
	
	@Test
	void test2 () {
		assertEquals (stats.orarioMin(lista), "07:25");
	}

	@Test 
	void test3() {
		assertEquals (stats.mediaLike(lista), "0.2");
	}
	
	
}
