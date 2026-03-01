package com.utsavi.tictactoe;

import com.utsavi.tictactoe.stratergies.ColumnWinningStratergy;
import com.utsavi.tictactoe.stratergies.DiagonalWinningStrategy;
import com.utsavi.tictactoe.stratergies.RowWinningStrategy;
import com.utsavi.tictactoe.stratergies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameController {
  Scanner scanner = new Scanner(System.in);

  /* IMPROVEMENTS: Direct Game object should not be sent, Rather than send id and by which client can ask for DTO */
  public Game startGame(){
     //Get dimensions
    int dimension = getDimensions();

    //Ask for Player details
    List<Player> players = getPlayers(dimension);

    //Ask for winning strategies
    List<WinningStrategy> winningStratergyList = getWinningStrategy();

    //Create Game Object
    return new Game(dimension , players , winningStratergyList);
  }

  public void display(Game game){
    game.display();
  }

  public void makeMove(Game game){
    game.makeMove();
  }

  public Player getWinner(Game game){
    return game.getWinner();
  }

  public GameState getGameState(Game game){
    return game.getGameState();
  }

  private int getDimensions(){
    System.out.println("Please enter size of board:");
    int dimension = scanner.nextInt();
    scanner.nextLine(); // consume trailing newline
    return dimension;
  }

  private List<Player> getPlayers(int dimension){
    System.out.println("Let's add players now: ");
    List<Player> players = new ArrayList<>();

    for(int i = 0; i< dimension - 1 ; i++){
      System.out.println("Add Player details : Name Symbol");
      String details = scanner.nextLine();
      String[] detailsArray = details.split(" ");
      Player player = new Human(i , detailsArray[0] , PlayerType.HUMAN, new Symbol(detailsArray[1]));
      players.add(player);
    }

    System.out.println("Do you want bot ? [YES/NO] ");
    String result = scanner.nextLine();

    if(result.equalsIgnoreCase("yes")){
      System.out.println("Add Bot details: Symbol");
      String symbol = scanner.nextLine();
      System.out.println("Choose difficulty level: [EASY / MEDIUM / HARD]");
      String level = scanner.nextLine();
      BotDifficultyLevel difficultyLevel = BotDifficultyLevel.valueOf(level.trim().toUpperCase());
      Player player = new Bot(players.size(), "BOT" , PlayerType.BOT, new Symbol(symbol), difficultyLevel);
      players.add(player);
    }
    return players;
  }

  private List<WinningStrategy> getWinningStrategy(){
    System.out.println("Do you want Raw Winning ? [YES/NO]");
    List<WinningStrategy> winningStratergyList = new ArrayList<>();

    String result = scanner.nextLine();

    if(result.equalsIgnoreCase("YES")){
      winningStratergyList.add(new RowWinningStrategy());
    }

    System.out.println("Do you want Col Winning ? [YES/NO]");
    result = scanner.nextLine();
    if(result.equalsIgnoreCase("YES")){
      winningStratergyList.add(new ColumnWinningStratergy());
    }

    System.out.println("Do you want Diagonal Winning ? [YES/NO]");
    result = scanner.nextLine();
    if(result.equalsIgnoreCase("YES")){
      winningStratergyList.add(new DiagonalWinningStrategy());
    }

    return winningStratergyList;
  }
}
