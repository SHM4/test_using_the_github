create table food(
food_pk number(5) 
constraint food_pk primary key,
food_name varchar2(30),
food_calorie number(6),
food_metricname varchar2(10),
food_metricgrams number(5),
food_category varchar2(10),
food_carb number(5),
food_fat number(5),
food_protein number(5),
food_sodium number(5));

