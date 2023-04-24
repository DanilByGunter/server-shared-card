create table category (id integer not null auto_increment, name varchar(255) not null, primary key (id)) engine=InnoDB;
create table metric (id integer not null auto_increment, name varchar(255) not null, primary key (id)) engine=InnoDB;
create table the_all_group (id bigint not null auto_increment, name varchar(255) not null, photo tinyblob, primary key (id)) engine=InnoDB;
create table user (id bigint not null auto_increment, name varchar(255) not null, photo tinyblob, primary key (id)) engine=InnoDB;
