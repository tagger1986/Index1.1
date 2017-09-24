//Nikola Ostojic
package index;

/**
 *
 * @author Nikola
 */
public class Index{
 public Smer smer;
 public int broj;
 public int godina;

 
    public Index(int godina, int broj, Smer smer) {
        this.smer = smer;
        this.broj = broj;
        this.godina = godina;
    }

    Index() {
    }


   
     public Smer getSmer() {
        return smer;
    }

    public void setSmer(Smer smer) {
        this.smer = smer;
    }

    public int getBroj() {
        return broj;
    }

    public void setBroj(int broj) {
        this.broj = broj;
    }

    public int getGodina() {
        return godina;
    }

    public void setGodina(int godina) {
        this.godina = godina;
    }

 @Override
     public String toString(){
           return String.format("%s/%s\t\t%s",getGodina(), getBroj(),smer.getSmer());
     }  

 
}
