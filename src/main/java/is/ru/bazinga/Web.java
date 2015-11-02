package is.ru.bazinga;

import spark.servlet.SparkApplication;

import static spark.Spark.*;

public class Web implements SparkApplication {
  Tic game;

  public static void main(String[] args) {
    staticFileLocation("/public");
    SparkApplication web = new Web();
    web.init();
  }

  @Override
  public void init() {
    post("/new-game", (req, res) -> {
      game = new Tic();
      return true;
  }
}