package com.eagle.recyclercardview.model;

import com.eagle.recyclercardview.R;

import java.util.ArrayList;

/**
 * Created by 1 on 28.03.2016.
 */
public class Lamp {
    
    private int imageId;
    private String title;
    private String description;

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public static ArrayList<Lamp> getData(){
        
        ArrayList<Lamp> dataList = new ArrayList<>();
        int[] images = getImages();

        for (int i = 0; i < images.length; i++) {

            Lamp lamp = new Lamp();
            lamp.setImageId(images[i]);
            lamp.setTitle("Lamp " + i);

            dataList.add(lamp);
            
        }
        return dataList;
    }

    private static int[] getImages() {
        int [] images = {
          R.drawable.rainbow_happy, R.drawable.rainbow_happy, R.drawable.rainbow_happy,
                R.drawable.rainbow_happy, R.drawable.rainbow_happy, R.drawable.rainbow_happy,
                R.drawable.rainbow_happy, R.drawable.rainbow_happy, R.drawable.rainbow_happy,
                R.drawable.rainbow_happy, R.drawable.rainbow_happy, R.drawable.rainbow_happy,
                R.drawable.rainbow_happy, R.drawable.rainbow_happy, R.drawable.rainbow_happy,
                R.drawable.rainbow_happy, R.drawable.rainbow_happy, R.drawable.rainbow_happy,
                R.drawable.rainbow_happy, R.drawable.rainbow_happy, R.drawable.rainbow_happy,
                R.drawable.rainbow_happy, R.drawable.rainbow_happy, R.drawable.rainbow_happy,
                R.drawable.rainbow_happy, R.drawable.rainbow_happy, R.drawable.rainbow_happy,
                R.drawable.rainbow_happy, R.drawable.rainbow_happy, R.drawable.rainbow_happy,
                R.drawable.rainbow_happy, R.drawable.rainbow_happy, R.drawable.rainbow_happy,
                R.drawable.rainbow_happy, R.drawable.rainbow_happy, R.drawable.rainbow_happy,
                R.drawable.rainbow_happy, R.drawable.rainbow_happy, R.drawable.rainbow_happy,
                R.drawable.rainbow_happy, R.drawable.rainbow_happy, R.drawable.rainbow_happy,
                R.drawable.rainbow_happy, R.drawable.rainbow_happy, R.drawable.rainbow_happy
        };

        return images;
    }


}
