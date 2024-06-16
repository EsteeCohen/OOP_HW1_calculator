
public class Integer implements Scalar {
    private final int number;

    public Integer(int number) {
        this.number = number;
    }

    public int getnumber() {
        return this.number;
    }

    public Scalar add(Scalar s) {
        return s.addInteger(this);
    }

    public Integer addInteger(Integer s) {
        return new Integer(this.number + s.number);
    }

    public Rational addRational(Rational s) {
        Rational ratio = new Rational(this.number * s.getDenominator(),s.getNumerator());
        ratio.reduce();
        return ratio;
    }

    public Scalar mul(Scalar s) {
        return s.mulInteger(this);
    }

    public Integer mulInteger(Integer s) {
        return new Integer(this.number * s.number);
    }

    public Rational mulRational(Rational s) {
        Rational ratio = new Rational(this.number * s.getNumerator(),s.getDenominator());
        ratio.reduce();
        return ratio;
    }

    public Scalar neg() {
        return new Integer(-this.number);
    }

    public Scalar power(int exponent) {
        return new Integer((int) Math.pow(this.number, exponent));
    }

    public int sign() {
        return (int) Math.signum(number);
    }

    public boolean equals(Object o) {
        if (o instanceof Integer) {
            Integer s = (Integer) o;
            return this.number == s.number;
        }
        return false;
    }
}
