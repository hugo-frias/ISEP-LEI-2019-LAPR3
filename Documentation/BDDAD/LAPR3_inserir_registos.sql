
-- ** inserir dados nas tabelas **

-- ## tabela Place ##
INSERT INTO place(id_place, latitude_place, longitude_place, elevation, description)
VALUES('P101', 41.150889, -8.609573, 0, 'Parque_Trindade');
INSERT INTO place(id_place, latitude_place, longitude_place, elevation, description)
VALUES('P102', 41.147043, -8.614380, 25, 'Parque_Leões');
INSERT INTO place(id_place, latitude_place, longitude_place, elevation, description)
VALUES('P103', 41.153067, -8.606706, 0, 'Silo_Auto');
INSERT INTO place(id_place, latitude_place, longitude_place, elevation, description)
VALUES('P104', 41.160896, -8.605167, 50, 'Parque_Marquês');
INSERT INTO place(id_place, latitude_place, longitude_place, elevation, description)
VALUES('I201', 41.145801, -8.614615, 0, 'Clérigos');
INSERT INTO place(id_place, latitude_place, longitude_place, elevation, description)
VALUES('I202', 41.143225, -8.621699, 15, 'Alfândega');
INSERT INTO place(id_place, latitude_place, longitude_place, elevation, description)
VALUES('I203', 41.169724, -8.679136, 5, 'Parque da Cidade');
INSERT INTO place(id_place, latitude_place, longitude_place, elevation, description)
VALUES('I204', 41.143060, -8.611173, 0, 'Sé');
INSERT INTO place(id_place, latitude_place, longitude_place, elevation, description)
VALUES('P105', 41.182445, -8.595690, 20, 'Parque_Pedrouços');
INSERT INTO place(id_place, latitude_place, longitude_place, elevation, description)
VALUES('P106', 41.189885, -8.599990, 10, 'Parque_Porto');
COMMIT;


-- ## tabela Park ##
INSERT INTO park(id_park, max_numbicycles, max_numescooters, available_bicycles, available_escooters, input_voltage_park, input_current_park)
VALUES('P101', 10, 4, 2, 2, 220, 16);
INSERT INTO park(id_park, max_numbicycles, max_numescooters, available_bicycles, available_escooters, input_voltage_park, input_current_park)
VALUES('P102', 8, 4, 2, 2, 220, 16);
INSERT INTO park(id_park, max_numbicycles, max_numescooters, available_bicycles, available_escooters, input_voltage_park, input_current_park)
VALUES('P103', 10, 4, 2, 2, 220, 16);
INSERT INTO park(id_park, max_numbicycles, max_numescooters, available_bicycles, available_escooters, input_voltage_park, input_current_park)
VALUES('P104', 6, 4, 2, 2, 220, 16);
INSERT INTO park(id_park, max_numbicycles, max_numescooters, available_bicycles, available_escooters, input_voltage_park, input_current_park)
VALUES('P105', 6, 4, 6, 4, 220, 16);
INSERT INTO park(id_park, max_numbicycles, max_numescooters, available_bicycles, available_escooters, input_voltage_park, input_current_park)
VALUES('P106', 0, 0, 0, 0, 220, 16);


-- ## tabela Point_Of_Interest ##
INSERT INTO point_of_interest(id_poi)
VALUES('I201');
INSERT INTO point_of_interest(id_poi)
VALUES('I202');
INSERT INTO point_of_interest(id_poi)
VALUES('I203');
INSERT INTO point_of_interest(id_poi)
VALUES('I204');
COMMIT;


