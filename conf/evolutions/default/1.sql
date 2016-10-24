# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table search_history (
  search_word                   varchar(255) not null,
  constraint pk_search_history primary key (search_word)
);


# --- !Downs

drop table if exists search_history;

