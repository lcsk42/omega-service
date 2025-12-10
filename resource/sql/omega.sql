drop table if exists system_department;
create table system_department
(
    id           bigint unsigned auto_increment                                        not null comment '主键ID',
    parent_id    bigint unsigned default 0                                             not null comment '父部门id',
    ancestors    varchar(50) default ''                not null comment '祖级列表',
    name         varchar(30) default ''                not null comment '名称',
    abbreviation varchar(30) default ''                not null comment '简称',
    code         varchar(10) default ''                not null comment '编码',
    level        smallint    default 0                 not null comment '层级',
    sort_order   int         default 0                 not null comment '显示顺序',
    is_deleted   tinyint     default 0                 not null comment '是否删除',
    create_time  datetime    default current_timestamp not null comment '创建时间',
    update_time  datetime    default current_timestamp on update current_timestamp not null comment '更新时间',
    primary key (id)
) comment = "部门表";

INSERT INTO system_department(id, parent_id, ancestors, name, abbreviation, code, level, sort_order)
VALUES (1, 0, '1', '总公司', '总', 'A', 1, 1);

INSERT INTO system_department(id, parent_id, ancestors, name, abbreviation, code, level, sort_order)
VALUES (11, 1, '1,11', '北京分公司', '京', 'BJ', 2, 11);
INSERT INTO system_department(id, parent_id, ancestors, name, abbreviation, code, level, sort_order)
VALUES (12, 1, '1,12', '天津分公司', '津', 'TJ', 2, 12);
INSERT INTO system_department(id, parent_id, ancestors, name, abbreviation, code, level, sort_order)
VALUES (13, 1, '1,13', '河北分公司', '冀', 'HE', 2, 13);
INSERT INTO system_department(id, parent_id, ancestors, name, abbreviation, code, level, sort_order)
VALUES (14, 1, '1,14', '山西分公司', '晋', 'SX', 2, 14);
INSERT INTO system_department(id, parent_id, ancestors, name, abbreviation, code, level, sort_order)
VALUES (15, 1, '1,15', '内蒙古分公司', '蒙', 'NM', 2, 15);
INSERT INTO system_department(id, parent_id, ancestors, name, abbreviation, code, level, sort_order)
VALUES (21, 1, '1,21', '辽宁分公司', '辽', 'LN', 2, 21);
INSERT INTO system_department(id, parent_id, ancestors, name, abbreviation, code, level, sort_order)
VALUES (22, 1, '1,22', '吉林分公司', '吉', 'JL', 2, 22);
INSERT INTO system_department(id, parent_id, ancestors, name, abbreviation, code, level, sort_order)
VALUES (23, 1, '1,23', '黑龙江分公司', '黑', 'HL', 2, 23);
INSERT INTO system_department(id, parent_id, ancestors, name, abbreviation, code, level, sort_order)
VALUES (31, 1, '1,31', '上海分公司', '沪', 'SH', 2, 31);
INSERT INTO system_department(id, parent_id, ancestors, name, abbreviation, code, level, sort_order)
VALUES (32, 1, '1,32', '江苏分公司', '苏', 'JS', 2, 32);
INSERT INTO system_department(id, parent_id, ancestors, name, abbreviation, code, level, sort_order)
VALUES (33, 1, '1,33', '浙江分公司', '浙', 'ZJ', 2, 33);
INSERT INTO system_department(id, parent_id, ancestors, name, abbreviation, code, level, sort_order)
VALUES (34, 1, '1,34', '安徽分公司', '皖', 'AH', 2, 34);
INSERT INTO system_department(id, parent_id, ancestors, name, abbreviation, code, level, sort_order)
VALUES (35, 1, '1,35', '福建分公司', '闽', 'FJ', 2, 35);
INSERT INTO system_department(id, parent_id, ancestors, name, abbreviation, code, level, sort_order)
VALUES (36, 1, '1,36', '江西分公司', '赣', 'JX', 2, 36);
INSERT INTO system_department(id, parent_id, ancestors, name, abbreviation, code, level, sort_order)
VALUES (37, 1, '1,37', '山东分公司', '鲁', 'SD', 2, 37);
INSERT INTO system_department(id, parent_id, ancestors, name, abbreviation, code, level, sort_order)
VALUES (41, 1, '1,41', '河南分公司', '豫', 'HA', 2, 41);
INSERT INTO system_department(id, parent_id, ancestors, name, abbreviation, code, level, sort_order)
VALUES (42, 1, '1,42', '湖北分公司', '鄂', 'HB', 2, 42);
INSERT INTO system_department(id, parent_id, ancestors, name, abbreviation, code, level, sort_order)
VALUES (43, 1, '1,43', '湖南分公司', '湘', 'HN', 2, 43);
INSERT INTO system_department(id, parent_id, ancestors, name, abbreviation, code, level, sort_order)
VALUES (44, 1, '1,44', '广东分公司', '粤', 'GD', 2, 44);
INSERT INTO system_department(id, parent_id, ancestors, name, abbreviation, code, level, sort_order)
VALUES (45, 1, '1,45', '广西分公司', '桂', 'GX', 2, 45);
INSERT INTO system_department(id, parent_id, ancestors, name, abbreviation, code, level, sort_order)
VALUES (46, 1, '1,46', '海南分公司', '琼', 'HI', 2, 46);
INSERT INTO system_department(id, parent_id, ancestors, name, abbreviation, code, level, sort_order)
VALUES (50, 1, '1,50', '重庆分公司', '渝', 'CQ', 2, 50);
INSERT INTO system_department(id, parent_id, ancestors, name, abbreviation, code, level, sort_order)
VALUES (51, 1, '1,51', '四川分公司', '川', 'SC', 2, 51);
INSERT INTO system_department(id, parent_id, ancestors, name, abbreviation, code, level, sort_order)
VALUES (52, 1, '1,52', '贵州分公司', '黔', 'GZ', 2, 52);
INSERT INTO system_department(id, parent_id, ancestors, name, abbreviation, code, level, sort_order)
VALUES (53, 1, '1,53', '云南分公司', '滇', 'YN', 2, 53);
INSERT INTO system_department(id, parent_id, ancestors, name, abbreviation, code, level, sort_order)
VALUES (54, 1, '1,54', '西藏分公司', '藏', 'XZ', 2, 54);
INSERT INTO system_department(id, parent_id, ancestors, name, abbreviation, code, level, sort_order)
VALUES (61, 1, '1,61', '陕西分公司', '陕', 'SN', 2, 61);
INSERT INTO system_department(id, parent_id, ancestors, name, abbreviation, code, level, sort_order)
VALUES (62, 1, '1,62', '甘肃分公司', '甘', 'GS', 2, 62);
INSERT INTO system_department(id, parent_id, ancestors, name, abbreviation, code, level, sort_order)
VALUES (63, 1, '1,63', '青海分公司', '青', 'QH', 2, 63);
INSERT INTO system_department(id, parent_id, ancestors, name, abbreviation, code, level, sort_order)
VALUES (64, 1, '1,64', '宁夏分公司', '宁', 'NX', 2, 64);
INSERT INTO system_department(id, parent_id, ancestors, name, abbreviation, code, level, sort_order)
VALUES (65, 1, '1,65', '新疆分公司', '新', 'XJ', 2, 65);
INSERT INTO system_department(id, parent_id, ancestors, name, abbreviation, code, level, sort_order)
VALUES (71, 1, '1,71', '台湾分公司', '台', 'TW', 2, 71);
INSERT INTO system_department(id, parent_id, ancestors, name, abbreviation, code, level, sort_order)
VALUES (81, 1, '1,81', '香港分公司', '港', 'HK', 2, 81);
INSERT INTO system_department(id, parent_id, ancestors, name, abbreviation, code, level, sort_order)
VALUES (82, 1, '1,82', '澳门分公司', '澳', 'MO', 2, 82);