-- ## tabela Vehicle ##
INSERT INTO vehicle(id_vehicle, weight_vehicle, latitude_vehicle, longitude_vehicle, aerodynamic_coefficient_vehicle, frontal_area_vehicle)
VALUES('B101', 50, 41.150889, -8.609573, 1.5, 3);
INSERT INTO vehicle(id_vehicle, weight_vehicle, latitude_vehicle, longitude_vehicle, aerodynamic_coefficient_vehicle, frontal_area_vehicle)
VALUES('B102', 55, 41.150889, -8.609573, 1.5, 3);
INSERT INTO vehicle(id_vehicle, weight_vehicle, latitude_vehicle, longitude_vehicle, aerodynamic_coefficient_vehicle, frontal_area_vehicle)
VALUES('S201', 70, 41.150889, -8.609573, 3.5, 9);
INSERT INTO vehicle(id_vehicle, weight_vehicle, latitude_vehicle, longitude_vehicle, aerodynamic_coefficient_vehicle, frontal_area_vehicle)
VALUES('S202', 60, 41.150889, -8.609573, 3.5, 9);
INSERT INTO vehicle(id_vehicle, weight_vehicle, latitude_vehicle, longitude_vehicle, aerodynamic_coefficient_vehicle, frontal_area_vehicle)
VALUES('B103', 50, 41.147043, -8.614380, 1.5, 3);
INSERT INTO vehicle(id_vehicle, weight_vehicle, latitude_vehicle, longitude_vehicle, aerodynamic_coefficient_vehicle, frontal_area_vehicle)
VALUES('B104', 40, 41.147043, -8.614380, 1.5, 3);
INSERT INTO vehicle(id_vehicle, weight_vehicle, latitude_vehicle, longitude_vehicle, aerodynamic_coefficient_vehicle, frontal_area_vehicle)
VALUES('S203', 80, 41.147043, -8.614380, 2.5, 6);
INSERT INTO vehicle(id_vehicle, weight_vehicle, latitude_vehicle, longitude_vehicle, aerodynamic_coefficient_vehicle, frontal_area_vehicle)
VALUES('S204', 70, 41.147043, -8.614380, 2.5, 6);
INSERT INTO vehicle(id_vehicle, weight_vehicle, latitude_vehicle, longitude_vehicle, aerodynamic_coefficient_vehicle, frontal_area_vehicle)
VALUES('B105', 45, 41.147043, -8.614380, 2.0, 9);
INSERT INTO vehicle(id_vehicle, weight_vehicle, latitude_vehicle, longitude_vehicle, aerodynamic_coefficient_vehicle, frontal_area_vehicle)
VALUES('B106', 65, 41.147043, -8.614380, 2.0, 9);
INSERT INTO vehicle(id_vehicle, weight_vehicle, latitude_vehicle, longitude_vehicle, aerodynamic_coefficient_vehicle, frontal_area_vehicle)
VALUES('S205', 70, 41.147043, -8.614380, 1.5, 3);
INSERT INTO vehicle(id_vehicle, weight_vehicle, latitude_vehicle, longitude_vehicle, aerodynamic_coefficient_vehicle, frontal_area_vehicle)
VALUES('S206', 80, 41.147043, -8.614380, 1.5, 3);
INSERT INTO vehicle(id_vehicle, weight_vehicle, latitude_vehicle, longitude_vehicle, aerodynamic_coefficient_vehicle, frontal_area_vehicle)
VALUES('B107', 45, 41.153067, -8.606706, 2.5, 6);
INSERT INTO vehicle(id_vehicle, weight_vehicle, latitude_vehicle, longitude_vehicle, aerodynamic_coefficient_vehicle, frontal_area_vehicle)
VALUES('B108', 55, 41.153067, -8.606706, 2.0, 9);
INSERT INTO vehicle(id_vehicle, weight_vehicle, latitude_vehicle, longitude_vehicle, aerodynamic_coefficient_vehicle, frontal_area_vehicle)
VALUES('S207', 40, 41.153067, -8.606706, 1.5, 3);
INSERT INTO vehicle(id_vehicle, weight_vehicle, latitude_vehicle, longitude_vehicle, aerodynamic_coefficient_vehicle, frontal_area_vehicle)
VALUES('S208', 50, 41.153067, -8.606706, 2.5, 6);
INSERT INTO vehicle(id_vehicle, weight_vehicle, latitude_vehicle, longitude_vehicle, aerodynamic_coefficient_vehicle, frontal_area_vehicle)
VALUES('B109', 50, 41.189885, -8.599990, 2.5, 6);
INSERT INTO vehicle(id_vehicle, weight_vehicle, latitude_vehicle, longitude_vehicle, aerodynamic_coefficient_vehicle, frontal_area_vehicle)
VALUES('B110', 50, 41.189885, -8.599990, 2.5, 6);
INSERT INTO vehicle(id_vehicle, weight_vehicle, latitude_vehicle, longitude_vehicle, aerodynamic_coefficient_vehicle, frontal_area_vehicle)
VALUES('S209', 60, 41.189885, -8.599990, 2.5, 9);
INSERT INTO vehicle(id_vehicle, weight_vehicle, latitude_vehicle, longitude_vehicle, aerodynamic_coefficient_vehicle, frontal_area_vehicle)
VALUES('S210', 70, 41.189885, -8.599990, 2.5, 8);
COMMIT;


