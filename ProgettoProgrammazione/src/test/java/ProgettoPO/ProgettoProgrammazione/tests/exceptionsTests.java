package ProgettoPO.ProgettoProgrammazione.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ProgettoPO.ProgettoProgrammazione.exceptions.*;
import ProgettoPO.ProgettoProgrammazione.StatsFilters.*;
import ProgettoPO.ProgettoProgrammazione.services.CommentServiceImpl;

class exceptionsTests {
	CommentServiceImpl commentService = new CommentServiceImpl();
	CommentStats commentStats = new CommentStats();
	CommentFilters commentFilters = new CommentFilters();

	
	@BeforeEach
	void setUp() throws Exception {
		//prova1 = commentService.getComments("1");
	};

	@AfterEach
	void tearDown() throws Exception {};

	@Test
	void test() {
		assertThrows (PostIdException.class, ()-> commentService.getComments("2372"));
		}
	
	@Test
	void test1() {
		assertThrows (CommentIdException.class, ()-> commentService.getComment("1"));
	}

	@Test
	void test2() {
		assertThrows (InvalidName.class, ()-> commentStats.numCommentiUtente(commentService.getAllComments(), "Andrea Cicetti"));
	}
	
	@Test 
	void test3() {
		assertThrows (InvalidDate.class, ()-> commentFilters.filtroGiorni(commentService.getAllComments(), 1));
	}
}
