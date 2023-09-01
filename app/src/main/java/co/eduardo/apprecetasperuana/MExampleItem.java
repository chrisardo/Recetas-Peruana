package co.eduardo.apprecetasperuana;

import java.io.Serializable;

public class MExampleItem implements Serializable {
    private int mImageResource;
    private String mText1;

    public MExampleItem(int mImageResource, String mText1) {
        this.mImageResource = mImageResource;
        this.mText1 = mText1;
    }
    public MExampleItem(){

    }

    public int getmImageResource() {
        return mImageResource;
    }

    public void setmImageResource(int mImageResource) {
        this.mImageResource = mImageResource;
    }

    public String getmText1() {
        return mText1;
    }

    public void setmText1(String mText1) {
        this.mText1 = mText1;
    }
}

