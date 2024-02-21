package src.ru.tern.http.main.java.client;
/**
 * Класс UrlExample - реализует класс для реализации методов по протоколоу HTTP
 *
 * @author Anton Shatkovskiy created 19.02.2024 г.
 */

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * UrlExample.
 *
 * @author Anton Shatkovskiy
 * @created 19.02.2024 г.
 */
public class UrlExample {

  public static void main(String[] args) throws IOException {
    // пишем URL куда обращаемся
    var url = new URL("https://www.google.com");

    // открываем соединение, т. е. просто пишем коннекшн
    var urlConnection = url.openConnection();

    // проверяем что вернет урлсоннекшн в дебаге
    System.out.println();

    // далее можем получить следующее
//    urlConnection.getContent();
  }

}
