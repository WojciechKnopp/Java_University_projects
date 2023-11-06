public class Rabin_Karp {

    public static void wyszukaj(String P, String T, int d, int q) {
        int m = P.length();
        int n = T.length();
        System.out.println("ALGORYTM RABINA-KARPA\nZnalezienie wzorca na pozycjach:");
        int h = 1;
        for (int i = 0; i < m - 1; i++)
            h = (h * d) % q;
        int p = 0;
        int t = 0;
        for (int i = 0; i < m; i++) {
            p = (d * p + P.charAt(i)) % q;
            t = (d * t + T.charAt(i)) % q;
        }
        for (int s = 0; s < n - m + 1; s++) {
            if (p == t) {
                if (P.equals(T.substring(s, s + m)))
                    System.out.print(s + 1 + " ");
            }
            if (s < n - m) {
                int t1 = (T.charAt(s) * h) % q;
                if (t < t1) t = t + q;
                t = (d * (t - t1) + T.charAt(s + m)) % q;
            }
        }
    }
}
