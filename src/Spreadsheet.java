import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Spreadsheet {
	
	String cell;
	String value;

	public String get(String cell) {
		// to be implemented
		return value;
	}
	
	public void set(String cell, String value) {
		int lenght = 0;
		if(0 > cell.length() && cell.length() > 2){
			//Error
		}
		if(value.contains("''") == false){
			//Value must be numbers only
			Pattern p = Pattern.compile("-?\\d+");
			Matcher m = p.matcher(value);
			while (m.find()){
				lenght++;
			}
			if(value.length() != lenght){
				//Error
				this.value = "#Error";
			}
			this.value = value;
			
		}
		else {
			//Get the value between ''
			Pattern pattern = Pattern.compile("\'([^\"]*)\'");
			Matcher matcher = pattern.matcher(value);
			while(matcher.find()){
				this.value = matcher.group(1);
			}
		}
	}
	
	public String evaluate(String cell) {
		
		return null;
	}
	
}
