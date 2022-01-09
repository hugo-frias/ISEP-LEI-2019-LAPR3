
-- ** eliminar tabelas se existentes **
-- CASCADE CONSTRAINTS para eliminar as restricoes de integridade das chaves primarias e chaves unicas
-- PURGE elimina a tabela da base de dados e da "reciclagem"
DROP TABLE Place		CASCADE CONSTRAINTS PURGE;
DROP TABLE Vehicle		CASCADE CONSTRAINTS PURGE;
DROP TABLE Bicycle		CASCADE CONSTRAINTS PURGE;
DROP TABLE Electric_Scooter 	CASCADE CONSTRAINTS PURGE;
DROP TABLE Park      		CASCADE CONSTRAINTS PURGE;
DROP TABLE Point_Of_Interest	CASCADE CONSTRAINTS PURGE;
DROP TABLE App_User		CASCADE CONSTRAINTS PURGE;
DROP TABLE Rent			CASCADE CONSTRAINTS PURGE;
DROP TABLE Travel_Path		CASCADE CONSTRAINTS PURGE;
DROP TABLE Invoice		CASCADE CONSTRAINTS PURGE;



-- ## tabela Place ##
CREATE TABLE Place (
    id_place			VARCHAR(30)		CONSTRAINT pk_place_id_place		PRIMARY KEY
							CONSTRAINT nn_place_id_place		NOT NULL,

    latitude_place       	NUMBER(8,6)		CONSTRAINT uk_place_latitude_place	UNIQUE,
                    
    longitude_place		NUMBER(8,6)		CONSTRAINT uk_place_longitude_place	UNIQUE,

    elevation			NUMBER(3,0),

    description            	CHAR(50),

CONSTRAINT ck_place_elevation CHECK (elevation >= 0)
);


-- ## tabela Vehicle ##
CREATE TABLE Vehicle (
    id_vehicle				VARCHAR(30)		CONSTRAINT pk_vehicle_id_vehicle	PRIMARY KEY
								CONSTRAINT nn_vehicle_id_vehicle	NOT NULL,

    weight_vehicle                   	NUMBER(3,0),

    latitude_vehicle    		NUMBER(8,6),

    longitude_vehicle    	     	NUMBER(8,6),

    aerodynamic_coefficient_vehicle   	NUMBER(3,2),

    frontal_area_vehicle             	NUMBER(2,1),

--    cmp_name				CHAR(20),

CONSTRAINT ck_vehicle_weight_vehicle CHECK (weight_vehicle > 0),
CONSTRAINT ck_vehicle_frontal_area_vehicle CHECK (frontal_area_vehicle > 0)
);


-- ## tabela Bicycle ##
CREATE TABLE Bicycle (
    id_bicycle		VARCHAR(30)		CONSTRAINT pk_bicycle_id_bike	PRIMARY KEY,

    wheel_size		NUMBER(2,0)
--wheel_size é medido em centímetros e representa o perímetro
);


-- ## tabela ElectricScooter ##
CREATE TABLE Electric_Scooter (
    id_escooter         VARCHAR(30)		CONSTRAINT pk_electric_scooter_id_escooter	PRIMARY KEY,        

    type_escooter	CHAR(2),

    max_battery		NUMBER(7,0),

    actual_battery	NUMBER(7,0),

    motor		NUMBER(4,0),
--motor é medido em W (p.ex. 250)

CONSTRAINT ck_electric_scooter_type_escooter	CHECK (REGEXP_LIKE(type_escooter, '[OR]{2}|[CI]{2}')),
--'OR' – Off-Road; 'CI' - City;
CONSTRAINT ck_electric_scooter_actual_battery_escooter CHECK (actual_battery <= max_battery)
);


-- ## tabela Park ##
CREATE TABLE Park (
    id_park			VARCHAR(30)	CONSTRAINT nn_park_id_park			NOT NULL
						CONSTRAINT pk_park_id_park			PRIMARY KEY,

    max_numbicycles	        NUMBER(3,0)		CONSTRAINT nn_park_max_numbicycles_park		NOT NULL,

    max_numescooters	 	NUMBER(3,0)		CONSTRAINT nn_park_max_numescooters_park	NOT NULL,

    available_bicycles		NUMBER(3,0),

    available_escooters		NUMBER(3,0),

    input_voltage_park          NUMBER(4,0),
--valor da voltagem (V)

    input_current_park          NUMBER(4,0),
--valor da Corrente (A)

--all parks are provided with a 16A current and 220v tension (A * V = W)
--A Joule is a unit related to energy or work performed on a system. A Watt is a unit of power or the rate which energy is consumed per unit time.
CONSTRAINT ck_park_availability_bicycles CHECK (available_bicycles <= max_numbicycles),
CONSTRAINT ck_park_availability_escooters CHECK (available_escooters <= max_numescooters)
);


-- ## tabela PointOfInterest ##
CREATE TABLE Point_Of_Interest (
    id_poi		VARCHAR(30)	CONSTRAINT nn_point_of_interest_id_poi		NOT NULL
					CONSTRAINT pk_point_of_interest_id_poi		PRIMARY KEY
);


