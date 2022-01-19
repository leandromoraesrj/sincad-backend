insert into tipo_unidade_estabelecimento
(sq_tipo_unid_estabelecimento,
 ds_tipo_unid_estabelecimento,
 co_rfb,
 in_sujeito_inscricao_estadual)
values
(se_tipo_unid_estabelecimento.nextval,
'tipo de unidade 1',
'co1',
1
);
insert into tipo_unidade_estabelecimento
(sq_tipo_unid_estabelecimento,
 ds_tipo_unid_estabelecimento,
 co_rfb,
 in_sujeito_inscricao_estadual)
values
(se_tipo_unid_estabelecimento.nextval,
'tipo de unidade 2',
'co3',
0
);

insert into regime_apuracao
(sq_regime_apuracao,
 co_regime_apuracao,
 no_regime_apuracao,
 dt_inicio,
 dt_fim)
values
(se_regime_apuracao.nextval,
1,
'normal',
trunc(sysdate),
null);
insert into regime_apuracao
(sq_regime_apuracao,
 co_regime_apuracao,
 no_regime_apuracao,
 dt_inicio,
 dt_fim)
values
(se_regime_apuracao.nextval,
2,
'simples nacional',
trunc(sysdate),
null);

insert into condicao_inscricao_estadual
(sq_condicao_inscricao_estadual,
 sq_situacao_cadastral,
 sg_condicao_inscricao_estadual,
 ds_condicao_inscricao_estadual)
values
(se_condicao_inscricao_estadual.nextval,
1,
'hr',
'habilitado');
insert into condicao_inscricao_estadual
(sq_condicao_inscricao_estadual,
 sq_situacao_cadastral,
 sg_condicao_inscricao_estadual,
 ds_condicao_inscricao_estadual)
values
(se_condicao_inscricao_estadual.nextval,
2,
'bx',
'baixado');