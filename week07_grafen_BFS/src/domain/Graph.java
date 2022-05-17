package domain;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
    private final int[][] verbindingsMatrix;
    public static final int infty = Integer.MAX_VALUE;

    public Graph(int[][] matrix) {
        if (!isGeldigeVerbindingsMatrix(matrix))
            throw new IllegalArgumentException("No valid verbindingsmatrix");

        this.verbindingsMatrix = matrix.clone();
    }

    private boolean isGeldigeVerbindingsMatrix(int[][] matrix) {
        if (matrix == null || matrix.length != matrix[0].length)
            return false;

        for (int i = 0; i < matrix.length; i++)
            if (matrix[i][i] != 0)
                return false;

        for (int[] ints : matrix)
            for (int j = 0; j < matrix.length; j++)
                if (ints[j] != 0 && ints[j] != 1)
                    return false;
        return true;
    }

    private int getAantalKnopen() {
        return this.verbindingsMatrix.length;
    }

    private int[] findAncestors(int start, int destination) {// nummering van
        // start-knoop
        // (1..aantal_knopen)
        // naar
        // eindKnoop
        // (destination)
        int[] ancestors = new int[this.getAantalKnopen()];
        initArray(ancestors, infty);

        Queue<Integer> queue = new LinkedList<>();
        // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Queue.html
        queue.add(start);
        ancestors[start-1] = 0;
        while(!queue.isEmpty()){
            int current = queue.remove();
            for(int i = 0; i<getAantalKnopen(); ++i){
                if(verbindingsMatrix[current-1][i]==1 && ancestors[i]==infty){
                    queue.add(i+1);
                    ancestors[i]=current;
                }
            }
        }


        // oefening 7.3


        return ancestors;
    }

    public List<Integer> findPath(int start, int destination) {
        if (start <= 0 || start > this.getAantalKnopen() || destination <= 0 || destination > this.getAantalKnopen())
            throw new IllegalArgumentException();

        int[] ancestors = this.findAncestors(start, destination);
        List<Integer> path = new LinkedList<>();

        // oefening 7.4
        int current = ancestors[destination-1];
        while (current!=0 && current!=infty){
            path.add(0,destination);
            destination=current;
            current=ancestors[destination-1];
        }
        if(current==0){
            path.add(0, destination);
        }
        return path;

    }

    private void initArray(int[] array, int value) {
        for (int i = 0; i < array.length; i++)
            array[i] = value;
    }


    // methode om tussenliggend resultaat te kunnen schrijven naar het scherm
    public String geefAncestors(int start, int destination) {
        String res = "Ancestors van " + start + " naar " + destination + ":\n";
        int[] ancestors = this.findAncestors(start, destination);
        for (int a = 0; a < ancestors.length; a++)
            res += ancestors[a] != infty ? ancestors[a] : "infty" + " ";

        return res;
    }


}
