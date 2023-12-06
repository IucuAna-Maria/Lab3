package Ex2;

import java.time.LocalDate;

public class Produs {
    private final String produs;
    private final float pret;
    private int cantitate;
    private final LocalDate data_expirarii;
    static float incasari = 0;

    public Produs(String produs, float pret, int cantitate, LocalDate data)
    {
        this.produs = produs;
        this.pret = pret;
        this.cantitate = cantitate;
        this.data_expirarii = data;
    }

    public String getProdus()
    {
        return produs;
    }
    public float getPret()
    {
        return pret;
    }
    public int getCantitate()
    {
        return cantitate;
    }
    public LocalDate getData()
    {
        return data_expirarii;
    }

    @Override
    public String toString()
    {
        return getProdus()
                + " " + getPret()
                + " " + getCantitate()
                + " " + getData()
                + "\n";
    }

    public void Afisare_produse_expirate(Produs p)
    {
        LocalDate now = LocalDate.now();
        if(now.isAfter(data_expirarii))
            System.out.print(p.toString());
    }

    public void vanzare (int cantitateVanduta)
    {
        if (cantitateVanduta > cantitate)
            System.out.println("Nu există suficientă cantitate pentru vânzare.");
        else
        {
            incasari += cantitateVanduta * pret;
            cantitate -= cantitateVanduta;
            System.out.println("Vânzare realizată pentru " + cantitateVanduta + " bucăți de " + produs);
        }
    }

    public static float getIncasari()
    {
        return incasari;
    }

}
