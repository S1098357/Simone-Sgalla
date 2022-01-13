package ProgettoPO.ProgettoProgrammazione.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ProgettoPO.ProgettoProgrammazione.exceptions.*;
import ProgettoPO.ProgettoProgrammazione.services.CommentServiceImpl;
import ProgettoPO.ProgettoProgrammazione.statsFilters.*;

class exceptionsTests {
	CommentServiceImpl commentService = new CommentServiceImpl();
	CommentStats commentStats = new CommentStats();
	CommentFilters commentFilters = new CommentFilters();

	
	@BeforeEach
	void setUp() throws Exception {
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
		assertThrows (InvalidNameException.class, ()-> commentStats.numCommentiUtente(commentService.getAllComments(), "Andrea Cicetti"));
	}
	
	@Test 
	void test3() {
		assertThrows (InvalidDateException.class, ()-> commentFilters.filtroGiorni(commentService.getAllComments(), 1));
	}
}
