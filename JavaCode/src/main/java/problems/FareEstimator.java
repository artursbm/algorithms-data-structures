package problems;

public class FareEstimator {

    //fare calculus = (Cost per minute) * (ride time) + (Cost per mile) * (ride distance)
    public double[] solution(int ride_time, int ride_distance, double[] cost_per_minute, double[] cost_per_mile) {

        for (int i = 0; i < cost_per_minute.length; i++) {
            cost_per_minute[i] *= ride_time;
            cost_per_mile[i] *= ride_distance;
            cost_per_minute[i] += cost_per_mile[i];
        }

        return cost_per_minute;

    }
}
