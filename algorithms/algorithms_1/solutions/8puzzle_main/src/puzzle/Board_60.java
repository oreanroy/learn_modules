package puzzle;

import java.util.ArrayList;
import java.util.List;

public class Board_60 {

    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)

    private class pos{
        public int x;
        public int y;
        public pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private int [][] board_state;
    private int [][] ideal_state;
    private int [][] board_copy;
    private int n=0;
    private int hamming = -1;
    private int manhatan = -1;

    public Board_60(int[][] tiles){
        if(tiles == null)
            throw new IllegalArgumentException();
        n = tiles[0].length;

        ideal_state = new int[n][n];
        board_copy = new int[n][n];
        board_state = new int[n][n];
        int count=0;
        for(int i =0; i<n; i++){
            for (int j =0; j<n; j++)
            {
                count++;
                if(i==n-1 && j==n-1)
                    ideal_state[i][j]=0;
                else
                    ideal_state[i][j]=count;
                board_copy[i][j] = tiles[i][j];
                board_state[i][j] = tiles[i][j];
            }
        }
    }

    private void createBoardCopy(){
        for(int i =0; i<n; i++){
            for (int j =0; j<n; j++)
            {
                int temp = (int)board_state[i][j];
                board_copy[i][j] = temp;
            }
        }
    }

    // string representation of this board
    public String toString(){
        String rep = "";
        rep+=n+"\n";
        for (int i=0; i<n; i++){
            for (int j =0; j<n; j++){
                if(j==0)
                    rep+=" ";
                if(j == n-1)
                    rep+=board_state[i][j];
                else
                    rep+=board_state[i][j]+" ";
            }
            rep+="\n";
        }
        return rep;
    }

    // board dimension n
    public int dimension(){
        return n;
    }

    // number of tiles out of place
    public int hamming(){
        if(hamming!=-1)
            return hamming;
        int total=0;
        for(int i =0; i<n; i++){
            for (int j =0; j<n; j++)
                if(ideal_state[i][j] != board_state[i][j] && ideal_state[i][j]!=0)
                    total++;
        }
        hamming = total;
        return total;
    }

    private pos getPosition(int item){
        int x=-1;
        int y=-1;
        for(int i =0; i<n; i++){
            for (int j =0; j<n; j++)
                if(item == board_state[i][j]){ x=i; y=j; break;}
        }
        return new pos(x, y);
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan(){
        if(manhatan!=-1)
            return manhatan;
        int total =0;
        for(int i =0; i<n; i++){
            for (int j =0; j<n; j++)
            {
                if(ideal_state[i][j]!=0){
                pos temp = getPosition(ideal_state[i][j]);
                if(temp.x>i) total+=temp.x-i;
                else if (temp.x<i) total+=i-temp.x;
                if(temp.y>j) total+=temp.y-j;
                else if (temp.y<j) total+=j-temp.y;}
            }
        }
        manhatan = total;
        return total;
    }

    // is this board the goal board?
    public boolean isGoal(){
        if(hamming()==0) return true;
        return false;
    }

    // does this board equal y?
    public boolean equals(Object y){
        if(y==null)
            return false;
        return y.toString().equals(this.toString());
    }

    // all neighboring boards
    /*public Iterable<Board> neighbors(){
        List<Board> boardList = new ArrayList<Board>();
        // create adjacent boards and them to this list
        pos zeroPosition = getPosition(0);
            createBoardCopy();
            if(zeroPosition.x>0 && zeroPosition.y>0 && zeroPosition.x<n-1 && zeroPosition.y<n-1){
                exchange(board_copy, zeroPosition, new pos(zeroPosition.x - 1, zeroPosition.y));
                Board neihbour = new Board(board_copy);
                boardList.add(neihbour);
                exchange(board_copy,  new pos(zeroPosition.x - 1, zeroPosition.y), zeroPosition);

                exchange(board_copy, zeroPosition, new pos(zeroPosition.x+1, zeroPosition.y));
                 neihbour = new Board(board_copy);
                boardList.add(neihbour);
                exchange(board_copy,  new pos(zeroPosition.x+1, zeroPosition.y), zeroPosition);


                exchange(board_copy, zeroPosition, new pos(zeroPosition.x, zeroPosition.y-1));
                 neihbour = new Board(board_copy);
                boardList.add(neihbour);
                exchange(board_copy,  new pos(zeroPosition.x, zeroPosition.y-1), zeroPosition);


                exchange(board_copy, zeroPosition, new pos(zeroPosition.x, zeroPosition.y+1));
                 neihbour = new Board(board_copy);
                boardList.add(neihbour);
                exchange(board_copy, new pos(zeroPosition.x, zeroPosition.y+1), zeroPosition);

            }else if(zeroPosition.x>0 && zeroPosition.y==0 && zeroPosition.x<n-1){
                exchange(board_copy, zeroPosition, new pos(zeroPosition.x - 1, zeroPosition.y));
                Board neihbour = new Board(board_copy);
                boardList.add(neihbour);
                exchange(board_copy,  new pos(zeroPosition.x - 1, zeroPosition.y), zeroPosition);

                exchange(board_copy, zeroPosition, new pos(zeroPosition.x+1, zeroPosition.y));
                neihbour = new Board(board_copy);
                boardList.add(neihbour);
                exchange(board_copy,  new pos(zeroPosition.x+1, zeroPosition.y), zeroPosition);

                exchange(board_copy, zeroPosition, new pos(zeroPosition.x, zeroPosition.y+1));
                neihbour = new Board(board_copy);
                boardList.add(neihbour);
                exchange(board_copy, new pos(zeroPosition.x, zeroPosition.y+1), zeroPosition);



            }else if(zeroPosition.y==0 && zeroPosition.x==n-1){

                exchange(board_copy, zeroPosition, new pos(zeroPosition.x - 1, zeroPosition.y));
                Board neihbour = new Board(board_copy);
                boardList.add(neihbour);
                exchange(board_copy,  new pos(zeroPosition.x - 1, zeroPosition.y), zeroPosition);

                exchange(board_copy, zeroPosition, new pos(zeroPosition.x, zeroPosition.y+1));
                neihbour = new Board(board_copy);
                boardList.add(neihbour);
                exchange(board_copy, new pos(zeroPosition.x, zeroPosition.y+1), zeroPosition);


            }else if (zeroPosition.x==0 && zeroPosition.y>0 && zeroPosition.y<n-1){

                exchange(board_copy, zeroPosition, new pos(zeroPosition.x+1, zeroPosition.y));
                Board neihbour = new Board(board_copy);
                boardList.add(neihbour);
                exchange(board_copy,  new pos(zeroPosition.x+1, zeroPosition.y), zeroPosition);

                exchange(board_copy, zeroPosition, new pos(zeroPosition.x, zeroPosition.y+1));
                neihbour = new Board(board_copy);
                boardList.add(neihbour);
                exchange(board_copy, new pos(zeroPosition.x, zeroPosition.y+1), zeroPosition);


                exchange(board_copy, zeroPosition, new pos(zeroPosition.x, zeroPosition.y-1));
                neihbour = new Board(board_copy);
                boardList.add(neihbour);
                exchange(board_copy,  new pos(zeroPosition.x, zeroPosition.y-1), zeroPosition);

            } else if (zeroPosition.x==0  && zeroPosition.y==n-1){

                exchange(board_copy, zeroPosition, new pos(zeroPosition.x+1, zeroPosition.y));
                Board neihbour = new Board(board_copy);
                boardList.add(neihbour);
                exchange(board_copy,  new pos(zeroPosition.x+1, zeroPosition.y), zeroPosition);


                exchange(board_copy, zeroPosition, new pos(zeroPosition.x, zeroPosition.y-1));
                neihbour = new Board(board_copy);
                boardList.add(neihbour);
                exchange(board_copy,  new pos(zeroPosition.x, zeroPosition.y-1), zeroPosition);

            } else if (zeroPosition.x==0 && zeroPosition.y==0 ){
                exchange(board_copy, zeroPosition, new pos(zeroPosition.x+1, zeroPosition.y));
                Board neihbour = new Board(board_copy);
                boardList.add(neihbour);
                exchange(board_copy,  new pos(zeroPosition.x+1, zeroPosition.y), zeroPosition);

                exchange(board_copy, zeroPosition, new pos(zeroPosition.x, zeroPosition.y+1));
                neihbour = new Board(board_copy);
                boardList.add(neihbour);
                exchange(board_copy, new pos(zeroPosition.x, zeroPosition.y+1), zeroPosition);

            } else if (zeroPosition.x>0 &&  zeroPosition.y==n-1 && zeroPosition.x<n-1){
                exchange(board_copy, zeroPosition, new pos(zeroPosition.x+1, zeroPosition.y));
                Board neihbour = new Board(board_copy);
                boardList.add(neihbour);
                exchange(board_copy,  new pos(zeroPosition.x+1, zeroPosition.y), zeroPosition);

                exchange(board_copy, zeroPosition, new pos(zeroPosition.x-1, zeroPosition.y));
                neihbour = new Board(board_copy);
                boardList.add(neihbour);
                exchange(board_copy,  new pos(zeroPosition.x-1, zeroPosition.y), zeroPosition);


                exchange(board_copy, zeroPosition, new pos(zeroPosition.x, zeroPosition.y-1));
                neihbour = new Board(board_copy);
                boardList.add(neihbour);
                exchange(board_copy, new pos(zeroPosition.x, zeroPosition.y-1), zeroPosition);
            }else if (zeroPosition.x==n-1 &&  zeroPosition.y>0 &&zeroPosition.y<n-1) {

                exchange(board_copy, zeroPosition, new pos(zeroPosition.x-1, zeroPosition.y));
                Board neihbour = new Board(board_copy);
                boardList.add(neihbour);
                exchange(board_copy,  new pos(zeroPosition.x-1, zeroPosition.y), zeroPosition);

                exchange(board_copy, zeroPosition, new pos(zeroPosition.x, zeroPosition.y+1));
                neihbour = new Board(board_copy);
                boardList.add(neihbour);
                exchange(board_copy, new pos(zeroPosition.x, zeroPosition.y+1), zeroPosition);

                exchange(board_copy, zeroPosition, new pos(zeroPosition.x, zeroPosition.y-1));
                neihbour = new Board(board_copy);
                boardList.add(neihbour);
                exchange(board_copy, new pos(zeroPosition.x, zeroPosition.y-1), zeroPosition);
            }else if (zeroPosition.x==n-1  &&zeroPosition.y==n-1){
                exchange(board_copy, zeroPosition, new pos(zeroPosition.x-1, zeroPosition.y));
                Board neihbour = new Board(board_copy);
                boardList.add(neihbour);
                exchange(board_copy,  new pos(zeroPosition.x-1, zeroPosition.y), zeroPosition);

                exchange(board_copy, zeroPosition, new pos(zeroPosition.x, zeroPosition.y-1));
                neihbour = new Board(board_copy);
                boardList.add(neihbour);
                exchange(board_copy, new pos(zeroPosition.x, zeroPosition.y-1), zeroPosition);
            }

            try {
                exchange(board_copy, zeroPosition, new pos(zeroPosition.x - 1, zeroPosition.y));
                Board neihbour = new Board(board_copy);
                boardList.add(neihbour);
                exchange(board_copy,  new pos(zeroPosition.x - 1, zeroPosition.y), zeroPosition);
            } catch (Exception e){
                int a=1;
            }
            try {
                exchange(board_copy, zeroPosition, new pos(zeroPosition.x+1, zeroPosition.y));
                Board neihbour = new Board(board_copy);
                boardList.add(neihbour);
                exchange(board_copy,  new pos(zeroPosition.x+1, zeroPosition.y), zeroPosition);
            } catch (Exception e){
                int a =1;
            }
            try {
                exchange(board_copy, zeroPosition, new pos(zeroPosition.x, zeroPosition.y-1));
                Board neihbour = new Board(board_copy);
                boardList.add(neihbour);
                exchange(board_copy,  new pos(zeroPosition.x, zeroPosition.y-1), zeroPosition);
            }catch (Exception e){
                int a =1;
            }
            try {
                exchange(board_copy, zeroPosition, new pos(zeroPosition.x, zeroPosition.y+1));
                Board neihbour = new Board(board_copy);
                boardList.add(neihbour);
                exchange(board_copy, new pos(zeroPosition.x, zeroPosition.y+1), zeroPosition);
            }catch (Exception e){
                int a =1;
            }
        return boardList;

    } */



    // all neighboring boards
    public Iterable<Board_60> neighbors(){
        List<Board_60> boardList = new ArrayList<Board_60>();
        // create adjacent boards and them to this list
        pos zeroPosition = getPosition(0);
        createBoardCopy();
        if(zeroPosition.x>0) {
            exchange(board_copy, zeroPosition, new pos(zeroPosition.x - 1, zeroPosition.y));
            Board_60 neihbour = new Board_60(board_copy);
            boardList.add(neihbour);
            exchange(board_copy, new pos(zeroPosition.x - 1, zeroPosition.y), zeroPosition);
        }
        if(zeroPosition.x<n-1) {
            exchange(board_copy, zeroPosition, new pos(zeroPosition.x + 1, zeroPosition.y));
            Board_60 neihbour = new Board_60(board_copy);
            boardList.add(neihbour);
            exchange(board_copy, new pos(zeroPosition.x + 1, zeroPosition.y), zeroPosition);
        }
        if(zeroPosition.y>0) {
            exchange(board_copy, zeroPosition, new pos(zeroPosition.x, zeroPosition.y - 1));
            Board_60 neihbour = new Board_60(board_copy);
            boardList.add(neihbour);
            exchange(board_copy, new pos(zeroPosition.x, zeroPosition.y - 1), zeroPosition);
        }
        if(zeroPosition.y<n-1){
            exchange(board_copy, zeroPosition, new pos(zeroPosition.x, zeroPosition.y+1));
            Board_60 neihbour = new Board_60(board_copy);
            boardList.add(neihbour);
            exchange(board_copy, new pos(zeroPosition.x, zeroPosition.y+1), zeroPosition);

        }

        return boardList;

    }




    private  void exchange(int [][]arr, pos first, pos second){
        int temp = arr[first.x][first.y];
        arr[first.x][first.y] = arr[second.x][second.y];
        arr[second.x][second.y]=temp;
    }

    private int[][] createTwin(int[][] b, pos item1, pos item2){
        // create a twin board from the present config
        createBoardCopy();
        exchange(board_copy, item1, item2);
        return board_copy;
    }

    // a board that is obtained by exchanging any pair of tiles
    public Board_60 twin(){
        Board_60 twinBoard = null;
        if(board_state[0][0]!=0 && board_state[0][1]!=0) {
            twinBoard = new Board_60(createTwin(board_state, new pos(0, 0), new pos(0, 1)));
        }else {
             twinBoard = new Board_60(createTwin(board_state, new pos(1, 0), new pos(1, 1)));
        }

        return twinBoard;
    }

    // unit testing (not graded)
    public static void main(String[] args){

    }

}