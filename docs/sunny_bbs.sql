/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2014-6-17 10:46:29                           */
/*==============================================================*/


drop table if exists sunny_forum;

drop table if exists sunny_response;

drop table if exists sunny_topic;

drop table if exists sunny_user;

/*==============================================================*/
/* Table: sunny_forum                                           */
/*==============================================================*/
create table sunny_forum
(
   id                   int not null,
   forumname            varchar(20),
   manager              varchar(50),
   createtime           timestamp,
   primary key (id)
);

/*==============================================================*/
/* Table: sunny_response                                        */
/*==============================================================*/
create table sunny_response
(
   id                   int not null,
   title                varchar(300),
   content              text,
   author               varchar(20),
   submittime           timestamp,
   topicid              int,
   topicname            varchar(50),
   xq                   varchar(20),
   primary key (id)
);

/*==============================================================*/
/* Table: sunny_topic                                           */
/*==============================================================*/
create table sunny_topic
(
   id                   int not null,
   content              text,
   author               varchar(20),
   submittime           timestamp,
   forumid              int,
   title                varchar(300),
   xq                   varchar(30),
   forumname            varchar(20),
   rq                   int,
   primary key (id)
);

/*==============================================================*/
/* Table: sunny_user                                            */
/*==============================================================*/
create table sunny_user
(
   id                   int not null,
   username             varchar(20),
   password             varchar(20),
   sex                  varchar(2),
   email                varchar(50),
   oicq                 varchar(20),
   signature            varchar(300),
   grade                varchar(20),
   lxdz                 varchar(50),
   tx                   varchar(30),
   grzy                 varchar(50),
   realname             varchar(30),
   primary key (id)
);

