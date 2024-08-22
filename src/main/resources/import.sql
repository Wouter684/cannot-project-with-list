
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

insert into myrelatedentity (id, relatedField, my_entity_id) values(1, 'related-1-field-1', 1);
insert into myrelatedentity (id, relatedField, my_entity_id) values(2, 'related-1-field-2', 1);
insert into myrelatedentity (id, relatedField, my_entity_id) values(3, 'related-2-field-1', 2);
insert into myrelatedentity (id, relatedField, my_entity_id) values(4, 'related-2-field-2', 2);
insert into myrelatedentity (id, relatedField, my_entity_id) values(5, 'related-3-field-1', 3);
insert into myrelatedentity (id, relatedField, my_entity_id) values(6, 'related-3-field-2', 3);

alter sequence myrelatedentity_seq restart with 4;