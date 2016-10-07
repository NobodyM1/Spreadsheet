import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {

	@Test
	public void test() {
		Spreadsheet test = new Spreadsheet();
		test.set("A1", "'test'");
		String result = test.get("A1");
		assertEquals("test", result);
		
	}

}
