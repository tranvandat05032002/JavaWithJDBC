BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "NhanVien" (
	"maNhanVien"	TEXT,
	"hoTen"	TEXT,
	"loaiHopDong"	TEXT,
	"heSoLuong"	INTEGER,
	PRIMARY KEY("maNhanVien")
);
CREATE TABLE IF NOT EXISTS "GiaoVien" (
	"maGiaoVien"	TEXT,
	"hoTen"	TEXT,
	"loaiHopDong"	TEXT,
	"heSoLuong"	INTEGER,
	"phuCap"	INTEGER,
	PRIMARY KEY("maGiaoVien")
);
INSERT INTO "NhanVien" ("maNhanVien","hoTen","loaiHopDong","heSoLuong") VALUES ('23NV1','nguyenthihanh','hopdong',3),
 ('23NV2','tranconguan','hopdong',3);
INSERT INTO "GiaoVien" ("maGiaoVien","hoTen","loaiHopDong","heSoLuong","phuCap") VALUES ('21GV1','tranduyanh','chinhthuc',5,1000000),
 ('19GV2','chauthanhhai','chinhthuc',6,1500000),
 ('21GV2','trancongman','chinhthuc',5,1000000),
 ('21GV3','nguyenvantrung','chinhthuc',4,1200000);
COMMIT;
