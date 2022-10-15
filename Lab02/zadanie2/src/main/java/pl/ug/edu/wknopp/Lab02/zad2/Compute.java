package pl.ug.edu.wknopp.Lab02.zad2;

import org.apache.commons.math3.stat.descriptive.SummaryStatistics;

public class Compute {
    public static double mean(SummaryStatistics stats){
        return stats.getMean();
    }
    public static double standardDeviation(SummaryStatistics stats){
        return stats.getStandardDeviation();
    }
    public static double variance(SummaryStatistics stats){
        return stats.getVariance();
    }
}
