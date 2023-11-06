public class NWP {
    String x,y;
    int n,m;
    char [][]b;
    int [][]c;

    NWP(String x, String y){
        this.x=x;
        this.y=y;
        m = x.length();
        n = y.length();
        b = new char[m+1][n+1];
        c = new int[m+1][n+1];
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
                    b[i][j]='\\';
                }else if(c[i-1][j] >= c[i][j-1]){
                    c[i][j] = c[i-1][j];
                    b[i][j] = '|';
                }else{
                    c[i][j] = c[i][j-1];
                    b[i][j] = '-';
                }
            }
        }
    }

    public void wyswietl(String x, char [][]b, int i, int j){
        if(i==0 || j==0)
            return;
        if(b[i][j]=='\\'){
            wyswietl(x,b,i-1,j-1);
            System.out.print(x.charAt(i-1));
        }else if(b[i][j]=='|'){
            wyswietl(x,b,i-1,j);
        } else{
            wyswietl(x,b,i,j-1);
        }
    }
}
