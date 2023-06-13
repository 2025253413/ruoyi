-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('用户和角色关联', '3', '1', '/system/role', 'C', '0', 'system:role:view', '#', 'admin', sysdate(), '', null, '用户和角色关联菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('用户和角色关联查询', @parentId, '1',  '#',  'F', '0', 'system:role:list',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('用户和角色关联新增', @parentId, '2',  '#',  'F', '0', 'system:role:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('用户和角色关联修改', @parentId, '3',  '#',  'F', '0', 'system:role:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('用户和角色关联删除', @parentId, '4',  '#',  'F', '0', 'system:role:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('用户和角色关联导出', @parentId, '5',  '#',  'F', '0', 'system:role:export',       '#', 'admin', sysdate(), '', null, '');
