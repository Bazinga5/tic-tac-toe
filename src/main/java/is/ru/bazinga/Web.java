package is.ru.bazinga;

import spark.*;
import static spark.Spark.*;

public class Web {
  public static void main(String[] args) {
    staticFileLocation("/public");
    get("/hello", (request, response) -> "Hello World!");
  }
}