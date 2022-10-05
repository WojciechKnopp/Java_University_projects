public class Wiek_wg_Planety {

    public static double policz(Double wiek, String Planeta){
        double wynik, rok;
        switch(Planeta){
            case "Merkury": rok = 31557600 * 0.2408467; break;
            case "Wenus": rok = 31557600 * 0.61519726; break;
            case "Mars": rok = 31557600 * 1.8808158; break;
            case "Jowisz": rok = 31557600 * 11.862615; break;
            case "Saturn": rok = 31557600 * 29.447498; break;
            case "Uran": rok = 31557600 * 84.016846; break;
            case "Neptun": rok = 31557600 * 164.79132; break;
            default: System.out.print("Nie ma planety "+Planeta+" "); return 0;
        }
        wynik = wiek/rok;
        return wynik;
    }

}
