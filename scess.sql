-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-05-2017 a las 09:09:02
-- Versión del servidor: 10.1.16-MariaDB
-- Versión de PHP: 5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";



CREATE DATABASE IF NOT EXISTS `scess` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `scess`;

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
(2, 2, '827ccb0eea8a706c4c34a16891f84e7b', 'SI'),
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
(0, 1095702, 'ADSI115'),
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
  `PERidFicFK` int(10) UNSIGNED DEFAULT NULL,
  `PERfoto` blob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`PERidPerPK`, `PERidDocFK`, `PERnumDoc`, `PERnom1`, `PERnom2`, `PERape1`, `PERape2`, `PERidGenFK`, `PERdir`, `PERtelFij`, `PERcel`, `PERcor`, `PERidRhFK`, `PERidTiPeFK`, `PERidRolFK`, `PERidCenFK`, `PERidFicFK`, `PERfoto`) VALUES
(0, 1, 12345678, 'asdfgy', ' ', 'sdfsd', ' ', 1, ' ', 123456, 0, ' ', 1, 2, 2, 1, 1, ''),
(1, 3, 12345, 'ADMIN', 'ADMIN', 'ADMIN', 'ADMIN', 2, 'prueba', 0, 1111111, 'ADMIN@admin.com', 1, 1, 1, 1, 1, ''),
(2, 3, 54321, 'User', 'User', 'User', 'User', 2, 'prueba', 0, 1111111, 'user@admin.com', 1, 1, 3, 1, 1, ''),
(4, 3, 14609952, 'Alexander', '', 'Salinas', 'Lozano', 2, 'Cll 110 #284-18', 4223601, 2147483647, 'salinas.alexander@gmail.com', 1, 2, 1, 1, 1, ''),
(5, 3, 94539564, 'jonnathan', '', 'valencia', 'perlaza', 2, 'dig 70 No 23 A - 151', 6638621, 2147483647, 'ican.jonna@gmail.com', 1, 1, 3, 1, 1, ''),
(6, 3, 1012378485, 'Jancel', 'Hernan', 'Perez', 'Paternin', 2, 'calle 42', 0, 0, 'jhperez@admin.com', 1, 1, 1, 1, 1, ''),
(7, 3, 16941522, 'JULIO', 'EDUARDO', 'PABON', 'ERAZO', 2, 'DG 29A T27-27', 3343531, 2147483647, 'jepabon22@misena.edu.co', 1, 1, 1, 1, 1, ''),
(8, 3, 16378842, 'Cristhian', 'Andersson', 'Caicedo', 'Lopez', 2, 'Carrera 25 # 52 - 71', 0, 2147483647, 'cacaicedo24@misena.edu.co', 1, 1, 3, 1, 1, ''),
(9, 3, 1143941423, 'Luisa', 'Fernanda', 'Salazar', 'Solarte', 1, 'Cra 27 # 32 a 43', 3818339, 2147483647, 'lfsalazar32@misena.edu.co', 1, 1, 3, 1, 1, ''),
(10, 3, 1143858861, 'Gustavo', 'Adolfo', 'Risueño', 'Zuñiga', 2, 'Carrera 39 a 30 c 63', 3378388, 2147483647, 'gustavoriu@hotmail.com', 1, 1, 1, 1, 1, ''),
(11, 3, 14695164, 'Carlos', 'Andres', 'Morales', 'Hurtado', 2, 'Calle 35 15 34', 0, 2147483647, 'camorales461@misena.edu.co', 1, 1, 3, 1, 1, ''),
(13, 3, 25026430, 'maria', 'yeimi', 'jaramillo', 'ocampo', 1, 'cra 26q # 72t-25', 3976050, 2147483647, 'yeimijaramillo1@gmail.com', 1, 1, 1, 1, 1, ''),
(14, 3, 1080930332, 'William', 'Alexander', 'Gallardo', 'Barrera', 2, 'calle 69 No. 7bBis 12 Apto 211', 3767439, 2147483647, 'wagallardo@misena.edu.co', 4, 2, 3, 1, 1, ''),
(20, 3, 1087132591, 'sammy', 'roberto', 'ruiz', 'ruiacines', 2, 'calle41A #50-33', 3314332, 2147483647, 'samyconciente12@hotmail.com', 1, 1, 1, 1, 1, ''),
(21, 3, 2222222, '1hhh', ' ', 'hhhh', ' ', 2, ' ', 12345, 0, ' ', 2, 3, 3, 1, 1, ''),
(22, 3, 29309704, 'yackeline', ' ', 'espinosa', ' ', 1, ' ', 12345678, 0, ' ', 8, 1, 4, 1, 1, ''),
(23, 3, 21212121, 'WEWEWEW', 'EWEWEWE', 'WEWEWE', 'WEWEWEW', 1, 'TRTGFGF', 767676, 6767, 'KPPK', 6, 1, 1, 1, 1, ''),
(24, 3, 87878787, '76767676', '767676', '76767', '676767676', 1, ' ', 989898, 0, '989898', 3, 2, 2, 1, 1, 0x89504e470d0a1a0a0000000d49484452000000a0000000780802000000fac06e38000058f94944415478dabcbd679424d779a659fb6fcfceee9eb3ab59e9ec8cb4a3198e66e447120d44122480f6e5bd3759dea7f7be32b3bcf7de7b6fbaaabdb74083f08e044882de89162461dad6be37becc5bb72233ab1b3273f42874232a5be2d153ef77bf7b23322ac2de566f6da935377a80b1cea3f7b9755e17d0d738756e87c665513bcd6aa751e530a8ec3aa54d5b6dd1569935952675855105ca0dca527d6589ae828e459ab242756981aa04e42b8b15d54585d5c5a0a0aa08e4551512b89e5b599053919f559607b2cb1500838c929cec92dcace29cf4e26c91b4a22c3a661432320b185938e667a6e7a7c94853a47252f35264a4e4a4ee919d22914424672572e83429332155fa1806807e9498119f901e9794c948cc8a4bc88c4dc88ce6e04ae0a29fe02bfb7e8a7f951145604ca7f1e99174253e2d1ac4a5fa07807f189f894b3b01e8c3b1a9c769cca19f4638da1b20d8d2e4856053438da1ce152c98d90536bdd2aa03dc31692e3354c12e1d8bb5e5702c6a0e2918906052cb056796e61230fd58c1b01b5270b066d1f43ec112a939c9d049470e3f85e0e4ac64513006704c82039efecd040bc282110587fb0c136c6badb336fb00341bebddfa5aa7cee730781dba1a9bd66d951c1bb9603a8a394688cbf4d59460513039468e39082ee08ef70457e683ccf2bc8cb25cd20cc11c51b32838233f935190fe848efda673d3387ec7b9c940148c31219da6888279b2f727f8209d8f15cc1d8be3604858705245c1f8113e207e26c2d9d1882a6d6fadb34b9a29c4706cf439b963addbac7199340ea3da6e082b585755a2dd4b30772c0a26c7145f3a925a22ab4201c7c18245c7fb12cc1d074857641c405a5e3a213a6648c94ece4962480a658116ebb62098884bccd8278cc4d375203b7d12b8ce60eba2e0e0d452a0b9607f897677b53a3b9a1d6df50e49339b89ebdd706caa75c1b1de6387635d8d058eb54e8bc6610ee758d48c28539a01156a7156f697e86a464e5501e08201afd5cc6ba9802438b3881122c7a13858f39e6f2addb9c97ec739fb132c5d17abf77ec17ba06ef3d2fde484701c946999635901e7610d8e3b13ece9697775b6b8da9b9d6d4d108c2a6d6a70316a1d469f5defb1c2ae3fc79260c9b1893b06b21cfb1d4b146b2a28c762e795a72c22821d33a8db2acbe570c13ccde498f55985d9e1d21c4e73aa221dec732c4cd2fe722d8c395cbfd88b71b8e37f86e090b28305276646027e3d38c132c1fe047b7b3b6abadb201820c4a8d2e64637a3ce09c706af4d726c63b898e3408ee1d828e6785f82037681d873e5ab4b14aa6222ace320c17b8e4b7328d99463d8150587d32c4f70bedff19ee6305db73fbb418ec5ba2d8e43c6fab148bf130932c16c1ca4162465458982792517676e7917edebeb846077470b09b6b18eba8651ef826384188e3119a356ebdd7ec701bb06506dd15382fd1db5be9ae0a6a950c37148c1e4785fa12ecfcf2c536494e689a497e4020c324b248ae03827ab3027bb2857263858f30182fd9a05bba1234b5ef7073a50b169a1c51a31a9174bfa57172cf9f3dbe58245f099a4ac1810dc8483085f7f8fb7afbba6a7d3d5d58ec9d8ded6686baeb736d5591b3cb646afb58145d9e8b1e9dd169dcb2c61d73a6da263d9da8997eb32bdaa54a72cd65582226d45a1a6bc405d96af2a050a6509c8ab2ee6e45615e55416c22e5a6b80fe8bafa368adcc4188b34bb2b38ab3084a3387a6e7f4824cd2ccbd3e4923c6fb2fde8b498b2891e4fd0d7608648b693e67874b7972563c90d56dbac20a757acc9e72e934393b96bb24af04372debc323ea87fae19804633276b437d95a1bcc4d6c650ca0d95ce73679ed861a2b1c4b9a996054e960c1b2f918824189be0a3cd63109ceae28e06a8357c9a260ee389c60aade64f4093bed7f3bc1071470122c6ae66331d03ce2e1048b5744c7114da34375837d9ede2e261821ee6c43882dcdfe9531426ca9afa18e1a3906102c39de371373c1fb43cc04971aaa831d8b9ac9ae0899469a492d972d3ade63bf60ee980b269ea4179377d7243b804c7338c1b2e939a4e0906d5a70cb1686a0355840aa4c36653aa26962a46e648042eceeee80600a31156adae1622126c73eb6bdc5d8db0361fb5c4abbbedaa6abb26a41a545536156979b546546358060722cd66a00bba4198e492a8e3ccae49890a559e638ab3887236ace6693f45e0bc6c78f6db6e5eba8d08e539f5cb0ac4a87e3899bb503dbf2fd8efd821bc686f617ea3600c7d616e6d8dce033d57b8d751e436d0ddba90e0826c7a260724c8225c71a082e3656134586aa427d6581ae02e46bcb159a32224f5d9aa32cceae2ec23157554276c528539a45cde2949c5d924bdbd732cda260eab765990e161c52737a80909ac5a21d9c6c7e2538d062583f4d7c1fa7797fd1964af4c4288063df102bd408311ce3686f6bb6b536595b1acd4df5a6469fb1c17b80604082f73bd6c27189490948303926cd704c9a21185e39dcaebc5c07d22c8b3209963906245846c896fb318db7e0f849343f567048cd9fd6f1fe8f85d6ec17dc3a3dd13c39d6388e423dc80b351c3b3a5a6d92634b7383e4b8ce50efd3d7790d1e17a01d2ebe530d10e2a01c6b41a959c51d8b9ab9609e636657592cb3cbcbb558b4c5e62ba7340fc81cb3d34f2f980ff6f5de797ed273f7c94e95f75f7bb283053f21626d17932d7aa5655538c1fe895914dc3e3bd53235ee173cd45fd3df433331ebb6da5bac10dcd2488e8d0db5106cf2d518bd6e5a1907726c0624984fc6a26042e6582cd43420c162531d4c708e45c1fbf8e70a062105337025c063051fdc721f50d8e9a7e2bd0d5ec9719a98817152b0f87dcd9728b86b76ba637a1255ba7e74a87678c03bd8e7eeeb72f67438badbed5dcc31049b60b7b10e829163bf600fbb9f48b714b52ebbc66953d92da0ca6e06957643854d5f6ed59559b465663d2835e94a8cda22bdb650a7c1b1d8a02bd2ab41a1beba405795af45a02bfdb285ee5a34ed3f957645c45b14e27299d4e696e4010806390279850cf14a766136274bbac11c0cdd942444c1e9fbfb2f5eb7832f86fc58b89e3cb8983f762516d01f623d0d227ae667e198420cc708b167a0d7d5cb1c936084d8dcdc6092aa3430d77ae0d85fa805c1d50e0b210a668e05c1c5060d79a541a14e4582c52959b64ae6e5da3f9604f385326d8970c19466129c539c0b720514458c7f45c1dcb16c7a7e721ebbe83aa0d996adb3c30aee5f5a80635ea805c79d0831cdc408b159aad28c5a9fc9e7357a3d064f8de858e9b402bf609ba9c26a04e51603418ee195c3ec4a8225c715dcb1283878b78b6e328af835972900179c57aa20cd7938eed79cb33fd68fd52c0a0ee938640b164cb88f85abd2074459263870258ce081e5e5bec5c58ed9d9b6e969745b0d63c38142ddedece994cdc4c0545f6bacf3196abd7a9f07e8bc355a8f5353e350bbed2a970d8e45c15c330f318797682ed8ef58121cac5951c5e04f83d01d6546793e20c104ec72c132bb21057f5acdc18ec3f97e12d272539e7caae63d7948c121174e11832b2bfd4b4b5df3f3ed33332d93938d6363e8b62018dd162bd4926084d82a2d9998e3c67a73431d3926cd5a8f5b53e38260208698c31d93665eae59a1362881b870a27d2ebed5b5a759124cb793f32bf75054149063ae799fe0408e394f92e3909a65519699a6d3034486cb3d048b8e0f803e29cb37ffb508772f32627875637079ad7b61a1736e8e85786242e8b6bafd7b5b1dadd08c95b155e8a8b16a22c15288c9b193421cce318f324f73b15125131cacb940c9c8af2e01f46c974c3001c18a320609a6313f655724c2a5395870b0e6708ec5f16305077d2cf5c91d07679d673aace0d1f52d38ee5b5eed5e5882e3d6a9a9a6f1f1fa91119a89fd7799a4559323e09896c5e4180b27720cc101c70e5ea881ac628be59a853820986f7211b49d290a26c7f4fc1ea92da86090e3fc724648c12279fb05cb343f5670b8293938d08f45141cecf800dff423597cf91c1c7ceb22627c731b8e0756d77b97569063146a8498176abeb725dd4c6c85630a3109a695b1aed6a3f5ed09061462f21a4eb0bfdb9204f31d2eae59bcf544768b244870616511d9e51c209827d85fba83043f36caffd3048b84bcc89145990b4ec94e20b8e688b1339706b6cef4ad6ff7ae9dec5e5aee985f40881b46d9b2188e6b07fabc7d3dd47039babaec9d9db6ce364b7b8ba9b5c9c8d6c70dc6c67ae4188e03859a755bb470523bac5819573b6c55766ba5cd5261358b8e4b4c6a00c192e3bd5dcc124365b1bea248575ea82da32705e869902225a3b89a5154550ca0598628db3f28cb979117aaf30a3743c36eb8162c9cfb70c59cff887eca7f2d487030198a34722c5ec469666e2ac8c84901e9d9c99cb4aca4d4cc44222d3b01a4c237123c75e1daf0cef981cd5370dcb3bcd2b5c80a35ebb6a42553fdd080afbf1782d17039bab1326e0f279885d8cb040308e68ec3092e356bf63bf6e7980b062105935d2e58342d063aa460ccc179416ba7bc27584d3db9e00308291822c3116c9d048b76e115f0814c308858b8f6fcf8d9cb4327cff46fec90607f473d35d63431d23832c8ee160ff4528849b0b5a3d5dcd66c648be34612cc0b35755b7cf70382d50ebbca6eabb65a4095c5082acd06506ed431a43b4ea5061528d12b19926072cc1ff7816312cced0613ec98041740b6040926c4be3ab8f90a361d4e70f0249dadc8e4e4e46771c453f133597969e1a0b08ac06bc8f8ca424c828988b5e75f9dbe787374e7c2d0d6d9be958deec55508c6b2986e4234b110f77b077b6bfa11e24e697bab1d8229c4108c101b1aeaf4f5fec998176a8620586933575b4d803bae30e90169deef78efce317b664f5d4e14abca300717579716559510189728cbc2156d7fa1962884f2fd8283c9dbbf9a0a59ae45a9e126e99076c309c6382b2f231c99b9e9a14815abb4685a26383d271144ecbcfc8dc56b2f4d9dbb3e76eaf2f0e6e9fed593e8b63ae716da67a7e0b8659c85b876181d750fad8ceddd5db6ae4e0a31156a16e206ffbd26124c39d6ba9c1aa783b6a9b960d1316966820d5a50aad700b2eb47105c22398654724c76b9e060cdfe284b7689825053b258bd65a69f7c29253a9679fd97080ea959966c59b9e682c92e137ce51b3fdebcf3f5b94b2f4c9ebd31b67d7e70fd543f72bc00c77328d46d93e3cd63fe1b4d6cd5d4df03c1cc714787b5bd9d0ab57f26aeabd5d7fa68c9449a69c9c4bb2d380eceb1e8980be68ff8d083b74489e498a4eea794101d93e682805a2ef80064a683276699e970a53b9c6099ecc70a965c86741cda6e58c16ffcd3fd4b6fff78f5c61b33e7ef4cec5c1ede3837b8baddbbb8d1b3b88c1c774c4fb74e4ca0a9ae1b1ef60e0c78fafb1d3ddd8085b8b3c3d2d6666a69a1426dacaf638ef7156ab66a920926c782605385c9586e349419f4a57a1d20bbfe27b9a487abe9f1db524d0528535794aaca09125caa923bde1765496d117ab1c0b840a8dbe269b8287faaadecc7debda0eb62db15ae230bb9f9c55ab3a0595914ec273001b326eb07f777bff6838f76bef6adc52baf4d9fb93176f2f2c8c66938a6ad8faed9d936dabf1c1ef60d0e42b0b3b707821162126c6e6db5b4b0c9f8d30b36c36e48c1f4181723f07035fbc2444030210a0ee9d8af59f24a828970821f3b377fda2db0908e3fad60d90e28c6c15d18e578cf6e40b0bf8bbebbbbfbf3dfddbdf5ed5f6d3cff8df18b2f0f9e7e7e64ebcce0facee01adbde6a5b5a6f9a5bae9b9af34dcc340ef7350cf57a06075c7dbd7cc9842a4d09e64f04502fcd5b2d2ad4d2f6969d964cdc316fb5e8e11e6ab5e86b4e15fa6a4eb9ae0a54eaaa2bb45515daca72a6b91c944b906050268dc9b158a8e5cbaa8a6250585ec429282b04e298935f5a10ae6ed3cd4782ee3413072fb10eb8931166c5952e5b3505f7d8193969202d2b8548cf4e0518a466260326f8f70f76bffeab8757bffee3c5db5f87e389531747b6ce0e6f6cc171c7ca66cbc26ac3cc42ede42cba2d74d424d8dedd610b2358d64b73c1b0abb4c1ae954fc34cb0f4d407418e4970a584a8f9c9058b8ef95a796f2c946b717a0e39553f76627e72c14f72cf8a5f0f2998082538c4aa89a79909beb7bbfbb307bb6ffef877a75f7b7fe1daabd4518f9e3c3bb471aa676dbb6369a3657eb1617ab66974b86178d03b34e8eeef93096608cf6d0576a71dd22d262638b0580a2db8d2a2037ed3d28b03aa8caaca80663f3a72cc0493e39082658e45c1fe400b828b42f97e92e62b648ec9f4c182432eb782050b390e2d38e4123978650c2260f7feeeeeef76777ff8dbfbb7bffdf3ad17de9945477deee6c8a90b8327cff6ae6f77ad6cb62f2c37cfcc378d8fa3dbf20d0fd50ca0d5ea648ea55d2d9a83c53b10865a5a2f39a56d4bb658e2abe1bdf592cd5065d503a8adb6e8abcc3a5069f27f37a22a40b060eeb842a23c609a28836989124cc355c53244a3e2c45c7860bf1dbc11164e7070a099f2826c19e1ba6bd94fa54e3b9d47166310ac769fe09cbd5d0e7f17fd70771720c71f3edcfde6afefdef8faf7966fbe317df1c5a13357fb772eb1edadd52d74d41db3f3cd93b30d635375a323a8d2cede2e87b4b18505b1b5b5198e836f238a82835b2d95c3a4b4ef7d834d72ec7f2d04a836a9abf66baed2332a7555dc7148c19c52e438e018038e4cb0ccfac18e833baffc623fdc2e8d49ed5eac9fcc31ff115f348b82c97108bb79c980748a7b58e43862f711334c9a7ff970f79d1fffeae4abefcf5c7d75e4fced81d3d7873777fa5737fb97967ae6e79b67161ba7e6ebc74651a55d7ddd4e69771a21b6b5b530c7fb05f3273d68cf920be608df7c3104bffaa33a00775c6d6054b1c9b88a34570608368d5384981c030c38629483937d80669963a2a044c11d935a5176c840cb7c1f2098122c3a0e569b919b4404a4c6c988f0bb7dc4fefb234cc61f3eb8f69ddfacbef8cdb1cbaf0c9d7f71ece4e9c1b5adc19595bec5c596b995a699a586f1315469777f8f933d98c76e2ed9db5b9963e93e31f559e2a33ca26082be45ce054be8c5b70600a544b5605a69544b8e95dc715500722cdae5ca4933afdb54ba65c90eaedec1043ba67161693e1c8b9a69ccd32c06fa60c7b2d3c066483a77ccf7a2f7ca72c0ae2458ae36352b1a40f0c3dd478f761f3dd87d78ff6374d48f765ff9f5eee9afff6ce2faebc3975e9ad8413bbd3dbcb23cb0b8d03abfde3cbbda38315e3b325c33d0eb0adc7e8060104e30d9151dcbbe450ed47683f86608a00c38e69a215872cc04fb7932c18450ba8b414975914871152a7601a7b0225f20b460ff62bad4ef582658166bee389c573ea0cf70c139f919802a33cdb2fbfae7805da938fbbda6e7c4a765c700bf600a30ecee3eb827997ef4e3fbbb6ffce4c3ad377f3c71edadc90b3706b72ff4afadf6ae2c37cdcf352fccb3677a4646bcd22d2676abb8bb931ee8b1b536589aeb4cf5d2375ca4f7f400add72e3e3e4d04be9f68d3c0b7dd24210996dec3a5b130d4668d04065a8d89a1366a54063550ea55a05aa72444cdb2a21dd27185b24ca4bcba9410d32c06baa4ac10149515149717121833a9e24d2a019e690e2fdd62f53ea005dbaf395d360df310b3cd0da92c67e62465e5266764c783f4ec18222d2b9a1004dfbf4b85fa57bbbbdfff70f7ccdb3f9dbdfef6d8d9ab433b1761776873a36d71b17561a179923dec4137106b7aba9c9dedf4d8a5b5a5dedc546b6cf0eaeb9860722c0ae68e45c194632e18682c7ec86eb060727cb0609963914a1543744c7333efc2648ec9a80c517041e04912c2ffd3fd76657373c85a1d66bf3a9dcfbefcf6d1de7d24a9b10a84389e1152f003f45928d18f1e3c7af800232c993ed8dd7df567774fbdfa9df92b2f8eec5ce95bdfe8595d6b5f9c6f989a689a1825c12ef6340fe2db1678e69209def755447adf96f0883c39d6ed734cf3f15e95e682b9632e386488abf64fc6c18265a649b0a899f22d6a1657562515a11d875b4a8982c539f8b1f10d2758740ce8b63f09e64d96643a9e900ab5bf3e4b25fad1ee03965b569c916558c64c0cbefff1eeb577bebf72f3d5c1ad8bc3db673b16d77a9697da66679ac746ea8706509c115f777787437a504b7a18af9e7d6dbca9ced2c83403d26cf4baf9575dc8b15e422698bf844b6b65888e45c132c74cb3be9a08675ad66957a92b802cd95c70709acbaa4a4a2b8b797d06a43c5ca7cd676551302fd1b229395c8e79171ddc3c93e0544cbaf08ad591e4585a1185118c65d2c3fb0fd962490282f9d6c79bdfffc5cacdd707b72e772e6fd64dcc358e8d358d8f378e0cd50df693e09aee0e57679bb3a315d0774dfdeff790345394e9ab2e01c76e86cbc5f03bb670c8b1d66ae4682c06c67ec1b25abd6f4a164c43aaa0bca2525b0e2a3465b27007ef9070cd500b303de308a93244e5fb321d340153e715ac3ca4e38057768b3023270d5dd5de9356d2a339309a2645165e91e02c454a608d142708460b1d0bbb299951112cbc0f1f3c9014fb974c926a84f89f7e7f6fedf69bc3db573da3f3f6fe494b4b8ba7b7b77178a06ea0d7d7d7edededf2f474ba035f18a71cdb5b02af0668f4976b4b9d5772ecffb60b041bdc6e2e98722c0ad6d94c4014ac35c3b15e14ec776c543104cdb24c4b540208e68e45e09b53ae2e0595aad20a650928af2ee69455c168814871793e1f708aca14a0a024171496e6011acb4ef38b51ae731445d920af50be3a12effe4ab710d82dde948c04408ea92cd3ec4b5b1c19b992ddac38eab358ab95c54ed332635333622258657ef0e0c1236ab548ee7df0f1a3dd0f1f3c3afdeab707362fd74eac380767dd9d1d0d8303105c3fd807c7a0b6bf079a9163e0ee6873b5b73a5ae1b849746cadf7498ed9379aa4af33d540b0dfb1cb15988f69edc4de96a8b35a08adc54c8e2158721c94e3806011e6d8a024648245823557a91910cc1d73d3105c5a59c81105cb1c037209d38f150cbba260206637605a7e2f010d33dae68cec44421aef49a57166561cc8c88c4d6782a50552a09796043fbcbb7bff63baf2e20f3ee8593ddfb17c1a829b060741f3e8101c370cf5039826c78cee4e4f17d3ec6c6b71b43622cae4d85a5f67a9abddf79535493039e68225c74cb0de667d42c16a939a1154b7497cc0f19e60996c599a49f0018e39e4581668598e69104e308fafc45e89a6facc0503d92e0704c328094ecf4a20c759d9f15901a9e2d82ff8c3dddd8f7677ef3db887f91751debd7f9f89bdff88aeff62777764fb62fbc26ac3e45cd7cc7cc3d068ebf848dbc468fb248ec32d63834d23cc342bdafdfd28e0eeee6e4747877f6fabadc1d25a6f6ba8e78e45cdbcd50a54697fa1d6dbcd406743ad3650c3a5b330b4661d41a61966e65865d2ec214499fd689f697f9a95da8a90546bcab95dee186af9c6487155a1486145be6c6fa4a05c0148704824c70ad9de96b8074209166f2df0268bdf01ccc949cece4e22b2b21239d939096497438e233ede7d7477979c3e7a70f73eefb63007fff293fbbfd9ddbdfd8d6f4f9db9dc3ebbd239b7d136bdda313901daa747dba6465a27879bc7071b47fbeb872198f63dba9d9db4767a8c6003d6c77b8ead1c83833b363d46b0842858cc31172c39ae22bb40a5631ce0588c329f8c65555a166231bb549f655e39b23e8bba6b1edfc034cc8c063fb641253a33332123231ea4a7c721a01cb82464398e78b0fbf093fb10cb3ae74f1eb22375d177771ffcf277bf619b97bbbb2fbfff93cd6b2ff6ae5ee95cbcd0333fdf353bdb393309a0198e9bc6061a46fa6a07fae0d8d3db8dc5b1ff4ba792607b630377ecd7ecf59a3c1e08161c87164cdd964c70b0e3900d36157012acd65701522b122c58742cd66a5995160bb56c0e2e467dde4f1194c32e0a3528561414e5eda34401cdfb37b03244c1f29592a48dd2191249702cc8cc8a01116c8be3c13d84185dd5475259fef011cbf427f73ebcfff093476c17e401964cdffaa7df2f5c7da76ffde6c0ea66cfe26ae7dc5c87a4b96d72cc1fe2a1fe5a69f3922f9fec6d8d581c3b9a1a45c732c1e4d8e8b2199c563f0e0b3926c10c8bfe533926cd24586b546b0c2a8da19a1c076b7e6c82659ac5d63ae4645c529e5f5a51004aa471494039172c038ef30b731505399cdcfc8c1c453a8131b177252f29273711a0268bd01552cb0567644647dcfdfd07e8997f7fffc1af3ffaf8b7d21ed647d2ed6129c6988fefdfffe4a38fa58b2fbcfffbc5cb6f8d6c9eef5bdee99a5fee9c5bea989b6e9b996c468827861ab07c42cfd5d7ebede9a6e513bd504d14eccfb18f3926bb26b7d3e8da27d818e4586f6584d42c332d3a865a0e0413213587134c8eab0254423634571773ca1165946b49271f88888229c74525f9406697a24c9af3f2b3f30a321568be0a3239a2e33c453280666e9aa08b5c33d94dcf888af8fa5b6f308b08eefd7b68ac3edcf5576924fbe1bd4f761f3edabd779f0af8cf3ed9bdf5d677a74fdf1e5ebfdcbdb8d1391ff856f1cc44ebf478d3a8e4b8bfcfd7db03c7355d9dce8e56ac8c9dcd4d700cc17b855a126cae71c12e0936b96c1c63c0312fd401c14689c74cc9925a422da03cc0717095e630cd01b5a25da8e582092ebbac2c5fa4b454014a4af268505a5a5052920f8a8b154545790052619764b3f82a98dafca2ecb082f352416e6eca1e01d9629fc5cb78c4f973677ff0fdef3d64f719a4f52f5b17efde7fc09e017878f7116d7d3c083cf5f1c35ffe72e5dadb93a75f1c583ddbb3b8d3b3b4d639bfdc3e3b851cb78c8fb24d2e4930f07477d57474385b5b493085d8565767addd13cc1d8714cc1d1b6c8c60cdc18e75266dc0ae46676270c14fe25866970b0ee958148c01a0c806442ab8ddfd14888e4161612e99c6a0a020273f3fbba020abb0303b3f3f5344a1c8007979e97c20c14c93726aaad18289a0178bd8dadebaf5fcaddf7df801e6dafbf73f6259a53dcb7bcc2a84dfff64f7c1c347d2731f77c1ce8bdf5bb8f4d6f0d6d5de95f3bdcbeb100cbbd2975c48f080af178efbbc3dbd9ece4e575b9b4c3020c1168f1b822d6e97d9e534bbed1c93d36174d8c309161c1b831deb04c7c18245cdc182651d162fd12a5519a1549682eaea12a2b2b2a8a2a2b0bcbc00478c01c65c6d3008b194e3029963522b02c1c188a60376d37373d338b47c9239668257b6d677ce9ff9c637bf79efe14366919649fe2dad10fce2e1eed93b6fcc9f7b7d64fd76cfcae9f6f9adce85d98ef9998ea9d9d6f1a9e691de86c1aeba81665f5f634dfb80bbad1f8e1d2d2db6e6466b5303156a7f8e6b3d665f0d345bbd35d61a37d3ec72c2b71865d26cb01981de6a60d8f4223aab4e6f16d17274269508b36baa0221046b2b805a57a90e8c394a4d397925c1dcae28bbaaaa9820e504648b84493383e2cb434c390681d36cd1ae4cf07ecd29709c93959495919099119b911e03308858de5c5bdfd9baf5c2ed9ffefc6724f1de7d96d77082d1887de7d71f6fdf7a6fe5d21bbdab67e0b86779a97d6e1682db26a65b46061a077beb07da6afb5a3c1d834c7060fff2f18229c1ff0682fdf11504fbd157710e102c8698db157d93e67f9e602ad47c4ae6390e14edac27109ce2b78b1067268a8241c4e2e6eadaa9ad5317cebef2d6ebbffbe8a387d2047c80605a4abdf5c30f776ebe3d7de646ffca99fed5cdf6d9c5ae99c5f6c9b9d6f1a1a691fec6a1eebafe0e4fd780bba38f362fa50dea7d33b1b5ce0bc1cc2ef0ec55e9e0c9d8683701bfe060cd416ac30a164ab43688d07635e5a456ad2ee7555a249ce360c1e11cf3c938d8eea7129c9bcde29b9d159f9519b74ff0fce6d2c6b99327cf9fbe70e3ca7bdffdf687f73fa1424d428305df95baaddf3cdcbdf9fafbebd75e19dfbadcb772b277790baba6f69985f6c9b196b1e1a691c1fa414cc3fdeece1e7e13624f70bd0f4030426cf5ba189260480d126c36384c249872bc17e5806683450782ec6ac209e646c5f8ca12acd1f8815711ee38784a7e12c1211dcb666214e7e0f938bc60d65ee5e530bb32c1e4383d2d3a627a7d6171676debc2cecee53337eedcfefe4f7ff440988283053f90c0caf8271fdc3dffe27bab175fea5d3a33b07abe7b61a56376b17d8a755bcd23a30d834368b56ababa6b3adb79881d4df5f6c63a7b436d48c181045b08d8f5b35ff03ec75603099639a60e8b6b0e29983b26b504572b134c6399607102e6d3306fbea8ffa271c8b55348c182da1c89104d1677acc84d057ec1398939d909b0cb130cbb69a95111931b73e36b332b6736b7af9c3d7bf5e24b6fbdf6ab0f3e384030cf31baecb77ff0fb93575f9f3a75a777f1222d99e84d5bcda3530d43e3befe1e4f6f97a7ab038e4309aeb1d4bab9604b8d0376710c166c72f81d87cc71b060c1aeac9766e8a1dca8d4054cf304eb74555a6da5885fb3aa5cabae0018a89565aaea5240036555497565b10c712616d37c8060d9ca38a4e03dcd796980d41e2c3823e5445ad2b108d81d5d999adb5ade40882f9dbb78ebdadbdf7cef97bffb6d58c128df0fd972f9eeee835f3fdcbdfdd68fd6afbd3bb872835effd0313bdf3239dd3236db383c5537d4e3edeff476774230fb9b3dad8de104dbbcae8305073be6828d56bdccf1c182c9aee858af67407068c7a10413104c8e6940631e625a3e3d36c45cb018655a10d39a5826b840912e0a86dd60c1391931596951e9c9c753138f460c2e4d8cadcf22c7b3db4b9be7b7a950bffb9d6f85157cff8124f8de83ddfbbfdfddfde987bb5b37df9f3bfb46efda66d7f25ae7dc42ebd44ccbe85cd3f04cfd706fed6037dd2726c1cee60651b0d9e712055b6a6ce0d30bd61a2c1ae2490407b75724981c93572efb00c13cc432c4422dca0e5e19cbba68beefc1ed060b66040bce4d825d129c931127e1179c9270246278617474697c6a65666e6361697b150dd7f96b57afdf79e13b3ffa213d467bcfff14c0ee03387dc42a336bc376e9d1bc078f1ede7beb07bb6b17bf3b7cf65ac7dae9ce996dc6c44cebc844e3683f425cdfd353d7ddedebecac696b73b534b34d8ffa7a40d3b0bdb6c6e6731316ccc4d0ecb21266a705905deed81cc064331246b35e4267306909a351030c06350d4470516fd4009d41add5abf47eaa45645186571178e5c8724cf0d3aa8a2250595e4854941510e5a5f944598942a2a0b438bfa448515c98078a0a7289c038bb301f52115c14e70ca0506481fcbc2c456ea622373d2f270de466a7b2d5517a7cbe222539e938355971b18712e221787678747e7462696a7a75766e637179676dfbe2d9f337aebcf2d69b3fffe0375812b3e76a1f3ee21b20ec4e22172cf5633ff968f7a56ffe7af2dcabfd1bb77a97b6bbe6373b26e640ebc428a6e1badededa9e9edaae2e4f7b3b0976343400eaa521983b3e5830c5977b656a597c0d9f46b0ca6050422dd9053a9d5282197d12c1a25d5970c309e61c2058e678bf692678bf636ed72f98b7d0108c1ca7a644c22edaabc484a3f171872306a60686668646e7c7e1786a6576767d61656773ebfce98b37aebff9debbbff9ddef48f00369e5c41e9d668f06f89fdb62717ec06e18ffd3ddfb3b2ffc6c62fbad81b5edfed593ddb34b1d53f3ed5353f543430dfdfd708c107b3b3adcad2dcee6266763230946826d3e8f849bb75aa260d1aedc2b2720983b36051c070b961cab598ef7e2ab0a8eaf5ecbd0692ac1130a0ee95b141c3ec47ec1e4981352b0e49804a70bf1f50bce488bcb4e8fcd4c8dce4a8b494d3c8e0e2bf2e81723fa26fafa27fb876646e0787c717272799a72bc73f1ec95e76f7ce37dac8cef4985fa61607d0ccb0f58761f48f7981eb28efa1374d43fda5dbffcadfef573839b177a9756d06ab54dccb68ecf340e0cd4f7f59160a94ab790607b2dea33136cf5d6d8c4467a7f7c7959967b65fd33da2b7d48c1611cef09e69aa58112f81d6bab38070b16bbad909d97bcbb160a7538c1a2635eab0bf37344c7a4960b4671f6af8033139160d805192951c9f147d3128f7ef1737f1ed137dedb3fd137383d3c3237468ea757e7d8eec799edd397cfa3e1fade4f7e48cf78d0fad87f3b91044b0fecd1caf837e8a8dffcfed4999787366e752e2f36cf4e778c2fb68dce370d0e22c49889310da34abb5b5b5d4d4dac4ad7d5d96b6bed5e8fcd5303ac356eab1bf1b5935ab22b4eb7c16a658279893e583055effd30c146bdd2a0930ba6de2aa4e060cda4565d199aeab242a2aab4005496e413705c5a9cf738c139058a6c225830ecb2fa9c11cb7639d2b03a8aca40ff9c702435eef05ffc973f8ae819e9ed1ded1b98181c9e1e21c708f1ecfafce2c995ad0b3ba72e9dbbf3facb3ffdd52fefb28accdcd283008fa4fb8bbb94de07fe1cfff017bf39fbf24fc64ebed4b9b8d1b1b0de33b5d23234d3323cda3830d48099b8ab4baad27ec1cefa7ae6d8eb61c0b12498e1b4581c668b6457542b4a15d51a4c3a09ed130a0e2ed1f00a3eade060b584a6aa54a6165780b2bc0870c75cb064778f92a25c710e96d945712ec849077ebbd216b4ff2652462cba6894682e3831ea99cffcf1ff15d13ddc03c77d63fd839343c8f1f0ece8d8c2049aea99b579146ae4f8fcf5cb2fbff5e64f7ef54bff8300d26a4978427e97d27c4f6abedefae9838d1b5f47887b96aef44f2f758c4cb78e8c350d0e37f4f4d775f5fa43dcdc8c2acd05db24bbc0ee72d99cce60bba453bca910902aa2953559a11cab4c26354fb0a496d8130ca96497c610ac539673b4d5651cd2160e512dc0e7c3090eb45a8a8305d3d42b13cced3232e390e0ecf468ac8e32128fa5c41e8a3bf2a5bffcd33f8ce81aea0670dc3f3e80c978707a1039960af52c34af6c6f9cb972010b27345c1f3d64cf6a3d62df4f438a3fbeb7fb11fb36139b9f3f41adbe2b3d6efba37bbb57defaeeecd9f7fa96bed63739d33f35db363ade3c34d2d83b2008c634dc04bb369f2f509c5d0076ad0e8745a8cca25dbad71b4aad5f30ad7ff4019dc139865d09a1cdd6abff8582f929ff4cb06cfa000926c76295e682c9b124380770c13cbbd43c87130cbb19e96cf98bde2a3de16842e457a39f7beaeffedb1f47740d76f40c77f58e74f78f31c7c8f1d0d4f0c8cce8d4d2f4cccaecc2c6d2daa98d9d8ba7afbe70fd5b3f7c1f73aff424defd87bb0fef3df0cfc40fe9b1dbdd0f1f3efa2d72fcabdfed6e5ffbcec4dad7da164e354e6fb64d8c368d0ca2d5c262a9a6b5c3ddc2043b1a1a1d3e2fe21be89c9d66a7c3647702a3c54418cc46a0371948a1dea8e5180d02a11be60350d1a4cb7b2b12ccbdf2536ab20cea6abdaa8ad0292b81b6ba02f08be24fa51f958909e6bf01945dde48cb3a6a0ca80b83663806e89fc5169a16c1fea5706e7a7e761a232b559199929b919c93ced648c0df3fc71f893df6e5235ff8eb2fffcd67223afadb3a07dabb873a99e6b11ef45c988fa1797c7e6272716a76757e696b65e3ccd6992be75e79e7b59f7df073f6acc7837bfedb4dd25a89d98569e971db7becd9aeddb77e707f6ee7a581f55b8d13a75bc7461b87d0670dd6f5f6fb3aba3d6d9d9ea616476d3d09b6d538a5c6ca064c0ebbd16ee36a99dd404116ed02835ec3f9b48245bbc182652d340bf47ebb5c303f152f02b14413aa8a62b13883708e01afd55288b343ad83c30ac6320913704ac2b1e498e748f0df7fe6ff8d68ef6b8563e4981cf78df6603ea69e6b6c6e7c72711a8e17379791e38b372fbffeee9b77efddffe4ee3dfab6e90326948d1eddbf8f861a437ab2fa37bbbb975f7e7762fbedd6c9ebed13d38d43a3f57d034cb054a26b9ad81ac9512bad8edc36695104bb56a3ddc29ece21bbe2a41b46ad1f794bfc58f6ec525916e16a697b1284b4cb05f353e1fabe620ed910cc5b68ee58d4cc574d80ec4273a0503fa9e0ac8c84f4d458c437298ec5171cfefc5fffd91ffd9f116dbd2d708c108b8e51ae1162381e9d1d43ad86e3f9f5c5cdb327af3c7fed5bdffade279fb067b4eededda5724d4f56d3420acbe587d213013ff8f5ef57cfff6860eeb5aee995c6a1e9ba9e615fd7a0b703cba4969aa63a479dc7e175da6aec7c43833699f5fb5baae0eca226ffb3a486581405dbe5f36e402d235c5245eb04fd2a18d59506fc4365b95ed24c6916432c9b832bca8aca4b0b010d68a584a3d86789d3f0010926c189b1874f3cf785e8235f7ceeb37ff99fffe07f8b68e96e68ed69a41c73cdd294dc3f24cdc7c831cdc7cb27573119df7cfececf7ef12bb69fc51ebcbc270996dc4afb1e0f1e6149ccded6f3f1eeee8b6f3f98dd78a77b7abb6968b9b667ccd73dea6d6bc31aa9a6d1ebaaafb17bb028b2591d368bdd1a68a9f4d21da17dddb27cde0dda5bfeb490da70820dea4a496a39d93d58b0cc315d21bb5a146accc1125c709846ba105495e23a825e5c515c505e940f4a0bf240497e2e2856e414e56513e10467a425a4a5c4a5249c888f3e7cf4ab9f8f3afca5a7fff6cffee23ffedf7ec16dbd4ded7dcda2e39e61e4b87f10b57a6a98e6e3b9b5f9b553eb17af5c7af9b5577ef99bdf3e9436b6ee3f78b8f72400feeb217b0fc43d6981fccb8f76cf5d7faf6fe652d3c096af7b92d1de0ec1ee861a47add3eeb6d95c5666d7660934cc3a2e58ec90fd828366539381814ef89f47608de4c7a45519354ab1a562b6d4d532c15c73c8eb4c337bc95385f4ae45f6765c8eaaa29450969740248c02524b76e947b8428ecb0a15806b8663d2bc4fb0f487e9b9e094a498e4f8e3b191cf1d7be60b10fcf9fffeff7df96ffe6b446b577d5b77437b4f630773bc9763403986e3d199d171e478716a617d61e7ecc933174ebdf5f5b77ffff1870fa47e3af06a00e91b118f1e4230bb21f19085f8bd1ffd747cfdb596914b9e8e4977db784d4b0bdbe2805daf1d76d99e86d566b658fd6d33ddd60db3c6fd57541b5230ec9260ee98c6e14486b4aea5d7a65655486f6a2be7037a852ad7cc1d93e003122cb32b08ce60f805a7e6a4a74070627c6442cc91c8a35f893cf4c5e8235ffedb3ffda3b8679f8a68eea805a4b9a5bba9b5a799cfca2478607c00211e41cf353b36bd34bdb03eb3717ae5f2cd2bdffafeb7a57bff6cfe951cff96bdf741f2fdc9276c7dfc11fb9ff796cf7dbb6bf2664dfbb4ad7194dd63609b1b768bdb6277daad76abc5ea305bec070b96ad6869fdfa2f47965d0e79e50497e2e0b22cac91f604031ac32e4fb3bab22c38c490caa1e0025e9c496d616e1641abe160c199e9897131c7e2a20e1d3bf4a598a34f03d4e7ac98c3114ded3e00c72d9d754d9d75a8d824985a6b146ad03bd20bd3d00cc733cb338b1b8b6bdbeb37eedcfce9cf7f76efe17dbaa5283d6ffbc0ff4c00fb329bb48cba77f79d1f3cec1a3f5bdf3ee5ac1bb4b96b1d9e7aa7db6e7358ac7693956d68b0a997361d4d461d83f61a0d1a11b3517e0586cc3a060b9f5e1d32d3240fe06316bd863ecf0722ec331a3f26b552c4a0ac0a8951554dd0295c1206093dec06d0055e822c2598a12c2fe55495165796b0375873a83ed3914fc37c260eec6731c70accc159a928d1d96989692931f1b1479f7de673c78e7e2929fad9a73fff97a8cfb9f1c7221a5a3da0b1cd4ba65b98637f8e25c75da07ba81b8e1165e4986af5e2fad2c6a9cddb779efff56f7fb3ff5e93fc39909ffd7e7774e17a43c7b4a376c0e9ae73b86aed4e2b805d8bcd68b61a4c16ff96322c72643ae5be05374f2898f3e482b942516438c15cb3ccae3e50a21162466539775c5d861c97d0008eb966f21ad22ea08e1a5186e382ec3490979902c1a9c9d1278e7df5c4912f451fff4a42e457bff4d93f3ff4b9bf4a3bf14c447d4b8de89845b9a3a1adaba9b9ab119a29ca1dfd9892bbc831720ca6176716d6163777365e7aed6bbffae003f6e571e9eb2d68b9a8eb7a70efd1fdbb0fe939eab5d3afb5f7ced5d40fd4781bed4e1f2a33eab3c506c126b3d568b218cc2616df03bc7285d02333c40573a9dc194714192c587aafde3ebba23c99e6e0ebf27087152cbdc61c03c93179457c4933e5981c4bef9ddf6bb2648e45c18539e9108c0467a562023efedc334fc5463e1317f56cdcf1a79ffabb3f3bfad4df463dfdd988ba66371c8b9aa95c37b7d7b77636b67737032ada708c72dd37da87b60b51c67cbcbab9b2b6b57ae5fad5effdf0fb1ffcf6771f7f729776aa036d17dbe4fad547bb2bdb77ba7a677df5fd3e5fa3cbe573d86d4e879dec8a82ad062de02e45bb9ce0f0d13c2a93cac79853b960bf481e59e90a1152300933a9aa39214d73d9c182034d168304fb5fae280826afb22a4d9a25d3fb7a69102c98d5e7c498a813cf4230ec26c41c4282bffcb9bf78f61ffee22bffe3bf45f8ea6db50df6ba46577d931b3434d7f8d3dce6778c340368eeec6dedee6f479ae1b86fa86760a46f7a7e7276717a61696e6b7be3f2d5cbafbdf1daaf7ff96bac8491dd87d216e6bd8f1e5cb9f1f6e0e87a4beb408da7d5e7a9f3b87d6e8703d8ac2640822d46bdd9709060ae3064751521a3bce4c2168ea248d920a463333493d1fd82f74ce3baf47b2013cc4ab4ff75b8d464d13b532bc9317fffad081c13dcb4e89ba759eca859adcec92acc6682b114ce488e4b8a3d71f4f09751a291e0a4b8231971478e3dfd0f5ffcabfff2853fff4f11de3a6bc0b1039ac9343437b6789a5abd708c8a0d28cd1d3d2d5d7d1d6d5d2dddfd9dfdc3bdbd83dd231343d3b313236383f38bb35333139b1beb37ae5f7bfdd5d7bffbfe77df7dfbbd8b672f0d0ecd3635f735d6b7b81c1e8fcb55e374baec560756bf5693d562041633130c6c7a2da0a48ad90da7368460297f248f0b3b58b055a7d9671ad7f14f04c716a5129882306bd4d20b5ee015769534864e3a8a48ef3eae145e8acb1c4b81c669258e20f072eb62feb7faf89f560dfcc936ffdf4ff53bcec9628e73d2159929886f5ce411088e8b398204a7241ccb4d8e8c7eee29ac833ffb677f1c515b67ad930473c43437b5d63623ca6d752d01d3edddad0d2d753822c454c00786bb07477afafa3a07077bc64687468607fababb417f4f4f476b6b63635b6d6d53bdafce6973781c5697d5041c6643c0aec96c324a7b943a122cd6e483d5fa119cc98cf2532b4406e0d76582f73e2039e69aad2a1521d36c51abcdfe97f8ec098645124c46650926c1129584b6b28a8f5565e5702c0aa6bfd28781f83e5be4980423c16c024e4f4a8e3d117df4d9e8e3cf60118cf826c71fcd493a71f4cb7ffff79ff90f7ff527ff3ec2eb33fb6a2d00a6bd12be7a476d8313c07443b3b7b1c507cddc745d93afa9ada1beb91683f6aea6d68e067c06c7f6f6868e8ec6d6d686e6e6ba8ed6e6d6a6867a9fa7a1d65b5f8bffe9f3ba9d36b3b1c60eb53aa745efb21afcd995045b597dde275836a1f25953d61c852cb35c9b39a00ada6c3a8d4cb0f84951b04c3317cc815708b66a342498432e65a9e5d90d5025437acd3185b8bcbaa45482fdd927a825d3185088e9af6d72c1055919a8cfd968afa28f1d7feee90416df43a989c73107a7c71efed2dffdb7fff19ffee8337ff0ef22bcec35837b8e6b25c1c05b67f7b1672e5cf5f5ee86861ad0d4e0018d8d0cba821f017c867dac9651e773825aafc3e7b1036f8d8d7dc9db6976394c0e9b0176ed26adcda8b11ad456bdca6ed4384c5a8b4e69d254d90c6a8ccdda6ade27cb2657592dc52961112c72984e8d1c9b560b822fda753a10fc79c22e6053ab4930e24bf85fd5a556f172bdbf3e2b7555d51c66547a5544e06bc94a4d7935374d3926d392ec625eb10351ce0765f979e5058ae2dc6c085664a4a5c6c520beb1c70fa5c41c4b8b3b9191108563ecb1af7ce50b7ff3979ff90f7ff287ff875f30cf31f0d4da00047ba5c7e2eaea029aeb18a4b3b6d6097c3e074372493a81c76d05e415c02bec7a1c66c41776f5aa8aca92fc92fc6c6d55a9b2ac505d51ac57961bd595d06cd7c38d325870f03cbaaf1a8712cc221870106c34d87ab0f803048bff6b2dd2ebd848332fd4022a11f80ebc3cc20f34b38b01fcbf04926cff9f722b2e06d545455585855545059501c7108c10a33e27c51c875d843825ee785a42646afc89c4e82389d18752e38f652445a6279e6082193e33a7468234fb7c7bb07bb85e744a36505363052492209d1456a7dd0858646d0678454d46644dda6a608648a3c665d1c36b65b102185415164d3501c1fe5c869956c5d991b08477cc200d6ab58ce0eb07087668b5803ba60ff3df0c10ac1948c9d610668d1647a34acdbf7a1ef8a6a346af24547aa58a6b069ab232a02e2d559594684a4ad4c5c5aaa22289c24a455e9922b738272b333136e1c491c4c8a3697151b09b91140dc171279e43ab95991a5d909b5ca4488df0d4180169f678f7f07aad7bd458386ea79170390c014c1cb7cd0830c50278656f260cd4648b5e85b28c524c951947845857596ad3a91c060d8e32986c045a741fb86253ef61d7a8814dad9241d7033f5273ac2a25ff00ff302e3ab49a3030bb4e9d8e6be6579c526d07620dd8ff1ba3e358b43aa6997db5512bbe5d827d1d4ec2a0d2b2df004933732cbd52535f5e0e746565dad2526d7109d0141529f3f3abf2154519e9a951c7138f1da6ca0cb52029ee5862ecd1d4c4c89c8c04faf252849bbdc5d9009869af49468dc708a4f7a59808eed569d7136e42522bb30b6872759a7548ad83bd9c50851917a9454136abab600b03c2a5d738756ad1b15da304a24e19f8a923801da72a954da97c12f049875acda153a746130249a44baf0734a6537e51fc11174fd8b47a8e5d67c0d1aa3158a56fca59b546c0067a9345670466adc14c5f6e95349360434505041bcacaf5a5650404ab0b0bab150a455212eca6441ecb4c8c86e3ac94e8a498c3e8b352124e646726e6e7a515156496146547b89c3ae0d72ce924dc3506c2e5d6e3a7c0ff49bb96e3b2e964f8bda2550e4061b5495d15c9769bf51eab1146a11052013c412d0d1c5a95889dcb0b605355f1317ee452fb71aaaa1dca2a60afae06b6aaaa70d0071c4aa58853a5022eb59ae3d668804bab73ebf422d0e93618e82842a6f75dd119f7309a9d0693438fa38570182c76bd19d8742640bee1d8acd298946a7ab7a6b1a2da50eecf3145197655050565595959b1b1c9918733a036392a2dfe180463ea8d8d7c2e3d391ac195be469c51989f15e174680139f68b74339c2e1dc075fa0027a056039c56b584d661c158cb0848e5905782924ae94459c6d86dd0027209c7ccb456e5826c9d1a03c0d349035814e176b9607b752561ad9473b06f122c73ccd0ea648e6bf406c263301e4c8dc1cc719b2c70ec325add261be1345a99639d89b0698d80e55bad07700ccc552a53a5d258594951064870555e9e2225313d2632333e3227292633293223f104e29b10f55c72fcf1bcaca492a25c7a0217449030724c905abb43031cf63d48aaa8d6615101bb590d9c668dc43ec134dd320c1a8ed3a8759974ac1a439b5605c11853829d925a0e770cc1355a444a0544a9a046ad72ab94c0a5ac76565739aa2a81bdb2c256816355302ea5ca59ad048eaa6a824e71ddad52736ad41ac2a9d186144c0abd46d34198ac9c80665b8dd94e4036cbb1de2c837cfb676eb5169a8dd52a4395525f59a9aba8d0969694e56467c64543b022351ec02e420cc1e89cb3d2e214d9c9c58aacd2821cfa0a4cc49e5787161679a0652e39145f1abb2c5ab75507308036164aa31f26d5a8b71b74f0e737a7d7505e891abd9e70eb748457af073e838ef0eab55ead0678346a50abd5fa341a11af5a0d6a03f8542ae0552a6b02b8abab615d42455ea1939b6316950c8f4a4378d5da5abd019ff4a1baaad51e1dfe63187c5a8357a3f7ea0c3ebd1178b47a78f599cc808bac339aeb4d1680419dc109ea8d2e4ead89e1333a69506776030cbc26a7c7e8f0e8eda0c66077eb6da2639aa725d30633da31a5d65ca53155aa51b4b3e39352224f28529273d362597c938fa7251e45f38c2eba20271d768b0b7390e0f2d2bcb292dc08b1fc5252fda701a362704108c1662de1326902e0a21e47e031e96b8c4c338e1ea3ce6bd2031af8cc863a93a1d6a8af351a419dc9041a4c46917aa3a1c120a7d968044d060343a7078d5a1d68d0e9eab55a62ff2f84ae56abc791a1d3039c86a40e7555adc17f0cb28bff54a2609eda5ab3c56b36133e8ba5ce62adb7da883a8bbdd66cf34950763d460bc0c017b8eeb1306acc56e03333d3241b997649751ba080637a8663b354b1a1198ef595aacabc829c846424382f3921273506d9cd4c3901c15826e5652452762158aad2184873300f31e5586ca66a1c3a8f532f42dd16ae03af43cfb0eb3c366d9ddd586b33d459fdd4db8cb20168b0181aadc646ab193459cccd568b8c169bb5c562215aad56a25da2cd6201ad66338e1d16eb1e46336833995b8d26a2c56064984cecf7c060265a8c16a2d16824a4df1553bdde48d0b8c16446889145e8441c716cb4d8d86920b26c66351a3d2693d76a051e8b85a89164f3eb221e1bc36d318bb8cc2682e663ae96b75daca9965e4ec1da2e6919adadac529696652724e42426c22ea66124188e339222519cb353e30ab2534af2b3a5e29c2b7d17269775d1b440f2af83a53531e173336a6b4c9c3a8f99fd951c9fc5e765837aafa5d1c368729b1b5da616b7a5d9656e0dd0e6b6003670d9180e2b6877da381d0e07e8743a393d2e17e8763a093a057d2e37e8713839fd0e17d16777727a6d8e5e9b0bf4589d0c87bbdbeeeab43a4097cdc9e9b4db3b6cb6768bbdcd6c6b3559c93afb25305b1b8de6668b1d3459ed0d662b72e937aadfd7213b25ac3a2db0e975c06ed03b8c069711adb211e390384d467c06606c33ee412d95bfb1a2c5b1b425029db4efa12eafa8282c2ac9531466e7283232e30e1f4e8b8ece498c83e3bcf43856a511e2e4a8fcace4a2dc34082e2b6476a5c7e8f310e20808ab637f39c326a3a9cede586b6bf0593938c5c5960627a7bdc1d556ef6caf75b4f9ecddb54ed0e573801e9f93e8f63a7abc6e4e2fe1f1f479bdfd1ecf80d73be8f3890cd5d60ef9eac1486d838c311f63d45b0ff68d3d44c3684dfd8887315c53076830e4ae1d74f9706403671de8737a41afc3d363afe9b2ba4087d5095aad8e168bbdd5e66cb3bb6a0d26d464f45636a5ca54850eb65c535eaa2e2b5195162bd91f20667fcdae5491cb29c9cb29cecd2e21f214a038378f28cac925f233b3404106a330331b1465e58082d48cc2b4cc7da4a7839ce464909d9494111f9f8615515454dcd1a351cf3d177f046bdf13e89f73936349706e3ab29b5482e2cce2cb9ef521c1fe043737395a9a9dad2d2e199dad35a0a3c5dddeec2230c695ae360f3bb678414fab0ff4367b7b9a3c834d75038db5c46043ed5063dd60433d18aaaf1f6e682030a6d391c6c6b1c6c6f1a6a6f1c69689a6d6091c25269b5aa79ada45a69b3b88d9e68e199c36b681d9c67630d3d0365ddf3ad3d0315ddf3e253159d7464cd4b612e3beb6316f2b31ea6919a9691e7235824167c380a3becf59dbebf0119db69a768babc5ea68305a7485c555d9b9251999f9c929e9f1d1190931e989316909d1444a5c6452ccf1c4e8633826c79e00293127526323d97e615c547a741cc88889cf8c4dc88a4b444394139f949b905c90925e989a519496599c9e5592915d9a995396955b9e9da72b2a02fae26243490907a758d799d916479911c7f292eafcdcecf898d8e7be8acaccea736a7c61461209cecf4a2ccd4f6776597c15ece94cff57d9f22bca14115d9dbeeeae5a919eeebade9efafe6ec6404f838cc1de46769418ea6e02235d2d60acab75b4b365acbd158c77747026dbdac0547be7645b0731d3d639dbde05e63abac17c67cf3c8e01163afa398b9d039ca5f6fec5b63e026306066d7d0badfdc47c4b1f986bee9d6bee07338dbd32a6eabb27ebba26bd5d139ece314fc7684dfb484debb0bb65c0dd087a5db55d764fb3c5e9511b8a9253b3a262928f1d8f3fc4f68692e28ea525456105929b9958909b5aa4482fcc4bab2ac95396e5eb2a8b4daa7287aebac6a4614d86ddd4ee7474b89c9d6e57b7a7a6d7e7edabf5f5d7d50ed4d7d1aff56853d3587333186f69217091ae83718931e9b71fe50df4785cdd35ce56bbc5a5acacc848cd387ea4303d253f35a9243bb52c373d3f33019428324af3335145504b20983d655d51247d1bbd48555d1c31d0df246370a07968b0052287fa9a86fb9b47065a46075b71c4184c8c748c0fb78f0fb58d0db64e0c7680a9812e30dddf33d5d73dd9d303a67afb3873ddbdf33d7d04c674bad0dbbfd43300967b0719dd039c95de31b0da3bb6d637bede3f416c0c4caef78cad758f12186ff48ee3285d1c2756bbc6c04ae728b1d43ecc681b596e1f05182cb60e2fb40c2d368f2c340dcf350cced4f54fd6768f7b3b47bcedc39eb67e77638fa3aed5e6f6694d854929109c1619997ae24442cc91948413e9c9d1009a416a626472fcf1d4f813685cb312a218719120372e2a2f3eba20e6443085b19144715c14288a8d0405d1c78122ea447e746441949ffcc81305278e83bca34714c78ee61d3f9673f448c6e167529f7d3aeee9a7229ffa87e41347d3a24f14652697e765c06e716e4a65712e0463d6a828645f84610f5dfb5ff603cd4511a323edc4c8701b0dc6463bc0e468a74437676aac677abc7772b4777abc7f66628060e3b1fed9f181d9d1c1b9b1a185d111b03838bc3030442cf50f2d0f0caf0c8e080caf0e8dac0d8f81f5e14989e98d91998d9139b0353cbf39340730d81e5ed81959dc19c171e1dcf8f299d1c553c3f33b4373a787e6396786164f0f2e9c1a98dfe99f037c70b277066c133d733bbdf3c476e71cd8e89a5eeb988478289f6b1a9869e89baeed1976b4c0b4afd2549898941b139b1673243df628c84082e38fa5c41e49893d941a773835e1484afce1b4c4238931cf609c14fb1cae838cc4638951cf64c69e488f3e96167514a4461f66c41dc53f4f8e3e9a14752429ea18ea797a4c24488d8ac46c9a1a751ca4441e4b3a7e24f9c4f1b4e8285c4f3a7e2c1593eee1c31860d2c531ea99af467ef52bd1cf3e83f52e9aa9f2fcacc2ac1438ae2ecca928c8ae2acaad2856b0af9397e5a325532a4b359a0a95aaa2a2a238626ab247c6f4542f989bea9b9dec9d9dec9701a9b39383f3d3c39c85a9e1c5e991c5c9d1a5a9b195c909c6f8c4f2d8f8ea28637d647c63744264736c726b7c0a9c9c983e393e0b4e8d2f482c81d3132b9c7393abe7a7d6700497a6d72f4ead5d9c58252e4dae010c2e4f6e5c9a58bf38be0630009771c4e9d8ea1ea3eb9c0b836be0ece0f2998125fa3dd8ec9e81ef95b671c47abaa9af5e692d4a4a56c4b11d229096703c5d3aa6c41d4d8e3f9c02bb094730488a3b949a7894de269714878bc712a29ec3c792f17b207d923e8ccf24c41f8a89fe6a72d2d1c484c3f1718763639e4b883994188b0fe0df9e488c7996117d2829e630fe2d06095187e3230f41248eb81875e4cb31c7be127df4e9a8a35f3cfaece750362a8a7294258a92dc74125c5998a32acd2f2dccaa28c9adac2caaae2ef1bfe0baba14b53a62617e082c2e0c13740a96e78797e6861667711c21305e98c195d1a5b9b1e5f9f1958509626d61923137b13e3fb9353fc3989d05db33733bb3f3a7a61618d3739c33b30be0dccc12383fbb0c2eccae496c5c9cdbbc34bb79716603607079eee495f9ed6b73db57674f5e9fdde6dc9cdb09e6d6fca9db0ba701069c9bb3a7c16d9199b300176fcc9cba3e73f2daf4d69589adcbe39b508ea0aff74c34abed48707e7c42764a34db274a8902f4de47480229c9c7708c8f7b2e35e5786202ae304f28dd719147d212639213e25212e393136313e2a2e2e3a312136312133138119b70222e313229293a39392629293621211a3f651f888f04490931294971f85789f1d1f88738a626c7c7c746c6c51c8b8e3c9c94702236fa70d489670f3ff74545668ab2ac505b51525d9caf2b2dd29715ab8b0b5445f96a14e40ab4570af456d59585987db5ca129daa346265796c75655c0457c0faf2f8dad2d8ea228e13ebcb9300839585313add5899029babd39c93ab73606775119c595e965801e7e7578973736c7c6161edf2e2fa95a50d3a5e59dc02d7964e82eb4ba764dc5a3a036e2f9f05cf2f31ee2c9f7b71e53c473cfddaea8557562f8297572ebcb47cfee5954b9c57562f735e5bbd065e5dbb42b08bcb97c00bf3676fcd9cba38b9de6daa2d494e2b4e4a55a427e6a4c465a74767a5a1c38aca4c85ec1338a6a74566a4e34a4c5e5602d466a6c6e6a42582ea92a2aae2c272a44851ad2c52aa8af1ffe4aaaaa24a1c55a54ac4a9aa04e3caaaa28acac272e92f7954e0b422bfb2b2a0aaaab01a837245059d82d2bc92324569450156b325c539859989e9b9a999796959baea12a3ba5c575e88ec6a8a1586f2228cb56505aaf282ea5285aa32dfa02935eb2b74aae2aad2ac92fc94888df5a9cd8d69115c0127d7a7b7d6a6b6d6664eaecf6e6fcc010c704a63b0b3392f72666b199cdd5c05e73724d6d6c09595adcbcb9be0d2d2c6d5e5cd6b2b5bd796b7afafecdc58d9b9b97a0adc5a3b7d6bf5ecedb5732f48dc593fffe2c605e26b6b175f5abf44bcb271f9d5cd2baf6d5d056f6c5e07af6f5c036f6eedf1d6c9eb8ccd1b6f6eb023787beb2678e7e4adaf6fdf26de3df902c0e01b3bcfbfb7cd78f7242ede7e6ffb0eaebfbc71193db6323bbf3223b72837232f23599111ef5f6ea641245b74e665c42b3213ca0ab2d04897e665a94a0bf5e565768dfaeaa95397b7b7efec5cbdb97101bcb07de5f6f6a52baba72f2c6d5e5cdebab8ba79696debeafaf6f5cd53374f9eb9b57df6f6ce3970e3e4c5e74f5f0537b72fdddabe7ae7cccd3b67afdfdab98c2b5f3b7ff3d5cbcfbf7cf1d6ad9d0b8b03e3bdb58d6eb5dea02a3169caccca124365a1a9b2c45c558aa3b1a258599aab2acb53952bd415f9d5655810a71664c5e5a54747ec6ccf83533b0b32ce6c33ceee2c8761119c3bb524b1822b174faf5d38b57a71671d5cdede04974e6e819b9ba76f6c9cbabebe036ec2e5fa995bebe7c0f3ebe75f208b9b17c14b5b975e3e79997865fbcaab2725b6ae82d74f5e036feedc00efecdc066f6fdf02d006de3d759bf3dee93be0dd532f806fee30be75eaceb74fbf08de3ff3b5ef9c7d49e2158997be7beee5ef497cffecabe07b389e7bed9dd32fccd70faa730b21b830273d373d89b60351ae710438cd4b4bc8c71a342d01b360697646a522a73237d75255f5ce9d17df7ee1ceeb17cf5f5a9c5fe8ee1c6bacefaf7577b96ded2e5387dbdcedb3f6d4dafaea1d43cd35136df5733dadabc33d5b1383e797e62faf2d5f595fb9bab17ae3e4c6ed532771bcb8b2787a6e7a6b72ecd4dcc4edd39bb74ead4d7434b4398d1e6d85dd5461d1971aabf3ab8bd28b32e2142951b9890c23c4ab4bb5d5f9c58ae474740931cf66261cca4b3d1e71eeec0ae7fcb95570e1fc1ab87876f5d2b9b54be736c0c5b3eb17ceb0f1e5f39bb8881fd14f2f9f5fe75cbb70f2eaf9ad6be7b6c1f5f3a7c18db3a7ae9fd9b973eac20b3be75f24b62f32b62e8197b6af805777ae82d74e5d7bfdf4f5374ef979f3f40de2ad533789b74fdffac6e917de3d73c78fa490744215e411a44dc6f7cebf0273e007e75f073fbaf826e3d2ebe0c717193fbdf026f8d1f9b7c037cf7d6db971589d5b5c969a93979996959a9493169f95129b991c8323812b6c5b3f2f93ed2de4e594e7e75517e49baa2ad726a7865adbba1b6b7c566d75614666fcd1d8635f8a3ef28f3147bf884152ec5713a29fc6f8c4739f8f3afc546adca192bc246d655e557e72455e62a5224957966551169aab0b746539cac27443459ea624ab5291827171664cdce12f14a4456a4b33abca92d3939f79f6a9fffed79ff983cffc3fffeebffee1fffee77ff2077ff5a77ff8f9bffacfcf3df5379187be00a29efb6ce2892fe5241d2acc381171f1c2bac8a58b1b972f6d5eb9bc75e5c2c6d58b9b572f9ebc72618b1cc32e4e71113fa29f5ebbb475fdf249e2c69553d72fefdcb874fae6e533b72f9f07cf5f3c77fbc2d997cf5d79e9ece55788335719a7aebdbc73f5f55337c01ba76f82b7cedc7cfbec2de29d73b7bf7efef96f5c7881718ef1eef93bef5d78f15be75f02ef9f7f197cfbdc4be0fdf3af7ee7c26bdfbff02a14123fb8f8da0f61eef21b0c49a11f922af193cb6f33aebc09fee912e3e717df665cfac62f2ebffb9d4bafaeb78eebf2cb2ad2f31459e9b919a979992939e949d96989202b2329339dfd5993dcece4829c74fc283f335d595aecb19a5b7c9eb6dadac2cccca4c4b89cec8c5c45564a5a6254ecd1a3279e7df6c8d35ffaea179efaf267bffccc53cf1cfef2d3cffee3535ffcdce79ffa872f3dfdd4b387be72ecb9cf7fe51fff1a441ef947f648c6f1af9e38f4c5e3cffd235a77cc05f191cf1e7afab3b88276babc08ff1763e3a3bff0857ff893cffcc7fff58ffffdfff2ffb777674f6d9d7718c7d566d269e2b88de33daeebd86801ed47fb02422c011b9b6013300e8b002370bc36f1324d1da769ecec5d2e3acd55a7bd6a7bd1697bd136896d0cd2d172b41c1ded20891db17823b6e33da913f739bc63a099fe059d329f79e7e53de286af7ee7802f8c78fd539470adb168935eb2d1a62faab669f0d6a9b6eb6acaa8fa6de697ea4a41e0f57c0c1efa9fb4fb1f6ed7dff9b4f370420eb14772121ec8cbb0e2ab18cf273cf7a77ed72741fa6cd87b9ef3f6b1746fd87d1e38fa02c45dbc44bf1bd217bc807ebcb33c92307b3e94eb0de7fac3432e76f8c2a291bec8683f37d11f9d74c5f2fdbc29571ceb34f1a825360bf0e9ac2b0597dce945ae41e2b23b73951e842b7416aed2d9394fee1a9dbbee19bae61a9ceb4bcfb8e2e77ff3c7832f751c69edea686b73b4b4b4e131dcdc88c6d874395eea68d98d3d4e1cadbbbbbbda7e7cf2e87b1f9e7ee783b7de3cf3facb3feaa9c42f394d2f741fea7274ed29abb25a4ab4262ba5b7287466b9ca58a4b52acce53ad09a144a6da1462fd39b94062b4f6394aa74129d518113ad418e4b56ab06cc16b9b558596253b539ea76d6dbcb2a289df4d982f54f6c58f12dacd2e79e5614ac5489d75185cfdaf4924aaba2c222c7bacdaed9596d6ede55018b81916d21300949904352171bf229d685c001fa6cd0730e81595f6f9c71f37cae84df4da4bdee94c795a669c8b87c30d4171cee0f8df647e671f322632e6e8c8ef2b09937ee8ee6dd7198a213d39ee4b43b0133741266dd09e2229dbce84e7fc3657a00ae7a338b3cb939ef1071cd979b37bce0a677046ef9866fd0d94b9e54ef477f3ad4dc89bbf4def6f64e870351bb3b5a30afe80a985aa4ed70ec3975eac4e9d3afffeced53af9d3adee66ce939ec6ceb696d687bb1656f93a3bb79d7eeed96529d5a2b01ca50a4d088147a89da24d5db3486522d65902934b824d3e8155a930cf9d5fa42bc46ad2d022525018a2ab4db8d086cb12a1a1aab76376db5144b7506a1f0d9275117441b96c936af500a5729456ba1582b2a37cbecc622acd536755d9509cfe03d756502bfef539ff713d298c45ed8e39c587a958c35567c61c87f0e58ff8508d3c78f2fd39708b82015f0a483de81900f7201de30c30cf9fda3dee0982f34eee160828e41decd9ba251313ee989e7bd096ca63d289a98f126677d69b8e41b808bde345cf10dc0656f1aae7a07969af30dcef9b20b3ef3e7002daffb8796bae91f861b0c310ab77cc4f0e7781f3019fab77f79b5bd071018438cb4985d14ed713adadb9a70973e70a00b69df3c7df2c0e1eeda86ed35bbb66e6fa839fec6b196ee961dbb7774ec6f6b74d4576cb5627065ca2d725501a52b942a36cb756234a62c4a8d55a5d0c9a454a14a23e5e9f877005639254457855a2c530ae52a11e6d856663499654693b4a5b5b6aada24976f9048d6ac5d2e58bd4c40026382e703af56085759a882524361894e8cf5f962e50bcf1b51b7e905bb20183c17089c65984fb18642e7c3e15eac382416f6e412cb5e0806ce079873100af672a13e8885dcf1309d08d349d6930e7b9241772ae01e087932ac2f1bf18fb2cc48d83f160ac07890853c139d0ac4667c719e37c9877ce4a22f35eb4b5df4a7e1123370253008730c91816b4c163ef367009beb01f4cbc20d26f77960e89111c4c3bae016b3e80e330ab703a3778263778213b703e37718de3d66f4ae7fe47a28e7fbfddf8eb5ef3beae8217f8d9dfce7919d9dcdadad8deded7b4e9c38f2ee076fbdfff333fb8e74bfd8bcabb2b6c2beadb4a2b662ffb1fd75adbb6a9beb1a1d3beb5b6a4bcaf5184d855a082a8d1899655a111aab8d72caa4406099a648a9912b28193fb8fa4204566ac5b86f63b2e59458a52b2ab11b8c16b5c158548271acb31b8d8552e9fab56bbfb3669960ed53828dcf3c5eb06e9964e372dca2d5124cf06a936a53894e68d56cb1e945085c5b6940ddc61d364124d2876c241ec7f547a32eacd8e37c291cc662ee44c2c3455c11b63f1aee8fb1ae78c48d35117127393a130f4036ca0c467c489be398e15870241e1ae7823019e1e5d908cc8462301b4cc0a540ea72308d8a57831982ece74259c0b77b51207b2398bb191c0654249b5ba111b2c2edf0e8ddd0a27be189ffea7e68e28bf0e47d76d197a109f82a3285f54678c8fbbbbf1e7538611fff6ff75d4e671bf99b9f070f3a31b5bffee897efffe2ed23470f1c3b7514835bfcbcd55c6eaa69a8711e7156edac2adb5eb6adbeb2a9a31e81f9b9d4881118e3aba444fc5d5a2352eaa52a834cae9592c072b514838bc080c0e88ac0807b38c61743acd34b2a2a0de5e55a8ada222e58f9d4138275cbbfbdfe7b8f21f0e6354f608817021b141b8bb505506a105795a81018755fac2916c4639e58948e726ec0064842b227e7e4125e994cf8c87982a393514f2aea41da54841e887ab351df509c1949046034191c4b852692a1f144703211827c9c85e9180717b9045c669330c766e01a3b04f8e62ef89c1dbe1919b9c52e111ebecd8edc898cc2bdf018719f1d5ff0456482f8722936ffafc8d4525f452601e7c4fc0931f9809db8179b88fce1e3d79c078e77f420f07ee7de4e672bbc7afc1006f7c35fbdfbc65b3f397874ffdefd1daf9e7c05b3abb7e93456aa7a67159ebea55b6d2555c5358d5b3b0e3a4a2b8d184a955aa8541548659b280c3125040512ea8a707f9e0f2c95a9f83b3319dff9778044a6166182d57aa9d5ae3758d59446881fb2cc66a94cf68375ab1f5ffe241f181602cbb73ca312afc1af4c5ad93aabf6390c7199a91081b797ebeab759f12416a0d95289b8172149cb54d20f4b0f2115f3423aee1b4c3299243398f067e2fe5c32c0d79def3a9e0e4f0cb0f90c373510c9a7d9e9410e660678b3e9185c4ea6e06a6c602e3e783d9a851bdc10a028badee246e13642726370373a7e6fde5d6e0ceb97d1091e37090fa2f96ff82a36055fc7a781ec1f46899925a6bee6f20fb869a4c50a0f391cce3e8ce41f72530fd233c93ff79e7af9c889ce7ddd1d8e9ecef6e3afbd72e6bd374fbffbd343afbcdce4686c68a96fed6e711eeec204dbaa4bb4c51acaa22edf66c793b8b8c262b4e91bdaebf71eee30dbf50829576c56e0318c095615fc6760b14c23218165ea02a425577158a416e12aa6bcb8cca0332b15cae7d058abde22dab2eae9658255dfc7fd19811ffbe1caef16ac5b4e1ec30ad13372e10a95649545c3dfa5cbcd45b8456f2da5f018c62fc482ff7ffc6f7ffc1ba4014ae0f3a5dd800000000049454e44ae426082);
INSERT INTO `persona` (`PERidPerPK`, `PERidDocFK`, `PERnumDoc`, `PERnom1`, `PERnom2`, `PERape1`, `PERape2`, `PERidGenFK`, `PERdir`, `PERtelFij`, `PERcel`, `PERcor`, `PERidRhFK`, `PERidTiPeFK`, `PERidRolFK`, `PERidCenFK`, `PERidFicFK`, `PERfoto`) VALUES
(25, 3, 987654321, 'prueba nombre', ' ', 'pru apellido', 'kjkj', 1, 'ghghgh', 67676, 7676, 'grtrt', 2, 1, 1, 1, 1, 0x89504e470d0a1a0a0000000d49484452000000a0000000780802000000fac06e38000080004944415478da94bd75785b57bab7edffbfef0cb50d5379a61d68a710b4c349d3a66d526698729b346cc789999999624631586049168325cbcc4c8993a634f8ce9c99e6fbedfd48dbdb4e3bd7fb5de73e6b9664c5b575efdfb39eb5256d07fcf9efb76e7cf37f7a06870d169bcad02e52b6d634cbab1aa5579ac485550d79d5258575e57935c599157919a5259965a5f965f9b925b919f919a939a91831cf29cec1243d2f3d2d370d6366416656611646dc89115fcd2ecac684a12803a417a4a5e6a5246527c667c4c5a6c6c5a4c44626c75c8e8f0889be141c157a36ecc2a9d0b3272f9c3a7df16c48f8c598a458fcc3a22b45f5cd75cda2269142aad0aa34ed06bdc5dc6e77181d4eb3db65f174d8bc1e7b57a7b3a70bb87abb81bbbf1778fabb41e7408f77b0b76ba80f60e2eeebc23d181d9d1d2d52514159b154a53039cc4eafaba3dbedeaea70f5b881b39b9938ba5c76af93b0753ab839ddb475daf9d8bd0e3b46169bc766755b2d1d160eb3cb6c761981cd65e2b03acd1687c96c37986c7a0ea355e79b5b75669b1e58ec068b5dc7e068b73a8d189989cb60771b01267e74c0e65c22e03fb76efdfb875bffe787ffccdfb8ae3559848ad6da165555a322afbca9b052905f7d25b3ac38ad2427fb4a61567959426e4e4a4e2a48cb4bcf2aca4ecfcf48cc4c4aca4ace28c8845d025ec93746c6746116be8a47e29fa4e5a78294dc64d84dcc4a884b8f8d4e8e894a8a0e4b8884ddf31121b07beef205a865ec4686c6a5c467e66715551497d754344b5a440a31ec6a8d7abdd56274d82d1d6eabdb63ed74c3aea3db4b6a3bfa7a08cf401f0767b77bb81f23ecd2e8eaf20864e2c2f21208363b6db8e9eef1ac108c11f035dfe6d8b16477b96072cc874cfbd51a5955b06bf46320a016feb8b999070926c718ed1d66126c71eac18f08fee7bffe03fe73eb07f0cf1f6e8d4d2fd4b518b20b9b5373eb190acb92f34b62b3326332331272f213730bb24bf312b353a253e3e233935273d3203b393b0523e6a97ec729d949499909c95989a939c9a4967b240e88848cc4f8f4046417762313a3c2e32342a32f5f080f3973f9fce94be7ce849c3f171a1c1a790976b30ab24b2a4bab1b6bea050d62955ca66d55b5b7e96d26a3cbc1a6d66befea7274773b7b7a5cbdc86b3f5f6ae7603ff00e0d80aee141d03de4c33bd0df333cd43538e0eef10ae592a28a52995a69ed70e0a6a7b70b63472f83b3dbe3eae9c40423e68e2ea4d96df776fca8e9db94b3b08e09be727f9a19207805306db2b55346972967426ce0041374ac300f6605b38e0df06a77e98900c62cf3fffffefbbffef6b77fdefadf5bb7fefebfb706c7fe7c2a38f3fd4fa3dffee4cca767c3ce848587c4c48625a445266786c54747a724c467a4c4a527c765242664252765a580e59a53a0d6077b0f6797d40204372221322c8eb11b1c7111c13d137a0ec0eee5e888c4f494ecc23c3cf595f5358d1201eccadb54ad06add66232386c468fcbd2e5b17577dba1b6bf1f740c0cb807073b0707bd43431c5dc3c38cd791a165f80563e2e9ed1129e44515e532b5cadae172f77477f675c331aa3a0a386926c17cc73f868b63a563e0b6037edd26b526a789d34c50b986dd760bea733b3fd366bf5a3c000ff363e4ca35679715cc6077b5030886d37ffffb877ffd70ebdf8cdd7fdd428eafddbcf5d189c437de0f3bf6fa474fbff8ee53c75e3a72fce5a75f78edc8f1574f5d0c0e898a084f888b4c4a884a420ae363531359e2e3d212e2d3e213331293b3a036159a01bc12a8e4f1e9ccc36252f0af622312a22ec786f3ed9ebd74fe7c587034166504beb8a0b4aae24a434dbda859dcaa6cd5eb5adbf5b0ab73da4c9d1d5604b7b7d739d0df313408afc03334043a87873b19a90cdd2323a0677414f48e8dd104740f0d7b07067b864740676fbf44a92aa9bca2d06a2018bebdfd7d9d7dbd9d18fbfbdcbd3d9ebe5e577717e1ecf2f221b5b0cec1c9fed14c5b3b6c64dae2b29a9d162cf93eaf4e0bc1dccf5a5f2e7809524ba3cd853a6ff197775eac798289801f5099fff79f48f0bf7ef8e7f7fff8f7bf6eddfadbbf6e6517083ff83cf6b5772fbef0fa87cfbdfcdea1a3c7f71e3e7af0c8f123cfbebcf7d091834f3ffbd2eb6f7e7eea4c684454784c5c445c6c7462426c72425c4a627c2ac678684e484f80698cf199890ce98964176a71584424c45c8e8d0c8d0e0f8eb874ee72c8995008be00d39762c2d273b3728af28baf9421bb0d2221ec2af4fad6f6768dd5aa73384c1e26b8cebe3e26afc3c3de91919f02521946c7fbc626002604bcc271dfe818e8ea1f94a934e5d5b5ad28fc1d1e4f4f1feef1f60d20e2c0c39aeee881e31e3f5db7fb5e79939775bf7846b9b9c36a71dba0990413b8c917ccb96fb72d33ca17ccd925c1741cb077725d9bd1e6c327f8d67f7eb88505f87f7f60ec82e1c9ef738b05c16199ef7c18f2ec8b6f1c7de1f5e790e0679e3f78f0b9bd7b9f3e70e8e8defd4776ef3d1cb4e750e0eefd070e3dfdda9b6f9f3875e6d485f321e1611171d13149f1687d6393518711eef8a89418803e3992e9a7e2221363c3e3a361f76264c485b0cb3cbb972213a3133292905d54e68afaea3a6193402957e8db546633ec1a5cae1576bb104744737c1c60c20337c77b272641fff82409c684e8631c8ff6e39eb189aefe21b9baada2a64ead6f876004da2f18657cd0d307c7fdee5e4499d1bcdcf432d97ca8a42f17ccacdce60ebbc5edb07a30da38a3104ccaf973726cb49b305a7110382db436c3a8bdc36aefb07190608cb89f5fb461d7ee32114c17fd1fd62beaf33f51a2ff734b6de8ac6e54e5970ab20a1aa213d33ef8eccbe75f78e999e78e3dfbf44b87f63fbb7bf753fbf63d0382820eefdab53f30f040d09e0330bdeff091175e7dfda32f3e3f7b3104b62ec544607d451d0e4f8c0c4b88c02e08ad7278420c96f04bd151b07bfef2a5b3a117c92e3443795246724e516e6e6961596d252ab35029956ad52aa381826beeeab2322bee806788092e44f68d8ff74f4cf42e87f58d71a27f6aba6f726a60628a533b303103e0b577646c00f7b082652a6d79759d4ad76e7777426df7c010e398150caf10dc89ffe27fd3dcc3ded9cd17bc62b5865dabc7c9da75d2842c6264d6668f0b60c20926bb08312718d85c5687dbeeea7462242018f79b6c4cb21da80d3cc19c5d46f0bf6efde77f6ffdf0f7fffcf04f56f3c8d4bc4465ac6c90e49554e5145dc9c82f4cc9cec5531f9d18732ee4d4879fbef7caebafef3d70203068f7c14387f7ef3d18b46b4fd0aebd3bb707eddcb667d7f6bdf0bd77ef534f1f7de9b537fef4e9e767cf9e0f3b1b7a29383c22242a8ae35c44c4e9cb97cf5cba74e2c2854fcf9c391d1a1a9d84353b372bbf30bfa4acb4bebe4a2068562aa53a5dabc9d466b79b3c9db6ee1e671f3aa941d62e82cb58843f581c9a9a199c9c86480273dc333c3ddb3ff5e30ce10193d38378e4c414cab55cdb5655dfa8d2191c1e2fd4f60e8dc071cfe03046f8c63d3ee58875df0022eeeeee25302750d839f1ceae6e6e021cde2e864e8fdde3266cee0e1627073fbefc40338bb493d953add865393d506ba5343bdc16029b25eaa831a1a61a0b337ce331017fc3a27bebd63f586efcf5079dbdbba2499e5fd95c50599f53569d565898909d8d7d51524e6a5c664c447258624a524474e4b9e0f3efbcffeea1c34feddeb377efbe833b77eddeb973cf8e1dbbb76d0bdcba75d7f6ed7b82820eee3bf0f4a1a79ec36afdd6fb1f7cf8c589cf4e9f3971eefc9717824f060743edc7a74e613c7f392c221e1baaec8cfc82bce2d2922b55b0db209389b55ad8d5daeced1d6e0b9ea3de3e64d73d88366a84ec32e5776a7a607a8604738e59c173c3d3f318c1c0f4dce0cc3c3134bb0086a17f6a863423ca72ad6e8560d825c1b849905d023a017965465eb8b940d3841c33783be1d8aff6ff5630b72a332c9d273123c44e8f83b56b737aacae4e6684e31582d9b68b59ad03c616ff397efd5f37fe71ebeb7fddb2f54e5d11682a04f22a716b766575d695aad4d2c2c4c2dcc4fcf4e4c2cce4a2b4c4829484b444b451000b2d3adea8d8e8d3674fbff4ca4bc8f4ce5d81dbb6efdaba6d27c6ed3b0249f61f1fdfb663d71e2cd5cf3effe2f1575e7fededf7def9e8e33f7df639c6d32117a31293c86e4e7149d195caca86c646b95ca4d1b49acc6d7607ec9a3bbdb04bd925bb504bd985ddc19959723938394b905d3e23330ba3b35789b1b96bb03b323d4b9a2158d1a6af6e6856eb8d2e6f4fcfe048ffc8181c1370cc32eced83639846a6073b7b070837d2cc081e2030efe8e97375f7d2b864177476e1e881572ec7fc345b5c28cee8b11de49b9ddb6eb7cedd09bb549f01ebd87e7b82b97d1423b8d5d22f6af308b50e50295296348a4b9b05e96515e9e5c520b52c3fa93827a9202b313f333e373d262b25a32013dbd9b8b478663b9b128b86393e392e22263c2935393834e4ed77df3e7ce4f0aec0a06ddb7780ed3b7622d6dbb707c1f4934fee7c72dbae5d41fb0e1c39faccb1173ff8f47334e16437abb0a8a0bce24a7d4393442ad268e58676ca2eeca238fbd7dd51b2cbaa9da3440ecf5d853f2eaf9c5dba1323e1b7bb008627e7b00c11fd2393ad6dc69ac6166dbbb9a3abb77768746074a27f641cf40d8fc137ee01704cc031a925a33f2ad8d985ecf638bcdd2c4c8926c158e33122ca0409c6de8c6f97e7d841e271935da41d04966aa7dbe5e8702e176c639b2c23cfb18523a052206d5468eaa48a2b2d22ac7fc5b5b525f5553915c5d9e54599a505a9853949799989b9594979d949b9b989393971e9b120293b312517fbda84e8e418ec85b0ebbd1c1d161e1b119b181397141b1e15f1c597275e7ef5e5838799ea8d403fb97507817c6fdf1514b867df99e08bb14929b09b5d549c575a5656535b271289542a99dea0325b0cae0e54667b4f2f965ed8ed1a1df397e5594e2d6377fedad8cc22189dbe36327515ce46a717c0d8ccd5db199f5b00239373a37818cbc0e8944a67aa6f91e8cd0e4fcf207c0f8dcfe04ed28c66bb9709f4284c135d83c39dfd839c54cc09120cbb0439e6406d70763239e620c1b06b7139add08c28c3f7f26473d621d8e5c126bd036a014de01820cda8d8ae4e0734f377506cb36df509bed2525f2d6a2aa92d2fae29bbd2548d494145516e693ebad9ece2fc8c829cb4bcacf4bcdc8cfcbcb4dc3cb4429985596979e94959c909198974221a1bdc9894b8a4ac94b8b404f46291f151d82c85c74685458687865d3a7beefc071f7e74fc8517f71f38b86de7cec7b7427160d0defd97a36292d23391dddc92d2a2caeaaaa69626a95ca2d65271a6ca4cd9855db62ccf20b8bed4ce5f03a30b8b6357af4fccdd189fbdce69c6383e7b0d4ccc2d2e317f956374f2ead8d43562606446adb3360a14462bf64843503b34313b30360dfa47a77a8727fa4626bb07c7889ea1718c5d03a3defe11d0d9374c787a8780bb67d0d533e0eceec7a4a37bc0d5d50f3a98feab0fb581a5a78391dd0de01881c6c6ccea624ea7dbd0457a3aed9d5e3b966a9e634c9cee251c1d1dc0e5f1b0735630f9f6156d2b6717992698262bafb2b8a4fe4a71750528bc529a59989b5b525c5a5d9555589059900fafcc5890939e9f9d9c9391989506855886b161058999c9201e153b23313e2325362d292605998ea7fd6e647c0c4c87845f3c177afe6cf09953e7befce4f34fdf7af76df4e1afbef1464c52626a761696dec28a2b15f58df52289a855dd6a3052714676b99eb9677c8a0b2ee7158c5fbb0126e7bf9e98bb09c71c500e26e71639a6e6af718c4f2f4ecc5ce70b6e122acd76afb77774707476787261707c0e0c8ccdc22e20af241890601a39c11dbd831c241b8e014ddcdd9ce35e4e30156d46f3925d3f74ff4f0af63a3a3c76970b50a64930e924c10834624dc986e0f2ecf2928ce2e2dc8a8afcf22b39256539c5a5a939f05a843d525a6e4e6a4e764a5e7a726e5a4a5e4a6a7e6a7a6e464a566a627a1248ca4a8b4f4f8e4e49884b4f8e494d2470332a3121223e2e2c36e6724c7468f4a5f36117ce869e05a72e9c3e71f6e4f9900b0877627a5a56413e965e14e79a16618b5ca9d4b7b73b5c3a8713fb22c4977a6636bed3ccf686cd2ed925b5138b5f81a9856ffc8ebf5ab23bffd504423c7b6d85e0e905d8fd6a72f6e6f8f48db1a9eb7cc19d7da390ba5cf034408e394830a47276dd7d4b7631077cc13ecdcb0453c55e2ad79c5d5ab09909eb1ef9064e77278c22b51c1d9d5dac63146a37956eeaaba1931c63c4bcc3eb0498046494e4a715e562b905c9f9592905d9e9c57918b1fa26e4a42764a622b8d09c9c95999c9981cc61929499011233d213d2d3e2d352e35253625392b19725d01863e713161b171a151d1211894eeac2a530acb8e0fca5d04b5191d08f7f88ef99575a525e5f5f2b1436cb14524d9bda68d6db1c566fbfb377b87368a2676c8653cba5766ce1abf1ab3727ae7d3db9f8cde4e27713d7be9dbefaf5d4c24d180598b03719e5be71eeebe9f96fc0ccc2b780e6500bc7308dc8ea4dae16b1caeaeceeee1f1f1a9bc30a3d3c314b23bb184ff50d31f40f4f338c4cf622d003a35dfde8b14709cc8117be7bd1820d79fc40f332d36cb9a6fecb8e128d10fb1ab125e87e1b5a6ecf9266eaceb895dbedf576747602bfef4ec2ee703a5d1d1d9e0e8fd783a38223202d3f3739272b212713c4676760444b85091ca3bd4ac9cd4ccdcb4ac9c9405263939913ce7043402dd925c131c949d14989b01b9990181e177f3926f6626414049fbb7889ec065f0e0f8b894665c69101bba8fc8515e5954d4d0d128950a9427c61d7e472dbba065c7d235d2353bde3b35499b9e032d9f5db9dbafe2d099eb9f60d3966f96605a476f6ea77801c43394ff0bcced8c1178c157a787c9e2f182927bb64ba7770b207e51a45fb36c1e4f8bf0ba616ec76a91c64d7ea4f306717b8babc1ddd5d10bcc2316966ecbaa1d60dc11e6fc792e0a86454d7d498d4e4d8b494c4ac0c22293b332e3d15c02b884bc3be2829292335252b1d22a1f37658bba8cc09b08bf85e8a8e81e0e0f088b321a1701c121611199710979a867d119a3534cff965e5e5b575e89c054aa54cabd39aadb06bc7fad43bec191c477c07a616c82ed32aa399620bf2f4e237b337be9bfbea7b307bfdcf338bdf4330cb77d357bff549bdfa2d07bcce5dfb9e20c75373df8e4fdfa47160640e820512adbda3bf67606a78fc2a0926906f00eb184930ec0232cd095ee17885e015e5faf6ad94ddd3c3c0d7ec4676bde8bf20d8c146991c63f176639fdddd0520dbe9eda4724d30763d9dac5dfc8f9bc505024e87860647468644455d8c8ebe1c1787f162644464423c80365f58539390dde8c438344d1009a09983eec1e3d975370ed9e5ec9ebf1c763ef4f2c5f048884f48cf48c9ce81ddcc82426c8d4a6a6aaa5b5ab0f4a238a3b7427c2d385abb7adc0363dee1c9be89b9a1996b2373d747e76f4c2c7c3579f5e6ccf56f01bccedffcf3c2cdbf81b91b7f81e3d9c5ef3938aff04dc0ebfce29fe717ff3a77ed2fb357ff3c3dff1da9c50463fff07c5bbb5b20d1d93b06217864e2dae8e4223413649704538e492d55ec9e810902d127c724988b3293e69e41c2dd3d4023418b31bb77ea7674f602a7b70f2cdde9e9b275a0d5f2728239c750bb04dbaf75106e0f40856670772c09de77e4e9c3cf3dffec4b2fbff3d1c7e72e5dc6c289251356c263b1e1898b8269768c4570a19375c939a6d402b21b1e170bbbb4f45e080bc7773b1b7a09a691e9f8b4746cb1d2f3d09617e49694155da9bad2d084ce59acd2a0386b4c16a3b3c3dad58d5d2fec527cc9ee186b77eadad7b0cb64f7c65fa0f6ead77f671c7ff5d7b9eb7fe64352617ace2f1e6ac1c2f5bf619c59f89e113cfbddc4f437d373df8f4f7d0dc13aa34728d53bdc43bd83d3b08be60b9a01040f8d2dd00850cc1177d03f3c4b159b13ec73dc3fded537c6819e1cacd0ccc9661df7bb20156a3b211b6afbe81ef64e9f6336ca4c89863f37e2ebedc604c125b5dcbecbf7253742ec25c19460241c04ecd8bb2fe8e0a13d070f07ee3bb06b2ff3a2d02bafbff9f9c953e74342010a2c64a3c062db1a111b8f320b918022ce7905d43323bbb08be0c22ec0046d17d9855a74e65985c5e8d54b6bead039a3b792b7e9619736be744ea37b8cd9f222beb04b6aa7a16d9129c8601e82bffaeb5538bef9b7f91b10f91dee21f8a6999b48addf2e40827d82e7be9d98f99a123c30b260307b453203124c82b13063a41c23bb28d42498af198efb8666f0789649ce31a9e5cb661cf78c9066ce34d9e5e9fc11c1b04ba3cbddd5e1e9f674f5787bfa4027ca3be59815ecf1c338f674b16011eef4767ababc9d44c0d1178eef7bea70e0fe7dbb0f1ed877f0f09efd0777eddebb6d6760e09e7dfb0f3d75ec8557defbd3c79f9e3cfde5b9e07317613a32383c0ca08c8746455e8a8e02988090887080b20caf672e8662a4eca22c93ddacc2226cc0f2cb2a4a6b1aaa9a848d128558d5d66ab2b6d95d46b7071b5fd6ee389dd0189e5d4476a7506f914838833016d8e5042f7cf56796bf925dcef4c28dbfcf23b22c0b7e609a2bd193b3e8bcbe87e6c1d1ab466bb758aec71a0c676cf375031b656c9147261698a69a19afb12c130cfc821950de01795de1dbe798d5cc8f2f076797bb09e50e4f0fbc0277678fc7db0baf2418509a211577029f5ddcd3c9c02cc3f0dbd509683d0eb870f9d2c973673f3b71e2edf7de7bea9967e175cfde037bf71ddcb3e76060e0be9d817b0377efdfb5f7d0ee03478e3cf7e24bafbff3e585f3a7822f9cb91872ee52e885b0cb1c67432fe21ed4e4d32117014a34adbbb04bc519eb6e41f9953226bbe226a952a8d4287446adcdd9ded149f165cf694cf83a67bf6064175ee721f5ab7f30dcfcdbb5afff0e16bff9c7e2cdbf5efbea2f7cc1e41e8289db05c32b5f309c996c5d106c73f591e0a9b9af2666aec3b1af9d9e40955e24c7381a7855fa47054f8215459b6a3557aeb9e2cc970a78cb733fd56d9fdaae3e80097393cd31df2e2718d659bb5d2498d4a2a3c6ae292032393a2c21e252cce5f0f888c8c4e84b3161a72e9cfdf0f34ff61d449477efd8b96be7aec0a05d7b766e0fdcb5230813c677d0be03879e7ee9953710ee8f3f3df1c5e97308f799e0d093672f9c3877fe8bb3e7601a453b2625212d2f2ba3a00864159514545496d5d657370b1a2532765f64d29aed0697c7e2ed71f40eb80747509c61777476719c6dac98e2bcf80d96de795e70176ffe1d5cfffa1f340157affdf9dae25f16afff95cff51b7fe3a07bf0b085abdfcf2f7c478e0126d066b6f74aa40657c7d0f0c8fcd4f45733b35f4f4edd001393d7c7c6afb15c1f1d5b24464617f0b0a1e1b9c1a1591a070667fafaa738fa07a6bbfbe17b86acf3eb36bff3e274f2d37c7b9479377b396e8fafa7ababb39b19b15982e04e6f97b7db4b0986634670544a4c74720cfb16e5988884a8b098f0cbd16111d19151b1d1e743425e7bf3cd7dfb0fc07260d0eea0dd7b607dfbae5da8e1db77053db97de7e35bb76fddb53b68ffa197df78ebd5b7def9e8f313d8f2a26ea305c3fe38253b2b3dbf30b3b038b7b4bca4bab6aaa9058d153a67895aab6a37e9ac76135a899e7e57ff50e73073c60ac59904fb565f9fe0ef518a29bb7cbbd7befa1b4093bc70fd2f576ffcf5bf8007e061fecd92af506324c15299bec33d0861b70b1e9f58f40bbe0abb9c6078855d120ca93ec103137d4c7619c15cd1a61e1bfc94e015a66f13dfbb127f89e6b28b6d31e3d88b107b5708664a348c22b83eb57111e1f19198c7a6c687845f0c8f8d088f8d0a8d0c0b8b0c07cc0b44afbdb26b77e08ec09d5b776c7b7ceb137f7c82e1896ddb7604063eb66dc78edd7b5f7ff79df39742a313139232d2933333d272b22138bbb8b4b8aa866f57a13360e3dbee7061e3ebe91f845deaad509cc7e6ae433067179d33095eaaccdf2c13fc5376713ff72512ec77fc174e30d6548ba3472637b83d43b70b865d00b5c48f0b1e9a02fdd81cb3767b19a354a8ff7f0bbecd77ef8f4276b99e8b35ddb524983dd1c1d9c524007621f5726c38806002f3989438fa1259c77831ead2793458d161c1972e7c76f2d337df7de3f9178e1d387c10b27ff7c8ef1f7dfcf1ad3b76bcf1debb97a222e35292e9bc260463e92dacb8824d5183584a76695f64b03bcd1d1e177ed0c1e19e9131e63d53d33343b3736373d72616ae4f2fde9cbde13ba7e117fc5796bf2fc10afe2fa9fd89047f373dff0d9dc28460abb39704fb4af4dc575333d727a71727a6ae8d4d2c8c4f2eb34b820787a7c92b0709865d4e30bc722bf1ed826f77bc7c3deee39fbef67965ef64f076f37b2ea6567b19bb70498b2e46ee4407b34d8a4e8e8548f20a91249b3e6a101c7111737cf5726cd885f0e090c88b110991a1e12117c3822f849e3b1b7cfaf4f953274e7ff1e1a71fbcf5de9bc75e79f1f8ab2fa15fc37639212d15094ec9cc4ecfc9635e2caaabaf178a04728544a556eaf49c5d8a2fd91d9c9c1e99417d9e1f9f5f9cbc7a63e6dacdb9ebdfccdff876e1abefa85bbe7af32f60996096dbf3cad9e58e00dce4ce677167a4314193c50856e83a3cfdc3a3b3d3b33766e76fae143c3e0f46d051b3e0613f2678bc6f60acb77fb4a76f84bf59e29fea5a3a97c909ee1a6258e67849e47f11cc2dc3945da6ab623b67528b3d129de2005d5e3753a20908468705b518e115a6493308890cc51c09c624382ce4624428b87039f874f0992fe1f8ecc92fce9c3813721edd194a7a627a0a094ecbcecd292c86ddda16418b4c0ebb8a369dc66832d8ec665707ec76f4f6770d8d90dde1e9d9b1b985f1f9ab930bd7a6af5d9f5dfcda6ff73b52ebe76f5c23cd0926bb9c636ec209a6f8d219e9e9f99b6066e16b808d90d5d90dc1ce8edee582af4e4c2d8c4dcc8d4fceff946048e5805d4e700f764a0c988ce01ef6cea1eede41a2ab67c8db3d4874760d016f773fa06e99a07bd039af84b7f1f5e32bce9460d464441652999398b0dbe9eae97233251a21a6d771231262c2e2603a2a3c3efa62c4e5b0984808bb14151e127e0937b11863723eece2b9cb21672f059fbe78fee48553e04ce8391c0438267064e0fbc4a727d3cb09d8f8165756d534b73449a4e256955cdba632b4ebad36d8b5ba99e28cf8760f8f42f0d0d40ce20bc113acdd99c51b73376ece7ff53509bef635eaf39ff982f970eb2b755b1cb8c9051a73b2cb9e8e66d4c231764483a3b39ce0a19119a89d99bb3e35730dc031ec4233dfae5ff0e4c0d00449e5d47290e0eede61720c58af03b70bf6760f9360be5dcef14fa9e5fa674eb0b7ab9b017e3b7d82a1d6eb71826e6f47404a4e1a4b466a6e26c6c4ccd4b894443aed0cc197a32138f25278f8c5cb97416818738a035bde2f83cf9ebc70e654c83968c6c28c7023f12803b1a989716949c95999598505b925886f2d8a33e22b556b5af506adc96c743861d7dee9ede8e9edec1f20c1549f7f54f0d59bdfc3eee2377fa13578995a76ef449b603a31c93fddc1bf39cbbc26e13b8b397bf51b123c397ba37f78dae2e8826097bb0fda20757a76910403d8c53dcb05cf0c8f4ef305f3d5fa0593d461d6f110c5972f98e7789875ecdbe972d03dd8f832f81be61570fd33a0047bb0fe32a7a0997517823bdd0e00c7016939e91ca9d9693c3252b2d2933252e3539953d091f171e1b148687468644470d8e5b317434e075f387bf102328d663b2a81f940436c72027a2bd46714e782d2f2e28aaa068158286d516ae49a7683ce6c6ab775989d9d564f2f2a22d5e7deb1b1c1a9a931f456b373e3730b4c71befe15d9e5b8fad537d76e7e7bede6f78b308d28c3ba9f79acd38bdfcd5dfb16da0026b8492c5cff9e26ec57bfe3bd1ecc641776018aadd5ee954ab50e47f7f0f0ccd4d4e2cccce2d4d4d5c9c905e04ff02c805ab23b343245f40f8e127d0328c5c38074727065997f13a629b29c4e0a2b5c2e9db7f20b664e66f95f4b70fbcf39df5e9ca961a604d3d2eb713b01390ec82eccc92ac80699f959197999e9b9197eb2405a4e264c2767a6c174627a1ae445272445c4c623d9308dea8d1aceda653eab827f8ef4e3b0c82d2e2a282b6dc2a6482293a8919056a5ae4d67315bdc9dc0eaf1da3abbe833610393e3786249f0e4dcd5d96b37105f724c3039bec138a6119ae175e1c6b7241813389e5bfc7af6da4dc0174c6a39f7549901ec022cb728c87cc143439350eb13ccaec12498bc726a11dfc1e1f181a131ce2e09e6bc42e17f61855dd2b94230579629a67cbb2cde157027ad9857fb59b58c5d98ee74828082f282fcb2fcbc92fcdce2bc9ca25cf20dd999f93944465e3620df2039232b312d233e35857d71299e7d17401c48ce4c894b89479dcf2ece47712eafad41716e144b646d9a36ab596d32e96c3683abc3e8f6780606bc4343dd2303606062646466627c6e7e66f13a3c4dce2dfe5482e7afdf84633f4b8239bb3ec78b5ffbf0abe5db65da2bbf5db4ca83831356ab5b2a553b1cf88926915a9468d825c1f4fe4b2ebbace309d8fd29c194515a23b181e9428962e1b634be5d4df7f27689b5cb4176a93873f1e5bf9ac4bd8583c36fd7095c6e078b9d79299925a0b0a210f03573a659d9b99c665fa6b373b1ff41938c34a37a23b2d83113c9d9a9190539705c565b59dd5c0fc75a9351a8d522201abbdde0663ea360eef4ba067a6d3ddebe89c1c169d81d1b9a1a61c3730db6a617906054e91b5c8201499d5bfc8a2630cdc9c68404cf5cfd0aac74ec774f6a89d9f91bb0383d7d0dff4908b6d93c10ec7476613e31314f4beff8ccd5b1694630c3d814181e9d845d120cbb7cc19c5dd2c99d255ee1987ff678d96aca7af5bdb4c0bdf6c74ae55ecce760dfa2c57fa78eff6d59cb053b3b6c1c4c8239e098a1b400f865176417e691668a3204a766e5d05a4b82e993c118330ab2d2f2320a2a8a20b8b2b156a251095b15cdad9a26a5ba4eaa90b79bcd9dddd62ee6a3f89d8383eefe6e2478787a746c6e627c7666626e767a6171e6ea75989ebeb608cd1ca8dbb0bb4230813b99aa7ef53afe2dfd73dc24a954ba39fd3874a6e6af83d9f9c5e9d9abd3d30b5353f3838363365b874ca672b9bc0303a31313b393d3f3e393b3b08bec0e4fcc02ce2b175c4aad8fc1e1de81a11e6c07fa06b8b09245be63bee0158ef96beded7661d4ffbe3b2fbdb192ff063c9f5db78b85d4da81c3650576a7052c13eca3ac9004f3ea761e17e5f4dc1ce6ad779969d8efc22bf3a1ef74e65db4ec87fc5373cb8aae34d6d60a5b1a24a2929a9ae0c8c8b73f3bf1eceb6fed7df685a75f79f383931762d2f244adda818919a47690f97827f61d93b38b0bd357e7e078e6da55d8bd4d30aa37e39893ca417639c1e49860fa2ffff24c76e91d963373d720786a061df2fcd0d0b8ddeee6048f8fcf4c4ccd8d4dcc308ef1138e4f31dc165c5f591e18e280607e295e7a096ff939c51fb1eb37ea7bdb0daf262f17ecf1bf1dbac3d5e15ec2a7d6e5ec703a5c36169f570237038aae1401ae5073395e5eaef98299ce2b252b352983f964435c5a3c46f64df0c9f9e585a5b5954555e5f562714e69e98727befc32f8e2c98ba127422e7e7efed2f137dfdffbd44be0c8736fbcfbe1e9768b7b686c6e7c660e4fece834eae2ece4d5d9d91bcb04d39c04fbd3e963855dee5db19c60fe11c0173c89cdd8ecfc14cbe0c818aa1827786c6c1a8e4747a76017a02c137cc79c6048e5e0e2bbe235da9f2acb7cb5bef769f092ca0966ef5cf6be68bbcbd5e1ec6080d325ec2ea70d381d56a7d3021c0e33a0794049550928ae2c86e625bba5795c95e6755e2498e9b153735293fc17dc20c75925b9d9a579150d35f5e29688c4c4d7fff4a753972e6795962564e7649795671755bdf5c189a0fd2f1c38f25ad0dee3fb0ebe7cf4d81b754df289d985b1e9b9e1e9f1898599f1f9093031bf30b97095cf3436c70bf0c74c4827279b75b9c87ed52798be8a917b00dd89afa24b07b0cbe1132c6f75ba3c24183082d9096777457c29b2ff5d3057a2b940ffa8dd1582c931dd8fb9039d12fb667702766d4e6787c305dc4e27d1e170905dd2ccd9b5db4d767b3b0828ab2d2fae2a29a828cc875d82bd121646f88663128c118ea136bb281b76b37273d3323313531392d3939232e3d27293f22a0a2a1a2b0bab1ad20bcb0f3ffb4a54426654423c364bc5d515a8dbe979b9478e3dbffbd05327ce5db818117fe0e9e33b761f08dc77f84c70e8e0d8e4f4dcdcf0d8d8f0f8d0f4fc14328da71e3983513ee4989bd34d3c6c853fd6341d0a8b04e6945afa9e933373607a6e01e3f0d884d9e650aab558b2e069647c123f0b46aeab22c7504ba9a5c60a5d1573e2a26f8013bcccae7fe7c37f4b0646bf69dadb7898b74ff15a24f65dec1e7e29e6220b6936a71d581c66b3dd843a6c775a1d760bf2ca79a59b18ed3633e01cdb6cc6803c441695b9a2b00821ae2c2e64cb35d422bb5c82b91063a74bd7c9ca29ca479a53329293d21213b362328b528aaa4b4a6acb2a9b256f7f721282cf8444e108484e4b2bae2a2fa9ae381d12fccc0bc70f3cf3ecc5c8e8b894cc2fce043f73ece5a0fd4fedda7b2023b760787262646a1285ba7778606c7a961cf3f1b9811516d2ecd77695f7c994ab2b0e023a0ef030eeb8999c9999989e9e9a9dc538343a6eb2da152acd4ac1e393708faf328c4cf0055371e6da637e76b96d0fb7af25c134f7ef6b7ddd2f6397fd4482efd3822e07e0920afc7619b5369715b0d77230c3aecd61018c6676dd25b5040966e3cbd8b55adb0310bbb2fa0aa8cd2dcdcb2aca01392579584df3ca0a00fb29b4fcece25c74c8e9f99920ad202d2927097ba1a4acb484b444acc4a97909f91559e50d57f0adaa9b257b9e7aeed9e36f3e75f49577de7f1f8293b3d36b5a1a2213e20f3ff7ecd1175f0e0e8ffce8f353bb0f1cd973f06908fee3d61ddb83f61696556025f6f6f78d4e4f0d4f4c8d4c4e8f4ecdc034469a8015bec92e0b260bfcc4df7e1cc0eed271333d3d3e3545e3c0f0b0d16251a854568703da20952f18051c8231f60ff9bae5150d33a7997b5d964de78ff44dbc8f9f709175d1c77c7dd763703920923413a4d6eab031f82ee4c05c90056aad7633e01cfb945b4da496bc72047c117ae654f885e0b8b088b4b8b89c94e4c2ccb4929cf4d2dcecf282ccd2bc8c925c9056949b52909d9c9f955a989398971c979d109f9914cd7e3e38190d75514a595d61fe95c27a496365a368c7bea78ebffceec79f9fdfb377dfb1e32f84c5446717169455d5ec7feae97d879f3ef4cc737b0e3e8549d0fe435b77ed468277eed9bffbc02183c506c70ce3638313e34393132c5360786a1a8ccecc1274da8b03da96d2b91c128c2f8dcd4ce3d00198905a805d51ffd010f66ef2d6568bdddeddd78765626c1276c739c17cbb2b5a656f4f4f576f2f8139bd6986de37439f39e0ef6a78bdd2d2c7c56097aebc4113069e63be5a049785ae94c6146a8bcd448e094639ab93ec5a2c06b3598f9111fc6574f0a7974fbf7bf693573f7ff7c58fdf3afee11be0d807af83173e7af395cfde7dfbf4c71f869cfc22e2fc99b84b17922222d2a3a3326363d3132292a2a3936392b292d30b928aaa726b8475579aaaae3408030f3eb373f791d0f0c457df78e3e8f3cf1f7bf5b53f7df679427ac6332fbc78e099a34fec0afcc3e35b91dac07d07a1f6c091a3983fbe7dd79bef7dd03b343a3c31dd3f360aa09903bb29681e999ee1e0cb26c17c38d94c7ce799dd17d46209605701a8454cc7318e4e8cf50df61b4ced32a5d26cb3b19fff1e857556308af328f20d609704b3c1c52a8bdeb81b4657408291606e4da57acbff60207b73a560aef632d8ad90cacf2edd0fa3261b73f93bf6a249260edfbfb21981d1ac37b146c9aec9a423c70169e5b9a9653929a5d918417249565c615a546e52685a747072c4a9988b1f879e7ae70cf4bf07f147df7df9d9b78e3df7f6f1e75f7be9c5b75e3b15723a3537ada022aba2bea8baa5aa5658d320966fdb73605bd0c1b894eca8d8e8175e7ef1b9975f79f18d378fbef8d2ee4387ffb87dc7938141bf7fe2c9df3ef6f8133b0221f8a9678f7df8d989ed3bf70245abae7f70bc776418f48d8e70f48f21d6135c945998cb308051d628d570ae98fb4af1dc2cec82f1d999db058391f1d1de813ebdd120914b8d16137b058711520b3047be89bec1c1de0174557d5c58b9bc7aba3a39a86ff22974bbb9a5945b5949307db49789295fb0dd4af8bcdaad669b854600bb466bbbd16a00ac690e56b99501828199057609cc03528bd293f253e2731263b3e201537e73924164465c54667c785accc5c4f00b7197cec7867e197eee93e0131f9efbecbd531fbdf2eedbc75e7ff5cbf3a7988b8556e694d715364a1b9a648dcd32c59b1f7cf4d8cedd475f7a2d2c263c3e35e1d3d367dffbf4f3232fbc70f8d8b14777ecf8cd1ffff8d0a37fdcbe67ef8edd7bb705eede7ff0c8534f3fb775fbee27b6069e3c19dcdb3bc65d5192e8191eea1d19ed1b45942728ca2ccc2554a079d46f972f187598805a80096797b97f721cd9e504ebdaf522a91839f6f6740d0c0fa28860f467779013dcd3dfbfc22e75c27cfc76ddfc0698b5ebb1bbdc9893726a9d5626d527d84ea0a2a0393059ad26ab19c06ebbc5003031d80cedf676829483760b63b7ddefd564d272043488ea883a410d5258d974a5a2a1bcbcbeace04a7e7175516165417649563a16e6828cb88c84d0d8cba1899191e9f1a131519f9cfe3224fc225aebd29afc7a51659da856a06c81e0f8f4ccdf3fb96dc7be036171e15149d131e919618949a72f5fde79e8d063bb76fd7eeb56c4178e1f7d72dbd65d417ffaf0d353672e3cf3cc4b3b771e080c3ce474f6d055e6ba0607004dba87867b867d39866316e6224894637e23e633cdcb2badbecb6e4e8e0012dcd3dfdb66d009252268eeecf692e0fea10102059c1d97d95da1165257085ebec3c1e8f60ba6b3c3cc5e153d1d2c92635f46ad08ab8dc01c76d11c60446901ed6623c372c198905a82041b8d6d005ecd6666341a3501b2f656b14e2ed0485ad4e2669508342a050d8a96465963bda41ed4086baec07a6345794379714d31dc5f69aca868282dabc3bc04605e23a86c910bea84f5326d6bada0716bd09e2703773ffff25be8c1a2b36242932e9d0ebd70e0d9235b77ed7d6c5be0ef1f79f2777f78e2e1471f093ab03f3c2aa2bcb2223b33fbd873c7763ebe53da2ca5ebbd7a7a7b986b46b27461afc95edaa81f2d8fbf5c6304cc7a3c353b323983c51b60c2324d7d388057ecc13870736862787872047b6e00a978e2243289cea0f342f0d0000597e81e1ce8191aecc201c75ec0d2ddd34d1feba34ff6719f00a3ab2471d7dcf06794b14850a5e5afa97cf00390450e13731d431345d66441ed35b49bf406a38e804b8359a737b5e98c5a0edca43bf5ed5ad0ce623068f47a7580dca8921a94a23699502b05302d54895b94c226794b83b4a951d68cb156540fa88d42c46b04d5d52d57aa9a2b680475a2ea2669b3442d152aa5f236556246d6ef1e7ff2899dfb4e5d088b488d0a4b8e8849493872fc59f4535f9c3ef7caeb6f3ef6e4b6f73ff9f0f78f3f1ab83f089becd2b2f21327bfdcbd737f7971554777278063e6b2beec4725e9129210dc37ecabd5588691639a707659a6c82e07791d425b3e31ee9f0f338e59c15838519cc5328956df860822b27cc1500bc76417071cf7a14d82bb5e0e77d51cbab686ffd4c412cb8b3003bf515a2198bb498281c1bc6497c1ac5b2198f16a6a6b6bd7009d81c1e0079a03142635422cd12b9063699b5ca295893552915a226815352b04308d119a093886dd06493da817d7354aebeac535b0db20a925c1a256191c378a25cfbef4f2d6c07d3bf71efaf8d417ef7df651d0c1037b0e1f7aedcdb793d33252d25363e2639f397ef4d5b75fdb1ab82dbb30a7a8b43c38f4f2ce6dfbf273ca9c5e177349ee2e0fa0a7cce1f1babb7be92a65b41e935da499e9bc26a6d957052601042fe14f2dd40ea2156761e743103c303608201582b1066b745a14582cc9be15776890d4c231d4aec8eeed82975dfdca5f84017fce754c6c41f6adac0ccbede2e701cc045e59f4269dce089d48671b0493cedbd1e8555a839a0423b83a9d0a2323b8d5a856b6abe47aa54ca780604082c9b1a015691635c905a051d6522364bca29902e8aa9ae50d70ccd895d58b54c26679934cab50b56b146dda7aa120e8e0a147b66e7b6c67e0eec34782f61f3c7cf4b9cf4e7c5e585294981a5f7aa5f84ce8d9fdcf1cd87b64ffc90ba70acb2a2e5c0ac31a5c5454e5e874b28ef1c475989d8e769b15239e38df85240787e85ab1300d9872cdaa1d1cf34d9660534b7607b0f51a1dc1c8ce07e1b87f7400402aba68acc1108ce5b3bbafc7d730a30318e8a705823ea5c9bf408eeff3f62baea5c27e209fb9708e4fa79ddf31b1f8bdf29755b3516f59026af1f300d2cccc59bb6ded5a8235adbd1d64177629c16dacddb6b6568c20406dd6ae704c82317282a116821ba4cdd582ba464953b3ac052ee1b845d18c096bba09e2d16429f5aa669900555aaa515636d4efdcb7f7916d417fdcb1e7ed3f7d181997109b189353909d999b5e589a7fa5a1f2d07387f71e39f8eabb6fd207538382f61b8d363bf688ac639bdb6eb0a24fd0b7998c06ab052166ae16d9cf00cd0493e6b18925d8989248ca2b20bb7d23c3187127bcc271df483fc08615ed1504abdb34d8ba74f576fb5a2a76dd457699cadcd5f3a38ef9827d174462e17aa8154d13db125bd9bec9c22515b4990c3a733b8139f3070b58c7003f1bc0f281e30f6821af7d9954f20a105fdf5ca7d2b25ec9b156ab0cd098d56a934a656c551a14729d4cd6269568c4008e519f09acc728d4705c2b6a4029463f05a01946c93146855e2ed54a040aa14c2bd79a756d163dca756563ed1381fb1fdbb9f7895d816ffee90308cecacbcc2bc947ef9d969715127979e7befd079e39fad69fde7ffad8f3e783cfbb3bddf64ebbc3cb5cd5cdecb4e017566855728d5ad9a6c593c85c0594bd2a245d071620cd144d0edce4eee17cc36eeff01046cc7b47fb1986fb80dde3d2b4ebf882a932d3badbd1d3edbe4db0ef4a66fee0f2b34b9a39c19c6392ca81f618184c26426b84572301bb1c68ef094e30e358ef4b3364038d1e6ad56a9d0af826da56a06b53eb751a8c6d5a5580caa800aded72855e2ad749a45a11ec8ad522a10a6a5b4830b718d7891bd0736142f7a01d6397ea66d0801c2b9ab184a30c280cad406bd52bdbd5f552c5532fbef287279f78327057d081dd1f7cf661647c4c6e71416e49694a76cee33b03dffbe4b3fd470efde9d38fac8e76478799fbc306d809a8f45ab152d62295009dc982a76fd93520bbbae198cc91574cb839579331c19a0af048663ed2c730d40b5608c65698b2fba38257d4648bb303f852cb4b30161493c36eb4db082c31283f1c7a8b99d0994d04cf6ebba6dda036e8d58636fc5418018c9260fc848072cc4955b5b582657356b056d30ab5009300a54102147ab15c2762ed0ac56a018b8809280b5f70bda4916e422dca381c37c9a1bc190784482d4285c7fdb08bb2af3269f40ee6aa936a8b35242a22e8f0c1c7776cddb12770f7c103c75f7de54c48d82727cf9e3c77f19d0f3fdb77707f6d439dcb63b6d875dc5f35d05bf50aadb2452aa817b4d4e147d0b4192c36eeaa5274fd30388612924776f9b2c93126d43461c4bc7bb81782bb077b80cded24c178e238c1b4f432c599154c65f9f6826c76b800e7987ce31eb20baf1ce4956f97eff876c138ac89db0533f875b66a95802f98c9711b1362943cb54a013009c8cb4929cc4f2f2fcfabab2b1389eae4f26689422096b7885b5b04f246616bb340d9d4d85a5f23ad6a5235548a2a5ac4cd229950a8108a5bc5528d4cac9250c385e3008ed148cbdb14520d53a5557a759b49d7ee320383c32252c96352538fbdfefa8e3d07d15d6fdf7d60f7c1a78f3c773c2e39ed74f085d8e424a3dd02ac1e7bbbc344a35825af13365535d457d6d7354bc428d478eed82bb43a31415630478b4b7f6b8114f2659366dca4a689b63d34c7c36011bd1bca197d676b8783fe220746407f8185ddb031d703c623d12d53ff0cc126bb9333ca6a86ef0ea3cdd98e2a64b5e3402468ae375b012a10e05caef04a6afd098663545806751bea6c9b4aab06ad1a158752ddcaa05110ac69f8c6444113a546ae50cb3009d81fb4fdf0bec0e3470fbff7e62b5f9ef8f472e885d8d8888484e8b48ce4dcfcac2b35a54dc23a894ad0226b6892d4955415b4c85a18b56a29804e2cba28ce8db2468c825601028d100b9562799b120d97ce6ad0d90d6d36bdc169327b6c4697adb5bd4da256c05cb3542254c8656a2562949693f9c1671f8b95122cbd46a7d9e2b6011c2278584d4b43794d3504378a8452552b0e798a08028111a699ab09757731e743587f24980f77b2822f1823fe098e0fa86d128bb0cc5b5c76ff3916c631edc5d9dd9a97bf29624e68f8e3cbe4d5ee6471915d83c5ce97caa96d339a7db04657f0a38239cd2478a55a75ab42a554a8e51c24159066d805b819f0fb071ff8dd03f7034c1e7df8b74ffce191ad8ffe71db1f1fdb1b14f4fcd1a3efbff3d6d953271313633232922b2a8a6b6a2a6a9a6b9a244df00abbd491d11a8c468c166c760156b51a356aa316922018859a34eb1d7a6387d1d4613438f4ae5ea7d96d323a19f24b0bc2632332f3b3907883dd88f89a5c368d494fe7c5201821ae6b1608a472a55687a7898a1b1c4336b351eef4ac70cc873b594129e764239ad60e17d4e2d091a955a807ec7ed7778e056a31777adde4957fba8a0a32a935da1c2c8c5dbdd9a63359c92ee595d46adb4d1a831123c36d5ef125b5be1da874549f51f9744c9bb44c30caae46a956b3f8edaa9472958c8fac552a574949ed92e07b366cbc7bfd86bbd76f62d8b4e5bebbef7de0defb1fbcef01f0d083bf79f0befbeed9bcf9770ffe7ae7134f7ef1f187f95919589885ad02b4cd0013dca4339a7462048b34262235d666894ca78469f4596d3643bbcb04cd106c729b1cdd5657afdde281e6366ba745676bcb2cccc6e6eac4d95358755099419ba51d28b41a2cc0b05bddd850ddd0d428148b15ad708ce785f64e58e1e0184f3a04b07ff5a8978b29679a96553af7c9355018714ca0004070835000c1f83e7436834e9fd1c9c8952731d82b3c5371e60b466ab9a4725e09b24b0a31f149f547968155dbdaa6e7405101700c482dcfae7ac96eab82805720554a58c4b256093413701c70f7e6bb892d9bb66cdeb879e3fa8deb376c5eb77ed3eabb566f58b7e19ecd7783fbeebe1ba6df7ae5d5ecd4b45a6155b3bc015d98ac4d8c9d15b646b453aa69a9ad13d623c7d85fd1661a765526adce06851683dddceeb020ac2697d9e86a07160f1666bdc96541194fce4e47353e79fe4271651576475a237e370df64862a5026a6b9b5a2aeb1aaaea1b11e216894cdaaac6b38027abcd6cd2fb1de3a9673e0ccb3ae6aa31c5973b1bc59ddfa60d2e1e8fd4422d120ccd28f8dc496608a6d4f2bd5276f9f1e51cf3534b5239c82e1432018566b60ef34b316717072e8d001d257e24667fb8e455ad50a958941c2b04d364458e03d6af5bbb61fd3a98051b366e5ab77ec39af5ebc196bbef59bf6123be8407ac5fb36af38675afbd783c2b35b9aab9ac515a2354348994cd22a5a049d25027a8ab17d6636dc6885d72bda8810a381c63cba4351b506c3142307412f44784508d957a8d54a3cc2b2d51eada1a44c22fce9ea11d825cd30ac7d81d5da9ab8557120cd3cc25e195ad328db6556f50b71bb526a61d8563e62cbfc74d39e67a2e824e597082e9ac326e42218e0c084682f154e29b3075d87f4139ba0219b7bbe537ccbca5f74704ebdad1589ada70fcf9d1ea99334cea36f49c7a6a9df8fc9460994a03fc52f9dc2658290728d1b41853b966e798480336ae5b0379776fda00366f5abf71c3da751bd621c69bb66c58bdf62ea8c503b6ac5ff3eb7bb7bcffc66b9949090de2aa464935c66659ad542944cbdd2c6a6c68a9abacadb852532e528a6a5b6a1bc48d12b605d398b4ad0615469d556fb0b753f9c5fa6a713bd8405be15ed42a4bcbcb90a8656d16fd89f35f169697a0f392aa14228514fd2d04a33803d86d10309f4415b7aa2058d1a6836395816947e1981a2e448d7a2e72cc15643a994c82690e704040aaa455895500ed1b242d5d789f558b39b7ffe11a66aeb7f2afbe4bf59913cc79e5d4aae80c138396833a64be541a99f8aab5285440eea3f536144b257ab9607f886514eb8007366f7c70cba607eede74dfe60d9b37aeddb06ed5fa75abc1dd9bd7af5f7bd7a6b5ab36acbe73c3aa5f3e74dfe68fde7e3d2321a6565056272c8760a1b24120adcfcc4b7effa37777ef0f7c6ceba3afbef97269752972dc2c6d16b0af1e62cb844db6ca28d398d55a8b0691457ce1556735a2682b746a85ae157baad8d4381c07a8f9f5e29a73a1c14d6201ec36089b49707935e3b85e28427c850aa544a58660b9b64da9d3339f3936b6b31f4c650a35e5986a35d5612eb2b70bc6d180551cab0036d9d00c49fccbf7d2e90bf24ad9a5ca0ca3187127bc123832f88b2e095e61b755d3e647c3419a7d0559ade5a0ecfa13ac592158a654aed04c8239a9128598031b5a4630c7fd5b18eed9b20176c1964debeedeb09671cc0a3ef1e17b69715179d9d92989895f7efad953fbf6a3e546e3fdc8430fffe1370f3dfee8a3cf3efd74697971f995d22bf5e528dd0d927af4d868f1b14f6f33e89893abe676bd059b3f14618da65d2b53cbb1351229c4594539d00cd9d85c61bf5452594e27372a6a6b2018f3dae626acbee8a245f256891287b646aec6f18ecac6ac6d58e7a0074f3d9e77ba422bca2c7361d6ae1efa1b47dc3dcc9dec7bcde973030693054f5f439310bb4834c0569787bdccab87c0d6161bdca53318ac5d4eea8a6e995b7d4930af26fb264ab5f647516b0dad6a9d823637b49f556333eb532b53aa00260a7fb956a9b1f36d952a14641aa3548111abae02c8957205accbc412b1402a15289160f8031bd7dc0510d9756bee5cbdfa57ab56fd122358bbfa0ec4fa812deb21f840d0f63d3b9ef8c343bf7ee4e1dffcf681071fbcfb9edfdc73efc3f7dd8f39043ff2bb879f3ffa7461416e71517e5965497d736dbdb0168b34b66eea360d7312d5a0a313ebe8a1547a75ab4e45765ba482ece25cb14a2ad32a50a813d2524f9e3b9b5f5a02b5a0b4aab2a6b11976fd829512fc32ac6085068b16d3b9e069c5738de79dce3f5004e1d277fdddae1e3ab9c8bf362b7d8c406f34e3a941f14756e8542809b675a0387b58bb6e7e4dbedd2ebfa5629a647f71e69765049773c6574bf7f021a31026912bb99bfe2aedfb126b544182692e91cb316af53886d056c9e0189b2cec22cd465dbb5e1380a577cbc6f5588637ad5fbb61c3eaf5eb57ad5e7be75d70bce60e6672d72feeb8e3676beef805f4fff6fe7b37af59f5c0e64dc443f7def3bbfbeefbcd962d0f6ed9fcdbfbef7bf4b70fbdfac2b1ccf4e4ac8c94dcfcaccaeaf2fae66aa1b4498e03aead154629b5b08b1176115fa11cfdaba851d49457920fd900372b6aea5e7ee3adcf4f9dc9cc2bc01c76b1f4422d10ca14d8266165820f9432ea4a688b89e71a4f3a8598f5e4d7c99e43a65e8996587a1f2bfba9100fd286a70cff097c4fa8c2c14165990ab25fad8bfed2239dc700f4979a91f836a345db6ed6184c7cb8ca4c35f9a75c7246297f04a9e5c03d780cbe098e127c13dc64c53339a6be9aabd828f8429158add1623fd1e5ed1ceaef1d1b1e1c1d1a18eceb09b87bcbc62d9b376cdcbc7e033ae88de8b0d6ac5e7fd75d6beff8d59d3f87e0356bee601cfff27fd6acfa15aaf7e675abefdbb0ee9e756bee59bdea81f5eb7eb369e3831bd63fb879e31f1ebcfff1df3dfce64b2f44475e8e890a4b4a8a2d2b2bac6dac6e113749b0366814304a8e01e6b8073a915d814c58db5c57585e04b598374b5a2a6bea3ef9fcc4d61dbb52d233abeb1a5a44922681482891e177c3ef4fc50abf1b35294c23ca0aa60d2839264374ea984e2353274c4b2c7d4884de33d56630e0f027c1f826882977968a5b6ed9b38f0eb2cba925f8829726b72dbdff25af5c1126b5245bbed45bf9522bc6f656aa94b27d143a506c31d0424b153291542c96495093356d9afebede91e1a1e181018fcba5d7aa953289462133685401f04a6ac1da8d6bd66c58bd6a1d04df09c7abd6dd79e7aa5f22cdabeffa254a377a6914f3fbd7ad8554d8050f6ddcf89b0d1b7ebd71c36fefdef2d8c3bf79e5b9a35f7ef6f199139f5dbc78aeb030a7b6beaa45d888222cc5afd0866d8f0a60424b2f8c92e0cafaaab2ea72b28b3457d5d647c7253cf2d813852565f54d2d8d2dc2866601f7cb5395a30e8504d3fe921c53a1a6b6c8a7937d758fb6379c60f63dad0c28a7f8cee8e050f671a0d0c1c16d7ef0add82d909d0b2ee715fc6882d57aa39a7d8556a5d1636505cc9acabe0ec0adb2849cce2b2a995f8772cc4599312a5308c452ae50937e7c89fddd55e866ec2e87dbebf1767bbb7aba7a7bbafb7a7b06fafb105f9542d6dc50575359595b5525110a751a4d00b6434c7cb7ac5fbf79dddacdebd6b07df35deb5741f6eaf5ab90e33bd804c3f1fa5577c0f1e63b7e71efea3bef5b7317f8f586b50f6fdef0f0968dbfbf77cb23bfbeefa93dbb5e7bf1d8bb6fbcfad9671fe6e767d5d455350b1a850aa1143f21da699d12a34c2313b78ad16393518cb00bc7e41bf720afc565159f9df8b2aeb1b9a6beb15988835401b8a39b5bcca876a14a539fc52fd49445d2ccbdb44782a938d3db1c91367c67bf6013ea30165dfaab9d549331526a57d88557be5dc6abdea8d2b5a327209d9c5aae75fa51c1ccce46a9413425b25606b992d4e2b7e68e66aad26817d03af40d0ee3fffa06faa0d6eeb4b3e7e3cd6ea7ddeb7619f56d5291a0ae1a6aaf34d5d7935da7cde6130cbbeb36ad5dcd345aabee587be7afb0eadef973e4185be1b5eb57afbaf31728d1ab7ff573d887d48736ad7f70fdaafbd6dcf1c0babb1836acfacde6b510bcebf1478e1cd8fbd2f347df7fff2d24b8babeaaa1a55ea8143167adb572a946265149c82ef651a049d204a9c5574aea9a6ad1d38be52220924a1b5b5aaa6a6beb9b9aea1a1bc53219a4f24b34e3987d8ee879641be9762a9278d261823de3ef205518d12e9133ea8dedec9fa0b139dc567b87a6ad1da5afaabe49ac50c11074d28b42461bc60e83058e5d2bbc12fc9a4c82c92efa3e2eb224954beaedd0a926898c6004531dc62f482b2e0a0c8a4d4f7f7fef00f3a10afa5c8c418f5d21bc5a9d0ebbd366b199b14dc47e4ba9908a054d0df535550db5d52dcd4d32a944d7a6b5592d0177dfbb79cb3d9b36ddb311218663946812ccd85dbfeaae3b7f09eefcd5cfb03f5e77d7afb006df7d1712fc2b70ffda3b7fbd61354c43f0c377af7ffcb70f6cfdc36ff6076d3f7ef4f05befbc51545200c1f5cd756295046ae98545915204bb2db216a8058de24644160b308e03ffa95489442e6d1109a0b9b6a101765b44a2268180ed1bd904b3af8d29b8174235fa1582c90734932a8c80b2482fea319ff6727aacec5f7f836091445159d72c92ab553a13749aec6e8cb08b516f467d76925aceee5233b5fc267e066cdb48309760124c31bd5dadef7cb11c37f1b03676d4a0bc9b2c0e6787776078b47f68046a3bbbbb9d6e97d561a3f773592d660b0cebf50828bc623956cb910e81a0b9bea9a1a6a9be56d8dc28974955ad4a74d4228928e09ebb37317dd696f59b3763255eb376fdaa35ebee5acd64f74eaec9428251a2b165c24a7ccfea3bef5d73d7bdaba1f917f7af85e65f41f06fefd9f0c8af1f78e2770fef0fdaf5c2b3cf7cf2f107d82cd5355636345763b9a545172e9b6502d02869064dd216803b4babca5ac4cdc82e6317c558a9845dd4282cbd28d768b244523953a2e9548dff39e21c4330b64c78ae11238c882f9e6e38c6d36434dbe9af70326f1837d9684ed905b847ab3342700dd67999b2b5cda833d939b50037db8c366dbb954363b000b5de8ca3016042d925b5f83198cd9b42c32197aba552269a5484c9288515bf0bca06b6f538785b2472994a8bea32383c4e578f18199b82e09efe414f67b703bb35abcd64b618da8d3abdc1a06d6f53e95a51cca472894822168a0542518b4058d750d72c68160a9a44c266c8c53e58226c419a7d5d34ec6eda84167af57f158c56eb5777affee5bd6befb867cd2f0009be7ffd5d48f0ef1fb8eff1df3e04c12f3e77f4d34f3f282eceab6db802c1585cd148fbba2ab9b041dc542ba8af173592630846896e163509a5023af982a61f9d2d828b420dc158902098b60d4c27429d246b9a1cd3f34b820113359d51df6ef929c1504b7f9793040bc5f26a1c4a5205be09fe2dec22b550cbd925a9e495d4e250004a6d3b3b31506526bb24185e09fcb45c038c919615462d7b278ead16a1149a51607a064746a76661776864823ecfd8e9ede9707b6d585cb0e8b41bdb74688db5ea56b54ac164532a96422d2a9d003168696a6c6ec4c8386e6a1409055289b0b6a6b2b1ae86110cbbb70b06b40f5ebdfa57107cd71d3fe7046f59f50b38be7bf5cf01ecdeb7e69710fcd09675bfbdef1e083eb03b1082bff8e2e3a2a25c12ccd46176c54565060da2863af635093a9d897b0aca0b9a840d02245c815f59844d1e4fb040201693606ab57ccd089b00a6054588d1d768f550cb8c5a03bd4b186a011492669dc14cca39c83a4ab44024abae6d84663a4a5000907e78855d127cbb5742ae466a19b59c5da4109060ae08934bfa9999f5952d3fb807ff45f8c6cf30303446977de91f1cf5787b5d6edfc51bcc16bb116b8da15ddba6c30657d98a065921432f2244660542418ba0a5196b2d8cd637d6436d435303734ab7be0e77e2ab4d8d0d4a190e04292378f3a6f57cc1e4188219c7cb05834d77fe0c8eb7acc2f833d845a1be6fdd9d68b248f0c13d4128d1274f7e0ac135f515104c22b1e2422d6463ac15d4d58b1aa0160d36c6dc925c6c9785d2163c158c6065ab442a43cd696cc261d98c895022c1620ccd54ab19cdd470b18229ca50cbbc6998b54b1b1518855738c693486f34a51cd387f1e01837f13064a8aaa6019a912dfc5b2cdec831b7c4b2858181d4b2467dc854f0aae7824b76a5ad4beb2bdb40b58ad8c3961c537dc64d8c38b6988576680c91ed1b18815a3bf3a7803b105978d568f52a755b2b0e1765ab5ca154f8232b6c110a9b9b09411363b7b1a1bebeaeb6b6a61ad4d5d6c02b1c8b0522bd56e77577a29405307637ad87dd8d1bd7f04b3427f8ce3b7f8e268b6da41936def13f9beffaf9e6bb30fe0fadc4a8d8bfdeb4e677f7df4b828f1f7dfaf4e92f982ebaaebcbea90aad169ae4aa866aec85ea5aeab1d3c558dd58d3246ea69d52667e9640d2229209214e2213c995721ca62dc216941d08660c8bc462090a35c332c1ec96894e2cd02905ec9ad46d7aba875ed2d1b367ffe96c30267af6439668638c161b6ee2f158ec2babeba119c70a04c33a0e0bd403ae4fe6e2bb42306b779960d89528f9dd938a2f984a34d5671c6d5d3d0350dbdb3fec7677dbed6eb3d96132d9f568d6f0dd142aa94c49159880d71694e00626adcd0d0d2d8d8d04e98457120cd9882f461cfb2ebbb3bfa7af4dadf5259804afb4cb966812cc869881046fbaf3ff05f7acfa39e004a3c982e063cf1c3977ee4b08aeac294595aeacbd52555789cd6e49652946acb819799989e949354db5908dd5373d3b0d82b106239f228940a9400f28c142829f15bf141a0718168925009a11659625c7783a144aecc39498285b3598ab353a1cfb700cd374ea9fdc331ffc603ec6c500c7b889dd081aac2bd5b568e5f0ec2355947b4a3c7c63d4b499805a6b5469da5bd506a054e979b471fb5ddad1f25991609465dc8925a3a76f08fd5477f780c3c1fcf95f53bb45836f827f2296b734a10b16302fc1d63712f04ac01cc01e178e09dc84602418e0cb24582a119b0c0697dddee1704845bc2e1a8e6fefa249f01dbffc1f085e752772fc3312bcf18eff07dc7dd7cf48304a34093eb47737121c12721625baa2aa188ee3931240526a726e415e4965797e69115d31afb4aaa2aea5b149d09c9a91865e01c728152105022c1589454228c68f0bcff82aee478e19cd52ceb15f331a6095167631d244db6640ae29b574ea9f4e166ad90ff7b4e9da757a231ce331d877d537b55454d5302716146a546cd825af0494c32b076757d1aaf3b374e282b24bdb596e5fcb0926e5f8fec8eee0e01882dbde6ed5a3f8e35f89e5f8ed2115407043ddffd7de7b70b595a75b9f2a1b500e4739672492082227db0483c12463704ed8608c0926e79c73ce41e49c8371c0b1caaeaaeeeaeaee7b6fdf7766cdac356b3ecabbc5e9aed5efcc379835b5769ffe231d044bbfff7e9efde8487813f1687971195a595a595db62304482084f6b67749ed6eeda0ca6d81fdc63a7c4bf6e3bdededb7af5f93f3f1978f6778508ab351673468f57a954ea754febf19ff0bf07995b60b3df80fc05a211b8cff008c120dc0e8c1d5d56548d1b3f313730b935dbdbdad1d1ded5d003c3e3137db3b3cd4d6d3dd3d38303e3b838eb1b5bbdbd3df8f328c526cafc3fb9818f6cf016f23f19380c11e8ce1633be3c37fd66a3466080b58766b7b6f7068b4a9b9adaebea9a3b367756df3f5f9352cfb75caf3724d1673b27a033f79f112f71e1d9faead6fcd2d2c21aea31ed85d7edec5df911f0bb1d3fd48baf6dfbd0bae185b49fdfbe446365d4c5c105993c9304502c61101febffffbfff8dbdffef10d59fdd34fef51f34fde1dec1d0130d002eae2fcf2d2c20ab82e2d2cd9666dd0fcdcfc826d6169710175d86edf8df5d3038494f336b6bb4f62de21b5bd05571ceeed208cfdfcd3d71f3f7ffcf4eecdc1f626c5eca6379a35068352a7936b345285422891f321914c2051888462824bb0443cb684cf95115c399fa711f0b4424223e040a00bc67a31e1a696b9ea34c13e5ed197c392e363ebeaca47467aa7e746a666875bfb7a9aba3b3b07fa47a6a700b56768b0b5a30d42e4b377d9ad8d91b191f5ed35f460946bfbb371b4bb7fb8b3b3b7b5b9bd8e64881300180edec1bd8730fa068e07a8e5fb684e072747a7ddf54337aede71d7f93a2b2cce0a0f37ad4fa0f572e2b5f4daaa96f76fbebe79f301cfe31f2ffbc1c16fdebe4334fdf2f547e4176c27009e9d5b58dfd8262b017905f7dfaff1bd79f7f5f0182cc1f51326fab38f3ffdfba87674f4868ccdfbfb4810aff7f68e91224e0ed0410f8fd1748f4e6147fc9483c393bffdfe1f7fffeb7ffefedbdfbe21d5bffdf8f6e4ddebc3d3e3fd939d8d3d686b6d7b716e697a626a6e7a76d166b3cdcccc4c4fcdce4c939a9b9d5998b7c1ca28d487bb47fbdb07245a84a9433c61fbfbe742ba46f8dac038f5d3a70f9f3152a1d8ed6e539c5db406935aaf5768b532a5522493f1c53242aa104032a5fd620387c71472ed8ca53c0e18abf95c3056f3d9000cba1a013a31e1aa92bae9d5c13e96ab57c201b8b6b66c68a87b726668627ab0a1a3a5a6a5a1b9bb7d6c6e6a6e7901257a706408e5fafc4a2000af8d4d8cac6c2ca30d6fee6eec9dd3dd3bd8fe0330b4793e0f03fce6f6daee3eaaa97d3cc06ec53358f4aac4c714ae1579a8f8ae6a819b52e8ac12991462834aeaece1ea535956071fe3f93d393d27750630071839ecb9141e7f7fb6b37bb0b9b56b9b5f42ab0060bbefdf7d24af13fcf1eaf1fe21264f0cafc847f6b1fb8f627b7a7a4642b50f4507afedda7f737cf016ad14bf2cfa28acb9b9be0d6ba24e7cfafce37ffce77fffe5f7bf83eed93b3b5d08fb606f6b7f67637773756b797e657a7c66786068746864627c0c1a1f1b1d1b1d81b0989e9ab4cdcd2e2f2da256a3ae4164714696065acc42c707a87e3bf6eebdb9fee1dd9b4fef4ebf9cbd3dd9df39dedba6802e6434a244cb49c072b9000b98d80e58c265f368020e1380e55c8e82c755111c305611ac73c638a213f35c9412778386047c23210e0e1e1cec1a9f1a80dafb3b1b3a9a5abbdbc666c6e7976d1333e32313c393b3132b6b4beb9baba038313586db61df8d9df5ed737e7684bb9b24e0357b705cdbdad9808337b65631c2a3f32052c2d56b2b9b1e6e5e729e9b846d9612ae029691c7504908a384af11136a954c6371f59a9e9cfefaf92bfafaeb93c3e3e3bd4f9fde61e4f888defce1230cbbbab6bebcb23a3d635b5a5e83c950ede178e8f5ebf7d0c9c919f4c7cc63efafa07884ad72068382e8d6c6eec4c85456467662dc8dec67b9e5c5d545f965d8b73b5bfbb8776fe7701793c1090ac657d0fdd39f7fffe9db2fa00b5b23e522dfbe3b7d7bb48f667304c00bb38b13239303bdfdd0c8f010b80e0f0d0e0ef4f7f7f5e2882f61689818b57a6571790d5df95c08d2408b1a825feb1831f4bc8703f0fbd7473f7d3a434d7c73b44f5169a5108ab34a25964bf9188424129e544a88a43c30160ad95c2e00d3c5044bc163abf85c258e0447c9a3ab080609183e362b8424e09808ccc1f1f5f515246038786a616a786a189a5e9c9e5f9e9b999f9ab64d62b1b2b1b4b6b502a8403ebb3083050a354cbc7d2e103d07bcbab6b102c0f637dcedac9fa0971dec6e6dae9193435b73b75ca29189cc7c8e56c0d5f0584a1e4b214089614b855cb99027d62874d11151d8efcb0b0b3d9d9dcd0d0d7ddddd1b6b5b4707182b8f213cd72b4b6b9353b3080030ba3da99d9e91688f8fdf9342adc6fc0d7f43b0e61b94e5bd637b695dddb99f76dfd7c3d762b278387b42268d9bc5e4939070333434b2acac767fff747bfbe0f0f0f43fffeb7ffcfed7ff405fc0ae7a7b0a8bbf7e8fc0f6e1d3077481a3131467dbf43c8cdbdfd3d7d5ded9d9d6d1d3ddd5dbd3ddd7db83457757278e03fd7d607cdee22667a7a616e6e6c80b82000cfb225501f0297ec77d54b5dd8f676f4e0f77be7f393bd85e7b7bbc4751a8c54a8d44ad9600b0522eb4339612600cefa2569380855c8684cf56c2bb021e302bff05582da0abf83412b087510bc0b1572ea5255e6facaf1ce8eb189de8199bec9d9a1b83a66da03839875cbd32bbbc3ebfba89e1182d65797d7b757472786e7e1aee5cc7e0b4b5bab9b3b2b50b67af9ddf62d7d6d6eaf6f61a747080dabc66cf8e30c9c6ce9df4c72ab991cd16d368048729203862115f0ef138023e4fc4e7089d75e6d82bb12f9fbdb4bafb79b9f8789abd7ddc7c03fd43aa2bebf0ed9f3f7e056934066c3adbec022aaadd5b27ef20d8f45c58bcb3c7be637bb7463d47d7b417d5b5ed15dbf2ada4348bb3bbb3ca6850e83562ad416ed4480d46958bd16881828222c6c7e7011883d039ddaf680d68ff6fdf9c9ebd7ff7e5e3c74f6767608399c7363337d43f08aeed2d6dad4d2d7635b742ed6dad6dadb8a9058baeceb6bedeaea1c1bed191c1b1e1c1e989b1f9d95930c6a404079f1e1f9f1f0fed7de278ffc3fbd3e3bdcd1f3fbedddb5a3a3ddaa2a0f5a238ebb572ad5aaa568a550a114af4bf3998c9e53a09395409c190f3180a82f92fd12112307c0cc05e465da8b71d707a5242435d456f77ebd070fbe858d7e048c7c474ff8c6dd49eb96c23b6e549309e5f9e01e373d2cbfdc3bd0b4b73a04b6a637b198c01d8bede588636375740776b6b7965656e7b6b1d191b7860a620ffcb22be92c31170b9422e4fc06471791cbe482011224548144aa93ad037d8df33d0a471316b2c7ab98bbbc10747a3d6c5cde47923317d77d35e6637d6b627c6a6e0637b973f384107858e117f0e4fd153214474781777e187c2bb007cbc7bf4f4418697d9425a4329544878328d54a7961935726789d86834f8a8b52ecfb2f2fff61fffdb5ffefa8f1fbfff620f77efde1ce3a14f5fdbaff77dfe0cdbad2e2d8d8f8c0c0f0c74b6b5b534369302e096a696a686a6c6867a08ffd7dcd408f29d1dad3d3ded7d7d9d03bddd2383fd936323b699a9b5e565fb5b4fcf5fbc4489467e7ef3fad00e787ffdf319ccbcfcfa70dd0e18090b8041f78f122d167345528e44ce1389582460119726e5d0645c3a8959cea30130e82a092a009be4827f028e084b4f8e6fa82bebee6c1c1c6a1b1eb1fb787a6ec8b63806cd2d8dd996c7e757a6e69626563650656697d66c1d3d2d2b6b8b6b1bcb20bababe0490e75a05daf5f5a5b5b5c57f315e595f5f38d8dfb1cd4daf2eae6fafefba395b051c059dce63b104702d9bc9e3f3840242c466da496b145ab958e169f6544bd4469549af302a455a9558a7919ba502ad9bb377735de7c1ce111e07e96675710d93c6014619344dfb4bbe640d3f390051dcbc73804e895a0aefee6fee753777bae95db4b083105e904b7812b403296a9f482540739399446283872568ffe0ecf7bffdf7f75f7ec72c777c7afa1a3be7b5fdb30a5f3e7f409bdc5c5b19411b6b6f47e3a8afa92155575d5b5f53d750d7508b455d6d5d6d0d8ec0dcdc54dfdad2d8dada0075b43575b637f77577c2ca73d3934bf373c0bcb1ba8aee8b5d09c0efdf9ebc3edc3c7bb30fba76c066b3d6d555ef6ad619740ab24493214b28618b65dc3f1c0cc0123615fa03304402461bb60376d684fab803f0ad94eb00dcd3d504c070f0f844d7e454cfd45cffecc2d01f801756a79737e6ec8b95d9e6f67aa0fd0330404224e0d5d505686d6d7e6363117471fbeaca6241fecb9e8ebeb1a109446500e632e52c9a0429504828344aa34aae1770851281542953b8995d5572a546a9960b653a8556cac7dc27574a4c6a1942a13121366d6f0b01677772740a5d10851f93e5d1c1d1f1a1bd3da362efdba7ca0324a67d92eec6eec1d6fec2f47cb04fa0b3caa01229203ca684c02829e4b00882100b0452a1d0a054ba1797d4ffe77ffd5fdf7efecbe1f1bb8f5fbea0bf03304c0cba3ffdf819db0716ec6c696a6da8abadaa8248c03595d5b55535f5b5f5000cba35d555506d4d7543437563634d7d7d554d4d7953434d637d754b535d5f4f0759ae31532dcdcf6fac2ee3973e39da79f31a6837df1c6f9f1e6d1cefaf5282fd5d83fc5cac169dbb496ed68bd532b658c450c8b922118f20584ca61383e1c867db739690ed20e63a89390c218b2623d8122e53c2a2a31f6b84028354627136600e8e080e8cbd1c7e29d0dfc7cd25fa72785e76d6c840c7c2ece8f050ebdcecc0c2e2f0ec5cff946d60697d12f5195d1903525d53edf2ea2242355802eaeec6f21616dbcb4bab73b3ab33736bb34bab532beb337b1bf32bb6b1a9c1e1ab61975ccda1de9e916a631493f0a6310d54869ec7b4937396cadc546af282a65a2d934a058450cc2104045b009329b9522953887da090ea6532b5d51ab8b2bab6b6be313c38bcb4b0042bef6318de3b39dcb5b75bc4aef55dfb67cf31826364077ea4d6cda5cd9ca739269559c693cbf80a31572a16ca503cb87c3e9dc5620b783cb14028758b4f7af2a73ffff72fbffe1799d5edd9e7600f93f58f1f3efff4f91b8660545434d18181eeb6b64678b4aab20220b1c0118786fabaeaaacaca8a525255956535d515380b477c89bb701e4e46e9ee686f431c436f46a11f1b1d420245cd9b9b9becefef5a5eb6ed6318d95ea3f8baa9fd3db4be1e5a1f37b556c1514a18702d7e61269bc625581882b1f82760961304b404dd51c4a64b792c39d72e4c522a91c0dda0f3b7b883ab8b4e63d428b50a29f95eeb84d8c8feaed6e92964fdaee999be99d97e9878726ed0b6343d333fb1b83a5f555731bf388b36bcb838bdba6a5b5d98c12f89d83c333735bfba84b9b9b2babca0302f37f35961ce8b6b11f1169397a74f9c6f40d2d357836919cd2ab7680ad399cf876f2c5a21bca9f332684d72097e078558c06573193406cd89c1a4b3f90c82a0f3f8c862844c4088bd3d7d6766e766e76ca363e373b679a46b4c1930abddafdb7b988fd7b710df37c957f337d7363656d757e7571262ae2b0432294f2ce28820a4390066b0d1d1e42c020696fbf8459ebcf98ed6fbf6fd97d3b7a768ec07bb985cd77ffcfc951406240cf178cce9e931306e696e224b31da2d16e7ebeaeaaaf27f070c6151515e525e568cdd406e089cd9d8508bd28d78861436d0df838c6db34de1619b9bebbaba5a4746fa5108291e0a8eab94e9a6e279ea844a09532565114286238d42633971056c30a6311cd934471e93266052e15d3898cf70927198101c2c6533e47c8eb34ae6a255eb6412199f2725b8328900e2f3584cbaa34c48dcba91343cd8393adc3d39d5373ed1333983f1a91fb91a8081b6a2aa1429dab63063b34d2c2dcd2c2c4c6d6e2ed9166c98809fbf280808baa4519a94328359ef15e073c9c51412e81f97f9aabba06a34bb7ef145c35256eddca5f472993e84905bdd8d5e68b49e6aad8fcee0ae55e9e0278cf14c3a8b81df8409c610c116f15842746b57b3fbd4ccd4fce2fcc0f0e08c6d761966b65fbbda87407763730713f83aa092d7e05656905a176766037dac52be4026108af84282c3b35766ae90c5113258b8552b52e8fb86a6fef1bfffdfe4958c93d313ec9a95c5f94f67ef7ef9f60dd90ad311c6dfbddd9dad4df4cd05c0e8ede96c6f6b26d5dc505787885f5d595b55515956525e5254515a5c555e0a61515e5a58595e5c5e06d265807deee6f2da9a4a6c08904631e8ec6c191d1d181f1f3aff9708cb51d55756e629fe6aaeb78c6151f33d3502bd5a281331e1502af3a223cb91caa1b2588e6cb613f95225d28b804917d01cc115c39288418550a2317b6aa542bd522260d3784c9ccc14f2593c0e8dc37212104c3428b54cd2d652373adc8b963c36de3d30dc3e3ed537313302c6d3b3136515c57373e3f3f393b3b323f3f3e3b6c509e46d182b39e5864ae926e06b853cbd986f54c82cbe3e573d7de34726f73b66df368d1f958f9f66b6aea4148d3d6a58be9bdb4918ae08f94683ce57279099651a8b5a6d1489042c068f4e653119741ad5814a77a233b94c029208c53ab5767c6c787d6db9abaf73667e7a616d79656b7d736707dadad8b25fc0595b0304f2d3e7386d69d1b6beb2141a14209788f85c369f4bf0501e185c168be0f0e54e0c3e5f62884fbeffe7df7f3fff23e3afb7edefb6b00ff448fe3f7ffff1fb8f5fbe7efaf0f9c37bcc61bb3b9b5bf69ab03c3f3f8dd28a1a0bff6110ea449aaeab39ff6740ab6baacaec38cfa15655946001d91725452478ec0080afa92c27ffe5d0fadacae6c6da9eaeb6fedece86baaaba9a0a68b0bf9be2afe2076945416e3aab51e1e262a0d31d288e14068f49653a3ad22fb299179572bec559e3aa53c8f93c3e8306a8a4718574271c557c2eaab44648a062c3e2621e139809161598590c079a13057dd0a05676b6d4a3e3f40fb4c0c1189ca0b1c9fec999a1d18981b2cac29999e1b9b9d1e9998169bbb9071757a6abaaebe40a350f7b436ae6137629b5fea197d3da473786e68f5b6ca71d4befab66ded6dace1a567e7dd17758dabb9d593be31b942c92fba84506bdcceca6d21ac432018bc97672a4d1194e54da053a93cae131686ce46d2121d0aa34b515a523fd3da893b3b3130b2b98d956d67630686f9297deb65697375796e05ce4f665a4d5d9297831e25218a214c1e130682c0e8b476712543a974d280891c6e0e2bfbaf5e6c79fbfbcfff476ff70175d06033bfaf7e9eb939fbf7f43b6b2eb270cc0a73b3beb980ec8479e9a1c8326c64730e3a277b6b7634eaa871d410b84401480a1b29257a5c50538fe2f802b4aaa2b4b6babcbc933f12d408bfc855bc8db71a418050c3719cfdda847fbf40f0943177164b078228944c247c892124e66adc8df5de7a197223c0be817c5cc7f322631437a8930ccc713159b4f7540f5e6d11ce442ae59a7548878420e5d2d11dd4c88efed6c1ce869191e01e3a6c1d1366874a26f64bc7770a4abaab6787a7a089a991e989ce89d9e9dac6ba8d1684c2211665c0d8ba562132699caea1174bd6f6aa76d6abb6ff1b87662bf7a6cb766f66dd1f0de8bdeedc72d4b392dcb8faba6b24b06d39ed4090426befdbd620a4c037c16974d65b0d81c0693e54067d1d83c472a9bc916e076b3ce782731212fe3c9585f976d7c787171d69ed8b75681195105ebf5a57908556e66661ce9fd9cc76cdcb55872d4e6f1241c0e82a892cb5370041a42accf2f6df8d3dfffcfb34fa707c7dbabebcb008c10b7beb1f9e1fd873ffffae76f3f7df91565fadbc7376f0e30f52d2ccc60c740a861e8531016a3e3437d03dde4bc4b92aeafafa8a929adaa28aa287b5556925f5a9c575156f4ef22f1832ed63031d6800daed80a008cdb2908c3c84d0aa52638243c2ee56ef095389dc95d637435e9d406b5c25541583422b467a38421665d10317f8071ff30b18ccd90306946a9283634084721cd91eff48398e16856497ccc3a93526c31a842fd3dab4bf37b3b6b87fb9b4746db3abbaa7b071b87c6da86463bfb065bfb06dbeb1acb27267be1ec99e9be89f1aee1c1b100bf6054661e5725957b49649e2c91bbd112d532bed631bdd56adb6b99db2d1fda2ce95f7bd9ba02ae774a076f15f7a7e6f524bde848ce68bc99d57a393e9329f6e6101a81d8c8e50a6934360a299dce717062c16d4e2c018b2f13f344f805af0604a4c7c4d4e6e7cc0ff62ecf4d6e2ccdad6e2c40cb6b36fbdb519630704fcdcf4dcccd8c4d4f8da39036d4355d8b8957a94c128956a174158af462b949ae7653683d42af249c9c7d7bfff5cfafdfeead6dceaf6daccc2fce2d2daf7dfdf1fbf9db22edfff8cd5f7efbf5f3e7b77b7bb0ef3ca206ec8b4db3b6b542be196d7d7b7569657ed6363531350a8d8df58f8f0f8c8cf47677b7b4b4d492a42b2bff4994a44bd6ed3f44de08ba6449c711b0295c16031d45acd445c4265c4f7b1297fac8db2fcceceeebac527818f501ce725fbdc45dc9d1f02e089914319b42b65e085656a33e73986206d559263608f92a0e4b45b034028ed5a40bf7f1f073314406f83cb895d8d95cd5d75d3bd05bdfdd5dd5df5fd73b580ff50d3577f6d6f5f4b73634578e8c7662689e9ce81e1bedc8c92a950af1602691c04c083d84122f8dfb95573583ad335b4d93eb55e3abaf7a674a7ad69ed74fe5d42f3d281abb5dd09696db7c23a73de545db8decce9807755169aff4be493ad730a3c765b9d24847dda1f3180c02472e574ce3893962a55aaac2641ce3eb9f161175272a62bebb736d767c6b617a7ddd062ddb67b39995e5c9e5a589c5f98989b1bedc97d9b131515e16abd9d9cda0f7866498c8549e7295bbce6875f10c1c18b37dfee5f7e3b3af7b7bab788485a585c5e5c5b333b4e35fbf7ffff38f3ffef2fbdf7e83cece8e3636e631d3afaccc81aefd2daeef4fc87f6de3cdd96b60dedadb58599fc70edbdc59d93dd8d8d95945f61c1ceceaec6c6a6eaea9abb39b92acdbff0fc628e045af72ffe8d6b8abb8300f0b4a6c5a5acccd9bc17732c3ee67bb256498ae3d9419fc0985c52493b92814ee0a869b9ceeeba290b22968c05caa2370423c065bc0e6f1a8540183919510d19afba4fc7e72a2d514e16d0970d6877ab805ba98e2bc9daf5bcd1977637a5b8b46fa2bbadb0a7a3acba18e8e46eccade81b6f6ae86b68e928eaeb2e1e126a8a7bd097ddaa8f516113abed86e0ea9c95bee624dcb296b9b5eab1ddbaa1ed928ea5dcb69b53dad9bba5f3e7caba0eb464e6b72565becc3bad8c7f571198d91f7caae3eac8cb95b98fcb4ea5a7a6678fc5dbd8b0f57a46672256c42269219ae442725ddce4abef33c26ad20f17e99ce1ce41d109b1c11f424352e33f96a564acce3d4fb3763929363d353aedd8abf7ce976c2f5cb97a3fdfd437c7d637c7ca20de6609d73a0c66c11ab8d0c42ae3478c834569d39e4e1d382f79f7f7bfbf58dfd0f76626e5e5d9e5fb6ad6faffdf2db77b4e4ef7ff9e9d7bffdfcf77ffce5f34f67276ff6f78fb6806d7777edcd9ba32f5fce7ef9eb4fd0b7dfbe7cfafefecd87c3c3d3ede3d39dd377fb1f3ebf7ef7e1e8f5eb9dededa505dbf8d8484f7f6f6b7767635b5b7d63635555557179f92ba8a2a290acde7ff026bbb55d45afca8a0b29fed7624212af7bdd7ce09172d73de9996b420643ea46687ca4045f2395e9252cb39240c83228446236c1a332256caa90e120e2205c3b1a85ac8247b73ece75bd9d6c3de8ab6c7972fdbaaf4bac9731c8457fd5df2bd4a48cf672be1e19d0dd5436d85dd1d690d7d65cdade528610dfd4540bc65d5dcd4d2d459ddd9543438d7d7db543bd5dcf1edd974a4c468315ced01a7c4057ef1d523d34df3ab349027ed5bd92513b7eaf78203dbf3b31ab113823ef9447dc2ebb72a72cf84641686a7e6052ce8382968c92cef8f4a7ae7e112cbe02e2f0954e0c214fa8be1a77f3eecb3228a3a22faf79f24ad263b37f4c88bf35292e26292222c2cf2f3c3021d43fdee21eeb628af4f50cf7760ff10b08f3f0f473b3849b5c83e56a6f89c222523ab3852a89da2c901b0cae212e9e9717d6f65f9f7d7bfbf9747d6f15d31d82151af9fef1def73ffdf4e5dba76fbf7ef9f52fdfa0afdf3f921f8140a1fef9e7cf7fffebaffff51fbffdf6f79ffef4d7afdffef4e1e38f207af0f66c9f3cfef8d39bcf5f4edebddf3b3c5adbdc985b5c409be81f1febeeed6d696fafabaf2fabaa2a045d3be652e0cc238d4bd22d29ca8748cc14a9c562898cf44cbdeb1c97e29e9c21bf9462f48da549dc391c8948a4168bf87a9ddad9607631b9112c198b2ae4d21d780c4721e38246c47e18e5bb35d8783650f269b8fce340d1fbde82d99a9c9b566d9051e9af935df632fb1a1446a534fbf1fde719e9a98911319121fe3eae2ece068b9b4b797911e6b6ba86fcd6f6d2eeee1aa8303fd7cbc34d267135eafd943a4f9dc9576af6bd975386e25c3bb2543eb09ad73673af6c28f1456b5c06fc5a9ff0ac3e31b3e1dae3eacbb78ac0d5e7dab3a0a4ac978d1359a59d31e93966ef30b1c69dc593333852071a1f5268dc93521fdd2badbd5f5677afbc3bbda8ed7641c3bda2e6db8f9f05475c8d8fbf9991f1f2c993a6f4f4f2c4d4aaeb29153efea9ae9678939b9fc66051eabca52a0faec868974cc714a9846a1789ce5da474c92daefffcfdcf876f3e1cbcd95bdd5946f7850e8ef63e7e3efbf5cfdf7ffafe85fcb4e99bf7071fbf9cfef2cba7df7efbf1ef7ffdf97ffce32ffff8cf3ffff6a7afbffef6f9a79fdf03eae1c9c6c9ebcdb30f075fbebe86be7d7f87e3fbb3fde3938dbdfde5cd2ddbcaead4e2d2f8f878dfc0407b47077c5c515b5b565d8d720db405ff92bd56a3389302660a4ba122b47a96d9cb37e9966bec2d45f0359d77b4401f2050ba407cb541e96251bbfaea2d810caeda892967d1a942826b1431efc65fd9ef2ddbeb293da8bdffa6e5e97ef5dd9386475b2df9d3250fc3cc2ad8d7d7c5ec6534e895ba206ba05e25970a78ce5a954a6aff5caa88cbbf937eb3a5b1bea626afa1a1b0adbdbab3ab2ec02f4026916934de72b9bb52ef23d77a795f4e6c1b5d2aefb315764c3e6f9eb857de9394d316fbb43ee26e794052ae352ed3373e2bfa7e69e4dd62ff84ac80c4e7790de35044d263bf8854ae50cb22542c8ed891ca75a40ba44a93b77f647cf283d4a2ba5b654d77caba93721b935fd42565d7deca2e4e7afc322ef56978ccadfb19adf79eb4a4dc6af20dced4ba25403a9355a67613c84d3c898121d0702406fbd3a23013729344ebe11b72f5f0ed4f076fdeee9ebc867d57b697965717a183a35dfb675a7f7cfffee3ebfd7d8cbcf35b5b8b38aeae4c2d2d22934f1d1dae9dbd3b7c7bbaf7f9d3f1eb93cdadedf9f58dd99dddc5d337dbe0fafde7f73f7d7bfbe9f331be8483f70f5676f796b677163636e716162630710c0f77f5f434b7b5d502735d0d86258ccb7691e51a680b0b5e92a27004628a238d2655133ab36fcccd80b85b06ef089de765a57b3024f10a107af8ca7c42d40197792ab78b3c158746578a25569560b2a56abd366ba5eae97ed5fd9df23b388e3f892c88f2c8b9647e1c1719e7ebe16172f5f7b2ca455afb4534a190cb62c9847c0e9daa104925843039fe5a5d65795969767d5d21f6637979be58ac9048940ab5a752e325d37b2b9d7d1fbdaaade81c2bec9c7ad13874a7a4e7465eebf5678db18f6ba3ee5684a5160626bcf0bd96698d7b129894e57f3de349796f45fbf4b5dbb9815792e4061f265746658a986c118dc10769700a89ba917a3fe76e4577727e63fcb39a84acba6b4fca22ee1644dcca8c7df0f27666d9d5d467153593f5cdf3752d2b1ed69b2efec95a4bacd12d18bb4da0327365068e544f289c056a7748a6f7d4b8f80d4f2f9c7efab6b1b7bd75b0bbb1b3b6b2b18481677975e1f8f5c1bbb3d39393ddeded95a9a941f098991aeaed6eaeaf2dad28cbafa92aeaeb694167dd5c9fdfdb5d5a5f9b01f2ad4ddbc1fe0a607ff87808c05f7f3c857d8f8ed741f7e070150b08b0c11856b6cd8f60f480953b3b1b5a9aaa1aeacaaa2a5e0133062af8b8b8f0e5abfc6c521426952de489e95c2144287497e39203c2af397b04eabcc38cbe9755415738ae3e72df20435884d6cdeac493aa2562319753f3246dacba60bef4fe40e6f5a9174913cf136ae2ad25916e2fa32c509cbf25cacb6c8571f566164b44a3115cf46c16538e1192cfd348147c06e7decdd4dab2d282fca78d0da52d6d8df109b162a9962f54cad4ee6a83b740edea7739beb86df8655d77565dffb39adebba5bdb78aba12329bc2d38b83925f06a7e406c6677a46dc770e4a0e887b127d2bb7b8752abbb42d2cee9ec664650934f6f0cc147078520026a406776b78cccda70f5f56253eafbdf1b23129a32af65e71f88daca8dbb997d233c36e3e8db8917123a3e8d1d38aaabae1a2b26ea34bb8ceeb8aca3d4c630e511a03257a0f91d64da47381846a4f81caa236fb3fca2efbfefbdf360f8f577756b70eb700786e716661696e636b15d3f0f1e9dee6e6d2f4f408ac66575713ac86660901435b4bddf060efd4c40850cd2f8cc2be8087128d82fce6ed0ebcfbf6dd2e88c2b8b03500e32eb819026f546c381e9867e78686473aecc9aba5065b07c28f0069fc88c28217ff024c67d3a94c273a9dca6050d92cb6801f7629dadb1a64f209355bc3a43e017c776f83d5cf2530d8c3d59dcbe24859545fb37eb43cab2dfb56dfd3b88e07517991968ac4a0fc58dfaccbee8fc2cccf223ce282dc237d8cee3ede62a502cfaf138d07c0f81f8f4983844cb6462c7d987eb3aeac2437fb61737d69455599d1648fcd844827d759c42a57b1cee3f6d3fcbcc6eefca69e7bc52d770a9b92731b1373eae39fd6c53caa8a7d507ef55ee9959b60fcd4f34abad233ea4e764d66494774d223a9de8a30c526146cb610a31106df8b8e4cad9b5f4ccabd9bcf4aa09497b5b1192557d35e4097539f46a46506dd786cbd7ed7e3729267444ae4d5db4dade3771fe4215519ac57d49650992140e11c24337b4a4d1648e2ec21d2fb8a0d7e3ab790b5fdcf6fbf7ede3844745eded85f5b58b14ddb266d4bd3ebdbcb6fcf8e31494f4d0d636440a7c48403a228a105792fa0a2c2fcda9acace8ed6bedeae81e14ef2c53b4ccf1bdb8b5bbbcb7b87eb47afb7b158df5a585b9b4361dfdd5d393ede42a286fe208dad00f6e8ca9313bd43836d5d1d0d507b6b6d637d397e104c4c32a650694c1a9de5c0a0521c2fd058540687ee63f58f8a8ef50a0c377bf90b4dae6a6f5f2f7f3fd0f2d16a6434aa884a799571bbf3456a53c6f59ad4a0f244dfac28ef34abe66ea8cbbd30d7bb61cea9feead86073a0ab44ef6260122c3a93b88047a73bea0c1a8b8b0112b3d9ae5a6d6afcb5dad2e21799f70038af204f2293f0043a85da43a27615c89d755ec105b5ed2feb3b9f94d63fade94ac82a01dd4bf75e0526bf0c4ac90d4accf68c7ae87e29dd72e5b66b5082f7e59b11c919fe51e9628d852d36d2e842472782cde4b118d890422e21b10445c5a53d4ecac0f85474f5f1abb05bcfe1d7cbc98fa1c8d4a781371ebb44a67847a7f9c6de8e4b78947233eb4ad44d77cf4b4ab750486a0c56ba842bdd7c14aede72578bc4e406ba727390bbffd5f7dffeb1fff674716b63ef351aecdce4f4986d6166797d1e800f5fef8e4e0e0e8ef4d437559595158071637d35222ee6e99c175905f9795595152dcd4df637e574350d8ef68e4f0fe3fcf1a9a185e5998dede5edbd35ec8fc59559f2d32118ab0e0e368f8eb6a1b7efb6cf3eecc1e2a4cb6171cceb73b343a3c3ddc3839d18a5c0b8b6bab8b4d80eb820ef39c5818ee7814f71727462311d6817593ca6a7871167643fbc1919e479fd920f1417e6151de81619e8866938da5553762fa5322db2203ee865b4e7e360c3bd4b1e711645a2bff146b0cbcd40031467355a156c11d311339587451c166e4a89f1bd9d18921e63bd19ed1deea5087415a52404d555653d7a76a7a1b52a3cea9a40a616cbdc2191ca20d7bbc4dc7a94595a7bafb8ee4e614dcacbea84e7e5e89757eee45f4ecf0dbf99e3137ddf2bf2ae77cc3d956facc818648d48b786c609946e1c8e08c6655259744706f9029623438cb41514997a35f971f2c3826bb7b2a3d3b2a26e66fac6dcf2bf76c73b2ad527faa6f56a6a70c2dde06b69e109772213ef044626a29ebb7a87ba7b85ea9c31aa7901adcce4ab70f1979902556ea112a38fda3da8a0aa1acff1e1bb23fb67e936e797d766e766c626c60640e5dd87938d8d4578b7b5b50e688b5ee55657a27e56624ecdc9c97cf1e25941410e8688fac69a86a6da8eeec6eebe96aeded6a6d65accb8e3e303cbcbb38b8bd33333a393934336db181c8c5118024bd46778f7e3a723d045877ef77ee7cddbad8393d59d83c5ed1ddbeadae4f44c5f4f6f3dba5e45796e69e18bc2bc4c0af3fcad2e28d28e74078a03e522952212b1e2e2ae34d714265c0db96275b9e46d0ab1a86343dcc3bd758403a5e8765c7de6ad8ab4cb2529a12fae7a267b88623ce451ae92785f7d6aa85b5aa82925507f3dd0f99a9f3ed4cf353cc0fdda15372825c2121368b86655df08353fb8e697931ef1282de2d9dd9807f753eaeb8a4d4657b552271118782c25828cc2d9eb5971edcbaa9687a5cdf78a1a92736a629e1447dd2f0c4bcbf1897d08055d7fea1971c73934d93d22ddf352b24758a2ca64a5112a3a9d43a5b2680ee83a1c0e478035c5812bd77984c5dd89bb95157f27273af55960fcbd90443cc27dbfd8dbce41b1328f50a97b90ce2fc2e87fc51c14e57b290e72f10ad19aad46577fb3471000a33e03aad4d92ad459f91a6fa3354ce9e667dbdc3c383b4371de3c5847691d1947e4e9b4d926d6b7960e4f76e6e6c69b9aaa1b1a2a31aaa226932f11638679f9322b3bfb29181715e5017063735d6b475d4b7b6d634b4d4d7d39ceefefef406107dad1d1bee1e11e0c4560bcb434b5be6e035d74654cc6408b2086810a8061681c491d1c2eafac4e4c4ef57477d5d754bf2a2bca2e2d7c4e71d12bf44a114160cbffe0c440957670a4517802666c54684ed6433f376da0c51015e0eaa5177968780631b5f65952f1dde8ec68f7e7516e7971d6ec68cb8d4073989e1fe3a54df0372507e9120334d7437449e1c6c830d7f04063a81be16f64c678cbe3fdd4f7232d590981f9e9575ea6863f4a0abf732df061eab58abca71e06b3abd628e3a9a55c9513a10e8a4ac9adedba975b99965b7de34505e85e7b5a1afda0283039332cf54548ca73cfc85b5e51b73da3ed8c5d82ae899cfd9d78720a4348a5b31da94c2afe4767527e70747062d0f84a9fd0ab61d7efc6a43f43410e4b7880a6eb1599ea157903f6f5bf765be57d59e2160869bc43dd42637c23aebb0545aacc3e72a3a7cec557efeaa770b58a8d16b1c15ba4f722d4585891b69e17d5ecbe3b5d3f3ec05cb475b881723a30dcdddbdb61b34ded1e6cac6d2e0e0e7691af1e1717e7e6e664c1c4b5d5e5009c97970dc04f91f65e66d53554b7daaf2854d7d5d95f642e2f7f85a1b6bdbd018c7b7bdba0aeaee6eeee16ec9bc9f1feb595d9e3a3f5776f77212cd080cfe7e3c5a3e35554eccf5f8ebefe78727cb24602eeeaaca9aa84839f5794e4505402a6fde3fa6ab1988f4ee9e044bbe8c47064721912093f2e2e3a35e1ea8debd10f6ec4a6c55d76550ba0ca07b10dcf925a1e5dcd8db1dcb1aaeffa6a12ada6cb4669849bf2aaa73639409d166a480a565df395047b8bfddc895013ebb21befd6659707573d9fc45ab393825fa4843e8eb5de8d094808768d0df6cabe9b9c71eb566a6cacc560e13870a4ce7ef7b2cbb32a3b1e1535a6beac4b7951733db32ae671e9a5f4bcf0b4dca0a44c383824e96950c2137d70bccc3b42ecec4b93385f648b7e600a9ce84c2a8345a3331c1c9d983c9158a1d5790484c6a4f85d4d8d487d1c7d3bfbea9d1781f17721442ad7b0eb4aaf30b7f07835b2a44780ce1a6eb914678db8eeec774961f2868059aaf7006081ce0d0e26d4ee5283b7cce863b2066ebff9b0b4bd3ebfb1b27bb2b97db43e3933d23fd4353cd4bfb830b777b8695b9ceae969851d01aca8e8e5cb179939d9cf48c028cea8d28f1fdf7bfe3ca3b6beaabdb30546075dec03080b7cd9d18101b7b1b1b18abc8e545b5d8ab63a31d6b7b2340dcc18a8e66d238b0b630bf3a333b38388dfa8d2efcf76a1ddbd85c5a5d1a96964ae96b6d68a86faa2c686628a56c8b57fca4829918b786c2e938368c26353d90c36977df9fca382269d467afe8e72298716ee6bc94e0c7d7cd5373bda2b33c223f38a6776944f8abf7b8846e4af242e39cb537cd56928d1bed2582f6154802a26587befaa7bfa15d38d4ba6185f45908988f1d344fbeb423da47e2691afb330c8a2bfe4eb62757331a995ce1aa359674a79f4ea515eddddbcdacc8a8ec4ac4a08534d587aaecfb5c7bef1197eb18f7c631efa5d7b600e4d96785e5658a3a4266f96dcc814c89c38c85654d065305917419845704572934f58f8b59b21d7ef5c4a7e1078fdbe25e286e54ab24b68bcfba5eb328f60beb3556e09710db9ea1399a8b386427a9f509d7788c61220337b4b0d1699d113f60560d857a0b5284c3e428d5b4573dbc6f1e9d2cecaf4ca2ce2d5e6c12a5212b2d2e8f8a8fd23da7b6b53b3a3301f1c0c531616e60070e6d347e415bdc2c25c78f7c993fb99998fab6acadb3a9aebeaca4b4af2f2f39fe3cc8a8ae28686eae6e63a1cc9925ef42a07330f221118631cc2b1bdb9baa3a50623b55d3d8d804dbe0cb2b43c81890bc8313bd9e606c94b7363a31d148580d0484446bd5a29173bd11c986cba582ed29b74e197432f5d098b898a904b44f65727c4429990af914ba37df4119e9a143f7d5a90e95690f976b04bac9729482bf110d20335c26817c1350f49a2557e33489b186a8a0f32c405a8233cc5fe265e809908f5513fb91595fb3435efd9cdfccc5baf9edfc9cbbaf7e876425a6ad28de4eb51d1576fdfb97b3fb726e6d6f3eb8f5fa53e2f47f745710e4b7fe913ff383031d3fffad3e08467987af501d794de91baa058a17b8858eb42e3cb61582a8b005e88bcbccf164821f4cb80e8a4d0ebf743e2ef05273e04636b548a7b589c774492c8e4eb283650a5ce32377f97e068cff058f79068d09598bca526f45d6f89b32744685c45060b5fe52277f616a8ccbee1b15bc7c7cb3b3bb6f5b99995e9ddd7eb4bb1bbc5f700000d4b494441545bb37d435dedddcd9353d3bb7bfba8cf639383884bb02f4c5950900dc0cf321e9614d9af07a0f5e6e63e7ff6ec11aa7471e9aba6967a7b93c6392f91bcb24b4b5fd5d49437d455916fe74061c79c03c0d5958518702bcb0b5ee56721375596e635d69437dadf61593532d4333b3b3631313838d8d1dfdf36d8df3e36d283508d68bdb931b7b3bd40f1f1f4f0b77a474484ddbd9b9653f06c70ac7b7e6912a901b3796363859fd58349bfc8e3311d1d291c1e07b616d07f90729c342c8a9c4a515029461ec545ce338a594611dd532308d6b12e99886b5ef2584f59a059e26b10f86858ee3227ade0828846e1d0296a19c36c147b5b3471d141b75363b233ee15bcc8a8a9aec05c58595f57d550df3eb5d6303c9fdf3a9c925d169b5114fda8c03fe91918072767c53c28467e3687dcb044dc848ca1f14cbd0f8d27a6d038171c68f6ce4ba3d2a84e742a867afa052a8b2b947986c5845f4f47eb0d8cbd8de46c0fcf31370362d3949610882e3546df7cec1a142d76f6f10889b65e8937fb5f16ea3df85a57a01519ec0baeca0cc63c8549a2b76033553475adec6eaf1fec0d4ef5cdac4c6e1f2fcfae8c0e8d0df40df5ccd86cab1b1b186c50aec97885fa9c9797f5e2f9d3ac678fd18901180851a5d18661e2dcfc1748d1d80438078061626c02f29d1838f3557e4e7656c6f3cc47792f3331f040b9391959cfeee73ecf28ce7f5156985ffaca7ef1bfb9b1b6a3ada9a5a9aeb3b30585bdbdb5defe9183810eb4ede5a589bddd25cac9c9fec1c136f61de2dfccc2d0e2da44676f6d454deecd9bd156abc1c5ac24788e179d280cb623e522e522dd81cda641048d2202633645c6a288381778748a8445d14b18de4a9a9f96e5aba21bd814911345c777320b1d741c8a46e4a8163a38eb44068d40a9e029e45cad9c901034834aaab3fff95311a6e4e2aacaacbcdce83b4f8bda06ca7aa79fd7f5806e627645ec93b2a01bcfddaedcb25e7be41d750f0e76094b82893dafa609dc821d188423938fee7bc191ea78e102cdd19141a7418458e1ece675292e0d930fec1b9ef83020ee2e007b84c659c2e28362d3dd8263a962bda3507b81ab64c94c7cad1bb2b1da230047d81768d90a23a1710160a6cc2050bb72e5ceaebea1dbaf3f2e6d6f8ececdf48d774e2f8f6d1c2cccad8e8d4f8ff60c744dcdda36b67767e7273a7b5a605f002e2dcdcfcdcd7c9ef9048071b4bfc7aafc9f551a6df8c5cb2c046954660086adf3f35f00302a39ec8b8919f6c5b73ccbb8ffe2f993972f9ee66467bc78fe0880f3b29e15e664e76567becc7a5a909b535e5244be33abbaba0c15bea6aaa4a5a9a6a5a9aab1bebcb3a3767cac9bd2d955ddde51d9dc51d8d09adfd0faaaadbb0c8d1d1b27ccdfcfcfe261500aa4044d2a6488082afce184644aff81c6bcc8643ab0588e1c9613974d25d88e108f7151c4a5d9ffae8394a715b245f40bdc8b1401952220e8423e83cf63b0998e108f4323d0e959342e87c927383c2e4728e0f379421e879f92949a7ef3b6e572aa4b48a27ff49da0d8fba6c02b3e91d73dc2c3626edf8a4ebb7725e5967f54ba7bf0758f90eb9e61893adf00c260bac86251e8f48bf6704873fcc1e922c5e1c2455468a6dee26d0dbf129a980605c6df0e88bbe51b95e6179dee7df5a65774aa6f6492d1f7b2c133c8272c26243a89af34b1247af4579909c3aebf50e7c953b9114a57882d71e348dd09853354d3daba7d7232bb3cdb35d8d5d5d7b6bebd4cbe3c39333f353a393c363532bf3c373939d2dede5455555a565658525200bf6228cac87880b28c351c0c016dc6b34738565495be7af512b10b9ec6919c8f2b2b4bece79cfbfee99307105a388a3c16198fef6381bb90da801fc59facfcd810c5857643936f07c0168150091aebab290d8d45cd2da5ad5dc5ed3da5cdeda595b52f13e2639c0d1a8d54a293cb30b828442c958c2b11d8df9778f102c5917a014f268361670c60604c0a8009a68390e524e531243c2a874a615da0701d29d801a00b61c1663b7138542e97811ac0a03b0130934187048480c7e1e9f4ce8545a5c98f0b5d83e3993277aeca4becec2544d27135ebadde1a4f6fb5c54be1128898ad740dd079862adddd057abd238703c6647ea63bd150a94197c5e679875e0a8a8af1bd9a0059ae247a47a558236f7a5f41c84a3405c718ac61c8535ec1114a93274fa2650b550ca19a27378231da2d4766648a752cb116620a4c1076806750e4e6c1fec2fadae0c4e0c0f8c0d058dfaafd4fcc2c4ccd4d4cce8e832e7c8cf5c8487f8bbdb316035271713e09181d17c28c845b8010372245e308dbc1d0408b2fc91740b02d20fb09994f40f4f1c3bb10b892a449e12e08d4411a46075df2ea2f2a04c9957c3716d628e094d6b6f296d6b2bae6dcfa96bcdac682e2f24cab8fa7c3450a97ce1072b830a580ed842acdc5d3c8a4b1f11c3afd40a55ea0d31d984c27168b0ab199a4ec06e5d01d784c273eca38ed22cd81c2406d675c0454ccd93c1e9dc54563a432d93488c56120d0d9df59cc617179845822e5f204894937eabaa7d29f165de06a9d04462a5fc996ea3972095b2676220888c6955339322a216308957411df89cfa572b84e6c0e9dc5c2aef9e7fb9f595c3c144f2a97eb8d5a4ffff0eba9c1f1e9c8c95e979321b55788c8e4639f7c9c3d5dbcfd844aad0383cbe24b38622521d3100a035706b46aa648855bb8121557eac21018840a6343fbc0daded6eccac2f8dc685367c3dce2d4f2fafcb46d12de05da730d0f8ff7f7f7a3015793f6053c145ef043662647237c09f0b81d9685776156dc9295f504f849e4f8469c80ad00c7e35b1e3db8033d79740f5ce15dd2d33842a4950b0b5e92178011b9d1bf91bd91d1605c1cdb5a1aec6f9bedecac6a69292dafc9842aeaf2206fab378d41c3cc04d9395da4383950d8cc8b62115fad923b395ea03a5da4d31c49de38929849813adc098f62817d40a35d84e3192c2a97cf80d83c1a0033383488c9a53bd02eb0b86c36aa3693c9e6f1ec7f7a9c20ee66be7a925b2ed67839713517e8429e44cf158b50cd99022e83cfa173041002b323838b40e0c0c0c0cb76b26f19a69d31f35c6c3c26cf91c5e188242ca9c6127cc52f2a3128f6064cacf20ee7eb2c14a6e407b6d0892f63f2852c818845e00139741e9f4108e88488c61392d7d6588490231073c5f805f4c11157d7f68e40777ac9d633dcd5dad3bcb9bbbab4668371472686709c98199b9819e91dececeeedc0805b5256585452908ff29bfb1cd60442d00233ac4117591a80e166b0443fc6eda8e138075c710b760616b8e5d1a3bb0f1edc7ef8f09f8061597b577ef608db05c202851a0e2601c3c7b02c00936f90eeea68191eec9d9d1ea7d4d515d4d7bfaaaacfa96bceaf6b2e815cdddc316c7058048bc165d01c684ee0448179e44aa946a7fa03b09deeb90b192c38928e1a89238d4585e86c1a8e4e0c471c4191ca7464a1440bd81c3e0b0b1230292ad3892b8085d90e544726c76e4485b3fbd564fb6bcb14ba84ce5130b84a422266f1097c3bbed73ea77309083f9b86c2cca6da2f823118007c2e3a44ba99c1257e4057660b4222af5d4ab865f2bba4f209750e8e32f94750b80a0a9d8047695c1e83e0f3c402162a019be5c4c22fca86b063801cbf0f6a015ba0e44b75ed7d03cb5b3bb695f981b1c19e818ed1c9c1bda3adc5d539d0b5039e1d1b9f1b1f9b1de91c68efe9eb44742a2d2f02e03cd4e7975959d94f9f9d7b1402457b982a2940aa429fc602273ccd7cfce4e9439c03d8247edc0bba404b02c6e640eac6b7832b1e012217381f650074cf07aa1cb207e308cc88d6fdbd9d43033d76c04d4dc5a0dbd25952df525ed75ca6d61a9d6870260f4f0f00dbc5f881c7a30a44045fc8035d3b63ba23700230e842f60587cec47e60511de90e400b7254f88a60610d8125e802129b60c2bb106841d80a84c81ec038046e62f004044324b504850647a6b0c54647868cca5230099e9db1fde47fbe8e81224c67a08d3b41f892ce609e736550d976610121737108909388953abd77b07b70a4777482c7956be6806842eb4971645f6009d121686c2402a65d3c369dcba27339a4681c368bcde170794c429c76eff1ced1e1c6de2e5a2fe2d5f8cc208484356d1bef1fee05e009db04343a33dc35d8d137d08de107800b8bf331083d7ff12cf37946c6f9e00b53423031b8024c53430dd8003fee05609c06bbbf2aca0360389804fc075d32a6a18cc3fa2460ac0118551d68f373b3e1662c50b10bf2ec43544d7949755971654921a5b5b5acad0d5cf39bda8b2a1b4a21894c436712341ae1e0c0064e642b1aed07646650045747ea4507278c241749cb922f0e9280593ce6b9652f92dec52d1c74e3732b8337ee254d4c02062d2786fd75153697094e84808b668c49e7073cab4a251cec6abd42b940fc4015c34f7c898c1071edfb83c3c5f38e0c052fa38f50e954f45d0844c1d88945c5ae220193e0b1d7986cc23324222426d11211a7b686b807c7430e1c29854a3079f68f9adaff5a32c105601a8709ae106a00ea01a21a00bb7afa6c1f1c2f6dac4283a3bd03233d7dc31db38be3a08b753b86ceb181e9c5e9c9f9c9e1a94100c6bc54db585d5cfa0af519ee0436d2a08064efa98fee8213f9961a14520cc7a0fb10b73fb98f33b121f08db07ecebf1cfceff60557b473329101304893c355decbe788d3189ad192c9808d8886ce9e939981ea40f9fffffbfff67fff1315aa92861283a7dd0000000049454e44ae426082);

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
--
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
