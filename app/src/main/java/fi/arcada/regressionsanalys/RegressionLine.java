package fi.arcada.regressionsanalys;

public class RegressionLine {

    // deklarera k, m, x  och correlationCoefficient som double
    double k, m, x;
    double sumXY = 0.0;
    double sumX = 0.0;
    double sumY = 0.0;
    double sumXpow = 0.0;
    double sumPowX = 0.0;
    double meanX = 0.0;
    double meanY = 0.0;
    int dataPairs = 0;


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
        }

        sumPowX = Math.pow(sumX,2);

        // Medelvärdena
        meanX = sumX / xData.length;
        meanY = sumY / yData.length;
        System.out.println(meanX + "\n" + meanY);


        System.out.println(sumXY);
        System.out.println(sumX);
        System.out.println(sumY);
        System.out.println(sumXpow);
        System.out.println(sumPowX);
    }

    private double getK() {
        k = (dataPairs * sumXY - (sumX * sumY)) / (dataPairs * sumXpow - sumPowX);
        System.out.println(k);
        return k;
    }

    private double getM() {
        m = meanY - k * meanX;
        System.out.println(m);
        return m;
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
        System.out.println("juu" + outputX);
        return outputX;
    }

    // Del 3:
    // - skapa en getter-metod för correlationCoefficient
    // - skapa en String-metod getCorrelationGrade() för uträkning av korrelationsgrad

}