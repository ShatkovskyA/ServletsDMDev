package src.ru.tern.http.main.java.server;


/**
 * Класс HttpClientRunner - реализует HTTP отправку запроса на сервер
 *
 * @author Anton Shatkovskiy created 21.02.2024 г.
 */

import static java.net.http.HttpRequest.BodyPublishers.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;

/**
 * HttpClientRunner.
 *
 * @author Anton Shatkovskiy
 * @created 21.02.2024 г.
 */
public class HttpClientRunner {

  public static void main(String[] args) throws IOException, InterruptedException {

    // созадем HTTP клиента
    var httpClient = HttpClient.newBuilder()
        .version(HttpClient.Version.HTTP_1_1)
        .build();

        // создаем запрос с отправкой JSONa
    var request = HttpRequest.newBuilder()
        // куда передаем
        .uri(URI.create("http://localhost:9000"))
        // что передаем
        .header("content-type", "application/json")
        // запрос в виде файла - для Бодипаблишер сделать статитческий импорт
        .POST(ofFile(Path.of("resources", "first.json")))
        .build();

    var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

    // выводим на консоль запросы и ответы
    System.out.println(response.headers());
    System.out.println(response.body());
  }

}
