package is.ru.bazinga;

import com.google.gson.Gson;
import spark.servlet.SparkApplication;

import static spark.Spark.*;

public class Web implements SparkApplication {
  Tic game;
  private static Gson gson = new Gson();

  public static void main(String[] args) {
    staticFileLocation("/public");
    SparkApplication web = new Web();
    String port = System.getenv("PORT");

    if (port != null) {
      port(Integer.valueOf(port));
    }

    web.init();
  }

  @Override
  public void init() {
    post("/new-game", (req, res) -> {
      game = new Tic();
      return true;
    });

    post("/player-move", (req, res) -> {
      WebDTO dto = new WebDTO();

      int move = Integer.parseInt(req.queryParams("move"));
      char player = game.player;
      game.placeMark(move);

      dto.player = player;

      if (game.isWinner()) {
        dto.status = 1;
        dto.message = player + " wins this game!";
      } else if (game.count >= 9) {
        dto.status = 2;
        dto.message = "Everyone is a looser! And you too!";
      } else {
        dto.status = 0;
        dto.message = "";
        game.switchPlayer();
      }

      return gson.toJson(dto);
    });
  }
}