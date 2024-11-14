
package org.example.Pruebas;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Autores {

    @SerializedName("autor")
    private List<String> mAutor;

    public List<String> getAutor() {
        return mAutor;
    }

    public void setAutor(List<String> autor) {
        mAutor = autor;
    }

}
