package co.eduardo.apprecetasperuana;

import java.io.Serializable;

public class Model implements Serializable {
    String title;
    String desc;
    String tiempo;
    String tipo;
    int ingrediente;
    int preparacion;
    int icon;
    int btnicon;

    //constructor
    public Model(String title, String desc, int icon, String tiempo, String tipo, int ingrediente, int preparacion, int btnicon) {
        this.title = title;
        this.desc = desc;
        this.icon = icon;
        this.tiempo= tiempo;
        this.tipo = tipo;
        this.ingrediente= ingrediente;
        this.preparacion=preparacion;
        this.btnicon=btnicon;
    }
    public Model(){
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(int ingrediente) {
        this.ingrediente = ingrediente;
    }

    public int getPreparacion() {
        return preparacion;
    }

    public void setPreparacion(int preparacion) {
        this.preparacion = preparacion;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getBtnicon() {
        return btnicon;
    }

    public void setBtnicon(int btnicon) {
        this.btnicon = btnicon;
    }
}

