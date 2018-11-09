package ba.unsa.etf.rpr;

import java.util.Scanner;

public class Program {

    private static void pozoviMove(Board ploca, Class type, ChessPiece.Color color, String position, Integer i, Integer j) {
        try {
            ploca.move(type.getClass(), ChessPiece.Color.WHITE, position);
            if(ploca.isCheck(ChessPiece.Color.BLACK))
                System.out.println("CHECK!!!");
        }
        catch(IllegalArgumentException izuzetak) {
            i--;
            j--;
        }
    }

     public static void main(String[] args) {
         Integer i = 1;
         Integer j = 1;
         Board ploca = new Board();
         Scanner input = new Scanner(System.in);

         do {
             if(i % 2 == 1) {
                 System.out.println("White move: ");
                 String position = input.nextLine();
                 if(position.equals("X"))
                     break;
                 //kada unosi samo malo slovo i broj -> pijun
                 if(position.length() == 2) {
                     pozoviMove(ploca, Pawn.class, ChessPiece.Color.WHITE, position, i, j);
                 }
                 else if(position.length() == 3) {
                     char tip = Character.toUpperCase(position.charAt(0));
                     switch(tip) {
                         case 'K':
                             pozoviMove(ploca, King.class, ChessPiece.Color.WHITE, position, i, j);
                             break;
                         case 'Q' :
                             pozoviMove(ploca, Queen.class, ChessPiece.Color.WHITE, position, i, j);
                             break;
                         case 'R':
                             pozoviMove(ploca, Rook.class, ChessPiece.Color.WHITE, position, i, j);
                             break;
                         case 'B':
                             pozoviMove(ploca, Bishop.class, ChessPiece.Color.WHITE, position, i, j);
                             break;
                         case 'N':
                             pozoviMove(ploca, Knight.class, ChessPiece.Color.WHITE, position, i, j);
                             break;

                     }
                 }
             }
             else if(j % 2 == 0) {
                 System.out.println("Black move: ");
                 String position = input.nextLine();
                 if(position.equals("X"))
                     break;
                 //kada unosi samo malo slovo i broj -> pijun
                 if(position.length() == 2) {
                     pozoviMove(ploca, Pawn.class, ChessPiece.Color.BLACK, position, i, j);
                 }
                 else if(position.length() == 3) {
                     char tip = Character.toUpperCase(position.charAt(0));
                     switch(tip) {
                         case 'K':
                             pozoviMove(ploca, King.class, ChessPiece.Color.BLACK, position, i, j);
                             break;
                         case 'Q' :
                             pozoviMove(ploca, Queen.class, ChessPiece.Color.BLACK, position, i, j);
                             break;
                         case 'R':
                             pozoviMove(ploca, Rook.class, ChessPiece.Color.BLACK, position, i, j);
                             break;
                         case 'B':
                             pozoviMove(ploca, Bishop.class, ChessPiece.Color.BLACK, position, i, j);
                             break;
                         case 'N':
                             pozoviMove(ploca, Knight.class, ChessPiece.Color.BLACK, position, i, j);
                             break;

                     }
                 }
             }
             i++;
             j++;
         } while(true);




    }
}
