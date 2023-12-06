package Ex1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp
{
    public static void main(String[] args) throws IOException
    {
        List<Parabola> parabole = new ArrayList<Parabola>();

        String nume_fis = "in.txt";
        BufferedReader flux_in;
        flux_in = new BufferedReader(new InputStreamReader(new FileInputStream(nume_fis)));

        int a, b, c;
        for(String linie; (linie = flux_in.readLine())!=null;)
        {
            String[] words = linie.split(" ");
            a = Integer.parseInt(words[0]);
            b = Integer.parseInt(words[1]);
            c = Integer.parseInt(words[2]);

            parabole.add(new Parabola(a, b, c));
        }

        do
        {
            System.out.println("0. Iesire");
            System.out.println("1. Afisare lista parabole + varf");
            System.out.println("2. Afisare Mijloc segment");
            System.out.println("3. Afisare mijloc segment (2 parabole)");
            System.out.println("4. Afisare lungime segment");
            System.out.println("5. Afisare lungime segment (2 parabole)");
            System.out.println();
            System.out.print("Alegeti optiunea: ");

            Scanner sc = new Scanner(System.in);
            int opt = sc.nextInt();
            System.out.println();

            switch (opt)
            {
                case 0:
                    System.exit(0);
                case 1:
                    for (Parabola p:parabole)
                        System.out.println(p.toString() + " " + p.coordonataX() + " " + p.coordonataY());
                    break;
                case 2:
                {
                    System.out.println("Introdu valorile parabolei: ");
                    double[] mijloc;
                    System.out.print("a= ");
                    a = sc.nextInt();
                    System.out.print("b= ");
                    b = sc.nextInt();
                    System.out.print("c= ");
                    c = sc.nextInt();
                    Parabola p4 = new Parabola(a, b, c);

                    Parabola p = parabole.get(0);

                    mijloc = p.mijlocSegmentDreapta(p4);
                    System.out.println(mijloc[0] + " " + mijloc[1]);
                    break;
                }
                case 3:
                {
                    double[] mijloc;
                    Parabola P1 = parabole.get(0);
                    Parabola P2 = parabole.get(1);

                    mijloc = Parabola.mijlocSegment(P1, P2);
                    System.out.println("Mijlocul segmentului dintre p1 si p2: " + mijloc[0] + " " + mijloc[1]);
                    break;
                }
                case 4:
                {
                    System.out.println("Introdu valorile parabolei: ");
                    double[] mijloc;
                    System.out.print("a= ");
                    a = sc.nextInt();
                    System.out.print("b= ");
                    b = sc.nextInt();
                    System.out.print("c= ");
                    c = sc.nextInt();
                    Parabola p = new Parabola(a, b, c);

                    Parabola P = parabole.get(0);
                    System.out.println(P.lungimeSegment(p));
                    break;
                }
                case 5:
                    Parabola P1 = parabole.get(0);
                    Parabola P2 = parabole.get(1);
                    System.out.println(Parabola.lungimeSegmentP2(P1, P2));
                    break;
                default:
                    System.out.println("Optiune gresita!");
                    break;
            }
            System.out.println();
        } while(true);
    }
}
