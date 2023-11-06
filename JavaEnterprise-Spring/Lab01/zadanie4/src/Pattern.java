public class Pattern {
    public static String draw(int n){
        StringBuilder pattertBuilder = new StringBuilder();
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++)
                pattertBuilder.append('x');
            pattertBuilder.append('\n');
        }
        for(int i=n; i>0; i--){
            for(int j=1; j<=i; j++)
                pattertBuilder.append('x');
            pattertBuilder.append('\n');
        }

        for(int i=n; i>0; i--){
            for(int j=i; j<n; j++)
                pattertBuilder.append(' ');
            for(int j=1; j<=i; j++)
                pattertBuilder.append('x');
            pattertBuilder.append('\n');
        }
        for(int i=1; i<=n; i++){
            for(int j=i; j<n; j++)
                pattertBuilder.append(' ');
            for(int j=1; j<=i; j++)
                pattertBuilder.append('x');
            pattertBuilder.append('\n');
        }
        return pattertBuilder.toString();
    }
}
