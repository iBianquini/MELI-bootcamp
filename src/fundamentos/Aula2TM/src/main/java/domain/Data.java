package fundamentos.Aula2TM.src.main.java.domain;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Data {

    private int dia;
    private int mes;
    private int ano;
    private GregorianCalendar fullDate;




    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;

        this.fullDate = new GregorianCalendar(this.ano,this.mes,this.dia);
    }


    public String getFullDate(){
        return this.fullDate.toZonedDateTime().toString();
    }

    public void addDay(){
        this.fullDate.add(Calendar.DAY_OF_MONTH,1);
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Data{"  + fullDate.toZonedDateTime() +
                '}';
    }
}
