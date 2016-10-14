import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {

	
	@Test
	public void test_Setup() {
		Spreadsheet test = new Spreadsheet();
		test.set("A1", "123");
		test.evaluate("A1");
		String result = test.get("A1");
		assertEquals("123", result);
	}
	
	@Test
	public void test_Number_handling() {
		Spreadsheet test = new Spreadsheet();
		test.set("A1", "-1");
		test.evaluate("A1");
		String result = test.get("A1");
		assertEquals("-1", result);
	}
	
	@Test
	public void test_Wrongly_formatted_integers() {
		Spreadsheet test = new Spreadsheet();
		test.set("A1", "5A");
		String result = test.evaluate("A1");;
		assertEquals("#Error", result);
	}
	
	@Test
	public void test_String_handling() {
		Spreadsheet test = new Spreadsheet();
		test.set("A1", "'a string'");
		String result = test.evaluate("A1");;
		assertEquals("a string", result);
	}
	
	@Test
	public void test_Unquoted_strings() {
		Spreadsheet test = new Spreadsheet();
		test.set("A1", "'a string");
		String result = test.evaluate("A1");;
		assertEquals("#Error", result);
	}
	
	@Test
	public void test_Simple_formulas() {
		Spreadsheet test = new Spreadsheet();
		test.set("A1", "='a string'");
		String result = test.evaluate("A1");;
		assertEquals("a string", result);
	}
	
	@Test
	public void test_Simple_formulas_with_errors() {
		Spreadsheet test = new Spreadsheet();
		test.set("A1", "='a string");
		String result = test.evaluate("A1");;
		assertEquals("#Error", result);
	}
	
	@Test
	public void test_Cell_references() {
		Spreadsheet test = new Spreadsheet();
		test.set("A5", "5");
		test.set("A1", "=A5");
		String result = test.evaluate("A1");
		assertEquals("5", result);
	}
	
	@Test
	public void test_Errors_in_cell_references() {
		Spreadsheet test = new Spreadsheet();
		test.set("A5", "5A");
		test.set("A1", "=A5");
		String result = test.evaluate("A1");
		assertEquals("#Error", result);
	}
	
	@Test
	public void test_Circular_references() {
		Spreadsheet test = new Spreadsheet();
		test.set("A5", "=A1");
		test.set("A1", "=A5");
		String result = test.evaluate("A1");
		assertEquals("#Circular", result);
	}
	
	@Test
	public void test_Integer_operations() {
		Spreadsheet test = new Spreadsheet();
		test.set("A1", "=1+1*2");
		String result = test.evaluate("A1");
		assertEquals("4", result);
	}
	
	
	/*
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

	@Test
	public void test_single_quoted_returns_error() {
		Spreadsheet test = new Spreadsheet();
		test.set("A1", "'test");
		String result = test.get("A1");
		assertEquals("#Error", result);
	}
	
	@Test
	public void test_5A_quoted_returns_error() {
		Spreadsheet test = new Spreadsheet();
		test.set("A1", "5A");
		String result = test.get("A1");
		assertEquals("#Error", result);
	}
	
	@Test
	public void test_Simple_Formulas() {
		Spreadsheet test = new Spreadsheet();
		test.set("A1", "='test'");
		String result = test.get("A1");
		assertEquals("test", result);
	}
	
	@Test
	public void test_Simple_Formulas_With_Errors() {
		Spreadsheet test = new Spreadsheet();
		test.set("A1", "='test");
		String result = test.get("A1");
		assertEquals("#Error", result);
	}
	*/
	
}