-- ## tabela AppUser ##
CREATE TABLE App_User (
    user_name			VARCHAR(100)	CONSTRAINT nn_app_user_user_name		NOT NULL
						CONSTRAINT uk_app_user_user_name		UNIQUE,

    user_email			VARCHAR(30)	CONSTRAINT pk_app_user_user_email		PRIMARY KEY,

    user_pass			CHAR(10)	CONSTRAINT nn_app_user_user_pass		NOT NULL,
   
    height			NUMBER(3,0)	CONSTRAINT nn_app_user_height			NOT NULL,

    weight			NUMBER(3,0)	CONSTRAINT nn_app_user_weight			NOT NULL,

    gender			CHAR(1)		CONSTRAINT nn_app_user_gender			NOT NULL,

    cyclingAvgSpeed		NUMBER(4,2),

    visaCardNumber		NUMBER(9,0)	CONSTRAINT nn_app_user_visa_card_number		NOT NULL,

    points			NUMBER(5,0),

CONSTRAINT ck_app_user_height CHECK (height > 0),
CONSTRAINT ck_app_user_weight CHECK (weight > 0),
CONSTRAINT ck_app_user_cyclingAvgSpeed CHECK (cyclingAvgSpeed > 0),
CONSTRAINT ck_app_user_visaCardNumber CHECK (visaCardNumber > 0),
CONSTRAINT ck_app_user_points CHECK (points >= 0),
CONSTRAINT ck_app_user_gender CHECK (REGEXP_LIKE(gender, '[M]{1}|[F]{1}|[m]{1}|[f]{1}'))
--'M' – Male; 'F' - Female
);


-- ## tabela Rent ##
CREATE TABLE Rent (
    id_rent      		VARCHAR(30)	CONSTRAINT pk_pedidos_viagens_cod_pedido	PRIMARY KEY,                 

    user_email			VARCHAR(20),

    id_vehicle			VARCHAR(10),

    id_park_start		VARCHAR(10),

    id_park_end			VARCHAR(10),

    date_hour_start		TIMESTAMP,

    date_hour_finish		TIMESTAMP,

    rent_cost			NUMBER(5,2),

    distance			NUMBER(5,0),
    
    points_rent			NUMBER(5,0)

--CONSTRAINT ck_rent_date_hour_finish CHECK (date_hour_finish > date_hour_start),
--CONSTRAINT ck_rent_id_park_different CHECK (id_park_start != id_park_end)
-- As 'start' e as 'end' coordenadas têm de ser diferentes entre si.
);


-- ## tabela TravelPath ##
CREATE TABLE Travel_Path (
    id_place_start		VARCHAR(30),

    id_place_end		VARCHAR(30),

    kinetic_coefficient		NUMBER(4,2),

    wind_direction		NUMBER(3,0),

    wind_speed      		NUMBER(3,1),

--Given N Travel_Paths, if every Place is connected to every other Place (except itself) the number of connections will be:  n*(n-1)/2
--CONSTRAINT pk_travel_path_id_place_start_id_place_end	PRIMARY KEY (id_place_start, id_place_end),
CONSTRAINT ck_travel_path_id_place_different CHECK (id_place_start != id_place_end)
);


-- ## tabela Invoice ##
CREATE TABLE Invoice (
    id_invoice       	VARCHAR(30)		CONSTRAINT pk_invoice_id_invoice	PRIMARY KEY,

    user_email          VARCHAR(20),

    invoice_date	DATE,

    total_cost		NUMBER(5,2)
);



-- ** alterar tabelas para definicao de chaves estrangeiras **

ALTER TABLE Bicycle ADD CONSTRAINT fk_bicycle_vehicle  FOREIGN KEY (id_bicycle) REFERENCES Vehicle (id_vehicle) on DELETE SET NULL;

ALTER TABLE Electric_Scooter ADD CONSTRAINT fk_electric_scooter_vehicle  FOREIGN KEY (id_escooter) REFERENCES Vehicle (id_vehicle) on DELETE SET NULL;

ALTER TABLE Park ADD CONSTRAINT fk_park_place  FOREIGN KEY (id_park) REFERENCES Place (id_place);

ALTER TABLE Point_Of_Interest ADD CONSTRAINT fk_point_of_interest_id_poi  FOREIGN KEY (id_poi) REFERENCES Place (id_place);

ALTER TABLE Rent ADD CONSTRAINT fk_rent_user_email  FOREIGN KEY (user_email) REFERENCES App_User (user_email);
ALTER TABLE Rent ADD CONSTRAINT fk_rent_id_vehicle  FOREIGN KEY (id_vehicle) REFERENCES Vehicle (id_vehicle) on DELETE SET NULL;
ALTER TABLE Rent ADD CONSTRAINT fk_rent_id_park_start  FOREIGN KEY (id_park_start) REFERENCES Park (id_park) on DELETE SET NULL;
ALTER TABLE Rent ADD CONSTRAINT fk_rent_id_park_end  FOREIGN KEY (id_park_end) REFERENCES Park (id_park) on DELETE SET NULL;

ALTER TABLE Travel_Path ADD CONSTRAINT fk_travel_path_id_rent  FOREIGN KEY (id_rent) REFERENCES Rent (id_rent);
ALTER TABLE Travel_Path ADD CONSTRAINT fk_travel_path_id_place_start  FOREIGN KEY (id_place_start) REFERENCES Place (id_place) on DELETE SET NULL;
ALTER TABLE Travel_Path ADD CONSTRAINT fk_travel_path_id_place_end  FOREIGN KEY (id_place_end) REFERENCES Place (id_place) on DELETE SET NULL;

ALTER TABLE Invoice ADD CONSTRAINT fk_invoice_user_email  FOREIGN KEY (user_email) REFERENCES App_User (user_email) on DELETE SET NULL;

