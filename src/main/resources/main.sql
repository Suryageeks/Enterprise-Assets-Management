-- branch_details: table
CREATE TABLE `branch_details` (
                                  `id` bigint NOT NULL AUTO_INCREMENT,
                                  `branch_name` varchar(50) NOT NULL,
                                  `branch_type` varchar(50) NOT NULL,
                                  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                  `sol_id` varchar(30) NOT NULL,
                                  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                  PRIMARY KEY (`id`),
                                  UNIQUE KEY `UKf5j383hmvi6blu3vney79k57u` (`sol_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- users: table
CREATE TABLE `users` (
                         `id` bigint NOT NULL AUTO_INCREMENT,
                         `address` varchar(300) NOT NULL,
                         `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                         `designation` varchar(50) NOT NULL,
                         `district` varchar(50) NOT NULL,
                         `emp_id` varchar(100) NOT NULL,
                         `emp_name` varchar(300) NOT NULL,
                         `mobile_number` int NOT NULL,
                         `state` varchar(50) NOT NULL,
                         `status` enum('ACTIVE','INACTIVE') NOT NULL,
                         `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                         PRIMARY KEY (`id`),
                         UNIQUE KEY `UK39smkrxk7iywhmw463bgxc0a` (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- roles: table
CREATE TABLE `roles` (
                         `role_id` bigint NOT NULL AUTO_INCREMENT,
                         `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                         `role_name` varchar(50) NOT NULL,
                         `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                         PRIMARY KEY (`role_id`),
                         UNIQUE KEY `UK716hgxp60ym1lifrdgp67xt5k` (`role_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- user_role_sol_mapper: table
CREATE TABLE `user_role_sol_mapper` (
                                        `id` bigint NOT NULL AUTO_INCREMENT,
                                        `branch_name` varchar(50) NOT NULL,
                                        `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                        `emp_name` varchar(300) NOT NULL,
                                        `role_name` varchar(50) NOT NULL,
                                        `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                        `sol_id` varchar(30) NOT NULL,
                                        `role_id` bigint NOT NULL,
                                        `emp_id` varchar(100) NOT NULL,
                                        PRIMARY KEY (`id`),
                                        UNIQUE KEY `UKmtqbaxi3d700iryt7grynslxn` (`role_name`),
                                        KEY `FKnv6na7t4dk7p22e2neo66iow8` (`role_id`),
                                        KEY `FKcdfqifw8l6daq2egj6xg7nv6j` (`emp_id`),
                                        KEY `FKqpv74r7139vxmi7ohq7w5gp38` (`sol_id`),
                                        CONSTRAINT `FKcdfqifw8l6daq2egj6xg7nv6j` FOREIGN KEY (`emp_id`) REFERENCES `users` (`emp_id`),
                                        CONSTRAINT `FKnv6na7t4dk7p22e2neo66iow8` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`),
                                        CONSTRAINT `FKqpv74r7139vxmi7ohq7w5gp38` FOREIGN KEY (`sol_id`) REFERENCES `branch_details` (`sol_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

