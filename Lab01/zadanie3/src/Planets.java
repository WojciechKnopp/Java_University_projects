public enum Planets {
    MERKURY (31557600 * 0.2408467),
    WENUS (31557600 * 0.61519726),
    ZIEMIA (31557600),
    MARS (31557600 * 1.8808158),
    JOWISZ (31557600 * 11.862615),
    SATURN (31557600 * 29.447498),
    URAN (31557600 * 84.016846),
    NEPTUN (31557600 * 164.79132);

    private final double year;
    Planets(double year){
        this.year = year;
    }

    public double ageOnPlanet(int age){
        return age/year;
    }
}
