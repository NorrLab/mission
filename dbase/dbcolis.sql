--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.0
-- Dumped by pg_dump version 9.5.0

-- Started on 2016-04-05 01:47:54

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2175 (class 1262 OID 40960)
-- Name: dbcolis; Type: DATABASE; Schema: -; Owner: projet
--

CREATE DATABASE dbcolis WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'French_France.1252' LC_CTYPE = 'French_France.1252';


ALTER DATABASE dbcolis OWNER TO projet;

\connect dbcolis

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 195 (class 3079 OID 12355)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2178 (class 0 OID 0)
-- Dependencies: 195
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 185 (class 1259 OID 40994)
-- Name: annonce; Type: TABLE; Schema: public; Owner: projet
--

CREATE TABLE annonce (
    id_annoce integer DEFAULT nextval(('public.annonce_id_annoce_seq'::text)::regclass) NOT NULL,
    type_transport character varying(30) NOT NULL,
    description text NOT NULL,
    date_annonce date NOT NULL,
    ville_depart character varying(50) NOT NULL,
    ville_arrivee character varying(50) NOT NULL,
    date_depart date NOT NULL,
    date_arrivee date NOT NULL,
    status boolean NOT NULL,
    client_id integer NOT NULL
);


ALTER TABLE annonce OWNER TO projet;

--
-- TOC entry 192 (class 1259 OID 41245)
-- Name: annonce_client_id_seq; Type: SEQUENCE; Schema: public; Owner: projet
--

CREATE SEQUENCE annonce_client_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE annonce_client_id_seq OWNER TO projet;

--
-- TOC entry 2179 (class 0 OID 0)
-- Dependencies: 192
-- Name: annonce_client_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: projet
--

ALTER SEQUENCE annonce_client_id_seq OWNED BY annonce.client_id;


--
-- TOC entry 187 (class 1259 OID 41174)
-- Name: annonce_id_annoce_seq; Type: SEQUENCE; Schema: public; Owner: projet
--

CREATE SEQUENCE annonce_id_annoce_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 2147483647
    CACHE 1;


ALTER TABLE annonce_id_annoce_seq OWNER TO projet;

--
-- TOC entry 181 (class 1259 OID 40966)
-- Name: avis; Type: TABLE; Schema: public; Owner: projet
--

CREATE TABLE avis (
    id_avis integer DEFAULT nextval(('public.avis_id_avis_seq'::text)::regclass) NOT NULL,
    type_avis character varying(30) NOT NULL,
    description text,
    date_avis date NOT NULL,
    client_id integer NOT NULL
);


ALTER TABLE avis OWNER TO projet;

--
-- TOC entry 191 (class 1259 OID 41229)
-- Name: avis_client_id_seq; Type: SEQUENCE; Schema: public; Owner: projet
--

CREATE SEQUENCE avis_client_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE avis_client_id_seq OWNER TO projet;

--
-- TOC entry 2180 (class 0 OID 0)
-- Dependencies: 191
-- Name: avis_client_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: projet
--

ALTER SEQUENCE avis_client_id_seq OWNED BY avis.client_id;


--
-- TOC entry 188 (class 1259 OID 41190)
-- Name: avis_id_avis_seq; Type: SEQUENCE; Schema: public; Owner: projet
--

CREATE SEQUENCE avis_id_avis_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 2147483647
    CACHE 1;


ALTER TABLE avis_id_avis_seq OWNER TO projet;

--
-- TOC entry 180 (class 1259 OID 40961)
-- Name: client; Type: TABLE; Schema: public; Owner: projet
--

CREATE TABLE client (
    id_client integer DEFAULT nextval(('public.client_id_client_seq'::text)::regclass) NOT NULL,
    nom character varying(30) NOT NULL,
    prenom character varying(50) NOT NULL,
    email character varying(50) NOT NULL,
    datenaissance date NOT NULL,
    telephone character varying(12) NOT NULL,
    sexe boolean NOT NULL,
    adresse character varying(60) NOT NULL,
    code_postal character varying(8) NOT NULL,
    identifiant character varying(30) NOT NULL,
    password character varying(30),
    photo bigint NOT NULL
);


