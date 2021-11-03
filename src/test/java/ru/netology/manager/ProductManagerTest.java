package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    private final ProductManager manager = new ProductManager(new ProductRepository());
    private final Product first = new Product(1, "scarf", 250);
    private final Book second = new Book(2, "Магия утра. Как первый час дня определяет ваш успех", 500, "Хэл Элрод");
    private final Smartphone third = new Smartphone(3, "A51", 5500, "Samsung");
    private final Product fourth = new Product(4, "flower", 509);
    private final Book fifth = new Book(5, "Подсознание может всё!", 400, "Джон Кехо");
    private final Smartphone sixth = new Smartphone(6, "P40", 5500, "Huawei");

    @BeforeEach
    void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
    }

    @Test
    void shouldSearchByNameBook() {
        Product[] expected = {second};
        assertArrayEquals(expected, manager.searchBy("Магия утра. Как первый час дня определяет ваш успех"));

    }

    @Test
    void shouldNotFindNameBook() {
        Product[] expected = {};
        assertArrayEquals(expected, manager.searchBy("Алые паруса"));

    }

    @Test
    void shouldSearchByAuthor() {
        Product[] expected = {fifth};
        assertArrayEquals(expected, manager.searchBy("Джон Кехо"));

    }

    @Test
    void shouldNotFindAuthor() {
        Product[] expected = {};
        assertArrayEquals(expected, manager.searchBy("Александр Пушкин"));

    }

    @Test
    void shouldSearchByNameProduct() {
        Product[] expected = {first};
        assertArrayEquals(expected, manager.searchBy("scarf"));

    }

    @Test
    void shouldNotFindProduct() {
        Product[] expected = {};
        assertArrayEquals(expected, manager.searchBy("vase"));

    }


    @Test
    void shouldSearchByManufacturer() {
        Product[] expected = {third};
        assertArrayEquals(expected, manager.searchBy("Samsung"));

    }

    @Test
    void shouldNotFindManufacturer() {
        Product[] expected = {};
        assertArrayEquals(expected, manager.searchBy("Nokia"));

    }

    @Test
    void shouldSearchBySmartphoneName() {
        Product[] expected = {sixth};
        assertArrayEquals(expected, manager.searchBy("P40"));

    }

    @Test
    void shouldNotFindSmartphoneName() {
        Product[] expected = {};
        assertArrayEquals(expected, manager.searchBy("A7"));

    }
}