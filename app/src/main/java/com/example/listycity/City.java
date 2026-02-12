package com.example.listycity;

import java.util.Objects;

/**
 * Represents a city with a city name and a province name.
 */
public class City implements Comparable<City> {

    /** The city name (e.g., "Edmonton"). */
    private final String city;

    /** The province name (e.g., "Alberta"). */
    private final String province;

    /**
     * Creates a City.
     *
     * @param city The city name
     * @param province The province name
     */
    public City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    /**
     * Gets the city name.
     *
     * @return the city name
     */
    public String getCityName() {
        return city;
    }

    /**
     * Gets the province name.
     *
     * @return the province name
     */
    public String getProvinceName() {
        return province;
    }

    /**
     * Compares cities by city name.
     *
     * @param other another City
     * @return negative/zero/positive if this city name is less/equal/greater
     */
    @Override
    public int compareTo(City other) {
        return this.city.compareTo(other.city);
    }

    /**
     * Cities are considered equal if both city name and province match.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City other = (City) o;
        return Objects.equals(city, other.city) && Objects.equals(province, other.province);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, province);
    }
}