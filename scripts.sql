CREATE TABLE `courses` (
                           `course_name` varchar(255) NOT NULL COMMENT '课程名称',
                           `page_num` varchar(255) NOT NULL COMMENT '第几集',
                           `title` varchar(100) NOT NULL COMMENT '本集名称',
                           `duration` varchar(50) NOT NULL COMMENT '时长非格式化',
                           `minutes` int NOT NULL DEFAULT '0' COMMENT '时长分钟',
                           `href` varchar(50) NOT NULL COMMENT '本集url地址',
                           `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT COMMENT='B站课程目录集'

CREATE TABLE `account` (
                           `id` varchar(255) NOT NULL COMMENT 'id',
                           `name` varchar(255) NOT NULL COMMENT '姓名',
                           `money` int NOT NULL DEFAULT '0' COMMENT '财富值'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT COMMENT='事务-转账测试';

insert into account (id, name, money) VALUES ('1','张三',1000),('2','李四',1000);
