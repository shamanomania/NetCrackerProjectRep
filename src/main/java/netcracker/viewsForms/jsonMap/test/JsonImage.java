package netcracker.viewsForms.jsonMap.test;

/**
 * Created by sivko on 22.05.2017.
 */
public class JsonImage {

    private byte[] image;
    JsonImage(byte[] image){
        this.image=image;
    }

    public void setImage(byte[] image){
        this.image=image;
    }

    public byte[] getImage(){
        return image;
    }

    @Override
    public String toString() {
        return "JsonImage{" +
                "image='" + image.toString() + '\'' +
                '}';
    }
}
