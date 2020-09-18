use ib

INSERT INTO user (id,username,pass,enabled,email) VALUES (1,"user1","$2a$10$NyaltQLE9xiwjHb9EdNFW.J8DvXrfr0wKKPXDwXzA4Cj6epBhBXou",true,"milutin@gmail.com");

INSERT INTO user (id,username,pass,enabled,email) VALUES (2,"user","$2a$10$NyaltQLE9xiwjHb9EdNFW.J8DvXrfr0wKKPXDwXzA4Cj6epBhBXou",true,"marko@gmail.com");
INSERT INTO Authority (authority_id,authority) VALUES (1,"Admin");
INSERT INTO Authority (authority_id,authority) VALUES (2,"Regular");
INSERT INTO authorities_users (id, authority_id) VALUES (1,1);
INSERT INTO authorities_users (id, authority_id) VALUES (1,2);
INSERT INTO authorities_users (id, authority_id) VALUES (2,2);

  

