--
-- PostgreSQL database dump
--

-- Dumped from database version 11.6
-- Dumped by pg_dump version 11.6

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

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: abbonamenti; Type: TABLE; Schema: public; Owner: golden
--

CREATE TABLE public.abbonamenti (
    id integer NOT NULL,
    name character varying(255) NOT NULL,
    "desc" character varying NOT NULL,
    price double precision NOT NULL
);


ALTER TABLE public.abbonamenti OWNER TO golden;

--
-- Name: sottoscrizioni; Type: TABLE; Schema: public; Owner: golden
--

CREATE TABLE public.sottoscrizioni (
    id bigint NOT NULL,
    user_id integer NOT NULL,
    abbonamento_id integer NOT NULL,
    due_date character varying(100)
);


ALTER TABLE public.sottoscrizioni OWNER TO golden;

--
-- Name: sottoscrizioni_id_seq; Type: SEQUENCE; Schema: public; Owner: golden
--

CREATE SEQUENCE public.sottoscrizioni_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sottoscrizioni_id_seq OWNER TO golden;

--
-- Name: sottoscrizioni_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: golden
--

ALTER SEQUENCE public.sottoscrizioni_id_seq OWNED BY public.sottoscrizioni.id;


--
-- Name: sub-type_id_seq; Type: SEQUENCE; Schema: public; Owner: golden
--

CREATE SEQUENCE public."sub-type_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."sub-type_id_seq" OWNER TO golden;

--
-- Name: sub-type_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: golden
--

ALTER SEQUENCE public."sub-type_id_seq" OWNED BY public.abbonamenti.id;


--
-- Name: utenti; Type: TABLE; Schema: public; Owner: golden
--

CREATE TABLE public.utenti (
    id integer NOT NULL,
    username character varying(255) NOT NULL,
    hash character varying(255) NOT NULL,
    ruolo character varying
);


ALTER TABLE public.utenti OWNER TO golden;

--
-- Name: utenti_id_seq; Type: SEQUENCE; Schema: public; Owner: golden
--

CREATE SEQUENCE public.utenti_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.utenti_id_seq OWNER TO golden;

--
-- Name: utenti_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: golden
--

ALTER SEQUENCE public.utenti_id_seq OWNED BY public.utenti.id;


--
-- Name: video; Type: TABLE; Schema: public; Owner: golden
--

CREATE TABLE public.video (
    id integer NOT NULL,
    name character varying(255) NOT NULL,
    link character varying NOT NULL
);


ALTER TABLE public.video OWNER TO golden;

--
-- Name: video_id_seq; Type: SEQUENCE; Schema: public; Owner: golden
--

CREATE SEQUENCE public.video_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.video_id_seq OWNER TO golden;

--
-- Name: video_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: golden
--

ALTER SEQUENCE public.video_id_seq OWNED BY public.video.id;


--
-- Name: abbonamenti id; Type: DEFAULT; Schema: public; Owner: golden
--

ALTER TABLE ONLY public.abbonamenti ALTER COLUMN id SET DEFAULT nextval('public."sub-type_id_seq"'::regclass);


--
-- Name: sottoscrizioni id; Type: DEFAULT; Schema: public; Owner: golden
--

ALTER TABLE ONLY public.sottoscrizioni ALTER COLUMN id SET DEFAULT nextval('public.sottoscrizioni_id_seq'::regclass);


--
-- Name: utenti id; Type: DEFAULT; Schema: public; Owner: golden
--

ALTER TABLE ONLY public.utenti ALTER COLUMN id SET DEFAULT nextval('public.utenti_id_seq'::regclass);


--
-- Name: video id; Type: DEFAULT; Schema: public; Owner: golden
--

ALTER TABLE ONLY public.video ALTER COLUMN id SET DEFAULT nextval('public.video_id_seq'::regclass);


--
-- Data for Name: abbonamenti; Type: TABLE DATA; Schema: public; Owner: golden
--

COPY public.abbonamenti (id, name, "desc", price) FROM stdin;
1	Basic	Aliquam ullamcorper purus id sapien sollicitudin maximus. Nullam laoreet arcu eget volutpat finibus. Sed felis magna, bibendum a cursus sed, rutrum nec lacus. Integer ac mi auctor, elementum metus vitae, feugiat nunc.	7.99000000000000021
2	Normal	Mauris blandit elit sit amet dolor faucibus consectetur. Etiam tempor, augue a aliquam feugiat, ante magna vehicula odio, id porta nibh nibh id nisl. Praesent sagittis felis nibh. 	10.9900000000000002
3	Full	Proin sem enim, bibendum accumsan ornare gravida, scelerisque at quam. Proin viverra pretium hendrerit. Quisque eu elementum enim, quis lobortis justo. 	13.9900000000000002
\.


--
-- Data for Name: sottoscrizioni; Type: TABLE DATA; Schema: public; Owner: golden
--

COPY public.sottoscrizioni (id, user_id, abbonamento_id, due_date) FROM stdin;
1	3	2	2020/02/20
2	1	3	domani
3	1	2	Testazzo
4	1	2	
5	1	2	
6	1	3	
7	1	2	
8	1	2	
9	1	2	
10	1	2	
11	1	2	
12	1	2	
13	1	3	
14	1	3	
15	1	3	
16	1	3	
17	1	3	
18	1	3	
19	1	3	
20	1	3	
\.


--
-- Data for Name: utenti; Type: TABLE DATA; Schema: public; Owner: golden
--

COPY public.utenti (id, username, hash, ruolo) FROM stdin;
1	p	83878C91171338902E0FE0FB97A8C47A	user
2	g	B2F5FF47436671B6E533D8DC3614845D	admin
\.


--
-- Data for Name: video; Type: TABLE DATA; Schema: public; Owner: golden
--

COPY public.video (id, name, link) FROM stdin;
\.


--
-- Name: sottoscrizioni_id_seq; Type: SEQUENCE SET; Schema: public; Owner: golden
--

SELECT pg_catalog.setval('public.sottoscrizioni_id_seq', 20, true);


--
-- Name: sub-type_id_seq; Type: SEQUENCE SET; Schema: public; Owner: golden
--

SELECT pg_catalog.setval('public."sub-type_id_seq"', 3, true);


--
-- Name: utenti_id_seq; Type: SEQUENCE SET; Schema: public; Owner: golden
--

SELECT pg_catalog.setval('public.utenti_id_seq', 2, true);


--
-- Name: video_id_seq; Type: SEQUENCE SET; Schema: public; Owner: golden
--

SELECT pg_catalog.setval('public.video_id_seq', 1, false);


--
-- Name: sottoscrizioni sottoscrizioni_pkey; Type: CONSTRAINT; Schema: public; Owner: golden
--

ALTER TABLE ONLY public.sottoscrizioni
    ADD CONSTRAINT sottoscrizioni_pkey PRIMARY KEY (id);


--
-- Name: abbonamenti sub-type_pkey; Type: CONSTRAINT; Schema: public; Owner: golden
--

ALTER TABLE ONLY public.abbonamenti
    ADD CONSTRAINT "sub-type_pkey" PRIMARY KEY (id);


--
-- Name: utenti utenti_pkey; Type: CONSTRAINT; Schema: public; Owner: golden
--

ALTER TABLE ONLY public.utenti
    ADD CONSTRAINT utenti_pkey PRIMARY KEY (username);


--
-- Name: video video_pkey; Type: CONSTRAINT; Schema: public; Owner: golden
--

ALTER TABLE ONLY public.video
    ADD CONSTRAINT video_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

