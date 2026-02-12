package com.example.listycity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CityListTest {

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.countCities());

        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);

        assertEquals(2, cityList.countCities());
        assertTrue(cityList.hasCity(city));
    }

    @Test
    void testAddException_duplicateCity() {
        CityList cityList = mockCityList();

        // Same values as mockCity(), should be considered duplicate because equals/hashCode is implemented
        City duplicate = new City("Edmonton", "Alberta");

        assertThrows(IllegalArgumentException.class, () -> cityList.add(duplicate));
    }

    @Test
    void testHasCity_trueAndFalse() {
        CityList cityList = mockCityList();

        assertTrue(cityList.hasCity(new City("Edmonton", "Alberta")));
        assertFalse(cityList.hasCity(new City("Calgary", "Alberta")));
    }

    @Test
    void testDelete_removesCity() {
        CityList cityList = mockCityList();

        City edmonton = new City("Edmonton", "Alberta");
        assertTrue(cityList.hasCity(edmonton));

        cityList.delete(edmonton);

        assertFalse(cityList.hasCity(edmonton));
        assertEquals(0, cityList.countCities());
    }

    @Test
    void testDelete_throwsIfMissing() {
        CityList cityList = mockCityList();

        City missing = new City("Vancouver", "British Columbia");

        assertThrows(IllegalArgumentException.class, () -> cityList.delete(missing));
    }

    @Test
    void testCountCities() {
        CityList cityList = new CityList();
        assertEquals(0, cityList.countCities());

        cityList.add(new City("A", "X"));
        cityList.add(new City("B", "Y"));

        assertEquals(2, cityList.countCities());
    }

    @Test
    void testGetCities_sorted() {
        CityList cityList = new CityList();
        cityList.add(new City("Regina", "Saskatchewan"));
        cityList.add(new City("Charlottetown", "Prince Edward Island"));
        cityList.add(new City("Edmonton", "Alberta"));

        assertEquals("Charlottetown", cityList.getCities().get(0).getCityName());
        assertEquals("Edmonton", cityList.getCities().get(1).getCityName());
        assertEquals("Regina", cityList.getCities().get(2).getCityName());
    }
}