ALTER TABLE client OWNER TO projet;

--
-- TOC entry 186 (class 1259 OID 41092)
-- Name: client_id_client_seq; Type: SEQUENCE; Schema: public; Owner: projet
--

CREATE SEQUENCE client_id_client_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 2147483647
    CACHE 1;


ALTER TABLE client_id_client_seq OWNER TO projet;

--
-- TOC entry 184 (class 1259 OID 40987)
-- Name: client_photo_seq; Type: SEQUENCE; Schema: public; Owner: projet
--

CREATE SEQUENCE client_photo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE client_photo_seq OWNER TO projet;

--
-- TOC entry 2181 (class 0 OID 0)
-- Dependencies: 184
-- Name: client_photo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: projet
--

ALTER SEQUENCE client_photo_seq OWNED BY client.photo;


--
-- TOC entry 183 (class 1259 OID 40982)
-- Name: colis; Type: TABLE; Schema: public; Owner: projet
--

CREATE TABLE colis (
    id_colis integer DEFAULT nextval(('public.colis_id_colis_seq'::text)::regclass) NOT NULL,
    poids double precision,
    taille character varying(10),
    prix double precision NOT NULL,
    annonce_id integer NOT NULL
);


ALTER TABLE colis OWNER TO projet;

--
-- TOC entry 193 (class 1259 OID 41260)
-- Name: colis_annonce_id_seq; Type: SEQUENCE; Schema: public; Owner: projet
--

CREATE SEQUENCE colis_annonce_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE colis_annonce_id_seq OWNER TO projet;

--
-- TOC entry 2182 (class 0 OID 0)
-- Dependencies: 193
-- Name: colis_annonce_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: projet
--

ALTER SEQUENCE colis_annonce_id_seq OWNED BY colis.annonce_id;


--
-- TOC entry 189 (class 1259 OID 41202)
-- Name: colis_id_colis_seq; Type: SEQUENCE; Schema: public; Owner: projet
--

CREATE SEQUENCE colis_id_colis_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 2147483647
    CACHE 1;


ALTER TABLE colis_id_colis_seq OWNER TO projet;

--
-- TOC entry 182 (class 1259 OID 40974)
-- Name: messages; Type: TABLE; Schema: public; Owner: projet
--

CREATE TABLE messages (
    id_message integer DEFAULT nextval(('public.messages_id_message_seq'::text)::regclass) NOT NULL,
    type_message character varying(30) NOT NULL,
    msgsent text NOT NULL,
    date_msg integer NOT NULL,
    client_id integer NOT NULL
);


ALTER TABLE messages OWNER TO projet;

--
-- TOC entry 194 (class 1259 OID 41272)
-- Name: messages_client_id_seq; Type: SEQUENCE; Schema: public; Owner: projet
--

CREATE SEQUENCE messages_client_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE messages_client_id_seq OWNER TO projet;

--
-- TOC entry 2183 (class 0 OID 0)
-- Dependencies: 194
-- Name: messages_client_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: projet
--

ALTER SEQUENCE messages_client_id_seq OWNED BY messages.client_id;


--
-- TOC entry 190 (class 1259 OID 41214)
-- Name: messages_id_message_seq; Type: SEQUENCE; Schema: public; Owner: projet
--

CREATE SEQUENCE messages_id_message_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 2147483647
    CACHE 1;


ALTER TABLE messages_id_message_seq OWNER TO projet;

--
-- TOC entry 2027 (class 2604 OID 41247)
-- Name: client_id; Type: DEFAULT; Schema: public; Owner: projet
--

ALTER TABLE ONLY annonce ALTER COLUMN client_id SET DEFAULT nextval('annonce_client_id_seq'::regclass);


