package pl.edu.ug.wknopp.javae.DBDemo.reactive;

public class Opinion {
    private int rating;
    private int houseId;

    public Opinion() {
    }

    public Opinion(int rating, int houseId) {
        this.rating = rating;
        this.houseId = houseId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    @Override
    public String toString() {
        return "Opinion{" +
                "rating=" + rating +
                "stars, houseId=" + houseId +
                '}';
    }
}
