import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Clock;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nCells = Integer.parseInt(br.readLine());
        int nExits = Integer.parseInt(br.readLine());
        int countdown = Integer.parseInt(br.readLine());
        int nConnections = Integer.parseInt(br.readLine());

        List<Integer>[] nodesSuc = new List[nCells];
        for(int i = 0; i < nCells; i++)
            nodesSuc[i] = new LinkedList<Integer>();

        Edge[] edges = new Edge[nConnections];

        for (int i = 0; i < nConnections; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt((input[1]));
            int cost = Integer.parseInt((input[2]));
            nodesSuc[start-1].add(end);
            Edge edge = new Edge(start, end, cost);
            edges[i] = edge;
        }

        MiceAndMaze m = new MiceAndMaze();








        //run Djikstra algorithm with graph inverted

    }
}
