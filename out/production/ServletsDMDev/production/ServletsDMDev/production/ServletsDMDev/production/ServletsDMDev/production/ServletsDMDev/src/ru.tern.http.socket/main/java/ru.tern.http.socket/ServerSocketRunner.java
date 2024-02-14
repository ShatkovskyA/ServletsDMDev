package src.ru.tern.http.socket.main.java.ru.tern.http.socket;



/**
 * Класс ServerSocketRunner - реализует сервер
 *
 * @author Anton Shatkovskiy created 15.02.2024 г.
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;

/**
 * ServerSocketRunner.
 *
 * @author Anton Shatkovskiy
 * @created 15.02.2024 г.
 */
public class ServerSocketRunner {

  public static void main(String[] args) throws IOException {

    // указываем порт для связи и оборачиваем в try cath для закрытия, если не исп.
    try (var serverSocket = new ServerSocket(7777);
// метод accept возвращает клиента (т. е. socket), кот. подключился к серверу
      var socket = serverSocket.accept();
      // запись resp клиенту
      var outputStream = new DataOutputStream(socket.getOutputStream());
        // ответ клиенту
      var inputStream = new DataInputStream(socket.getInputStream())) {

      // вывод информации, которую считаем
      System.out.println("Client request " + inputStream.readUTF());
      outputStream.writeUTF("Hello Evrybady cool Server!");
    }
  }

}
