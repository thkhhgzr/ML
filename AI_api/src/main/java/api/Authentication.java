package api;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Authentication {
  private static List<String> loadTokens() {
    ClassLoader classloader = Thread.currentThread().getContextClassLoader();
    InputStream is = classloader.getResourceAsStream("Tokens.txt");

    List<String> result =
              new BufferedReader(new InputStreamReader(is,
                      StandardCharsets.UTF_8)).lines().collect(Collectors.toList());

    return result;
  }

  public static boolean verifyUser(String token) {
    return loadTokens().contains(token);
  }
}