--
-- TOC entry 2021 (class 2604 OID 41231)
-- Name: client_id; Type: DEFAULT; Schema: public; Owner: projet
--

ALTER TABLE ONLY avis ALTER COLUMN client_id SET DEFAULT nextval('avis_client_id_seq'::regclass);


--
-- TOC entry 2018 (class 2604 OID 40989)
-- Name: photo; Type: DEFAULT; Schema: public; Owner: projet
--

ALTER TABLE ONLY client ALTER COLUMN photo SET DEFAULT nextval('client_photo_seq'::regclass);


--
-- TOC entry 2025 (class 2604 OID 41262)
-- Name: annonce_id; Type: DEFAULT; Schema: public; Owner: projet
--

ALTER TABLE ONLY colis ALTER COLUMN annonce_id SET DEFAULT nextval('colis_annonce_id_seq'::regclass);


--
-- TOC entry 2023 (class 2604 OID 41274)
-- Name: client_id; Type: DEFAULT; Schema: public; Owner: projet
--

ALTER TABLE ONLY messages ALTER COLUMN client_id SET DEFAULT nextval('messages_client_id_seq'::regclass);


--
-- TOC entry 2161 (class 0 OID 40994)
-- Dependencies: 185
-- Data for Name: annonce; Type: TABLE DATA; Schema: public; Owner: projet
--



--
-- TOC entry 2184 (class 0 OID 0)
-- Dependencies: 192
-- Name: annonce_client_id_seq; Type: SEQUENCE SET; Schema: public; Owner: projet
--

SELECT pg_catalog.setval('annonce_client_id_seq', 1, false);


--
-- TOC entry 2185 (class 0 OID 0)
-- Dependencies: 187
-- Name: annonce_id_annoce_seq; Type: SEQUENCE SET; Schema: public; Owner: projet
--

SELECT pg_catalog.setval('annonce_id_annoce_seq', 1, false);


--
-- TOC entry 2157 (class 0 OID 40966)
-- Dependencies: 181
-- Data for Name: avis; Type: TABLE DATA; Schema: public; Owner: projet
--



--
-- TOC entry 2186 (class 0 OID 0)
-- Dependencies: 191
-- Name: avis_client_id_seq; Type: SEQUENCE SET; Schema: public; Owner: projet
--

SELECT pg_catalog.setval('avis_client_id_seq', 1, false);


--
-- TOC entry 2187 (class 0 OID 0)
-- Dependencies: 188
-- Name: avis_id_avis_seq; Type: SEQUENCE SET; Schema: public; Owner: projet
--

SELECT pg_catalog.setval('avis_id_avis_seq', 1, false);


--
-- TOC entry 2156 (class 0 OID 40961)
-- Dependencies: 180
-- Data for Name: client; Type: TABLE DATA; Schema: public; Owner: projet
--



--
-- TOC entry 2188 (class 0 OID 0)
-- Dependencies: 186
-- Name: client_id_client_seq; Type: SEQUENCE SET; Schema: public; Owner: projet
--

SELECT pg_catalog.setval('client_id_client_seq', 1, false);


--
-- TOC entry 2189 (class 0 OID 0)
-- Dependencies: 184
-- Name: client_photo_seq; Type: SEQUENCE SET; Schema: public; Owner: projet
--

SELECT pg_catalog.setval('client_photo_seq', 1, false);


--
-- TOC entry 2159 (class 0 OID 40982)
-- Dependencies: 183
-- Data for Name: colis; Type: TABLE DATA; Schema: public; Owner: projet
--



--
-- TOC entry 2190 (class 0 OID 0)
-- Dependencies: 193
-- Name: colis_annonce_id_seq; Type: SEQUENCE SET; Schema: public; Owner: projet
--

SELECT pg_catalog.setval('colis_annonce_id_seq', 1, false);


