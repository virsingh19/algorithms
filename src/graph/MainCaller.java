package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MainCaller {
	public static void main(String[] args) {
		System.out.println("Program will read inputs from keyboad ...");
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for(int a0 = 0; a0 < q; a0++){
			int n = in.nextInt();
			int m = in.nextInt();
			int[][] edges = new int[m][2];
			for(int edges_i = 0; edges_i < m; edges_i++){
				for(int edges_j = 0; edges_j < 2; edges_j++){
					edges[edges_i][edges_j] = in.nextInt();
				}
			}
			int s = in.nextInt();
			int[] result = bfs(n, m, edges, s);
			for (int i = 0; i < result.length; i++) {
				System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
			}
			System.out.println("");


		}
		in.close();
	}

	static int[] bfs(int n, int m, int[][] edges, int s) {
		// Complete this function
		Map<Vertex, Set<Vertex>> graphMap = buildGraph(m, edges);
		Map<Integer, Vertex> weightTable = buildWeightTable(n);

		// start node
		weightTable.get(s).setWeight(0);

		updateDistances(weightTable, graphMap);

		// Print the distances now
		//weightTable.forEach((key,val) -> System.out.println(val.getId() +","+ val.getWeight() +","+ val.getParent()));

		int d[] = new int[n-1];  // leave the starting node

		int count = 0;
        int weight;
		for (int i = 1; i <= n; i++) {
			if (i == s) {
				continue;
			}
            
            weight = weightTable.get(i).getWeight();
            if (weight == Integer.MAX_VALUE) {
                weight = -1;
            }
            d[count++] = weight;
		}

		return d;
	}

	// Function to add an edge into the graph
	public static Map<Vertex, Set<Vertex>> addEdge(Vertex vertex1, Vertex vertex2, Map<Vertex, Set<Vertex>> graphMap) {
		// If graph is null then allocate it
		if (graphMap == null) {
			graphMap = new HashMap<>();
		}

		// We are not considering self loops
		if ((vertex1 == vertex2) || vertex1.getId() == vertex2.getId()) {
			return graphMap;
		}

		// Add this vertex1 if not added already
		Set<Vertex> vertexSet = graphMap.get(vertex1);
		if (vertexSet == null) {
			vertexSet = new HashSet<Vertex>();
			graphMap.put(vertex1,  vertexSet);
		}

		// Check if vertex2 is in the set or not
		if (vertexSet.contains(vertex2) == false) {    
			vertexSet.add(vertex2);    
		}

		return graphMap;
	}


	static Map<Vertex, Set<Vertex>> buildGraph(int m, int[][] edges) {
		Map<Vertex, Set<Vertex>> graphMap = new HashMap<>();

		//int[][] edges = new int[m][2];
		for(int pairs = 0; pairs < m; pairs++) {
			addEdge(new Vertex(edges[pairs][0]), new Vertex(edges[pairs][1], 6), graphMap);
            addEdge(new Vertex(edges[pairs][1]), new Vertex(edges[pairs][0], 6), graphMap);
		}

		return graphMap;
	}

	private static void updateDistances(Map<Integer, Vertex> weightTable, Map<Vertex, Set<Vertex>> graphMap) {
		// update distances for all the nodes
		Vertex v;
		int newWeight;
		Vertex weightNode;
		while ((v = getNextVertex(weightTable)) != null) {
			Set<Vertex> nodes = graphMap.get(v);
			if (nodes == null) {
				continue; // this does not have any child nodes
			}

			// node = child nodes of main weightTable node (v)
			for (Vertex node : nodes) {
				weightNode = weightTable.get(node.getId());
				if (weightNode.getWeight() == Integer.MAX_VALUE) {
					newWeight = v.getWeight() + node.getWeight();
					weightNode.setWeight(newWeight);
					weightNode.setParent(v.getId());
				} else {
					newWeight = v.getWeight() + node.getWeight();
					if (newWeight < weightNode.getWeight()) {
						weightNode.setWeight(newWeight);
						weightNode.setParent(v.getId());
					}
				}
			}
		}
	}

	private static Map<Integer, Vertex> buildWeightTable(int n) {
		// Build a weight table with maximum weight (infinity)
		Map<Integer, Vertex> weightTable = new HashMap<>();

		for (int i = 1; i <= n; i++) {
			weightTable.put(i, new Vertex(i, Integer.MAX_VALUE));
		}

		return weightTable;
	}

	private static Vertex getNextVertex(Map<Integer, Vertex> weightTable) {
		int minValue = Integer.MAX_VALUE;
		Vertex selected = null;

		//loop a Map
		for (Map.Entry<Integer, Vertex> entry : weightTable.entrySet()) {
			//System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
			if (entry.getValue().isVisited() == false) {
				if (entry.getValue().getWeight() < minValue) {
					minValue = entry.getValue().getWeight();
					selected = entry.getValue();
				}
			}
		}

		if (selected != null) {
			selected.setVisited(true);
		}
		return selected;
	}
}
