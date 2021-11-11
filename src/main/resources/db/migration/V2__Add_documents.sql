insert into document (name, save_time, text)
    values ('расчет от 10 сентября', current_timestamp,
            'Россия и Соединенные {123} Штаты должны найти необходимые {+5.17} сферы сотрудничества, {789 } заявила на брифинге {7- } официальный {56749} представиттель госдепа Хизер {+55844} Науэрт, комментируя слова {-78914} российского премьер-министра  {0.22356} Дмитрия Медведева  об отношениях {ok} между Москвой и Васшингтоном. {4}');
insert into document_codes(document_id, code) values (1, -78914);
insert into document_codes(document_id, code) values (1, 55844);
insert into document_codes(document_id, code) values (1, 4);
insert into document_codes(document_id, code) values (1, 56749);
insert into document_codes(document_id, code) values (1, 123);

insert into document (name, save_time, text)
    values ('срочно к оплате', current_timestamp,
            '{123} Штаты должны найти необходимые {2021} заявила на брифинге {7- } официальный {-900} представиттель госдепа Хизер {+55844} Науэрт, комментируя слова {-78914} российского {-80001} премьер-министра  {0.22356} Дмитрия Медведева об отношениях {ok} между Москвой и Васшингтоном. {4}');
insert into document_codes(document_id, code) values (2, -78914);
insert into document_codes(document_id, code) values (2, -80001);
insert into document_codes(document_id, code) values (2, 4);
insert into document_codes(document_id, code) values (2, -900);
insert into document_codes(document_id, code) values (2, 2021);
insert into document_codes(document_id, code) values (2, 123);

insert into document (name, save_time, text)
    values ('срочно к оплате2', current_timestamp,
            'Some text {19} add more text {+100500}  {-127} {helloWorld}');
insert into document_codes(document_id, code) values (3, 19);
insert into document_codes(document_id, code) values (3, 100500);
insert into document_codes(document_id, code) values (3, -127);




