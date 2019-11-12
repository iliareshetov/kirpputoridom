create table home_page_card
(
    id serial not null
        constraint home_page_card_pk
            primary key,
    amount text not null,
    description text not null,
    title text not null
);

-- check that user name is correct
-- alter table appointment owner to uxzaupesynjrvs;

create unique index home_page_card_id_uindex
    on home_page_card (id);

