INSERT INTO OPERADORA(name) VALUES('Tim');
INSERT INTO OPERADORA(name) VALUES('vivo');
INSERT INTO OPERADORA(name) VALUES('oi');
INSERT INTO OPERADORA(name) VALUES('claro');

INSERT INTO DDD(codigo, name) VALUES(47, 'SC Note');
INSERT INTO DDD(codigo, name) VALUES(51, 'RS POA');
INSERT INTO DDD(codigo, name) VALUES(41, 'PR CTB');
INSERT INTO DDD(codigo, name) VALUES(11, 'SP Capital');

INSERT INTO PLANO(franquia, minutos, valor, tipo, operadora_id) VALUES('200MB', 100, 89.90,'CONTROLE', 1);
INSERT INTO DDD_PLANO(ddd_codigo, plano_id)  VALUES(47,1);

INSERT INTO PLANO(franquia, minutos, valor, tipo, operadora_id) VALUES('100MB', 100, 59.90,'PRE', 2);
INSERT INTO DDD_PLANO(ddd_codigo, plano_id)  VALUES(51,2);

INSERT INTO PLANO(franquia, minutos, valor, tipo, operadora_id) VALUES('1500MB', 100, 69.90,'POS', 3);
INSERT INTO DDD_PLANO(ddd_codigo, plano_id)  VALUES(11,3);
INSERT INTO DDD_PLANO(ddd_codigo, plano_id)  VALUES(47,3);
INSERT INTO DDD_PLANO(ddd_codigo, plano_id)  VALUES(41,3);

INSERT INTO PLANO(franquia, minutos, valor, tipo, operadora_id) VALUES('200MB', 100, 89.90,'CONTROLE', 3);
INSERT INTO DDD_PLANO(ddd_codigo, plano_id)  VALUES(47,4);

INSERT INTO PLANO(franquia, minutos, valor, tipo, operadora_id) VALUES('100MB', 100, 59.90,'PRE', 4);
INSERT INTO DDD_PLANO(ddd_codigo, plano_id)  VALUES(47,5);

INSERT INTO PLANO(franquia, minutos, valor, tipo, operadora_id) VALUES('200MB', 100, 89.90,'CONTROLE', 3);
INSERT INTO DDD_PLANO(ddd_codigo, plano_id)  VALUES(47,1);



