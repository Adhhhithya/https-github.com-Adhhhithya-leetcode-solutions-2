class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(a,b)->{
            if(a[0]==b[0])
                return a[1] - b[1];
            return b[0] - a[0];
        });

        List<int[]> res = new ArrayList<>();

        for(int a[]:people){
            res.add(a[1],a);
        }

        return res.toArray(new int[res.size()][]);
    }
}