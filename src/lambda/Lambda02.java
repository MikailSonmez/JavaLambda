package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda02 {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>(Arrays.asList(12, -3, 65, 3, 7, 34, 22, -60, 42, 15));
		ciftKareMax(list);
	}
	// list'in cift olan elemanlarinin karelerini aliniz ve en buyugunu yazdiriniz
	
	public static void ciftKareMax(List<Integer> list) {
		Optional <Integer> maxEl = list.stream().filter(Lambda01::ciftBul).map(t->t*t).reduce(Math::max);
// Optional <Integer> maxEl = list.stream().filter(Lambda01::ciftBul).map(t->t*t).reduce(Integer::max);
		// reduce(Math""max) da kullanilabilir ancak reduce(Integer::max); daha specific oldugu icin hizli calisir
		// int <Integer> maxEl = list.stream().filter(Lambda01::ciftBul).map(t->t*t).reduce(Integer::max);
		// reduce() returne edilen eleman null yada int'den buyuk olur ihtimali icin Java guvenlik olarak handle ederek
		// optional class' sart kosuyor
		System.out.println(maxEl);
		
	}
	//list'teki tum elemanlarin toplamini yazdirin
	// lamda expression....

}
