package com.example.food_delivery.Classes;

public class Delivery {

    public static String this_name;
    public static String this_summ;
    public static String this_status;
    public static String this_id;
    private String idrequest;
    private String name;
    private String telephone_number;
    private String description;
    private String summ;
    private String status;

    public Delivery(String idrequest, String name, String telephone_number, String description, String summ, String status) {
        this.idrequest = idrequest;
        this.name = name;
        this.telephone_number = telephone_number;
        this.description = description;
        this.summ = summ;
        this.status = status;
    }

    public Delivery(String name, String telephone_number, String description, String summ, String status) {
        this.name = name;
        this.telephone_number = telephone_number;
        this.description = description;
        this.summ = summ;
        this.status = status;
    }

    public String getIdrequest() {
        return idrequest;
    }

    public void setIdrequest(String idrequest) {
        this.idrequest = idrequest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone_number() {
        return telephone_number;
    }

    public void setTelephone_number(String telephone_number) {
        this.telephone_number = telephone_number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSumm() {
        return summ;
    }

    public void setSumm(String summ) {
        this.summ = summ;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
