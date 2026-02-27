package com.utsavi.tictactoe;

import com.utsavi.tictactoe.stratergies.BotPlayingStrategy;
import com.utsavi.tictactoe.stratergies.BotPlayingStrategyFactory;

public class Bot extends Player{

  private BotDifficultyLevel botDifficultyLevel;
  private BotPlayingStrategy botPlayingStrategy;

  public Bot(Integer id, String name , PlayerType playerType , Symbol symbol, BotDifficultyLevel botDifficultyLevel){
    super(id, name , playerType , symbol);
    this.botDifficultyLevel = botDifficultyLevel;
    this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategyByDifficultyLevel(botDifficultyLevel);
  }

  @Override
  public Move makeMove(Board board){
    System.out.println("Hey ! " + getName() + " Its your turn. Please make move.");
    return botPlayingStrategy.makeMove(board, this);
  }
}
