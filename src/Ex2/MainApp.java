package Ex2;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws IOException {
        String nume_fis = "produse.csv";
        BufferedReader flux_in;
        flux_in = new BufferedReader(new InputStreamReader(new FileInputStream(nume_fis)));
        String produs;
        float pret;
        int cantitate;
        LocalDate data_expirarii;

        List<Produs> produse = new ArrayList<Produs>();

        for(String linie; (linie = flux_in.readLine())!=null;)
        {
            String[] words = linie.split(", ");
            produs = words[0];
            pret = Float.parseFloat(words[1]);
            cantitate = Integer.parseInt(words[2]);
            data_expirarii = LocalDate.parse(words[3]);

            produse.add(new Produs(produs, pret, cantitate, data_expirarii));
        }

        do
        {
            System.out.println("a. Afisarea produselor.");
            System.out.println("b. Afisarea produselor expirate.");
            System.out.println("c. Vanzarea unui produs.");
            System.out.println("d. Afisarea produselor cu pretul minim");
            System.out.println("e. Salvarea produselor care au o cantitate mai mica decat o valoare citita de la tastatura intr-un fisier");
            System.out.println("n. Exit");
            System.out.println();
            System.out.print("Alegeti optiunea: ");
            Scanner sc = new Scanner(System.in);
            char opt;
            while(!Character.isLetter(opt = sc.next().charAt(0)));
            sc.nextLine();
            switch (opt)
            {
                case 'a':
                    for(Produs p:produse)
                        System.out.print(p.toString());
                    System.out.println("Total incasari: " + Produs.getIncasari());
                    break;
                case 'b':
                    for(Produs p:produse)
                        p.Afisare_produse_expirate(p);
                    break;
                case 'c':
                    System.out.print("Ce produs vreti sa cumparati: ");
                    String nume = sc.nextLine();
                    System.out.print("Ce cantitate cumparati: ");
                    int cant = sc.nextInt(), ok = 0;
                    for (Produs p:produse)
                    {
                        ok = 1;
                        if (nume.equals(p.getProdus()))
                            if (p.getCantitate() != 0)
                                p.vanzare(cant);
                            else
                                System.out.println("Din pacate, acest produs nu mai este in stoc!");
                    }
                    if (ok == 0)
                        System.out.println("Din pacate, nu avem acest produs deloc!");
                    Iterator<Produs> it = produse.iterator();
                    while(it.hasNext())
                    {
                        Produs sterge = it.next();
                        if(sterge.getCantitate() == 0)
                            it.remove();
                    }
                    for(Produs p:produse)
                        System.out.print(p.toString());
                    break;
                case 'd':
                    Produs p1 = produse.get(0);
                    float minim = p1.getPret();
                    for(Produs p:produse)
                    {
                        if (p.getPret() < minim)
                            minim = p.getPret();
                    }
                    for(Produs p:produse)
                    {
                        if (p.getPret() == minim)
                            System.out.print(p.toString());
                    }
                    break;
                case 'e':
                    PrintStream flux_out = new PrintStream ("fisier_out.txt");
                    System.out.print("Dati cantitatea: ");
                    int cant_min = sc.nextInt();
                    for(Produs p:produse)
                    {
                        if (p.getCantitate() < cant_min)
                            flux_out.print(p);
                    }
                    break;
                case 'n':
                    System.exit(0);
                default:
                    System.out.println("Wrong option!");
                    break;
            }

            System.out.println();
        } while(true);
    }
}