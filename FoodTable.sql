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

INSERT INTO food (food_pk, food_name, food_calorie, food_metricgrams, food_category, food_carb, food_fat, food_protein, food_sodium ) VALUES ('1', '��Ұ��', '368.8', '500', '���̷�', '39.7', '8.5', '33.5', '1264.31 ');
INSERT INTO food (food_pk, food_name, food_calorie, food_metricgrams, food_category, food_carb, food_fat, food_protein, food_sodium ) VALUES ('2', '�߰���', '595.61', '400', '���̷�', '44.9', '25.8', '45.9', '1535.83 ');
INSERT INTO food (food_pk, food_name, food_calorie, food_metricgrams, food_category, food_carb, food_fat, food_protein, food_sodium ) VALUES ('3', '�߰���', '558.47', '300', '���̷�', '23.1', '31.6', '45.5', '1016.94 ');
INSERT INTO food (food_pk, food_name, food_calorie, food_metricgrams, food_category, food_carb, food_fat, food_protein, food_sodium ) VALUES ('4', '�߲�ġ', '176.72', '70', '���̷�', '13.35', '8.57', '11.56', '286.91 ');
INSERT INTO food (food_pk, food_name, food_calorie, food_metricgrams, food_category, food_carb, food_fat, food_protein, food_sodium ) VALUES ('5', '��������', '184', '100', '���̷�', '31.1', '5.2', '3.1', '743.37 ');
INSERT INTO food (food_pk, food_name, food_calorie, food_metricgrams, food_category, food_carb, food_fat, food_protein, food_sodium ) VALUES ('6', '���̱���', '397', '250', '���̷�', '2.1', '16.5', '61.1', '1582.17 ');
INSERT INTO food (food_pk, food_name, food_calorie, food_metricgrams, food_category, food_carb, food_fat, food_protein, food_sodium ) VALUES ('7', '��������', '240.32', '100', '���̷�', '8.1', '14.4', '19.5', '404.66 ');
INSERT INTO food (food_pk, food_name, food_calorie, food_metricgrams, food_category, food_carb, food_fat, food_protein, food_sodium ) VALUES ('8', '�����', '488', '250', '���̷�', '0.2', '30.8', '54.6', '1567.94 ');
INSERT INTO food (food_pk, food_name, food_calorie, food_metricgrams, food_category, food_carb, food_fat, food_protein, food_sodium ) VALUES ('9', '�Ұ��', '395.29', '150', '���̷�', '7.8', '25.2', '34.4', '560.71 ');
INSERT INTO food (food_pk, food_name, food_calorie, food_metricgrams, food_category, food_carb, food_fat, food_protein, food_sodium ) VALUES ('10', '�����ұݱ���', '296.54', '100', '���̷�', '11.6', '16.2', '26', '124.75 ');
INSERT INTO food (food_pk, food_name, food_calorie, food_metricgrams, food_category, food_carb, food_fat, food_protein, food_sodium ) VALUES ('11', '�Ҿ�䰥����', '989.15', '300', '���̷�', '26.2', '71.6', '60.1', '1378.45 ');
INSERT INTO food (food_pk, food_name, food_calorie, food_metricgrams, food_category, food_carb, food_fat, food_protein, food_sodium ) VALUES ('12', '���հ���', '480.81', '150', '���̷�', '13.7', '35.3', '27.1', '548.76 ');
INSERT INTO food (food_pk, food_name, food_calorie, food_metricgrams, food_category, food_carb, food_fat, food_protein, food_sodium ) VALUES ('13', '�������', '433.35', '150', '���̷�', '8.8', '30.56', '30.77', '704.64 ');
INSERT INTO food (food_pk, food_name, food_calorie, food_metricgrams, food_category, food_carb, food_fat, food_protein, food_sodium ) VALUES ('14', '�ӿ�������', '494', '250', '���̷�', '3.5', '29.4', '53.8', '1568.96 ');
INSERT INTO food (food_pk, food_name, food_calorie, food_metricgrams, food_category, food_carb, food_fat, food_protein, food_sodium ) VALUES ('15', '¤�ұ��̰����', '326.21', '200', '���̷�', '2.3', '16.2', '42.7', '826.79 ');
INSERT INTO food (food_pk, food_name, food_calorie, food_metricgrams, food_category, food_carb, food_fat, food_protein, food_sodium ) VALUES ('16', '�ܹ��׽�����ũ', '457.7', '200', '���̷�', '20.76', '29.65', '26.96', '950.22 ');
INSERT INTO food (food_pk, food_name, food_calorie, food_metricgrams, food_category, food_carb, food_fat, food_protein, food_sodium ) VALUES ('17', 'Ȳ�±���', '437.57', '200', '���̷�', '26.9', '15.4', '47.8', '1135.33 ');
INSERT INTO food (food_pk, food_name, food_calorie, food_metricgrams, food_category, food_carb, food_fat, food_protein, food_sodium ) VALUES ('18', '��������', '797.14', '250', '���̷�', '12.08', '64.07', '43.06', '1220.37 ');
INSERT INTO food (food_pk, food_name, food_calorie, food_metricgrams, food_category, food_carb, food_fat, food_protein, food_sodium ) VALUES ('19', '�Ա���', '415.25', '1100', '�� �� ����', '31.7', '12.1', '44.9', '4047.26 ');