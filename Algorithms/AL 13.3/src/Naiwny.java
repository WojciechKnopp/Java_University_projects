public class Naiwny{
    public static void wyszukaj(String P, String T){
        int m = P.length();
        int n = T.length();
        System.out.println("ALGORYTM NAIWNY\nZnalezienie wzorca na pozycjach:");
        for(int s = 0; s < n-m+1; s++){
            if(P.equals(T.substring(s, s+m)))
                System.out.print(s+1+" ");
        }
    }
}
