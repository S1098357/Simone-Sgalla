package ProgettoPO.ProgettoProgrammazione.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ProgettoPO.ProgettoProgrammazione.entities.CommentMethods;
import ProgettoPO.ProgettoProgrammazione.exceptions.PostIdException;
import ProgettoPO.ProgettoProgrammazione.services.CommentServiceImpl;

class exceptionsTests {
	CommentServiceImpl commentService = new CommentServiceImpl();
	
	
	@BeforeEach
	void setUp() throws Exception {};

	@AfterEach
	void tearDown() throws Exception {};

	@Test
	void test() {
		assertThrows (PostIdException.class, ()-> commentService.getComments("2372"));
		}
	
	

}
