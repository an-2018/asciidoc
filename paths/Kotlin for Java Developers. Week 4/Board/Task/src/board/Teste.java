package board;

import java.util.Arrays;
import java.util.LinkedList;

public class Teste {
    public static void main(String[] args) {
        Teste test = new Teste();
        test.test();
    }

    public void test(){

        int width = 2;
        LinkedList<LinkedList<Cell>> cells = new LinkedList<>();

        for(int i = 0; i < width; i++){
            LinkedList<Cell> aux = new LinkedList<>();
            for(int j = 0; j < width; j++){
                aux.add(new Cell(i,j));
            }
            cells.add(aux);
        }

        System.out.println(cells.toString());
    }
    class Cell{
        public Cell(int i,int j) {

        }
    }
}
