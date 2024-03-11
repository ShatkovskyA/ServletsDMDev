package src.ru.tern.http.service;

/**
 * Класс FlightService -
 *
 * @author Anton Shatkovskiy created 05.03.2024 г.
 */

import java.util.List;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;
import src.ru.tern.http.dto.FlightDto;
import src.ru.tern.http.dao.FlightDao;


/**
 * FlightService.
 *
 * @author Anton Shatkovskiy
 * @created 05.03.2024 г.
 */

public class FlightService {

  // добавляем паттерн синглтон
  private static final FlightService INSTANCE = new FlightService();

  // фильтр, возвращает из DAO также все перелеты,
  // но с реализацией паттерна синглтон (т. к. по правилам хорошего тона, опять же
  // Service, DAO и пр. должны быть синглтонами)
  private final FlightDao flightDao = FlightDao.getInstance();

  // также добавляем приватный конструктор для для синглтона
  private FlightService() {
  }

  // по правилам хорошего тона - возвращаем Dto, т. е. возвращаем все перелеты
  public List<FlightDto> findAll() {

    // преобразовываем все сущности через стримы
    return flightDao.findAll().stream()
        // flight cущность преобразовываем в FlightDto
        .map(flight -> new FlightDto(
            flight.getId(),
            // откуда и куда летит + статус
            """
                %s - %s - % s
                """.formatted(flight.getDepartureAirportCode(),
                flight.getArrivalAirportCode(),
                flight.getStatus())
        ))
        // коллектим все в список, преобразовываем в статический импорт
        .collect(Collectors.toList());

  }

  // добавляем для синглтона метод гет
 public static FlightService getInstance() {
    return INSTANCE;
 }
}
