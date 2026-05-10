package graph;

public class Vertex {
	private int  id;
	private int  weight;
	private int  parent;
	private boolean visited;

	// Constructors, we must need id at least
	public Vertex(int id) {
		this.id     = id;
		this.weight = 0;
	}

	public Vertex(int id, int weight) {
		this.id     = id;
		this.weight = weight;
	}

	// Getters
	public int  getId()        { return id;       }
	public int  getWeight()    { return weight;   }
	public int  getParent()    { return parent;   }
	public boolean isVisited() { return visited;  }

	// Setters
	public void setWeight(int weight)       { this.weight = weight;   }
	public void setParent(int parent)       { this.parent = parent;   }
	public void setVisited(boolean visited) { this.visited = visited; }


	@Override
	public String toString() {
		return "Vertex [id=" + id + ", weight=" + weight + ", parent=" + parent + ", visited=" + visited + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
