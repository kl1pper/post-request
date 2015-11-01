DROP TABLE IF EXISTS city;
DROP TABLE IF EXISTS country;
DROP SEQUENCE IF EXISTS city_id_seq;
DROP SEQUENCE IF EXISTS country_id_seq;

CREATE TABLE city (
    id integer NOT NULL,
    title character varying(255),
    country integer
);

CREATE SEQUENCE city_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE city_id_seq OWNED BY city.id;

CREATE TABLE country (
    id integer NOT NULL,
    title character varying(255),
    code character varying(255)
);

CREATE SEQUENCE country_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE country_id_seq OWNED BY country.id;

ALTER TABLE ONLY city
ADD CONSTRAINT city_pkey PRIMARY KEY (id);


ALTER TABLE ONLY country
ADD CONSTRAINT country_pkey PRIMARY KEY (id);

ALTER TABLE ONLY city
ADD CONSTRAINT city_country_fkey FOREIGN KEY (country) REFERENCES country(id);
