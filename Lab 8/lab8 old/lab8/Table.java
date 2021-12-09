package com.company;

import java.util.Vector;

public class Table {
     Object[][] matriceCuTxt;

    public Table(Object[][] matriceCuTxt) {
        this.matriceCuTxt = matriceCuTxt;
    }
    public void print(AsciiPrinter p)
    {
        String raspuns="";
        for (int i = 0; i <matriceCuTxt.length ; i++) {
            for (int j = 0; j < matriceCuTxt[i].length ; j++) {
                raspuns+=matriceCuTxt[i][j];
                for (int k = 0; k < p.idkWhatThisDoes[j]- matriceCuTxt[i][j].toString().length(); k++) {
                    raspuns+=" ";
                }
                raspuns+="|";
            }
            raspuns+="\n";
        }
        System.out.println(raspuns);
    }
    public void print(CsvPrinter p)
    {
        String raspuns = "";
        for (int i = 0; i < matriceCuTxt.length; i++) {
            for (int j = 0; j < matriceCuTxt[i].length; j++) {
                raspuns+=matriceCuTxt[i][j];
                if(j!=matriceCuTxt[i].length-1)
                    raspuns+= p.delim;
            }
            raspuns+="\n";
        }
        System.out.println(raspuns);
    }

    class AsciiPrinter
    {
        int[] idkWhatThisDoes;

        public AsciiPrinter(int[] idkWhatThisDoes) {
            this.idkWhatThisDoes = idkWhatThisDoes;
        }


    }
    class CsvPrinter
    {
        String delim=",";
    }
}
