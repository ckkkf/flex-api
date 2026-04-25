/*
 Navicat Premium Dump SQL

 Source Server         : 38.76.207.64newapi
 Source Server Type    : PostgreSQL
 Source Server Version : 180000 (180000)
 Source Host           : 38.76.207.64:44278
 Source Catalog        : flex_api
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 180000 (180000)
 File Encoding         : 65001

 Date: 25/04/2026 10:54:16
*/


-- ----------------------------
-- Sequence structure for channels_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."channels_id_seq";
CREATE SEQUENCE "public"."channels_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;
ALTER SEQUENCE "public"."channels_id_seq" OWNER TO "flex_api";

-- ----------------------------
-- Sequence structure for checkins_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."checkins_id_seq";
CREATE SEQUENCE "public"."checkins_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;
ALTER SEQUENCE "public"."checkins_id_seq" OWNER TO "flex_api";

-- ----------------------------
-- Sequence structure for custom_oauth_providers_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."custom_oauth_providers_id_seq";
CREATE SEQUENCE "public"."custom_oauth_providers_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;
ALTER SEQUENCE "public"."custom_oauth_providers_id_seq" OWNER TO "flex_api";

-- ----------------------------
-- Sequence structure for logs_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."logs_id_seq";
CREATE SEQUENCE "public"."logs_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;
ALTER SEQUENCE "public"."logs_id_seq" OWNER TO "flex_api";

-- ----------------------------
-- Sequence structure for midjourneys_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."midjourneys_id_seq";
CREATE SEQUENCE "public"."midjourneys_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;
ALTER SEQUENCE "public"."midjourneys_id_seq" OWNER TO "flex_api";

-- ----------------------------
-- Sequence structure for models_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."models_id_seq";
CREATE SEQUENCE "public"."models_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;
ALTER SEQUENCE "public"."models_id_seq" OWNER TO "flex_api";

-- ----------------------------
-- Sequence structure for passkey_credentials_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."passkey_credentials_id_seq";
CREATE SEQUENCE "public"."passkey_credentials_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;
ALTER SEQUENCE "public"."passkey_credentials_id_seq" OWNER TO "flex_api";

-- ----------------------------
-- Sequence structure for prefill_groups_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."prefill_groups_id_seq";
CREATE SEQUENCE "public"."prefill_groups_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;
ALTER SEQUENCE "public"."prefill_groups_id_seq" OWNER TO "flex_api";

-- ----------------------------
-- Sequence structure for quota_data_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."quota_data_id_seq";
CREATE SEQUENCE "public"."quota_data_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;
ALTER SEQUENCE "public"."quota_data_id_seq" OWNER TO "flex_api";

-- ----------------------------
-- Sequence structure for redemptions_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."redemptions_id_seq";
CREATE SEQUENCE "public"."redemptions_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;
ALTER SEQUENCE "public"."redemptions_id_seq" OWNER TO "flex_api";

-- ----------------------------
-- Sequence structure for setups_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."setups_id_seq";
CREATE SEQUENCE "public"."setups_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;
ALTER SEQUENCE "public"."setups_id_seq" OWNER TO "flex_api";

-- ----------------------------
-- Sequence structure for subscription_orders_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."subscription_orders_id_seq";
CREATE SEQUENCE "public"."subscription_orders_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;
ALTER SEQUENCE "public"."subscription_orders_id_seq" OWNER TO "flex_api";

-- ----------------------------
-- Sequence structure for subscription_plans_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."subscription_plans_id_seq";
CREATE SEQUENCE "public"."subscription_plans_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;
ALTER SEQUENCE "public"."subscription_plans_id_seq" OWNER TO "flex_api";

-- ----------------------------
-- Sequence structure for subscription_pre_consume_records_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."subscription_pre_consume_records_id_seq";
CREATE SEQUENCE "public"."subscription_pre_consume_records_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;
ALTER SEQUENCE "public"."subscription_pre_consume_records_id_seq" OWNER TO "flex_api";

-- ----------------------------
-- Sequence structure for tasks_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."tasks_id_seq";
CREATE SEQUENCE "public"."tasks_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;
ALTER SEQUENCE "public"."tasks_id_seq" OWNER TO "flex_api";

-- ----------------------------
-- Sequence structure for tokens_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."tokens_id_seq";
CREATE SEQUENCE "public"."tokens_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;
ALTER SEQUENCE "public"."tokens_id_seq" OWNER TO "flex_api";

-- ----------------------------
-- Sequence structure for top_ups_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."top_ups_id_seq";
CREATE SEQUENCE "public"."top_ups_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;
ALTER SEQUENCE "public"."top_ups_id_seq" OWNER TO "flex_api";

-- ----------------------------
-- Sequence structure for two_fa_backup_codes_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."two_fa_backup_codes_id_seq";
CREATE SEQUENCE "public"."two_fa_backup_codes_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;
ALTER SEQUENCE "public"."two_fa_backup_codes_id_seq" OWNER TO "flex_api";

-- ----------------------------
-- Sequence structure for two_fas_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."two_fas_id_seq";
CREATE SEQUENCE "public"."two_fas_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;
ALTER SEQUENCE "public"."two_fas_id_seq" OWNER TO "flex_api";

-- ----------------------------
-- Sequence structure for user_oauth_bindings_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."user_oauth_bindings_id_seq";
CREATE SEQUENCE "public"."user_oauth_bindings_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;
ALTER SEQUENCE "public"."user_oauth_bindings_id_seq" OWNER TO "flex_api";

-- ----------------------------
-- Sequence structure for user_subscriptions_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."user_subscriptions_id_seq";
CREATE SEQUENCE "public"."user_subscriptions_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;
ALTER SEQUENCE "public"."user_subscriptions_id_seq" OWNER TO "flex_api";

-- ----------------------------
-- Sequence structure for users_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."users_id_seq";
CREATE SEQUENCE "public"."users_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;
ALTER SEQUENCE "public"."users_id_seq" OWNER TO "flex_api";

-- ----------------------------
-- Sequence structure for vendors_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."vendors_id_seq";
CREATE SEQUENCE "public"."vendors_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;
ALTER SEQUENCE "public"."vendors_id_seq" OWNER TO "flex_api";

