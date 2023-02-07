-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-02-07 07:44:42.943

-- tables
-- Table: advertisement
CREATE TABLE advertisement (
                               id serial  NOT NULL,
                               user_id int  NOT NULL,
                               header varchar(255)  NOT NULL,
                               body varchar(1000)  NOT NULL,
                               type_id int  NOT NULL,
                               city_id int  NOT NULL,
                               created_timestamp timestamp  NOT NULL,
                               edited_timestamp timestamp  NOT NULL,
                               status char(1)  NOT NULL,
                               picture bytea  NULL,
                               CONSTRAINT advertisement_pk PRIMARY KEY (id)
);

-- Table: advertisement_type
CREATE TABLE advertisement_type (
                                    id serial  NOT NULL,
                                    name varchar(20)  NOT NULL,
                                    CONSTRAINT advertisement_type_pk PRIMARY KEY (id)
);

-- Table: city
CREATE TABLE city (
                      id serial  NOT NULL,
                      name varchar(20)  NOT NULL,
                      CONSTRAINT city_pk PRIMARY KEY (id)
);

-- Table: conversation
CREATE TABLE conversation (
                              id serial  NOT NULL,
                              datetime timestamp  NOT NULL,
                              subject varchar(255)  NOT NULL,
                              advertisement_id int  NOT NULL,
                              CONSTRAINT conversation_pk PRIMARY KEY (id)
);

-- Table: message
CREATE TABLE message (
                         id serial  NOT NULL,
                         body text  NOT NULL,
                         datetime timestamp  NOT NULL,
                         picture bytea  NULL,
                         status char(1)  NOT NULL,
                         CONSTRAINT message_pk PRIMARY KEY (id)
);

-- Table: message_receiver
CREATE TABLE message_receiver (
                                  id serial  NOT NULL,
                                  conversation_id int  NOT NULL,
                                  message_id int  NOT NULL,
                                  sender_id int  NOT NULL,
                                  receiver_id int  NOT NULL,
                                  CONSTRAINT message_receiver_pk PRIMARY KEY (id)
);

-- Table: role
CREATE TABLE role (
                      id serial  NOT NULL,
                      name varchar(20)  NOT NULL,
                      CONSTRAINT role_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user" (
                        id serial  NOT NULL,
                        username varchar(255)  NULL,
                        password varchar(255)  NULL,
                        email varchar(255)  NOT NULL,
                        role_id int  NOT NULL,
                        CONSTRAINT user_ak_1 UNIQUE (username) NOT DEFERRABLE  INITIALLY IMMEDIATE,
                        CONSTRAINT user_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: ad_ad_type (table: advertisement)
ALTER TABLE advertisement ADD CONSTRAINT ad_ad_type
    FOREIGN KEY (type_id)
        REFERENCES advertisement_type (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: ad_city (table: advertisement)
ALTER TABLE advertisement ADD CONSTRAINT ad_city
    FOREIGN KEY (city_id)
        REFERENCES city (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: ad_user (table: advertisement)
ALTER TABLE advertisement ADD CONSTRAINT ad_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: conversation_advertisement (table: conversation)
ALTER TABLE conversation ADD CONSTRAINT conversation_advertisement
    FOREIGN KEY (advertisement_id)
        REFERENCES advertisement (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: message_receiver_conversation (table: message_receiver)
ALTER TABLE message_receiver ADD CONSTRAINT message_receiver_conversation
    FOREIGN KEY (conversation_id)
        REFERENCES conversation (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: message_sender_user (table: message_receiver)
ALTER TABLE message_receiver ADD CONSTRAINT message_sender_user
    FOREIGN KEY (receiver_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: message_user_message (table: message_receiver)
ALTER TABLE message_receiver ADD CONSTRAINT message_user_message
    FOREIGN KEY (message_id)
        REFERENCES message (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: message_user_user (table: message_receiver)
ALTER TABLE message_receiver ADD CONSTRAINT message_user_user
    FOREIGN KEY (sender_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: user_role (table: user)
ALTER TABLE "user" ADD CONSTRAINT user_role
    FOREIGN KEY (role_id)
        REFERENCES role (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- End of file.

