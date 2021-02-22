public class Rational {
   private int num;
   private int den;

    public Rational(int num, int den) {
        if(den == 0){
            throw new RuntimeException("Rational: denominator is equal to zero");
        }
        this.num = num;
        this.den = den;
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
}