drop table if exists system_user;
create table system_user
(
    id                        bigint unsigned auto_increment                                     not null comment '主键ID',
    department_id             bigint       default null comment '部门ID',
    username                  varchar(30)  default '' comment '用户昵称',
    email                     varchar(50)  default '' comment '用户邮箱',
    mobile                     varchar(11)  default '' comment '手机号码',
    gender                    char(1)      default 'U' comment '用户性别 M=男, F=女, O=其他, U=未知',
    avatar                    varchar(100) default '' comment '头像路径',
    password                  varchar(50)                            not null comment '密码',
    salt                      varchar(24)                            not null comment '盐加密',
    is_internal               tinyint      default '1' comment '用户类型（1系统用户,0注册用户）',
    is_disabled               tinyint      default '0' comment '账号状态（0正常 1停用）',
    last_password_update_time datetime comment '密码最后更新时间',
    is_deleted                tinyint      default 0                 not null comment '是否删除',
    create_time               datetime     default current_timestamp not null comment '创建时间',
    update_time               datetime     default current_timestamp on update current_timestamp not null comment '更新时间',
    primary key (id)
) engine = innodb
  auto_increment = 100 comment = '用户信息表';
insert into system_user(id, department_id, username, email, mobile, gender, avatar, password, salt)
values (1, 1, 'admin', 'admin@omega.com', '18800000001', 'U', '', 'T5TQTJOzhuKhXM9GZd1QrCnlnc5OUPtOrNR+uxaKfK8=',
        'uRD99xLNHvbiV8k5mj+1Tg==')

