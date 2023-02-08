INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Tallinn');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Tartu');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Narva');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Pärnu');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Kohtla-Järve');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Viljandi');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Maardu');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Rakvere');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Kuressaare');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Sillamäe');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Valga');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Võru');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Jõhvi');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Keila');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Haapsalu');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Paide');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Saue');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Elva');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Tapa');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Põlva');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Türi');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Rapla');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Jõgeva');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Kiviõli');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Põltsamaa');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Sindi');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Paldiski');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Kärdla');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Kunda');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Tõrva');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Narva-Jõesuu');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Kehra');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Loksa');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Otepää');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Räpina');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Tamsalu');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Kilingi-Nõmme');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Karksi-Nuia');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Võhma');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Antsla');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Lihula');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Mustvee');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Suure-Jaani');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Abja-Paluoja');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Püssi');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Mõisaküla');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Kallaste');

INSERT INTO public.role (id, name) VALUES (DEFAULT, 'admin');
INSERT INTO public.role (id, name) VALUES (DEFAULT, 'user');

INSERT INTO public.advertisement_type (id, name) VALUES (DEFAULT, 'band');
INSERT INTO public.advertisement_type (id, name) VALUES (DEFAULT, 'member');
INSERT INTO public.advertisement_type (id, name) VALUES (DEFAULT, 'equipment');



INSERT INTO public."user" (id, username, password, email, role_id) VALUES (2, 'admin', 'admin', 'admin@admin.ee', 1);
INSERT INTO public."user" (id, username, password, email, role_id) VALUES (3, 'ain', '123', 'ain@ain.ee', 2);
INSERT INTO public."user" (id, username, password, email, role_id) VALUES (4, 'asdf', '123', 'asdf@asdf.ee', 2);

INSERT INTO public.conversation (id, datetime, subject, advertisement_id) VALUES (1, '2023-02-08 11:37:50.000000', 'asddfasdfadsf', null);
INSERT INTO public.conversation (id, datetime, subject, advertisement_id) VALUES (2, '2023-01-08 11:37:58.000000', 'Otsin kidra', null);
INSERT INTO public.conversation (id, datetime, subject, advertisement_id) VALUES (3, '2023-01-13 11:38:11.000000', 'Otsin trummarit', null);

INSERT INTO public.message (id, body, datetime, picture, status) VALUES (1, 'asdfasdfasdf', '2023-02-08 11:42:54.000000', null, 'A');
INSERT INTO public.message (id, body, datetime, picture, status) VALUES (2, 'Mul on hea kidra', '2023-02-08 11:43:41.000000', null, 'A');
INSERT INTO public.message (id, body, datetime, picture, status) VALUES (3, 'Olen trummar', '2023-02-08 11:44:06.000000', null, 'A');

INSERT INTO public.message_receiver (id, conversation_id, message_id, sender_id, receiver_id) VALUES (1, 1, 1, 4, 3);
INSERT INTO public.message_receiver (id, conversation_id, message_id, sender_id, receiver_id) VALUES (3, 2, 2, 3, 2);
INSERT INTO public.message_receiver (id, conversation_id, message_id, sender_id, receiver_id) VALUES (4, 3, 3, 4, 3);
