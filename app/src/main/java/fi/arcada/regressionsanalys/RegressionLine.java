package fi.arcada.regressionsanalys;

import android.os.health.SystemHealthManager;

public class RegressionLine {

    // deklarera k, m, x  och correlationCoefficient som double
    double k, m, x;


    // Skapa en konstruktor som tar emot data-arrays för x och y
    // Uträkningen för k och m kan ske i konstruktorn m.h.a.
    // formeln för minsta kvadratmetoden
    public RegressionLine(double[] xData, double[] yData, double inputY) {

        double sumXY = 0.0;
        double sumX = 0.0;
        double sumY = 0.0;
        double sumXpow = 0.0;

        for (int i = 0; i < xData.length; i++) {
            sumXY += xData[i] * yData[i];
            sumX += xData[i];
            sumY += yData[i];
            sumXpow += Math.pow(xData[i], 2);
        }

        // Medelvärdena
        double meanX = sumX / xData.length;
        double meanY = sumY / yData.length;
        System.out.println(meanX + "\n" + meanY);

        double sumPowX = Math.pow(sumX,2);

        System.out.println(sumXY);
        System.out.println(sumX);
        System.out.println(sumY);
        System.out.println(sumXpow);
        System.out.println(sumPowX);

        k = (xData.length * sumXY - (sumX * sumY)) / (xData.length * sumXpow - sumPowX);
        System.out.println(k);

        m = meanY - k * meanX;
        System.out.println(m);

        double outputX = (inputY - m) / k;
        System.out.println(outputX);
    }


    // Del 3: uträkningen för correlationCoefficient kan också ske i konstruktorn
    // (det är förstås också ok att ha en skild metod för uträknigarna om man vill
    // hålla konstruktorn simpel.)


    // skapa en metod getX som tar emot ett y-värde, räknar ut x
    // m.h.a. räta linjens ekvation y=kx+m, och returnerar x
    public double getX(double y) {
        return 0.0;
    }

    // Del 3:
    // - skapa en getter-metod för correlationCoefficient
    // - skapa en String-metod getCorrelationGrade() för uträkning av korrelationsgrad

}