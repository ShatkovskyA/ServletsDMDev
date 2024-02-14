package src.ru.tern.http.socket.main.java.ru.tern.http.socket;


/**
 * Класс DatagramServerRunner - реализует сервер для взаимодействия по протоколу UDP
 *
 * @author Anton Shatkovskiy created 19.02.2024 г.
 */

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * DatagramServerRunner.
 *
 * @author Anton Shatkovskiy
 * @created 19.02.2024 г.
 */
public class DatagramServerRunner {

  public static void main(String[] args) throws SocketException {

    // передаем порт, на котором будем работать и оборачиваем в try-catch ресурсы
    try (var datagramServer = new DatagramSocket(7777)) {

      // создаем опять буффер c размером
      byte[] buffer = new byte[512];

      // принимаем пакет из класса DatagramRunner
      DatagramPacket packet = new DatagramPacket(buffer);
      datagramServer.receive(packet);

      // а теперь получаем данные
      System.out.println(new String(buffer));

    }

  }

}
