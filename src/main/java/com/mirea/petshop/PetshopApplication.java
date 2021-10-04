package com.mirea.petshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Главный класс
 * @author Сметанникова Ксения
 */

@SpringBootApplication
public class PetshopApplication {

	/**
	 * Входная точка веб-приложения
	 * @param args Массив аргументов переданных при запуске веб-приложения
	 */
	public static void main(String[] args) {
		SpringApplication.run(PetshopApplication.class, args);
	}

}
