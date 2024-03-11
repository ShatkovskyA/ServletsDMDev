package src.ru.tern.http.client;
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

    // обращаемся к файлу через url и записать все в виде коноекшена и считывать побайтно инфу
    var url = new URL("file:/Study/ServletsDMDev/src/ru.tern.http/main/java/socket");

    // открываем коннекшн, получаем коннекшн
    var urlConnection = url.openConnection();

    // запихиваем в строку, выводим на печать
    System.out.println(new String(urlConnection.getInputStream().readAllBytes()));

//    checkGoogle();
  }

  // выносим в отдельный файл
  private static void checkGoogle() throws IOException {
    // пишем URL куда обращаемся
    var url = new URL("https://www.google.com");

    // открываем соединение, т. е. просто пишем коннекшн - GET запрос
    var urlConnection = url.openConnection();

    // POST запрос, передаем в айтпутстрим - боди
    urlConnection.setDoOutput(true);

    // записываем байты
    try (var outputStream = urlConnection.getOutputStream()) {

    }

    // проверяем что вернет урлсоннекшн в дебаге
    System.out.println();

    // далее можем получить следующее
    // urlConnection.getContent();
  }

}
