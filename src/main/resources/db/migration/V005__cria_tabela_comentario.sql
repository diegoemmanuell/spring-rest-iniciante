create table comentario (
	id bigint not null GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ), 
	ordem_servico_id bigint not null, 
	descricao text not null,
	data_envio TIMESTAMP 
	
	
);

alter table comentario add constraint fk_comentario_ordem_servico foreign key (ordem_servico_id) references ordem_servico(id)