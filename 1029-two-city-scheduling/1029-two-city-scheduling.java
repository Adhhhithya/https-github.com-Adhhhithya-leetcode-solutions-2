class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length;
        Arrays.sort(costs,(a,b)->
        (a[0]-a[1]) - (b[0]-b[1])
        );
        int total_cost =0;

        for(int i=0;i<n/2;i++){
            total_cost += costs[i][0];
        }
        for(int i=n/2;i<n;i++){
            total_cost += costs[i][1];
        }
        return total_cost;
    }
}