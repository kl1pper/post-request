package ru.dmitry.postrequest.entities;

import javax.persistence.*;

@Entity
@Table(name = "city")
public class City {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "city_id_seq")
    @SequenceGenerator(name = "city_id_seq", sequenceName = "city_id_seq")
    private Integer id;

    @Column(name = "title")
    private String cityName;

    @JoinColumn(name = "country", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Country country;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
