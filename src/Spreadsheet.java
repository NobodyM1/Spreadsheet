import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Spreadsheet {
	
	// Must be pairs, 
	String cell;
	String value;
	
	//HashMap map = new HashMap();
	

	public String get(String cell) {
		
		//Object result = map.get(cell);
		
		return value;
	}
	
	public void set(String cell, String value) {
		// Count how many ' can be found in value
		Pattern pat = Pattern.compile("'");
		Matcher mat = pat.matcher(value);
		int count = 0;
		while (mat.find()){
			count++;
		}
		
		if(count < 2){
			//Value must be numbers only
			int count2 = 0;
			for (int i = 0, len = value.length(); i < len; i++) {
			    if (Character.isDigit(value.charAt(i))) {
			        count2++;
			    }
			}
			
			if(value.length() != count2){
				//Error
				this.value = "#Error";
			}
			else{
				this.value = value;
			}
			
			
		}
		else {
			//Get the value between ''
			Pattern pattern = Pattern.compile("\'([^\"]*)\'");
			Matcher matcher = pattern.matcher(value);
			while(matcher.find()){
				this.value = matcher.group(1);
			}
		}
		
		//map.put(this.cell, this.value);
	}
	
	public String evaluate(String cell) {
		
		return null;
	}
	
}
