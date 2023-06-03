BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "SinhVien" (
	"MaSinhVien"	text UNIQUE,
	"HoDem"	TEXT,
	"Ten"	TEXT,
	"GioiTinh"	NUMERIC,
	"NgaySinh"	TEXT,
	"MaNganh"	INTEGER,
	"DiemTrungBinh"	NUMERIC
);
CREATE TABLE IF NOT EXISTS "NganhDaoTao" (
	"MaNganh"	INTEGER UNIQUE,
	"TenNganh"	TEXT
);
INSERT INTO "SinhVien" VALUES ('21T101','Tran Van','Dat',0,'5/3/2002',101,8.8);
INSERT INTO "SinhVien" VALUES ('21t102','Ngo Van','Hoang',0,'12/5/2003',101,8.2);
INSERT INTO "SinhVien" VALUES ('21t103','Ngo Quynh','Chau',1,'30/12/2003',101,8.6);
INSERT INTO "SinhVien" VALUES ('21T104','Le Thi ','Thu Ngan',1,'7/11/2003',102,7.3);
INSERT INTO "SinhVien" VALUES ('21T105','Le Diem','Hanh',1,'14/6/2003',101,8.8);
INSERT INTO "SinhVien" VALUES ('21T106','Phan Thi','Chau Anh',1,'17/9/2003',103,5.6);
INSERT INTO "SinhVien" VALUES ('21T107','Tran Thi','Hang',1,'29/4/2003',102,8.8);
INSERT INTO "SinhVien" VALUES ('21T108','Hoang Quynh','Thu',1,'11/1/2003',103,8.8);
INSERT INTO "SinhVien" VALUES ('21T109','Tran Hoang','Bao',0,'31/8/2003',101,6.2);
INSERT INTO "SinhVien" VALUES ('21T110','Hoang Gia','Kiet',0,'27/5/2003',101,4.2);
INSERT INTO "NganhDaoTao" VALUES (101,'CNTT');
INSERT INTO "NganhDaoTao" VALUES (102,'KTPM');
INSERT INTO "NganhDaoTao" VALUES (103,'TOAN');
INSERT INTO "NganhDaoTao" VALUES (104,'VLY');
INSERT INTO "NganhDaoTao" VALUES (105,'KNT');
COMMIT;
