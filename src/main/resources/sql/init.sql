-- MySQL Script generated by MySQL Workbench
-- 01/28/16 19:59:06
-- Model: New Model    Version: 1.0
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema rxb_res
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `rxb_res` DEFAULT CHARACTER SET utf8 ;
USE `rxb_res` ;

-- -----------------------------------------------------
-- Table `rxb_res`.`t_res_user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rxb_res`.`t_res_user` ;

CREATE TABLE IF NOT EXISTS `rxb_res`.`t_res_user` (
  `id` VARCHAR(32) NOT NULL DEFAULT '',
  `name` VARCHAR(32) NOT NULL COMMENT '用户名',
  `password` VARCHAR(32) NOT NULL COMMENT '密码',
  `real_name` VARCHAR(32) NULL COMMENT '真实姓名',
  `gender` INT(1) NULL COMMENT '性别',
  `mobile_phone` VARCHAR(20) NULL COMMENT '手机号',
  `email` VARCHAR(64) NULL COMMENT '邮箱',
  `salt` VARCHAR(16) NULL COMMENT '盐',
  `locked` TINYINT(1) NULL DEFAULT 0 COMMENT '是否锁定',
  `register_date` DATETIME NULL COMMENT '注册时间',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`name` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `rxb_res`.`t_res_permission`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rxb_res`.`t_res_permission` ;

CREATE TABLE IF NOT EXISTS `rxb_res`.`t_res_permission` (
  `id` VARCHAR(32) NOT NULL COMMENT '权限表',
  `url` VARCHAR(45) NULL COMMENT '权限地址',
  `name` VARCHAR(45) NOT NULL COMMENT '权限名称',
  `per_type` INT(4) NULL COMMENT '类型',
  `parent_id` VARCHAR(45) NULL COMMENT '父节点id',
  `visible` TINYINT(1) NULL DEFAULT 1 COMMENT '是否可见，默认可见',
  `remark` VARCHAR(128) NULL COMMENT '描述',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `url_UNIQUE` (`url` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rxb_res`.`t_res_role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rxb_res`.`t_res_role` ;

CREATE TABLE IF NOT EXISTS `rxb_res`.`t_res_role` (
  `id` VARCHAR(32) NOT NULL,
  `name` VARCHAR(32) NOT NULL COMMENT '角色名',
  `code` VARCHAR(8) NOT NULL COMMENT '角色代码',
  `remark` VARCHAR(128) NULL COMMENT '角色描述',
  `role_type` INT(4) NULL COMMENT '类型',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC),
  UNIQUE INDEX `code_UNIQUE` (`code` ASC))
ENGINE = InnoDB
COMMENT = '角色表';


-- -----------------------------------------------------
-- Table `rxb_res`.`t_res_user_role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rxb_res`.`t_res_user_role` ;

CREATE TABLE IF NOT EXISTS `rxb_res`.`t_res_user_role` (
  `user_id` VARCHAR(32) NOT NULL COMMENT '用户id',
  `role_id` VARCHAR(32) NOT NULL COMMENT '角色id',
  INDEX `fk_res_u_r_idx` (`user_id` ASC),
  INDEX `fk_res_ur_r_idx` (`role_id` ASC),
  UNIQUE INDEX `index_ur` (`user_id` ASC, `role_id` ASC),
  CONSTRAINT `fk_res_ur_u`
    FOREIGN KEY (`user_id`)
    REFERENCES `rxb_res`.`t_res_user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_res_ur_r`
    FOREIGN KEY (`role_id`)
    REFERENCES `rxb_res`.`t_res_role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '用户角色关联表';


-- -----------------------------------------------------
-- Table `rxb_res`.`t_res_role_permission`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rxb_res`.`t_res_role_permission` ;

CREATE TABLE IF NOT EXISTS `rxb_res`.`t_res_role_permission` (
  `role_id` VARCHAR(32) NULL COMMENT '角色id',
  `permission_id` VARCHAR(32) NULL COMMENT '权限id',
  INDEX `fk_rp_r_idx` (`role_id` ASC),
  UNIQUE INDEX `index_rp` (`role_id` ASC, `permission_id` ASC),
  INDEX `fk_rex_rp_p_idx` (`permission_id` ASC),
  CONSTRAINT `fk_res_rp_r`
    FOREIGN KEY (`role_id`)
    REFERENCES `rxb_res`.`t_res_role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_rex_rp_p`
    FOREIGN KEY (`permission_id`)
    REFERENCES `rxb_res`.`t_res_permission` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '角色权限关联表';


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
