-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-04-2017 a las 02:24:53
-- Versión del servidor: 5.7.14
-- Versión de PHP: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `scess`
--
DROP DATABASE IF EXISTS `scess`;

CREATE DATABASE scess;

use scess;



SET FOREIGN_KEY_CHECKS=0;
-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `acceso`
--

CREATE TABLE `acceso` (
  `ACCidAccPK` int(10) UNSIGNED NOT NULL,
  `ACCidPerFK` int(10) UNSIGNED NOT NULL,
  `ACCcon` varchar(50) NOT NULL,
  `ACCact` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `acceso`
--

INSERT INTO `acceso` (`ACCidAccPK`, `ACCidPerFK`, `ACCcon`, `ACCact`) VALUES
(1, 1, '81dc9bdb52d04dc20036dbd8313ed055', 'SI'),
(2, 2, '827ccb0eea8a706c4c34a16891f84e7b', 'NO'),
(3, 4, 'c4ea00264805192b811b2cd048049c43', 'SI'),
(4, 5, '827ccb0eea8a706c4c34a16891f84e7b', 'SI'),
(5, 6, '827ccb0eea8a706c4c34a16891f84e7b', 'SI'),
(6, 7, '827ccb0eea8a706c4c34a16891f84e7b', 'SI'),
(7, 8, '827ccb0eea8a706c4c34a16891f84e7b', 'SI'),
(8, 9, '70d9011250cf39b8c84ca2652f6bc1e0', 'SI'),
(9, 10, 'e45823afe1e5120cec11fc4c379a0c67', 'SI'),
(10, 11, 'ad7e762ed4f2dba7957e7df3741d4c79', 'SI'),
(11, 20, '827ccb0eea8a706c4c34a16891f84e7b', 'SI'),
(12, 13, '827ccb0eea8a706c4c34a16891f84e7b', 'SI'),
(13, 14, '81dc9bdb52d04dc20036dbd8313ed055', 'SI');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `censed`
--

CREATE TABLE `censed` (
  `CSidSedFK` int(10) UNSIGNED DEFAULT NULL,
  `CSidCenFK` int(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `centros`
--

CREATE TABLE `centros` (
  `CENidCenPK` int(10) UNSIGNED NOT NULL,
  `CENnomCen` varchar(100) DEFAULT NULL,
  `CENcodSenCen` int(10) DEFAULT NULL,
  `CENidCiuFK` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `centros`
--

INSERT INTO `centros` (`CENidCenPK`, `CENnomCen`, `CENcodSenCen`, `CENidCiuFK`) VALUES
(1, 'CEAI', 1234, 1217);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudad`
--

CREATE TABLE `ciudad` (
  `CIUidCiuPK` int(10) UNSIGNED NOT NULL,
  `CIUnomCiu` varchar(30) DEFAULT NULL,
  `CIUidDepFK` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ciudad`
--

INSERT INTO `ciudad` (`CIUidCiuPK`, `CIUnomCiu`, `CIUidDepFK`) VALUES
(1, 'El Encanto', 1),
(2, 'La Chorrera', 1),
(3, 'La Pedrera', 1),
(4, 'Leticia', 1),
(5, 'Mirití-Paraná', 1),
(6, 'Puerto Nariño', 1),
(7, 'Puerto Santander', 1),
(8, 'Tarapacá', 1),
(9, 'Amazonas', 1),
(10, 'La ciudad de caro', 1),
(11, 'Abejorral', 2),
(12, 'Abriaquí', 2),
(13, 'Alejandría', 2),
(14, 'Amagá', 2),
(15, 'Amalfi', 2),
(16, 'Andes', 2),
(17, 'Angelópolis', 2),
(18, 'Angostura', 2),
(19, 'Anorí', 2),
(20, 'Antioquia', 2),
(21, 'Anza', 2),
(22, 'Apartadó', 2),
(23, 'Arboletes', 2),
(24, 'Arboretes', 2),
(25, 'Argelia', 2),
(26, 'Armenia', 2),
(27, 'Barbosa', 2),
(28, 'Belén de Bajirá', 2),
(29, 'Bello', 2),
(30, 'Belmira', 2),
(31, 'Betania', 2),
(32, 'Betulia', 2),
(33, 'Bolombolo', 2),
(34, 'Briceño', 2),
(35, 'Buriticá', 2),
(36, 'Cáceres', 2),
(37, 'Caicedo', 2),
(38, 'Caldas', 2),
(39, 'Campamento', 2),
(40, 'Cañasgordas', 2),
(41, 'Capurganá', 2),
(42, 'Caracolí', 2),
(43, 'Caramanta', 2),
(44, 'Carepa', 2),
(45, 'Carolina', 2),
(46, 'Caucasia', 2),
(47, 'Cestilla', 2),
(48, 'Chigorodó', 2),
(49, 'Cisneros', 2),
(50, 'Ciudad Bolívar', 2),
(51, 'Cocorná', 2),
(52, 'Concepción', 2),
(53, 'Concordia', 2),
(54, 'Copacabana', 2),
(55, 'Currulao', 2),
(56, 'Dabeiba', 2),
(57, 'Don Matías', 2),
(58, 'Doradal', 2),
(59, 'Ebéjico', 2),
(60, 'El Bagre', 2),
(61, 'El Carmen de Viboral', 2),
(62, 'El Peñol', 2),
(63, 'El Retiro', 2),
(64, 'El Santuario', 2),
(65, 'Entrerríos', 2),
(66, 'Envigado', 2),
(67, 'Fredonia', 2),
(68, 'Frontino', 2),
(69, 'Giraldo', 2),
(70, 'Girardota', 2),
(71, 'Gómez Plata', 2),
(72, 'Granada', 2),
(73, 'Guadalupe', 2),
(74, 'Guarne', 2),
(75, 'Guatapé', 2),
(76, 'Heliconia', 2),
(77, 'Hispania', 2),
(78, 'Hoyorrico', 2),
(79, 'Itagüí', 2),
(80, 'Ituango', 2),
(81, 'Jardín', 2),
(82, 'Jericó', 2),
(83, 'La Ceja', 2),
(84, 'La Estrella', 2),
(85, 'La Fe', 2),
(86, 'La Pintada', 2),
(87, 'La Sierra', 2),
(88, 'La Unión', 2),
(89, 'Liborina', 2),
(90, 'Llanadas', 2),
(91, 'Maceo', 2),
(92, 'Marinilla', 2),
(93, 'Medellín', 2),
(94, 'Montebello', 2),
(95, 'Murindó', 2),
(96, 'Mutatá', 2),
(97, 'Nariño', 2),
(98, 'Nechí', 2),
(99, 'Necoclí', 2),
(100, 'Nueva Colonia', 2),
(101, 'Nutibara', 2),
(102, 'Olaya', 2),
(103, 'Palermo', 2),
(104, 'Peque', 2),
(105, 'Pueblo Rico', 2),
(106, 'Puerto Berrío', 2),
(107, 'Puerto Claver', 2),
(108, 'Puerto Nare', 2),
(109, 'Puerto perales', 2),
(110, 'Puerto Triunfo', 2),
(111, 'Remedios', 2),
(112, 'Rionegro', 2),
(113, 'Sabanalarga', 2),
(114, 'Sabaneta', 2),
(115, 'Salgar', 2),
(116, 'San Andrés de Cuerquía', 2),
(117, 'San Carlos', 2),
(118, 'San Francisco', 2),
(119, 'San Jerónimo', 2),
(120, 'San José de la Montaña', 2),
(121, 'San José del Nus', 2),
(122, 'San Juan de Urabá', 2),
(123, 'San Luis', 2),
(124, 'San Pedro de los Milagros', 2),
(125, 'San Pedro de Urabá', 2),
(126, 'San Rafael', 2),
(127, 'San Roque', 2),
(128, 'San Vicente', 2),
(129, 'Santa Bárbara', 2),
(130, 'Santa Rosa de Osos', 2),
(131, 'Santa Fe de Antioquia', 2),
(132, 'Santo Domingo', 2),
(133, 'Segovia', 2),
(134, 'Sevilla', 2),
(135, 'Sonsón', 2),
(136, 'Sopetrán', 2),
(137, 'Sucre', 2),
(138, 'Támesis', 2),
(139, 'Taparto', 2),
(140, 'Tarazá', 2),
(141, 'Tarso', 2),
(142, 'Titiribí', 2),
(143, 'Toledo', 2),
(144, 'Turbo', 2),
(145, 'Uramita', 2),
(146, 'Urrao', 2),
(147, 'Valdivia', 2),
(148, 'Valparaíso', 2),
(149, 'Vegachí', 2),
(150, 'Venecia', 2),
(151, 'Versalles', 2),
(152, 'Vigía del Fuerte', 2),
(153, 'Yalí', 2),
(154, 'Yarumal', 2),
(155, 'Yolombó', 2),
(156, 'Yondó', 2),
(157, 'Zaragoza', 2),
(158, 'Altamira', 2),
(159, 'La Cruzada', 2),
(160, 'Puerto Valdivia', 2),
(161, 'Pueblorrico', 2),
(162, 'Arauca', 3),
(163, 'Arauquita', 3),
(164, 'Cravo Norte', 3),
(165, 'Fortul', 3),
(166, 'Puerto Nariño', 3),
(167, 'Puerto Rondón', 3),
(168, 'Saravena', 3),
(169, 'Tame', 3),
(170, 'Baranoa', 4),
(171, 'Barranquilla', 4),
(172, 'Campo de la Cruz', 4),
(173, 'Candelaria', 4),
(174, 'GalapaJuan de Acosta', 4),
(175, 'Luruaco', 4),
(176, 'Malambo', 4),
(177, 'Manatí', 4),
(178, 'Palmar de Varela', 4),
(179, 'Piojó', 4),
(180, 'Polonuevo', 4),
(181, 'Ponedera', 4),
(182, 'Puerto Colombia', 4),
(183, 'Repelón', 4),
(184, 'Sabanagrande', 4),
(185, 'Sabanalarga', 4),
(186, 'Santa Lucía', 4),
(187, 'Santo Tomás', 4),
(188, 'Soledad', 4),
(189, 'Suan', 4),
(190, 'Tubará', 4),
(191, 'Usiacurí', 4),
(192, 'Juan Mina', 4),
(193, 'La Loma', 4),
(194, 'La Jagua de Ibirico', 4),
(195, 'Achí', 5),
(196, 'Altos del Rosario', 5),
(197, 'Arenal del Sur', 5),
(198, 'Arjona', 5),
(199, 'Arroyo Hondo', 5),
(200, 'Barranco de Loba', 5),
(201, 'Bayunca', 5),
(202, 'Calamar', 5),
(203, 'Cantagallo', 5),
(204, 'Cartagena', 5),
(205, 'Cicuco', 5),
(206, 'Clemencia', 5),
(207, 'Córdoba', 5),
(208, 'El Carmen de Bolívar', 5),
(209, 'El Guamo', 5),
(210, 'El Peñón', 5),
(211, 'Hatillo de Loba', 5),
(212, 'Magangué', 5),
(213, 'Mahates', 5),
(214, 'Malagana', 5),
(215, 'Margarita', 5),
(216, 'María La Baja', 5),
(217, 'Mompós', 5),
(218, 'Montecristo', 5),
(219, 'Morales', 5),
(220, 'Pinillos', 5),
(221, 'Regidor', 5),
(222, 'Rioviejo', 5),
(223, 'San Cayetano', 5),
(224, 'San Cristóbal', 5),
(225, 'San Estanislao', 5),
(226, 'San Fernando', 5),
(227, 'San Jacinto', 5),
(228, 'San Juan Nepomuceno', 5),
(229, 'San Martín de Loba', 5),
(230, 'San Pablo', 5),
(231, 'Santa Catalina', 5),
(232, 'Santa Rosa', 5),
(233, 'Santa Rosa de Lima', 5),
(234, 'Santa Rosa del Sur', 5),
(235, 'Simití', 5),
(236, 'Sincerín', 5),
(237, 'Soplaviento', 5),
(238, 'Talaigua Nuevo', 5),
(239, 'Tiquisio', 5),
(240, 'Turbaco', 5),
(241, 'Turbaná', 5),
(242, 'Villanueva', 5),
(243, 'Zambrano', 5),
(244, 'Almeida', 6),
(245, 'Aquitania', 6),
(246, 'Arcabuco', 6),
(247, 'Belén', 6),
(248, 'Belencito', 6),
(249, 'Berbeo', 6),
(250, 'Beteitiva', 6),
(251, 'Boavita', 6),
(252, 'Boyacá', 6),
(253, 'Briceño', 6),
(254, 'Buenavista', 6),
(255, 'Busbanza', 6),
(256, 'Caldas', 6),
(257, 'Campohermoso', 6),
(258, 'Cerinza', 6),
(259, 'Chinavita', 6),
(260, 'Chiquinquirá', 6),
(261, 'Chíquiza', 6),
(262, 'Chiscas', 6),
(263, 'Chita', 6),
(264, 'Chitaraque', 6),
(265, 'Chivatá', 6),
(266, 'Chivor', 6),
(267, 'Ciénaga', 6),
(268, 'Cómbita', 6),
(269, 'Coper', 6),
(270, 'Corrales', 6),
(271, 'Covarachía', 6),
(272, 'Cubará', 6),
(273, 'Cucaita', 6),
(274, 'Cuítiva', 6),
(275, 'Duitama', 6),
(276, 'El Cocuy', 6),
(277, 'El Espino', 6),
(278, 'Firavitoba', 6),
(279, 'Floresta', 6),
(280, 'Gachantivá', 6),
(281, 'Gámeza', 6),
(282, 'Garagoa', 6),
(283, 'Guacamayas', 6),
(284, 'Guateque', 6),
(285, 'Guayatá', 6),
(286, 'Güicán', 6),
(287, 'Iza', 6),
(288, 'Jenesano', 6),
(289, 'Jericó', 6),
(290, 'La Capilla', 6),
(291, 'La Uvita', 6),
(292, 'La Victoria', 6),
(293, 'Labranzagrande', 6),
(294, 'Laguna de Tota', 6),
(295, 'Macanal', 6),
(296, 'Maguncia', 6),
(297, 'Maripí', 6),
(298, 'Miraflores', 6),
(299, 'Mongua', 6),
(300, 'Monguí', 6),
(301, 'Moniquirá', 6),
(302, 'Motavita', 6),
(303, 'Muzo', 6),
(304, 'Nobsa', 6),
(305, 'Nuevo Colón', 6),
(306, 'Oicatá', 6),
(307, 'Otanche', 6),
(308, 'Pachavita', 6),
(309, 'Páez', 6),
(310, 'Paipa', 6),
(311, 'Pajarito', 6),
(312, 'Panqueba', 6),
(313, 'Pauna', 6),
(314, 'Paya', 6),
(315, 'Paz del Río', 6),
(316, 'Pesca', 6),
(317, 'Pisba', 6),
(318, 'Puerto Boyacá', 6),
(319, 'Quípama', 6),
(320, 'Ramiriquí', 6),
(321, 'Ráquira', 6),
(322, 'Rondón', 6),
(323, 'Saboyá', 6),
(324, 'Sáchica', 6),
(325, 'Samacá', 6),
(326, 'San Eduardo', 6),
(327, 'San José de Pare', 6),
(328, 'San Luis de Gaceno', 6),
(329, 'San Mateo', 6),
(330, 'San Miguel de Sema', 6),
(331, 'San Pablo de Borbur', 6),
(332, 'Santa María', 6),
(333, 'Santa Rosa de Viterbo', 6),
(334, 'Santa Sofía', 6),
(335, 'Santana', 6),
(336, 'Sativanorte', 6),
(337, 'Sativasur', 6),
(338, 'Siachoque', 6),
(339, 'Soatá', 6),
(340, 'Socha', 6),
(341, 'Socotá', 6),
(342, 'Sogamoso', 6),
(343, 'Somondoco', 6),
(344, 'SoraSoracá', 6),
(345, 'Sotaquirá', 6),
(346, 'Susacón', 6),
(347, 'Susón', 6),
(348, 'Sutamarchán', 6),
(349, 'Sutatenza', 6),
(350, 'Tasco', 6),
(351, 'Tenza', 6),
(352, 'Tibaná', 6),
(353, 'Tibasosa', 6),
(354, 'Tinjacá', 6),
(355, 'Tipacoque', 6),
(356, 'Toca', 6),
(357, 'Toguí', 6),
(358, 'Tópaga', 6),
(359, 'Tota', 6),
(360, 'Tunja', 6),
(361, 'Tunungua', 6),
(362, 'Turmequé', 6),
(363, 'Tuta', 6),
(364, 'Tutasa', 6),
(365, 'Umbita', 6),
(366, 'Ventaquemada', 6),
(367, 'Villa de Leyva', 6),
(368, 'Viracachá', 6),
(369, 'Zetaquirá', 6),
(370, 'Aguadas', 7),
(371, 'Anserma', 7),
(372, 'Aranzazu', 7),
(373, 'Belalcázar', 7),
(374, 'Chinchiná', 7),
(375, 'Filadelfia', 7),
(376, 'La Dorada', 7),
(377, 'La Merced', 7),
(378, 'Manizales', 7),
(379, 'Manzanares', 7),
(380, 'Marmato', 7),
(381, 'Marquetalia', 7),
(382, 'Marulanda', 7),
(383, 'Neira', 7),
(384, 'Norcasia', 7),
(385, 'Pácora', 7),
(386, 'Palestina', 7),
(387, 'Pensilvania', 7),
(388, 'Riosucio', 7),
(389, 'Risaralda', 7),
(390, 'Salamina', 7),
(391, 'Samaná', 7),
(392, 'San José', 7),
(393, 'Supía', 7),
(394, 'Victoria', 7),
(395, 'Villamaría', 7),
(396, 'Viterbo', 7),
(397, 'Albania', 8),
(398, 'Belén de Los Andaquíes', 8),
(399, 'Cartagena del Chaira', 8),
(400, 'Curillo', 8),
(401, 'El Doncello', 8),
(402, 'El Paujil', 8),
(403, 'Florencia', 8),
(404, 'La Montañita', 8),
(405, 'La Solita', 8),
(406, 'Larandia', 8),
(407, 'Morelia', 8),
(408, 'Puerto Milán', 8),
(409, 'Puerto Rico', 8),
(410, 'Puerto Solano', 8),
(411, 'Rionegro', 8),
(412, 'San Antonio de Getucha', 8),
(413, 'San José del Fragua', 8),
(414, 'San Vicente del Caguán', 8),
(415, 'Tres Esquinas Solano', 8),
(416, 'Unión Peneya', 8),
(417, 'Valparaíso', 8),
(418, 'Venecia', 8),
(419, 'Aguazul', 9),
(420, 'Chámeza', 9),
(421, 'Hato Corozal', 9),
(422, 'La Salina', 9),
(423, 'Maní', 9),
(424, 'Monterrey', 9),
(425, 'Nunchía', 9),
(426, 'Orocué', 9),
(427, 'Paz de Ariporo', 9),
(428, 'Pore', 9),
(429, 'Recetor', 9),
(430, 'Sabanalarga', 9),
(431, 'Sacama', 9),
(432, 'San Luis de Palenque', 9),
(433, 'Támara', 9),
(434, 'Tauramena', 9),
(435, 'Trinidad', 9),
(436, 'Tumara', 9),
(437, 'Villanueva', 9),
(438, 'Yopal', 9),
(439, 'Almaguer', 10),
(440, 'ALTAMIRA', 10),
(441, 'Argelia', 10),
(442, 'Balboa', 10),
(443, 'Belalcázar', 10),
(444, 'Bolívar', 10),
(445, 'Buenos Aires', 10),
(446, 'Cajibío', 10),
(447, 'Caldono', 10),
(448, 'Caldoñó', 10),
(449, 'Caloto', 10),
(450, 'Coconuco', 10),
(451, 'Corinto', 10),
(452, 'CUATRO ESQUINAS', 10),
(453, 'El Bordo', 10),
(454, 'EL CAIRO', 10),
(455, 'El Carmen', 10),
(456, 'EL HATO', 10),
(457, 'El Morro', 10),
(458, 'EL PALMAR', 10),
(459, 'EL RETIRO', 10),
(460, 'EL ROSARIO', 10),
(461, 'El Tambo', 10),
(462, 'Florencia', 10),
(463, 'Guachené', 10),
(464, 'Guapi', 10),
(465, 'Inzá', 10),
(466, 'Jambálo', 10),
(467, 'La Carbonera', 10),
(468, 'LA CHORRERA', 10),
(469, 'La Herradura', 10),
(470, 'La Sierra', 10),
(471, 'La Vega', 10),
(472, 'LA VENTA', 10),
(473, 'LAS CRUCES', 10),
(474, 'López', 10),
(475, 'López de Micay', 10),
(476, 'Mercaderes', 10),
(477, 'Miranda', 10),
(478, 'Mondomo', 10),
(479, 'MONTERREDONDO', 10),
(480, 'Morales', 10),
(481, 'Padilla', 10),
(482, 'Páez', 10),
(483, 'Paispamba', 10),
(484, 'PARRAGA', 10),
(485, 'Patía ( El Bordo)', 10),
(486, 'PIAGUA', 10),
(487, 'Piamonte', 10),
(488, 'Piendamó', 10),
(489, 'Popayán', 10),
(490, 'Puerto Tejada', 10),
(491, 'Puracé', 10),
(492, 'QUILICACERIO', 10),
(493, 'BLANCO', 10),
(494, 'Rosas', 10),
(495, 'San Joaquín', 10),
(496, 'SAN MIGUEL', 10),
(497, 'San Sebastián', 10),
(498, 'SANTA RITA', 10),
(499, 'Santa Rosa', 10),
(500, 'SANTA ROSA BOTA CAUCANA', 10),
(501, 'Santander de Quilichao', 10),
(502, 'SIBERIA', 10),
(503, 'Silvia', 10),
(504, 'Sotará', 10),
(505, 'Suárez', 10),
(506, 'Timbío', 10),
(507, 'Timbiquí', 10),
(508, 'Toribío', 10),
(509, 'Totoró', 10),
(510, 'Tunía', 10),
(511, 'Villarica', 10),
(512, 'ZARZAL', 10),
(513, 'Aguachica', 11),
(514, 'Agustín Codazzi', 11),
(515, 'Becerril', 11),
(516, 'Bosconia', 11),
(517, 'Chimichagua', 11),
(518, 'Chiriguaná', 11),
(519, 'Curumaní', 11),
(520, 'El Copey', 11),
(521, 'El Paso', 11),
(522, 'Gamarra', 11),
(523, 'González', 11),
(524, 'La Gloria', 11),
(525, 'La Paz', 11),
(526, 'Pailitas', 11),
(527, 'Pelaya', 11),
(528, 'Río de Oro', 11),
(529, 'San Alberto', 11),
(530, 'San Diego', 11),
(531, 'San Martín', 11),
(532, 'Tamalameque', 11),
(533, 'Valledupar', 11),
(534, 'Pueblo Bello', 11),
(535, 'Astrea', 11),
(536, 'Manaure Balcón del Cesar', 11),
(537, 'Acandí', 12),
(538, 'Alto Baudó', 12),
(539, 'Atradó', 12),
(540, 'Bagadó', 12),
(541, 'Bahía Solano', 12),
(542, 'Bajo Baudó', 12),
(543, 'Bojaya', 12),
(544, 'Carmen de Atrato', 12),
(545, 'Chocó', 12),
(546, 'Condoto', 12),
(547, 'El Cantón de San Pablo', 12),
(548, 'Istmina', 12),
(549, 'Juradó', 12),
(550, 'Litoral de San Juan', 12),
(551, 'Lloró', 12),
(552, 'Noquí', 12),
(553, 'Novita', 12),
(554, 'Nuquí', 12),
(555, 'Quibdó', 12),
(556, 'Riosucio', 12),
(557, 'San José del Palmar', 12),
(558, 'Sipí', 12),
(559, 'Tadó', 12),
(560, 'Unguía', 12),
(561, 'Carmen del Darién', 12),
(562, 'Pizarro', 12),
(563, 'Ayapel', 13),
(564, 'Buenavista', 13),
(565, 'Canalete', 13),
(566, 'Cereté', 13),
(567, 'Chimá', 13),
(568, 'Chinú', 13),
(569, 'Ciénaga de Oro', 13),
(570, 'Cotorra', 13),
(571, 'La Apartada', 13),
(572, 'Lorica', 13),
(573, 'Los Córdobas', 13),
(574, 'Momil', 13),
(575, 'Monitos', 13),
(576, 'Montelíbano', 13),
(577, 'Montería', 13),
(578, 'Planeta Rica', 13),
(579, 'Pueblo Nuevo', 13),
(580, 'Puerto Escondido', 13),
(581, 'Puerto Libertador', 13),
(582, 'Purísima', 13),
(583, 'Sahagún', 13),
(584, 'San Andrés de Sotavento', 13),
(585, 'San Antero', 13),
(586, 'San Bernardo del Viento', 13),
(587, 'San Carlos', 13),
(588, 'San Pelayo', 13),
(589, 'Tierralta', 13),
(590, 'Valencia', 13),
(591, 'Agua de Dios', 14),
(592, 'Albán', 14),
(593, 'Anapoima', 14),
(594, 'Anolaima', 14),
(595, 'Apulo', 14),
(596, 'Arbeláez', 14),
(597, 'Beltrán', 14),
(598, 'Bituima', 14),
(599, 'Bojacá', 14),
(600, 'Cabrera', 14),
(601, 'Cachipay', 14),
(602, 'Cajicá', 14),
(603, 'Caparrapí', 14),
(604, 'Cáqueza', 14),
(605, 'Carmen de Carupa', 14),
(606, 'Chaguaní', 14),
(607, 'Chía', 14),
(608, 'Chinauta', 14),
(609, 'Chipaque', 14),
(610, 'Choachí', 14),
(611, 'Chocontá', 14),
(612, 'Cogua', 14),
(613, 'Cota', 14),
(614, 'Cucunubá', 14),
(615, 'El Colegio', 14),
(616, 'El Peñón', 14),
(617, 'El Rosal', 14),
(618, 'Facatativá', 14),
(619, 'Fómeque', 14),
(620, 'Fosca', 14),
(621, 'Funza', 14),
(622, 'Fúquene', 14),
(623, 'Fusagasugá', 14),
(624, 'Gachalá', 14),
(625, 'Gachancipá', 14),
(626, 'Gachetá', 14),
(627, 'Gama', 14),
(628, 'Girardot', 14),
(629, 'Granada', 14),
(630, 'Guachetá', 14),
(631, 'Guaduas', 14),
(632, 'Guasca', 14),
(633, 'Guataquí', 14),
(634, 'Guatavita', 14),
(635, 'Guayabal de Síquima', 14),
(636, 'Guayabetal', 14),
(637, 'Gutiérrez', 14),
(638, 'Jerusalén', 14),
(639, 'Junín', 14),
(640, 'La Calera', 14),
(641, 'La Mesa', 14),
(642, 'La Palma', 14),
(643, 'La Peña', 14),
(644, 'La Vega', 14),
(645, 'Lenguazaque', 14),
(646, 'Machetá', 14),
(647, 'Madrid', 14),
(648, 'Manta', 14),
(649, 'Medina', 14),
(650, 'Mosquera', 14),
(651, 'Nariño', 14),
(652, 'Nemocón', 14),
(653, 'Nilo', 14),
(654, 'Nimaima', 14),
(655, 'Nocaima', 14),
(656, 'Pacho', 14),
(657, 'Paime', 14),
(658, 'Pandi', 14),
(659, 'Paratebueno', 14),
(660, 'Pasca', 14),
(661, 'Puerto Salgar', 14),
(662, 'Pulí', 14),
(663, 'Quebradanegra', 14),
(664, 'Quetame', 14),
(665, 'Quipile', 14),
(666, 'Ricaurte', 14),
(667, 'San Antonio del Tequendama', 14),
(668, 'San Bernardo', 14),
(669, 'San Cayetano', 14),
(670, 'San Francisco', 14),
(671, 'San Juan de Rioseco', 14),
(672, 'Sasaima', 14),
(673, 'Sesquilé', 14),
(674, 'Sibaté', 14),
(675, 'Silvania', 14),
(676, 'Simijaca', 14),
(677, 'Sisga', 14),
(678, 'Soacha', 14),
(679, 'Sopó', 14),
(680, 'Subachoque', 14),
(681, 'Suesca', 14),
(682, 'Supatá', 14),
(683, 'Susa', 14),
(684, 'Sutatausa', 14),
(685, 'Tabio', 14),
(686, 'Tausa', 14),
(687, 'Tena', 14),
(688, 'Tenjo', 14),
(689, 'Tibacuy', 14),
(690, 'Tibirita', 14),
(691, 'Tocaima', 14),
(692, 'Tocancipá', 14),
(693, 'Topaipí', 14),
(694, 'Ubalá', 14),
(695, 'Ubaque', 14),
(696, 'Ubaté', 14),
(697, 'Une', 14),
(698, 'Utica', 14),
(699, 'Venecia - Ospina Pérez', 14),
(700, 'Vergara', 14),
(701, 'Viani', 14),
(702, 'Villagómez', 14),
(703, 'Villapinzón', 14),
(704, 'Villeta', 14),
(705, 'Viotá', 14),
(706, 'Yacopí', 14),
(707, 'Zipacón', 14),
(708, 'Zipaquirá', 14),
(709, 'Capellania', 14),
(710, 'La Punta', 14),
(711, 'Santandercito', 14),
(712, 'Tobia', 14),
(713, 'Siberia', 14),
(714, 'Inírida', 15),
(715, 'Guaviare', 15),
(716, 'Puerto Inírida', 15),
(717, 'San José Del Guaviare', 16),
(718, 'Calamar', 16),
(719, 'El Retorno', 16),
(720, 'Miraflores', 16),
(721, 'Morichal', 16),
(722, 'Acevedo', 17),
(723, 'Agrado', 17),
(724, 'Aipe', 17),
(725, 'Algeciras', 17),
(726, 'Altamira', 17),
(727, 'Baraya', 17),
(728, 'Campoalegre', 17),
(729, 'Ciudad de Colombia', 17),
(730, 'Elías', 17),
(731, 'Fortalecillas', 17),
(732, 'Garzón', 17),
(733, 'Gigante', 17),
(734, 'Guadalupe', 17),
(735, 'Hobo', 17),
(736, 'Iquira', 17),
(737, 'Isnos', 17),
(738, 'La Argentina', 17),
(739, 'La Plata', 17),
(740, 'Nátaga', 17),
(741, 'Neiva', 17),
(742, 'Oporapa', 17),
(743, 'Paicol', 17),
(744, 'Palermo', 17),
(745, 'Palestina', 17),
(746, 'Pital', 17),
(747, 'Pitalito', 17),
(748, 'Rivera', 17),
(749, 'Saladoblanco', 17),
(750, 'San Agustín', 17),
(751, 'Santa María', 17),
(752, 'Suaza', 17),
(753, 'Tárqui', 17),
(754, 'Tello', 17),
(755, 'Teruel', 17),
(756, 'Tesalia', 17),
(757, 'Timaná', 17),
(758, 'Villavieja', 17),
(759, 'Yaguará', 17),
(760, 'Caguán', 17),
(761, 'Juncal', 17),
(762, 'La Jagua', 17),
(763, 'La Ulloa', 17),
(764, 'Maito', 17),
(765, 'Pacarní', 17),
(766, 'Santa Helena', 17),
(767, 'Vegalarga', 17),
(768, 'Zuluaga', 17),
(769, 'Belén', 17),
(770, 'Barrancas', 18),
(771, 'Dibulia', 18),
(772, 'Distracción', 18),
(773, 'El Molino', 18),
(774, 'Fonseca', 18),
(775, 'Hato Nuevo', 18),
(776, 'Manaure', 18),
(777, 'Riohacha', 18),
(778, 'San Juan del Cesar', 18),
(779, 'Uribia', 18),
(780, 'Urumita', 18),
(781, 'Maicao', 18),
(782, 'Villanueva', 18),
(783, 'Albania', 18),
(784, 'Algarrobo', 19),
(785, 'Aracataca', 19),
(786, 'Ariguaní', 19),
(787, 'Cerro de San Antonio', 19),
(788, 'Chivolo', 19),
(789, 'Ciénaga', 19),
(790, 'Concordia', 19),
(791, 'El Banco', 19),
(792, 'El Difícil', 19),
(793, 'El Piñón', 19),
(794, 'El Retén', 19),
(795, 'Fundación', 19),
(796, 'Guamal', 19),
(797, 'Pedraza', 19),
(798, 'Pijiño del Carmen', 19),
(799, 'Pivijay', 19),
(800, 'Plato', 19),
(801, 'Puebloviejo', 19),
(802, 'Remolino', 19),
(803, 'Salamina', 19),
(804, 'San Angel', 19),
(805, 'San Sebastián de Buenavista', 19),
(806, 'San Zenón', 19),
(807, 'Santa Ana', 19),
(808, 'Santa Marta', 19),
(809, 'Sitionuevo', 19),
(810, 'Tenerife', 19),
(811, 'Zona Bananera', 19),
(812, 'Acacías', 20),
(813, 'Barranca de Upia', 20),
(814, 'Cabuyaro', 20),
(815, 'Castilla La Nueva', 20),
(816, 'Cubarral', 20),
(817, 'Cumaral', 20),
(818, 'El Calvario', 20),
(819, 'El Castillo', 20),
(820, 'El Dorado', 20),
(821, 'Fuente de Oro', 20),
(822, 'Granada', 20),
(823, 'Guamal', 20),
(824, 'La Macarena', 20),
(825, 'La Uribe', 20),
(826, 'Lejanías', 20),
(827, 'Mapiripán', 20),
(828, 'Mesetas', 20),
(829, 'Puerto Concordia', 20),
(830, 'Puerto Gaitán', 20),
(831, 'Puerto Lleras', 20),
(832, 'Puerto López', 20),
(833, 'Puerto Rico', 20),
(834, 'Restrepo', 20),
(835, 'San Carlos Guaroa', 20),
(836, 'San Juan de Arama', 20),
(837, 'San Juanito', 20),
(838, 'San Martín', 20),
(839, 'Villavicencio', 20),
(840, 'Vista Hermosa', 20),
(841, 'Albán', 21),
(842, 'Aldana', 21),
(843, 'Ancuyá', 21),
(844, 'Arboleda', 21),
(845, 'Barbacoas', 21),
(846, 'Belén', 21),
(847, 'Berruecos', 21),
(848, 'Bomboná', 21),
(849, 'Buesaco', 21),
(850, 'Catambuco', 21),
(851, 'Chachaguí', 21),
(852, 'Chachaouit', 21),
(853, 'Colón', 21),
(854, 'Consaca', 21),
(855, 'Contadero', 21),
(856, 'Córdoba', 21),
(857, 'Cuaspud', 21),
(858, 'Cumbal', 21),
(859, 'Cumbitara', 21),
(860, 'Cumbitra', 21),
(861, 'El Charco', 21),
(862, 'El Chorrillo', 21),
(863, 'El Peñol', 21),
(864, 'El Remolino', 21),
(865, 'El Rosario', 21),
(866, 'El Tablón', 21),
(867, 'El Tambo', 21),
(868, 'Francisco Pizarro', 21),
(869, 'Funes', 21),
(870, 'Guachávez', 21),
(871, 'Guachucal', 21),
(872, 'Guaitarilla', 21),
(873, 'Gualmatán', 21),
(874, 'Guitarrilla', 21),
(875, 'Iles', 21),
(876, 'Imúes', 21),
(877, 'Ipiales', 21),
(878, 'José María Hernández', 21),
(879, 'La Cruz', 21),
(880, 'La Florida', 21),
(881, 'La Llamada', 21),
(882, 'La Llanada', 21),
(883, 'La Tola', 21),
(884, 'La Unión', 21),
(885, 'Leiva', 21),
(886, 'Linares', 21),
(887, 'Los Andes', 21),
(888, 'Maguí', 21),
(889, 'Mallama', 21),
(890, 'Mocoa', 21),
(891, 'Mosquera', 21),
(892, 'Olaya Herrera', 21),
(893, 'Ospina', 21),
(894, 'Pasto', 21),
(895, 'Payam', 21),
(896, 'Pilcuán', 21),
(897, 'Policarpa', 21),
(898, 'Potosí', 21),
(899, 'Providencia', 21),
(900, 'Provincia', 21),
(901, 'Puerres', 21),
(902, 'Pupiales', 21),
(903, 'Ricaurte', 21),
(904, 'Roberto Payán', 21),
(905, 'Rosaflorida', 21),
(906, 'Samaniego', 21),
(907, 'San Bernardo', 21),
(908, 'San José', 21),
(909, 'San Lorenzo', 21),
(910, 'San Pablo', 21),
(911, 'San Pedro Cartago', 21),
(912, 'San Remo', 21),
(913, 'Sandoná', 21),
(914, 'Santa Bárbara', 21),
(915, 'Santacruz', 21),
(916, 'Sapuyes', 21),
(917, 'Sibundoy', 21),
(918, 'Sotomayor', 21),
(919, 'Taminango', 21),
(920, 'Tangua', 21),
(921, 'Tumaco', 21),
(922, 'Túquerres', 21),
(923, 'Uribe', 21),
(924, 'Yacuanquer', 21),
(925, 'Abrego', 22),
(926, 'Arboledas', 22),
(927, 'Bochalema', 22),
(928, 'Bucarasica', 22),
(929, 'Cachira', 22),
(930, 'Cacota', 22),
(931, 'Chinácota', 22),
(932, 'Chitagá', 22),
(933, 'Convención', 22),
(934, 'Cúcuta', 22),
(935, 'Cucutilla', 22),
(936, 'Durania', 22),
(937, 'El Carmen', 22),
(938, 'El Taira', 22),
(939, 'El Tarra', 22),
(940, 'El Zulia', 22),
(941, 'Gramalote', 22),
(942, 'Hacarí', 22),
(943, 'Herrán', 22),
(944, 'La Esperanza', 22),
(945, 'La Playa', 22),
(946, 'Labateca', 22),
(947, 'Los Patios', 22),
(948, 'Lourdes', 22),
(949, 'Motiscua', 22),
(950, 'Mutiscua', 22),
(951, 'Ocaña', 22),
(952, 'Pamplona', 22),
(953, 'Pamplonita', 22),
(954, 'Puerto Santander', 22),
(955, 'Ragonvalia', 22),
(956, 'Salazar', 22),
(957, 'San Calixto', 22),
(958, 'San Cayetano', 22),
(959, 'Santiago', 22),
(960, 'Sardinata', 22),
(961, 'Silos', 22),
(962, 'Teorama', 22),
(963, 'Teorema', 22),
(964, 'Tibú', 22),
(965, 'Toledo', 22),
(966, 'Villa Caro', 22),
(967, 'Villa del Rosario', 22),
(968, 'Colón', 23),
(969, 'Mocoa', 23),
(970, 'Orito', 23),
(971, 'Puerto Asís', 23),
(972, 'Puerto Caicedo', 23),
(973, 'Puerto Guzmán', 23),
(974, 'Puerto Leguízamo', 23),
(975, 'San Francisco', 23),
(976, 'San Miguel', 23),
(977, 'Santiago', 23),
(978, 'Sibundoy', 23),
(979, 'Valle del Guamuez', 23),
(980, 'Villagarzón', 23),
(981, 'Armenia', 24),
(982, 'Barcelona', 24),
(983, 'Buenavista', 24),
(984, 'Calarcá', 24),
(985, 'Circasia', 24),
(986, 'Córdoba', 24),
(987, 'Filandia', 24),
(988, 'Génova', 24),
(989, 'La Tebaida', 24),
(990, 'Montenegro', 24),
(991, 'Pijao', 24),
(992, 'Pueblo Tapao', 24),
(993, 'Quimbaya', 24),
(994, 'Salento', 24),
(995, 'Apía', 25),
(996, 'Balboa', 25),
(997, 'Belén de Umbría', 25),
(998, 'Dosquebradas', 25),
(999, 'Guática', 25),
(1000, 'Irra', 25),
(1001, 'La Celia', 25),
(1002, 'La Virginia', 25),
(1003, 'Marsella', 25),
(1004, 'Marsella Alto Cauca', 25),
(1005, 'Mistrató', 25),
(1006, 'Pereira', 25),
(1007, 'Pueblo Rico', 25),
(1008, 'Quinchía', 25),
(1009, 'Santa Cecilia', 25),
(1010, 'Santa Rosa de Cabal', 25),
(1011, 'Santuario', 25),
(1012, 'Taparcal-Belen de Umbria', 25),
(1013, 'San Andrés', 26),
(1014, 'Providencia', 26),
(1015, 'Aguada', 27),
(1016, 'Albania', 27),
(1017, 'Aratoca', 27),
(1018, 'Barbosa', 27),
(1019, 'Barichara', 27),
(1020, 'Barrancabermeja', 27),
(1021, 'Betulia', 27),
(1022, 'Bolívar', 27),
(1023, 'Bucaramanga', 27),
(1024, 'Cabrera', 27),
(1025, 'Caldas', 27),
(1026, 'California', 27),
(1027, 'Capitá', 27),
(1028, 'Capitanejo', 27),
(1029, 'Carcasi', 27),
(1030, 'Cepita', 27),
(1031, 'Cerrito', 27),
(1032, 'Charalá', 27),
(1033, 'Charta', 27),
(1034, 'Chimá', 27),
(1035, 'Chipatá', 27),
(1036, 'Cimitarra', 27),
(1037, 'Cite', 27),
(1038, 'Concepción', 27),
(1039, 'Confines', 27),
(1040, 'Contratación', 27),
(1041, 'Coromoro', 27),
(1042, 'Curití', 27),
(1043, 'El Cármen', 27),
(1044, 'El Guacamayo', 27),
(1045, 'El Peñón', 27),
(1046, 'El Playón', 27),
(1047, 'Encino', 27),
(1048, 'Enciso', 27),
(1049, 'Florián', 27),
(1050, 'Floridablanca', 27),
(1051, 'Galán', 27),
(1052, 'Gámbita', 27),
(1053, 'Girón', 27),
(1054, 'Guaca', 27),
(1055, 'Guadalupe', 27),
(1056, 'Guapota', 27),
(1057, 'Guavatá', 27),
(1058, 'Güepsa', 27),
(1059, 'Hato', 27),
(1060, 'Jesús María', 27),
(1061, 'Jordán', 27),
(1062, 'La Belleza', 27),
(1063, 'La Paz', 27),
(1064, 'Landázuri', 27),
(1065, 'Lebrija', 27),
(1066, 'Los Santos', 27),
(1067, 'Macaravita', 27),
(1068, 'Málaga', 27),
(1069, 'Matanza', 27),
(1070, 'Mogotes', 27),
(1071, 'Molagavita', 27),
(1072, 'Ocamonte', 27),
(1073, 'Oiba', 27),
(1074, 'Onzaga', 27),
(1075, 'Palmar', 27),
(1076, 'Palmas Socorro', 27),
(1077, 'Páramo', 27),
(1078, 'Piedecuesta', 27),
(1079, 'Pinchote', 27),
(1080, 'Puente Nacional', 27),
(1081, 'Puerto Parra', 27),
(1082, 'Puerto Wilches', 27),
(1083, 'Rionegro', 27),
(1084, 'Sabana de Torres', 27),
(1085, 'San Andrés', 27),
(1086, 'San Benito', 27),
(1087, 'San Gil', 27),
(1088, 'San Joaquín', 27),
(1089, 'San José de Miranda', 27),
(1090, 'San Miguel', 27),
(1091, 'San Vicente de Chucurí', 27),
(1092, 'Santa Bárbara', 27),
(1093, 'Santa Helena del Opón', 27),
(1094, 'Simacota', 27),
(1095, 'Socorro', 27),
(1096, 'Suaita', 27),
(1097, 'Sucre', 27),
(1098, 'Suratá', 27),
(1099, 'Tona', 27),
(1100, 'Vado Real', 27),
(1101, 'Valle San José', 27),
(1102, 'Vélez', 27),
(1103, 'Vetas', 27),
(1104, 'Villanueva', 27),
(1105, 'Zapatoca', 27),
(1106, 'Betulia', 28),
(1107, 'Buenavista', 28),
(1108, 'Caimito', 28),
(1109, 'Chalán', 28),
(1110, 'Colosó', 28),
(1111, 'Corozal', 28),
(1112, 'Coveñas', 28),
(1113, 'Galeras', 28),
(1114, 'Guaranda', 28),
(1115, 'La Unión', 28),
(1116, 'Los Palmitos', 28),
(1117, 'Majagual', 28),
(1118, 'Morroa', 28),
(1119, 'Ovejas', 28),
(1120, 'Sampués', 28),
(1121, 'San Benito Abad', 28),
(1122, 'San Juan de Betulia', 28),
(1123, 'San Marcos', 28),
(1124, 'San Onofre', 28),
(1125, 'San Pedro', 28),
(1126, 'Sincé', 28),
(1127, 'Sincelejo', 28),
(1128, 'Sucre', 28),
(1129, 'Tolú', 28),
(1130, 'Toluviejo', 28),
(1131, 'Alpujarra', 29),
(1132, 'Alvarado', 29),
(1133, 'Ambalema', 29),
(1134, 'Anaime', 29),
(1135, 'Anzoátegui', 29),
(1136, 'Armero', 29),
(1137, 'Armero-Guayabal', 29),
(1138, 'Ataco', 29),
(1139, 'Cajamarca', 29),
(1140, 'Cambao', 29),
(1141, 'Carmen de Apicalá', 29),
(1142, 'Casabianca', 29),
(1143, 'Chaparral', 29),
(1144, 'Chicoral', 29),
(1145, 'Coello', 29),
(1146, 'Coyaima', 29),
(1147, 'Cunday', 29),
(1148, 'Dolores', 29),
(1149, 'Espinal', 29),
(1150, 'Falan', 29),
(1151, 'Flandes', 29),
(1152, 'Fresno', 29),
(1153, 'Guamo', 29),
(1154, 'Herveo', 29),
(1155, 'Honda', 29),
(1156, 'Ibagué', 29),
(1157, 'Icononzo', 29),
(1158, 'La Sierra', 29),
(1159, 'Lérida', 29),
(1160, 'Líbano', 29),
(1161, 'Mariquita', 29),
(1162, 'Melgar', 29),
(1163, 'Murillo', 29),
(1164, 'Natagaima', 29),
(1165, 'Ortega', 29),
(1166, 'Palocabildo', 29),
(1167, 'Piedras', 29),
(1168, 'Planadas', 29),
(1169, 'Prado', 29),
(1170, 'Purificación', 29),
(1171, 'Rioblanco', 29),
(1172, 'Roncesvalles', 29),
(1173, 'Rovira', 29),
(1174, 'Saldaña', 29),
(1175, 'San Antonio', 29),
(1176, 'San Luis', 29),
(1177, 'Santa Isabel', 29),
(1178, 'Suárez', 29),
(1179, 'Valle de San Juan', 29),
(1180, 'Venadillo', 29),
(1181, 'Villahermosa', 29),
(1182, 'Villarrica', 29),
(1183, 'Beltrán', 29),
(1184, 'Castilla', 29),
(1185, 'Convenio', 29),
(1186, 'Chenche Asoleado', 29),
(1187, 'Doima', 29),
(1188, 'El Tablazo', 29),
(1189, 'Frias', 29),
(1190, 'Gaitania', 29),
(1191, 'Gualanday', 29),
(1192, 'Herrera', 29),
(1193, 'Junin', 29),
(1194, 'La Arada', 29),
(1195, 'La Chamba', 29),
(1196, 'Olaya Herrera', 29),
(1197, 'Padua', 29),
(1198, 'Payandé', 29),
(1199, 'Playarrica', 29),
(1200, 'Santa Teresa', 29),
(1201, 'Santiago Pérez', 29),
(1202, 'Tres Esquinas', 29),
(1203, 'Velú', 29),
(1204, 'Albán', 30),
(1205, 'Alcalá', 30),
(1206, 'Andalucía', 30),
(1207, 'Ansermanuevo', 30),
(1208, 'Argelia', 30),
(1209, 'Barragán', 30),
(1210, 'Bitaco', 30),
(1211, 'Bolívar', 30),
(1212, 'Buenaventura', 30),
(1213, 'Buenos Aires', 30),
(1214, 'Buga', 30),
(1215, 'Bugalagrande', 30),
(1216, 'Caicedonia', 30),
(1217, 'Cali', 30),
(1218, 'Calima', 30),
(1219, 'Candelaria', 30),
(1220, 'Cartago', 30),
(1221, 'Ceylan', 30),
(1222, 'Costa Rica', 30),
(1223, 'Dagua', 30),
(1224, 'Dapa', 30),
(1225, 'Darién', 30),
(1226, 'El Aguila', 30),
(1227, 'El Bolo', 30),
(1228, 'El Cairo', 30),
(1229, 'El Carmelo', 30),
(1230, 'El Carmen', 30),
(1231, 'El Cerrito', 30),
(1232, 'El Dovio', 30),
(1233, 'Fenicia', 30),
(1234, 'Florida', 30),
(1235, 'Galicia', 30),
(1236, 'Ginebra', 30),
(1237, 'Guacarí', 30),
(1238, 'Jamundí', 30),
(1239, 'Juachaco', 30),
(1240, 'Km 26', 30),
(1241, 'La Bocana', 30),
(1242, 'La Buitrera', 30),
(1243, 'La Cumbre', 30),
(1244, 'La Dolores', 30),
(1245, 'La Iberia', 30),
(1246, 'La Nubia', 30),
(1247, 'La Unión', 30),
(1248, 'La Victoria', 30),
(1249, 'Ladrilleros', 30),
(1250, 'Lago Calima', 30),
(1251, 'Madrigal', 30),
(1252, 'Obando', 30),
(1253, 'Palmaseca', 30),
(1254, 'Palmira', 30),
(1255, 'Pavas', 30),
(1256, 'Poblado Campestre', 30),
(1257, 'Potrerito', 30),
(1258, 'Pradera', 30),
(1259, 'Queremal', 30),
(1260, 'Restrepo', 30),
(1261, 'Riofrío', 30),
(1262, 'Roldanillo', 30),
(1263, 'Rozo', 30),
(1264, 'Salónica', 30),
(1265, 'Samaria', 30),
(1266, 'San Antonio de los Caballeros', 30),
(1267, 'San Pedro', 30),
(1268, 'Santa Helena', 30),
(1269, 'Santa Lucía', 30),
(1270, 'Sevilla', 30),
(1271, 'Sonso', 30),
(1272, 'Tienda Nueva', 30),
(1273, 'Toro', 30),
(1274, 'Trujillo', 30),
(1275, 'Tuluá', 30),
(1276, 'Ulloa', 30),
(1277, 'Venecia', 30),
(1278, 'Versalles', 30),
(1279, 'Vijes', 30),
(1280, 'Villagorgona', 30),
(1281, 'Yotoco', 30),
(1282, 'Yumbo', 30),
(1283, 'Zarzal', 30),
(1284, 'Ameime', 30),
(1285, 'El Placer', 30),
(1286, 'Quebrada Nueva', 30),
(1287, 'Rurales Valle', 30),
(1288, 'La Marina', 30),
(1289, 'La Horqueta', 30),
(1290, 'Bahía Malaga', 30),
(1291, 'Carurú', 31),
(1292, 'Cumaribo', 31),
(1293, 'La Hormiga', 31),
(1294, 'La Primavera', 31),
(1295, 'Mitú', 31),
(1296, 'Nueva Antioquia', 31),
(1297, 'Pacoa', 31),
(1298, 'San José de Ocune', 31),
(1299, 'Santa Rita', 31),
(1300, 'Santa Rosalía', 31),
(1301, 'Taraira', 31),
(1302, 'Toraira', 31),
(1303, 'Vichada', 31),
(1304, 'Yavarate', 31),
(1305, 'Puerto Carreño', 32);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `departamento`
--

CREATE TABLE `departamento` (
  `DEPidDepPK` int(10) UNSIGNED NOT NULL,
  `DEPnomDep` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `departamento`
--

INSERT INTO `departamento` (`DEPidDepPK`, `DEPnomDep`) VALUES
(1, 'Amazonas'),
(2, 'Antioquia'),
(3, 'Arauca'),
(4, 'Atlántico'),
(5, 'Bolívar'),
(6, 'Boyacá'),
(7, 'Caldas'),
(8, 'Caquetá'),
(9, 'Casanare'),
(10, 'Cauca'),
(11, 'Cesar'),
(12, 'Chocó'),
(13, 'Córdoba'),
(14, 'Cundinamarca'),
(15, 'Guainía'),
(16, 'Guaviare'),
(17, 'Huila'),
(18, 'La Guajira'),
(19, 'Magdalena'),
(20, 'Meta'),
(21, 'Nariño'),
(22, 'Norte de Santander'),
(23, 'Putumayo'),
(24, 'Quindío'),
(25, 'Risaralda'),
(26, 'San Andrés y Providencia'),
(27, 'Santander'),
(28, 'Sucre'),
(29, 'Tolima'),
(30, 'Valle del Cauca'),
(31, 'Vaupés'),
(32, 'Vichada');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `documento`
--

CREATE TABLE `documento` (
  `DOCidDocPK` int(10) UNSIGNED NOT NULL,
  `DOCdesTipDoc` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `documento`
--

INSERT INTO `documento` (`DOCidDocPK`, `DOCdesTipDoc`) VALUES
(1, 'RC'),
(2, 'TI'),
(3, 'CC'),
(4, 'CE');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entsal`
--

CREATE TABLE `entsal` (
  `ESidEntSalPK` int(10) UNSIGNED NOT NULL,
  `ESidPerFK` int(10) UNSIGNED DEFAULT NULL,
  `ESidTiEnSaFK` int(10) UNSIGNED DEFAULT NULL,
  `ESfecHor` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ESnov` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entsalequ`
--

CREATE TABLE `entsalequ` (
  `ESQidEnSaPK` int(10) UNSIGNED NOT NULL,
  `ESQidEquFK` int(10) UNSIGNED DEFAULT NULL,
  `ESQtiEnSaEq` int(2) NOT NULL,
  `ESQfeEnEq` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ESQidPerFK` int(11) NOT NULL,
  `ESQnov` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipos`
--

CREATE TABLE `equipos` (
  `EQUidEquPK` int(10) UNSIGNED NOT NULL,
  `EQUidMarPK` int(10) UNSIGNED NOT NULL,
  `EQUmod` varchar(30) DEFAULT NULL,
  `EQUser` varchar(30) DEFAULT NULL,
  `EQUidTipFK` int(10) UNSIGNED NOT NULL,
  `EQUdes` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ficha`
--

CREATE TABLE `ficha` (
  `FICidFicPK` int(10) UNSIGNED NOT NULL,
  `FICnumFic` int(15) NOT NULL,
  `FICdesFic` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ficha`
--

INSERT INTO `ficha` (`FICidFicPK`, `FICnumFic`, `FICdesFic`) VALUES
(1, 1095701, 'ADSI 113');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `genero`
--

CREATE TABLE `genero` (
  `GENidGenPK` int(10) UNSIGNED NOT NULL,
  `GENdesGen` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `genero`
--

INSERT INTO `genero` (`GENidGenPK`, `GENdesGen`) VALUES
(1, 'FEMENINO'),
(2, 'MASCULINO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `marequ`
--

CREATE TABLE `marequ` (
  `MEidMaEqPK` int(10) UNSIGNED NOT NULL,
  `MEdeMaEq` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `marequ`
--

INSERT INTO `marequ` (`MEidMaEqPK`, `MEdeMaEq`) VALUES
(1, 'ACER'),
(2, 'ASUS'),
(3, 'APPLE'),
(4, 'DELL'),
(5, 'GATEWAY'),
(6, 'HP'),
(7, 'LENOVO'),
(8, 'LG'),
(9, 'PC SMART'),
(10, 'TOSHIBA'),
(11, 'SONY'),
(12, 'OTROS');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `perequ`
--

CREATE TABLE `perequ` (
  `PEidPerFK` int(10) UNSIGNED NOT NULL,
  `PEidEquFK` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `PERidPerPK` int(10) UNSIGNED NOT NULL,
  `PERidDocFK` int(10) UNSIGNED NOT NULL,
  `PERnumDoc` int(15) NOT NULL,
  `PERnom1` varchar(30) NOT NULL,
  `PERnom2` varchar(30) DEFAULT NULL,
  `PERape1` varchar(30) NOT NULL,
  `PERape2` varchar(30) DEFAULT NULL,
  `PERidGenFK` int(10) UNSIGNED NOT NULL,
  `PERdir` varchar(100) DEFAULT NULL,
  `PERtelFij` int(10) DEFAULT NULL,
  `PERcel` int(12) DEFAULT NULL,
  `PERcor` varchar(100) DEFAULT NULL,
  `PERidRhFK` int(10) UNSIGNED NOT NULL,
  `PERidTiPeFK` int(10) UNSIGNED NOT NULL,
  `PERidRolFK` int(10) UNSIGNED DEFAULT NULL,
  `PERidCenFK` int(10) UNSIGNED DEFAULT NULL,
  `PERidFicFK` int(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`PERidPerPK`, `PERidDocFK`, `PERnumDoc`, `PERnom1`, `PERnom2`, `PERape1`, `PERape2`, `PERidGenFK`, `PERdir`, `PERtelFij`, `PERcel`, `PERcor`, `PERidRhFK`, `PERidTiPeFK`, `PERidRolFK`, `PERidCenFK`, `PERidFicFK`) VALUES
(1, 3, 12345, 'ADMIN', 'ADMIN', 'ADMIN', 'ADMIN', 2, 'prueba', 0, 1111111, 'ADMIN@admin.com', 1, 1, 1, 1, 1),
(2, 3, 54321, 'User', 'User', 'User', 'User', 2, 'prueba', 0, 1111111, 'user@admin.com', 1, 1, 3, 1, 1),
(4, 3, 14609952, 'Alexander', '', 'Salinas', 'Lozano', 2, 'Cll 110 #284-18', 4223601, 2147483647, 'salinas.alexander@gmail.com', 1, 2, 1, 1, 1),
(5, 3, 94539564, 'jonnathan', '', 'valencia', 'perlaza', 2, 'dig 70 No 23 A - 151', 6638621, 2147483647, 'ican.jonna@gmail.com', 1, 1, 3, 1, 1),
(6, 3, 1012378485, 'Jancel', 'Hernan', 'Perez', 'Paternin', 2, 'calle 42', 0, 0, 'jhperez@admin.com', 1, 1, 1, 1, 1),
(7, 3, 16941522, 'JULIO', 'EDUARDO', 'PABON', 'ERAZO', 2, 'DG 29A T27-27', 3343531, 2147483647, 'jepabon22@misena.edu.co', 1, 1, 1, 1, 1),
(8, 3, 16378842, 'Cristhian', 'Andersson', 'Caicedo', 'Lopez', 2, 'Carrera 25 # 52 - 71', 0, 2147483647, 'cacaicedo24@misena.edu.co', 1, 1, 3, 1, 1),
(9, 3, 1143941423, 'Luisa', 'Fernanda', 'Salazar', 'Solarte', 1, 'Cra 27 # 32 a 43', 3818339, 2147483647, 'lfsalazar32@misena.edu.co', 1, 1, 3, 1, 1),
(10, 3, 1143858861, 'Gustavo', 'Adolfo', 'Risueño', 'Zuñiga', 2, 'Carrera 39 a 30 c 63', 3378388, 2147483647, 'gustavoriu@hotmail.com', 1, 1, 1, 1, 1),
(11, 3, 14695164, 'Carlos', 'Andres', 'Morales', 'Hurtado', 2, 'Calle 35 15 34', 0, 2147483647, 'camorales461@misena.edu.co', 1, 1, 3, 1, 1),
(13, 3, 25026430, 'maria', 'yeimi', 'jaramillo', 'ocampo', 1, 'cra 26q # 72t-25', 3976050, 2147483647, 'yeimijaramillo1@gmail.com', 1, 1, 1, 1, 1),
(14, 3, 1080930332, 'William', 'Alexander', 'Gallardo', 'Barrera', 2, 'calle 69 No. 7bBis 12 Apto 211', 3767439, 2147483647, 'wagallardo@misena.edu.co', 4, 2, 1, 1, 1),
(20, 3, 1087132591, 'sammy', 'roberto', 'ruiz', 'ruiacines', 2, 'calle41A #50-33', 3314332, 2147483647, 'samyconciente12@hotmail.com', 1, 1, 1, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rh`
--

CREATE TABLE `rh` (
  `RHidRhPK` int(10) UNSIGNED NOT NULL,
  `RHdesRh` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `rh`
--

INSERT INTO `rh` (`RHidRhPK`, `RHdesRh`) VALUES
(1, 'A+'),
(2, 'B+'),
(3, 'AB+'),
(4, 'O+'),
(5, 'A-'),
(6, 'B-'),
(7, 'AB-'),
(8, 'O-');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `ROLidRolPK` int(10) UNSIGNED NOT NULL,
  `ROLdesRol` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`ROLidRolPK`, `ROLdesRol`) VALUES
(1, 'ADMINISTRADOR'),
(2, 'OPERADOR'),
(3, 'REGISTRADOR'),
(4, 'NINGUNO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sede`
--

CREATE TABLE `sede` (
  `SEDIdSedPK` int(10) UNSIGNED NOT NULL,
  `SEDnomSed` varchar(100) DEFAULT NULL,
  `SEDcodSenSed` int(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipentsal`
--

CREATE TABLE `tipentsal` (
  `TESidTiEnSaPK` int(10) UNSIGNED NOT NULL,
  `TESdeTiEnSa` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipentsal`
--

INSERT INTO `tipentsal` (`TESidTiEnSaPK`, `TESdeTiEnSa`) VALUES
(1, 'Entrada'),
(2, 'Salida'),
(3, 'Registro');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipequ`
--

CREATE TABLE `tipequ` (
  `TEidTiEqPK` int(10) UNSIGNED NOT NULL,
  `TEclaEqu` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipequ`
--

INSERT INTO `tipequ` (`TEidTiEqPK`, `TEclaEqu`) VALUES
(1, 'Portatil'),
(2, 'Tablet'),
(3, 'Celular'),
(4, 'Proyector');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipper`
--

CREATE TABLE `tipper` (
  `TPidTiPePK` int(10) UNSIGNED NOT NULL,
  `TPdeTiPe` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipper`
--

INSERT INTO `tipper` (`TPidTiPePK`, `TPdeTiPe`) VALUES
(1, 'Instructor'),
(2, 'Aprendiz'),
(3, 'Contratista'),
(4, 'Administrativo');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `acceso`
--
ALTER TABLE `acceso`
  ADD PRIMARY KEY (`ACCidAccPK`),
  ADD KEY `FK_per` (`ACCidPerFK`) USING BTREE;

--
-- Indices de la tabla `censed`
--
ALTER TABLE `censed`
  ADD KEY `FK_centros` (`CSidCenFK`) USING BTREE,
  ADD KEY `FK_sede` (`CSidSedFK`) USING BTREE;

--
-- Indices de la tabla `centros`
--
ALTER TABLE `centros`
  ADD PRIMARY KEY (`CENidCenPK`),
  ADD KEY `FK_ciudad` (`CENidCiuFK`) USING BTREE;

--
-- Indices de la tabla `ciudad`
--
ALTER TABLE `ciudad`
  ADD PRIMARY KEY (`CIUidCiuPK`),
  ADD KEY `FK_departamento` (`CIUidDepFK`) USING BTREE;

--
-- Indices de la tabla `departamento`
--
ALTER TABLE `departamento`
  ADD PRIMARY KEY (`DEPidDepPK`);

--
-- Indices de la tabla `documento`
--
ALTER TABLE `documento`
  ADD PRIMARY KEY (`DOCidDocPK`);

--
-- Indices de la tabla `entsal`
--
ALTER TABLE `entsal`
  ADD PRIMARY KEY (`ESidEntSalPK`),
  ADD KEY `FK_tipes` (`ESidTiEnSaFK`) USING BTREE,
  ADD KEY `Id_persona` (`ESidPerFK`) USING BTREE;

--
-- Indices de la tabla `entsalequ`
--
ALTER TABLE `entsalequ`
  ADD KEY `FK_entrs` (`ESQidEnSaPK`) USING BTREE,
  ADD KEY `FK_equips` (`ESQidEquFK`) USING BTREE;

--
-- Indices de la tabla `equipos`
--
ALTER TABLE `equipos`
  ADD PRIMARY KEY (`EQUidEquPK`),
  ADD KEY `FK_tipo_equipo` (`EQUidTipFK`) USING BTREE,
  ADD KEY `FK_marca_equipo` (`EQUidMarPK`) USING BTREE;

--
-- Indices de la tabla `ficha`
--
ALTER TABLE `ficha`
  ADD PRIMARY KEY (`FICidFicPK`);

--
-- Indices de la tabla `genero`
--
ALTER TABLE `genero`
  ADD PRIMARY KEY (`GENidGenPK`);

--
-- Indices de la tabla `marequ`
--
ALTER TABLE `marequ`
  ADD PRIMARY KEY (`MEidMaEqPK`);

--
-- Indices de la tabla `perequ`
--
ALTER TABLE `perequ`
  ADD PRIMARY KEY (`PEidPerFK`,`PEidEquFK`),
  ADD KEY `FK_equi` (`PEidEquFK`) USING BTREE;

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`PERidPerPK`),
  ADD KEY `FK_doc` (`PERidDocFK`) USING BTREE,
  ADD KEY `FK_gen` (`PERidGenFK`) USING BTREE,
  ADD KEY `FK_rh` (`PERidRhFK`) USING BTREE,
  ADD KEY `FK_tip` (`PERidTiPeFK`) USING BTREE,
  ADD KEY `FK_rol` (`PERidRolFK`) USING BTREE,
  ADD KEY `FK_cen` (`PERidCenFK`) USING BTREE,
  ADD KEY `FK_fic` (`PERidFicFK`) USING BTREE;

--
-- Indices de la tabla `rh`
--
ALTER TABLE `rh`
  ADD PRIMARY KEY (`RHidRhPK`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`ROLidRolPK`);

--
-- Indices de la tabla `sede`
--
ALTER TABLE `sede`
  ADD PRIMARY KEY (`SEDIdSedPK`);

--
-- Indices de la tabla `tipentsal`
--
ALTER TABLE `tipentsal`
  ADD PRIMARY KEY (`TESidTiEnSaPK`);

--
-- Indices de la tabla `tipequ`
--
ALTER TABLE `tipequ`
  ADD PRIMARY KEY (`TEidTiEqPK`);

--
-- Indices de la tabla `tipper`
--
ALTER TABLE `tipper`
  ADD PRIMARY KEY (`TPidTiPePK`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `ROLidRolPK` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `acceso`
--
ALTER TABLE `acceso`
  ADD CONSTRAINT `acceso_ibfk_1` FOREIGN KEY (`ACCidPerFK`) REFERENCES `persona` (`PERidPerPK`);

--
-- Filtros para la tabla `censed`
--
ALTER TABLE `censed`
  ADD CONSTRAINT `centro_sede_ibfk_1` FOREIGN KEY (`CSidCenFK`) REFERENCES `centros` (`CENidCenPK`),
  ADD CONSTRAINT `centro_sede_ibfk_2` FOREIGN KEY (`CSidSedFK`) REFERENCES `sede` (`SEDIdSedPK`);

--
-- Filtros para la tabla `centros`
--
ALTER TABLE `centros`
  ADD CONSTRAINT `centros_ibfk_1` FOREIGN KEY (`CENidCiuFK`) REFERENCES `ciudad` (`CIUidCiuPK`);

--
-- Filtros para la tabla `ciudad`
--
ALTER TABLE `ciudad`
  ADD CONSTRAINT `ciudad_ibfk_1` FOREIGN KEY (`CIUidDepFK`) REFERENCES `departamento` (`DEPidDepPK`);

--
-- Filtros para la tabla `entsal`
--
ALTER TABLE `entsal`
  ADD CONSTRAINT `entrada_salida_ibfk_1` FOREIGN KEY (`ESidTiEnSaFK`) REFERENCES `tipentsal` (`TESidTiEnSaPK`),
  ADD CONSTRAINT `entrada_salida_ibfk_2` FOREIGN KEY (`ESidPerFK`) REFERENCES `persona` (`PERidPerPK`);

--
-- Filtros para la tabla `entsalequ`
--
ALTER TABLE `entsalequ`
  ADD CONSTRAINT `entrada_salida_equipo_ibfk_1` FOREIGN KEY (`ESQidEnSaPK`) REFERENCES `entsal` (`ESidEntSalPK`),
  ADD CONSTRAINT `entrada_salida_equipo_ibfk_2` FOREIGN KEY (`ESQidEquFK`) REFERENCES `equipos` (`EQUidEquPK`);

--
-- Filtros para la tabla `equipos`
--
ALTER TABLE `equipos`
  ADD CONSTRAINT `equipos_ibfk_1` FOREIGN KEY (`EQUidMarPK`) REFERENCES `marequ` (`MEidMaEqPK`),
  ADD CONSTRAINT `equipos_ibfk_2` FOREIGN KEY (`EQUidTipFK`) REFERENCES `tipequ` (`TEidTiEqPK`);

--
-- Filtros para la tabla `perequ`
--
ALTER TABLE `perequ`
  ADD CONSTRAINT `persona_equipos_ibfk_1` FOREIGN KEY (`PEidEquFK`) REFERENCES `equipos` (`EQUidEquPK`),
  ADD CONSTRAINT `persona_equipos_ibfk_2` FOREIGN KEY (`PEidPerFK`) REFERENCES `persona` (`PERidPerPK`);

--
-- Filtros para la tabla `persona`
--
ALTER TABLE `persona`
  ADD CONSTRAINT `persona_ibfk_1` FOREIGN KEY (`PERidCenFK`) REFERENCES `centros` (`CENidCenPK`),
  ADD CONSTRAINT `persona_ibfk_2` FOREIGN KEY (`PERidDocFK`) REFERENCES `documento` (`DOCidDocPK`),
  ADD CONSTRAINT `persona_ibfk_3` FOREIGN KEY (`PERidFicFK`) REFERENCES `ficha` (`FICidFicPK`),
  ADD CONSTRAINT `persona_ibfk_4` FOREIGN KEY (`PERidGenFK`) REFERENCES `genero` (`GENidGenPK`),
  ADD CONSTRAINT `persona_ibfk_5` FOREIGN KEY (`PERidRhFK`) REFERENCES `rh` (`RHidRhPK`),
  ADD CONSTRAINT `persona_ibfk_6` FOREIGN KEY (`PERidRolFK`) REFERENCES `rol` (`ROLidRolPK`),
  ADD CONSTRAINT `persona_ibfk_7` FOREIGN KEY (`PERidTiPeFK`) REFERENCES `tipper` (`TPidTiPePK`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
