-- email: cmsong111@naver.com , password: 1234
insert into user_entity (username, password, nickname)
values ('cmsong111@naver.com', '$2a$10$PdmeJs3yBaHhy6YfTF0Zze1Pw9GnxGFA7syoe/NhOmnmx1jOw43RK', '�賲��');

-- todo
insert into todo_entity (title, content, is_done, user_idx)
values ('����1', '����1 ����', false, 1),
       ('����2', '����2 ����', false, 1),
       ('����3', '����3 ����', true, 1);
