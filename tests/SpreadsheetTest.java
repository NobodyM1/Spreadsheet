import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {

	@Test
	public void test() {
		Spreadsheet test = new Spreadsheet();
		test.set("A1", "-1");
		String result = test.get("A1");
		assertEquals("-1", result);
		
	}

}
