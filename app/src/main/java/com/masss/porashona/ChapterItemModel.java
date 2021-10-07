package com.masss.porashona;

public class ChapterItemModel {
        private Integer name;
        private String location;
        private Integer image_id;

        ChapterItemModel(Integer name,String location,Integer image_id)
        {
            this.name=name;
            this.location=location;
            this.image_id=image_id;
        }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
