class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2];
        int noOfCarFleets = 0;
        double prevMax = 0;

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> b[0] - a[0]);

        for (int i = 0; i < n; i++) {
            double time = (double)(target - cars[i][0]) / cars[i][1];

            if (prevMax < time) {
                prevMax = time;
                noOfCarFleets++;
            }
        }

        return noOfCarFleets;
    }
}
