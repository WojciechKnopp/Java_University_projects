public class Main {
    public static void main(String[] args) {
        double wiek = 1000000000;
        System.out.println(ageOnPlanet(wiek, "Merkury"));
        System.out.println(ageOnPlanet(wiek, "Wenus"));
        System.out.println(ageOnPlanet(wiek, "Ziemia"));
        System.out.println(ageOnPlanet(wiek, "Mars"));
        System.out.println(ageOnPlanet(wiek, "Jowisz"));
        System.out.println(ageOnPlanet(wiek, "Saturn"));
        System.out.println(ageOnPlanet(wiek, "Uran"));
        System.out.println(ageOnPlanet(wiek, "Neptun"));
        System.out.println(ageOnPlanet(wiek, "Nieistniejaca"));
    }

    public static double ageOnPlanet(Double age, String planet){
        double result, year;
        switch(planet){
            case "Merkury": year = 31557600 * 0.2408467; break;
            case "Wenus": year = 31557600 * 0.61519726; break;
            case "Ziemia": year = 31557600; break;
            case "Mars": year = 31557600 * 1.8808158; break;
            case "Jowisz": year = 31557600 * 11.862615; break;
            case "Saturn": year = 31557600 * 29.447498; break;
            case "Uran": year = 31557600 * 84.016846; break;
            case "Neptun": year = 31557600 * 164.79132; break;
            default: System.out.print("Nie ma planety "+planet+" "); return 0;
        }
        result = age/year;
        return result;
    }
}
