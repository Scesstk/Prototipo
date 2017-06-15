DROP DATABASE IF EXISTS `scess`;

CREATE DATABASE scess;

use scess;




SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for acceso
-- ----------------------------
DROP TABLE IF EXISTS `acceso`;
CREATE TABLE `acceso` (
  `ACCidAccPK` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ACCidPerFK` int(10) unsigned NOT NULL,
  `ACCcon` varchar(50) NOT NULL,
  `ACCact` varchar(2) NOT NULL,
  PRIMARY KEY (`ACCidAccPK`),
  KEY `ACCFKper` (`ACCidPerFK`) USING BTREE,
  CONSTRAINT `acceso_ibfk_1` FOREIGN KEY (`ACCidPerFK`) REFERENCES `persona` (`PERidPerPK`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of acceso
-- ----------------------------
INSERT INTO `acceso` VALUES ('1', '1', '81dc9bdb52d04dc20036dbd8313ed055', 'SI');
INSERT INTO `acceso` VALUES ('2', '2', '827ccb0eea8a706c4c34a16891f84e7b', 'SI');
INSERT INTO `acceso` VALUES ('3', '4', 'c4ea00264805192b811b2cd048049c43', 'SI');
INSERT INTO `acceso` VALUES ('4', '5', '827ccb0eea8a706c4c34a16891f84e7b', 'SI');
INSERT INTO `acceso` VALUES ('5', '6', '827ccb0eea8a706c4c34a16891f84e7b', 'SI');
INSERT INTO `acceso` VALUES ('6', '7', '827ccb0eea8a706c4c34a16891f84e7b', 'SI');
INSERT INTO `acceso` VALUES ('7', '8', '827ccb0eea8a706c4c34a16891f84e7b', 'SI');
INSERT INTO `acceso` VALUES ('8', '9', '70d9011250cf39b8c84ca2652f6bc1e0', 'SI');
INSERT INTO `acceso` VALUES ('9', '10', 'e45823afe1e5120cec11fc4c379a0c67', 'SI');
INSERT INTO `acceso` VALUES ('10', '11', 'ad7e762ed4f2dba7957e7df3741d4c79', 'SI');
INSERT INTO `acceso` VALUES ('11', '20', '827ccb0eea8a706c4c34a16891f84e7b', 'SI');
INSERT INTO `acceso` VALUES ('12', '13', '827ccb0eea8a706c4c34a16891f84e7b', 'SI');
INSERT INTO `acceso` VALUES ('13', '14', '81dc9bdb52d04dc20036dbd8313ed055', 'SI');

-- ----------------------------
-- Table structure for censed
-- ----------------------------
DROP TABLE IF EXISTS `censed`;
CREATE TABLE `censed` (
  `CSidSedFK` int(10) unsigned DEFAULT NULL,
  `CSidCenFK` int(10) unsigned DEFAULT NULL,
  KEY `FK_centros` (`CSidCenFK`) USING BTREE,
  KEY `FK_sede` (`CSidSedFK`) USING BTREE,
  CONSTRAINT `censed_ibfk_1` FOREIGN KEY (`CSidCenFK`) REFERENCES `centros` (`CENidCenPK`),
  CONSTRAINT `censed_ibfk_2` FOREIGN KEY (`CSidSedFK`) REFERENCES `sede` (`SEDIdSedPK`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of censed
-- ----------------------------
INSERT INTO `censed` VALUES ('1', '1');

-- ----------------------------
-- Table structure for centros
-- ----------------------------
DROP TABLE IF EXISTS `centros`;
CREATE TABLE `centros` (
  `CENidCenPK` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CENnomCen` varchar(100) DEFAULT NULL,
  `CENcodSenCen` int(10) DEFAULT NULL,
  `CENidCiuFK` int(10) unsigned NOT NULL,
  PRIMARY KEY (`CENidCenPK`),
  KEY `FK_ciudad` (`CENidCiuFK`) USING BTREE,
  CONSTRAINT `centros_ibfk_1` FOREIGN KEY (`CENidCiuFK`) REFERENCES `ciudad` (`CIUidCiuPK`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of centros
-- ----------------------------
INSERT INTO `centros` VALUES ('1', 'CEAI', '1234', '1217');

-- ----------------------------
-- Table structure for ciudad
-- ----------------------------
DROP TABLE IF EXISTS `ciudad`;
CREATE TABLE `ciudad` (
  `CIUidCiuPK` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CIUnomCiu` varchar(30) DEFAULT NULL,
  `CIUidDepFK` int(10) unsigned NOT NULL,
  PRIMARY KEY (`CIUidCiuPK`),
  KEY `FK_depart` (`CIUidDepFK`) USING BTREE,
  CONSTRAINT `ciudad_ibfk_1` FOREIGN KEY (`CIUidDepFK`) REFERENCES `departamento` (`DEPidDepPK`)
) ENGINE=InnoDB AUTO_INCREMENT=1306 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of ciudad
-- ----------------------------
INSERT INTO `ciudad` VALUES ('1', 'El Encanto', '1');
INSERT INTO `ciudad` VALUES ('2', 'La Chorrera', '1');
INSERT INTO `ciudad` VALUES ('3', 'La Pedrera', '1');
INSERT INTO `ciudad` VALUES ('4', 'Leticia', '1');
INSERT INTO `ciudad` VALUES ('5', 'Mirití-Paraná', '1');
INSERT INTO `ciudad` VALUES ('6', 'Puerto Nariño', '1');
INSERT INTO `ciudad` VALUES ('7', 'Puerto Santander', '1');
INSERT INTO `ciudad` VALUES ('8', 'Tarapacá', '1');
INSERT INTO `ciudad` VALUES ('9', 'Amazonas', '1');
INSERT INTO `ciudad` VALUES ('10', 'La ciudad de caro', '1');
INSERT INTO `ciudad` VALUES ('11', 'Abejorral', '2');
INSERT INTO `ciudad` VALUES ('12', 'Abriaquí', '2');
INSERT INTO `ciudad` VALUES ('13', 'Alejandría', '2');
INSERT INTO `ciudad` VALUES ('14', 'Amagá', '2');
INSERT INTO `ciudad` VALUES ('15', 'Amalfi', '2');
INSERT INTO `ciudad` VALUES ('16', 'Andes', '2');
INSERT INTO `ciudad` VALUES ('17', 'Angelópolis', '2');
INSERT INTO `ciudad` VALUES ('18', 'Angostura', '2');
INSERT INTO `ciudad` VALUES ('19', 'Anorí', '2');
INSERT INTO `ciudad` VALUES ('20', 'Antioquia', '2');
INSERT INTO `ciudad` VALUES ('21', 'Anza', '2');
INSERT INTO `ciudad` VALUES ('22', 'Apartadó', '2');
INSERT INTO `ciudad` VALUES ('23', 'Arboletes', '2');
INSERT INTO `ciudad` VALUES ('24', 'Arboretes', '2');
INSERT INTO `ciudad` VALUES ('25', 'Argelia', '2');
INSERT INTO `ciudad` VALUES ('26', 'Armenia', '2');
INSERT INTO `ciudad` VALUES ('27', 'Barbosa', '2');
INSERT INTO `ciudad` VALUES ('28', 'Belén de Bajirá', '2');
INSERT INTO `ciudad` VALUES ('29', 'Bello', '2');
INSERT INTO `ciudad` VALUES ('30', 'Belmira', '2');
INSERT INTO `ciudad` VALUES ('31', 'Betania', '2');
INSERT INTO `ciudad` VALUES ('32', 'Betulia', '2');
INSERT INTO `ciudad` VALUES ('33', 'Bolombolo', '2');
INSERT INTO `ciudad` VALUES ('34', 'Briceño', '2');
INSERT INTO `ciudad` VALUES ('35', 'Buriticá', '2');
INSERT INTO `ciudad` VALUES ('36', 'Cáceres', '2');
INSERT INTO `ciudad` VALUES ('37', 'Caicedo', '2');
INSERT INTO `ciudad` VALUES ('38', 'Caldas', '2');
INSERT INTO `ciudad` VALUES ('39', 'Campamento', '2');
INSERT INTO `ciudad` VALUES ('40', 'Cañasgordas', '2');
INSERT INTO `ciudad` VALUES ('41', 'Capurganá', '2');
INSERT INTO `ciudad` VALUES ('42', 'Caracolí', '2');
INSERT INTO `ciudad` VALUES ('43', 'Caramanta', '2');
INSERT INTO `ciudad` VALUES ('44', 'Carepa', '2');
INSERT INTO `ciudad` VALUES ('45', 'Carolina', '2');
INSERT INTO `ciudad` VALUES ('46', 'Caucasia', '2');
INSERT INTO `ciudad` VALUES ('47', 'Cestilla', '2');
INSERT INTO `ciudad` VALUES ('48', 'Chigorodó', '2');
INSERT INTO `ciudad` VALUES ('49', 'Cisneros', '2');
INSERT INTO `ciudad` VALUES ('50', 'Ciudad Bolívar', '2');
INSERT INTO `ciudad` VALUES ('51', 'Cocorná', '2');
INSERT INTO `ciudad` VALUES ('52', 'Concepción', '2');
INSERT INTO `ciudad` VALUES ('53', 'Concordia', '2');
INSERT INTO `ciudad` VALUES ('54', 'Copacabana', '2');
INSERT INTO `ciudad` VALUES ('55', 'Currulao', '2');
INSERT INTO `ciudad` VALUES ('56', 'Dabeiba', '2');
INSERT INTO `ciudad` VALUES ('57', 'Don Matías', '2');
INSERT INTO `ciudad` VALUES ('58', 'Doradal', '2');
INSERT INTO `ciudad` VALUES ('59', 'Ebéjico', '2');
INSERT INTO `ciudad` VALUES ('60', 'El Bagre', '2');
INSERT INTO `ciudad` VALUES ('61', 'El Carmen de Viboral', '2');
INSERT INTO `ciudad` VALUES ('62', 'El Peñol', '2');
INSERT INTO `ciudad` VALUES ('63', 'El Retiro', '2');
INSERT INTO `ciudad` VALUES ('64', 'El Santuario', '2');
INSERT INTO `ciudad` VALUES ('65', 'Entrerríos', '2');
INSERT INTO `ciudad` VALUES ('66', 'Envigado', '2');
INSERT INTO `ciudad` VALUES ('67', 'Fredonia', '2');
INSERT INTO `ciudad` VALUES ('68', 'Frontino', '2');
INSERT INTO `ciudad` VALUES ('69', 'Giraldo', '2');
INSERT INTO `ciudad` VALUES ('70', 'Girardota', '2');
INSERT INTO `ciudad` VALUES ('71', 'Gómez Plata', '2');
INSERT INTO `ciudad` VALUES ('72', 'Granada', '2');
INSERT INTO `ciudad` VALUES ('73', 'Guadalupe', '2');
INSERT INTO `ciudad` VALUES ('74', 'Guarne', '2');
INSERT INTO `ciudad` VALUES ('75', 'Guatapé', '2');
INSERT INTO `ciudad` VALUES ('76', 'Heliconia', '2');
INSERT INTO `ciudad` VALUES ('77', 'Hispania', '2');
INSERT INTO `ciudad` VALUES ('78', 'Hoyorrico', '2');
INSERT INTO `ciudad` VALUES ('79', 'Itagüí', '2');
INSERT INTO `ciudad` VALUES ('80', 'Ituango', '2');
INSERT INTO `ciudad` VALUES ('81', 'Jardín', '2');
INSERT INTO `ciudad` VALUES ('82', 'Jericó', '2');
INSERT INTO `ciudad` VALUES ('83', 'La Ceja', '2');
INSERT INTO `ciudad` VALUES ('84', 'La Estrella', '2');
INSERT INTO `ciudad` VALUES ('85', 'La Fe', '2');
INSERT INTO `ciudad` VALUES ('86', 'La Pintada', '2');
INSERT INTO `ciudad` VALUES ('87', 'La Sierra', '2');
INSERT INTO `ciudad` VALUES ('88', 'La Unión', '2');
INSERT INTO `ciudad` VALUES ('89', 'Liborina', '2');
INSERT INTO `ciudad` VALUES ('90', 'Llanadas', '2');
INSERT INTO `ciudad` VALUES ('91', 'Maceo', '2');
INSERT INTO `ciudad` VALUES ('92', 'Marinilla', '2');
INSERT INTO `ciudad` VALUES ('93', 'Medellín', '2');
INSERT INTO `ciudad` VALUES ('94', 'Montebello', '2');
INSERT INTO `ciudad` VALUES ('95', 'Murindó', '2');
INSERT INTO `ciudad` VALUES ('96', 'Mutatá', '2');
INSERT INTO `ciudad` VALUES ('97', 'Nariño', '2');
INSERT INTO `ciudad` VALUES ('98', 'Nechí', '2');
INSERT INTO `ciudad` VALUES ('99', 'Necoclí', '2');
INSERT INTO `ciudad` VALUES ('100', 'Nueva Colonia', '2');
INSERT INTO `ciudad` VALUES ('101', 'Nutibara', '2');
INSERT INTO `ciudad` VALUES ('102', 'Olaya', '2');
INSERT INTO `ciudad` VALUES ('103', 'Palermo', '2');
INSERT INTO `ciudad` VALUES ('104', 'Peque', '2');
INSERT INTO `ciudad` VALUES ('105', 'Pueblo Rico', '2');
INSERT INTO `ciudad` VALUES ('106', 'Puerto Berrío', '2');
INSERT INTO `ciudad` VALUES ('107', 'Puerto Claver', '2');
INSERT INTO `ciudad` VALUES ('108', 'Puerto Nare', '2');
INSERT INTO `ciudad` VALUES ('109', 'Puerto perales', '2');
INSERT INTO `ciudad` VALUES ('110', 'Puerto Triunfo', '2');
INSERT INTO `ciudad` VALUES ('111', 'Remedios', '2');
INSERT INTO `ciudad` VALUES ('112', 'Rionegro', '2');
INSERT INTO `ciudad` VALUES ('113', 'Sabanalarga', '2');
INSERT INTO `ciudad` VALUES ('114', 'Sabaneta', '2');
INSERT INTO `ciudad` VALUES ('115', 'Salgar', '2');
INSERT INTO `ciudad` VALUES ('116', 'San Andrés de Cuerquía', '2');
INSERT INTO `ciudad` VALUES ('117', 'San Carlos', '2');
INSERT INTO `ciudad` VALUES ('118', 'San Francisco', '2');
INSERT INTO `ciudad` VALUES ('119', 'San Jerónimo', '2');
INSERT INTO `ciudad` VALUES ('120', 'San José de la Montaña', '2');
INSERT INTO `ciudad` VALUES ('121', 'San José del Nus', '2');
INSERT INTO `ciudad` VALUES ('122', 'San Juan de Urabá', '2');
INSERT INTO `ciudad` VALUES ('123', 'San Luis', '2');
INSERT INTO `ciudad` VALUES ('124', 'San Pedro de los Milagros', '2');
INSERT INTO `ciudad` VALUES ('125', 'San Pedro de Urabá', '2');
INSERT INTO `ciudad` VALUES ('126', 'San Rafael', '2');
INSERT INTO `ciudad` VALUES ('127', 'San Roque', '2');
INSERT INTO `ciudad` VALUES ('128', 'San Vicente', '2');
INSERT INTO `ciudad` VALUES ('129', 'Santa Bárbara', '2');
INSERT INTO `ciudad` VALUES ('130', 'Santa Rosa de Osos', '2');
INSERT INTO `ciudad` VALUES ('131', 'Santa Fe de Antioquia', '2');
INSERT INTO `ciudad` VALUES ('132', 'Santo Domingo', '2');
INSERT INTO `ciudad` VALUES ('133', 'Segovia', '2');
INSERT INTO `ciudad` VALUES ('134', 'Sevilla', '2');
INSERT INTO `ciudad` VALUES ('135', 'Sonsón', '2');
INSERT INTO `ciudad` VALUES ('136', 'Sopetrán', '2');
INSERT INTO `ciudad` VALUES ('137', 'Sucre', '2');
INSERT INTO `ciudad` VALUES ('138', 'Támesis', '2');
INSERT INTO `ciudad` VALUES ('139', 'Taparto', '2');
INSERT INTO `ciudad` VALUES ('140', 'Tarazá', '2');
INSERT INTO `ciudad` VALUES ('141', 'Tarso', '2');
INSERT INTO `ciudad` VALUES ('142', 'Titiribí', '2');
INSERT INTO `ciudad` VALUES ('143', 'Toledo', '2');
INSERT INTO `ciudad` VALUES ('144', 'Turbo', '2');
INSERT INTO `ciudad` VALUES ('145', 'Uramita', '2');
INSERT INTO `ciudad` VALUES ('146', 'Urrao', '2');
INSERT INTO `ciudad` VALUES ('147', 'Valdivia', '2');
INSERT INTO `ciudad` VALUES ('148', 'Valparaíso', '2');
INSERT INTO `ciudad` VALUES ('149', 'Vegachí', '2');
INSERT INTO `ciudad` VALUES ('150', 'Venecia', '2');
INSERT INTO `ciudad` VALUES ('151', 'Versalles', '2');
INSERT INTO `ciudad` VALUES ('152', 'Vigía del Fuerte', '2');
INSERT INTO `ciudad` VALUES ('153', 'Yalí', '2');
INSERT INTO `ciudad` VALUES ('154', 'Yarumal', '2');
INSERT INTO `ciudad` VALUES ('155', 'Yolombó', '2');
INSERT INTO `ciudad` VALUES ('156', 'Yondó', '2');
INSERT INTO `ciudad` VALUES ('157', 'Zaragoza', '2');
INSERT INTO `ciudad` VALUES ('158', 'Altamira', '2');
INSERT INTO `ciudad` VALUES ('159', 'La Cruzada', '2');
INSERT INTO `ciudad` VALUES ('160', 'Puerto Valdivia', '2');
INSERT INTO `ciudad` VALUES ('161', 'Pueblorrico', '2');
INSERT INTO `ciudad` VALUES ('162', 'Arauca', '3');
INSERT INTO `ciudad` VALUES ('163', 'Arauquita', '3');
INSERT INTO `ciudad` VALUES ('164', 'Cravo Norte', '3');
INSERT INTO `ciudad` VALUES ('165', 'Fortul', '3');
INSERT INTO `ciudad` VALUES ('166', 'Puerto Nariño', '3');
INSERT INTO `ciudad` VALUES ('167', 'Puerto Rondón', '3');
INSERT INTO `ciudad` VALUES ('168', 'Saravena', '3');
INSERT INTO `ciudad` VALUES ('169', 'Tame', '3');
INSERT INTO `ciudad` VALUES ('170', 'Baranoa', '4');
INSERT INTO `ciudad` VALUES ('171', 'Barranquilla', '4');
INSERT INTO `ciudad` VALUES ('172', 'Campo de la Cruz', '4');
INSERT INTO `ciudad` VALUES ('173', 'Candelaria', '4');
INSERT INTO `ciudad` VALUES ('174', 'GalapaJuan de Acosta', '4');
INSERT INTO `ciudad` VALUES ('175', 'Luruaco', '4');
INSERT INTO `ciudad` VALUES ('176', 'Malambo', '4');
INSERT INTO `ciudad` VALUES ('177', 'Manatí', '4');
INSERT INTO `ciudad` VALUES ('178', 'Palmar de Varela', '4');
INSERT INTO `ciudad` VALUES ('179', 'Piojó', '4');
INSERT INTO `ciudad` VALUES ('180', 'Polonuevo', '4');
INSERT INTO `ciudad` VALUES ('181', 'Ponedera', '4');
INSERT INTO `ciudad` VALUES ('182', 'Puerto Colombia', '4');
INSERT INTO `ciudad` VALUES ('183', 'Repelón', '4');
INSERT INTO `ciudad` VALUES ('184', 'Sabanagrande', '4');
INSERT INTO `ciudad` VALUES ('185', 'Sabanalarga', '4');
INSERT INTO `ciudad` VALUES ('186', 'Santa Lucía', '4');
INSERT INTO `ciudad` VALUES ('187', 'Santo Tomás', '4');
INSERT INTO `ciudad` VALUES ('188', 'Soledad', '4');
INSERT INTO `ciudad` VALUES ('189', 'Suan', '4');
INSERT INTO `ciudad` VALUES ('190', 'Tubará', '4');
INSERT INTO `ciudad` VALUES ('191', 'Usiacurí', '4');
INSERT INTO `ciudad` VALUES ('192', 'Juan Mina', '4');
INSERT INTO `ciudad` VALUES ('193', 'La Loma', '4');
INSERT INTO `ciudad` VALUES ('194', 'La Jagua de Ibirico', '4');
INSERT INTO `ciudad` VALUES ('195', 'Achí', '5');
INSERT INTO `ciudad` VALUES ('196', 'Altos del Rosario', '5');
INSERT INTO `ciudad` VALUES ('197', 'Arenal del Sur', '5');
INSERT INTO `ciudad` VALUES ('198', 'Arjona', '5');
INSERT INTO `ciudad` VALUES ('199', 'Arroyo Hondo', '5');
INSERT INTO `ciudad` VALUES ('200', 'Barranco de Loba', '5');
INSERT INTO `ciudad` VALUES ('201', 'Bayunca', '5');
INSERT INTO `ciudad` VALUES ('202', 'Calamar', '5');
INSERT INTO `ciudad` VALUES ('203', 'Cantagallo', '5');
INSERT INTO `ciudad` VALUES ('204', 'Cartagena', '5');
INSERT INTO `ciudad` VALUES ('205', 'Cicuco', '5');
INSERT INTO `ciudad` VALUES ('206', 'Clemencia', '5');
INSERT INTO `ciudad` VALUES ('207', 'Córdoba', '5');
INSERT INTO `ciudad` VALUES ('208', 'El Carmen de Bolívar', '5');
INSERT INTO `ciudad` VALUES ('209', 'El Guamo', '5');
INSERT INTO `ciudad` VALUES ('210', 'El Peñón', '5');
INSERT INTO `ciudad` VALUES ('211', 'Hatillo de Loba', '5');
INSERT INTO `ciudad` VALUES ('212', 'Magangué', '5');
INSERT INTO `ciudad` VALUES ('213', 'Mahates', '5');
INSERT INTO `ciudad` VALUES ('214', 'Malagana', '5');
INSERT INTO `ciudad` VALUES ('215', 'Margarita', '5');
INSERT INTO `ciudad` VALUES ('216', 'María La Baja', '5');
INSERT INTO `ciudad` VALUES ('217', 'Mompós', '5');
INSERT INTO `ciudad` VALUES ('218', 'Montecristo', '5');
INSERT INTO `ciudad` VALUES ('219', 'Morales', '5');
INSERT INTO `ciudad` VALUES ('220', 'Pinillos', '5');
INSERT INTO `ciudad` VALUES ('221', 'Regidor', '5');
INSERT INTO `ciudad` VALUES ('222', 'Rioviejo', '5');
INSERT INTO `ciudad` VALUES ('223', 'San Cayetano', '5');
INSERT INTO `ciudad` VALUES ('224', 'San Cristóbal', '5');
INSERT INTO `ciudad` VALUES ('225', 'San Estanislao', '5');
INSERT INTO `ciudad` VALUES ('226', 'San Fernando', '5');
INSERT INTO `ciudad` VALUES ('227', 'San Jacinto', '5');
INSERT INTO `ciudad` VALUES ('228', 'San Juan Nepomuceno', '5');
INSERT INTO `ciudad` VALUES ('229', 'San Martín de Loba', '5');
INSERT INTO `ciudad` VALUES ('230', 'San Pablo', '5');
INSERT INTO `ciudad` VALUES ('231', 'Santa Catalina', '5');
INSERT INTO `ciudad` VALUES ('232', 'Santa Rosa', '5');
INSERT INTO `ciudad` VALUES ('233', 'Santa Rosa de Lima', '5');
INSERT INTO `ciudad` VALUES ('234', 'Santa Rosa del Sur', '5');
INSERT INTO `ciudad` VALUES ('235', 'Simití', '5');
INSERT INTO `ciudad` VALUES ('236', 'Sincerín', '5');
INSERT INTO `ciudad` VALUES ('237', 'Soplaviento', '5');
INSERT INTO `ciudad` VALUES ('238', 'Talaigua Nuevo', '5');
INSERT INTO `ciudad` VALUES ('239', 'Tiquisio', '5');
INSERT INTO `ciudad` VALUES ('240', 'Turbaco', '5');
INSERT INTO `ciudad` VALUES ('241', 'Turbaná', '5');
INSERT INTO `ciudad` VALUES ('242', 'Villanueva', '5');
INSERT INTO `ciudad` VALUES ('243', 'Zambrano', '5');
INSERT INTO `ciudad` VALUES ('244', 'Almeida', '6');
INSERT INTO `ciudad` VALUES ('245', 'Aquitania', '6');
INSERT INTO `ciudad` VALUES ('246', 'Arcabuco', '6');
INSERT INTO `ciudad` VALUES ('247', 'Belén', '6');
INSERT INTO `ciudad` VALUES ('248', 'Belencito', '6');
INSERT INTO `ciudad` VALUES ('249', 'Berbeo', '6');
INSERT INTO `ciudad` VALUES ('250', 'Beteitiva', '6');
INSERT INTO `ciudad` VALUES ('251', 'Boavita', '6');
INSERT INTO `ciudad` VALUES ('252', 'Boyacá', '6');
INSERT INTO `ciudad` VALUES ('253', 'Briceño', '6');
INSERT INTO `ciudad` VALUES ('254', 'Buenavista', '6');
INSERT INTO `ciudad` VALUES ('255', 'Busbanza', '6');
INSERT INTO `ciudad` VALUES ('256', 'Caldas', '6');
INSERT INTO `ciudad` VALUES ('257', 'Campohermoso', '6');
INSERT INTO `ciudad` VALUES ('258', 'Cerinza', '6');
INSERT INTO `ciudad` VALUES ('259', 'Chinavita', '6');
INSERT INTO `ciudad` VALUES ('260', 'Chiquinquirá', '6');
INSERT INTO `ciudad` VALUES ('261', 'Chíquiza', '6');
INSERT INTO `ciudad` VALUES ('262', 'Chiscas', '6');
INSERT INTO `ciudad` VALUES ('263', 'Chita', '6');
INSERT INTO `ciudad` VALUES ('264', 'Chitaraque', '6');
INSERT INTO `ciudad` VALUES ('265', 'Chivatá', '6');
INSERT INTO `ciudad` VALUES ('266', 'Chivor', '6');
INSERT INTO `ciudad` VALUES ('267', 'Ciénaga', '6');
INSERT INTO `ciudad` VALUES ('268', 'Cómbita', '6');
INSERT INTO `ciudad` VALUES ('269', 'Coper', '6');
INSERT INTO `ciudad` VALUES ('270', 'Corrales', '6');
INSERT INTO `ciudad` VALUES ('271', 'Covarachía', '6');
INSERT INTO `ciudad` VALUES ('272', 'Cubará', '6');
INSERT INTO `ciudad` VALUES ('273', 'Cucaita', '6');
INSERT INTO `ciudad` VALUES ('274', 'Cuítiva', '6');
INSERT INTO `ciudad` VALUES ('275', 'Duitama', '6');
INSERT INTO `ciudad` VALUES ('276', 'El Cocuy', '6');
INSERT INTO `ciudad` VALUES ('277', 'El Espino', '6');
INSERT INTO `ciudad` VALUES ('278', 'Firavitoba', '6');
INSERT INTO `ciudad` VALUES ('279', 'Floresta', '6');
INSERT INTO `ciudad` VALUES ('280', 'Gachantivá', '6');
INSERT INTO `ciudad` VALUES ('281', 'Gámeza', '6');
INSERT INTO `ciudad` VALUES ('282', 'Garagoa', '6');
INSERT INTO `ciudad` VALUES ('283', 'Guacamayas', '6');
INSERT INTO `ciudad` VALUES ('284', 'Guateque', '6');
INSERT INTO `ciudad` VALUES ('285', 'Guayatá', '6');
INSERT INTO `ciudad` VALUES ('286', 'Güicán', '6');
INSERT INTO `ciudad` VALUES ('287', 'Iza', '6');
INSERT INTO `ciudad` VALUES ('288', 'Jenesano', '6');
INSERT INTO `ciudad` VALUES ('289', 'Jericó', '6');
INSERT INTO `ciudad` VALUES ('290', 'La Capilla', '6');
INSERT INTO `ciudad` VALUES ('291', 'La Uvita', '6');
INSERT INTO `ciudad` VALUES ('292', 'La Victoria', '6');
INSERT INTO `ciudad` VALUES ('293', 'Labranzagrande', '6');
INSERT INTO `ciudad` VALUES ('294', 'Laguna de Tota', '6');
INSERT INTO `ciudad` VALUES ('295', 'Macanal', '6');
INSERT INTO `ciudad` VALUES ('296', 'Maguncia', '6');
INSERT INTO `ciudad` VALUES ('297', 'Maripí', '6');
INSERT INTO `ciudad` VALUES ('298', 'Miraflores', '6');
INSERT INTO `ciudad` VALUES ('299', 'Mongua', '6');
INSERT INTO `ciudad` VALUES ('300', 'Monguí', '6');
INSERT INTO `ciudad` VALUES ('301', 'Moniquirá', '6');
INSERT INTO `ciudad` VALUES ('302', 'Motavita', '6');
INSERT INTO `ciudad` VALUES ('303', 'Muzo', '6');
INSERT INTO `ciudad` VALUES ('304', 'Nobsa', '6');
INSERT INTO `ciudad` VALUES ('305', 'Nuevo Colón', '6');
INSERT INTO `ciudad` VALUES ('306', 'Oicatá', '6');
INSERT INTO `ciudad` VALUES ('307', 'Otanche', '6');
INSERT INTO `ciudad` VALUES ('308', 'Pachavita', '6');
INSERT INTO `ciudad` VALUES ('309', 'Páez', '6');
INSERT INTO `ciudad` VALUES ('310', 'Paipa', '6');
INSERT INTO `ciudad` VALUES ('311', 'Pajarito', '6');
INSERT INTO `ciudad` VALUES ('312', 'Panqueba', '6');
INSERT INTO `ciudad` VALUES ('313', 'Pauna', '6');
INSERT INTO `ciudad` VALUES ('314', 'Paya', '6');
INSERT INTO `ciudad` VALUES ('315', 'Paz del Río', '6');
INSERT INTO `ciudad` VALUES ('316', 'Pesca', '6');
INSERT INTO `ciudad` VALUES ('317', 'Pisba', '6');
INSERT INTO `ciudad` VALUES ('318', 'Puerto Boyacá', '6');
INSERT INTO `ciudad` VALUES ('319', 'Quípama', '6');
INSERT INTO `ciudad` VALUES ('320', 'Ramiriquí', '6');
INSERT INTO `ciudad` VALUES ('321', 'Ráquira', '6');
INSERT INTO `ciudad` VALUES ('322', 'Rondón', '6');
INSERT INTO `ciudad` VALUES ('323', 'Saboyá', '6');
INSERT INTO `ciudad` VALUES ('324', 'Sáchica', '6');
INSERT INTO `ciudad` VALUES ('325', 'Samacá', '6');
INSERT INTO `ciudad` VALUES ('326', 'San Eduardo', '6');
INSERT INTO `ciudad` VALUES ('327', 'San José de Pare', '6');
INSERT INTO `ciudad` VALUES ('328', 'San Luis de Gaceno', '6');
INSERT INTO `ciudad` VALUES ('329', 'San Mateo', '6');
INSERT INTO `ciudad` VALUES ('330', 'San Miguel de Sema', '6');
INSERT INTO `ciudad` VALUES ('331', 'San Pablo de Borbur', '6');
INSERT INTO `ciudad` VALUES ('332', 'Santa María', '6');
INSERT INTO `ciudad` VALUES ('333', 'Santa Rosa de Viterbo', '6');
INSERT INTO `ciudad` VALUES ('334', 'Santa Sofía', '6');
INSERT INTO `ciudad` VALUES ('335', 'Santana', '6');
INSERT INTO `ciudad` VALUES ('336', 'Sativanorte', '6');
INSERT INTO `ciudad` VALUES ('337', 'Sativasur', '6');
INSERT INTO `ciudad` VALUES ('338', 'Siachoque', '6');
INSERT INTO `ciudad` VALUES ('339', 'Soatá', '6');
INSERT INTO `ciudad` VALUES ('340', 'Socha', '6');
INSERT INTO `ciudad` VALUES ('341', 'Socotá', '6');
INSERT INTO `ciudad` VALUES ('342', 'Sogamoso', '6');
INSERT INTO `ciudad` VALUES ('343', 'Somondoco', '6');
INSERT INTO `ciudad` VALUES ('344', 'SoraSoracá', '6');
INSERT INTO `ciudad` VALUES ('345', 'Sotaquirá', '6');
INSERT INTO `ciudad` VALUES ('346', 'Susacón', '6');
INSERT INTO `ciudad` VALUES ('347', 'Susón', '6');
INSERT INTO `ciudad` VALUES ('348', 'Sutamarchán', '6');
INSERT INTO `ciudad` VALUES ('349', 'Sutatenza', '6');
INSERT INTO `ciudad` VALUES ('350', 'Tasco', '6');
INSERT INTO `ciudad` VALUES ('351', 'Tenza', '6');
INSERT INTO `ciudad` VALUES ('352', 'Tibaná', '6');
INSERT INTO `ciudad` VALUES ('353', 'Tibasosa', '6');
INSERT INTO `ciudad` VALUES ('354', 'Tinjacá', '6');
INSERT INTO `ciudad` VALUES ('355', 'Tipacoque', '6');
INSERT INTO `ciudad` VALUES ('356', 'Toca', '6');
INSERT INTO `ciudad` VALUES ('357', 'Toguí', '6');
INSERT INTO `ciudad` VALUES ('358', 'Tópaga', '6');
INSERT INTO `ciudad` VALUES ('359', 'Tota', '6');
INSERT INTO `ciudad` VALUES ('360', 'Tunja', '6');
INSERT INTO `ciudad` VALUES ('361', 'Tunungua', '6');
INSERT INTO `ciudad` VALUES ('362', 'Turmequé', '6');
INSERT INTO `ciudad` VALUES ('363', 'Tuta', '6');
INSERT INTO `ciudad` VALUES ('364', 'Tutasa', '6');
INSERT INTO `ciudad` VALUES ('365', 'Umbita', '6');
INSERT INTO `ciudad` VALUES ('366', 'Ventaquemada', '6');
INSERT INTO `ciudad` VALUES ('367', 'Villa de Leyva', '6');
INSERT INTO `ciudad` VALUES ('368', 'Viracachá', '6');
INSERT INTO `ciudad` VALUES ('369', 'Zetaquirá', '6');
INSERT INTO `ciudad` VALUES ('370', 'Aguadas', '7');
INSERT INTO `ciudad` VALUES ('371', 'Anserma', '7');
INSERT INTO `ciudad` VALUES ('372', 'Aranzazu', '7');
INSERT INTO `ciudad` VALUES ('373', 'Belalcázar', '7');
INSERT INTO `ciudad` VALUES ('374', 'Chinchiná', '7');
INSERT INTO `ciudad` VALUES ('375', 'Filadelfia', '7');
INSERT INTO `ciudad` VALUES ('376', 'La Dorada', '7');
INSERT INTO `ciudad` VALUES ('377', 'La Merced', '7');
INSERT INTO `ciudad` VALUES ('378', 'Manizales', '7');
INSERT INTO `ciudad` VALUES ('379', 'Manzanares', '7');
INSERT INTO `ciudad` VALUES ('380', 'Marmato', '7');
INSERT INTO `ciudad` VALUES ('381', 'Marquetalia', '7');
INSERT INTO `ciudad` VALUES ('382', 'Marulanda', '7');
INSERT INTO `ciudad` VALUES ('383', 'Neira', '7');
INSERT INTO `ciudad` VALUES ('384', 'Norcasia', '7');
INSERT INTO `ciudad` VALUES ('385', 'Pácora', '7');
INSERT INTO `ciudad` VALUES ('386', 'Palestina', '7');
INSERT INTO `ciudad` VALUES ('387', 'Pensilvania', '7');
INSERT INTO `ciudad` VALUES ('388', 'Riosucio', '7');
INSERT INTO `ciudad` VALUES ('389', 'Risaralda', '7');
INSERT INTO `ciudad` VALUES ('390', 'Salamina', '7');
INSERT INTO `ciudad` VALUES ('391', 'Samaná', '7');
INSERT INTO `ciudad` VALUES ('392', 'San José', '7');
INSERT INTO `ciudad` VALUES ('393', 'Supía', '7');
INSERT INTO `ciudad` VALUES ('394', 'Victoria', '7');
INSERT INTO `ciudad` VALUES ('395', 'Villamaría', '7');
INSERT INTO `ciudad` VALUES ('396', 'Viterbo', '7');
INSERT INTO `ciudad` VALUES ('397', 'Albania', '8');
INSERT INTO `ciudad` VALUES ('398', 'Belén de Los Andaquíes', '8');
INSERT INTO `ciudad` VALUES ('399', 'Cartagena del Chaira', '8');
INSERT INTO `ciudad` VALUES ('400', 'Curillo', '8');
INSERT INTO `ciudad` VALUES ('401', 'El Doncello', '8');
INSERT INTO `ciudad` VALUES ('402', 'El Paujil', '8');
INSERT INTO `ciudad` VALUES ('403', 'Florencia', '8');
INSERT INTO `ciudad` VALUES ('404', 'La Montañita', '8');
INSERT INTO `ciudad` VALUES ('405', 'La Solita', '8');
INSERT INTO `ciudad` VALUES ('406', 'Larandia', '8');
INSERT INTO `ciudad` VALUES ('407', 'Morelia', '8');
INSERT INTO `ciudad` VALUES ('408', 'Puerto Milán', '8');
INSERT INTO `ciudad` VALUES ('409', 'Puerto Rico', '8');
INSERT INTO `ciudad` VALUES ('410', 'Puerto Solano', '8');
INSERT INTO `ciudad` VALUES ('411', 'Rionegro', '8');
INSERT INTO `ciudad` VALUES ('412', 'San Antonio de Getucha', '8');
INSERT INTO `ciudad` VALUES ('413', 'San José del Fragua', '8');
INSERT INTO `ciudad` VALUES ('414', 'San Vicente del Caguán', '8');
INSERT INTO `ciudad` VALUES ('415', 'Tres Esquinas Solano', '8');
INSERT INTO `ciudad` VALUES ('416', 'Unión Peneya', '8');
INSERT INTO `ciudad` VALUES ('417', 'Valparaíso', '8');
INSERT INTO `ciudad` VALUES ('418', 'Venecia', '8');
INSERT INTO `ciudad` VALUES ('419', 'Aguazul', '9');
INSERT INTO `ciudad` VALUES ('420', 'Chámeza', '9');
INSERT INTO `ciudad` VALUES ('421', 'Hato Corozal', '9');
INSERT INTO `ciudad` VALUES ('422', 'La Salina', '9');
INSERT INTO `ciudad` VALUES ('423', 'Maní', '9');
INSERT INTO `ciudad` VALUES ('424', 'Monterrey', '9');
INSERT INTO `ciudad` VALUES ('425', 'Nunchía', '9');
INSERT INTO `ciudad` VALUES ('426', 'Orocué', '9');
INSERT INTO `ciudad` VALUES ('427', 'Paz de Ariporo', '9');
INSERT INTO `ciudad` VALUES ('428', 'Pore', '9');
INSERT INTO `ciudad` VALUES ('429', 'Recetor', '9');
INSERT INTO `ciudad` VALUES ('430', 'Sabanalarga', '9');
INSERT INTO `ciudad` VALUES ('431', 'Sacama', '9');
INSERT INTO `ciudad` VALUES ('432', 'San Luis de Palenque', '9');
INSERT INTO `ciudad` VALUES ('433', 'Támara', '9');
INSERT INTO `ciudad` VALUES ('434', 'Tauramena', '9');
INSERT INTO `ciudad` VALUES ('435', 'Trinidad', '9');
INSERT INTO `ciudad` VALUES ('436', 'Tumara', '9');
INSERT INTO `ciudad` VALUES ('437', 'Villanueva', '9');
INSERT INTO `ciudad` VALUES ('438', 'Yopal', '9');
INSERT INTO `ciudad` VALUES ('439', 'Almaguer', '10');
INSERT INTO `ciudad` VALUES ('440', 'ALTAMIRA', '10');
INSERT INTO `ciudad` VALUES ('441', 'Argelia', '10');
INSERT INTO `ciudad` VALUES ('442', 'Balboa', '10');
INSERT INTO `ciudad` VALUES ('443', 'Belalcázar', '10');
INSERT INTO `ciudad` VALUES ('444', 'Bolívar', '10');
INSERT INTO `ciudad` VALUES ('445', 'Buenos Aires', '10');
INSERT INTO `ciudad` VALUES ('446', 'Cajibío', '10');
INSERT INTO `ciudad` VALUES ('447', 'Caldono', '10');
INSERT INTO `ciudad` VALUES ('448', 'Caldoñó', '10');
INSERT INTO `ciudad` VALUES ('449', 'Caloto', '10');
INSERT INTO `ciudad` VALUES ('450', 'Coconuco', '10');
INSERT INTO `ciudad` VALUES ('451', 'Corinto', '10');
INSERT INTO `ciudad` VALUES ('452', 'CUATRO ESQUINAS', '10');
INSERT INTO `ciudad` VALUES ('453', 'El Bordo', '10');
INSERT INTO `ciudad` VALUES ('454', 'EL CAIRO', '10');
INSERT INTO `ciudad` VALUES ('455', 'El Carmen', '10');
INSERT INTO `ciudad` VALUES ('456', 'EL HATO', '10');
INSERT INTO `ciudad` VALUES ('457', 'El Morro', '10');
INSERT INTO `ciudad` VALUES ('458', 'EL PALMAR', '10');
INSERT INTO `ciudad` VALUES ('459', 'EL RETIRO', '10');
INSERT INTO `ciudad` VALUES ('460', 'EL ROSARIO', '10');
INSERT INTO `ciudad` VALUES ('461', 'El Tambo', '10');
INSERT INTO `ciudad` VALUES ('462', 'Florencia', '10');
INSERT INTO `ciudad` VALUES ('463', 'Guachené', '10');
INSERT INTO `ciudad` VALUES ('464', 'Guapi', '10');
INSERT INTO `ciudad` VALUES ('465', 'Inzá', '10');
INSERT INTO `ciudad` VALUES ('466', 'Jambálo', '10');
INSERT INTO `ciudad` VALUES ('467', 'La Carbonera', '10');
INSERT INTO `ciudad` VALUES ('468', 'LA CHORRERA', '10');
INSERT INTO `ciudad` VALUES ('469', 'La Herradura', '10');
INSERT INTO `ciudad` VALUES ('470', 'La Sierra', '10');
INSERT INTO `ciudad` VALUES ('471', 'La Vega', '10');
INSERT INTO `ciudad` VALUES ('472', 'LA VENTA', '10');
INSERT INTO `ciudad` VALUES ('473', 'LAS CRUCES', '10');
INSERT INTO `ciudad` VALUES ('474', 'López', '10');
INSERT INTO `ciudad` VALUES ('475', 'López de Micay', '10');
INSERT INTO `ciudad` VALUES ('476', 'Mercaderes', '10');
INSERT INTO `ciudad` VALUES ('477', 'Miranda', '10');
INSERT INTO `ciudad` VALUES ('478', 'Mondomo', '10');
INSERT INTO `ciudad` VALUES ('479', 'MONTERREDONDO', '10');
INSERT INTO `ciudad` VALUES ('480', 'Morales', '10');
INSERT INTO `ciudad` VALUES ('481', 'Padilla', '10');
INSERT INTO `ciudad` VALUES ('482', 'Páez', '10');
INSERT INTO `ciudad` VALUES ('483', 'Paispamba', '10');
INSERT INTO `ciudad` VALUES ('484', 'PARRAGA', '10');
INSERT INTO `ciudad` VALUES ('485', 'Patía ( El Bordo)', '10');
INSERT INTO `ciudad` VALUES ('486', 'PIAGUA', '10');
INSERT INTO `ciudad` VALUES ('487', 'Piamonte', '10');
INSERT INTO `ciudad` VALUES ('488', 'Piendamó', '10');
INSERT INTO `ciudad` VALUES ('489', 'Popayán', '10');
INSERT INTO `ciudad` VALUES ('490', 'Puerto Tejada', '10');
INSERT INTO `ciudad` VALUES ('491', 'Puracé', '10');
INSERT INTO `ciudad` VALUES ('492', 'QUILICACERIO', '10');
INSERT INTO `ciudad` VALUES ('493', 'BLANCO', '10');
INSERT INTO `ciudad` VALUES ('494', 'Rosas', '10');
INSERT INTO `ciudad` VALUES ('495', 'San Joaquín', '10');
INSERT INTO `ciudad` VALUES ('496', 'SAN MIGUEL', '10');
INSERT INTO `ciudad` VALUES ('497', 'San Sebastián', '10');
INSERT INTO `ciudad` VALUES ('498', 'SANTA RITA', '10');
INSERT INTO `ciudad` VALUES ('499', 'Santa Rosa', '10');
INSERT INTO `ciudad` VALUES ('500', 'SANTA ROSA BOTA CAUCANA', '10');
INSERT INTO `ciudad` VALUES ('501', 'Santander de Quilichao', '10');
INSERT INTO `ciudad` VALUES ('502', 'SIBERIA', '10');
INSERT INTO `ciudad` VALUES ('503', 'Silvia', '10');
INSERT INTO `ciudad` VALUES ('504', 'Sotará', '10');
INSERT INTO `ciudad` VALUES ('505', 'Suárez', '10');
INSERT INTO `ciudad` VALUES ('506', 'Timbío', '10');
INSERT INTO `ciudad` VALUES ('507', 'Timbiquí', '10');
INSERT INTO `ciudad` VALUES ('508', 'Toribío', '10');
INSERT INTO `ciudad` VALUES ('509', 'Totoró', '10');
INSERT INTO `ciudad` VALUES ('510', 'Tunía', '10');
INSERT INTO `ciudad` VALUES ('511', 'Villarica', '10');
INSERT INTO `ciudad` VALUES ('512', 'ZARZAL', '10');
INSERT INTO `ciudad` VALUES ('513', 'Aguachica', '11');
INSERT INTO `ciudad` VALUES ('514', 'Agustín Codazzi', '11');
INSERT INTO `ciudad` VALUES ('515', 'Becerril', '11');
INSERT INTO `ciudad` VALUES ('516', 'Bosconia', '11');
INSERT INTO `ciudad` VALUES ('517', 'Chimichagua', '11');
INSERT INTO `ciudad` VALUES ('518', 'Chiriguaná', '11');
INSERT INTO `ciudad` VALUES ('519', 'Curumaní', '11');
INSERT INTO `ciudad` VALUES ('520', 'El Copey', '11');
INSERT INTO `ciudad` VALUES ('521', 'El Paso', '11');
INSERT INTO `ciudad` VALUES ('522', 'Gamarra', '11');
INSERT INTO `ciudad` VALUES ('523', 'González', '11');
INSERT INTO `ciudad` VALUES ('524', 'La Gloria', '11');
INSERT INTO `ciudad` VALUES ('525', 'La Paz', '11');
INSERT INTO `ciudad` VALUES ('526', 'Pailitas', '11');
INSERT INTO `ciudad` VALUES ('527', 'Pelaya', '11');
INSERT INTO `ciudad` VALUES ('528', 'Río de Oro', '11');
INSERT INTO `ciudad` VALUES ('529', 'San Alberto', '11');
INSERT INTO `ciudad` VALUES ('530', 'San Diego', '11');
INSERT INTO `ciudad` VALUES ('531', 'San Martín', '11');
INSERT INTO `ciudad` VALUES ('532', 'Tamalameque', '11');
INSERT INTO `ciudad` VALUES ('533', 'Valledupar', '11');
INSERT INTO `ciudad` VALUES ('534', 'Pueblo Bello', '11');
INSERT INTO `ciudad` VALUES ('535', 'Astrea', '11');
INSERT INTO `ciudad` VALUES ('536', 'Manaure Balcón del Cesar', '11');
INSERT INTO `ciudad` VALUES ('537', 'Acandí', '12');
INSERT INTO `ciudad` VALUES ('538', 'Alto Baudó', '12');
INSERT INTO `ciudad` VALUES ('539', 'Atradó', '12');
INSERT INTO `ciudad` VALUES ('540', 'Bagadó', '12');
INSERT INTO `ciudad` VALUES ('541', 'Bahía Solano', '12');
INSERT INTO `ciudad` VALUES ('542', 'Bajo Baudó', '12');
INSERT INTO `ciudad` VALUES ('543', 'Bojaya', '12');
INSERT INTO `ciudad` VALUES ('544', 'Carmen de Atrato', '12');
INSERT INTO `ciudad` VALUES ('545', 'Chocó', '12');
INSERT INTO `ciudad` VALUES ('546', 'Condoto', '12');
INSERT INTO `ciudad` VALUES ('547', 'El Cantón de San Pablo', '12');
INSERT INTO `ciudad` VALUES ('548', 'Istmina', '12');
INSERT INTO `ciudad` VALUES ('549', 'Juradó', '12');
INSERT INTO `ciudad` VALUES ('550', 'Litoral de San Juan', '12');
INSERT INTO `ciudad` VALUES ('551', 'Lloró', '12');
INSERT INTO `ciudad` VALUES ('552', 'Noquí', '12');
INSERT INTO `ciudad` VALUES ('553', 'Novita', '12');
INSERT INTO `ciudad` VALUES ('554', 'Nuquí', '12');
INSERT INTO `ciudad` VALUES ('555', 'Quibdó', '12');
INSERT INTO `ciudad` VALUES ('556', 'Riosucio', '12');
INSERT INTO `ciudad` VALUES ('557', 'San José del Palmar', '12');
INSERT INTO `ciudad` VALUES ('558', 'Sipí', '12');
INSERT INTO `ciudad` VALUES ('559', 'Tadó', '12');
INSERT INTO `ciudad` VALUES ('560', 'Unguía', '12');
INSERT INTO `ciudad` VALUES ('561', 'Carmen del Darién', '12');
INSERT INTO `ciudad` VALUES ('562', 'Pizarro', '12');
INSERT INTO `ciudad` VALUES ('563', 'Ayapel', '13');
INSERT INTO `ciudad` VALUES ('564', 'Buenavista', '13');
INSERT INTO `ciudad` VALUES ('565', 'Canalete', '13');
INSERT INTO `ciudad` VALUES ('566', 'Cereté', '13');
INSERT INTO `ciudad` VALUES ('567', 'Chimá', '13');
INSERT INTO `ciudad` VALUES ('568', 'Chinú', '13');
INSERT INTO `ciudad` VALUES ('569', 'Ciénaga de Oro', '13');
INSERT INTO `ciudad` VALUES ('570', 'Cotorra', '13');
INSERT INTO `ciudad` VALUES ('571', 'La Apartada', '13');
INSERT INTO `ciudad` VALUES ('572', 'Lorica', '13');
INSERT INTO `ciudad` VALUES ('573', 'Los Córdobas', '13');
INSERT INTO `ciudad` VALUES ('574', 'Momil', '13');
INSERT INTO `ciudad` VALUES ('575', 'Monitos', '13');
INSERT INTO `ciudad` VALUES ('576', 'Montelíbano', '13');
INSERT INTO `ciudad` VALUES ('577', 'Montería', '13');
INSERT INTO `ciudad` VALUES ('578', 'Planeta Rica', '13');
INSERT INTO `ciudad` VALUES ('579', 'Pueblo Nuevo', '13');
INSERT INTO `ciudad` VALUES ('580', 'Puerto Escondido', '13');
INSERT INTO `ciudad` VALUES ('581', 'Puerto Libertador', '13');
INSERT INTO `ciudad` VALUES ('582', 'Purísima', '13');
INSERT INTO `ciudad` VALUES ('583', 'Sahagún', '13');
INSERT INTO `ciudad` VALUES ('584', 'San Andrés de Sotavento', '13');
INSERT INTO `ciudad` VALUES ('585', 'San Antero', '13');
INSERT INTO `ciudad` VALUES ('586', 'San Bernardo del Viento', '13');
INSERT INTO `ciudad` VALUES ('587', 'San Carlos', '13');
INSERT INTO `ciudad` VALUES ('588', 'San Pelayo', '13');
INSERT INTO `ciudad` VALUES ('589', 'Tierralta', '13');
INSERT INTO `ciudad` VALUES ('590', 'Valencia', '13');
INSERT INTO `ciudad` VALUES ('591', 'Agua de Dios', '14');
INSERT INTO `ciudad` VALUES ('592', 'Albán', '14');
INSERT INTO `ciudad` VALUES ('593', 'Anapoima', '14');
INSERT INTO `ciudad` VALUES ('594', 'Anolaima', '14');
INSERT INTO `ciudad` VALUES ('595', 'Apulo', '14');
INSERT INTO `ciudad` VALUES ('596', 'Arbeláez', '14');
INSERT INTO `ciudad` VALUES ('597', 'Beltrán', '14');
INSERT INTO `ciudad` VALUES ('598', 'Bituima', '14');
INSERT INTO `ciudad` VALUES ('599', 'Bojacá', '14');
INSERT INTO `ciudad` VALUES ('600', 'Cabrera', '14');
INSERT INTO `ciudad` VALUES ('601', 'Cachipay', '14');
INSERT INTO `ciudad` VALUES ('602', 'Cajicá', '14');
INSERT INTO `ciudad` VALUES ('603', 'Caparrapí', '14');
INSERT INTO `ciudad` VALUES ('604', 'Cáqueza', '14');
INSERT INTO `ciudad` VALUES ('605', 'Carmen de Carupa', '14');
INSERT INTO `ciudad` VALUES ('606', 'Chaguaní', '14');
INSERT INTO `ciudad` VALUES ('607', 'Chía', '14');
INSERT INTO `ciudad` VALUES ('608', 'Chinauta', '14');
INSERT INTO `ciudad` VALUES ('609', 'Chipaque', '14');
INSERT INTO `ciudad` VALUES ('610', 'Choachí', '14');
INSERT INTO `ciudad` VALUES ('611', 'Chocontá', '14');
INSERT INTO `ciudad` VALUES ('612', 'Cogua', '14');
INSERT INTO `ciudad` VALUES ('613', 'Cota', '14');
INSERT INTO `ciudad` VALUES ('614', 'Cucunubá', '14');
INSERT INTO `ciudad` VALUES ('615', 'El Colegio', '14');
INSERT INTO `ciudad` VALUES ('616', 'El Peñón', '14');
INSERT INTO `ciudad` VALUES ('617', 'El Rosal', '14');
INSERT INTO `ciudad` VALUES ('618', 'Facatativá', '14');
INSERT INTO `ciudad` VALUES ('619', 'Fómeque', '14');
INSERT INTO `ciudad` VALUES ('620', 'Fosca', '14');
INSERT INTO `ciudad` VALUES ('621', 'Funza', '14');
INSERT INTO `ciudad` VALUES ('622', 'Fúquene', '14');
INSERT INTO `ciudad` VALUES ('623', 'Fusagasugá', '14');
INSERT INTO `ciudad` VALUES ('624', 'Gachalá', '14');
INSERT INTO `ciudad` VALUES ('625', 'Gachancipá', '14');
INSERT INTO `ciudad` VALUES ('626', 'Gachetá', '14');
INSERT INTO `ciudad` VALUES ('627', 'Gama', '14');
INSERT INTO `ciudad` VALUES ('628', 'Girardot', '14');
INSERT INTO `ciudad` VALUES ('629', 'Granada', '14');
INSERT INTO `ciudad` VALUES ('630', 'Guachetá', '14');
INSERT INTO `ciudad` VALUES ('631', 'Guaduas', '14');
INSERT INTO `ciudad` VALUES ('632', 'Guasca', '14');
INSERT INTO `ciudad` VALUES ('633', 'Guataquí', '14');
INSERT INTO `ciudad` VALUES ('634', 'Guatavita', '14');
INSERT INTO `ciudad` VALUES ('635', 'Guayabal de Síquima', '14');
INSERT INTO `ciudad` VALUES ('636', 'Guayabetal', '14');
INSERT INTO `ciudad` VALUES ('637', 'Gutiérrez', '14');
INSERT INTO `ciudad` VALUES ('638', 'Jerusalén', '14');
INSERT INTO `ciudad` VALUES ('639', 'Junín', '14');
INSERT INTO `ciudad` VALUES ('640', 'La Calera', '14');
INSERT INTO `ciudad` VALUES ('641', 'La Mesa', '14');
INSERT INTO `ciudad` VALUES ('642', 'La Palma', '14');
INSERT INTO `ciudad` VALUES ('643', 'La Peña', '14');
INSERT INTO `ciudad` VALUES ('644', 'La Vega', '14');
INSERT INTO `ciudad` VALUES ('645', 'Lenguazaque', '14');
INSERT INTO `ciudad` VALUES ('646', 'Machetá', '14');
INSERT INTO `ciudad` VALUES ('647', 'Madrid', '14');
INSERT INTO `ciudad` VALUES ('648', 'Manta', '14');
INSERT INTO `ciudad` VALUES ('649', 'Medina', '14');
INSERT INTO `ciudad` VALUES ('650', 'Mosquera', '14');
INSERT INTO `ciudad` VALUES ('651', 'Nariño', '14');
INSERT INTO `ciudad` VALUES ('652', 'Nemocón', '14');
INSERT INTO `ciudad` VALUES ('653', 'Nilo', '14');
INSERT INTO `ciudad` VALUES ('654', 'Nimaima', '14');
INSERT INTO `ciudad` VALUES ('655', 'Nocaima', '14');
INSERT INTO `ciudad` VALUES ('656', 'Pacho', '14');
INSERT INTO `ciudad` VALUES ('657', 'Paime', '14');
INSERT INTO `ciudad` VALUES ('658', 'Pandi', '14');
INSERT INTO `ciudad` VALUES ('659', 'Paratebueno', '14');
INSERT INTO `ciudad` VALUES ('660', 'Pasca', '14');
INSERT INTO `ciudad` VALUES ('661', 'Puerto Salgar', '14');
INSERT INTO `ciudad` VALUES ('662', 'Pulí', '14');
INSERT INTO `ciudad` VALUES ('663', 'Quebradanegra', '14');
INSERT INTO `ciudad` VALUES ('664', 'Quetame', '14');
INSERT INTO `ciudad` VALUES ('665', 'Quipile', '14');
INSERT INTO `ciudad` VALUES ('666', 'Ricaurte', '14');
INSERT INTO `ciudad` VALUES ('667', 'San Antonio del Tequendama', '14');
INSERT INTO `ciudad` VALUES ('668', 'San Bernardo', '14');
INSERT INTO `ciudad` VALUES ('669', 'San Cayetano', '14');
INSERT INTO `ciudad` VALUES ('670', 'San Francisco', '14');
INSERT INTO `ciudad` VALUES ('671', 'San Juan de Rioseco', '14');
INSERT INTO `ciudad` VALUES ('672', 'Sasaima', '14');
INSERT INTO `ciudad` VALUES ('673', 'Sesquilé', '14');
INSERT INTO `ciudad` VALUES ('674', 'Sibaté', '14');
INSERT INTO `ciudad` VALUES ('675', 'Silvania', '14');
INSERT INTO `ciudad` VALUES ('676', 'Simijaca', '14');
INSERT INTO `ciudad` VALUES ('677', 'Sisga', '14');
INSERT INTO `ciudad` VALUES ('678', 'Soacha', '14');
INSERT INTO `ciudad` VALUES ('679', 'Sopó', '14');
INSERT INTO `ciudad` VALUES ('680', 'Subachoque', '14');
INSERT INTO `ciudad` VALUES ('681', 'Suesca', '14');
INSERT INTO `ciudad` VALUES ('682', 'Supatá', '14');
INSERT INTO `ciudad` VALUES ('683', 'Susa', '14');
INSERT INTO `ciudad` VALUES ('684', 'Sutatausa', '14');
INSERT INTO `ciudad` VALUES ('685', 'Tabio', '14');
INSERT INTO `ciudad` VALUES ('686', 'Tausa', '14');
INSERT INTO `ciudad` VALUES ('687', 'Tena', '14');
INSERT INTO `ciudad` VALUES ('688', 'Tenjo', '14');
INSERT INTO `ciudad` VALUES ('689', 'Tibacuy', '14');
INSERT INTO `ciudad` VALUES ('690', 'Tibirita', '14');
INSERT INTO `ciudad` VALUES ('691', 'Tocaima', '14');
INSERT INTO `ciudad` VALUES ('692', 'Tocancipá', '14');
INSERT INTO `ciudad` VALUES ('693', 'Topaipí', '14');
INSERT INTO `ciudad` VALUES ('694', 'Ubalá', '14');
INSERT INTO `ciudad` VALUES ('695', 'Ubaque', '14');
INSERT INTO `ciudad` VALUES ('696', 'Ubaté', '14');
INSERT INTO `ciudad` VALUES ('697', 'Une', '14');
INSERT INTO `ciudad` VALUES ('698', 'Utica', '14');
INSERT INTO `ciudad` VALUES ('699', 'Venecia - Ospina Pérez', '14');
INSERT INTO `ciudad` VALUES ('700', 'Vergara', '14');
INSERT INTO `ciudad` VALUES ('701', 'Viani', '14');
INSERT INTO `ciudad` VALUES ('702', 'Villagómez', '14');
INSERT INTO `ciudad` VALUES ('703', 'Villapinzón', '14');
INSERT INTO `ciudad` VALUES ('704', 'Villeta', '14');
INSERT INTO `ciudad` VALUES ('705', 'Viotá', '14');
INSERT INTO `ciudad` VALUES ('706', 'Yacopí', '14');
INSERT INTO `ciudad` VALUES ('707', 'Zipacón', '14');
INSERT INTO `ciudad` VALUES ('708', 'Zipaquirá', '14');
INSERT INTO `ciudad` VALUES ('709', 'Capellania', '14');
INSERT INTO `ciudad` VALUES ('710', 'La Punta', '14');
INSERT INTO `ciudad` VALUES ('711', 'Santandercito', '14');
INSERT INTO `ciudad` VALUES ('712', 'Tobia', '14');
INSERT INTO `ciudad` VALUES ('713', 'Siberia', '14');
INSERT INTO `ciudad` VALUES ('714', 'Inírida', '15');
INSERT INTO `ciudad` VALUES ('715', 'Guaviare', '15');
INSERT INTO `ciudad` VALUES ('716', 'Puerto Inírida', '15');
INSERT INTO `ciudad` VALUES ('717', 'San José Del Guaviare', '16');
INSERT INTO `ciudad` VALUES ('718', 'Calamar', '16');
INSERT INTO `ciudad` VALUES ('719', 'El Retorno', '16');
INSERT INTO `ciudad` VALUES ('720', 'Miraflores', '16');
INSERT INTO `ciudad` VALUES ('721', 'Morichal', '16');
INSERT INTO `ciudad` VALUES ('722', 'Acevedo', '17');
INSERT INTO `ciudad` VALUES ('723', 'Agrado', '17');
INSERT INTO `ciudad` VALUES ('724', 'Aipe', '17');
INSERT INTO `ciudad` VALUES ('725', 'Algeciras', '17');
INSERT INTO `ciudad` VALUES ('726', 'Altamira', '17');
INSERT INTO `ciudad` VALUES ('727', 'Baraya', '17');
INSERT INTO `ciudad` VALUES ('728', 'Campoalegre', '17');
INSERT INTO `ciudad` VALUES ('729', 'Ciudad de Colombia', '17');
INSERT INTO `ciudad` VALUES ('730', 'Elías', '17');
INSERT INTO `ciudad` VALUES ('731', 'Fortalecillas', '17');
INSERT INTO `ciudad` VALUES ('732', 'Garzón', '17');
INSERT INTO `ciudad` VALUES ('733', 'Gigante', '17');
INSERT INTO `ciudad` VALUES ('734', 'Guadalupe', '17');
INSERT INTO `ciudad` VALUES ('735', 'Hobo', '17');
INSERT INTO `ciudad` VALUES ('736', 'Iquira', '17');
INSERT INTO `ciudad` VALUES ('737', 'Isnos', '17');
INSERT INTO `ciudad` VALUES ('738', 'La Argentina', '17');
INSERT INTO `ciudad` VALUES ('739', 'La Plata', '17');
INSERT INTO `ciudad` VALUES ('740', 'Nátaga', '17');
INSERT INTO `ciudad` VALUES ('741', 'Neiva', '17');
INSERT INTO `ciudad` VALUES ('742', 'Oporapa', '17');
INSERT INTO `ciudad` VALUES ('743', 'Paicol', '17');
INSERT INTO `ciudad` VALUES ('744', 'Palermo', '17');
INSERT INTO `ciudad` VALUES ('745', 'Palestina', '17');
INSERT INTO `ciudad` VALUES ('746', 'Pital', '17');
INSERT INTO `ciudad` VALUES ('747', 'Pitalito', '17');
INSERT INTO `ciudad` VALUES ('748', 'Rivera', '17');
INSERT INTO `ciudad` VALUES ('749', 'Saladoblanco', '17');
INSERT INTO `ciudad` VALUES ('750', 'San Agustín', '17');
INSERT INTO `ciudad` VALUES ('751', 'Santa María', '17');
INSERT INTO `ciudad` VALUES ('752', 'Suaza', '17');
INSERT INTO `ciudad` VALUES ('753', 'Tárqui', '17');
INSERT INTO `ciudad` VALUES ('754', 'Tello', '17');
INSERT INTO `ciudad` VALUES ('755', 'Teruel', '17');
INSERT INTO `ciudad` VALUES ('756', 'Tesalia', '17');
INSERT INTO `ciudad` VALUES ('757', 'Timaná', '17');
INSERT INTO `ciudad` VALUES ('758', 'Villavieja', '17');
INSERT INTO `ciudad` VALUES ('759', 'Yaguará', '17');
INSERT INTO `ciudad` VALUES ('760', 'Caguán', '17');
INSERT INTO `ciudad` VALUES ('761', 'Juncal', '17');
INSERT INTO `ciudad` VALUES ('762', 'La Jagua', '17');
INSERT INTO `ciudad` VALUES ('763', 'La Ulloa', '17');
INSERT INTO `ciudad` VALUES ('764', 'Maito', '17');
INSERT INTO `ciudad` VALUES ('765', 'Pacarní', '17');
INSERT INTO `ciudad` VALUES ('766', 'Santa Helena', '17');
INSERT INTO `ciudad` VALUES ('767', 'Vegalarga', '17');
INSERT INTO `ciudad` VALUES ('768', 'Zuluaga', '17');
INSERT INTO `ciudad` VALUES ('769', 'Belén', '17');
INSERT INTO `ciudad` VALUES ('770', 'Barrancas', '18');
INSERT INTO `ciudad` VALUES ('771', 'Dibulia', '18');
INSERT INTO `ciudad` VALUES ('772', 'Distracción', '18');
INSERT INTO `ciudad` VALUES ('773', 'El Molino', '18');
INSERT INTO `ciudad` VALUES ('774', 'Fonseca', '18');
INSERT INTO `ciudad` VALUES ('775', 'Hato Nuevo', '18');
INSERT INTO `ciudad` VALUES ('776', 'Manaure', '18');
INSERT INTO `ciudad` VALUES ('777', 'Riohacha', '18');
INSERT INTO `ciudad` VALUES ('778', 'San Juan del Cesar', '18');
INSERT INTO `ciudad` VALUES ('779', 'Uribia', '18');
INSERT INTO `ciudad` VALUES ('780', 'Urumita', '18');
INSERT INTO `ciudad` VALUES ('781', 'Maicao', '18');
INSERT INTO `ciudad` VALUES ('782', 'Villanueva', '18');
INSERT INTO `ciudad` VALUES ('783', 'Albania', '18');
INSERT INTO `ciudad` VALUES ('784', 'Algarrobo', '19');
INSERT INTO `ciudad` VALUES ('785', 'Aracataca', '19');
INSERT INTO `ciudad` VALUES ('786', 'Ariguaní', '19');
INSERT INTO `ciudad` VALUES ('787', 'Cerro de San Antonio', '19');
INSERT INTO `ciudad` VALUES ('788', 'Chivolo', '19');
INSERT INTO `ciudad` VALUES ('789', 'Ciénaga', '19');
INSERT INTO `ciudad` VALUES ('790', 'Concordia', '19');
INSERT INTO `ciudad` VALUES ('791', 'El Banco', '19');
INSERT INTO `ciudad` VALUES ('792', 'El Difícil', '19');
INSERT INTO `ciudad` VALUES ('793', 'El Piñón', '19');
INSERT INTO `ciudad` VALUES ('794', 'El Retén', '19');
INSERT INTO `ciudad` VALUES ('795', 'Fundación', '19');
INSERT INTO `ciudad` VALUES ('796', 'Guamal', '19');
INSERT INTO `ciudad` VALUES ('797', 'Pedraza', '19');
INSERT INTO `ciudad` VALUES ('798', 'Pijiño del Carmen', '19');
INSERT INTO `ciudad` VALUES ('799', 'Pivijay', '19');
INSERT INTO `ciudad` VALUES ('800', 'Plato', '19');
INSERT INTO `ciudad` VALUES ('801', 'Puebloviejo', '19');
INSERT INTO `ciudad` VALUES ('802', 'Remolino', '19');
INSERT INTO `ciudad` VALUES ('803', 'Salamina', '19');
INSERT INTO `ciudad` VALUES ('804', 'San Angel', '19');
INSERT INTO `ciudad` VALUES ('805', 'San Sebastián de Buenavista', '19');
INSERT INTO `ciudad` VALUES ('806', 'San Zenón', '19');
INSERT INTO `ciudad` VALUES ('807', 'Santa Ana', '19');
INSERT INTO `ciudad` VALUES ('808', 'Santa Marta', '19');
INSERT INTO `ciudad` VALUES ('809', 'Sitionuevo', '19');
INSERT INTO `ciudad` VALUES ('810', 'Tenerife', '19');
INSERT INTO `ciudad` VALUES ('811', 'Zona Bananera', '19');
INSERT INTO `ciudad` VALUES ('812', 'Acacías', '20');
INSERT INTO `ciudad` VALUES ('813', 'Barranca de Upia', '20');
INSERT INTO `ciudad` VALUES ('814', 'Cabuyaro', '20');
INSERT INTO `ciudad` VALUES ('815', 'Castilla La Nueva', '20');
INSERT INTO `ciudad` VALUES ('816', 'Cubarral', '20');
INSERT INTO `ciudad` VALUES ('817', 'Cumaral', '20');
INSERT INTO `ciudad` VALUES ('818', 'El Calvario', '20');
INSERT INTO `ciudad` VALUES ('819', 'El Castillo', '20');
INSERT INTO `ciudad` VALUES ('820', 'El Dorado', '20');
INSERT INTO `ciudad` VALUES ('821', 'Fuente de Oro', '20');
INSERT INTO `ciudad` VALUES ('822', 'Granada', '20');
INSERT INTO `ciudad` VALUES ('823', 'Guamal', '20');
INSERT INTO `ciudad` VALUES ('824', 'La Macarena', '20');
INSERT INTO `ciudad` VALUES ('825', 'La Uribe', '20');
INSERT INTO `ciudad` VALUES ('826', 'Lejanías', '20');
INSERT INTO `ciudad` VALUES ('827', 'Mapiripán', '20');
INSERT INTO `ciudad` VALUES ('828', 'Mesetas', '20');
INSERT INTO `ciudad` VALUES ('829', 'Puerto Concordia', '20');
INSERT INTO `ciudad` VALUES ('830', 'Puerto Gaitán', '20');
INSERT INTO `ciudad` VALUES ('831', 'Puerto Lleras', '20');
INSERT INTO `ciudad` VALUES ('832', 'Puerto López', '20');
INSERT INTO `ciudad` VALUES ('833', 'Puerto Rico', '20');
INSERT INTO `ciudad` VALUES ('834', 'Restrepo', '20');
INSERT INTO `ciudad` VALUES ('835', 'San Carlos Guaroa', '20');
INSERT INTO `ciudad` VALUES ('836', 'San Juan de Arama', '20');
INSERT INTO `ciudad` VALUES ('837', 'San Juanito', '20');
INSERT INTO `ciudad` VALUES ('838', 'San Martín', '20');
INSERT INTO `ciudad` VALUES ('839', 'Villavicencio', '20');
INSERT INTO `ciudad` VALUES ('840', 'Vista Hermosa', '20');
INSERT INTO `ciudad` VALUES ('841', 'Albán', '21');
INSERT INTO `ciudad` VALUES ('842', 'Aldana', '21');
INSERT INTO `ciudad` VALUES ('843', 'Ancuyá', '21');
INSERT INTO `ciudad` VALUES ('844', 'Arboleda', '21');
INSERT INTO `ciudad` VALUES ('845', 'Barbacoas', '21');
INSERT INTO `ciudad` VALUES ('846', 'Belén', '21');
INSERT INTO `ciudad` VALUES ('847', 'Berruecos', '21');
INSERT INTO `ciudad` VALUES ('848', 'Bomboná', '21');
INSERT INTO `ciudad` VALUES ('849', 'Buesaco', '21');
INSERT INTO `ciudad` VALUES ('850', 'Catambuco', '21');
INSERT INTO `ciudad` VALUES ('851', 'Chachaguí', '21');
INSERT INTO `ciudad` VALUES ('852', 'Chachaouit', '21');
INSERT INTO `ciudad` VALUES ('853', 'Colón', '21');
INSERT INTO `ciudad` VALUES ('854', 'Consaca', '21');
INSERT INTO `ciudad` VALUES ('855', 'Contadero', '21');
INSERT INTO `ciudad` VALUES ('856', 'Córdoba', '21');
INSERT INTO `ciudad` VALUES ('857', 'Cuaspud', '21');
INSERT INTO `ciudad` VALUES ('858', 'Cumbal', '21');
INSERT INTO `ciudad` VALUES ('859', 'Cumbitara', '21');
INSERT INTO `ciudad` VALUES ('860', 'Cumbitra', '21');
INSERT INTO `ciudad` VALUES ('861', 'El Charco', '21');
INSERT INTO `ciudad` VALUES ('862', 'El Chorrillo', '21');
INSERT INTO `ciudad` VALUES ('863', 'El Peñol', '21');
INSERT INTO `ciudad` VALUES ('864', 'El Remolino', '21');
INSERT INTO `ciudad` VALUES ('865', 'El Rosario', '21');
INSERT INTO `ciudad` VALUES ('866', 'El Tablón', '21');
INSERT INTO `ciudad` VALUES ('867', 'El Tambo', '21');
INSERT INTO `ciudad` VALUES ('868', 'Francisco Pizarro', '21');
INSERT INTO `ciudad` VALUES ('869', 'Funes', '21');
INSERT INTO `ciudad` VALUES ('870', 'Guachávez', '21');
INSERT INTO `ciudad` VALUES ('871', 'Guachucal', '21');
INSERT INTO `ciudad` VALUES ('872', 'Guaitarilla', '21');
INSERT INTO `ciudad` VALUES ('873', 'Gualmatán', '21');
INSERT INTO `ciudad` VALUES ('874', 'Guitarrilla', '21');
INSERT INTO `ciudad` VALUES ('875', 'Iles', '21');
INSERT INTO `ciudad` VALUES ('876', 'Imúes', '21');
INSERT INTO `ciudad` VALUES ('877', 'Ipiales', '21');
INSERT INTO `ciudad` VALUES ('878', 'José María Hernández', '21');
INSERT INTO `ciudad` VALUES ('879', 'La Cruz', '21');
INSERT INTO `ciudad` VALUES ('880', 'La Florida', '21');
INSERT INTO `ciudad` VALUES ('881', 'La Llamada', '21');
INSERT INTO `ciudad` VALUES ('882', 'La Llanada', '21');
INSERT INTO `ciudad` VALUES ('883', 'La Tola', '21');
INSERT INTO `ciudad` VALUES ('884', 'La Unión', '21');
INSERT INTO `ciudad` VALUES ('885', 'Leiva', '21');
INSERT INTO `ciudad` VALUES ('886', 'Linares', '21');
INSERT INTO `ciudad` VALUES ('887', 'Los Andes', '21');
INSERT INTO `ciudad` VALUES ('888', 'Maguí', '21');
INSERT INTO `ciudad` VALUES ('889', 'Mallama', '21');
INSERT INTO `ciudad` VALUES ('890', 'Mocoa', '21');
INSERT INTO `ciudad` VALUES ('891', 'Mosquera', '21');
INSERT INTO `ciudad` VALUES ('892', 'Olaya Herrera', '21');
INSERT INTO `ciudad` VALUES ('893', 'Ospina', '21');
INSERT INTO `ciudad` VALUES ('894', 'Pasto', '21');
INSERT INTO `ciudad` VALUES ('895', 'Payam', '21');
INSERT INTO `ciudad` VALUES ('896', 'Pilcuán', '21');
INSERT INTO `ciudad` VALUES ('897', 'Policarpa', '21');
INSERT INTO `ciudad` VALUES ('898', 'Potosí', '21');
INSERT INTO `ciudad` VALUES ('899', 'Providencia', '21');
INSERT INTO `ciudad` VALUES ('900', 'Provincia', '21');
INSERT INTO `ciudad` VALUES ('901', 'Puerres', '21');
INSERT INTO `ciudad` VALUES ('902', 'Pupiales', '21');
INSERT INTO `ciudad` VALUES ('903', 'Ricaurte', '21');
INSERT INTO `ciudad` VALUES ('904', 'Roberto Payán', '21');
INSERT INTO `ciudad` VALUES ('905', 'Rosaflorida', '21');
INSERT INTO `ciudad` VALUES ('906', 'Samaniego', '21');
INSERT INTO `ciudad` VALUES ('907', 'San Bernardo', '21');
INSERT INTO `ciudad` VALUES ('908', 'San José', '21');
INSERT INTO `ciudad` VALUES ('909', 'San Lorenzo', '21');
INSERT INTO `ciudad` VALUES ('910', 'San Pablo', '21');
INSERT INTO `ciudad` VALUES ('911', 'San Pedro Cartago', '21');
INSERT INTO `ciudad` VALUES ('912', 'San Remo', '21');
INSERT INTO `ciudad` VALUES ('913', 'Sandoná', '21');
INSERT INTO `ciudad` VALUES ('914', 'Santa Bárbara', '21');
INSERT INTO `ciudad` VALUES ('915', 'Santacruz', '21');
INSERT INTO `ciudad` VALUES ('916', 'Sapuyes', '21');
INSERT INTO `ciudad` VALUES ('917', 'Sibundoy', '21');
INSERT INTO `ciudad` VALUES ('918', 'Sotomayor', '21');
INSERT INTO `ciudad` VALUES ('919', 'Taminango', '21');
INSERT INTO `ciudad` VALUES ('920', 'Tangua', '21');
INSERT INTO `ciudad` VALUES ('921', 'Tumaco', '21');
INSERT INTO `ciudad` VALUES ('922', 'Túquerres', '21');
INSERT INTO `ciudad` VALUES ('923', 'Uribe', '21');
INSERT INTO `ciudad` VALUES ('924', 'Yacuanquer', '21');
INSERT INTO `ciudad` VALUES ('925', 'Abrego', '22');
INSERT INTO `ciudad` VALUES ('926', 'Arboledas', '22');
INSERT INTO `ciudad` VALUES ('927', 'Bochalema', '22');
INSERT INTO `ciudad` VALUES ('928', 'Bucarasica', '22');
INSERT INTO `ciudad` VALUES ('929', 'Cachira', '22');
INSERT INTO `ciudad` VALUES ('930', 'Cacota', '22');
INSERT INTO `ciudad` VALUES ('931', 'Chinácota', '22');
INSERT INTO `ciudad` VALUES ('932', 'Chitagá', '22');
INSERT INTO `ciudad` VALUES ('933', 'Convención', '22');
INSERT INTO `ciudad` VALUES ('934', 'Cúcuta', '22');
INSERT INTO `ciudad` VALUES ('935', 'Cucutilla', '22');
INSERT INTO `ciudad` VALUES ('936', 'Durania', '22');
INSERT INTO `ciudad` VALUES ('937', 'El Carmen', '22');
INSERT INTO `ciudad` VALUES ('938', 'El Taira', '22');
INSERT INTO `ciudad` VALUES ('939', 'El Tarra', '22');
INSERT INTO `ciudad` VALUES ('940', 'El Zulia', '22');
INSERT INTO `ciudad` VALUES ('941', 'Gramalote', '22');
INSERT INTO `ciudad` VALUES ('942', 'Hacarí', '22');
INSERT INTO `ciudad` VALUES ('943', 'Herrán', '22');
INSERT INTO `ciudad` VALUES ('944', 'La Esperanza', '22');
INSERT INTO `ciudad` VALUES ('945', 'La Playa', '22');
INSERT INTO `ciudad` VALUES ('946', 'Labateca', '22');
INSERT INTO `ciudad` VALUES ('947', 'Los Patios', '22');
INSERT INTO `ciudad` VALUES ('948', 'Lourdes', '22');
INSERT INTO `ciudad` VALUES ('949', 'Motiscua', '22');
INSERT INTO `ciudad` VALUES ('950', 'Mutiscua', '22');
INSERT INTO `ciudad` VALUES ('951', 'Ocaña', '22');
INSERT INTO `ciudad` VALUES ('952', 'Pamplona', '22');
INSERT INTO `ciudad` VALUES ('953', 'Pamplonita', '22');
INSERT INTO `ciudad` VALUES ('954', 'Puerto Santander', '22');
INSERT INTO `ciudad` VALUES ('955', 'Ragonvalia', '22');
INSERT INTO `ciudad` VALUES ('956', 'Salazar', '22');
INSERT INTO `ciudad` VALUES ('957', 'San Calixto', '22');
INSERT INTO `ciudad` VALUES ('958', 'San Cayetano', '22');
INSERT INTO `ciudad` VALUES ('959', 'Santiago', '22');
INSERT INTO `ciudad` VALUES ('960', 'Sardinata', '22');
INSERT INTO `ciudad` VALUES ('961', 'Silos', '22');
INSERT INTO `ciudad` VALUES ('962', 'Teorama', '22');
INSERT INTO `ciudad` VALUES ('963', 'Teorema', '22');
INSERT INTO `ciudad` VALUES ('964', 'Tibú', '22');
INSERT INTO `ciudad` VALUES ('965', 'Toledo', '22');
INSERT INTO `ciudad` VALUES ('966', 'Villa Caro', '22');
INSERT INTO `ciudad` VALUES ('967', 'Villa del Rosario', '22');
INSERT INTO `ciudad` VALUES ('968', 'Colón', '23');
INSERT INTO `ciudad` VALUES ('969', 'Mocoa', '23');
INSERT INTO `ciudad` VALUES ('970', 'Orito', '23');
INSERT INTO `ciudad` VALUES ('971', 'Puerto Asís', '23');
INSERT INTO `ciudad` VALUES ('972', 'Puerto Caicedo', '23');
INSERT INTO `ciudad` VALUES ('973', 'Puerto Guzmán', '23');
INSERT INTO `ciudad` VALUES ('974', 'Puerto Leguízamo', '23');
INSERT INTO `ciudad` VALUES ('975', 'San Francisco', '23');
INSERT INTO `ciudad` VALUES ('976', 'San Miguel', '23');
INSERT INTO `ciudad` VALUES ('977', 'Santiago', '23');
INSERT INTO `ciudad` VALUES ('978', 'Sibundoy', '23');
INSERT INTO `ciudad` VALUES ('979', 'Valle del Guamuez', '23');
INSERT INTO `ciudad` VALUES ('980', 'Villagarzón', '23');
INSERT INTO `ciudad` VALUES ('981', 'Armenia', '24');
INSERT INTO `ciudad` VALUES ('982', 'Barcelona', '24');
INSERT INTO `ciudad` VALUES ('983', 'Buenavista', '24');
INSERT INTO `ciudad` VALUES ('984', 'Calarcá', '24');
INSERT INTO `ciudad` VALUES ('985', 'Circasia', '24');
INSERT INTO `ciudad` VALUES ('986', 'Córdoba', '24');
INSERT INTO `ciudad` VALUES ('987', 'Filandia', '24');
INSERT INTO `ciudad` VALUES ('988', 'Génova', '24');
INSERT INTO `ciudad` VALUES ('989', 'La Tebaida', '24');
INSERT INTO `ciudad` VALUES ('990', 'Montenegro', '24');
INSERT INTO `ciudad` VALUES ('991', 'Pijao', '24');
INSERT INTO `ciudad` VALUES ('992', 'Pueblo Tapao', '24');
INSERT INTO `ciudad` VALUES ('993', 'Quimbaya', '24');
INSERT INTO `ciudad` VALUES ('994', 'Salento', '24');
INSERT INTO `ciudad` VALUES ('995', 'Apía', '25');
INSERT INTO `ciudad` VALUES ('996', 'Balboa', '25');
INSERT INTO `ciudad` VALUES ('997', 'Belén de Umbría', '25');
INSERT INTO `ciudad` VALUES ('998', 'Dosquebradas', '25');
INSERT INTO `ciudad` VALUES ('999', 'Guática', '25');
INSERT INTO `ciudad` VALUES ('1000', 'Irra', '25');
INSERT INTO `ciudad` VALUES ('1001', 'La Celia', '25');
INSERT INTO `ciudad` VALUES ('1002', 'La Virginia', '25');
INSERT INTO `ciudad` VALUES ('1003', 'Marsella', '25');
INSERT INTO `ciudad` VALUES ('1004', 'Marsella Alto Cauca', '25');
INSERT INTO `ciudad` VALUES ('1005', 'Mistrató', '25');
INSERT INTO `ciudad` VALUES ('1006', 'Pereira', '25');
INSERT INTO `ciudad` VALUES ('1007', 'Pueblo Rico', '25');
INSERT INTO `ciudad` VALUES ('1008', 'Quinchía', '25');
INSERT INTO `ciudad` VALUES ('1009', 'Santa Cecilia', '25');
INSERT INTO `ciudad` VALUES ('1010', 'Santa Rosa de Cabal', '25');
INSERT INTO `ciudad` VALUES ('1011', 'Santuario', '25');
INSERT INTO `ciudad` VALUES ('1012', 'Taparcal-Belen de Umbria', '25');
INSERT INTO `ciudad` VALUES ('1013', 'San Andrés', '26');
INSERT INTO `ciudad` VALUES ('1014', 'Providencia', '26');
INSERT INTO `ciudad` VALUES ('1015', 'Aguada', '27');
INSERT INTO `ciudad` VALUES ('1016', 'Albania', '27');
INSERT INTO `ciudad` VALUES ('1017', 'Aratoca', '27');
INSERT INTO `ciudad` VALUES ('1018', 'Barbosa', '27');
INSERT INTO `ciudad` VALUES ('1019', 'Barichara', '27');
INSERT INTO `ciudad` VALUES ('1020', 'Barrancabermeja', '27');
INSERT INTO `ciudad` VALUES ('1021', 'Betulia', '27');
INSERT INTO `ciudad` VALUES ('1022', 'Bolívar', '27');
INSERT INTO `ciudad` VALUES ('1023', 'Bucaramanga', '27');
INSERT INTO `ciudad` VALUES ('1024', 'Cabrera', '27');
INSERT INTO `ciudad` VALUES ('1025', 'Caldas', '27');
INSERT INTO `ciudad` VALUES ('1026', 'California', '27');
INSERT INTO `ciudad` VALUES ('1027', 'Capitá', '27');
INSERT INTO `ciudad` VALUES ('1028', 'Capitanejo', '27');
INSERT INTO `ciudad` VALUES ('1029', 'Carcasi', '27');
INSERT INTO `ciudad` VALUES ('1030', 'Cepita', '27');
INSERT INTO `ciudad` VALUES ('1031', 'Cerrito', '27');
INSERT INTO `ciudad` VALUES ('1032', 'Charalá', '27');
INSERT INTO `ciudad` VALUES ('1033', 'Charta', '27');
INSERT INTO `ciudad` VALUES ('1034', 'Chimá', '27');
INSERT INTO `ciudad` VALUES ('1035', 'Chipatá', '27');
INSERT INTO `ciudad` VALUES ('1036', 'Cimitarra', '27');
INSERT INTO `ciudad` VALUES ('1037', 'Cite', '27');
INSERT INTO `ciudad` VALUES ('1038', 'Concepción', '27');
INSERT INTO `ciudad` VALUES ('1039', 'Confines', '27');
INSERT INTO `ciudad` VALUES ('1040', 'Contratación', '27');
INSERT INTO `ciudad` VALUES ('1041', 'Coromoro', '27');
INSERT INTO `ciudad` VALUES ('1042', 'Curití', '27');
INSERT INTO `ciudad` VALUES ('1043', 'El Cármen', '27');
INSERT INTO `ciudad` VALUES ('1044', 'El Guacamayo', '27');
INSERT INTO `ciudad` VALUES ('1045', 'El Peñón', '27');
INSERT INTO `ciudad` VALUES ('1046', 'El Playón', '27');
INSERT INTO `ciudad` VALUES ('1047', 'Encino', '27');
INSERT INTO `ciudad` VALUES ('1048', 'Enciso', '27');
INSERT INTO `ciudad` VALUES ('1049', 'Florián', '27');
INSERT INTO `ciudad` VALUES ('1050', 'Floridablanca', '27');
INSERT INTO `ciudad` VALUES ('1051', 'Galán', '27');
INSERT INTO `ciudad` VALUES ('1052', 'Gámbita', '27');
INSERT INTO `ciudad` VALUES ('1053', 'Girón', '27');
INSERT INTO `ciudad` VALUES ('1054', 'Guaca', '27');
INSERT INTO `ciudad` VALUES ('1055', 'Guadalupe', '27');
INSERT INTO `ciudad` VALUES ('1056', 'Guapota', '27');
INSERT INTO `ciudad` VALUES ('1057', 'Guavatá', '27');
INSERT INTO `ciudad` VALUES ('1058', 'Güepsa', '27');
INSERT INTO `ciudad` VALUES ('1059', 'Hato', '27');
INSERT INTO `ciudad` VALUES ('1060', 'Jesús María', '27');
INSERT INTO `ciudad` VALUES ('1061', 'Jordán', '27');
INSERT INTO `ciudad` VALUES ('1062', 'La Belleza', '27');
INSERT INTO `ciudad` VALUES ('1063', 'La Paz', '27');
INSERT INTO `ciudad` VALUES ('1064', 'Landázuri', '27');
INSERT INTO `ciudad` VALUES ('1065', 'Lebrija', '27');
INSERT INTO `ciudad` VALUES ('1066', 'Los Santos', '27');
INSERT INTO `ciudad` VALUES ('1067', 'Macaravita', '27');
INSERT INTO `ciudad` VALUES ('1068', 'Málaga', '27');
INSERT INTO `ciudad` VALUES ('1069', 'Matanza', '27');
INSERT INTO `ciudad` VALUES ('1070', 'Mogotes', '27');
INSERT INTO `ciudad` VALUES ('1071', 'Molagavita', '27');
INSERT INTO `ciudad` VALUES ('1072', 'Ocamonte', '27');
INSERT INTO `ciudad` VALUES ('1073', 'Oiba', '27');
INSERT INTO `ciudad` VALUES ('1074', 'Onzaga', '27');
INSERT INTO `ciudad` VALUES ('1075', 'Palmar', '27');
INSERT INTO `ciudad` VALUES ('1076', 'Palmas Socorro', '27');
INSERT INTO `ciudad` VALUES ('1077', 'Páramo', '27');
INSERT INTO `ciudad` VALUES ('1078', 'Piedecuesta', '27');
INSERT INTO `ciudad` VALUES ('1079', 'Pinchote', '27');
INSERT INTO `ciudad` VALUES ('1080', 'Puente Nacional', '27');
INSERT INTO `ciudad` VALUES ('1081', 'Puerto Parra', '27');
INSERT INTO `ciudad` VALUES ('1082', 'Puerto Wilches', '27');
INSERT INTO `ciudad` VALUES ('1083', 'Rionegro', '27');
INSERT INTO `ciudad` VALUES ('1084', 'Sabana de Torres', '27');
INSERT INTO `ciudad` VALUES ('1085', 'San Andrés', '27');
INSERT INTO `ciudad` VALUES ('1086', 'San Benito', '27');
INSERT INTO `ciudad` VALUES ('1087', 'San Gil', '27');
INSERT INTO `ciudad` VALUES ('1088', 'San Joaquín', '27');
INSERT INTO `ciudad` VALUES ('1089', 'San José de Miranda', '27');
INSERT INTO `ciudad` VALUES ('1090', 'San Miguel', '27');
INSERT INTO `ciudad` VALUES ('1091', 'San Vicente de Chucurí', '27');
INSERT INTO `ciudad` VALUES ('1092', 'Santa Bárbara', '27');
INSERT INTO `ciudad` VALUES ('1093', 'Santa Helena del Opón', '27');
INSERT INTO `ciudad` VALUES ('1094', 'Simacota', '27');
INSERT INTO `ciudad` VALUES ('1095', 'Socorro', '27');
INSERT INTO `ciudad` VALUES ('1096', 'Suaita', '27');
INSERT INTO `ciudad` VALUES ('1097', 'Sucre', '27');
INSERT INTO `ciudad` VALUES ('1098', 'Suratá', '27');
INSERT INTO `ciudad` VALUES ('1099', 'Tona', '27');
INSERT INTO `ciudad` VALUES ('1100', 'Vado Real', '27');
INSERT INTO `ciudad` VALUES ('1101', 'Valle San José', '27');
INSERT INTO `ciudad` VALUES ('1102', 'Vélez', '27');
INSERT INTO `ciudad` VALUES ('1103', 'Vetas', '27');
INSERT INTO `ciudad` VALUES ('1104', 'Villanueva', '27');
INSERT INTO `ciudad` VALUES ('1105', 'Zapatoca', '27');
INSERT INTO `ciudad` VALUES ('1106', 'Betulia', '28');
INSERT INTO `ciudad` VALUES ('1107', 'Buenavista', '28');
INSERT INTO `ciudad` VALUES ('1108', 'Caimito', '28');
INSERT INTO `ciudad` VALUES ('1109', 'Chalán', '28');
INSERT INTO `ciudad` VALUES ('1110', 'Colosó', '28');
INSERT INTO `ciudad` VALUES ('1111', 'Corozal', '28');
INSERT INTO `ciudad` VALUES ('1112', 'Coveñas', '28');
INSERT INTO `ciudad` VALUES ('1113', 'Galeras', '28');
INSERT INTO `ciudad` VALUES ('1114', 'Guaranda', '28');
INSERT INTO `ciudad` VALUES ('1115', 'La Unión', '28');
INSERT INTO `ciudad` VALUES ('1116', 'Los Palmitos', '28');
INSERT INTO `ciudad` VALUES ('1117', 'Majagual', '28');
INSERT INTO `ciudad` VALUES ('1118', 'Morroa', '28');
INSERT INTO `ciudad` VALUES ('1119', 'Ovejas', '28');
INSERT INTO `ciudad` VALUES ('1120', 'Sampués', '28');
INSERT INTO `ciudad` VALUES ('1121', 'San Benito Abad', '28');
INSERT INTO `ciudad` VALUES ('1122', 'San Juan de Betulia', '28');
INSERT INTO `ciudad` VALUES ('1123', 'San Marcos', '28');
INSERT INTO `ciudad` VALUES ('1124', 'San Onofre', '28');
INSERT INTO `ciudad` VALUES ('1125', 'San Pedro', '28');
INSERT INTO `ciudad` VALUES ('1126', 'Sincé', '28');
INSERT INTO `ciudad` VALUES ('1127', 'Sincelejo', '28');
INSERT INTO `ciudad` VALUES ('1128', 'Sucre', '28');
INSERT INTO `ciudad` VALUES ('1129', 'Tolú', '28');
INSERT INTO `ciudad` VALUES ('1130', 'Toluviejo', '28');
INSERT INTO `ciudad` VALUES ('1131', 'Alpujarra', '29');
INSERT INTO `ciudad` VALUES ('1132', 'Alvarado', '29');
INSERT INTO `ciudad` VALUES ('1133', 'Ambalema', '29');
INSERT INTO `ciudad` VALUES ('1134', 'Anaime', '29');
INSERT INTO `ciudad` VALUES ('1135', 'Anzoátegui', '29');
INSERT INTO `ciudad` VALUES ('1136', 'Armero', '29');
INSERT INTO `ciudad` VALUES ('1137', 'Armero-Guayabal', '29');
INSERT INTO `ciudad` VALUES ('1138', 'Ataco', '29');
INSERT INTO `ciudad` VALUES ('1139', 'Cajamarca', '29');
INSERT INTO `ciudad` VALUES ('1140', 'Cambao', '29');
INSERT INTO `ciudad` VALUES ('1141', 'Carmen de Apicalá', '29');
INSERT INTO `ciudad` VALUES ('1142', 'Casabianca', '29');
INSERT INTO `ciudad` VALUES ('1143', 'Chaparral', '29');
INSERT INTO `ciudad` VALUES ('1144', 'Chicoral', '29');
INSERT INTO `ciudad` VALUES ('1145', 'Coello', '29');
INSERT INTO `ciudad` VALUES ('1146', 'Coyaima', '29');
INSERT INTO `ciudad` VALUES ('1147', 'Cunday', '29');
INSERT INTO `ciudad` VALUES ('1148', 'Dolores', '29');
INSERT INTO `ciudad` VALUES ('1149', 'Espinal', '29');
INSERT INTO `ciudad` VALUES ('1150', 'Falan', '29');
INSERT INTO `ciudad` VALUES ('1151', 'Flandes', '29');
INSERT INTO `ciudad` VALUES ('1152', 'Fresno', '29');
INSERT INTO `ciudad` VALUES ('1153', 'Guamo', '29');
INSERT INTO `ciudad` VALUES ('1154', 'Herveo', '29');
INSERT INTO `ciudad` VALUES ('1155', 'Honda', '29');
INSERT INTO `ciudad` VALUES ('1156', 'Ibagué', '29');
INSERT INTO `ciudad` VALUES ('1157', 'Icononzo', '29');
INSERT INTO `ciudad` VALUES ('1158', 'La Sierra', '29');
INSERT INTO `ciudad` VALUES ('1159', 'Lérida', '29');
INSERT INTO `ciudad` VALUES ('1160', 'Líbano', '29');
INSERT INTO `ciudad` VALUES ('1161', 'Mariquita', '29');
INSERT INTO `ciudad` VALUES ('1162', 'Melgar', '29');
INSERT INTO `ciudad` VALUES ('1163', 'Murillo', '29');
INSERT INTO `ciudad` VALUES ('1164', 'Natagaima', '29');
INSERT INTO `ciudad` VALUES ('1165', 'Ortega', '29');
INSERT INTO `ciudad` VALUES ('1166', 'Palocabildo', '29');
INSERT INTO `ciudad` VALUES ('1167', 'Piedras', '29');
INSERT INTO `ciudad` VALUES ('1168', 'Planadas', '29');
INSERT INTO `ciudad` VALUES ('1169', 'Prado', '29');
INSERT INTO `ciudad` VALUES ('1170', 'Purificación', '29');
INSERT INTO `ciudad` VALUES ('1171', 'Rioblanco', '29');
INSERT INTO `ciudad` VALUES ('1172', 'Roncesvalles', '29');
INSERT INTO `ciudad` VALUES ('1173', 'Rovira', '29');
INSERT INTO `ciudad` VALUES ('1174', 'Saldaña', '29');
INSERT INTO `ciudad` VALUES ('1175', 'San Antonio', '29');
INSERT INTO `ciudad` VALUES ('1176', 'San Luis', '29');
INSERT INTO `ciudad` VALUES ('1177', 'Santa Isabel', '29');
INSERT INTO `ciudad` VALUES ('1178', 'Suárez', '29');
INSERT INTO `ciudad` VALUES ('1179', 'Valle de San Juan', '29');
INSERT INTO `ciudad` VALUES ('1180', 'Venadillo', '29');
INSERT INTO `ciudad` VALUES ('1181', 'Villahermosa', '29');
INSERT INTO `ciudad` VALUES ('1182', 'Villarrica', '29');
INSERT INTO `ciudad` VALUES ('1183', 'Beltrán', '29');
INSERT INTO `ciudad` VALUES ('1184', 'Castilla', '29');
INSERT INTO `ciudad` VALUES ('1185', 'Convenio', '29');
INSERT INTO `ciudad` VALUES ('1186', 'Chenche Asoleado', '29');
INSERT INTO `ciudad` VALUES ('1187', 'Doima', '29');
INSERT INTO `ciudad` VALUES ('1188', 'El Tablazo', '29');
INSERT INTO `ciudad` VALUES ('1189', 'Frias', '29');
INSERT INTO `ciudad` VALUES ('1190', 'Gaitania', '29');
INSERT INTO `ciudad` VALUES ('1191', 'Gualanday', '29');
INSERT INTO `ciudad` VALUES ('1192', 'Herrera', '29');
INSERT INTO `ciudad` VALUES ('1193', 'Junin', '29');
INSERT INTO `ciudad` VALUES ('1194', 'La Arada', '29');
INSERT INTO `ciudad` VALUES ('1195', 'La Chamba', '29');
INSERT INTO `ciudad` VALUES ('1196', 'Olaya Herrera', '29');
INSERT INTO `ciudad` VALUES ('1197', 'Padua', '29');
INSERT INTO `ciudad` VALUES ('1198', 'Payandé', '29');
INSERT INTO `ciudad` VALUES ('1199', 'Playarrica', '29');
INSERT INTO `ciudad` VALUES ('1200', 'Santa Teresa', '29');
INSERT INTO `ciudad` VALUES ('1201', 'Santiago Pérez', '29');
INSERT INTO `ciudad` VALUES ('1202', 'Tres Esquinas', '29');
INSERT INTO `ciudad` VALUES ('1203', 'Velú', '29');
INSERT INTO `ciudad` VALUES ('1204', 'Albán', '30');
INSERT INTO `ciudad` VALUES ('1205', 'Alcalá', '30');
INSERT INTO `ciudad` VALUES ('1206', 'Andalucía', '30');
INSERT INTO `ciudad` VALUES ('1207', 'Ansermanuevo', '30');
INSERT INTO `ciudad` VALUES ('1208', 'Argelia', '30');
INSERT INTO `ciudad` VALUES ('1209', 'Barragán', '30');
INSERT INTO `ciudad` VALUES ('1210', 'Bitaco', '30');
INSERT INTO `ciudad` VALUES ('1211', 'Bolívar', '30');
INSERT INTO `ciudad` VALUES ('1212', 'Buenaventura', '30');
INSERT INTO `ciudad` VALUES ('1213', 'Buenos Aires', '30');
INSERT INTO `ciudad` VALUES ('1214', 'Buga', '30');
INSERT INTO `ciudad` VALUES ('1215', 'Bugalagrande', '30');
INSERT INTO `ciudad` VALUES ('1216', 'Caicedonia', '30');
INSERT INTO `ciudad` VALUES ('1217', 'Cali', '30');
INSERT INTO `ciudad` VALUES ('1218', 'Calima', '30');
INSERT INTO `ciudad` VALUES ('1219', 'Candelaria', '30');
INSERT INTO `ciudad` VALUES ('1220', 'Cartago', '30');
INSERT INTO `ciudad` VALUES ('1221', 'Ceylan', '30');
INSERT INTO `ciudad` VALUES ('1222', 'Costa Rica', '30');
INSERT INTO `ciudad` VALUES ('1223', 'Dagua', '30');
INSERT INTO `ciudad` VALUES ('1224', 'Dapa', '30');
INSERT INTO `ciudad` VALUES ('1225', 'Darién', '30');
INSERT INTO `ciudad` VALUES ('1226', 'El Aguila', '30');
INSERT INTO `ciudad` VALUES ('1227', 'El Bolo', '30');
INSERT INTO `ciudad` VALUES ('1228', 'El Cairo', '30');
INSERT INTO `ciudad` VALUES ('1229', 'El Carmelo', '30');
INSERT INTO `ciudad` VALUES ('1230', 'El Carmen', '30');
INSERT INTO `ciudad` VALUES ('1231', 'El Cerrito', '30');
INSERT INTO `ciudad` VALUES ('1232', 'El Dovio', '30');
INSERT INTO `ciudad` VALUES ('1233', 'Fenicia', '30');
INSERT INTO `ciudad` VALUES ('1234', 'Florida', '30');
INSERT INTO `ciudad` VALUES ('1235', 'Galicia', '30');
INSERT INTO `ciudad` VALUES ('1236', 'Ginebra', '30');
INSERT INTO `ciudad` VALUES ('1237', 'Guacarí', '30');
INSERT INTO `ciudad` VALUES ('1238', 'Jamundí', '30');
INSERT INTO `ciudad` VALUES ('1239', 'Juachaco', '30');
INSERT INTO `ciudad` VALUES ('1240', 'Km 26', '30');
INSERT INTO `ciudad` VALUES ('1241', 'La Bocana', '30');
INSERT INTO `ciudad` VALUES ('1242', 'La Buitrera', '30');
INSERT INTO `ciudad` VALUES ('1243', 'La Cumbre', '30');
INSERT INTO `ciudad` VALUES ('1244', 'La Dolores', '30');
INSERT INTO `ciudad` VALUES ('1245', 'La Iberia', '30');
INSERT INTO `ciudad` VALUES ('1246', 'La Nubia', '30');
INSERT INTO `ciudad` VALUES ('1247', 'La Unión', '30');
INSERT INTO `ciudad` VALUES ('1248', 'La Victoria', '30');
INSERT INTO `ciudad` VALUES ('1249', 'Ladrilleros', '30');
INSERT INTO `ciudad` VALUES ('1250', 'Lago Calima', '30');
INSERT INTO `ciudad` VALUES ('1251', 'Madrigal', '30');
INSERT INTO `ciudad` VALUES ('1252', 'Obando', '30');
INSERT INTO `ciudad` VALUES ('1253', 'Palmaseca', '30');
INSERT INTO `ciudad` VALUES ('1254', 'Palmira', '30');
INSERT INTO `ciudad` VALUES ('1255', 'Pavas', '30');
INSERT INTO `ciudad` VALUES ('1256', 'Poblado Campestre', '30');
INSERT INTO `ciudad` VALUES ('1257', 'Potrerito', '30');
INSERT INTO `ciudad` VALUES ('1258', 'Pradera', '30');
INSERT INTO `ciudad` VALUES ('1259', 'Queremal', '30');
INSERT INTO `ciudad` VALUES ('1260', 'Restrepo', '30');
INSERT INTO `ciudad` VALUES ('1261', 'Riofrío', '30');
INSERT INTO `ciudad` VALUES ('1262', 'Roldanillo', '30');
INSERT INTO `ciudad` VALUES ('1263', 'Rozo', '30');
INSERT INTO `ciudad` VALUES ('1264', 'Salónica', '30');
INSERT INTO `ciudad` VALUES ('1265', 'Samaria', '30');
INSERT INTO `ciudad` VALUES ('1266', 'San Antonio de los Caballeros', '30');
INSERT INTO `ciudad` VALUES ('1267', 'San Pedro', '30');
INSERT INTO `ciudad` VALUES ('1268', 'Santa Helena', '30');
INSERT INTO `ciudad` VALUES ('1269', 'Santa Lucía', '30');
INSERT INTO `ciudad` VALUES ('1270', 'Sevilla', '30');
INSERT INTO `ciudad` VALUES ('1271', 'Sonso', '30');
INSERT INTO `ciudad` VALUES ('1272', 'Tienda Nueva', '30');
INSERT INTO `ciudad` VALUES ('1273', 'Toro', '30');
INSERT INTO `ciudad` VALUES ('1274', 'Trujillo', '30');
INSERT INTO `ciudad` VALUES ('1275', 'Tuluá', '30');
INSERT INTO `ciudad` VALUES ('1276', 'Ulloa', '30');
INSERT INTO `ciudad` VALUES ('1277', 'Venecia', '30');
INSERT INTO `ciudad` VALUES ('1278', 'Versalles', '30');
INSERT INTO `ciudad` VALUES ('1279', 'Vijes', '30');
INSERT INTO `ciudad` VALUES ('1280', 'Villagorgona', '30');
INSERT INTO `ciudad` VALUES ('1281', 'Yotoco', '30');
INSERT INTO `ciudad` VALUES ('1282', 'Yumbo', '30');
INSERT INTO `ciudad` VALUES ('1283', 'Zarzal', '30');
INSERT INTO `ciudad` VALUES ('1284', 'Ameime', '30');
INSERT INTO `ciudad` VALUES ('1285', 'El Placer', '30');
INSERT INTO `ciudad` VALUES ('1286', 'Quebrada Nueva', '30');
INSERT INTO `ciudad` VALUES ('1287', 'Rurales Valle', '30');
INSERT INTO `ciudad` VALUES ('1288', 'La Marina', '30');
INSERT INTO `ciudad` VALUES ('1289', 'La Horqueta', '30');
INSERT INTO `ciudad` VALUES ('1290', 'Bahía Malaga', '30');
INSERT INTO `ciudad` VALUES ('1291', 'Carurú', '31');
INSERT INTO `ciudad` VALUES ('1292', 'Cumaribo', '31');
INSERT INTO `ciudad` VALUES ('1293', 'La Hormiga', '31');
INSERT INTO `ciudad` VALUES ('1294', 'La Primavera', '31');
INSERT INTO `ciudad` VALUES ('1295', 'Mitú', '31');
INSERT INTO `ciudad` VALUES ('1296', 'Nueva Antioquia', '31');
INSERT INTO `ciudad` VALUES ('1297', 'Pacoa', '31');
INSERT INTO `ciudad` VALUES ('1298', 'San José de Ocune', '31');
INSERT INTO `ciudad` VALUES ('1299', 'Santa Rita', '31');
INSERT INTO `ciudad` VALUES ('1300', 'Santa Rosalía', '31');
INSERT INTO `ciudad` VALUES ('1301', 'Taraira', '31');
INSERT INTO `ciudad` VALUES ('1302', 'Toraira', '31');
INSERT INTO `ciudad` VALUES ('1303', 'Vichada', '31');
INSERT INTO `ciudad` VALUES ('1304', 'Yavarate', '31');
INSERT INTO `ciudad` VALUES ('1305', 'Puerto Carreño', '32');

-- ----------------------------
-- Table structure for departamento
-- ----------------------------
DROP TABLE IF EXISTS `departamento`;
CREATE TABLE `departamento` (
  `DEPidDepPK` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `DEPnomDep` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`DEPidDepPK`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of departamento
-- ----------------------------
INSERT INTO `departamento` VALUES ('1', 'Amazonas');
INSERT INTO `departamento` VALUES ('2', 'Antioquia');
INSERT INTO `departamento` VALUES ('3', 'Arauca');
INSERT INTO `departamento` VALUES ('4', 'Atlántico');
INSERT INTO `departamento` VALUES ('5', 'Bolívar');
INSERT INTO `departamento` VALUES ('6', 'Boyacá');
INSERT INTO `departamento` VALUES ('7', 'Caldas');
INSERT INTO `departamento` VALUES ('8', 'Caquetá');
INSERT INTO `departamento` VALUES ('9', 'Casanare');
INSERT INTO `departamento` VALUES ('10', 'Cauca');
INSERT INTO `departamento` VALUES ('11', 'Cesar');
INSERT INTO `departamento` VALUES ('12', 'Chocó');
INSERT INTO `departamento` VALUES ('13', 'Córdoba');
INSERT INTO `departamento` VALUES ('14', 'Cundinamarca');
INSERT INTO `departamento` VALUES ('15', 'Guainía');
INSERT INTO `departamento` VALUES ('16', 'Guaviare');
INSERT INTO `departamento` VALUES ('17', 'Huila');
INSERT INTO `departamento` VALUES ('18', 'La Guajira');
INSERT INTO `departamento` VALUES ('19', 'Magdalena');
INSERT INTO `departamento` VALUES ('20', 'Meta');
INSERT INTO `departamento` VALUES ('21', 'Nariño');
INSERT INTO `departamento` VALUES ('22', 'Norte de Santander');
INSERT INTO `departamento` VALUES ('23', 'Putumayo');
INSERT INTO `departamento` VALUES ('24', 'Quindío');
INSERT INTO `departamento` VALUES ('25', 'Risaralda');
INSERT INTO `departamento` VALUES ('26', 'San Andrés y Providencia');
INSERT INTO `departamento` VALUES ('27', 'Santander');
INSERT INTO `departamento` VALUES ('28', 'Sucre');
INSERT INTO `departamento` VALUES ('29', 'Tolima');
INSERT INTO `departamento` VALUES ('30', 'Valle del Cauca');
INSERT INTO `departamento` VALUES ('31', 'Vaupés');
INSERT INTO `departamento` VALUES ('32', 'Vichada');

-- ----------------------------
-- Table structure for documento
-- ----------------------------
DROP TABLE IF EXISTS `documento`;
CREATE TABLE `documento` (
  `DOCidDocPK` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `DOCdesTipDoc` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`DOCidDocPK`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of documento
-- ----------------------------
INSERT INTO `documento` VALUES ('1', 'RC');
INSERT INTO `documento` VALUES ('2', 'TI');
INSERT INTO `documento` VALUES ('3', 'CC');
INSERT INTO `documento` VALUES ('4', 'CE');

-- ----------------------------
-- Table structure for entsal
-- ----------------------------
DROP TABLE IF EXISTS `entsal`;
CREATE TABLE `entsal` (
  `ESidEntSalPK` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ESidPerFK` int(10) unsigned DEFAULT NULL,
  `ESidTiEnSaFK` int(10) unsigned DEFAULT NULL,
  `ESfecHor` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ESnov` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ESidEntSalPK`),
  KEY `FKtipes` (`ESidTiEnSaFK`) USING BTREE,
  KEY `FKpers` (`ESidPerFK`) USING BTREE,
  CONSTRAINT `entsal_ibfk_1` FOREIGN KEY (`ESidTiEnSaFK`) REFERENCES `tipentsal` (`TESidTiEnSaPK`),
  CONSTRAINT `entsal_ibfk_2` FOREIGN KEY (`ESidPerFK`) REFERENCES `persona` (`PERidPerPK`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of entsal
-- ----------------------------
INSERT INTO `entsal` VALUES ('1', '4', '1', '2017-01-12 18:07:24', null);
INSERT INTO `entsal` VALUES ('17', '4', '2', '2017-01-13 00:03:26', null);
INSERT INTO `entsal` VALUES ('18', '4', '1', '2017-01-13 00:03:43', null);
INSERT INTO `entsal` VALUES ('19', '4', '2', '2017-01-13 00:08:29', null);

-- ----------------------------
-- Table structure for entsalequ
-- ----------------------------
DROP TABLE IF EXISTS `entsalequ`;
CREATE TABLE `entsalequ` (
  `ESQidEnSaFK` int(10) unsigned NOT NULL,
  `ESQidEquFK` int(10) unsigned DEFAULT NULL,
  `ESQtiEnSaEq` int(2) NOT NULL,
  `ESQfeEnEq` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ESQidPerFK` int(11) unsigned DEFAULT NULL,
  `ESQnov` varchar(100) DEFAULT NULL,
  KEY `FK_entrs` (`ESQidEnSaFK`) USING BTREE,
  KEY `FK_equips` (`ESQidEquFK`) USING BTREE,
  KEY `FK_pers` (`ESQidPerFK`) USING BTREE,
  CONSTRAINT `entsalequ_ibfk_1` FOREIGN KEY (`ESQidEnSaFK`) REFERENCES `entsal` (`ESidEntSalPK`),
  CONSTRAINT `entsalequ_ibfk_2` FOREIGN KEY (`ESQidEquFK`) REFERENCES `equipos` (`EQUidEquPK`),
  CONSTRAINT `entsalequ_ibfk_3` FOREIGN KEY (`ESQidPerFK`) REFERENCES `persona` (`PERidPerPK`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of entsalequ
-- ----------------------------

-- ----------------------------
-- Table structure for equipos
-- ----------------------------
DROP TABLE IF EXISTS `equipos`;
CREATE TABLE `equipos` (
  `EQUidEquPK` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `EQUidMarFK` int(10) unsigned NOT NULL,
  `EQUmod` varchar(30) DEFAULT NULL,
  `EQUser` varchar(30) DEFAULT NULL,
  `EQUidTipFK` int(10) unsigned NOT NULL,
  `EQUdes` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`EQUidEquPK`),
  KEY `EQUFKtipequ` (`EQUidTipFK`) USING BTREE,
  KEY `EQUFKmarequ` (`EQUidMarFK`) USING BTREE,
  CONSTRAINT `equipos_ibfk_1` FOREIGN KEY (`EQUidMarFK`) REFERENCES `marequ` (`MEidMaEqPK`),
  CONSTRAINT `equipos_ibfk_2` FOREIGN KEY (`EQUidTipFK`) REFERENCES `tipequ` (`TEidTiEqPK`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of equipos
-- ----------------------------
INSERT INTO `equipos` VALUES ('1', '3', 'iphone 5s', '5555', '3', '');
INSERT INTO `equipos` VALUES ('2', '3', '1', '2', '1', '3');
INSERT INTO `equipos` VALUES ('3', '2', '2', '3', '3', '4');
INSERT INTO `equipos` VALUES ('4', '1', '3', '44', '2', '5');
INSERT INTO `equipos` VALUES ('5', '1', '55', '2321', '3', '31');
INSERT INTO `equipos` VALUES ('6', '2', '4545', '45', '2', '45');
INSERT INTO `equipos` VALUES ('7', '1', '3521', '635', '2', '+566458');

-- ----------------------------
-- Table structure for ficha
-- ----------------------------
DROP TABLE IF EXISTS `ficha`;
CREATE TABLE `ficha` (
  `FICidFicPK` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `FICnumFic` int(15) NOT NULL,
  `FICdesFic` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`FICidFicPK`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of ficha
-- ----------------------------
INSERT INTO `ficha` VALUES ('1', '1095701', 'ADSI 113');

-- ----------------------------
-- Table structure for genero
-- ----------------------------
DROP TABLE IF EXISTS `genero`;
CREATE TABLE `genero` (
  `GENidGenPK` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `GENdesGen` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`GENidGenPK`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of genero
-- ----------------------------
INSERT INTO `genero` VALUES ('1', 'FEMENINO');
INSERT INTO `genero` VALUES ('2', 'MASCULINO');

-- ----------------------------
-- Table structure for marequ
-- ----------------------------
DROP TABLE IF EXISTS `marequ`;
CREATE TABLE `marequ` (
  `MEidMaEqPK` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `MEdeMaEq` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`MEidMaEqPK`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of marequ
-- ----------------------------
INSERT INTO `marequ` VALUES ('1', 'ACER');
INSERT INTO `marequ` VALUES ('2', 'ASUS');
INSERT INTO `marequ` VALUES ('3', 'APPLE');
INSERT INTO `marequ` VALUES ('4', 'DELL');
INSERT INTO `marequ` VALUES ('5', 'GATEWAY');
INSERT INTO `marequ` VALUES ('6', 'HP');
INSERT INTO `marequ` VALUES ('7', 'LENOVO');
INSERT INTO `marequ` VALUES ('8', 'LG');
INSERT INTO `marequ` VALUES ('9', 'PC SMART');
INSERT INTO `marequ` VALUES ('10', 'TOSHIBA');
INSERT INTO `marequ` VALUES ('11', 'SONY');
INSERT INTO `marequ` VALUES ('12', 'OTROS');

-- ----------------------------
-- Table structure for perequ
-- ----------------------------
DROP TABLE IF EXISTS `perequ`;
CREATE TABLE `perequ` (
  `PEidPerFK` int(10) unsigned NOT NULL,
  `PEidEquFK` int(10) unsigned NOT NULL,
  PRIMARY KEY (`PEidPerFK`,`PEidEquFK`),
  KEY `FKperequi` (`PEidEquFK`) USING BTREE,
  KEY `FKperso` (`PEidPerFK`) USING BTREE,
  CONSTRAINT `perequ_ibfk_1` FOREIGN KEY (`PEidEquFK`) REFERENCES `equipos` (`EQUidEquPK`),
  CONSTRAINT `perequ_ibfk_2` FOREIGN KEY (`PEidPerFK`) REFERENCES `persona` (`PERidPerPK`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of perequ
-- ----------------------------
INSERT INTO `perequ` VALUES ('10', '1');
INSERT INTO `perequ` VALUES ('10', '2');

-- ----------------------------
-- Table structure for persona
-- ----------------------------
DROP TABLE IF EXISTS `persona`;
CREATE TABLE `persona` (
  `PERidPerPK` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `PERidDocFK` int(10) unsigned DEFAULT NULL,
  `PERnumDoc` int(15) NOT NULL,
  `PERnom1` varchar(30) NOT NULL,
  `PERnom2` varchar(30) DEFAULT NULL,
  `PERape1` varchar(30) NOT NULL,
  `PERape2` varchar(30) DEFAULT NULL,
  `PERidGenFK` int(10) unsigned DEFAULT NULL,
  `PERdir` varchar(100) DEFAULT NULL,
  `PERtelFij` int(10) DEFAULT NULL,
  `PERcel` int(12) DEFAULT NULL,
  `PERcor` varchar(100) DEFAULT NULL,
  `PERidRhFK` int(10) unsigned DEFAULT NULL,
  `PERidTiPeFK` int(10) unsigned DEFAULT NULL,
  `PERidRolFK` int(10) unsigned DEFAULT NULL,
  `PERidCenFK` int(10) unsigned DEFAULT NULL,
  `PERidFicFK` int(10) unsigned DEFAULT NULL,
  `PERfoto` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`PERidPerPK`),
  KEY `PERFKcen` (`PERidCenFK`) USING BTREE,
  KEY `PERFKdoc` (`PERidDocFK`) USING BTREE,
  KEY `PERFKfic` (`PERidFicFK`) USING BTREE,
  KEY `PERFKgen` (`PERidGenFK`) USING BTREE,
  KEY `PERFKrh` (`PERidRhFK`) USING BTREE,
  KEY `PERFKrol` (`PERidRolFK`) USING BTREE,
  KEY `PERFKtipper` (`PERidTiPeFK`) USING BTREE,
  CONSTRAINT `persona_ibfk_1` FOREIGN KEY (`PERidCenFK`) REFERENCES `centros` (`CENidCenPK`),
  CONSTRAINT `persona_ibfk_2` FOREIGN KEY (`PERidDocFK`) REFERENCES `documento` (`DOCidDocPK`),
  CONSTRAINT `persona_ibfk_3` FOREIGN KEY (`PERidFicFK`) REFERENCES `ficha` (`FICidFicPK`),
  CONSTRAINT `persona_ibfk_4` FOREIGN KEY (`PERidGenFK`) REFERENCES `genero` (`GENidGenPK`),
  CONSTRAINT `persona_ibfk_5` FOREIGN KEY (`PERidRhFK`) REFERENCES `rh` (`RHidRhPK`),
  CONSTRAINT `persona_ibfk_6` FOREIGN KEY (`PERidRolFK`) REFERENCES `rol` (`ROLidRolPK`),
  CONSTRAINT `persona_ibfk_7` FOREIGN KEY (`PERidTiPeFK`) REFERENCES `tipper` (`TPidTiPePK`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of persona
-- ----------------------------
INSERT INTO `persona` VALUES ('1', '3', '12345', 'ADMIN', 'ADMIN', 'ADMIN', 'ADMIN', '2', 'prueba', '0', '1111111', 'ADMIN@admin.com', '1', '1', '1', '1', '1', '');
INSERT INTO `persona` VALUES ('2', '3', '54321', 'User', 'User', 'User', 'User', '2', 'prueba', '0', '1111111', 'user@admin.com', '1', '1', '3', '1', '1', '');
INSERT INTO `persona` VALUES ('4', '3', '14609952', 'Alexander', '', 'Salinas', 'Lozano', '2', 'Cll 110 #284-18', '4223601', '2147483647', 'salinas.alexander@gmail.com', '1', '2', '1', '1', '1', '');
INSERT INTO `persona` VALUES ('5', '3', '94539564', 'jonnathan', '', 'valencia', 'perlaza', '2', 'dig 70 No 23 A - 151', '6638621', '2147483647', 'ican.jonna@gmail.com', '1', '1', '3', '1', '1', '');
INSERT INTO `persona` VALUES ('6', '3', '1012378485', 'Jancel', 'Hernan', 'Perez', 'Paternin', '2', 'calle 42', '0', '0', 'jhperez@admin.com', '1', '1', '1', '1', '1', '');
INSERT INTO `persona` VALUES ('7', '3', '16941522', 'JULIO', 'EDUARDO', 'PABON', 'ERAZO', '2', 'DG 29A T27-27', '3343531', '2147483647', 'jepabon22@misena.edu.co', '1', '1', '1', '1', '1', '');
INSERT INTO `persona` VALUES ('8', '3', '16378842', 'Cristhian', 'Andersson', 'Caicedo', 'Lopez', '2', 'Carrera 25 # 52 - 71', '0', '2147483647', 'cacaicedo24@misena.edu.co', '1', '1', '3', '1', '1', '');
INSERT INTO `persona` VALUES ('9', '3', '1143941423', 'Luisa', 'Fernanda', 'Salazar', 'Solarte', '1', 'Cra 27 # 32 a 43', '3818339', '2147483647', 'lfsalazar32@misena.edu.co', '1', '1', '3', '1', '1', '');
INSERT INTO `persona` VALUES ('10', '3', '1143858861', 'Gustavo', 'Adolfo', 'Risueño', 'Zuñiga', '2', 'Carrera 39 a 30 c 63', '3378388', '2147483647', 'gustavoriu@hotmail.com', '1', '1', '1', '1', '1', '');
INSERT INTO `persona` VALUES ('11', '3', '14695164', 'Carlos', 'Andres', 'Morales', 'Hurtado', '2', 'Calle 35 15 34', '0', '2147483647', 'camorales461@misena.edu.co', '1', '1', '3', '1', '1', '');
INSERT INTO `persona` VALUES ('13', '3', '25026430', 'maria', 'yeimi', 'jaramillo', 'ocampo', '1', 'cra 26q # 72t-25', '3976050', '2147483647', 'yeimijaramillo1@gmail.com', '1', '1', '1', '1', '1', '');
INSERT INTO `persona` VALUES ('14', '3', '1080930332', 'William', 'Alexander', 'Gallardo', 'Barrera', '2', 'calle 69 No. 7bBis 12 Apto 211', '3767439', '2147483647', 'wagallardo@misena.edu.co', '4', '2', '3', '1', '1', '');
INSERT INTO `persona` VALUES ('20', '3', '1087132591', 'sammy', 'roberto', 'ruiz', 'ruiacines', '2', 'calle41A #50-33', '3314332', '2147483647', 'samyconciente12@hotmail.com', '1', '1', '1', '1', '1', '');

-- ----------------------------
-- Table structure for rh
-- ----------------------------
DROP TABLE IF EXISTS `rh`;
CREATE TABLE `rh` (
  `RHidRhPK` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `RHdesRh` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`RHidRhPK`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of rh
-- ----------------------------
INSERT INTO `rh` VALUES ('1', 'A+');
INSERT INTO `rh` VALUES ('2', 'B+');
INSERT INTO `rh` VALUES ('3', 'AB+');
INSERT INTO `rh` VALUES ('4', 'O+');
INSERT INTO `rh` VALUES ('5', 'A-');
INSERT INTO `rh` VALUES ('6', 'B-');
INSERT INTO `rh` VALUES ('7', 'AB-');
INSERT INTO `rh` VALUES ('8', 'O-');

-- ----------------------------
-- Table structure for rol
-- ----------------------------
DROP TABLE IF EXISTS `rol`;
CREATE TABLE `rol` (
  `ROLidRolPK` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ROLdesRol` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`ROLidRolPK`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of rol
-- ----------------------------
INSERT INTO `rol` VALUES ('1', 'ADMINISTRADOR');
INSERT INTO `rol` VALUES ('2', 'OPERADOR');
INSERT INTO `rol` VALUES ('3', 'REGISTRADOR');
INSERT INTO `rol` VALUES ('4', 'NINGUNO');

-- ----------------------------
-- Table structure for sede
-- ----------------------------
DROP TABLE IF EXISTS `sede`;
CREATE TABLE `sede` (
  `SEDIdSedPK` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `SEDnomSed` varchar(100) DEFAULT NULL,
  `SEDcodSenSed` int(20) DEFAULT NULL,
  PRIMARY KEY (`SEDIdSedPK`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sede
-- ----------------------------
INSERT INTO `sede` VALUES ('1', 'CEAI', '1234');

-- ----------------------------
-- Table structure for tipentsal
-- ----------------------------
DROP TABLE IF EXISTS `tipentsal`;
CREATE TABLE `tipentsal` (
  `TESidTiEnSaPK` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `TESdeTiEnSa` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`TESidTiEnSaPK`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tipentsal
-- ----------------------------
INSERT INTO `tipentsal` VALUES ('1', 'Entrada');
INSERT INTO `tipentsal` VALUES ('2', 'Salida');
INSERT INTO `tipentsal` VALUES ('3', 'Registro');

-- ----------------------------
-- Table structure for tipequ
-- ----------------------------
DROP TABLE IF EXISTS `tipequ`;
CREATE TABLE `tipequ` (
  `TEidTiEqPK` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `TEclaEqu` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`TEidTiEqPK`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tipequ
-- ----------------------------
INSERT INTO `tipequ` VALUES ('1', 'Portatil');
INSERT INTO `tipequ` VALUES ('2', 'Tablet');
INSERT INTO `tipequ` VALUES ('3', 'Celular');
INSERT INTO `tipequ` VALUES ('4', 'Proyector');

-- ----------------------------
-- Table structure for tipper
-- ----------------------------
DROP TABLE IF EXISTS `tipper`;
CREATE TABLE `tipper` (
  `TPidTiPePK` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `TPdeTiPe` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`TPidTiPePK`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tipper
-- ----------------------------
INSERT INTO `tipper` VALUES ('1', 'Instructor');
INSERT INTO `tipper` VALUES ('2', 'Aprendiz');
INSERT INTO `tipper` VALUES ('3', 'Contratista');
INSERT INTO `tipper` VALUES ('4', 'Administrativo');
