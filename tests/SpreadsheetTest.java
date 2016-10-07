import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {

	@Test
	public void test_123_equals_ 123() {
		Spreadsheet test = new Spreadsheet();
		test.set("A1", "123");
		String result = test.get("A1");
		assertEquals("123", result);
		
	}

}
