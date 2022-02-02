-- drop for testing so any new app contexts that are spawned will be fresh
drop table if exists `room`;

create table `room` (
`id` long primary key auto_increment,
`name` varchar(50) NOT NULL,
`num_guests` int NOT NULL,
`num_beds` int NOT NULL,
`bathroom` varchar(50) NOT NULL,

check(`name` <> ''),
check(`num_guests` >= 1),
check(`num_beds` >= 1),
check(`bathroom` <> '')
);
