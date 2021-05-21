package ru.gb.artem.marketapril;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
// Домашнее задание:
// 1. При оформлении заказа нужно указать доп информацию: телефон, адрес доставки
// 2. Регистрация пользователей через отправку JSON
// {
//   "username": "bob",
//   "password": "123"
//   "email": "bob@gmail.com"
// }
// 3. *Исследовательская* Загрузка товаров из файла

@SpringBootApplication
@PropertySource("classpath:app.properties")
public class MarketAprilApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarketAprilApplication.class, args);
	}

}
