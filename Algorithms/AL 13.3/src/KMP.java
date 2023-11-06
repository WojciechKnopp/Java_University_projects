public class KMP {
    static int[] Prefix_Function(String P) {
        int m = P.length();
        int[] pi = new int[m];
        pi[0] = 0;
        int k = 0;
        for (int q = 1; q < m; q++) {
            while (k > 0 && (P.charAt(k) != P.charAt(q)))
                k = pi[k];
            if (P.charAt(k) == P.charAt(q))
                k++;
            pi[q] = k;
        }
        return pi;
    }

    public static void wyszukaj(String P, String T) {
        System.out.println("ALGORYTM KNUTHA-MORRISA-PRATTA\nZnalezienie wzorca na pozycjach:");
        int m = P.length();
        int n = T.length();
        int[] pi = Prefix_Function(P);
        int q = 0;
        for (int i = 0; i < n; i++) {
            while (q > 0 && (P.charAt(q) != T.charAt(i)))
                q = pi[q];
            if (P.charAt(q) == T.charAt(i))
                q++;
            if (q == m) {
                System.out.print(i - m + 2+" ");
                q = pi[q-1];
            }
        }
    }
}
