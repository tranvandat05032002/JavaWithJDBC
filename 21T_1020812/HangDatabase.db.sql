BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "LoaiHang" (
	"maLoaiHang"	TEXT,
	"tenLoaiHang"	TEXT,
	PRIMARY KEY("maLoaiHang")
);
CREATE TABLE IF NOT EXISTS "HangHoa" (
	"maHang"	TEXT,
	"tenHang"	TEXT,
	"soLuong"	INTEGER,
	"donGia"	INTEGER,
	"tonKho"	INTEGER,
	"ngaySanXuat"	TEXT,
	"ngayHetHan"	TEXT,
	"thoiGianBH"	TEXT,
	"maLoaiHang"	TEXT,
	PRIMARY KEY("maHang")
);
COMMIT;
