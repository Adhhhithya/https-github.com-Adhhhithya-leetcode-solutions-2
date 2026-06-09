class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(a,b)->a[1]-b[1]);
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b)->(b-a));
        int sum =0;
        for(int a[]:courses){
            sum += a[0];
            q.add(a[0]);
            if(sum>a[1]){
                sum -= q.poll();
            }
        }
        return q.size();
    }
}