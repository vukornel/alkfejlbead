INSERT INTO STORAGE (id,location,size)
VALUES (1, 'Budapest', 200);

INSERT INTO BEER (id, type, origin, stored_at_id, amount)
values (1, 'Ale', 'Great Britain', 1, 30);
INSERT INTO BEER (id, type, origin, stored_at_id, amount)
values (2, 'Lager', 'Czech Republic', 1, 40);
INSERT INTO BEER (id, type, origin, stored_at_id, amount)
values (3, 'Lager', 'Germany', 1, 20);

INSERT INTO WINE (id, colors, type, stored_at_id, amount)
values (1, 'White', 'Riesling', 1, 20);
INSERT INTO WINE (id, colors, type, stored_at_id, amount)
values (2, 'Red', 'Pinot noir', 1, 15);


INSERT INTO ROLE (id, name)
values (1, 'ADMIN');

INSERT INTO ROLE (id, name)
values (2, 'USER');

INSERT INTO USERS (id, email, password, user_name)
values (1, 'admin@admin.hu', 'admin', 'admin');

INSERT INTO USERS_ROLES(user_id, role_id)
values (1,1);