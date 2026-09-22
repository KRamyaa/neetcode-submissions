class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count=0;
        for(int i=0; i< grid.length; i++){
            for(int j=0; j< grid[0].length; j++){
                if(visited[i][j] != true && grid[i][j] == '1'){ 
                    count++;
                    markAllConnectedVisited(visited, grid, i, j);
                }
            }
        } 
        return count;  
    }
    public void markAllConnectedVisited(boolean[][] visited, char[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return;
        if(visited[i][j] || grid[i][j] == '0') return;
        visited[i][j] = true;
        markAllConnectedVisited(visited, grid, i, j+1);
        markAllConnectedVisited(visited, grid, i, j-1);
        markAllConnectedVisited(visited, grid, i+1, j);
        markAllConnectedVisited(visited, grid, i-1, j);
    }
    // visit every element
    // if it is not previously visited and if its a landmass add a counter
    // to mark all interconnected landmasses as visited and treat them as one unit use DFS
    // as u reach element mark it as visited if its land
}
