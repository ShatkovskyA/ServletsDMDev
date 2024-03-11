package src.ru.tern.http.client;

/**
 * Класс HttpClientExample - реализует класс для реализации роли клиента к вэб-серверу
 * HttpClient - проедпочтительнее использовать после Java 11 нежели Url
 *
 * @author Anton Shatkovskiy created 21.02.2024 г.
 */

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.sql.SQLOutput;

/**
 * HttpClientExample.
 *
 * @author Anton Shatkovskiy
 * @created 21.02.2024 г.
 */
public class HttpClientExample {

  public static void main(String[] args) throws IOException, InterruptedException {

    // используем паттерн Builder
    var httpClient = HttpClient.newBuilder()
        .version(HttpClient.Version.HTTP_1_1)
        .build();

    // отправить запрос, сначала создаем request, потом передаем
    HttpRequest request = HttpRequest.newBuilder(URI.create("http://localhost:8080/clearth/ui/restricted/home.jsf"))
        .GET()
        .build();

    // еще вариант запроса для примера
    // HttpRequest request2 = HttpRequest.newBuilder(URI.create("https://www.google.com"))
    // .POST(HttpRequest.BodyPublisher.ofFile(Path.of("path", "to", "file")))
    // .build();

    var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

    // выодим боди и заголовки
    System.out.println(response.body());
    System.out.println(response.headers());


  }

}
