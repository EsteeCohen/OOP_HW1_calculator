

public class Rational implements Scalar {

    private int numerator;
    private int denominator;

    public Rational(int numerator, int denominator) {
        if (denominator == 0) {
            //return null;
            throw new IllegalArgumentException("The denominator cannot be 0!");

        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return this.numerator;
    }
    public int getDenominator() {
        return denominator;
    }

    // Method to compute the greatest common divisor using the Euclidean algorithm
    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Method to reduce the fraction to its lowest terms
    public Scalar reduce() {
        int gcd = gcd(numerator, denominator);
        if (gcd == denominator)
            return new Integer(numerator / denominator);
        return new Rational(numerator / gcd, denominator / gcd);
    }

    @Override
    public Scalar add(Scalar s) {
        return s.addRational(this);
    }

    @Override
    public Scalar addRational(Rational s) {
        Rational ratio = new Rational(numerator * s.denominator + s.numerator * denominator, denominator * s.denominator);
        ratio.reduce();
        return ratio;
    }

    @Override
    public Scalar addInteger(Integer s) {
        Rational ratio = new Rational(numerator + s.getnumber() * denominator, denominator);
        ratio.reduce();
        return ratio;
    }


    @Override
    public Scalar mul(Scalar s) {
        return s.mulRational(this);
    }

    @Override
    public Scalar mulRational(Rational s) {
        Rational ratio = new Rational(numerator * s.numerator, denominator * s.denominator);
        ratio.reduce();
        return ratio;
    }

    @Override
    public Scalar mulInteger(Integer s) {
        Rational ratio = new Rational(numerator * s.getnumber(), denominator);
        ratio.reduce();
        return ratio;
    }

    @Override
    public Scalar neg() {
        return new Rational(-this.numerator, this.denominator);
    }

    @Override
    public Scalar power(int exponent) {
        return new Rational((int) Math.pow(this.numerator, exponent), (int) Math.pow(this.denominator, exponent));
    }

    @Override
    public int sign() {
        return (int) (Math.signum(this.numerator) * Math.signum(this.denominator));
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Rational) {
            Rational s = (Rational) o;
            return this.numerator == s.numerator && this.denominator == s.denominator;
        }
        return false;
    }

}