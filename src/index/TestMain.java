//Nikola Ostojic
package index;
//import java.util.Scanner;

public class TestMain{
  public static Index[]indeksi= new Index[100];
  private static int pozicija = 0;
   
//1.Učitaj: metoda kojom se ubacuje 10-tak objekata klase Index u kolekciju. 
    public static void ucitaj(Index z){
        int i = pozicija++;
            indeksi[i]=z;
    }

//// KOMENTAR: Metoda koja sluzi da korisnik sam unese indekse u kolekciju preko tastature
//  public static void ucitaj(){
//        for (int i = 0; i < indeksi.length; i++) {
//            indeksi[i]= new Index();
//            System.out.print("Unesi godinu upisa: ");
//            Scanner dodajGodinu = new Scanner(System.in);
//                int godina = (dodajGodinu.nextInt());
//                    indeksi[i].setGodina(godina);
//            
//            System.out.print("Unesi broj indeksa: ");
//            Scanner dodajIndeks = new Scanner(System.in);
//                int broj = (dodajIndeks.nextInt());
//                    indeksi[i].setBroj(broj);
//            
//            System.out.print("Unesi smer (ISIT,ME,OM,UK): ");
//            Scanner dodajSmer = new Scanner(System.in);
//                String smer = (dodajSmer.nextLine().toUpperCase());
//                    indeksi[i].setSmer(Smer.valueOf(smer));
//        }
//  }
    
  
//2. PoslednjiIndex: vraća broj poslednjeg studenta upisanog određene godine.    
    public static int poslednjiIndeks(int godina) {
      int max = 0;
      for (Index i : indeksi) {
          if (i != null && i.getGodina() == godina && max < i.getBroj()) { //pazi na NULL i velicinu niza
              max = i.getBroj();
          }
      }
        return max;
    }
/* 3. Popularnost: prima kao parametre dve godine, i vraća informaciju o 
*   tome da li se broj studenata povećao ili smanjio.
*/
    public static String popularnost(int generacija1, int generacija2){
    generacija1 = poslednjiIndeks(generacija1);
    generacija2 = poslednjiIndeks(generacija2);
        if (generacija1>generacija2)
            return  "vise studenata ima u starijoj generaciji.";
        else 
            return  "vise studenata ima u tekucoj generaciji.";
           }
//4. Overlodovati prethodnu metodu tako da vraća i informacije o broju 
//studenata upisanih u te dve godine.
    public static String popularnost(String generacija1, String generacija2){
    int x =Integer.parseInt(generacija1);
        x = poslednjiIndeks(x);
    int y =Integer.parseInt(generacija2);
        y = poslednjiIndeks(y);
            
        
    return "Broj studenata u generaciji "+generacija1+ " je "+x+" a u generaciji " +generacija2+ " je " + y +".";
     
        
}  
// 5.  PonovniUpis: prima kao parametar određeni Index iz kolekcije (npr. prvi) 
// i postavlja mu godinu na tekuću godinu, a broj treba da bude za jedan veći od 
//   poslednjeg Indexa tekuće godine.   
    public static void ponovniUpis(Index zaPromenu){
        int tekuca = 14;
        if(zaPromenu.getGodina() !=tekuca){
            zaPromenu.setGodina(tekuca);
            zaPromenu.setBroj(poslednjiIndeks(tekuca)+1);
        }
        else{
System.out.println("Student "+zaPromenu.getGodina()+"/"+zaPromenu.getBroj()+" je tekuca generacija, nema potrebe za ponovnim upisom.");
                  
    }
    }
//6.Ispis: ispisuju se svi Indexi u formatu: godina/broj, SMER.    
    public static void ispis() {
    System.out.println("RB\tGen/Indeks\tSMER");
    int k = 0;
      for (Index i : indeksi) {
          if (i != null) {
              k++;
              System.out.println(k+"\t"+ i); 
          }
      }
     
    }
//7. NajpopularnijiSmer: metoda koja vraća informaciju o smeru sa najvećim brojem studenata.
    public static Smer najpopularnijiSmer() {
    Smer najpop = null;
    int brojac1 = 0;
//pazi da nije NULL u IF!!!
    for (int i = 0; i < indeksi.length; ++i) {
        int brojac2 = 0;
        for (int j = 0; j < indeksi.length; ++j) {
            if (indeksi[i]!= null&& indeksi[j]!=null && indeksi[j].getSmer() == indeksi[i].getSmer()) 
                ++brojac2;
        }
        if (brojac2 > brojac1) {
            brojac1 = brojac2;
            najpop = indeksi[i].getSmer();
        }
    }
    return najpop;
}
    public static void main(String[] args) {

 //unos radi testiranja       
    ucitaj(new Index(11, 1014, Smer.ME));
    ucitaj(new Index(10, 1013, Smer.UK));
    ucitaj(new Index(14, 1113, Smer.OM));
    ucitaj(new Index(11, 1015, Smer.OM));
    ucitaj(new Index(10, 1016, Smer.ISIT));
    ucitaj(new Index(14, 1115, Smer.ME));
    ucitaj(new Index(10, 1014, Smer.ISIT));
    ucitaj(new Index(10, 1015, Smer.ME));
    ucitaj(new Index(14, 1119, Smer.ISIT));
    ucitaj(new Index(14, 1120, Smer.ISIT));

    ispis();
        
    System.out.println("Poslednji upisani indeks u trazenoj generaciji je "+ poslednjiIndeks(14)+"."); // unos generacija
    
    System.out.println("Poredjenje popularnosti je pokazalo da " + popularnost(11,14)); // unos dve generacije int
    System.out.println(popularnost("14","11"));//unos dve generacije kao string
        
    ponovniUpis(indeksi[0]); //ucitava informacije prvog indeksa u bazi
    ponovniUpis(indeksi[5]); // ucitava informacije 5. indeksa u bazi
       
        
//    ispis();
        
    System.out.println("Najpopularniji smer na fakultetu je "+najpopularnijiSmer()+".");
        
    }
}
      
