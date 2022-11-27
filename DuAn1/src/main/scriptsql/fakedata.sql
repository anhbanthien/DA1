USE [DuAn1]
GO
INSERT INTO [dbo].[SanPham]([IDSP],[TenSP],[Mota],[Image],[Gia],[TrangThai])
VALUES('bc3a6843-ce94-4103-ba5a-cd9f8c9960d7','Coffee đen','nhiều đường','coffeden.png', 50000, 1),
('45384b43-3ca6-4842-844f-26fd72449d79','Coffee nhai luôn li','li làm từ bột mì','coffeenhaili.png', 60000, 1),
('e21a8ac9-70a5-40cc-86a1-5c48c90683c9','Coffee sữa','nhiều nhiều sữa đó','coffeesua.png', 20000, 1),
('063bfdb7-1ce3-4e39-9222-2de56523d9e4','bạc xỉu','sấp hay ngữa','bacxiu.png', 70000, 1);
go
INSERT INTO [dbo].[KhachHang]([IdKhachHang],[Ten],[DiemTichLuy],[SoDienThoai],[TrangThai])
VALUES('9d61d381-828d-45f2-a3b2-4cc77f1822a4',' Trần Tuấn Nam',5,'0397670676','ON'),
('181ef7f2-0a9f-44de-818b-6de841a96c94','Phạm Văn Hùng',4,'0396926976','ON'),
('379c4764-fc9d-4854-a38a-5d765240cb77','Trần Trúc Nhân',9,'0356292297','ON'),
('f939658c-fb71-4858-8f5a-1b82c1b5d78f','Đinh Văn Hùng',3,'0337128928','ON'),
('df99d931-0af8-4135-aa5d-761329783728','Vương Thu Thủy',7,'0398121125','ON');
go
INSERT INTO [dbo].[KhuyenMai]([IDKM],[NgayBatDau],[NgayKetThuc],[PhanTramKM],[TrangThai])
VALUES('33cf7fe9-ff36-4ad1-89b4-7e4e68f2584b','12/12/2012','12/12/2112','','ON'),
('1ad7f5db-aa2a-4058-8f73-91586b5930db','12/12/2012','12/12/2112','','ON'),
('1f4038d5-67d3-41c4-9f50-d61d63bc0ddb','12/12/2012','12/12/2112','','ON')
go
INSERT INTO [dbo].[NhanVien]([IdNhanVien],[HoTen],[Email],[SDT],[GioiTinh],[TrangThai])
VALUES( '0e0da193-d20d-496a-a0cb-5006cb530c29','Nguyễn Công Thiện','yeudoi29@gmail.com','0877166352','Nam','ON'),
( '7b45d047-1a0c-446f-ad07-4f55e262bf5f','Nguyễn Trung Hưng','nangconko123@gmail.com','0987665322','Nam','ON'),
( '50e77d8f-bd17-4c82-9152-6702239ba6f5','Vũ Tường An','nangconvuong@gmail.com','09857995442','Nam','ON'),
( '8f8d5655-bfc7-4072-93c1-d593157acb6b','Nguyễn Trọng Hiếu','thattinh123@gmail.com','0834223123','Nam','ON'),
( '1ab94bc6-384a-4f3a-b7e9-bc9e02e61d75','Nguyễn Văn Long','vanlongnguyen2405@gmail.com','0877166352','Nam','ON');
GO
INSERT INTO [dbo].[DangNhap]([TenTaiKhoan],[MatKhau],[Quyen],[IdNhanVien])
VALUES(N'admin','123','admin','0e0da193-d20d-496a-a0cb-5006cb530c29'),
      (N'staff','123','staff','7b45d047-1a0c-446f-ad07-4f55e262bf5f'),
	  (N'an123','123','staff','50e77d8f-bd17-4c82-9152-6702239ba6f5'),
	  (N'hieu456','123','staff','8f8d5655-bfc7-4072-93c1-d593157acb6b'),
	  (N'long789','123','staff','1ab94bc6-384a-4f3a-b7e9-bc9e02e61d75');
	  DELETE FROM [dbo].[SanPham]