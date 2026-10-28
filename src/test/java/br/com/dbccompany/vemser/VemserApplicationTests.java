package br.com.dbccompany.vemser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VemserApplicationTests {

	@Test
	void contextLoads() {

		int a = 1;
		int b = 2;

		assertEquals(a + b, 3);
	}

}
