BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "Product" (
	"productID"	INTEGER,
	"nameProduct"	TEXT,
	"priceProduct"	INTEGER,
	"quantityProduct"	INTEGER,
	"categoryID"	INTEGER,
	PRIMARY KEY("productID" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "Category" (
	"categoryID"	INTEGER,
	"name"	TEXT,
	PRIMARY KEY("categoryID")
);
INSERT INTO "Product" ("productID","nameProduct","priceProduct","quantityProduct","categoryID") VALUES (1,'Sting',10000,7,104),
 (2,'BanhKem',70000,1,103),
 (3,'ThachRauCau',7000,5,102),
 (4,'KeoVinamilk',5000,4,101),
 (5,'SnackBiDo',5000,2,105),
 (7,'BanhGau',10000,4,103),
 (8,'BanhSuKem',29000,2,103),
 (9,'KeoChanh',7000,6,101);
INSERT INTO "Category" ("categoryID","name") VALUES (101,'Keo'),
 (102,'Thach'),
 (103,'Banh'),
 (104,'Nuoc'),
 (105,'Snack'),
 (106,'HaiSan');
COMMIT;
