create table UBS
(
    id          Bigint primary key,
    ENDERECO_FK Long,
    nome        varchar(100),
    sigla       varchar(10),
    codigo      varchar(10)
);

create table Usuario
(
    id     Bigint primary key,
    nome   varchar(100),
    cartao varchar(15)
);

create table Funcionario
(
    id         Bigint primary key,
    nome       varchar(100),
    cargo      varchar(50),
    observacao varchar(50),
    status     varchar(20)
);

create table Medicamento
(
    id     Bigint primary key,
    nome   varchar(100),
    mg     Float,
    codigo varchar(10),
    tipo   varchar(30)
);

create table Endereco
(
    id           Bigint primary key,
    rua          varchar(100),
    numero       varchar(10),
    complemento  varchar(40),
    codigoPostal varchar(8),
    estado       varchar(2),
    pais         varchar(30),
    bairro       varchar(30)
);

create table Estoque_Medicamento
(
    id              Bigint primary key,
    UBS_FK          Bigint not null,
    MEDICAMENTOS_FK Bigint not null,
    quantidade      Long
);

create table Controle_medicamento
(
    id           Bigint primary key,
    ESTOQUE_FK   Bigint not null,
    USUARIO_FK      Bigint not null,
    quantidade   Bigint,
    dataRegistro Date,
    observacao   varchar(40),
    Receita      varchar(40)
);

create table Consulta_Agendamento
(
    id           Bigint primary key,
    ENDERECO_FK  Bigint not null,
    USUARIO_FK      Bigint not null,
    tipoConsulta varchar(30),
    agendamento Date,
    observacao   varchar(40)
);

create table Prontuario
(
    id             Bigint primary key,
    USUARIO_FK        Bigint not null,
    FUNCIONARIO_FK Bigint not null,
    UBS_FK         Bigint not null,
    dataRegistrado date,
    observacao     varchar(40)
);

create table Agenda_Disponivel
(
    id             Bigint primary key,
    FUNCIONARIO_FK Bigint not null,
    UBS_FK         Bigint not null,
    mes            varchar(15),
    dia            varchar(15),
    horario        varchar(10)
);

alter table Estoque_Medicamento
    add foreign key (UBS_FK) references UBS (id);

alter table Estoque_Medicamento
    add foreign key (MEDICAMENTOS_FK) references Medicamento (id);

alter table Controle_medicamento
    add foreign key (ESTOQUE_FK) references Estoque_Medicamento (id);

alter table Controle_medicamento
    add foreign key (USUARIO_FK) references Usuario (id);

alter table Consulta_Agendamento
    add foreign key (ENDERECO_FK) references Endereco (id);

alter table Consulta_Agendamento
    add foreign key (USUARIO_FK) references Usuario (id);

alter table Prontuario
    add foreign key (USUARIO_FK) references Usuario (id);

alter table Prontuario
    add foreign key (FUNCIONARIO_FK) references Funcionario (id);

alter table Prontuario
    add foreign key (ubs_fk) references UBS (id);

alter table Agenda_Disponivel
    add foreign key (FUNCIONARIO_FK) references Funcionario (id);

alter table Agenda_Disponivel
    add foreign key (UBS_FK) references UBS (id);




