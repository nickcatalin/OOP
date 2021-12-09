package p2;

public class Graph extends MyList {
    private boolean[] visited;

    public Graph(int numOfVertices) {
        visited = new boolean[numOfVertices + 1];
        for (int i = 0; i <= numOfVertices; i++)
            add(new MyList());
    }

    public void add(int x, int y) {
        MyList adjList = (MyList) get(x);
        adjList.add(y);
    }

    void dfs(int start){
        MyList adjList = (MyList) get(start);
        System.out.print(start+" ");
        visited[start] = true;
        if (adjList.size()!=0){
            for(int j = 1;j<9;j++)
                if(visited[j] == false)
                    dfs(j);
        }

    }

    public String toString() {
        String result = "";
        for (int i = 1; i < size(); i++)
            result += i + ":" + get(i) + "\n";
        return result;
    }
}