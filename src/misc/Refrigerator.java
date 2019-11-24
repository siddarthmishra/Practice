package misc;

import java.util.Scanner;

public class Refrigerator {
	public static String z, v, pl = "";

	public static void main(String args[]) {
		System.out.println("*****************************************");
		System.out.println(" Welcome to Refrigerator program ");
		System.out.println("******************************************");
		System.out.println("o-o-o-o-o-o-o-o-o-o-o-o-o-o-o");
		System.out.println("Haier Refrigerator");
		System.out.println("On Your Refrigerator");
		System.out.print("How many food items are kept inside the refrigerator?:");
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		System.out.print("Enter the products kept inside the refrigerator:");
		for (int e = 1; e <= r; e++) {
			String s = sc.next().trim().toLowerCase();
			pl = pl.concat(s);
			System.out.print("\t\t\t\t\t\t");
		}
		System.out.println();
		System.out.println("Here comes your menu");
		System.out.print("Enter '0' to show the menu:");
		int c = sc.nextInt();
		if (c == 0) {
			System.out.println("0.ToadjustthemodificationofRefrigerator");
			System.out.println("1.Tostorethefooditem insidetherefrigerator");
			System.out.println("2.Totakefooditem outoftherefrigerator");
			System.out.println("3.Tocleantherefrigerator");
			System.out.print("Selectoneofoption:");
			int choice = sc.nextInt();
			switch (choice) {
			case 0:
				System.out.println("Toadjustthemodificationofrefrigerator!!!");
				System.out.println("opentherefrigerator");
				System.out.print("Seethetemperatureadjustmentandenterit:");
				int t = sc.nextInt();
				if (t <= 16 && t >= 5) {
					System.out.println("Moderatetemperature");
					System.out.println("Foodstoredintherefrigeratorwillbeingoodcondition");
				} else {
					System.out.println("Foodstoredwillnotbeingoodcondition");
				}
				System.out.println("Iftherefrigeratorisinfreezermood");
				System.out.println("Now,Settherefrigeratortorefrigeratormoodfrom freezermood");
				System.out.println("AndpressSMARToptionintherefrigeratoritprotectscompibalityoftherefrigerator");
				System.out.println("NowyourRefrigeratorismodified");
				break;
			case 1:
				System.out.println("Tostorethefooditem insidetherefrigerator!!!");
				System.out.print("PressUNLOCKoptionintherefrigerator:");
				String h = "UNLOCK";
				String D = sc.next();
				if (D.equals(h)) {
					System.out.println("Refrigeratoropens");
				} else {
					System.out.println("Refrigeratordoesnotopens");
				}
				System.out.print("Entertheitem whichyouwantedtobestoredinsidetherefrigerator:");
				String p = sc.next().trim().toLowerCase();
				boolean b = pl.contains(p);
				if (b) {
					System.out.println("Theitem whichyouwantedtostoreisalreadyinpresent");
					System.out.print("IfyouwanttostoreitagainenterSTORE:");
					v = "STORE";
					z = sc.next();
					if (z.equals(v)) {
						System.out.println("Youcanstorethefood");
					} else {
						System.out.println("youarenotallowedtostoreuntilyouenterSTORE");
					}
				} else {
					pl = pl.concat(p);
					System.out.println("Youcanstorethefooditems");
				}
				System.out.println("Selsctoneofthegivenchioceinthefollowingmenuastheproductbelongswhichcategory?");
				System.out.println(
						"a.Itisamilkproduct\nb.Itisacoolentproduct\nc.Itisavegetarianproduct(fruitsorvegetables)\nd.Itisanonvegetarianproduct\ne.Itiscooldrinks\nf.Otherproductsthanthese");
				System.out.print("choice:");
				String i = sc.next().toLowerCase();
				char i1 = i.charAt(0);
				switch (i1) {
				case 'a':
					System.out.println("itisamilkproductsoitisstoredinthesecondrackfrom thefreezer");
					break;
				case 'b':
					System.out.println("itisacoolentproductsoitisstoredinfreezer");
					break;
				case 'c':
					System.out.println("Itisavegetarianproduct");
					System.out.println(
							"fruitsatstoredinthemiddlerackoftherefrigeratorandvegetablesarestoredinabovethebottom layerwheretomatoesandsensitiveveggiesareStored");
					break;
				case 'd':
					System.out.println("itisanonvegetarianproducthenceitisstoredinfreezer");
					break;
				case 'e':
					System.out.println("cooldrinksarestoredinsideracks");
					break;
				case 'f':
					System.out.println("otherfooditemsarestoredinotherleftoutracks");
					break;
				default:
					System.out.println("invalid");
					break;
				}
				System.out.println("Now,foodisstored");
				break;
			case 2:
				System.out.println("Totakefooditem outoftherefrigerator!!!");
				System.out.println("enterthefooditem whichyouwanttotakeoutoftherefrigerator");
				String f = sc.next().trim().toLowerCase();
				boolean remove = pl.contains(f);
				if (remove) {
					System.out.println("Youcantakeout" + f + "item");
				} else {
					System.out.println("Youcan'ttakeout" + f + "item");
				}
				break;
			case 3:
				System.out.println("Tocleanthetherefrigerator!!!");
				System.out.println("Takeouteveryfooditem keptinsidetherefrigerator");
				System.out.print("Aftertakingallthefooditemsoutoftherefrigerator,EnterOUT");
				String q = sc.next();
				String y = "OUT";
				if (q.equals(y)) {
					System.out.print("PressHOILIDAYbuttonintherefrigerator");
				} else {
					System.out.println("Youcannotbeallowedtoclean");
				}
				System.out.println("\nNow,Changetherefrigeratormodeintofreezermode");
				System.out.print("PressDEFORSTtomelttheicecoolents");
				String T = "DEFORST";
				Scanner l = new Scanner(System.in);
				String k1 = l.next().trim();
				if (T.equals(k1)) {
					System.out.println("Now,icemelts");
				} else {
					System.out.println("icedoesnotmelts");
				}
				System.out.println("Refrigeratorwillbecleaned");
				break;
			default:
				System.out.println("!!!invalid!!!");
				break;
			}
		}
	}
}