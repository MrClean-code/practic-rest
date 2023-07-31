create table practic.address (
                                 id  bigserial not null,
                                 home varchar(255),
                                 street varchar(255),
                                 primary key (id)
);

create table practic.client (
                                id  bigserial not null,
                                name varchar(255),
                                surname varchar(255),
                                address_id int8,
                                primary key (id),
                                foreign key (address_id) references practic.address
);



create table practic.menu (
                              id  bigserial not null,
                              name varchar(255),
                              price varchar(255),
                              weight varchar(255),
                              primary key (id)
);

create table practic.ingredient (
                                    id  bigserial not null,
                                    name varchar(255),
                                    menu_id int8,
                                    primary key (id),
                                    foreign key (menu_id) references practic.menu
);

create table client_menu (
                             client_id int8 not null,
                             menu_id int8 not null,
                             primary key (client_id, menu_id),
                             foreign key (menu_id) references practic.menu,
                             foreign key (client_id) references practic.client

);