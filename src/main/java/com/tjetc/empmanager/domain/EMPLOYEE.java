package com.tjetc.empmanager.domain;

public class EMPLOYEE {
    //属性
    private int Id;
    private int POST_TYPR;
    private String EMP_NAME;
    private int EMP_SEX;
    private int EMP_AGE;
    private String EMP_DEPART;
    private int EMP_YEAR;
    //构造方法

    public EMPLOYEE() {
    }

    public EMPLOYEE(int id, int POST_TYPR, String EMP_NAME, int EMP_SEX, int EMP_AGE, String EMP_DEPART, int EMP_YEAR) {
        Id = id;
        this.POST_TYPR = POST_TYPR;
        this.EMP_NAME = EMP_NAME;
        this.EMP_SEX = EMP_SEX;
        this.EMP_AGE = EMP_AGE;
        this.EMP_DEPART = EMP_DEPART;
        this.EMP_YEAR = EMP_YEAR;
    }
    //set ,get方法

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getPOST_TYPR() {
        return POST_TYPR;
    }

    public void setPOST_TYPR(int POST_TYPR) {
        this.POST_TYPR = POST_TYPR;
    }

    public String getEMP_NAME() {
        return EMP_NAME;
    }

    public void setEMP_NAME(String EMP_NAME) {
        this.EMP_NAME = EMP_NAME;
    }

    public int getEMP_SEX() {
        return EMP_SEX;
    }

    public void setEMP_SEX(int EMP_SEX) {
        this.EMP_SEX = EMP_SEX;
    }

    public int getEMP_AGE() {
        return EMP_AGE;
    }

    public void setEMP_AGE(int EMP_AGE) {
        this.EMP_AGE = EMP_AGE;
    }

    public String getEMP_DEPART() {
        return EMP_DEPART;
    }

    public void setEMP_DEPART(String EMP_DEPART) {
        this.EMP_DEPART = EMP_DEPART;
    }

    public int getEMP_YEAR() {
        return EMP_YEAR;
    }

    public void setEMP_YEAR(int EMP_YEAR) {
        this.EMP_YEAR = EMP_YEAR;
    }
    //toString 方法

    @Override
    public String toString() {
        return "EMPLOYEE{" +
                "Id=" + Id +
                ", POST_TYPR=" + POST_TYPR +
                ", EMP_NAME='" + EMP_NAME + '\'' +
                ", EMP_SEX=" + EMP_SEX +
                ", EMP_AGE=" + EMP_AGE +
                ", EMP_DEPART='" + EMP_DEPART + '\'' +
                ", EMP_YEAR=" + EMP_YEAR +
                '}';
    }
}
