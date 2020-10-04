create table spring_cloud_simple.order_item
(
	id bigint auto_increment
		primary key,
	order_num varchar(20) default '' not null,
	gmt_created timestamp default CURRENT_TIMESTAMP not null,
	create_by int default 0 not null,
	gmt_modify datetime default CURRENT_TIMESTAMP not null,
	modify_by int default 0 not null,
	enabled_flag tinyint default 0 not null,
	constraint order_order_num_uindex
		unique (order_num)
);

INSERT INTO spring_cloud_simple.order_item (id, order_num, gmt_created, create_by, gmt_modify, modify_by, enabled_flag) VALUES (1, '20200101123456', '2020-09-27 16:54:24', 1, '2020-09-27 16:54:24', 1, 1);
INSERT INTO spring_cloud_simple.order_item (id, order_num, gmt_created, create_by, gmt_modify, modify_by, enabled_flag) VALUES (2, '20200101123457', '2020-10-02 22:20:46', 1, '2020-10-02 22:20:52', 1, 1);