public interface Scalar {
    Scalar add(Scalar s);
    Scalar mul(Scalar s);
    Scalar power(int exponent);
    int sign();
    Scalar neg();
    Scalar addRational(Rational s);
    Scalar addInteger(Integer s);
    Scalar mulRational(Rational s);
    Scalar mulInteger(Integer s);
}
