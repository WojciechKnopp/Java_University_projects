package pl.ug.edu.wknopp.Lab02.zad2;

import org.apache.commons.math3.stat.descriptive.SummaryStatistics;

public class Main {
    public static void main(String[] args) {
        double[] data = {10.12, 1.003, 5.0312, 7.22, 8.002033};
        SummaryStatistics stats = new SummaryStatistics();
        for(int i=0; i<data.length; i++){
            stats.addValue(data[i]);
        }


        System.out.println(Compute.mean(stats));
        System.out.println(Compute.standardDeviation(stats));
        System.out.println(Compute.variance(stats));

    }
}