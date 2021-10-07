package com.masss.porashona;

public class GridItemModel {
    private Integer name;
    private Integer image_id;
    private Integer class_id;

    GridItemModel(Integer class_id,Integer name,Integer image_id)
    {
        this.class_id=class_id;
        this.name=name;
        this.image_id=image_id;
    }

    public Integer getClass_id() {
        return class_id;
    }

    public void setClass_id(Integer class_id) {
        this.class_id = class_id;
    }

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    public Integer getImage_id() {
        return image_id;
    }

    public void setImage_id(Integer image_id) {
        this.image_id = image_id;
    }
}
