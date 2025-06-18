create table foods
(
    id                    bigint auto_increment
        primary key,
    calorie               double       null comment '열량(kcal)(1회제공량당)',
    carbohydrate          double       null comment '탄수화물(g)(1회제공량당)',
    cholesterol           double       null comment '콜레스테롤(mg)(1회제공량당)',
    food_cd               varchar(255) null comment '식품 코드',
    food_name             varchar(255) null comment '식품 이름',
    group_name            varchar(255) null comment '식품 군',
    maker_name            varchar(255) null comment '지역/제조사',
    protein               double       null comment '단백질(g)(1회제공량당)',
    province              double       null comment '지방(g)(1회제공량당)',
    ref_name              varchar(255) null comment '자료 출처',
    research_year         varchar(255) null comment '조사 연도',
    salt                  double       null comment '나트륨(mg)(1회제공량당)',
    sample_id             varchar(255) null comment 'SAMPLE_ID',
    saturated_fatty_acids double       null comment '포화지방산(g)(1회제공량당)',
    serving_size          double       null comment '1회 제공량',
    sugars                double       null comment '총당류(g)(1회제공량당)',
    trans_fat             double       null comment '트랜스지방(g)(1회제공량당)'
);