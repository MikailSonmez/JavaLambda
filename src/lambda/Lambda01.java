package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda01 {
	/*
	 * 1- Lambda "functional programming"
	 * nasil yaparim degil ne yaparim
	 * 2- "structured programming" nasil yaparim
	 * 3- "functional programming" hiz, code kisaligi. code okunabilirligi ve
	 * hatarsiz code yazma acilarindan cok faydalidir
	 * 4- Lambda sadece collections'larda(list, queue ve set) ve array'larde kullanilabilir ancak
	 * map'lerde kullanilmaz
	 * lambda kullanmak hatasiz code kullanmaktir
	 */
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>(Arrays.asList(12,13,65,3,7,34,22,60,42,55));
		
		printElStructured(list); // method call
		System.out.println();
		printElfunctional(list);
		System.out.println();
		printElfunctional1(list);
		System.out.println();
		printCiftElStructured(list);
		System.out.println();
		printCiftElFunctional(list);
		System.out.println();
		printCiftElFunctional2(list);
		System.out.println();
		printCiftAltmisKucuk(list);
		System.out.println();
		printTekYirmiBuyuk(list);
		System.out.println();
		ciftKarePrint(list);
		System.out.println();
		ciftKarePrint1(list);
		System.out.println();
		kupbirFazlaTekFunction(list);
		System.out.println();
		ciftKarekokFunctional(list);
		System.out.println();
		maxElfunction(list);
	}
	// structure programming ile lsit elemanlarinin tamamini aralarina bosluk birakara yazdiriniz
	public static void printElStructured(List<Integer> list) {
		for (Integer w : list) {
			System.out.print(w + " ");
		}
		
	}
	// functional programming ile list elemanlarinin tamamini aralarina bosluk birakarak yazdiriniz
	public static void printElfunctional(List<Integer> list) {
		list.stream().forEach(t->System.out.print(t+ " ")); // lambda expression : lambda ifadesi
		// stream() : datalari yukaridan asagiya akis sekline getirir.
		// forEach() : datanin parametresine gore her bir elemani isler
		// t-> " Lambda operatoru
		// lambda expression yapisi cok tavsiye edilmez daha cok METHOD REFERENCE kullanilir
	}
	// Method Reference -->kendi create ettigimiz veya java'dan aldigimiz method ile
	// Classname::MethodName
	// ClassName:: MethodName--> ez- ber- leee
	
	public static void printEl(int t) {
		System.out.print(t + " ");
	}
	public static void printElfunctional1(List<Integer> list) {
		list.stream().forEach(Lambda01::printEl);
	}
	// structured programming ile list elemanlarinin cift olanlarini ayni satirda aralarina bosluk birakarak yazdiriniz
	public static void printCiftElStructured(List<Integer> list) {
		for (Integer w : list) {
			if (w%2==0) {
				System.out.print(w + " ");
			}
		}
	}
	// functional programming ile list elemanlarinin cift olanlarini ayni satirda aralarina bosluk birakarak yazdiriniz
	public static void printCiftElFunctional(List<Integer> list) {
		list.stream().filter(t->t%2==0).forEach(Lambda01::printEl);
		// filter()--> akis icerinsindeki elemanlari istenen sarta gore filtreleme yapar
	}
	public static boolean ciftBul(int i) { // reere edilecek tohum method create edildi
		
		return i%2==0;
	}
	public static void printCiftElFunctional2(List<Integer> list) {
		list.stream().filter(Lambda01::ciftBul).forEach(Lambda01::printEl); // iki tane merhod refere
		// filter()--> akis icerinsindeki elemanlari istenen sarta gore filtreleme yapar
	}
	// functional programmin ile list elemanlarinin cift olanlarinin 60 dan kucuk olanlarini ayni satirda aralarina bosluk koyarak yazdirin
	public static void printCiftAltmisKucuk(List<Integer> list) {
		list.stream().filter(t->t%2==0 & t<60).forEach(Lambda01::printEl);
	}
	// functional programmin ile list elemanlarinin tek olanlarinin veya 20 dan buyuk
	// olanlarini ayni satirda aralarina bosluk koyarak yazdirin
	public static void printTekYirmiBuyuk(List<Integer> list) {
		list.stream().filter(t->t%2==1 || t>20).sorted().forEach(Lambda01::printEl); // + siraladim
	}
	// functional programmin ile list elemanlarinin cift olanlarinin
	//karelerini ayni satirda aralarina bosluk  koyarak yazdirin
	
	public static void ciftKarePrint(List<Integer> list) {
		list.stream().filter(t->t%2==0).map(t->t*t).sorted().forEach(Lambda01::printEl); // + siraladim
		}
	public static void ciftKarePrint1(List<Integer> list) {
		list.stream().filter(t->t%2==0).map(Lambda01::kare).sorted().forEach(Lambda01::printEl); // + siraladim
		}
	public static int kare(int i) {
		
		return i*i;
	}
	//map() --> bir ara islemde kullanilir. elemanlari sitenen isleme gore degistirmek update etmek icin kullanilir.
	
	// functional programmin ile list elemanlarinin cift olanlarinin
		//karelerini ayni satirda aralarina bosluk  koyarak yazdirin
		
	public static void kupbirFazlaTekFunction(List<Integer> list) {
		list.stream().filter(t->t%2==1).map(t->(t*t*t)+1).forEach(Lambda01::printEl);
		}
	// functional programmin ile list elemanlarinin cift olanlarinin
		//karekoklerini ayni satirda aralarina bosluk  koyarak yazdirin
		
	public static void ciftKarekokFunctional(List<Integer> list) {
		list.stream().
		filter(Lambda01::ciftBul).
		map(Math::sqrt).
		sorted().
		forEach(t->System.out.print(t+" ")); // + siraladim
		}
	// list'in en buyuk elemanini yazdiriniz
	public static void maxElfunction(List<Integer> list) {
		Optional<Integer> maxEl = list.stream().reduce(Math::max);
		System.out.println(maxEl);
		// reduce()-->azaltmak ... bir cok datayi tek bir dataya(max min carp top vs islemlerde) cevirmek icin kullanilir
	}
}



