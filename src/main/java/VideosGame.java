public class VideosGame {

    String name;
    String releaseDate;
    String category;
    String rating;
    int id;
    int reviewScore;

    public VideosGame(){
    }

    public VideosGame(String name, int reviewScore, String releaseDate, String category, String rating, int id) {
        this.name = name;
        this.reviewScore = reviewScore;
        this.rating = rating;
        this.releaseDate = releaseDate;
        this.id = id;
        this.category = category;
    }

    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return "Video game" + this.name + " has an id of" + this.id + "and a review score of " + this.reviewScore;
    }
}
