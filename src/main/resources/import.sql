
insert into myentity (id, field, foo) values(1, 'field-1', 'foo-1');
insert into myentity (id, field, foo) values(2, 'field-2', 'foo-2');
insert into myentity (id, field, foo) values(3, 'field-3', 'foo-3');

alter sequence myentity_seq restart with 4;

insert into my_collection (collection_item, my_entity_id) values ('item1', 1);
insert into my_collection (collection_item, my_entity_id) values ('item2', 1);
insert into my_collection (collection_item, my_entity_id) values ('item3', 1);
insert into my_collection (collection_item, my_entity_id) values ('item4', 2);
insert into my_collection (collection_item, my_entity_id) values ('item5', 2);
insert into my_collection (collection_item, my_entity_id) values ('item6', 2);
insert into my_collection (collection_item, my_entity_id) values ('item7', 3);
insert into my_collection (collection_item, my_entity_id) values ('item8', 3);
insert into my_collection (collection_item, my_entity_id) values ('item9', 3);