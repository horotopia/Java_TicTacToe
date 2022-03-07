import java.util.Scanner;
import java.util.Random;

public class Main {
  static Scanner scan = new Scanner(System.in);
  static Random rand = new Random();
  static final String empty = " ";
  static final String PLAYER1 = "O";
  static final String PLAYER2 = "X";

  public static void main(String[] args) {
    //boolean wantToPlay = true;
    String player = "Joueur 2";
    String symbol = PLAYER2;
    String[][] tabCase = initialize(empty);
    play(tabCase, player, symbol);
    /*while (wantToPlay == true) {
      String[][] tabCase = initialize(empty);
      play(tabCase, player, symbol);
      wantToPlay = restart(wantToPlay);
    }*/
  }

  public static void play(String[][] tabCase, String player, String symbol) {
    int tour = 1;
    String win = " ";
    while (win != "Joueur 1" & win != "Joueur 2" & tour != 9) {
      String caseEmpty = player;
      player = (player == "Joueur 1") ? "Joueur 2" : "Joueur 1";
      symbol = (symbol == PLAYER1) ? PLAYER2 : PLAYER1;
      while (caseEmpty != empty) {
        display(tabCase);
        System.out.print("tour n°");
        System.out.println(tour);
        System.out.println(player);
        System.out.println("donnez la ligne (1-3):");
        int ligne = scan.nextInt() - 1;
        System.out.println("donnez la colonne (1-3):");
        int colonne = scan.nextInt() - 1;
        if (tabCase[ligne][colonne] == empty) {
          caseEmpty = empty;
          tabCase[ligne][colonne] = (player == "Joueur 1") ? PLAYER1 : PLAYER2;
        } else {
          System.out.println("case déjà prise, essaie encore.");
          caseEmpty = player;
        }
      }
      win = victory(tabCase, player, symbol);
      tour++;
    }
  }

  public static String victory(String[][] tabCase, String player, String symbol) {
    String win = null;
    for (int i = 0; i < 3; i++) {
      if (tabCase[i][0] == symbol) {
        if (tabCase[i][1] == symbol) {
          if (tabCase[i][2] == symbol) {
            display(tabCase);
            System.out.println("Bravo " + player + ", vous avez gagné.");
            win = player;
          }
        }
      }
      if (tabCase[0][i] == symbol) {
        if (tabCase[1][i] == symbol) {
          if (tabCase[2][i] == symbol) {
            display(tabCase);
            System.out.println("Bravo " + player + ", vous avez gagné.");
            win = player;
          }
        }
      }
    }
    if (tabCase[0][0] == symbol) {
      if (tabCase[1][1] == symbol) {
        if (tabCase[2][2] == symbol) {
          display(tabCase);
          System.out.println("Bravo " + player + ", vous avez gagné.");
          win = player;
        }
      }
    }
    if (tabCase[0][2] == symbol) {
      if (tabCase[1][1] == symbol) {
        if (tabCase[2][0] == symbol) {
          display(tabCase);
          System.out.println("Bravo " + player + ", vous avez gagné.");
          win = player;
        }
      }
    }
    return win;
  }

  /*public static boolean restart(boolean wantToPlay) {
    char answer = ' ';
    //while (answer != "y" & answer != "n") {
    System.out.println("voulez-vous recommencer ? (y/n)");
    answer = scan.nextChar();
    //answer = answer.toLowerCase();
    if (answer == 'y') {
      wantToPlay = true;
      System.out.println("Super !");
    }
    else {
      wantToPlay = false;
      System.out.println("à bientot !");
    }
    /*if (answer == "n") {
      wantToPlay = false;
    }
    System.out.print(answer);
    }
    return wantToPlay;
  }*/

  public static String[][] initialize(String initChar) {
    return new String[][] { { initChar, initChar, initChar }, { initChar, initChar, initChar },
        { initChar, initChar, initChar } };
  }

  public static void display(String[][] tabCase) {
    System.out.println("  ___ ___ ___ ");
    for (int i = 0; i < tabCase.length; i++) {
      for (int j = 0; j < tabCase[i].length; j++) {
        System.out.print(" | ");
        System.out.print(tabCase[i][j]);
      }
      System.out.println(" |");
      System.out.println(" |___|___|___|");
    }
  }
}