package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda02 {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>(Arrays.asList(12, -3, 65, 3, 7, 34, 22, -60, 42, 15));
		ciftKareMax(list);
		toplaEl1(list);
		toplaEl2(list);
		carpCiftEl1(list);
		carpCiftEl2(list);
		min1(list);
		min2(list);
		min3(list);
		min4(list);
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
	// lamdba expression....
	public static void toplaEl1(List<Integer> list) {
		int toplam = list.stream().reduce(0,(x, y) -> x + y);
		
		/*
		 * x her zaman ilk degerini atanan degerden 0 alir
		 * y her zaman degerini list.stream()'den alir(akis)
		 * x ilk degerden sonraki degerlerini islemden alir
		 */
		System.out.println(toplam);
		// System.out.println(list.stream().reduce(0,(x,y) -> x + y));
	}
	// listteki tum elemanlarin toplamini yazdirin
	// method reference
	public static void toplaEl2(List<Integer> list) {
		Optional<Integer> toplam = list.stream().reduce(Math::addExact);
		// Optional<Integer> toplam = list.stream().reduce(Integer::sum);
		/*
		 * x her zaman ilk degerini atanan degerden 0 alir
		 * y her zaman degerini list.stream()'den alir(akis)
		 * x ilk degerden sonraki degerlerini islemden alir
		 */
		System.out.println(toplam);
		// System.out.println(list.stream().reduce(Math::addExact));
	}
	// listteki tum elemanlarin toplamini yazdirin
	// method reference
	public static void carpCiftEl1(List<Integer> list) {
		Optional<Integer> carp = list.stream().filter(Lambda01::ciftBul).reduce(Math::multiplyExact);
		System.out.println(carp);
	}
	// list'teki cift elemanlarin yazdriniz
	// lambda expression...
	public static void carpCiftEl2(List<Integer> list) {
		Integer carp = list.stream().filter(Lambda01::ciftBul).reduce(1,(x,y)->(x*y));
		// pozitif deger uretiniz
		Integer carpPoz = list.stream().filter(Lambda01::ciftBul).reduce(-1,(x,y)->(x*y));
		System.out.println(carp);
		System.out.println(carpPoz);
	}
	// list'teki elemanlardan en kucugunu 4 farkli yontem ile yazdiriniz
	// 1. yontem method reference --> Integer class
	public static void min1(List<Integer> list) {
		Optional<Integer> min =list.stream().reduce(Integer::min);
		System.out.println(min);
	}
	// 2. yontem method reference --> Math class
	public static void min2(List<Integer> list) {
		Optional<Integer> min =list.stream().reduce(Math::min);
		System.out.println(min);
	}
	// 3. yontem methodu
	public static int minBul(int x, int y) {
		return x<y ? x:y;// ternary
	}
	// 3. yontem method reference --> Haluk class
	public static void min3(List<Integer> list) {
		Optional<Integer> min =list.stream().reduce(Lambda02::minBul);
		System.out.println(min);
	}
	// 4. yontem lambda expression
	public static void min4(List<Integer> list) {
		Integer min =list.stream().reduce(Integer.MAX_VALUE,(x,y)->x<y?x:y);
		System.out.println(min);
	}
}
