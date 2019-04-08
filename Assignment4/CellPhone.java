/*
 * Nigel Yong Sao Young, 40089856
 * COMP249
 * Assignment 4
 * Due 21/03/19
 */

import java.util.Objects;
import java.util.Scanner;

public class CellPhone {
    private long serialNum;
    private String brand;
    private int year;
    private double price;
    Scanner keyIn = new Scanner(System.in);

    public CellPhone(long serialNum, String brand, int year, double price) {
        this.serialNum = serialNum;
        this.brand = brand;
        this.year = year;
        this.price = price;
    }

    public long getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(long serialNum) {
        this.serialNum = serialNum;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public CellPhone(CellPhone cp, long sn){
        this.brand = cp.getBrand();
        this.price = cp.getPrice();
        this.year = cp.getYear();
        this.serialNum = sn;
    }

    @Override
    protected Object clone() {
        System.out.println("Please enter a new serial number.");
        return new CellPhone(this, keyIn.nextLong());
    }

    @Override
    public String toString() {
        return "["+serialNum+": "+brand+" "+price+"$ "+year+"]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != this.getClass())
            return false;
        if (this == o)
            return true;
        CellPhone otherCellPhone = (CellPhone) o;
        return (this.serialNum == otherCellPhone.getSerialNum() && this.year == otherCellPhone.getYear() && this.price == otherCellPhone.getPrice());
    }
}
