import java.util.ArrayList;
import java.util.List;

public class Recursie {


    // Oefening 1: n-de Fibonacci-getal

    public static int fibonacci(int getal) {
        if(getal<0) throw new IllegalArgumentException();
        if(getal==1) return 1;
        if(getal==2) return 1;
        return fibonacci(getal-1)+fibonacci(getal-2);
    }

    // Oefening 2 : som van cijfers

    public static int somVanCijfers(int getal) {
        if(getal/10 == 0) return Math.abs(getal);
        return Math.abs(getal%10) + somVanCijfers(getal/10);
    }

    // Oefening 3: keer een string om
    public static String keerOm(String s) {
        if(s==null) throw new IllegalArgumentException();
        if(s.isEmpty()) return s;
        if(s.length()==1) return s;
        return s.substring(s.length()-1) + keerOm(s.substring(0,s.length()-1));
    }

    //oefening 4: countX

    public static int countX(String s) {
        if(s==null) throw new IllegalArgumentException();
        if(s.isEmpty()) return 0;
        String first = s.substring(s.length()-1);
        String rest = s.substring(0,s.length()-1);
        if(first.equals("x")) return 1 + countX(rest);
        return countX(rest);
    }

    //oefening 5 : countHi
    public static int countHi(String s) {
        if(s==null) throw new IllegalArgumentException();
        if(s.length() < 2) return 0;
        String first = s.substring(s.length()-2);
        String rest = s.substring(0,s.length()-1);
        if(first.equals("hi")) return 1 + countHi(rest);
        return countHi(rest);
    }

    // oefening 6
    public static String changeXY(String s) {
        if(s==null) throw new IllegalArgumentException();
        if(s.isEmpty()) return s;
        String first = s.substring(0,1);
        if(first.equals("x")) return "y"+changeXY(s.substring(1));
        return first+changeXY(s.substring(1));
    }

    // oefening 7

    public static String changePi(String s) {
        if(s==null) throw new IllegalArgumentException();
        if(s.isEmpty()) return s;
        String first = s.substring(0,1);
        if(first.equals("p") && s.length()>1) {
            String next = s.substring(0, 2);
            if(next.equals("pi")) return "3.14"+changePi(s.substring(2));
        }
        return first+changePi(s.substring(1));
    }

    // oefening 8:
    public static int tweelog(int getal) {
        if(getal<=0) throw new IllegalArgumentException();
        if(getal==1) return 0;
        return 1+tweelog(getal/2);
    }

    // oefening 9;
    public static double findMaximum(List<Double> lijst) {
        if(lijst==null) throw new IllegalArgumentException();
        if(lijst.isEmpty()) throw new IllegalArgumentException();
        if(lijst.size()==1){
            return lijst.get(0);
        }
        Double element = lijst.remove(0);
        return Math.max(element, findMaximum(lijst));
    }

    // oefening 10;
    public static ArrayList<String> findSubstrings(String string) {
        if(string == null) throw new IllegalArgumentException();
        ArrayList<String> list = new ArrayList<String>();
        if(string.length()==0){
            list.add("");
            return list;
        }
        if(string.length()==1){
            list.add(string);
            return list;
        }
        list.add(null);
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // oefening 11;
    public static int aantalKaarten(int n){
        if(n<=0) throw new IllegalArgumentException();
        if(n==1) return 2;
        return (2*n+n-1)+aantalKaarten(n-1);
    }
}