create table food(
food_pk number(5) 
constraint food_pk primary key,
food_name varchar2(30),
food_calorie number(7,2),
food_metricname varchar2(20),
food_metricgrams number(5),
food_category varchar2(20),
food_carb number(5,2),
food_fat number(5,2),
food_protein number(5,2),
food_sodium number(6,2));

drop table food;

desc food;
select * from food;

delete from food;

INSERT INTO food (food_pk, food_name, food_calorie, food_metricgrams, food_category, food_carb, food_fat, food_protein, food_sodium ) VALUES ('1', '꿩불고기', '368.8', '500', '구이류', '39.7', '8.5', '33.5', '1264.31 ');
INSERT INTO food (food_pk, food_name, food_calorie, food_metricgrams, food_category, food_carb, food_fat, food_protein, food_sodium ) VALUES ('2', '닭갈비', '595.61', '400', '구이류', '44.9', '25.8', '45.9', '1535.83 ');
INSERT INTO food (food_pk, food_name, food_calorie, food_metricgrams, food_category, food_carb, food_fat, food_protein, food_sodium ) VALUES ('3', '닭갈비', '558.47', '300', '구이류', '23.1', '31.6', '45.5', '1016.94 ');
INSERT INTO food (food_pk, food_name, food_calorie, food_metricgrams, food_category, food_carb, food_fat, food_protein, food_sodium ) VALUES ('4', '닭꼬치', '176.72', '70', '구이류', '13.35', '8.57', '11.56', '286.91 ');
INSERT INTO food (food_pk, food_name, food_calorie, food_metricgrams, food_category, food_carb, food_fat, food_protein, food_sodium ) VALUES ('5', '더덕구이', '184', '100', '구이류', '31.1', '5.2', '3.1', '743.37 ');
INSERT INTO food (food_pk, food_name, food_calorie, food_metricgrams, food_category, food_carb, food_fat, food_protein, food_sodium ) VALUES ('6', '도미구이', '397', '250', '구이류', '2.1', '16.5', '61.1', '1582.17 ');
INSERT INTO food (food_pk, food_name, food_calorie, food_metricgrams, food_category, food_carb, food_fat, food_protein, food_sodium ) VALUES ('7', '돼지갈비', '240.32', '100', '구이류', '8.1', '14.4', '19.5', '404.66 ');
INSERT INTO food (food_pk, food_name, food_calorie, food_metricgrams, food_category, food_carb, food_fat, food_protein, food_sodium ) VALUES ('8', '병어구이', '488', '250', '구이류', '0.2', '30.8', '54.6', '1567.94 ');
INSERT INTO food (food_pk, food_name, food_calorie, food_metricgrams, food_category, food_carb, food_fat, food_protein, food_sodium ) VALUES ('9', '불고기', '395.29', '150', '구이류', '7.8', '25.2', '34.4', '560.71 ');
INSERT INTO food (food_pk, food_name, food_calorie, food_metricgrams, food_category, food_carb, food_fat, food_protein, food_sodium ) VALUES ('10', '붕장어소금구이', '296.54', '100', '구이류', '11.6', '16.2', '26', '124.75 ');
INSERT INTO food (food_pk, food_name, food_calorie, food_metricgrams, food_category, food_carb, food_fat, food_protein, food_sodium ) VALUES ('11', '소양념갈비구이', '989.15', '300', '구이류', '26.2', '71.6', '60.1', '1378.45 ');
INSERT INTO food (food_pk, food_name, food_calorie, food_metricgrams, food_category, food_carb, food_fat, food_protein, food_sodium ) VALUES ('12', '양념왕갈비', '480.81', '150', '구이류', '13.7', '35.3', '27.1', '548.76 ');
INSERT INTO food (food_pk, food_name, food_calorie, food_metricgrams, food_category, food_carb, food_fat, food_protein, food_sodium ) VALUES ('13', '양념장어구이', '433.35', '150', '구이류', '8.8', '30.56', '30.77', '704.64 ');
INSERT INTO food (food_pk, food_name, food_calorie, food_metricgrams, food_category, food_carb, food_fat, food_protein, food_sodium ) VALUES ('14', '임연수구이', '494', '250', '구이류', '3.5', '29.4', '53.8', '1568.96 ');
INSERT INTO food (food_pk, food_name, food_calorie, food_metricgrams, food_category, food_carb, food_fat, food_protein, food_sodium ) VALUES ('15', '짚불구이곰장어', '326.21', '200', '구이류', '2.3', '16.2', '42.7', '826.79 ');
INSERT INTO food (food_pk, food_name, food_calorie, food_metricgrams, food_category, food_carb, food_fat, food_protein, food_sodium ) VALUES ('16', '햄버그스테이크', '457.7', '200', '구이류', '20.76', '29.65', '26.96', '950.22 ');
INSERT INTO food (food_pk, food_name, food_calorie, food_metricgrams, food_category, food_carb, food_fat, food_protein, food_sodium ) VALUES ('17', '황태구이', '437.57', '200', '구이류', '26.9', '15.4', '47.8', '1135.33 ');
INSERT INTO food (food_pk, food_name, food_calorie, food_metricgrams, food_category, food_carb, food_fat, food_protein, food_sodium ) VALUES ('18', '훈제오리', '797.14', '250', '구이류', '12.08', '64.07', '43.06', '1220.37 ');
INSERT INTO food (food_pk, food_name, food_calorie, food_metricgrams, food_category, food_carb, food_fat, food_protein, food_sodium ) VALUES ('19', '게국지', '415.25', '1100', '국 및 탕류', '31.7', '12.1', '44.9', '4047.26 ');