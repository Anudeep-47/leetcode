class Solution {
public:
    void exploreIsland(vector<vector<char>> &grid, int i, int j){
        
        if(i<0 || j<0 || i==grid.size() || j== grid[0].size() || grid[i][j]=='0')return;
        
        grid[i][j] = '0';
        exploreIsland(grid, i, j+1);
        exploreIsland(grid, i+1, j);
        exploreIsland(grid, i-1, j);
        exploreIsland(grid, i, j-1);
        
        return;
    }
    
    int numIslands(vector<vector<char>>& grid) {
        int count = 0;
        for(int i=0; i<grid.size(); i++){
            for(int j=0; j<grid[0].size(); j++){
                if(grid[i][j]=='1'){
                    count++;
                    exploreIsland(grid, i, j);
                }
            }
        }
        return count;
    }
};