package com.example.resf;

public class item {
    private int item_img_id;
    private String item_name;

    public item(int item_img_id, String item_name){
        this.item_img_id = item_img_id;
        this.item_name = item_name;
    }

    public int getItem_img_id(){
        return item_img_id;
    }

    public String getItem_name(){
        return item_name;
    }
}
