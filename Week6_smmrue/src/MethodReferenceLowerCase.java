import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodReferenceLowerCase {

	public static void main(String[] args) {
		List<String> listOfNames = Arrays.asList(new String[]
				{"Apple","Banana","Cherry"});
		
		 List<String> lowercaseList = listOfNames.stream()
	                .map(String::toLowerCase)
	                .collect(Collectors.toList());

	        System.out.println(lowercaseList);
		
	}

}