-- ## tabela Bicycle ##
INSERT INTO bicycle(id_bicycle, wheel_size)
VALUES('B101', 70);
INSERT INTO bicycle(id_bicycle, wheel_size)
VALUES('B102', 80);
INSERT INTO bicycle(id_bicycle, wheel_size)
VALUES('B103', 70);
INSERT INTO bicycle(id_bicycle, wheel_size)
VALUES('B104', 60);
INSERT INTO bicycle(id_bicycle, wheel_size)
VALUES('B105', 70);
INSERT INTO bicycle(id_bicycle, wheel_size)
VALUES('B106', 75);
INSERT INTO bicycle(id_bicycle, wheel_size)
VALUES('B107', 60);
INSERT INTO bicycle(id_bicycle, wheel_size)
VALUES('B108', 80);
INSERT INTO bicycle(id_bicycle, wheel_size)
VALUES('B109', 50);
INSERT INTO bicycle(id_bicycle, wheel_size)
VALUES('B110', 80);
COMMIT;


-- ## tabela Electric_Scooter ##
INSERT INTO electric_scooter(id_escooter, type_escooter, max_battery, actual_battery, motor)
VALUES('S201', 'OR', 500, 500, 250);
INSERT INTO electric_scooter(id_escooter, type_escooter, max_battery, actual_battery, motor)
VALUES('S202', 'CI', 600, 400, 200);
INSERT INTO electric_scooter(id_escooter, type_escooter, max_battery, actual_battery, motor)
VALUES('S203', 'OR', 700, 550, 250);
INSERT INTO electric_scooter(id_escooter, type_escooter, max_battery, actual_battery, motor)
VALUES('S204', 'CI', 500, 500, 200);
INSERT INTO electric_scooter(id_escooter, type_escooter, max_battery, actual_battery, motor)
VALUES('S205', 'OR', 600, 450, 250);
INSERT INTO electric_scooter(id_escooter, type_escooter, max_battery, actual_battery, motor)
VALUES('S206', 'CI', 700, 100, 200);
INSERT INTO electric_scooter(id_escooter, type_escooter, max_battery, actual_battery, motor)
VALUES('S207', 'OR', 500, 500, 250);
INSERT INTO electric_scooter(id_escooter, type_escooter, max_battery, actual_battery, motor)
VALUES('S208', 'CI', 600, 450, 200);
INSERT INTO electric_scooter(id_escooter, type_escooter, max_battery, actual_battery, motor)
VALUES('S209', 'OR', 700, 500, 250);
INSERT INTO electric_scooter(id_escooter, type_escooter, max_battery, actual_battery, motor)
VALUES('S210', 'CI', 600, 600, 200);
COMMIT;


-- ## tabela App_User ##
INSERT INTO app_user(user_name, user_email, user_pass, height, weight, gender, cyclingAvgSpeed, visaCardNumber, points)
VALUES('Carlos', 'carlos@isep.pt', 'isepcarlos', 170, 70, 'M', 20, 123456789, 0);
INSERT INTO app_user(user_name, user_email, user_pass, height, weight, gender, cyclingAvgSpeed, visaCardNumber, points)
VALUES('Luis', 'luis@isep.pt', 'isepluis', 180, 80, 'M', 15, 987654321, 0);
INSERT INTO app_user(user_name, user_email, user_pass, height, weight, gender, cyclingAvgSpeed, visaCardNumber, points)
VALUES('Ana', 'ana@isep.pt', 'isepana', 160, 60, 'F', 10, 123987465, 0);
INSERT INTO app_user(user_name, user_email, user_pass, height, weight, gender, cyclingAvgSpeed, visaCardNumber, points)
VALUES('Maria', 'maria@isep.pt', 'isepmaria', 150, 50, 'F', 5, 321789645, 0);
COMMIT;


