package com.utsavi.tictactoe.stratergies;

import com.utsavi.tictactoe.BotDifficultyLevel;

public class BotPlayingStrategyFactory {
  public static BotPlayingStrategy getBotPlayingStrategyByDifficultyLevel(BotDifficultyLevel botDifficultyLevel){
      BotPlayingStrategy botPlayingStrategy = null;

      if(botDifficultyLevel.equals(BotDifficultyLevel.EASY)){
        botPlayingStrategy = new EasyBotPlayingStrategy();
      }else if(botDifficultyLevel.equals(BotDifficultyLevel.MEDIUM)){
        botPlayingStrategy = new MediumBotPlayingStratergy();
      }else{
        botPlayingStrategy = new HardBotPlayingStratergy();
      }
      return botPlayingStrategy;
  }


}
