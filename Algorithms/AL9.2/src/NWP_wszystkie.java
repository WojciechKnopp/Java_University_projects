import java.util.ArrayList;
import java.util.HashSet;

public class NWP_wszystkie {
    String x,y;
    int n,m;
    Kierunki [][]b;
    int [][]c;
    ArrayList<String> podciagi = new ArrayList<>();

    NWP_wszystkie(String x, String y){
        this.x=x;
        this.y=y;
        m = x.length();
        n = y.length();
        b = new Kierunki[m+1][n+1];
        c = new int[m+1][n+1];
        for(int i=0;i<m+1;i++)
            for(int j=0; j<n+1; j++)
                b[i][j] = new Kierunki();
        podciagi.add("");
    }

    public void policz_dlugosc(){
        for(int i=0; i<=m; i++)
            c[i][0]=0;
        for(int i=0; i<=n; i++)
            c[0][i]=0;

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(x.charAt(i-1)==y.charAt(j-1)){
                    c[i][j]=c[i-1][j-1]+1;
                    b[i][j].skos = true;
                }else{
                    if(c[i-1][j] >= c[i][j-1]){
                        c[i][j] = c[i-1][j];
                        b[i][j].gora = true;
                    }
                    if(c[i][j-1] >= c[i-1][j]){
                        c[i][j] = c[i][j - 1];
                        b[i][j].lewo = true;
                    }
                }
            }
        }
    }

    public void polacz(String x, Kierunki [][]b, int i, int j, int k){
        if(i==0 || j==0)
            return;
        if(b[i][j].skos){
            podciagi.set(k, x.charAt(i-1)+podciagi.get(k));
            polacz(x,b,i-1,j-1, k);
        }else if(b[i][j].lewo && b[i][j].gora){
            podciagi.add(podciagi.get(k));
            polacz(x, b, i, j-1, podciagi.size()-1);
            polacz(x, b, i-1, j, k);
        }else{
            if(b[i][j].lewo){
                polacz(x, b, i, j-1, k);
            }else{
                polacz(x, b, i-1, j, k);
            }
        }
    }

    public void wyswietl(){
        polacz(x, b, m, n, 0);
        HashSet<String> bezpowtorzen = new HashSet<>(podciagi);
        System.out.println(bezpowtorzen);
    }
}
