package Lessons7;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Game game=new Game();
        game.blowEverything(3,4);
        System.out.println(game);
    }
}
class Game{
    String [][] arr= new String[5][5];
    final String EMPTY="|_|";
    final String WALL="|#|";
    final String VISIT="|+|";
    {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j]=EMPTY;

            }
        }
        arr[1][0]=WALL;
        arr[2][1]=WALL;
        arr[3][2]=WALL;
        arr[2][3]=WALL;
        arr[1][4]=WALL;
    }
    public void blowEverything(int row, int col){
        int r=row;
        int c=col;
        arr[r][c]=VISIT;
        // смотрим влево
        r=row;
        c=col-1;
        if (isLength(r,c)){
          if (isEmpty(r,c)){
                blowEverything(r,c);
            }

        }
        //cмотрим вверх
        r=row-1;
        c=col;
        if (isLength(r,c)){
            if (isEmpty(r,c)){
                blowEverything(r,c);
            }

        }
        //смотрим вправо
        r=row;
        c=col+1;
        if (isLength(r,c)){
            if (isEmpty(r,c)){
                blowEverything(r,c);
            }

        }
        // смотрим вниз
        r=row+1;
        c=col;
        if (isLength(r,c)){
            if (isEmpty(r,c)){
                blowEverything(r,c);
            }

        }




        }
    private boolean isLength(int row,int col){
        return row>=0&&row<arr.length&&col>=0&&col<arr.length;
    }
    private boolean isEmpty(int row,int col){
        return arr[row][col].equals(EMPTY);
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                sb.append(arr[i][j]);

            }
            sb.append("\n");
        }
        return sb.toString();
    }
}

