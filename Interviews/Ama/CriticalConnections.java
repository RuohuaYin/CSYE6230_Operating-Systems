import java.util.*;

class CriticalConnections{
  public static int[][] findBridges(int n, List<int[]> edges){
    List<int[]> bridges = new ArrayList<>();
    Graph graph = new Graph(n, edges);
    boolean[] visited = new boolean[n + 1];// i represent node is visited
    int[] level = new int[n + 1];
    int[] parent = new int[n + 1];
    int[] visitOrder = new int[n + 1];
    int[] counter = new int[1];

    dfs(1, graph, visited, level, parent, visitOrder, counter, bridges);

    int[][] result = new int[bridges.size()][2];
    for(int i = 0; i < bridges.size(); i++){
      result[i] = bridges.get(i);
    }
    return result;
  }

  private static void dfs(int n, Graph graph, boolean[] visited, int[] level, int[] parent, int[] visitOrder, int[] counter, List<int[]> bridges){
    visited[n] = true;
    level[n] = ++counter[0];
    visitOrder[n] = counter[0];

    List<Integer> neighbors = graph.adj[n];
    for(int i = 0; i < neighbors.size(); i++){
      int nei = neighbors.get(i);
      if(!visited[nei]){

        parent[nei] = n;
        dfs(nei, graph, visited, level, parent, visitOrder, counter, bridges);

        level[n] = Math.min(level[n], level[nei]);
        // if level[nei] > visitOrder[n], means the level of neibor have neverbeen updated back to a smaller value
        if(level[nei] > visitOrder[n]){
          bridges.add(new int[]{Math.min(n, nei), Math.max(n, nei)});
        }

      }else if(parent[n] != nei){
        // if we come to a neibor we already visited before, we can regard them in same level (one component)
        level[n] = Math.min(level[n], level[nei]);
      }

    }


  }

  public static void main(String[] args) {
    int n1 = 5;
    int[][] edgeArr1 = {{1, 2}, {1, 3}, {3, 4}, {1, 4}, {4, 5}};
    List<int[]> edges1 = new ArrayList<>();
    for(int[] edge: edgeArr1){
      edges1.add(edge);
    }
    System.out.println("result: " + printResult(findBridges(n1, edges1)));

    int n2 = 6;
    int[][] edgeArr2 = {{1, 2}, {1, 3}, {2, 3}, {2, 4}, {2, 5}, {4, 6}, {5, 6}};
    List<int[]> edges2 = new ArrayList<>();
    for(int[] edge: edgeArr2){
      edges2.add(edge);
    }
    System.out.println("result: " + printResult(findBridges(n2, edges2)));

    int n3 = 9;
    int[][] edgeArr3 = {{1, 2}, {1, 3}, {2, 3}, {3, 4}, {3, 6}, {4, 5}, {6, 7}, {6, 9}, {7, 8}, {8, 9}};
    List<int[]> edges3 = new ArrayList<>();
    for(int[] edge: edgeArr3){
      edges3.add(edge);
    }
    System.out.println("result: " + printResult(findBridges(n3, edges3)));
  }

  public static String printResult(int[][] result){
    StringBuilder sb = new StringBuilder();
    for(int[] bridge: result){
      sb.append(" [").append(bridge[0]).append(", ").append(bridge[1]).append("], ");
    }
    return sb.toString();
  }

  static class Graph{
      int size;
      List<Integer>[] adj;
      Graph(int size, List<int[]> edges){
        this.size = size;
        this.adj = new ArrayList[size + 1];
        for(int i = 0; i < size + 1; i++){
          adj[i] = new ArrayList<>();
        }
        for(int[] edge: edges){
          addEdge(edge);
        }
      }

      public void addEdge(int[] edge){
        adj[edge[0]].add(edge[1]);
        adj[edge[1]].add(edge[0]);
      }
  }
}