-- ## tabela Rent ##
INSERT INTO rent(id_rent, user_email, id_vehicle, id_park_start, id_park_end, date_hour_start, date_hour_finish, rent_cost, distance, points_rent)
VALUES('R01', 'carlos@isep.pt', 'B101', 'P101', 'P104', TO_TIMESTAMP('2019-12-20 09:00:00', 'yyyy-mm-dd HH24:MI:SS'), TO_TIMESTAMP('2019-12-21 12:00:00', 'yyyy-mm-dd HH24:MI:SS'), 10, 20, 30);
INSERT INTO rent(id_rent, user_email, id_vehicle, id_park_start, id_park_end, date_hour_start, date_hour_finish, rent_cost, distance, points_rent)
VALUES('R02', 'luis@isep.pt', 'S201', 'P101', 'P103', TO_TIMESTAMP('2019-12-22 12:00:00', 'yyyy-mm-dd HH24:MI:SS'), TO_TIMESTAMP('2019-12-23 09:00:00', 'yyyy-mm-dd HH24:MI:SS'), 30, 20, 10);
INSERT INTO rent(id_rent, user_email, id_vehicle, id_park_start, id_park_end, date_hour_start, date_hour_finish, rent_cost, distance, points_rent)
VALUES('R03', 'ana@isep.pt', 'B103', 'P102', 'P101', TO_TIMESTAMP('2019-12-19 08:00:00', 'yyyy-mm-dd HH24:MI:SS'), TO_TIMESTAMP('2019-12-19 18:00:00', 'yyyy-mm-dd HH24:MI:SS'), 10, 20, 30);
INSERT INTO rent(id_rent, user_email, id_vehicle, id_park_start, id_park_end, date_hour_start, date_hour_finish, rent_cost, distance, points_rent)
VALUES('R04', 'maria@isep.pt', 'S205', 'P103', 'P104', TO_TIMESTAMP('2020-12-02 09:00:00', 'yyyy-mm-dd HH24:MI:SS'), TO_TIMESTAMP('2020-12-05 12:00:00', 'yyyy-mm-dd HH24:MI:SS'), 30, 20, 10);
INSERT INTO rent(id_rent, user_email, id_vehicle, id_park_start, id_park_end, date_hour_start, date_hour_finish, rent_cost, distance, points_rent)
VALUES('R05', 'carlos@isep.pt', 'B104', 'P102', 'P103', TO_TIMESTAMP('2019-01-20 09:00:00', 'yyyy-mm-dd HH24:MI:SS'), TO_TIMESTAMP('2019-01-21 12:00:00', 'yyyy-mm-dd HH24:MI:SS'), 40, 50, 60);
INSERT INTO rent(id_rent, user_email, id_vehicle, id_park_start, id_park_end, date_hour_start, date_hour_finish, rent_cost, distance, points_rent)
VALUES('R06', 'luis@isep.pt', 'S204', 'P102', 'P101', TO_TIMESTAMP('2019-01-22 12:00:00', 'yyyy-mm-dd HH24:MI:SS'), TO_TIMESTAMP('2019-01-23 09:00:00', 'yyyy-mm-dd HH24:MI:SS'), 60, 50, 40);
INSERT INTO rent(id_rent, user_email, id_vehicle, id_park_start, id_park_end, date_hour_start, date_hour_finish, rent_cost, distance, points_rent)
VALUES('R07', 'ana@isep.pt', 'B107', 'P104', 'P101', TO_TIMESTAMP('2019-01-19 08:00:00', 'yyyy-mm-dd HH24:MI:SS'), TO_TIMESTAMP('2019-01-19 18:00:00', 'yyyy-mm-dd HH24:MI:SS'), 40, 50, 60);
INSERT INTO rent(id_rent, user_email, id_vehicle, id_park_start, id_park_end, date_hour_start, date_hour_finish, rent_cost, distance, points_rent)
VALUES('R08', 'maria@isep.pt', 'S208', 'P104', 'P103', TO_TIMESTAMP('2020-01-22 09:00:00', 'yyyy-mm-dd HH24:MI:SS'), TO_TIMESTAMP('2020-01-25 12:00:00', 'yyyy-mm-dd HH24:MI:SS'), 60, 50, 40);
COMMIT;


