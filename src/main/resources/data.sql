insert into User (username, encryptedpassword, enabled)
values('Jon', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1 );

insert into User (username, encryptedpassword, enabled)
values('Yash', '$2a$10$hIYLtzqthyMNzxP.whmUFef1VNmgbszxA8XrZv95CeF2fh4QIg8Ui', 1 ),
('Kashyap', '$2a$10$d5QDyH.8ajK1nttNIXTDWecTEWMw2eLJav/BJrOCD9XrRK1.Xzy1S', 1 ),
('Smit', '$2a$10$EMpEu.CV6ywGcrUCJ5GRoubzfrsGAhe7xN2jobnBpHGM1rcfZxlPW', 1 ),
('Meet', '$2a$10$Nel7GtoG61A2rFzk3MP2LudYOq1riwkrrxkQSRskXDNSPnAcsIvHi', 1 ),
('Deep', '$2a$10$cqawv.iO6ZByUjc6It4Dgu2LKD.9Qi6V./U0x.bTi.1pn17xn3.b.', 1 ),
('Rocky', '$2a$10$mLbkn24NwFtWSlArS7z.E.mO75gNU20QtghX9x6fPDcMnO9TtWC9a', 1 ),
('Harsh', '$2a$10$yB4ktzGW92tPeG0sZb9LN.k7vpD0WgeBkb5uAWqLErGEcVrD4sdBW', 1 ),
('Pratik', '$2a$10$Z2upVosZ9vsl0SoHOVihr.ObhUffRFo.k4gCJbU04p.xKp/KQ0fke', 1 ),
('Kishan', '$2a$10$eJYtZdaJOybaCZLfGvz2L.fKIaxrgoRT4oDdCLcFWMC37vilmETT.', 1 ),
('Kirtan', '$2a$10$wWxV4Zl2DxcAmUM.lEVupO8p.Uc70yHvmo36LgRPxYsGK9Ptnw7qK', 1 );



insert into Student(Name,Studentid,Exercises,Assignment1,Assignment2,Midterm,Finalexam,Finalproject)
values('Yash','991510991',9,4,5,25,29,14);

insert into Student(Name,Studentid,Exercises,Assignment1,Assignment2,Midterm,Finalexam,Finalproject)
values('Kashyap','991510922',9,4,5,25,29,14);

insert into Student(Name,Studentid,Exercises,Assignment1,Assignment2,Midterm,Finalexam,Finalproject)
values('Smit','991510932',9,4,5,25,29,14);

insert into Student(Name,Studentid,Exercises,Assignment1,Assignment2,Midterm,Finalexam,Finalproject)
values('Meet','991510432',9,4,5,23,20,10);

insert into Student(Name,Studentid,Exercises,Assignment1,Assignment2,Midterm,Finalexam,Finalproject)
values('Deep','991510345',10,5,5,30,35,15);

insert into Student(Name,Studentid,Exercises,Assignment1,Assignment2,Midterm,Finalexam,Finalproject)
values('Rocky','99153456',5,4,0,15,15,10);

insert into Student(Name,Studentid,Exercises,Assignment1,Assignment2,Midterm,Finalexam,Finalproject)
values('Harsh','991512345',9,2,4,18,39,12);

insert into Student(Name,Studentid,Exercises,Assignment1,Assignment2,Midterm,Finalexam,Finalproject)
values('Pratik','991514322',5,5,5,20,19,10);

insert into Student(Name,Studentid,Exercises,Assignment1,Assignment2,Midterm,Finalexam,Finalproject)
values('Kishan','991534592',9,4,5,10,0,10);

insert into Student(Name,Studentid,Exercises,Assignment1,Assignment2,Midterm,Finalexam,Finalproject)
values('Kirtan','991523452',9,4,5,25,29,14);

insert into Role(rolename)
values('ROLE_PROF');


insert into Role(rolename)
values('ROLE_STUDENT');


insert into user_roles(users_id,roles_id)
values(1,1);

insert into user_roles(users_id,roles_id)
values(2,2),
(3,2),
(4,2),
(5,2),
(6,2),
(7,2),
(8,2),
(9,2),
(10,2),
(11,2);
