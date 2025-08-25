-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 10, 2024 at 07:54 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library_management`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `username` varchar(15) NOT NULL,
  `name` varchar(25) NOT NULL,
  `password` varchar(15) NOT NULL,
  `security_ques` varchar(45) NOT NULL,
  `answer` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`username`, `name`, `password`, `security_ques`, `answer`) VALUES
('sathu', 'loki', '141', 'Avala yapahamirukka?', 'illaye'),
('ucsc', 'School of Computing', 'ucsc', 'Course name ?', 'IS'),
('UOC', 'UOC', 'UOC', 'What is your school name?', 'IS');

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `book_id` int(10) UNSIGNED NOT NULL,
  `name` varchar(45) NOT NULL,
  `edition` int(10) UNSIGNED NOT NULL,
  `publisher` varchar(35) NOT NULL,
  `price` int(8) UNSIGNED NOT NULL,
  `stock` int(8) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`book_id`, `name`, `edition`, `publisher`, `price`, `stock`) VALUES
(503, 'Romeo and Juliet', 1, 'William Shakespeare', 150, 50),
(504, 'Harry', 1, 'J.K. Rowling', 300, 100),
(505, 'The Great Gatsby', 2, 'Charles Scribner\'s Sons', 200, 30),
(506, '1984', 1, 'Secker & Warburg', 180, 45),
(507, 'To Kill a Mockingbird', 3, '', 250, 60),
(508, 'Moby-Dick', 1, 'Harper & Brothers', 300, 20),
(509, 'War and Peace', 2, 'The Russian Messenger', 350, 40);

-- --------------------------------------------------------

--
-- Table structure for table `issue`
--

CREATE TABLE `issue` (
  `book_id` int(10) UNSIGNED NOT NULL,
  `b_name` varchar(25) NOT NULL,
  `edition` int(5) UNSIGNED NOT NULL,
  `publisher` varchar(25) NOT NULL,
  `price` int(5) UNSIGNED NOT NULL,
  `stock` int(5) UNSIGNED NOT NULL,
  `stu_id` int(10) UNSIGNED NOT NULL,
  `s_name` varchar(25) NOT NULL,
  `f_name` varchar(25) NOT NULL,
  `course` varchar(25) NOT NULL,
  `branch` varchar(25) NOT NULL,
  `year` varchar(10) NOT NULL,
  `semister` varchar(15) NOT NULL,
  `doi` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `issue`
--

INSERT INTO `issue` (`book_id`, `b_name`, `edition`, `publisher`, `price`, `stock`, `stu_id`, `s_name`, `f_name`, `course`, `branch`, `year`, `semister`, `doi`) VALUES
(503, 'Romeo and Juliet', 1, 'William Shakespeare', 150, 50, 143, 'Sathu', 'Kratos', 'hm', 'nah', '2', '2', '2018-03-25'),
(503, 'Romeo and Juliet', 1, 'William Shakespeare', 150, 50, 143, 'Sathu', 'Kratos', 'hm', 'nah', '2', '2', '2018-03-25'),
(504, 'Harry Potter', 1, 'J.K. Rowling', 300, 100, 144, 'Alice', 'Williams', 'cs', 'it', '1', '2', '2023-09-12'),
(505, 'The Great Gatsby', 2, 'Charles Scribner\'s Sons', 200, 30, 145, 'Beth', 'Brown', 'eng', 'lit', '2', '1', '2023-10-01'),
(506, '1984', 1, 'Secker & Warburg', 180, 45, 146, 'Carl', 'White', 'math', 'sci', '3', '1', '2023-10-20'),
(507, 'To Kill a Mockingbird', 3, 'J.B. Lippincott & Co.', 250, 60, 147, 'Diana', 'Black', 'cs', 'it', '4', '2', '2023-10-25'),
(508, 'Moby-Dick', 1, 'Harper & Brothers', 300, 20, 148, 'Edna', 'Yellow', 'hist', 'arts', '1', '1', '2023-09-30'),
(509, 'War and Peace', 2, 'The Russian Messenger', 350, 40, 149, 'Frank', 'Smith', 'bio', 'med', '1', '2', '2023-10-05');

-- --------------------------------------------------------

--
-- Table structure for table `returntbl`
--

CREATE TABLE `returntbl` (
  `stu_id` int(10) UNSIGNED NOT NULL,
  `s_name` varchar(25) NOT NULL,
  `f_name` varchar(25) NOT NULL,
  `course` varchar(15) NOT NULL,
  `branch` varchar(25) NOT NULL,
  `year` varchar(15) NOT NULL,
  `semister` varchar(15) NOT NULL,
  `book_id` int(10) UNSIGNED NOT NULL,
  `b_name` varchar(25) NOT NULL,
  `edition` varchar(25) NOT NULL,
  `publisher` varchar(25) NOT NULL,
  `price` int(10) UNSIGNED NOT NULL,
  `stock` int(10) UNSIGNED NOT NULL,
  `doi` date NOT NULL,
  `doreturn` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `returntbl`
--

INSERT INTO `returntbl` (`stu_id`, `s_name`, `f_name`, `course`, `branch`, `year`, `semister`, `book_id`, `b_name`, `edition`, `publisher`, `price`, `stock`, `doi`, `doreturn`) VALUES
(144, 'Alice', 'Williams', 'cs', 'it', '1', '2', 504, 'Harry Potter', '1', 'J.K. Rowling', 300, 100, '2023-09-12', '2023-10-10'),
(145, 'Beth', 'Brown', 'eng', 'lit', '2', '1', 505, 'The Great Gatsby', '2', 'Charles Scribner\'s Sons', 200, 30, '2023-10-01', '2023-10-25'),
(146, 'Carl', 'White', 'math', 'sci', '3', '1', 506, '1984', '1', 'Secker & Warburg', 180, 45, '2023-10-20', '2023-11-05'),
(147, 'Diana', 'Black', 'cs', 'it', '4', '2', 507, 'To Kill a Mockingbird', '3', 'J.B. Lippincott & Co.', 250, 60, '2023-10-25', '2023-11-10'),
(148, 'Edna', 'Yellow', 'hist', 'arts', '1', '1', 508, 'Moby-Dick', '1', 'Harper & Brothers', 300, 20, '2023-09-30', '2023-10-15'),
(149, 'Frank', 'Smith', 'bio', 'med', '1', '2', 509, 'War and Peace', '2', 'The Russian Messenger', 350, 40, '2023-10-05', '2023-11-01');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `student_id` int(10) UNSIGNED NOT NULL,
  `name` varchar(25) NOT NULL,
  `fathers_name` varchar(25) NOT NULL,
  `course` varchar(15) NOT NULL,
  `branch` varchar(25) NOT NULL,
  `year` varchar(15) NOT NULL,
  `semister` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`student_id`, `name`, `fathers_name`, `course`, `branch`, `year`, `semister`) VALUES
(143, 'Sathu', 'Kratos', 'd', 'd', '1', '2'),
(150, 'Alice', 'Williams', 'bio', 'med', '1', '2'),
(151, 'Bob', 'Johnson', 'eng', 'lit', '3', '1'),
(152, 'Charlie', 'Clark', 'chem', 'sci', '2', '1'),
(153, 'Debra', 'White', 'cs', 'it', '1', '2'),
(154, 'Ethan', 'Davis', 'math', 'sci', '4', '2');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`book_id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`student_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
