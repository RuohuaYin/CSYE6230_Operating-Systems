import java.util.*;


class CriticalConnections{
  public static int[][] findBridges(int n, int[][] edges){
    List<int[]> bridges = new ArrayList<>();
    boolean[] visited = new boolean[n];// i represent node (i + 1) is visited
    GraphNode[] nodes = new GraphNode[n];
    for(int i = 1; i <= n; i++){
      nodes[i - 1] = new GraphNode(i);
    }
    for(int[] edge: edges){

    }


    int[][] result = new int[bridges.size()][2];
    for(int i = 0; i < bridges.size(); i++){
      result[i] = bridges.get(i);
    }
    return result;
  }

  public static void main(String[] args) {
    int n1 = 5;
    int[][] edges1 = {{1, 2}, {1, 3}, {3, 4}, {1, 4}, {4, 5}};
    System.out.println(Arrays.toString(findBridges(n1, edges1)));
  }

  static class GraphNode{
    int val;
    Set<Integer> neighbor;
    GraphNode(int val){
      this.val = val;
      this.neighbor = new HashSet<>();
    }
    public void addEdge(int[] edge){
      if(edge[0] == val){
        neighbor.add(edge[1]);
      }
      if(edge[1] == val){
        neighbor.add(edge[0]);
      }
    }
  }
}
