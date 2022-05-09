package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Lambda04 {

	public static void main(String[] args) {
		
		TechPro trGunduz=new TechPro("yaz", "TR gunduz", 97, 124);
		TechPro engGunduz=new TechPro("kis", "ENG gunduz", 95, 131);
		TechPro trGece=new TechPro("bahar", "TR gunduz", 98, 143);
		TechPro engGece=new TechPro("sonbahar", "ENG gunduz", 93, 151);
		
	List<TechPro> list=new ArrayList<>(Arrays.asList(trGunduz,engGunduz,trGece,engGece));
	
	// bu class'da agirlikli return  type calisacagiz
	
	System.out.println(batchOrt92Byk(list));
	System.out.println();
	System.out.println(ogrcSayisi110Az(list));
	System.out.println();
	System.out.println(herhangiBirBaharKontrol(list));
	System.out.println();
	System.out.println(ogrcSayisiTersSiralaBatch(list));
	System.out.println();
	System.out.println(batchOrtTersSiraliBatch(list));
	System.out.println();
	System.out.println(ogrcSayisiEnAz2Batch(list));
	System.out.println();
	System.out.println(ogrcOrt95BykOgrcSayisi(list));
	System.out.println();
	System.out.println(batchOrt95BykOgrcSayisi(list));
	System.out.println();
	System.out.println(ogrcSayisi130BykBatchOrt(list));
	}
	
	// task 01--> batch ort'larinin 92'den buyuk oldugu kontrol eden parametre create ediniz
	public static boolean batchOrt92Byk(List<TechPro> list) {
		return list.
				stream().
				allMatch(t->t.getBatchOrt()>92); // akisindaki her eleman batchart field'a gore eslesmesini kontrol ediyor
	}
	// task 02--> ogrc sayilarinin hic birinin 110 dan az olmadigini kontrol eden parametre create ediniz
	
	public static boolean ogrcSayisi110Az(List<TechPro> list) {
		return list.
				stream().
				noneMatch(t -> t.getOgrcSayisi()<110);
			// allMatch(t -> t.getOgrcSayisi()>=110);
	}
	// task 03--> batch'lerde herhangi birinde "bahar" olup olmadigini kontrol eden parametre create ediniz
	
		public static boolean herhangiBirBaharKontrol(List<TechPro> list) {
			return list.
					stream().
					anyMatch(t->t.getBatch().equals("bahar"));
		}
	// task 04--> batch'leri ogr sayilarina gore buyuk->kck siralayin
		
	public static List<TechPro> ogrcSayisiTersSiralaBatch(List<TechPro> list) {
		return	list.
				stream().
				sorted(Comparator.comparing(TechPro::getOgrcSayisi).
					reversed()). // ogrcSayisi parametresine gore ters siraladi
				collect(Collectors.toList()); // collect() -> akisdaki elemanalri istenen sarta gore topla
											// Collectors.toList() ->collect'e toplanan elemanlarilist'e cevirir
		}
	// task 05-->batch'leri batch ort gore b->k siralayip ilk 3'unu yazdiriniz
	
	public static List<TechPro> batchOrtTersSiraliBatch(List<TechPro> list) {
		return	list.
			stream().
			sorted(Comparator.comparing(TechPro::getBatchOrt).
				reversed()).
			limit(3). 
			collect(Collectors.toList()); 
	}
	// task 06-->ogrc sayisi en az olan 2. batch'i yazdiriniz
	
	public static List<TechPro> ogrcSayisiEnAz2Batch(List<TechPro> list) {
		return	list.
				stream().
				sorted(Comparator.comparing(TechPro::getOgrcSayisi)).
				limit(2). // ilk iki eleman alindi
				skip(1). // ilk eleman atlandi
				collect(Collectors.toList()); 
		}
	// task 07--> batch ort 95'den buyuk olan batch'lerin ogrc sayilarini toplamini yazdiriniz
		
	public static int ogrcOrt95BykOgrcSayisi(List<TechPro> list) {
		return	list.
				stream().
				filter(t->t.getBatchOrt()>95). // 95 den byk sarti
				map(t->t.getOgrcSayisi()). // batch ort olan data ogrc sayisi olarak update edildi
				// reduce(0,Integer::sum); // ogrc  sayisi toplandi
				reduce(0,(t,u)->t+u); // ogrc sayisi toplandi
			}
	public static int batchOrt95BykOgrcSayisi(List<TechPro> list) {
		return	list.
				stream().
				filter(t->t.getBatchOrt()>95). // 95 den byk sarti
				mapToInt(t->t.getOgrcSayisi()). //mapToInt()-->type gore int return ederki sum() 
								// calisir reduce gerek kalmaz daha kisa ve hizli code saglar
				sum();
			}
	// task 08--> ogrc sayilari 130'dan buyuk olan batch'lerin batch ort bulunuz
	public static OptionalDouble ogrcSayisi130BykBatchOrt(List<TechPro> list) {
		return list.stream().
		filter(t->t.getOgrcSayisi()>130).
		mapToDouble(t->t.getBatchOrt()).
		average();
		
	}
}
