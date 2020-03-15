create table EMP_ADDR (
    EMP_ID int unsigned not null,
    ADDR_ID int unsigned not null,
    CONSTRAINT EMP_ADDR_EMP foreign key (EMP_ID) references EMPLOYEE(EMP_ID),
    CONSTRAINT EMP_ADDR_ADDR foreign key (ADDR_ID) references ADDRESS(ADDR_ID),
    CONSTRAINT EMP_ADDR_UNIQUE UNIQUE (ADDR_ID, EMP_ID)
)