-- ## tabela Travel_Path ##
--o valor de caminhos diretos entre dois pontos é igual a:  n*(n-1)/2  (n = Places)
INSERT INTO travel_path(id_place_start, id_place_end, kinetic_coefficient, wind_direction, wind_speed)
VALUES('P101', 'P104', 10.25, 0, 0);
INSERT INTO travel_path(id_place_start, id_place_end, kinetic_coefficient, wind_direction, wind_speed)
VALUES('P101', 'I201', 10.25, 0, 0);
INSERT INTO travel_path(id_place_start, id_place_end, kinetic_coefficient, wind_direction, wind_speed)
VALUES('I201', 'I202', 10.25, 0, 0);
INSERT INTO travel_path(id_place_start, id_place_end, kinetic_coefficient, wind_direction, wind_speed)
VALUES('I202', 'P103', 10.25, 0, 0);
INSERT INTO travel_path(id_place_start, id_place_end, kinetic_coefficient, wind_direction, wind_speed)
VALUES('P102', 'P101', 10.25, 0, 0);
INSERT INTO travel_path(id_place_start, id_place_end, kinetic_coefficient, wind_direction, wind_speed)
VALUES('P103', 'I203', 10.25, 0, 0);
INSERT INTO travel_path(id_place_start, id_place_end, kinetic_coefficient, wind_direction, wind_speed)
VALUES('I203', 'I204', 10.25, 0, 0);
INSERT INTO travel_path(id_place_start, id_place_end, kinetic_coefficient, wind_direction, wind_speed)
VALUES('I204', 'P104', 10.25, 0, 0);
INSERT INTO travel_path(id_place_start, id_place_end, kinetic_coefficient, wind_direction, wind_speed)
VALUES('P102', 'P103', 10.25, 0, 0);
--...'R06'
INSERT INTO travel_path(id_place_start, id_place_end, kinetic_coefficient, wind_direction, wind_speed)
VALUES('P102', 'P101', 10.25, 0, 0);
--...'R06'
INSERT INTO travel_path(id_place_start, id_place_end, kinetic_coefficient, wind_direction, wind_speed)
VALUES('P104', 'P101', 10.25, 0, 0);
--...'R08'
INSERT INTO travel_path(id_place_start, id_place_end, kinetic_coefficient, wind_direction, wind_speed)
VALUES('P104', 'P103', 10.25, 0, 0);
--...'R08'
COMMIT;


-- ## tabela Invoice ##
INSERT INTO invoice(id_invoice, user_email, invoice_date, total_cost)
VALUES('IV01', 'carlos@isep.pt', TO_DATE('2020-01-05', 'yyyy-mm-dd'), 0);
INSERT INTO invoice(id_invoice, user_email, invoice_date, total_cost)
VALUES('IV02', 'luis@isep.pt', TO_DATE('2020-01-05', 'yyyy-mm-dd'), 0);
INSERT INTO invoice(id_invoice, user_email, invoice_date, total_cost)
VALUES('IV03', 'ana@isep.pt', TO_DATE('2020-01-05', 'yyyy-mm-dd'), 0);
INSERT INTO invoice(id_invoice, user_email, invoice_date, total_cost)
VALUES('IV04', 'maria@isep.pt', TO_DATE('2020-01-05', 'yyyy-mm-dd'), 0);
INSERT INTO invoice(id_invoice, user_email, invoice_date, total_cost)
VALUES('IV05', 'carlos@isep.pt', TO_DATE('2020-02-05', 'yyyy-mm-dd'), 0);
INSERT INTO invoice(id_invoice, user_email, invoice_date, total_cost)
VALUES('IV06', 'luis@isep.pt', TO_DATE('2020-02-05', 'yyyy-mm-dd'), 0);
INSERT INTO invoice(id_invoice, user_email, invoice_date, total_cost)
VALUES('IV07', 'ana@isep.pt', TO_DATE('2020-02-05', 'yyyy-mm-dd'), 0);
INSERT INTO invoice(id_invoice, user_email, invoice_date, total_cost)
VALUES('IV08', 'maria@isep.pt', TO_DATE('2020-02-05', 'yyyy-mm-dd'), 0);
COMMIT;

