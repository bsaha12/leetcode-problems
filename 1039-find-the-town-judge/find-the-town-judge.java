class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] persons = new int[n+1] ;
        // Arrays.fill(persons , 0) ;
        for(int[] relation : trust){
            int p1 = relation[0] ;
            persons[p1] = -1 ;
        }

        int judge = -1 ;
        int count = 0 ;
        for(int i = 1 ; i < n+1 ; i++){
            int person = persons[i] ;
            if(person == 0){
                count++ ;
                judge = i ;
            }
        }

        if(count != 1){
            return -1 ;
        }

        // persons = new int[n+1] ;
        int personTrustsJudge = 0 ;
        for(int[] relation : trust){
            // int p1 = relation[0] ;
            int p2 = relation[1] ;
            if(p2 == judge){
                personTrustsJudge++ ;
            }
        }

        if(personTrustsJudge == n-1){
            return judge ;
        }
        return -1 ;
    }
}