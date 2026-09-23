drop table if exists system_org;
create table system_org
(
    id               bigint unsigned auto_increment comment '主键ID'
        primary key,
    org_code         bigint                                not null comment '编码',
    org_name         varchar(50) default ''                not null comment '名称',
    org_name_english varchar(50) default ''                not null comment '名称英文',
    org_abbreviation varchar(30) default ''                not null comment '简称',
    org_letter_code  varchar(30) default ''                not null comment '简称英文',
    sort_order       int         default 0                 not null comment '显示顺序',
    is_deleted       tinyint     default 0                 not null comment '是否删除',
    create_time      datetime    default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time      datetime    default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间'
) comment '组织表';


