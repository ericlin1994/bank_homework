create table coinRateInfo
(
    C_Id INT AUTO_INCREMENT,
    chartName varchar(255) not null,
    Currency varchar(255) not null,
    code  varchar(255),
    symbol varchar(255),
    rate  varchar(255),
    description varchar(255),
    rate_float varchar(255),
    primary key(chartName,Currency)
);

create table coinInfo
(
    chartName varchar(255)  not null,
    chineseName varchar(255)  not null,
    primary key(chartName)
);

create table coinUpdate
(
    chartName varchar(255)  not null,
    updated varchar(255)  not null,
    updatedISO varchar(255)  not null,
    updateduk varchar(255)  not null,
    primary key(chartName)
);