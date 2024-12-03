class Solution {
    public int minSwapsCouples(int[] rows) {
        int N = rows.length/2;
        int groups[] = new int[2*N];
        for(int g=0;g<N;g++){
            groups[2*g] = g;
            groups[2*g+1] = g;
        }
        int swaps = 0;

        for(int i=0;i<rows.length;i+=2){
            int fid = rows[i];
            int secid = rows[i+1];
            if(fid != (secid^1)){
                if(groups[fid] != groups[secid]){
                    swaps++;
                    union(groups, fid, secid);

                }


            }


        }
        return swaps;


        
    }

    private void union(int[] groups, int fid, int secid){
        int fidgroup = groups[fid];
        for(int i=0;i<groups.length;i++){
            if(groups[i] == fidgroup){
                groups[i] = groups[secid];
            }

        }

    }
}