# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table search_history (
  search_id                     bigint not null,
  search_word                   varchar(255),
  constraint pk_search_history primary key (search_id)
);
create sequence search_history_seq;


# --- !Downs

drop table if exists search_history;
drop sequence if exists search_history_seq;

