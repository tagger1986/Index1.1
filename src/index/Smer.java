//Nikola Ostojic
package index;

/**
 *
 * @author Nikola
 */
public enum Smer{
    ISIT("Informacioni sistemi i tehnologije"),
    ME("Menadzment"),
    OM("Operacioni menadzment"),
    UK("Upravljanje kvalitetom");

 
    
    public String smer;

    private Smer(String smer) {
        this.smer = smer;
    }

    public void setSmer(String smer) {
        this.smer = smer;
    }
    
    public String getSmer() {
        return smer;
    }
    
    
}
