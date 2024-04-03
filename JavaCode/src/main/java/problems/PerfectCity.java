package problems;

public class PerfectCity {

    double solution(double[] departure, double[] destination) {
        var minUpDownPath = 0.0;
        // case where departure starts at a non-integer Y AXIS point
        if(Math.ceil(departure[1]) != Math.floor(departure[1])) {
            var upThenDown =
              Math.abs(Math.ceil(departure[1]) - departure[1]) + Math.abs(Math.ceil(departure[1]) - destination[1]);
            var downThenUp =
              Math.abs(Math.floor(departure[1]) - departure[1]) + Math.abs(Math.floor(departure[1]) - destination[1]);

            minUpDownPath = Math.min(upThenDown, downThenUp);
        }
        else {
            minUpDownPath = Math.abs(destination[1] - departure[1]);
        }


        var toTheRight =
          Math.abs(Math.ceil(departure[0]) - departure[0]) + Math.abs(Math.ceil(departure[0]) - destination[0]);
        var toTheLeft =
          Math.abs(Math.floor(departure[0]) - departure[0]) + Math.abs(Math.floor(departure[0]) - destination[0]);
        var horizontalMinDist = Math.min(toTheRight, toTheLeft);

        return minUpDownPath + horizontalMinDist;
    }
}
