-- email: cmsong111@naver.com , password: 1234
insert into users (username, password, nickname, role)
values ('cmsong111@naver.com', '$2a$10$PdmeJs3yBaHhy6YfTF0Zze1Pw9GnxGFA7syoe/NhOmnmx1jOw43RK', '김남주', 'USER');

-- todo
insert into todo (title, content, is_done, user_id)
values ('할일1', '할일1 내용', false, 1),
       ('할일2', '할일2 내용', false, 1),
       ('할일3', '할일3 내용', true, 1),
       ('할일3', '할일3 내용', true, 1),
       ('할일3', '할일3 내용', true, 1),
       ('할일3', '할일3 내용', true, 1),
       ('할일3', '할일3 내용', true, 1),
       ('할일3', '할일3 내용', true, 1),
       ('할일3', '할일3 내용', true, 1),
       ('할일3', '할일3 내용', true, 1),
       ('할일3', '할일3 내용', true, 1),
       ('할일5', '할일3 내용', true, 1),
       ('할일101', '할일3 내용', true, 1);
