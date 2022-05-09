package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Lambda03 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>(Arrays.asList("mehmet",
				"emre","nilgun","cincix","kader","emine","islam","islam","wabuziddin","kokorec"));
		
		alfabetikBykHarf(list);
		System.out.println();
		karakterSayisiTekrarsizSirali(list);
		System.out.println();
		karakterSayisiSiraliEl(list);
		System.out.println();
		sonHarfSiraliEl(list);
		System.out.println();
		ciftKareTekrarsizTersSire(list);
		System.out.println();
		harfSayisi7Kontrol(list);
		System.out.println();
		wBaslamaKontrol(list);
		System.out.println();
		xBitenKontrol(list);
		System.out.println();
		karakteriEnBuyukEl(list);
		System.out.println();
		karakteriEnBuyukEl2(list);
		System.out.println();
		ilkElemanHaricSonHarfSirali(list);
	}
	// List elemanlarini alfabetik buyuk harf ve tekrarsiz yazdiriniz
	public static void alfabetikBykHarf(List<String> list) {
	list.
	stream().
	// map(t->t.toUpperCase()). // elemanlari byk harf update edildi
	map(String::toUpperCase). // // elemanlari byk harf update edildi
	sorted(). // sira
	distinct(). // tekrarsiz yapildi ......... cok onemli islami 1 kere yazdirdi
	forEach(t->System.out.print(t + " ")); // EMRE EMÝNE KADER MEHMET NÝLGUN YÝLDÝZ ÝSLAM 
	}
	// list elemanlarinin character sayisini ters sirali olarak tekrarsiz yazdiriniz
	
	public static void karakterSayisiTekrarsizSirali(List<String> list) {
		list.
		stream().
		map(t->t.length()). // String data character sayisina update edildi
		sorted(Comparator.reverseOrder()). // ters sira
		distinct(). // tekrarsiz
		forEach(Lambda01::printEl); // yazdirildi
	}
	// list elemanlarini character sayisina gore kckten byke gore yazdiriniz.
	public static void karakterSayisiSiraliEl(List<String> list) {
		list.
		stream().
		sorted(Comparator.comparing(t->t.toString().length())). // eleman character sayisina gore ozel siralama yapildi
		forEach(t->System.out.print(t +" "));
	}
	// list elemanlarinin sonra harfine gore ters sirali yazdiriniz
	public static void sonHarfSiraliEl(List<String> list) {
		list.
		stream().
		sorted(Comparator.
				comparing(t->t.toString().
						charAt(t.toString().length()-1)). // elemanin length()-1)--> son indexin'nin karakterini alir
		reversed()). //elemanin length()-1)--> son indexin'nin karakterini ters siralara z->a
		forEach(t->System.out.print(t + " "));
	}
	// listin elemanlarinin karakterlerinin cift sayili karakter karelerini hesaplayan, ve karelerini tekrarsiz buyukten kucuge sirali yaziniz
	public static void ciftKareTekrarsizTersSire(List<String> list) {
		list.
		stream().
		// filter(t->t.length()%2==0).
		map(t->t.length()*t.length()). // string elemanlari character sayisina cevrildi
		filter(Lambda01::ciftBul). // cift sarti calisti
		distinct(). // tekrarsiz
		sorted(Comparator.reverseOrder()). // ters sira b->k
		forEach(Lambda01::printEl); // yazdirilidi
	}
	// list elemanlarinin karakter sayisini 7 ve 7'den az olma durumunu kontrol ediniz
	public static void harfSayisi7Kontrol(List<String> list) {
		/*boolean kontrol =list.
		stream().
		allMatch(t->t.length()<=7); // her bir elemani harf sayisini <=7'ye eslemesine bakti
		if (kontrol) {
			System.out.println("list elemanlari 7 harften buyuk degil");
		} else {
			System.out.println("list elemanlari 7 harften buyuk");
		}
		System.out.println(kontrol);
		*/
		System.out.println(list.
				stream().
				allMatch(t->t.length()<=7) // allmatch() her bir tum elemani eslestir
				?"list elemanlari 7 harften buyuk degil":"list elemanlari 7 harften buyuk");
	}
	// List elemanlarinin "W" ile baslamasini kontrol ediniz
	public static void wBaslamaKontrol(List<String> list) {
		System.out.println(list.
				stream().
				noneMatch(t->t.startsWith("w"))?"w ile baslayan isim yok ":"w ile baslayan isim var");
	}
	// List elemanlarinin "x" ile baslamasini kontrol ediniz
		public static void xBitenKontrol(List<String> list) {
			System.out.println(list.
					stream().
					anyMatch(t->t.endsWith("x"))?"x ile biten isim var":"x ile biten isim yok");
		}
// anyMatch() --> en az bir eleman sarti saglarsa true aksi durumda false return eder
// allMatch() --> tum elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder
// noneMatch() -->	hicbir sarti saglamaza true en az bir eleman sarti saglarsa false return eder
		
	// karakter sayisi en buyuk elemani yazdirniz
	public static void karakteriEnBuyukEl(List<String> list) {
		System.out.println(list.
				stream().
				sorted(Comparator.comparing(t->t.toString().length()). // lenght karakter uzunluguna gore siraladi k->b
						reversed()). // ters siraladi b->b
				findFirst());
				
	}
	public static void karakteriEnBuyukEl2(List<String> list) {
		Stream<String> sonIsim = list.
				stream().
				sorted(Comparator.comparing(t->t.toString().length()). // lenght karakter uzunluguna gore siraladi k->b
						reversed()). // ters siraladi b->b
				limit(1); // limit(a) akisindan cikan elemanlari a parametresine gore ilk a elemani alir
		System.out.println(Arrays.toString(sonIsim.toArray()));
	}
	// list elemanlarini son harfine gore siralayip eleman haric kalan elemanlari yazdiriniz
	public static void ilkElemanHaricSonHarfSirali(List<String> list) {
		list.
		stream().
		sorted(Comparator.comparing(t ->t.toString().charAt(t.length()-1))).
		skip(1). // akistan cikan elemanlarin 1. parametreyi atlar
		// forEach(System.out::println);
		forEach(t-> System.out.print(t+" "));
		
	}
}
