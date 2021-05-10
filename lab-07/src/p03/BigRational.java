package p03;

import java.math.BigInteger;

public class BigRational implements MyComparable{
    private BigInteger num;
    private BigInteger den;

    public BigRational(BigInteger num, BigInteger den) {
        if(den.equals(BigInteger.ZERO)){
            throw new RuntimeException("calc01.calc02.BigRational: denominator is equal to zero");
        }
        if(den.signum()<0){
            num = num.negate();
            den = den.negate();
        }

        BigInteger d = num.gcd(den);
        this.num = num.divide(d);
        this.den = den.divide(d);
    }

    public static BigRational parse(String s) {
        s=s.trim();
        int indexSlash = s.indexOf('/');
        if(indexSlash==-1){
            return new BigRational(new BigInteger(s), BigInteger.ONE);
        }
        String n = s.substring(0,indexSlash);
        String d = s.substring(indexSlash+1);
        return new BigRational(new BigInteger(n),new BigInteger(d));
    }

    @Override
    public String toString(){
        return num+"/"+ den;
    }

    public BigRational add(BigRational other) {
        BigInteger rNum = num.multiply(other.den).add(den.multiply(other.num));
        BigInteger rDen = den.multiply(other.den);
        return new BigRational(rNum, rDen);
    }

    public BigRational subtract(BigRational other) {
        BigInteger rNum = num.multiply(other.den).subtract(den.multiply(other.num));
        BigInteger rDen = den.multiply(other.den);
        return new BigRational(rNum, rDen);
    }

    public BigRational multiply(BigRational other) {
        BigInteger rNum = num.multiply(other.num);
        BigInteger rDen = den.multiply(other.den);
        return new BigRational(rNum, rDen);
    }

    public BigRational divide(BigRational other) {
        if(other.num.equals(BigInteger.ZERO)){
            throw new RuntimeException("calc01.calc02.BigRational: division by zero");
        }
        BigInteger rNum = num.multiply(other.den) ;
        BigInteger rDen = den.multiply(other.num);
        return new BigRational(rNum, rDen);
    }

    @Override
    public int compareTo(Object o){
        BigRational other = (BigRational) o;
        return num.multiply(other.den).compareTo(den.multiply(other.num));
    }
}
