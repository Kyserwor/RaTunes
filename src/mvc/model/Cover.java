package mvc.model;

/**
 * Created by rlukas on 08.09.2015.
 */
public class Cover {
    private int id;
    private String url;

   public Cover(){
       this.id = 0;
       this.url = null;
   }

    public Cover(int id, String url) {
        this.id = id;
        this.url = url;
    }

    //region Getter and Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    //endregion
}
