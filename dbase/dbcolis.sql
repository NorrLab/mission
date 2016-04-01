
CREATE SEQUENCE public.client_id_seq;

CREATE TABLE public.client (
                id INTEGER NOT NULL DEFAULT nextval('public.client_id_seq'),
                nom VARCHAR(50) NOT NULL,
                email VARCHAR(100) NOT NULL,
                prenom VARCHAR(50) NOT NULL,
                dateNaissance DATE NOT NULL,
                telephone VARCHAR(50),
                telephone_1 BYTEA NOT NULL,
                sex BOOLEAN NOT NULL,
                code_postal VARCHAR(50) NOT NULL,
                CONSTRAINT id PRIMARY KEY (id)
);


ALTER SEQUENCE public.client_id_seq OWNED BY public.client.id;

CREATE TABLE public.messages (
                id INTEGER NOT NULL,
                date DATE NOT NULL,
                msg VARCHAR(500) NOT NULL,
                CONSTRAINT id PRIMARY KEY (id)
);


CREATE TABLE public.avis (
                id INTEGER NOT NULL,
                description VARCHAR(300),
                date DATE NOT NULL,
                CONSTRAINT id PRIMARY KEY (id)
);


CREATE TABLE public.annonce (
                id INTEGER NOT NULL,
                type_transport VARCHAR(100) NOT NULL,
                date_annonce DATE NOT NULL,
                date_annonce_1 DATE NOT NULL,
                description VARCHAR(200),
                v_depart VARCHAR(200) NOT NULL,
                v_arrivee VARCHAR(50) NOT NULL,
                v_arrivee_1 DATE NOT NULL,
                date_arrivee DATE NOT NULL,
                status BOOLEAN NOT NULL,
                CONSTRAINT id PRIMARY KEY (id)
);


CREATE TABLE public.colis (
                id INTEGER NOT NULL,
                poids DOUBLE PRECISION NOT NULL,
                prix DOUBLE PRECISION NOT NULL,
                taille VARCHAR(3) NOT NULL,
                CONSTRAINT id PRIMARY KEY (id)
);


ALTER TABLE public.annonce ADD CONSTRAINT user_annonce_fk
FOREIGN KEY (id)
REFERENCES public.client (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.avis ADD CONSTRAINT user_avis_fk
FOREIGN KEY (id)
REFERENCES public.client (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.messages ADD CONSTRAINT user_messages_fk
FOREIGN KEY (id)
REFERENCES public.client (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.colis ADD CONSTRAINT annonce_colis_fk
FOREIGN KEY (id)
REFERENCES public.annonce (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
