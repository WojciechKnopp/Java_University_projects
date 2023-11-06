public class Main {
    public static void main(String[] args) {
        int age = 1000000000;
        System.out.format("Wiek na Merkurym %.2f%n" ,Planets.MERKURY.ageOnPlanet(age));
        System.out.format("Wiek na Wenus %.2f%n" ,Planets.WENUS.ageOnPlanet(age));
        System.out.format("Wiek na Ziemii %.2f%n" ,Planets.ZIEMIA.ageOnPlanet(age));
        System.out.format("Wiek na Marsie %.2f%n" ,Planets.MARS.ageOnPlanet(age));
        System.out.format("Wiek na Jowiszu %.2f%n" ,Planets.JOWISZ.ageOnPlanet(age));
        System.out.format("Wiek na Saturnie %.2f%n" ,Planets.SATURN.ageOnPlanet(age));
        System.out.format("Wiek na Uranie %.2f%n" ,Planets.URAN.ageOnPlanet(age));
        System.out.format("Wiek na Neptunie %.2f%n" ,Planets.NEPTUN.ageOnPlanet(age));

    }
}