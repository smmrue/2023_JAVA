import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

enum Type {
	MEAT, FISH, OTHER
}

public class Test {
	public static void main(String[] args) {
		
		List<Food> menu = Arrays.asList(new Food("salad", true, 200, Type.OTHER),
				new Food("beef", false, 7100, Type.MEAT), new Food("chicken", false, 1400, Type.MEAT),
				new Food("rice", true, 3510, Type.OTHER), new Food("season fruit", true, 1120, Type.OTHER),
				new Food("pizza", true, 5150, Type.OTHER), new Food("salmon", false, 4150, Type.FISH));

		List<Food> list = menu.stream().filter(p -> p.calories < 300).filter(p -> p.Vege == true)
				.collect(Collectors.toList());
		
		System.out.println(list);

	}
}