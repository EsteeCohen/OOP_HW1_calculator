
import java.util.HashMap;
import java.util.Map;


public class Polynomial {
    private Map<java.lang.Integer, Monomial> monomials;

    // -- constructor ---
    public Polynomial(){
        this.monomials = new HashMap<java.lang.Integer, Monomial>();
    }

    // --- copy constructor ---
    public Polynomial(Polynomial p){
        this.monomials = p.getMap(); // !!!!!!!!!!!!!

    }

    public Map getMap(){ // !!!!!!!!!!!
        return this.monomials;
    }

    public static Polynomial build(String input){
        Polynomial polynomial = new Polynomial();
        String[] onlyMono = input.split(" ");
        for(int expo = 0; expo<onlyMono.length; expo++){
            if (!onlyMono[expo].equals("0"))
                polynomial.monomials.put(expo, new Monomial(expo, stringToScalar(onlyMono[expo])));
        }
        return polynomial;
    }

    // --- functions ---
    public Polynomial add(Polynomial p){
        Polynomial polynomial = new Polynomial(this);
        for (Map.Entry<java.lang.Integer, Monomial> entry : p.monomials.entrySet()) {
            Monomial Mono = entry.getValue();

            // If this already contains the exponent, add the coefficients
            if (polynomial.monomials.containsKey(Mono.getExponent())) {
                polynomial.monomials.get(Mono.getExponent()).add(Mono);
            } else {
                // Otherwise, just put the new entry
                polynomial.monomials.put(Mono.getExponent(), Mono);
            }
        }
        return polynomial;
    }

    //public Polynomial mul(Polynomial p){



    //public Scalar evaluate(Scalar s){



    //public Polynomial derivative(){


    //@Override
    //public boolean equals(Object o){

    //}

    //@Override
    //public String toString(){

    //}

    // --- Helper functions ---

    private static Scalar stringToScalar (String toConvert){
        String[] onlyScalar = toConvert.split("/");
        if(onlyScalar.length == 1){
            return new Integer(java.lang.Integer.parseInt(onlyScalar[0])); // !!!!!!!
        }else{
            return new Rational(java.lang.Integer.parseInt(onlyScalar[0]),java.lang.Integer.parseInt(onlyScalar[1]));
        }
    }

}
