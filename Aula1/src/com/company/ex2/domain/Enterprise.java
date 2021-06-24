package com.company.ex2.domain;

import java.util.Calendar;
import java.util.Date;

public class Enterprise {

    private String name;

    private Date ano;

    private double value;

    public Enterprise(String name, Date ano, double value) {
        this.name = name;
        this.ano = ano;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getAno() {
        return ano;
    }

    public void setAno(Date ano) {
        this.ano = ano;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public static void compareEnterprises(Enterprise empresaX, Enterprise empresaY){
        while(empresaX.getValue() < empresaY.getValue()){
            empresaX.setValue(empresaX.getValue() + (empresaX.getValue() * 1.48));

            empresaY.setValue(empresaY.getValue() + (empresaY.getValue() * 0.32));

            Calendar calendarX = Calendar.getInstance();
            calendarX.setTime(empresaX.getAno());
            calendarX.add(Calendar.YEAR, 1);
            empresaX.setAno(calendarX.getTime());

            Calendar calendarY = Calendar.getInstance();
            calendarY.setTime(empresaY.getAno());
            calendarY.add(Calendar.YEAR, 1);
            empresaY.setAno(calendarY.getTime());

            System.out.println(empresaX);
            System.out.println(empresaY);
        }    }

    @Override
    public String toString() {
        return "Enterprise{" +
                "name='" + name + '\'' +
                ", ano=" + ano +
                ", value=" + value +
                '}';
    }
}
