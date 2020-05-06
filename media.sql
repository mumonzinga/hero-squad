--
-- PostgreSQL database dump
--

-- Dumped from database version 10.12 (Ubuntu 10.12-0ubuntu0.18.04.1)
-- Dumped by pg_dump version 10.12 (Ubuntu 10.12-0ubuntu0.18.04.1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: heroes; Type: TABLE; Schema: public; Owner: mumo
--

CREATE TABLE public.heroes (
    id integer NOT NULL,
    name character varying,
    age integer,
    power character varying,
    weakness character varying,
    createdat timestamp without time zone,
    squadid integer
);


ALTER TABLE public.heroes OWNER TO mumo;

--
-- Name: heroes_id_seq; Type: SEQUENCE; Schema: public; Owner: mumo
--

CREATE SEQUENCE public.heroes_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.heroes_id_seq OWNER TO mumo;

--
-- Name: heroes_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mumo
--

ALTER SEQUENCE public.heroes_id_seq OWNED BY public.heroes.id;


--
-- Name: squads; Type: TABLE; Schema: public; Owner: mumo
--

CREATE TABLE public.squads (
    id integer NOT NULL,
    name character varying,
    size integer,
    cause character varying
);


ALTER TABLE public.squads OWNER TO mumo;

--
-- Name: squads_id_seq; Type: SEQUENCE; Schema: public; Owner: mumo
--

CREATE SEQUENCE public.squads_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.squads_id_seq OWNER TO mumo;

--
-- Name: squads_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mumo
--

ALTER SEQUENCE public.squads_id_seq OWNED BY public.squads.id;


--
-- Name: heroes id; Type: DEFAULT; Schema: public; Owner: mumo
--

ALTER TABLE ONLY public.heroes ALTER COLUMN id SET DEFAULT nextval('public.heroes_id_seq'::regclass);


--
-- Name: squads id; Type: DEFAULT; Schema: public; Owner: mumo
--

ALTER TABLE ONLY public.squads ALTER COLUMN id SET DEFAULT nextval('public.squads_id_seq'::regclass);


--
-- Data for Name: heroes; Type: TABLE DATA; Schema: public; Owner: mumo
--

COPY public.heroes (id, name, age, power, weakness, createdat, squadid) FROM stdin;
\.


--
-- Data for Name: squads; Type: TABLE DATA; Schema: public; Owner: mumo
--

COPY public.squads (id, name, size, cause) FROM stdin;
\.


--
-- Name: heroes_id_seq; Type: SEQUENCE SET; Schema: public; Owner: mumo
--

SELECT pg_catalog.setval('public.heroes_id_seq', 1, false);


--
-- Name: squads_id_seq; Type: SEQUENCE SET; Schema: public; Owner: mumo
--

SELECT pg_catalog.setval('public.squads_id_seq', 1, false);


--
-- Name: heroes heroes_pkey; Type: CONSTRAINT; Schema: public; Owner: mumo
--

ALTER TABLE ONLY public.heroes
    ADD CONSTRAINT heroes_pkey PRIMARY KEY (id);


--
-- Name: squads squads_pkey; Type: CONSTRAINT; Schema: public; Owner: mumo
--

ALTER TABLE ONLY public.squads
    ADD CONSTRAINT squads_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

