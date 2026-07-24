class Solution {
    public class Pair{
        int height;
        String name;
        
        Pair(int height,String name){
            this.name = name;
            this.height = height;
        }
    }
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        String[] ans = new String[n];
        int k = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.height-b.height);
        for(int i = 0;i<n;i++){
            String name = names[i];
            int height = heights[i];
            pq.add(new Pair(height,name));
        }
        
        
        
        while(!pq.isEmpty()){ //
            Pair t = pq.poll();
            String nam = t.name;
            ans[k++] = nam;
        }
        
        int i =0;
        int j =n-1;
        //reverse ans
        while(i<j){ //
            String temp = ans[i];
            ans[i] = ans[j];
            ans[j] = temp;
            i++;
            j--;
        }
        
        return ans;
        
    }
}

