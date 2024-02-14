package src.ru.tern.http.socket.main.java.ru.tern.http.socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.DataInputStream;
import java.net.Inet4Address;
import java.net.Socket;

/**
 * Класс SocketRunner - реализует соединение с удаленным хостом,
 * т. е. это клиент на стороне Java.
 *
 * @author Anton Shatkovskiy created 14.02.2024 г.
 */

public class SocketRunner {

  public static void main(String[] args) throws IOException {

    // http - 80
    // https - 43
    // tcp

    // II способ передачи адреса
//    var inetAddress = Inet4Address.getByName("google.com");

    // другой вариант с локальным сервером для класса ServerSocketRunner
    var inetAddress = Inet4Address.getByName("localhost");
//    try (var socket = new Socket(inetAddress, 80);

    // другой вариант с локальным сервером для класса ServerSocketRunner
    try (var socket = new Socket(inetAddress, 7777);

    // создали нашего клиента, на базе tray-catch с ресурсами, т. е. его нужно закрывать I способ
    // try (var socket = new Socket("google.com", 80);

        // отправлем данные
        var outputStream = new DataOutputStream(socket.getOutputStream());
        // получаем данные
        var inputStream = new DataOutputStream(socket.getOutputStream())) {

      // запрос с приветствием
      outputStream.writeUTF("Hello Evrybady!");

      // ответ в байтах, т. к. тип данных неизвестен
      // var response = inputStream.readAllBytes();

      // вывод на экран байтов
      // System.out.println(response.length);

      // другой вариант с локальным сервером для класса ServerSocketRunner
      System.out.println("Response from server: " + inputStream.writeUTF());

    }

  }

}