-- ----------------------------
-- Table structure for abilities
-- ----------------------------
DROP TABLE IF EXISTS "public"."abilities";
CREATE TABLE "public"."abilities" (
  "group" varchar(64) COLLATE "pg_catalog"."default" NOT NULL,
  "model" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "channel_id" int8 NOT NULL,
  "enabled" bool,
  "priority" int8 DEFAULT 0,
  "weight" int8 DEFAULT 0,
  "tag" text COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "public"."abilities" OWNER TO "flex_api";

-- ----------------------------
-- Table structure for channels
-- ----------------------------
DROP TABLE IF EXISTS "public"."channels";
CREATE TABLE "public"."channels" (
  "id" int8 NOT NULL DEFAULT nextval('channels_id_seq'::regclass),
  "type" int8 DEFAULT 0,
  "key" text COLLATE "pg_catalog"."default" NOT NULL,
  "open_ai_organization" text COLLATE "pg_catalog"."default",
  "test_model" text COLLATE "pg_catalog"."default",
  "status" int8 DEFAULT 1,
  "name" text COLLATE "pg_catalog"."default",
  "weight" int8 DEFAULT 0,
  "created_time" int8,
  "test_time" int8,
  "response_time" int8,
  "base_url" text COLLATE "pg_catalog"."default" DEFAULT ''::text,
  "other" text COLLATE "pg_catalog"."default",
  "balance" numeric,
  "balance_updated_time" int8,
  "models" text COLLATE "pg_catalog"."default",
  "group" varchar(64) COLLATE "pg_catalog"."default" DEFAULT 'default'::character varying,
  "used_quota" int8 DEFAULT 0,
  "model_mapping" text COLLATE "pg_catalog"."default",
  "status_code_mapping" varchar(1024) COLLATE "pg_catalog"."default" DEFAULT ''::character varying,
  "priority" int8 DEFAULT 0,
  "auto_ban" int8 DEFAULT 1,
  "other_info" text COLLATE "pg_catalog"."default",
  "tag" text COLLATE "pg_catalog"."default",
  "setting" text COLLATE "pg_catalog"."default",
  "param_override" text COLLATE "pg_catalog"."default",
  "header_override" text COLLATE "pg_catalog"."default",
  "remark" varchar(255) COLLATE "pg_catalog"."default",
  "channel_info" json,
  "settings" text COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "public"."channels" OWNER TO "flex_api";

-- ----------------------------
-- Table structure for checkins
-- ----------------------------
DROP TABLE IF EXISTS "public"."checkins";
CREATE TABLE "public"."checkins" (
  "id" int8 NOT NULL DEFAULT nextval('checkins_id_seq'::regclass),
  "user_id" int8 NOT NULL,
  "checkin_date" varchar(10) COLLATE "pg_catalog"."default" NOT NULL,
  "quota_awarded" int8 NOT NULL,
  "created_at" int8
)
;
ALTER TABLE "public"."checkins" OWNER TO "flex_api";

-- ----------------------------
-- Table structure for custom_oauth_providers
-- ----------------------------
DROP TABLE IF EXISTS "public"."custom_oauth_providers";
CREATE TABLE "public"."custom_oauth_providers" (
  "id" int8 NOT NULL DEFAULT nextval('custom_oauth_providers_id_seq'::regclass),
  "name" varchar(64) COLLATE "pg_catalog"."default" NOT NULL,
  "slug" varchar(64) COLLATE "pg_catalog"."default" NOT NULL,
  "icon" varchar(128) COLLATE "pg_catalog"."default" DEFAULT ''::character varying,
  "enabled" bool DEFAULT false,
  "client_id" varchar(256) COLLATE "pg_catalog"."default",
  "client_secret" varchar(512) COLLATE "pg_catalog"."default",
  "authorization_endpoint" varchar(512) COLLATE "pg_catalog"."default",
  "token_endpoint" varchar(512) COLLATE "pg_catalog"."default",
  "user_info_endpoint" varchar(512) COLLATE "pg_catalog"."default",
  "scopes" varchar(256) COLLATE "pg_catalog"."default" DEFAULT 'openid profile email'::character varying,
  "user_id_field" varchar(128) COLLATE "pg_catalog"."default" DEFAULT 'sub'::character varying,
  "username_field" varchar(128) COLLATE "pg_catalog"."default" DEFAULT 'preferred_username'::character varying,
  "display_name_field" varchar(128) COLLATE "pg_catalog"."default" DEFAULT 'name'::character varying,
  "email_field" varchar(128) COLLATE "pg_catalog"."default" DEFAULT 'email'::character varying,
  "well_known" varchar(512) COLLATE "pg_catalog"."default",
  "auth_style" int8 DEFAULT 0,
  "access_policy" text COLLATE "pg_catalog"."default",
  "access_denied_message" varchar(512) COLLATE "pg_catalog"."default",
  "created_at" timestamptz(6),
  "updated_at" timestamptz(6)
)
;
ALTER TABLE "public"."custom_oauth_providers" OWNER TO "flex_api";

-- ----------------------------
-- Table structure for logs
-- ----------------------------
DROP TABLE IF EXISTS "public"."logs";
CREATE TABLE "public"."logs" (
  "id" int8 NOT NULL DEFAULT nextval('logs_id_seq'::regclass),
  "user_id" int8,
  "created_at" int8,
  "type" int8,
  "content" text COLLATE "pg_catalog"."default",
  "username" text COLLATE "pg_catalog"."default" DEFAULT ''::text,
  "token_name" text COLLATE "pg_catalog"."default" DEFAULT ''::text,
  "model_name" text COLLATE "pg_catalog"."default" DEFAULT ''::text,
  "quota" int8 DEFAULT 0,
  "prompt_tokens" int8 DEFAULT 0,
  "completion_tokens" int8 DEFAULT 0,
  "use_time" int8 DEFAULT 0,
  "is_stream" bool,
  "channel_id" int8,
  "channel_name" text COLLATE "pg_catalog"."default",
  "token_id" int8 DEFAULT 0,
  "group" text COLLATE "pg_catalog"."default",
  "ip" text COLLATE "pg_catalog"."default" DEFAULT ''::text,
  "request_id" varchar(64) COLLATE "pg_catalog"."default" DEFAULT ''::character varying,
  "other" text COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "public"."logs" OWNER TO "flex_api";

-- ----------------------------
-- Table structure for midjourneys
-- ----------------------------
DROP TABLE IF EXISTS "public"."midjourneys";
CREATE TABLE "public"."midjourneys" (
  "id" int8 NOT NULL DEFAULT nextval('midjourneys_id_seq'::regclass),
  "code" int8,
  "user_id" int8,
  "action" varchar(40) COLLATE "pg_catalog"."default",
  "mj_id" text COLLATE "pg_catalog"."default",
  "prompt" text COLLATE "pg_catalog"."default",
  "prompt_en" text COLLATE "pg_catalog"."default",
  "description" text COLLATE "pg_catalog"."default",
  "state" text COLLATE "pg_catalog"."default",
  "submit_time" int8,
  "start_time" int8,
  "finish_time" int8,
  "image_url" text COLLATE "pg_catalog"."default",
  "video_url" text COLLATE "pg_catalog"."default",
  "video_urls" text COLLATE "pg_catalog"."default",
  "status" varchar(20) COLLATE "pg_catalog"."default",
  "progress" varchar(30) COLLATE "pg_catalog"."default",
  "fail_reason" text COLLATE "pg_catalog"."default",
  "channel_id" int8,
  "quota" int8,
  "buttons" text COLLATE "pg_catalog"."default",
  "properties" text COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "public"."midjourneys" OWNER TO "flex_api";

-- ----------------------------
-- Table structure for models
-- ----------------------------
DROP TABLE IF EXISTS "public"."models";
CREATE TABLE "public"."models" (
  "id" int8 NOT NULL DEFAULT nextval('models_id_seq'::regclass),
  "model_name" varchar(128) COLLATE "pg_catalog"."default" NOT NULL,
  "description" text COLLATE "pg_catalog"."default",
  "icon" varchar(128) COLLATE "pg_catalog"."default",
  "tags" varchar(255) COLLATE "pg_catalog"."default",
  "vendor_id" int8,
  "endpoints" text COLLATE "pg_catalog"."default",
  "status" int8 DEFAULT 1,
  "sync_official" int8 DEFAULT 1,
  "created_time" int8,
  "updated_time" int8,
  "deleted_at" timestamptz(6),
  "name_rule" int8 DEFAULT 0
)
;
ALTER TABLE "public"."models" OWNER TO "flex_api";

-- ----------------------------
-- Table structure for options
-- ----------------------------
DROP TABLE IF EXISTS "public"."options";
CREATE TABLE "public"."options" (
  "key" text COLLATE "pg_catalog"."default" NOT NULL,
  "value" text COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "public"."options" OWNER TO "flex_api";

-- ----------------------------
-- Table structure for passkey_credentials
-- ----------------------------
DROP TABLE IF EXISTS "public"."passkey_credentials";
CREATE TABLE "public"."passkey_credentials" (
  "id" int8 NOT NULL DEFAULT nextval('passkey_credentials_id_seq'::regclass),
  "user_id" int8 NOT NULL,
  "credential_id" varchar(512) COLLATE "pg_catalog"."default" NOT NULL,
  "public_key" text COLLATE "pg_catalog"."default" NOT NULL,
  "attestation_type" varchar(255) COLLATE "pg_catalog"."default",
  "aa_guid" varchar(512) COLLATE "pg_catalog"."default",
  "sign_count" int8 DEFAULT 0,
  "clone_warning" bool,
  "user_present" bool,
  "user_verified" bool,
  "backup_eligible" bool,
  "backup_state" bool,
  "transports" text COLLATE "pg_catalog"."default",
  "attachment" varchar(32) COLLATE "pg_catalog"."default",
  "last_used_at" timestamptz(6),
  "created_at" timestamptz(6),
  "updated_at" timestamptz(6),
  "deleted_at" timestamptz(6)
)
;
ALTER TABLE "public"."passkey_credentials" OWNER TO "flex_api";

-- ----------------------------
-- Table structure for prefill_groups
-- ----------------------------
DROP TABLE IF EXISTS "public"."prefill_groups";
CREATE TABLE "public"."prefill_groups" (
  "id" int8 NOT NULL DEFAULT nextval('prefill_groups_id_seq'::regclass),
  "name" varchar(64) COLLATE "pg_catalog"."default" NOT NULL,
  "type" varchar(32) COLLATE "pg_catalog"."default" NOT NULL,
  "items" json,
  "description" varchar(255) COLLATE "pg_catalog"."default",
  "created_time" int8,
  "updated_time" int8,
  "deleted_at" timestamptz(6)
)
;
ALTER TABLE "public"."prefill_groups" OWNER TO "flex_api";

-- ----------------------------
-- Table structure for quota_data
-- ----------------------------
DROP TABLE IF EXISTS "public"."quota_data";
CREATE TABLE "public"."quota_data" (
  "id" int8 NOT NULL DEFAULT nextval('quota_data_id_seq'::regclass),
  "user_id" int8,
  "username" varchar(64) COLLATE "pg_catalog"."default" DEFAULT ''::character varying,
  "model_name" varchar(64) COLLATE "pg_catalog"."default" DEFAULT ''::character varying,
  "created_at" int8,
  "token_used" int8 DEFAULT 0,
  "count" int8 DEFAULT 0,
  "quota" int8 DEFAULT 0
)
;
ALTER TABLE "public"."quota_data" OWNER TO "flex_api";

-- ----------------------------
-- Table structure for redemptions
-- ----------------------------
DROP TABLE IF EXISTS "public"."redemptions";
CREATE TABLE "public"."redemptions" (
  "id" int8 NOT NULL DEFAULT nextval('redemptions_id_seq'::regclass),
  "user_id" int8,
  "key" char(32) COLLATE "pg_catalog"."default",
  "status" int8 DEFAULT 1,
  "name" text COLLATE "pg_catalog"."default",
  "quota" int8 DEFAULT 100,
  "created_time" int8,
  "redeemed_time" int8,
  "used_user_id" int8,
  "deleted_at" timestamptz(6),
  "expired_time" int8
)
;
ALTER TABLE "public"."redemptions" OWNER TO "flex_api";

-- ----------------------------
-- Table structure for setups
-- ----------------------------
DROP TABLE IF EXISTS "public"."setups";
CREATE TABLE "public"."setups" (
  "id" int8 NOT NULL DEFAULT nextval('setups_id_seq'::regclass),
  "version" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
  "initialized_at" int8 NOT NULL
)
;
ALTER TABLE "public"."setups" OWNER TO "flex_api";

-- ----------------------------
-- Table structure for subscription_orders
-- ----------------------------
DROP TABLE IF EXISTS "public"."subscription_orders";
CREATE TABLE "public"."subscription_orders" (
  "id" int8 NOT NULL DEFAULT nextval('subscription_orders_id_seq'::regclass),
  "user_id" int8,
  "plan_id" int8,
  "money" numeric,
  "trade_no" varchar(255) COLLATE "pg_catalog"."default",
  "payment_method" varchar(50) COLLATE "pg_catalog"."default",
  "status" text COLLATE "pg_catalog"."default",
  "create_time" int8,
  "complete_time" int8,
  "provider_payload" text COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "public"."subscription_orders" OWNER TO "flex_api";

-- ----------------------------
-- Table structure for subscription_plans
-- ----------------------------
DROP TABLE IF EXISTS "public"."subscription_plans";
CREATE TABLE "public"."subscription_plans" (
  "id" int8 NOT NULL DEFAULT nextval('subscription_plans_id_seq'::regclass),
  "title" varchar(128) COLLATE "pg_catalog"."default" NOT NULL,
  "subtitle" varchar(255) COLLATE "pg_catalog"."default" DEFAULT ''::character varying,
  "price_amount" numeric(10,6) NOT NULL DEFAULT 0.000000,
  "currency" varchar(8) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'USD'::character varying,
  "duration_unit" varchar(16) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'month'::character varying,
  "duration_value" int8 NOT NULL DEFAULT 1,
  "custom_seconds" int8 NOT NULL DEFAULT 0,
  "enabled" bool DEFAULT true,
  "sort_order" int8 DEFAULT 0,
  "stripe_price_id" varchar(128) COLLATE "pg_catalog"."default" DEFAULT ''::character varying,
  "creem_product_id" varchar(128) COLLATE "pg_catalog"."default" DEFAULT ''::character varying,
  "max_purchase_per_user" int8 DEFAULT 0,
  "upgrade_group" varchar(64) COLLATE "pg_catalog"."default" DEFAULT ''::character varying,
  "total_amount" int8 NOT NULL DEFAULT 0,
  "quota_reset_period" varchar(16) COLLATE "pg_catalog"."default" DEFAULT 'never'::character varying,
  "quota_reset_custom_seconds" int8 DEFAULT 0,
  "created_at" int8,
  "updated_at" int8
)
;
ALTER TABLE "public"."subscription_plans" OWNER TO "flex_api";

-- ----------------------------
-- Table structure for subscription_pre_consume_records
-- ----------------------------
DROP TABLE IF EXISTS "public"."subscription_pre_consume_records";
CREATE TABLE "public"."subscription_pre_consume_records" (
  "id" int8 NOT NULL DEFAULT nextval('subscription_pre_consume_records_id_seq'::regclass),
  "request_id" varchar(64) COLLATE "pg_catalog"."default",
  "user_id" int8,
  "user_subscription_id" int8,
  "pre_consumed" int8 NOT NULL DEFAULT 0,
  "status" varchar(32) COLLATE "pg_catalog"."default",
  "created_at" int8,
  "updated_at" int8
)
;
ALTER TABLE "public"."subscription_pre_consume_records" OWNER TO "flex_api";

-- ----------------------------
-- Table structure for tasks
-- ----------------------------
DROP TABLE IF EXISTS "public"."tasks";
CREATE TABLE "public"."tasks" (
  "id" int8 NOT NULL DEFAULT nextval('tasks_id_seq'::regclass),
  "created_at" int8,
  "updated_at" int8,
  "task_id" varchar(191) COLLATE "pg_catalog"."default",
  "platform" varchar(30) COLLATE "pg_catalog"."default",
  "user_id" int8,
  "group" varchar(50) COLLATE "pg_catalog"."default",
  "channel_id" int8,
  "quota" int8,
  "action" varchar(40) COLLATE "pg_catalog"."default",
  "status" varchar(20) COLLATE "pg_catalog"."default",
  "fail_reason" text COLLATE "pg_catalog"."default",
  "submit_time" int8,
  "start_time" int8,
  "finish_time" int8,
  "progress" varchar(20) COLLATE "pg_catalog"."default",
  "properties" json,
  "private_data" json,
  "data" json
)
;
ALTER TABLE "public"."tasks" OWNER TO "flex_api";

-- ----------------------------
-- Table structure for tokens
-- ----------------------------
DROP TABLE IF EXISTS "public"."tokens";
CREATE TABLE "public"."tokens" (
  "id" int8 NOT NULL DEFAULT nextval('tokens_id_seq'::regclass),
  "user_id" int8,
  "key" char(64) COLLATE "pg_catalog"."default",
  "status" int8 DEFAULT 1,
  "name" text COLLATE "pg_catalog"."default",
  "created_time" int8,
  "accessed_time" int8,
  "expired_time" int8 DEFAULT '-1'::integer,
  "remain_quota" int8 DEFAULT 0,
  "unlimited_quota" bool,
  "model_limits_enabled" bool,
  "model_limits" text COLLATE "pg_catalog"."default",
  "allow_ips" text COLLATE "pg_catalog"."default" DEFAULT ''::text,
  "used_quota" int8 DEFAULT 0,
  "group" text COLLATE "pg_catalog"."default" DEFAULT ''::text,
  "cross_group_retry" bool,
  "deleted_at" timestamptz(6)
)
;
ALTER TABLE "public"."tokens" OWNER TO "flex_api";
COMMENT ON COLUMN "public"."tokens"."key" IS '原48位';

-- ----------------------------
-- Table structure for top_ups
-- ----------------------------
DROP TABLE IF EXISTS "public"."top_ups";
CREATE TABLE "public"."top_ups" (
  "id" int8 NOT NULL DEFAULT nextval('top_ups_id_seq'::regclass),
  "user_id" int8,
  "amount" int8,
  "money" numeric,
  "trade_no" varchar(255) COLLATE "pg_catalog"."default",
  "payment_method" varchar(50) COLLATE "pg_catalog"."default",
  "create_time" int8,
  "complete_time" int8,
  "status" text COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "public"."top_ups" OWNER TO "flex_api";

-- ----------------------------
-- Table structure for two_fa_backup_codes
-- ----------------------------
DROP TABLE IF EXISTS "public"."two_fa_backup_codes";
CREATE TABLE "public"."two_fa_backup_codes" (
  "id" int8 NOT NULL DEFAULT nextval('two_fa_backup_codes_id_seq'::regclass),
  "user_id" int8 NOT NULL,
  "code_hash" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "is_used" bool,
  "used_at" timestamptz(6),
  "created_at" timestamptz(6),
  "deleted_at" timestamptz(6)
)
;
ALTER TABLE "public"."two_fa_backup_codes" OWNER TO "flex_api";

-- ----------------------------
-- Table structure for two_fas
-- ----------------------------
DROP TABLE IF EXISTS "public"."two_fas";
CREATE TABLE "public"."two_fas" (
  "id" int8 NOT NULL DEFAULT nextval('two_fas_id_seq'::regclass),
  "user_id" int8 NOT NULL,
  "secret" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "is_enabled" bool,
  "failed_attempts" int8 DEFAULT 0,
  "locked_until" timestamptz(6),
  "last_used_at" timestamptz(6),
  "created_at" timestamptz(6),
  "updated_at" timestamptz(6),
  "deleted_at" timestamptz(6)
)
;
ALTER TABLE "public"."two_fas" OWNER TO "flex_api";

-- ----------------------------
-- Table structure for user_oauth_bindings
-- ----------------------------
DROP TABLE IF EXISTS "public"."user_oauth_bindings";
CREATE TABLE "public"."user_oauth_bindings" (
  "id" int8 NOT NULL DEFAULT nextval('user_oauth_bindings_id_seq'::regclass),
  "user_id" int8 NOT NULL,
  "provider_id" int8 NOT NULL,
  "provider_user_id" varchar(256) COLLATE "pg_catalog"."default" NOT NULL,
  "created_at" timestamptz(6)
)
;
ALTER TABLE "public"."user_oauth_bindings" OWNER TO "flex_api";

-- ----------------------------
-- Table structure for user_subscriptions
-- ----------------------------
DROP TABLE IF EXISTS "public"."user_subscriptions";
CREATE TABLE "public"."user_subscriptions" (
  "id" int8 NOT NULL DEFAULT nextval('user_subscriptions_id_seq'::regclass),
  "user_id" int8,
  "plan_id" int8,
  "amount_total" int8 NOT NULL DEFAULT 0,
  "amount_used" int8 NOT NULL DEFAULT 0,
  "start_time" int8,
  "end_time" int8,
  "status" varchar(32) COLLATE "pg_catalog"."default",
  "source" varchar(32) COLLATE "pg_catalog"."default" DEFAULT 'order'::character varying,
  "last_reset_time" int8 DEFAULT 0,
  "next_reset_time" int8 DEFAULT 0,
  "upgrade_group" varchar(64) COLLATE "pg_catalog"."default" DEFAULT ''::character varying,
  "prev_user_group" varchar(64) COLLATE "pg_catalog"."default" DEFAULT ''::character varying,
  "created_at" int8,
  "updated_at" int8
)
;
ALTER TABLE "public"."user_subscriptions" OWNER TO "flex_api";

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS "public"."users";
CREATE TABLE "public"."users" (
  "id" int8 NOT NULL DEFAULT nextval('users_id_seq'::regclass),
  "username" text COLLATE "pg_catalog"."default",
  "password" text COLLATE "pg_catalog"."default" NOT NULL,
  "display_name" text COLLATE "pg_catalog"."default",
  "role" int8 DEFAULT 1,
  "status" int8 DEFAULT 1,
  "email" text COLLATE "pg_catalog"."default",
  "github_id" text COLLATE "pg_catalog"."default",
  "discord_id" text COLLATE "pg_catalog"."default",
  "oidc_id" text COLLATE "pg_catalog"."default",
  "wechat_id" text COLLATE "pg_catalog"."default",
  "telegram_id" text COLLATE "pg_catalog"."default",
  "access_token" char(32) COLLATE "pg_catalog"."default",
  "quota" int8 DEFAULT 0,
  "used_quota" int8 DEFAULT 0,
  "request_count" int8 DEFAULT 0,
  "group" varchar(64) COLLATE "pg_catalog"."default" DEFAULT 'default'::character varying,
  "aff_code" varchar(32) COLLATE "pg_catalog"."default",
  "aff_count" int8 DEFAULT 0,
  "aff_quota" int8 DEFAULT 0,
  "aff_history" int8 DEFAULT 0,
  "inviter_id" int8,
  "deleted_at" timestamptz(6),
  "linux_do_id" text COLLATE "pg_catalog"."default",
  "setting" text COLLATE "pg_catalog"."default",
  "remark" varchar(255) COLLATE "pg_catalog"."default",
  "stripe_customer" varchar(64) COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "public"."users" OWNER TO "flex_api";

-- ----------------------------
-- Table structure for vendors
-- ----------------------------
DROP TABLE IF EXISTS "public"."vendors";
CREATE TABLE "public"."vendors" (
  "id" int8 NOT NULL DEFAULT nextval('vendors_id_seq'::regclass),
  "name" varchar(128) COLLATE "pg_catalog"."default" NOT NULL,
  "description" text COLLATE "pg_catalog"."default",
  "icon" varchar(128) COLLATE "pg_catalog"."default",
  "status" int8 DEFAULT 1,
  "created_time" int8,
  "updated_time" int8,
  "deleted_at" timestamptz(6)
)
;
ALTER TABLE "public"."vendors" OWNER TO "flex_api";

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."channels_id_seq"
OWNED BY "public"."channels"."id";
SELECT setval('"public"."channels_id_seq"', 335, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."checkins_id_seq"
OWNED BY "public"."checkins"."id";
SELECT setval('"public"."checkins_id_seq"', 4, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."custom_oauth_providers_id_seq"
OWNED BY "public"."custom_oauth_providers"."id";
SELECT setval('"public"."custom_oauth_providers_id_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."logs_id_seq"
OWNED BY "public"."logs"."id";
SELECT setval('"public"."logs_id_seq"', 93565, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."midjourneys_id_seq"
OWNED BY "public"."midjourneys"."id";
SELECT setval('"public"."midjourneys_id_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."models_id_seq"
OWNED BY "public"."models"."id";
SELECT setval('"public"."models_id_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."passkey_credentials_id_seq"
OWNED BY "public"."passkey_credentials"."id";
SELECT setval('"public"."passkey_credentials_id_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."prefill_groups_id_seq"
OWNED BY "public"."prefill_groups"."id";
SELECT setval('"public"."prefill_groups_id_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."quota_data_id_seq"
OWNED BY "public"."quota_data"."id";
SELECT setval('"public"."quota_data_id_seq"', 775, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."redemptions_id_seq"
OWNED BY "public"."redemptions"."id";
SELECT setval('"public"."redemptions_id_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."setups_id_seq"
OWNED BY "public"."setups"."id";
SELECT setval('"public"."setups_id_seq"', 1, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."subscription_orders_id_seq"
OWNED BY "public"."subscription_orders"."id";
SELECT setval('"public"."subscription_orders_id_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."subscription_plans_id_seq"
OWNED BY "public"."subscription_plans"."id";
SELECT setval('"public"."subscription_plans_id_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."subscription_pre_consume_records_id_seq"
OWNED BY "public"."subscription_pre_consume_records"."id";
SELECT setval('"public"."subscription_pre_consume_records_id_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."tasks_id_seq"
OWNED BY "public"."tasks"."id";
SELECT setval('"public"."tasks_id_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."tokens_id_seq"
OWNED BY "public"."tokens"."id";
SELECT setval('"public"."tokens_id_seq"', 3, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."top_ups_id_seq"
OWNED BY "public"."top_ups"."id";
SELECT setval('"public"."top_ups_id_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."two_fa_backup_codes_id_seq"
OWNED BY "public"."two_fa_backup_codes"."id";
SELECT setval('"public"."two_fa_backup_codes_id_seq"', 4, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."two_fas_id_seq"
OWNED BY "public"."two_fas"."id";
SELECT setval('"public"."two_fas_id_seq"', 1, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."user_oauth_bindings_id_seq"
OWNED BY "public"."user_oauth_bindings"."id";
SELECT setval('"public"."user_oauth_bindings_id_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."user_subscriptions_id_seq"
OWNED BY "public"."user_subscriptions"."id";
SELECT setval('"public"."user_subscriptions_id_seq"', 1, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."users_id_seq"
OWNED BY "public"."users"."id";
SELECT setval('"public"."users_id_seq"', 6, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."vendors_id_seq"
OWNED BY "public"."vendors"."id";
SELECT setval('"public"."vendors_id_seq"', 3, true);

-- ----------------------------
-- Indexes structure for table abilities
-- ----------------------------
CREATE INDEX "idx_abilities_channel_id" ON "public"."abilities" USING btree (
  "channel_id" "pg_catalog"."int8_ops" ASC NULLS LAST
);
CREATE INDEX "idx_abilities_priority" ON "public"."abilities" USING btree (
  "priority" "pg_catalog"."int8_ops" ASC NULLS LAST
);
CREATE INDEX "idx_abilities_tag" ON "public"."abilities" USING btree (
  "tag" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_abilities_weight" ON "public"."abilities" USING btree (
  "weight" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table abilities
-- ----------------------------
ALTER TABLE "public"."abilities" ADD CONSTRAINT "abilities_pkey" PRIMARY KEY ("group", "model", "channel_id");

-- ----------------------------
-- Indexes structure for table channels
-- ----------------------------
CREATE INDEX "idx_channels_name" ON "public"."channels" USING btree (
  "name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_channels_tag" ON "public"."channels" USING btree (
  "tag" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table channels
-- ----------------------------
ALTER TABLE "public"."channels" ADD CONSTRAINT "channels_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table checkins
-- ----------------------------
CREATE UNIQUE INDEX "idx_user_checkin_date" ON "public"."checkins" USING btree (
  "user_id" "pg_catalog"."int8_ops" ASC NULLS LAST,
  "checkin_date" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table checkins
-- ----------------------------
ALTER TABLE "public"."checkins" ADD CONSTRAINT "checkins_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table custom_oauth_providers
-- ----------------------------
CREATE UNIQUE INDEX "idx_custom_oauth_providers_slug" ON "public"."custom_oauth_providers" USING btree (
  "slug" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table custom_oauth_providers
-- ----------------------------
ALTER TABLE "public"."custom_oauth_providers" ADD CONSTRAINT "custom_oauth_providers_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table logs
-- ----------------------------
CREATE INDEX "idx_created_at_id" ON "public"."logs" USING btree (
  "id" "pg_catalog"."int8_ops" ASC NULLS LAST,
  "created_at" "pg_catalog"."int8_ops" ASC NULLS LAST
);
CREATE INDEX "idx_created_at_type" ON "public"."logs" USING btree (
  "created_at" "pg_catalog"."int8_ops" ASC NULLS LAST,
  "type" "pg_catalog"."int8_ops" ASC NULLS LAST
);
CREATE INDEX "idx_logs_channel_id" ON "public"."logs" USING btree (
  "channel_id" "pg_catalog"."int8_ops" ASC NULLS LAST
);
CREATE INDEX "idx_logs_group" ON "public"."logs" USING btree (
  "group" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_logs_ip" ON "public"."logs" USING btree (
  "ip" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_logs_model_name" ON "public"."logs" USING btree (
  "model_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_logs_request_id" ON "public"."logs" USING btree (
  "request_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_logs_token_id" ON "public"."logs" USING btree (
  "token_id" "pg_catalog"."int8_ops" ASC NULLS LAST
);
CREATE INDEX "idx_logs_token_name" ON "public"."logs" USING btree (
  "token_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_logs_user_id" ON "public"."logs" USING btree (
  "user_id" "pg_catalog"."int8_ops" ASC NULLS LAST
);
CREATE INDEX "idx_logs_username" ON "public"."logs" USING btree (
  "username" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_user_id_id" ON "public"."logs" USING btree (
  "user_id" "pg_catalog"."int8_ops" ASC NULLS LAST,
  "id" "pg_catalog"."int8_ops" ASC NULLS LAST
);
CREATE INDEX "index_username_model_name" ON "public"."logs" USING btree (
  "model_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "username" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table logs
-- ----------------------------
ALTER TABLE "public"."logs" ADD CONSTRAINT "logs_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table midjourneys
-- ----------------------------
CREATE INDEX "idx_midjourneys_action" ON "public"."midjourneys" USING btree (
  "action" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_midjourneys_finish_time" ON "public"."midjourneys" USING btree (
  "finish_time" "pg_catalog"."int8_ops" ASC NULLS LAST
);
CREATE INDEX "idx_midjourneys_mj_id" ON "public"."midjourneys" USING btree (
  "mj_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_midjourneys_progress" ON "public"."midjourneys" USING btree (
  "progress" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_midjourneys_start_time" ON "public"."midjourneys" USING btree (
  "start_time" "pg_catalog"."int8_ops" ASC NULLS LAST
);
CREATE INDEX "idx_midjourneys_status" ON "public"."midjourneys" USING btree (
  "status" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_midjourneys_submit_time" ON "public"."midjourneys" USING btree (
  "submit_time" "pg_catalog"."int8_ops" ASC NULLS LAST
);
CREATE INDEX "idx_midjourneys_user_id" ON "public"."midjourneys" USING btree (
  "user_id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table midjourneys
-- ----------------------------
ALTER TABLE "public"."midjourneys" ADD CONSTRAINT "midjourneys_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table models
-- ----------------------------
CREATE INDEX "idx_models_deleted_at" ON "public"."models" USING btree (
  "deleted_at" "pg_catalog"."timestamptz_ops" ASC NULLS LAST
);
CREATE INDEX "idx_models_vendor_id" ON "public"."models" USING btree (
  "vendor_id" "pg_catalog"."int8_ops" ASC NULLS LAST
);
CREATE UNIQUE INDEX "uk_model_name_delete_at" ON "public"."models" USING btree (
  "model_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "deleted_at" "pg_catalog"."timestamptz_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table models
-- ----------------------------
ALTER TABLE "public"."models" ADD CONSTRAINT "models_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table options
-- ----------------------------
ALTER TABLE "public"."options" ADD CONSTRAINT "options_pkey" PRIMARY KEY ("key");

-- ----------------------------
-- Indexes structure for table passkey_credentials
-- ----------------------------
CREATE UNIQUE INDEX "idx_passkey_credentials_credential_id" ON "public"."passkey_credentials" USING btree (
  "credential_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_passkey_credentials_deleted_at" ON "public"."passkey_credentials" USING btree (
  "deleted_at" "pg_catalog"."timestamptz_ops" ASC NULLS LAST
);
CREATE UNIQUE INDEX "idx_passkey_credentials_user_id" ON "public"."passkey_credentials" USING btree (
  "user_id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table passkey_credentials
-- ----------------------------
ALTER TABLE "public"."passkey_credentials" ADD CONSTRAINT "passkey_credentials_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table prefill_groups
-- ----------------------------
CREATE INDEX "idx_prefill_groups_deleted_at" ON "public"."prefill_groups" USING btree (
  "deleted_at" "pg_catalog"."timestamptz_ops" ASC NULLS LAST
);
CREATE INDEX "idx_prefill_groups_type" ON "public"."prefill_groups" USING btree (
  "type" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE UNIQUE INDEX "uk_prefill_name" ON "public"."prefill_groups" USING btree (
  "name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
) WHERE deleted_at IS NULL;

-- ----------------------------
-- Uniques structure for table prefill_groups
-- ----------------------------
ALTER TABLE "public"."prefill_groups" ADD CONSTRAINT "idx_prefill_groups_name" UNIQUE ("name");

-- ----------------------------
-- Primary Key structure for table prefill_groups
-- ----------------------------
ALTER TABLE "public"."prefill_groups" ADD CONSTRAINT "prefill_groups_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table quota_data
-- ----------------------------
CREATE INDEX "idx_qdt_created_at" ON "public"."quota_data" USING btree (
  "created_at" "pg_catalog"."int8_ops" ASC NULLS LAST
);
CREATE INDEX "idx_qdt_model_user_name" ON "public"."quota_data" USING btree (
  "model_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "username" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_quota_data_user_id" ON "public"."quota_data" USING btree (
  "user_id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table quota_data
-- ----------------------------
ALTER TABLE "public"."quota_data" ADD CONSTRAINT "quota_data_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table redemptions
-- ----------------------------
CREATE INDEX "idx_redemptions_deleted_at" ON "public"."redemptions" USING btree (
  "deleted_at" "pg_catalog"."timestamptz_ops" ASC NULLS LAST
);
CREATE UNIQUE INDEX "idx_redemptions_key" ON "public"."redemptions" USING btree (
  "key" COLLATE "pg_catalog"."default" "pg_catalog"."bpchar_ops" ASC NULLS LAST
);
CREATE INDEX "idx_redemptions_name" ON "public"."redemptions" USING btree (
  "name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table redemptions
-- ----------------------------
ALTER TABLE "public"."redemptions" ADD CONSTRAINT "redemptions_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table setups
-- ----------------------------
ALTER TABLE "public"."setups" ADD CONSTRAINT "setups_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table subscription_orders
-- ----------------------------
CREATE INDEX "idx_subscription_orders_plan_id" ON "public"."subscription_orders" USING btree (
  "plan_id" "pg_catalog"."int8_ops" ASC NULLS LAST
);
CREATE INDEX "idx_subscription_orders_trade_no" ON "public"."subscription_orders" USING btree (
  "trade_no" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_subscription_orders_user_id" ON "public"."subscription_orders" USING btree (
  "user_id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Uniques structure for table subscription_orders
-- ----------------------------
ALTER TABLE "public"."subscription_orders" ADD CONSTRAINT "subscription_orders_trade_no_key" UNIQUE ("trade_no");

-- ----------------------------
-- Primary Key structure for table subscription_orders
-- ----------------------------
ALTER TABLE "public"."subscription_orders" ADD CONSTRAINT "subscription_orders_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table subscription_plans
-- ----------------------------
ALTER TABLE "public"."subscription_plans" ADD CONSTRAINT "subscription_plans_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table subscription_pre_consume_records
-- ----------------------------
CREATE UNIQUE INDEX "idx_subscription_pre_consume_records_request_id" ON "public"."subscription_pre_consume_records" USING btree (
  "request_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_subscription_pre_consume_records_status" ON "public"."subscription_pre_consume_records" USING btree (
  "status" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_subscription_pre_consume_records_updated_at" ON "public"."subscription_pre_consume_records" USING btree (
  "updated_at" "pg_catalog"."int8_ops" ASC NULLS LAST
);
CREATE INDEX "idx_subscription_pre_consume_records_user_id" ON "public"."subscription_pre_consume_records" USING btree (
  "user_id" "pg_catalog"."int8_ops" ASC NULLS LAST
);
CREATE INDEX "idx_subscription_pre_consume_records_user_subscription_id" ON "public"."subscription_pre_consume_records" USING btree (
  "user_subscription_id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table subscription_pre_consume_records
-- ----------------------------
ALTER TABLE "public"."subscription_pre_consume_records" ADD CONSTRAINT "subscription_pre_consume_records_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table tasks
-- ----------------------------
CREATE INDEX "idx_tasks_action" ON "public"."tasks" USING btree (
  "action" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_tasks_channel_id" ON "public"."tasks" USING btree (
  "channel_id" "pg_catalog"."int8_ops" ASC NULLS LAST
);
CREATE INDEX "idx_tasks_created_at" ON "public"."tasks" USING btree (
  "created_at" "pg_catalog"."int8_ops" ASC NULLS LAST
);
CREATE INDEX "idx_tasks_finish_time" ON "public"."tasks" USING btree (
  "finish_time" "pg_catalog"."int8_ops" ASC NULLS LAST
);
CREATE INDEX "idx_tasks_platform" ON "public"."tasks" USING btree (
  "platform" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_tasks_progress" ON "public"."tasks" USING btree (
  "progress" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_tasks_start_time" ON "public"."tasks" USING btree (
  "start_time" "pg_catalog"."int8_ops" ASC NULLS LAST
);
CREATE INDEX "idx_tasks_status" ON "public"."tasks" USING btree (
  "status" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_tasks_submit_time" ON "public"."tasks" USING btree (
  "submit_time" "pg_catalog"."int8_ops" ASC NULLS LAST
);
CREATE INDEX "idx_tasks_task_id" ON "public"."tasks" USING btree (
  "task_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_tasks_user_id" ON "public"."tasks" USING btree (
  "user_id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table tasks
-- ----------------------------
ALTER TABLE "public"."tasks" ADD CONSTRAINT "tasks_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table tokens
-- ----------------------------
CREATE INDEX "idx_tokens_deleted_at" ON "public"."tokens" USING btree (
  "deleted_at" "pg_catalog"."timestamptz_ops" ASC NULLS LAST
);
CREATE UNIQUE INDEX "idx_tokens_key" ON "public"."tokens" USING btree (
  "key" COLLATE "pg_catalog"."default" "pg_catalog"."bpchar_ops" ASC NULLS LAST
);
CREATE INDEX "idx_tokens_name" ON "public"."tokens" USING btree (
  "name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_tokens_user_id" ON "public"."tokens" USING btree (
  "user_id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table tokens
-- ----------------------------
ALTER TABLE "public"."tokens" ADD CONSTRAINT "tokens_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table top_ups
-- ----------------------------
CREATE INDEX "idx_top_ups_trade_no" ON "public"."top_ups" USING btree (
  "trade_no" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_top_ups_user_id" ON "public"."top_ups" USING btree (
  "user_id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Uniques structure for table top_ups
-- ----------------------------
ALTER TABLE "public"."top_ups" ADD CONSTRAINT "top_ups_trade_no_key" UNIQUE ("trade_no");

-- ----------------------------
-- Primary Key structure for table top_ups
-- ----------------------------
ALTER TABLE "public"."top_ups" ADD CONSTRAINT "top_ups_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table two_fa_backup_codes
-- ----------------------------
CREATE INDEX "idx_two_fa_backup_codes_deleted_at" ON "public"."two_fa_backup_codes" USING btree (
  "deleted_at" "pg_catalog"."timestamptz_ops" ASC NULLS LAST
);
CREATE INDEX "idx_two_fa_backup_codes_user_id" ON "public"."two_fa_backup_codes" USING btree (
  "user_id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table two_fa_backup_codes
-- ----------------------------
ALTER TABLE "public"."two_fa_backup_codes" ADD CONSTRAINT "two_fa_backup_codes_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table two_fas
-- ----------------------------
CREATE INDEX "idx_two_fas_deleted_at" ON "public"."two_fas" USING btree (
  "deleted_at" "pg_catalog"."timestamptz_ops" ASC NULLS LAST
);
CREATE INDEX "idx_two_fas_user_id" ON "public"."two_fas" USING btree (
  "user_id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Uniques structure for table two_fas
-- ----------------------------
ALTER TABLE "public"."two_fas" ADD CONSTRAINT "two_fas_user_id_key" UNIQUE ("user_id");

-- ----------------------------
-- Primary Key structure for table two_fas
-- ----------------------------
ALTER TABLE "public"."two_fas" ADD CONSTRAINT "two_fas_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table user_oauth_bindings
-- ----------------------------
CREATE UNIQUE INDEX "ux_provider_userid" ON "public"."user_oauth_bindings" USING btree (
  "provider_id" "pg_catalog"."int8_ops" ASC NULLS LAST,
  "provider_user_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE UNIQUE INDEX "ux_user_provider" ON "public"."user_oauth_bindings" USING btree (
  "user_id" "pg_catalog"."int8_ops" ASC NULLS LAST,
  "provider_id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table user_oauth_bindings
-- ----------------------------
ALTER TABLE "public"."user_oauth_bindings" ADD CONSTRAINT "user_oauth_bindings_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table user_subscriptions
-- ----------------------------
CREATE INDEX "idx_user_sub_active" ON "public"."user_subscriptions" USING btree (
  "user_id" "pg_catalog"."int8_ops" ASC NULLS LAST,
  "status" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "end_time" "pg_catalog"."int8_ops" ASC NULLS LAST
);
CREATE INDEX "idx_user_subscriptions_end_time" ON "public"."user_subscriptions" USING btree (
  "end_time" "pg_catalog"."int8_ops" ASC NULLS LAST
);
CREATE INDEX "idx_user_subscriptions_next_reset_time" ON "public"."user_subscriptions" USING btree (
  "next_reset_time" "pg_catalog"."int8_ops" ASC NULLS LAST
);
CREATE INDEX "idx_user_subscriptions_plan_id" ON "public"."user_subscriptions" USING btree (
  "plan_id" "pg_catalog"."int8_ops" ASC NULLS LAST
);
CREATE INDEX "idx_user_subscriptions_status" ON "public"."user_subscriptions" USING btree (
  "status" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_user_subscriptions_user_id" ON "public"."user_subscriptions" USING btree (
  "user_id" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table user_subscriptions
-- ----------------------------
ALTER TABLE "public"."user_subscriptions" ADD CONSTRAINT "user_subscriptions_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table users
-- ----------------------------
CREATE UNIQUE INDEX "idx_users_access_token" ON "public"."users" USING btree (
  "access_token" COLLATE "pg_catalog"."default" "pg_catalog"."bpchar_ops" ASC NULLS LAST
);
CREATE UNIQUE INDEX "idx_users_aff_code" ON "public"."users" USING btree (
  "aff_code" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_users_deleted_at" ON "public"."users" USING btree (
  "deleted_at" "pg_catalog"."timestamptz_ops" ASC NULLS LAST
);
CREATE INDEX "idx_users_discord_id" ON "public"."users" USING btree (
  "discord_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_users_display_name" ON "public"."users" USING btree (
  "display_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_users_email" ON "public"."users" USING btree (
  "email" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_users_git_hub_id" ON "public"."users" USING btree (
  "github_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_users_inviter_id" ON "public"."users" USING btree (
  "inviter_id" "pg_catalog"."int8_ops" ASC NULLS LAST
);
CREATE INDEX "idx_users_linux_do_id" ON "public"."users" USING btree (
  "linux_do_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_users_oidc_id" ON "public"."users" USING btree (
  "oidc_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_users_stripe_customer" ON "public"."users" USING btree (
  "stripe_customer" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_users_telegram_id" ON "public"."users" USING btree (
  "telegram_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_users_username" ON "public"."users" USING btree (
  "username" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_users_we_chat_id" ON "public"."users" USING btree (
  "wechat_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Uniques structure for table users
-- ----------------------------
ALTER TABLE "public"."users" ADD CONSTRAINT "users_username_key" UNIQUE ("username");

-- ----------------------------
-- Primary Key structure for table users
-- ----------------------------
ALTER TABLE "public"."users" ADD CONSTRAINT "users_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table vendors
-- ----------------------------
CREATE INDEX "idx_vendors_deleted_at" ON "public"."vendors" USING btree (
  "deleted_at" "pg_catalog"."timestamptz_ops" ASC NULLS LAST
);
CREATE UNIQUE INDEX "uk_vendor_name_delete_at" ON "public"."vendors" USING btree (
  "name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "deleted_at" "pg_catalog"."timestamptz_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table vendors
-- ----------------------------
ALTER TABLE "public"."vendors" ADD CONSTRAINT "vendors_pkey" PRIMARY KEY ("id");
