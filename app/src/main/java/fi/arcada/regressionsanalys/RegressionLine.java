package fi.arcada.regressionsanalys;

import java.math.RoundingMode;

public class RegressionLine {

    // deklarera k, m, x  och correlationCoefficient som double
    double k, m, x;
    double sumXY = 0.0;
    double sumX = 0.0;
    double sumY = 0.0;
    double sumXpow = 0.0;
    double sumPowX = 0.0;
    double sumYpow = 0.0;
    double sumPowY = 0.0;
    double meanX = 0.0;
    double meanY = 0.0;
    int dataPairs = 0;
    double roundedR = 0.0;
    double roundedX = 0.0;


    // Skapa en konstruktor som tar emot data-arrays för x och y
    // Uträkningen för k och m kan ske i konstruktorn m.h.a.
    // formeln för minsta kvadratmetoden
    public RegressionLine(double[] xData, double[] yData) {

        dataPairs = xData.length;

        for (int i = 0; i < xData.length; i++) {
            sumXY += xData[i] * yData[i];
            sumX += xData[i];
            sumY += yData[i];
            sumXpow += Math.pow(xData[i], 2);
            sumYpow += Math.pow(yData[i], 2);
        }

        sumPowX = Math.pow(sumX,2);
        sumPowY = Math.pow(sumY,2);
        System.out.println("sumPowY " + sumPowY);
        System.out.println("sumYPow " + sumYpow);

        // Medelvärdena
        meanX = sumX / xData.length;
        meanY = sumY / yData.length;
        System.out.println("medeltal x: " + meanX + "\n" +"medeltal y: " + meanY);

        System.out.println("sumXY " + sumXY);
        System.out.println("sumX " + sumX);
        System.out.println("sumY " + sumY);
        System.out.println("sumXpow " + sumXpow);
        System.out.println("sumPowX " + sumPowX);
    }

    private double getK() {
        k = (dataPairs * sumXY - (sumX * sumY)) / (dataPairs * sumXpow - sumPowX);
        System.out.println("K " + k);
        return k;
    }

    private double getM() {
        m = meanY - k * meanX;
        System.out.println("M " + m);
        return m;
    }
    private double calcR() {
        double r = (dataPairs * sumXY - (sumX * sumY)) / Math.sqrt((dataPairs * sumXpow - sumPowX) * (dataPairs * sumYpow - sumPowY));
        return r;
    }

    // Del 3: uträkningen för correlationCoefficient kan också ske i konstruktorn
    // (det är förstås också ok att ha en skild metod för uträknigarna om man vill
    // hålla konstruktorn simpel.)


    // skapa en metod getX som tar emot ett y-värde, räknar ut x
    // m.h.a. räta linjens ekvation y=kx+m, och returnerar x
    public double getX(double inputY) {
        double k = getK();
        double m = getM();
        double outputX = (inputY - m) / k;
        roundedX = Math.round(outputX * 100.0) / 100.0;
        System.out.println("skostrolek " + outputX);
        return roundedX;
    }

    // Del 3:
    // - skapa en getter-metod för correlationCoefficient
    public double getR() {
        double r = calcR();
        roundedR = Math.round(r * 100.0) / 100.0;

        //System.out.println("r = " + r);
        return roundedR;
    }

    // - skapa en String-metod getCorrelationGrade() för uträkning av korrelationsgrad
    public String getCorrelationGrade() {

        String rGrade ="";
        String rString = "" + roundedR;
        if (roundedR == 1 || roundedR == -1) {
            rGrade ="Perfekt";
        }
        else if((roundedR >= 0.75 && roundedR < 1) || (roundedR <= -0.75 && roundedR > -1)) {
            rGrade ="Hög";
        }
        else if((roundedR >= 0.50 && roundedR < 0.75) ||(roundedR <= -0.50 && roundedR > -0.75) ) {
            rGrade ="Måttlig";
        }
        else if((roundedR >= 0.25 && roundedR < 0.50) ||(roundedR <= -0.25 && roundedR > -0.50) ) {
            rGrade ="Låg";
        }
        else if((roundedR >= 0 && roundedR < 0.25) ||(roundedR <= -0 && roundedR > -0.25) ) {
            rGrade ="Ingen";
        }
        return rString + " " +  "(" + rGrade + ")"  ;
    }
}