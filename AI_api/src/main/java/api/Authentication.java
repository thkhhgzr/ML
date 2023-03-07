package api;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Authentication {
  private static List<String> loadTokens() {
    List<String> result;
    try (Stream<String> lines = Files.lines(Paths.get(new File("").getAbsolutePath()
            + "\\src\\main\\java\\api\\Tokens.txt"))) {

      result = lines.collect(Collectors.toList());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    return result;
  }

  public static boolean verifyUser(String token) {
    return loadTokens().contains(token);
  }
}
