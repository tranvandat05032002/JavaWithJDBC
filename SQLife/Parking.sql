BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "Person" (
	"CMND"	TEXT UNIQUE,
	"hoTen"	TEXT,
	"gioiTinh"	NUMERIC,
	"maSoCanHo"	INTEGER
);
CREATE TABLE IF NOT EXISTS "Xe" (
	"maXe"	INTEGER UNIQUE,
	"tenXe"	INTEGER,
	"CMND"	TEXT
);
CREATE TABLE IF NOT EXISTS "XeDap" (
	"maXeDap"	TEXT UNIQUE,
	"maXe"	INTEGER,
	"soVeXe"	TEXT,
	"thoiGianVao"	TEXT,
	"thoiGianRa"	TEXT
);
CREATE TABLE IF NOT EXISTS "XeMay" (
	"maXeMay"	TEXT UNIQUE,
	"maXe"	INTEGER,
	"bienSo"	TEXT,
	"thoiGianVao"	TEXT,
	"thoiGianRa"	TEXT
);
CREATE TABLE IF NOT EXISTS "XeOTo" (
	"maXeOto"	TEXT UNIQUE,
	"maXe"	INTEGER,
	"bienSo"	TEXT,
	"thoiGianVao"	TEXT,
	"thoiGianRa"	TEXT,
	"trangThaiVao"	TEXT,
	"trangThaiRa"	TEXT
);
INSERT INTO "XeDap" ("maXeDap","maXe","soVeXe","thoiGianVao","thoiGianRa") VALUES ('83884',0,'1014','14:15 07/11/2015','15:00 07/11/2015'),
 ('88560',0,'1014','14:15 07/11/2015','15:00 07/11/2015');
INSERT INTO "XeMay" ("maXeMay","maXe","bienSo","thoiGianVao","thoiGianRa") VALUES ('97915',2,'38H1-4536','17:10 17/11/2015','8:10 20/11/2015'),
 ('80502',2,'38H1-4536','17:10 17/11/2015','8:10 20/11/2015');
INSERT INTO "XeOTo" ("maXeOto","maXe","bienSo","thoiGianVao","thoiGianRa","trangThaiVao","trangThaiRa") VALUES ('81998',4,'40A-365.12','11:30 07/11/2015','17:30 07/11/2015','Binh thuong','Be guong'),
 ('50803',4,'37A-365.12','12:30 07/11/2015','7:05 10/12/2015','Tray xuot ben cua phia truc','Bi hong kinh chieu hau'),
 ('78976',4,'40A-365.12','11:30 07/11/2015','17:30 07/11/2015','Binh thuong','Binh thuong'),
 ('29641',4,'37A-365.12','12:30 07/11/2015','7:05 10/12/2015','Tray xuot ben cua phia truc','Bi hong kinh chieu hau');
COMMIT;
