package Ex1;

public class Parabola {
    private int a, b, c;

    public Parabola(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double coordonataX()
    {
        return (double) (-b)/(double)(2*a);
    }

    public double coordonataY()
    {
        return (double) (-b*b+4*a*c)/ (double)(4*a);
    }

    public double[] mijlocSegmentDreapta (Parabola p)
    {
        double X=(coordonataX()+p.coordonataX())/2;
        double Y=(coordonataY()+p.coordonataY())/2;

        return new double[]{X, Y};
    }

    public static double[] mijlocSegment(Parabola p1, Parabola p2)
    {
        double X=(double) (p1.coordonataX()+p2.coordonataX())/2;
        double Y=(double) (p1.coordonataY()+p2.coordonataY())/2;

        return new double[]{X, Y};
    }

    public double lungimeSegment(Parabola p)
    {
        double X=p.coordonataX()-coordonataX();
        double Y=p.coordonataY()-coordonataY();

        return Math.hypot(X, Y);
    }

    public static double lungimeSegmentP2(Parabola p1, Parabola p2)
    {
        double X=p2.coordonataX()-p1.coordonataX();
        double Y=p2.coordonataY()-p1.coordonataY();

        return Math.hypot(X, Y);
    }

    @Override
    public String toString() {
        return "f(x) = "
                + a + "x^2"
                + " + "
                + b + "x"
                + " + "
                + c;
    }
}
