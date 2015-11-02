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
    web.init();
  }

  @Override
  public void init() {
    post("/new-game", (req, res) -> {
      game = new Tic();
      return true;
  }
}