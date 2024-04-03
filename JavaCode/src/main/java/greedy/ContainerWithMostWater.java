package greedy;

public class ContainerWithMostWater {
    public int solution(int[] height) {
        int r = height.length - 1;
        int areaMax = 0;
        for (int l = 0; l < r;) {
            int area = calculateArea(l, r, Math.min(height[l], height[r]));
            areaMax = Math.max(areaMax, area);
            if(height[l]<height[r]) l++;
            else r--;
        }
        return areaMax;
    }

    private int calculateArea(int l, int r, int height) {
        int base = r - l;
        return base * height;
    }
}
