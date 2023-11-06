import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File Fwzorzec = new File("wzorzec1.txt");
        File Ftekst = new File("tekst1.txt");
        try{
            Scanner tekst_input = new Scanner(Ftekst);
            String tekst = "";
            while(tekst_input.hasNext())
                tekst += tekst_input.nextLine();

            Scanner wzorzec_input = new Scanner(Fwzorzec);
            String wzorzec = "";
            while(wzorzec_input.hasNext())
                wzorzec += wzorzec_input.nextLine();

        long start = System.currentTimeMillis();
        Naiwny.wyszukaj(wzorzec, tekst);
        long Time_naiwny = System.currentTimeMillis() - start;
        System.out.println("\nCzas wykonania: "+Time_naiwny+"ms\n");

        start = System.currentTimeMillis();
        Rabin_Karp.wyszukaj(wzorzec, tekst, 25, 27077);
        long Time_Rabin_Karp = System.currentTimeMillis() - start;
        System.out.println("\nCzas wykonania: "+Time_Rabin_Karp+"ms\n");

        start = System.currentTimeMillis();
        KMP.wyszukaj(wzorzec, tekst);
        long Time_KMP = System.currentTimeMillis() - start;
        System.out.println("\nCzas wykonania: "+Time_KMP+"ms");

        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}

            // CZASY I WYNIKI //
//////////////////////////////////////////////////////
// wzorzec2.txt && tekst2.txt (bardzo mały wzorzec) //
//////////////////////////////////////////////////////
/*
ALGORYTM NAIWNY
Znalezienie wzorca na pozycjach:
1 13 22
Czas wykonania: 7ms

ALGORYTM RABINA-KARPA
Znalezienie wzorca na pozycjach:
1 13 22
Czas wykonania: 0ms

ALGORYTM KNUTHA-MORRISA-PRATTA
Znalezienie wzorca na pozycjach:
1 13 22
Czas wykonania: 1ms
*/

/////////////////////////////////////////////////
// wzorzec1.txt && tekst1.txt (średni wzorzec) //
/////////////////////////////////////////////////
/*
ALGORYTM NAIWNY
Znalezienie wzorca na pozycjach:
1611 4811 8011 9611 10413 17209 18411 19213 20013 21615 22415 24815
25615 29613 30413 33213 34813 36813 39611 40811 42813 45213 47615
50013 50813 54011 55213 57215 58015 61213 62415 63615 64817 66019
69221 72821 74023 75223 78025 81623 82425 87621 88423 90825 95225
96027 96827 98027 102027 102827 104827 106027 107627 109227 110427
115229 117627 118829 124025 126425 132825 133627 134427 137227 140429
141629 143231 144033 145635 148033 149235 150035 152035 154437 158037
163631 165231 167229 168029 169629 171629 173629 178027 179229 180431
182833 184433 186435 187637 189235 190435 193637 194437 195637 199235
Czas wykonania: 21ms

ALGORYTM RABINA-KARPA
Znalezienie wzorca na pozycjach:
1611 4811 8011 9611 10413 17209 18411 19213 20013 21615 22415 24815
25615 29613 30413 33213 34813 36813 39611 40811 42813 45213 47615
50013 50813 54011 55213 57215 58015 61213 62415 63615 64817 66019
69221 72821 74023 75223 78025 81623 82425 87621 88423 90825 95225
96027 96827 98027 102027 102827 104827 106027 107627 109227 110427
115229 117627 118829 124025 126425 132825 133627 134427 137227 140429
141629 143231 144033 145635 148033 149235 150035 152035 154437 158037
163631 165231 167229 168029 169629 171629 173629 178027 179229 180431
182833 184433 186435 187637 189235 190435 193637 194437 195637 199235
Czas wykonania: 10ms

ALGORYTM KNUTHA-MORRISA-PRATTA
Znalezienie wzorca na pozycjach:
1611 4811 8011 9611 10413 17209 18411 19213 20013 21615 22415 24815
25615 29613 30413 33213 34813 36813 39611 40811 42813 45213 47615
50013 50813 54011 55213 57215 58015 61213 62415 63615 64817 66019
69221 72821 74023 75223 78025 81623 82425 87621 88423 90825 95225
96027 96827 98027 102027 102827 104827 106027 107627 109227 110427
115229 117627 118829 124025 126425 132825 133627 134427 137227 140429
141629 143231 144033 145635 148033 149235 150035 152035 154437 158037
163631 165231 167229 168029 169629 171629 173629 178027 179229 180431
182833 184433 186435 187637 189235 190435 193637 194437 195637 199235
Czas wykonania: 13ms
*/

/////////////////////////////////////////////
// wzorzec.txt && tekst.txt (duży wzorzec) //
/////////////////////////////////////////////
/*
ALGORYTM NAIWNY
Znalezienie wzorca na pozycjach:
261 19881 72554 84317 119263 138100 183522 202213
Czas wykonania: 320ms

ALGORYTM RABINA-KARPA
Znalezienie wzorca na pozycjach:
261 19881 72554 84317 119263 138100 183522 202213
Czas wykonania: 15ms

ALGORYTM KNUTHA-MORRISA-PRATTA
Znalezienie wzorca na pozycjach:
261 19881 72554 84317 119263 138100 183522 202213
Czas wykonania: 24ms
*/
