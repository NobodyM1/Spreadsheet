import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {

	@Test
	public void test_123_equals_123() {
		Spreadsheet test = new Spreadsheet();
		test.set("A1", "123");
		String result = test.get("A1");
		assertEquals("123", result);
	}
	
	@Test
	public void test_double_quoted_returns_quoted_text() {
		Spreadsheet test = new Spreadsheet();
		test.set("A1", "'test'");
		String result = test.get("A1");
		assertEquals("test", result);
	}

}
