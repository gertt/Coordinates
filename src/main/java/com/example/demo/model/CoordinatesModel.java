package com.example.demo.model;

public class CoordinatesModel {

    private Double latFirstPoint;
    private Double lngFirstPoint;
    private Double latSecondPoint;
    private Double lngSecondPoint;
    private String type;
    private Integer limit;

    public Double getLatFirstPoint() {
        return latFirstPoint;
    }

    public void setLatFirstPoint(Double latFirstPoint) {
        this.latFirstPoint = latFirstPoint;
    }

    public Double getLngFirstPoint() {
        return lngFirstPoint;
    }

    public void setLngFirstPoint(Double lngFirstPoint) {
        this.lngFirstPoint = lngFirstPoint;
    }

    public Double getLatSecondPoint() {
        return latSecondPoint;
    }

    public void setLatSecondPoint(Double latSecondPoint) {
        this.latSecondPoint = latSecondPoint;
    }

    public Double getLngSecondPoint() {
        return lngSecondPoint;
    }

    public void setLngSecondPoint(Double lngSecondPoint) {
        this.lngSecondPoint = lngSecondPoint;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getLimit() {
        return limit;
    }

    @Override
    public String toString() {
        return "CoordinatesModel{" +
                "latFirstPoint=" + latFirstPoint +
                ", lngFirstPoint=" + lngFirstPoint +
                ", latSecondPoint=" + latSecondPoint +
                ", lngSecondPoint=" + lngSecondPoint +
                ", type='" + type + '\'' +
                ", limit=" + limit +
                '}';
    }
}








