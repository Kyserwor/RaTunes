package mvc.model;

/**
 * Created by rlukas on 04.11.2015.
 */
public class Genre {
    private int id;
    private String name;
    private int albumID;

    public Genre(){
        this.id = 0;
        this.name = null;
        this.albumID = 0;
    }

    public Genre(int id, String name, int albumID) {
        this.id = id;
        this.name = name;
        this.albumID = albumID;
    }

    //region Getter and Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAlbumID() {
        return albumID;
    }

    public void setAlbumID(int albumID) {
        this.albumID = albumID;
    }
//endregion
}