--
-- TOC entry 2191 (class 0 OID 0)
-- Dependencies: 189
-- Name: colis_id_colis_seq; Type: SEQUENCE SET; Schema: public; Owner: projet
--

SELECT pg_catalog.setval('colis_id_colis_seq', 1, false);


--
-- TOC entry 2158 (class 0 OID 40974)
-- Dependencies: 182
-- Data for Name: messages; Type: TABLE DATA; Schema: public; Owner: projet
--



--
-- TOC entry 2192 (class 0 OID 0)
-- Dependencies: 194
-- Name: messages_client_id_seq; Type: SEQUENCE SET; Schema: public; Owner: projet
--

SELECT pg_catalog.setval('messages_client_id_seq', 1, false);


--
-- TOC entry 2193 (class 0 OID 0)
-- Dependencies: 190
-- Name: messages_id_message_seq; Type: SEQUENCE SET; Schema: public; Owner: projet
--

SELECT pg_catalog.setval('messages_id_message_seq', 1, false);


--
-- TOC entry 2037 (class 2606 OID 41177)
-- Name: annonce_pkey; Type: CONSTRAINT; Schema: public; Owner: projet
--

ALTER TABLE ONLY annonce
    ADD CONSTRAINT annonce_pkey PRIMARY KEY (id_annoce);


--
-- TOC entry 2031 (class 2606 OID 41199)
-- Name: avis_pkey; Type: CONSTRAINT; Schema: public; Owner: projet
--

ALTER TABLE ONLY avis
    ADD CONSTRAINT avis_pkey PRIMARY KEY (id_avis);


--
-- TOC entry 2029 (class 2606 OID 41095)
-- Name: client_pkey; Type: CONSTRAINT; Schema: public; Owner: projet
--

ALTER TABLE ONLY client
    ADD CONSTRAINT client_pkey PRIMARY KEY (id_client);


--
-- TOC entry 2035 (class 2606 OID 41205)
-- Name: colis_pkey; Type: CONSTRAINT; Schema: public; Owner: projet
--

ALTER TABLE ONLY colis
    ADD CONSTRAINT colis_pkey PRIMARY KEY (id_colis);


--
-- TOC entry 2033 (class 2606 OID 41217)
-- Name: messages_pkey; Type: CONSTRAINT; Schema: public; Owner: projet
--

ALTER TABLE ONLY messages
    ADD CONSTRAINT messages_pkey PRIMARY KEY (id_message);


--
-- TOC entry 2038 (class 2606 OID 41239)
-- Name: Foreign_key01; Type: FK CONSTRAINT; Schema: public; Owner: projet
--

ALTER TABLE ONLY avis
    ADD CONSTRAINT "Foreign_key01" FOREIGN KEY (client_id) REFERENCES client(id_client);


--
-- TOC entry 2039 (class 2606 OID 41282)
-- Name: Foreign_key02; Type: FK CONSTRAINT; Schema: public; Owner: projet
--

ALTER TABLE ONLY messages
    ADD CONSTRAINT "Foreign_key02" FOREIGN KEY (client_id) REFERENCES client(id_client);


--
-- TOC entry 2041 (class 2606 OID 41255)
-- Name: Foreign_key03; Type: FK CONSTRAINT; Schema: public; Owner: projet
--

ALTER TABLE ONLY annonce
    ADD CONSTRAINT "Foreign_key03" FOREIGN KEY (client_id) REFERENCES client(id_client);


--
-- TOC entry 2040 (class 2606 OID 41267)
-- Name: Foreign_key04; Type: FK CONSTRAINT; Schema: public; Owner: projet
--

ALTER TABLE ONLY colis
    ADD CONSTRAINT "Foreign_key04" FOREIGN KEY (annonce_id) REFERENCES annonce(id_annoce);


--
-- TOC entry 2177 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-04-05 01:47:56

--
-- PostgreSQL database dump complete
--

