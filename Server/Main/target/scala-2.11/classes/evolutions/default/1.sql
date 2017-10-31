# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table device (
  id                            bigint auto_increment not null,
  name                          varchar(255),
  description                   varchar(255),
  constraint pk_device primary key (id)
);

create table gesture (
  id                            bigint auto_increment not null,
  name                          varchar(255),
  description                   varchar(255),
  constraint pk_gesture primary key (id)
);

create table hand (
  hand_id                       bigint auto_increment not null,
  timestamp                     bigint,
  device_id                     varchar(255),
  is_right                      boolean,
  hand_position_x               float,
  hand_position_y               float,
  hand_position_z               float,
  palm_normal_pitch             float,
  palm_normal_yaw               float,
  palm_normal_roll              float,
  direction_pitch               float,
  direction_yaw                 float,
  direction_roll                float,
  grab_angle                    float,
  pinch_distance                float,
  thumb_direction_pitch         float,
  thumb_direction_yaw           float,
  thumb_direction_roll          float,
  thumb_center_x                float,
  thumb_center_y                float,
  thumb_center_z                float,
  index_direction_pitch         float,
  index_direction_yaw           float,
  index_direction_roll          float,
  index_center_x                float,
  index_center_y                float,
  index_center_z                float,
  middle_direction_pitch        float,
  middle_direction_yaw          float,
  middle_direction_roll         float,
  middle_center_x               float,
  middle_center_y               float,
  middle_center_z               float,
  ring_direction_pitch          float,
  ring_direction_yaw            float,
  ring_direction_roll           float,
  ring_center_x                 float,
  ring_center_y                 float,
  ring_center_z                 float,
  pinky_direction_pitch         float,
  pinky_direction_yaw           float,
  pinky_direction_roll          float,
  pinky_center_x                float,
  pinky_center_y                float,
  pinky_center_z                float,
  constraint pk_hand primary key (hand_id)
);

create table training_data (
  id                            bigint auto_increment not null,
  user_id                       bigint,
  session_id                    uuid,
  gesture_id                    bigint,
  device_id                     bigint,
  hand_id                       bigint,
  timestamp                     bigint,
  is_right                      boolean,
  hand_position_x               float,
  hand_position_y               float,
  hand_position_z               float,
  palm_normal_pitch             float,
  palm_normal_yaw               float,
  palm_normal_roll              float,
  direction_pitch               float,
  direction_yaw                 float,
  direction_roll                float,
  grab_angle                    float,
  pinch_distance                float,
  thumb_direction_pitch         float,
  thumb_direction_yaw           float,
  thumb_direction_roll          float,
  thumb_center_x                float,
  thumb_center_y                float,
  thumb_center_z                float,
  index_direction_pitch         float,
  index_direction_yaw           float,
  index_direction_roll          float,
  index_center_x                float,
  index_center_y                float,
  index_center_z                float,
  middle_direction_pitch        float,
  middle_direction_yaw          float,
  middle_direction_roll         float,
  middle_center_x               float,
  middle_center_y               float,
  middle_center_z               float,
  ring_direction_pitch          float,
  ring_direction_yaw            float,
  ring_direction_roll           float,
  ring_center_x                 float,
  ring_center_y                 float,
  ring_center_z                 float,
  pinky_direction_pitch         float,
  pinky_direction_yaw           float,
  pinky_direction_roll          float,
  pinky_center_x                float,
  pinky_center_y                float,
  pinky_center_z                float,
  constraint pk_training_data primary key (id)
);

create table user (
  id                            bigint auto_increment not null,
  prename                       varchar(255),
  surname                       varchar(255),
  right_handed                  boolean default false not null,
  constraint pk_user primary key (id)
);

alter table training_data add constraint fk_training_data_user_id foreign key (user_id) references user (id) on delete restrict on update restrict;
create index ix_training_data_user_id on training_data (user_id);

alter table training_data add constraint fk_training_data_gesture_id foreign key (gesture_id) references gesture (id) on delete restrict on update restrict;
create index ix_training_data_gesture_id on training_data (gesture_id);

alter table training_data add constraint fk_training_data_device_id foreign key (device_id) references device (id) on delete restrict on update restrict;
create index ix_training_data_device_id on training_data (device_id);


# --- !Downs

alter table training_data drop constraint if exists fk_training_data_user_id;
drop index if exists ix_training_data_user_id;

alter table training_data drop constraint if exists fk_training_data_gesture_id;
drop index if exists ix_training_data_gesture_id;

alter table training_data drop constraint if exists fk_training_data_device_id;
drop index if exists ix_training_data_device_id;

drop table if exists device;

drop table if exists gesture;

drop table if exists hand;

drop table if exists training_data;

drop table if exists user;

