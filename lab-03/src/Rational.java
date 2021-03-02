public class Rational {
   private int num;
   private int den;

    public Rational(int num, int den) {
        if(den == 0){
            throw new RuntimeException("Rational: denominator is equal to zero");
        }
        if(den<0){
            num = -num;
            den = -den;
        }

        int a = Math.abs(num);
        int b = Math.abs(den);

        while(b!=0){
            int rem = a % b;
            a = b;
            b = rem;
        }

        this.num = num/a;
        this.den = den/a;
    }
    @Override
    public String toString(){
        return num+"/"+ den;
    }

    public Rational add(Rational other) {
        int rNum = num * other.den + den*other.num;
        int rDen = den * other.den;
        return new Rational(rNum, rDen);
    }

    public Rational subtract(Rational other) {
        int rNum = num * other.den - den*other.num;
        int rDen = den * other.den;
        return new Rational(rNum, rDen);
    }

    public Rational multiply(Rational other) {
        int rNum = num * other.num;
        int rDen = den * other.den;
        return new Rational(rNum, rDen);
    }

    public Rational divide(Rational other) {
        if(other.num==0){
            throw new RuntimeException("Rational: division by zero");
        }
        int rNum = num * other.den ;
        int rDen = den * other.num;
        return new Rational(rNum, rDen);
    }

    public int compareTo(Rational other) {
        int lhs = num * other.den;
        int rhs = other.num * den;
        if(lhs<rhs){
            return -1;
        } else if(lhs>rhs){
            return 1;
        }
        return 0;
    }
}
