public class Wzor {
    public static void narysuj(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++)
                System.out.print("x");
            System.out.println();
        }
        for(int i=n; i>0; i--){
            for(int j=1; j<=i; j++)
                System.out.print("x");
            System.out.println();
        }

        for(int i=n; i>0; i--){
            for(int j=i; j<n; j++)
                System.out.print(" ");
            for(int j=1; j<=i; j++)
                System.out.print("x");
            System.out.println();
        }
        for(int i=1; i<=n; i++){
            for(int j=i; j<n; j++)
                System.out.print(" ");
            for(int j=1; j<=i; j++)
                System.out.print("x");
            System.out.println();
        }
    }
}
