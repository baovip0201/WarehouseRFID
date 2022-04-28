-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th4 28, 2022 lúc 10:56 AM
-- Phiên bản máy phục vụ: 10.4.11-MariaDB
-- Phiên bản PHP: 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `rfid`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `db_order`
--

CREATE TABLE `db_order` (
  `order_id` varchar(30) NOT NULL,
  `order_date` date NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `db_order`
--

INSERT INTO `db_order` (`order_id`, `order_date`, `status`) VALUES
('OD1', '2022-04-28', 3),
('OD2', '2022-04-28', 3);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `orderdetail`
--

CREATE TABLE `orderdetail` (
  `id` int(11) NOT NULL,
  `order_id` varchar(30) NOT NULL,
  `product_id` varchar(30) NOT NULL,
  `quanity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `orderdetail`
--

INSERT INTO `orderdetail` (`id`, `order_id`, `product_id`, `quanity`) VALUES
(36, 'OD1', 'P001', 10),
(37, 'OD1', 'P002', 10),
(38, 'OD2', 'P005', 10),
(39, 'OD2', 'P004', 20);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product`
--

CREATE TABLE `product` (
  `product_id` varchar(30) NOT NULL,
  `product_name` varchar(30) NOT NULL,
  `quanity` int(11) NOT NULL,
  `detail` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `product`
--

INSERT INTO `product` (`product_id`, `product_name`, `quanity`, `detail`) VALUES
('P001', 'Tra xanh 0 do', 200, 'sds'),
('P002', 'Sting', 500, 'fdfd'),
('P003', 'Nuoc tang luc Warrior', 400, 'ksdk'),
('P004', 'C2', 1000, 'dsdd'),
('P005', 'Pepsi', 1000, 'dsdd'),
('P006', 'Coca Cola', 2000, 'dsddd');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `qltk`
--

CREATE TABLE `qltk` (
  `account` varchar(30) NOT NULL,
  `pass` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `qltk`
--

INSERT INTO `qltk` (`account`, `pass`) VALUES
('bao', '123');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tag_rfid`
--

CREATE TABLE `tag_rfid` (
  `tag_id` varchar(30) NOT NULL,
  `product_id` varchar(30) NOT NULL,
  `date` varchar(30) NOT NULL,
  `gate` varchar(30) NOT NULL,
  `order_id` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `tag_rfid`
--

INSERT INTO `tag_rfid` (`tag_id`, `product_id`, `date`, `gate`, `order_id`) VALUES
('300F 4FB7 3AD0 01C0 8369 A1', 'P001', '2022/04/28 15:50:14', '1', 'OD1'),
('300F 4FB7 3AD0 01C0 8369 A10', 'P001', '2022/04/28 15:50:14', '1', 'OD1'),
('300F 4FB7 3AD0 01C0 8369 A11', 'P002', '2022/04/28 15:50:14', '1', 'OD1'),
('300F 4FB7 3AD0 01C0 8369 A12', 'P002', '2022/04/28 15:50:14', '1', 'OD1'),
('300F 4FB7 3AD0 01C0 8369 A13', 'P002', '2022/04/28 15:50:14', '1', 'OD1'),
('300F 4FB7 3AD0 01C0 8369 A14', 'P002', '2022/04/28 15:50:14', '1', 'OD1'),
('300F 4FB7 3AD0 01C0 8369 A15', 'P002', '2022/04/28 15:50:14', '1', 'OD1'),
('300F 4FB7 3AD0 01C0 8369 A16', 'P002', '2022/04/28 15:50:14', '1', 'OD1'),
('300F 4FB7 3AD0 01C0 8369 A17', 'P002', '2022/04/28 15:50:14', '1', 'OD1'),
('300F 4FB7 3AD0 01C0 8369 A18', 'P002', '2022/04/28 15:50:14', '1', 'OD1'),
('300F 4FB7 3AD0 01C0 8369 A19', 'P002', '2022/04/28 15:50:14', '1', 'OD1'),
('300F 4FB7 3AD0 01C0 8369 A2', 'P001', '2022/04/28 15:50:14', '1', 'OD1'),
('300F 4FB7 3AD0 01C0 8369 A20', 'P002', '2022/04/28 15:50:14', '1', 'OD1'),
('300F 4FB7 3AD0 01C0 8369 A21', 'P004', '2022/04/28 15:50:14', '1', 'OD2'),
('300F 4FB7 3AD0 01C0 8369 A22', 'P004', '2022/04/28 15:50:14', '1', 'OD2'),
('300F 4FB7 3AD0 01C0 8369 A23', 'P004', '2022/04/28 15:50:14', '1', 'OD2'),
('300F 4FB7 3AD0 01C0 8369 A24', 'P004', '2022/04/28 15:50:14', '1', 'OD2'),
('300F 4FB7 3AD0 01C0 8369 A25', 'P004', '2022/04/28 15:50:14', '1', 'OD2'),
('300F 4FB7 3AD0 01C0 8369 A26', 'P004', '2022/04/28 15:50:14', '1', 'OD2'),
('300F 4FB7 3AD0 01C0 8369 A27', 'P004', '2022/04/28 15:50:14', '1', 'OD2'),
('300F 4FB7 3AD0 01C0 8369 A28', 'P004', '2022/04/28 15:50:14', '1', 'OD2'),
('300F 4FB7 3AD0 01C0 8369 A29', 'P004', '2022/04/28 15:50:14', '1', 'OD2'),
('300F 4FB7 3AD0 01C0 8369 A3', 'P001', '2022/04/28 15:50:14', '1', 'OD1'),
('300F 4FB7 3AD0 01C0 8369 A30', 'P004', '2022/04/28 15:50:14', '1', 'OD2'),
('300F 4FB7 3AD0 01C0 8369 A31', 'P004', '2022/04/28 15:50:14', '1', 'OD2'),
('300F 4FB7 3AD0 01C0 8369 A32', 'P004', '2022/04/28 15:50:14', '1', 'OD2'),
('300F 4FB7 3AD0 01C0 8369 A33', 'P004', '2022/04/28 15:50:14', '1', 'OD2'),
('300F 4FB7 3AD0 01C0 8369 A34', 'P004', '2022/04/28 15:50:14', '1', 'OD2'),
('300F 4FB7 3AD0 01C0 8369 A35', 'P004', '2022/04/28 15:50:14', '1', 'OD2'),
('300F 4FB7 3AD0 01C0 8369 A36', 'P004', '2022/04/28 15:50:14', '1', 'OD2'),
('300F 4FB7 3AD0 01C0 8369 A37', 'P004', '2022/04/28 15:50:14', '1', 'OD2'),
('300F 4FB7 3AD0 01C0 8369 A38', 'P004', '2022/04/28 15:50:14', '1', 'OD2'),
('300F 4FB7 3AD0 01C0 8369 A39', 'P004', '2022/04/28 15:50:14', '1', 'OD2'),
('300F 4FB7 3AD0 01C0 8369 A4', 'P001', '2022/04/28 15:50:14', '1', 'OD1'),
('300F 4FB7 3AD0 01C0 8369 A40', 'P004', '2022/04/28 15:50:14', '1', 'OD2'),
('300F 4FB7 3AD0 01C0 8369 A41', 'P005', '2022/04/28 15:50:14', '1', 'OD2'),
('300F 4FB7 3AD0 01C0 8369 A42', 'P005', '2022/04/28 15:50:14', '1', 'OD2'),
('300F 4FB7 3AD0 01C0 8369 A43', 'P005', '2022/04/28 15:50:14', '1', 'OD2'),
('300F 4FB7 3AD0 01C0 8369 A44', 'P005', '2022/04/28 15:50:14', '1', 'OD2'),
('300F 4FB7 3AD0 01C0 8369 A45', 'P005', '2022/04/28 15:50:14', '1', 'OD2'),
('300F 4FB7 3AD0 01C0 8369 A46', 'P005', '2022/04/28 15:50:14', '1', 'OD2'),
('300F 4FB7 3AD0 01C0 8369 A47', 'P005', '2022/04/28 15:50:14', '1', 'OD2'),
('300F 4FB7 3AD0 01C0 8369 A48', 'P005', '2022/04/28 15:50:14', '1', 'OD2'),
('300F 4FB7 3AD0 01C0 8369 A49', 'P005', '2022/04/28 15:50:14', '1', 'OD2'),
('300F 4FB7 3AD0 01C0 8369 A5', 'P001', '2022/04/28 15:50:14', '1', 'OD1'),
('300F 4FB7 3AD0 01C0 8369 A50', 'P005', '2022/04/28 15:50:14', '1', 'OD2'),
('300F 4FB7 3AD0 01C0 8369 A51', 'P003', '2022/04/28 15:50:14', '1', NULL),
('300F 4FB7 3AD0 01C0 8369 A52', 'P003', '2022/04/28 15:50:14', '1', NULL),
('300F 4FB7 3AD0 01C0 8369 A53', 'P003', '2022/04/28 15:50:14', '1', NULL),
('300F 4FB7 3AD0 01C0 8369 A54', 'P003', '2022/04/28 15:50:14', '1', NULL),
('300F 4FB7 3AD0 01C0 8369 A55', 'P003', '2022/04/28 15:50:14', '1', NULL),
('300F 4FB7 3AD0 01C0 8369 A56', 'P003', '2022/04/28 15:50:14', '1', NULL),
('300F 4FB7 3AD0 01C0 8369 A57', 'P003', '2022/04/28 15:50:14', '1', NULL),
('300F 4FB7 3AD0 01C0 8369 A58', 'P003', '2022/04/28 15:50:14', '1', NULL),
('300F 4FB7 3AD0 01C0 8369 A59', 'P003', '2022/04/28 15:50:14', '1', NULL),
('300F 4FB7 3AD0 01C0 8369 A6', 'P001', '2022/04/28 15:50:14', '1', 'OD1'),
('300F 4FB7 3AD0 01C0 8369 A60', 'P003', '2022/04/28 15:41:12', '1', NULL),
('300F 4FB7 3AD0 01C0 8369 A7', 'P001', '2022/04/28 15:50:14', '1', 'OD1'),
('300F 4FB7 3AD0 01C0 8369 A8', 'P001', '2022/04/28 15:50:14', '1', 'OD1'),
('300F 4FB7 3AD0 01C0 8369 A9', 'P001', '2022/04/28 15:50:14', '1', 'OD1');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `db_order`
--
ALTER TABLE `db_order`
  ADD PRIMARY KEY (`order_id`);

--
-- Chỉ mục cho bảng `orderdetail`
--
ALTER TABLE `orderdetail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `order_id` (`order_id`),
  ADD KEY `product_id` (`product_id`);

--
-- Chỉ mục cho bảng `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`product_id`);

--
-- Chỉ mục cho bảng `tag_rfid`
--
ALTER TABLE `tag_rfid`
  ADD PRIMARY KEY (`tag_id`),
  ADD KEY `product_id` (`product_id`),
  ADD KEY `order_id` (`order_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `orderdetail`
--
ALTER TABLE `orderdetail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `orderdetail`
--
ALTER TABLE `orderdetail`
  ADD CONSTRAINT `orderdetail_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `db_order` (`order_id`),
  ADD CONSTRAINT `orderdetail_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`);

--
-- Các ràng buộc cho bảng `tag_rfid`
--
ALTER TABLE `tag_rfid`
  ADD CONSTRAINT `tag_rfid_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
  ADD CONSTRAINT `tag_rfid_ibfk_2` FOREIGN KEY (`order_id`) REFERENCES `db_order` (`order_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
