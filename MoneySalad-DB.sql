DROP TABLE t_transaction;
DROP TABLE t_account;
DROP TABLE t_qna_board_file;
DROP TABLE t_qna_board;

DROP TABLE t_code;
DROP TABLE t_member;


DROP TABLE t_account;
CREATE TABLE t_account
(
    account_number    VARCHAR2(50) NOT NULL,
    account_bank    VARCHAR2(50) NOT NULL,
    account_nickname    VARCHAR2(50),
    balance    NUMBER(38) NOT NULL,
    id    VARCHAR2(50) NOT NULL
);

CREATE UNIQUE INDEX 엔터티1_PK1 ON t_account
( account_number );

ALTER TABLE t_account
 ADD CONSTRAINT 엔터티1_PK1 PRIMARY KEY ( account_number )
 USING INDEX 엔터티1_PK1;
 
ALTER TABLE t_account ADD CONSTRAINT t_account_id_fk
FOREIGN KEY(id) REFERENCES t_member(id) ON DELETE CASCADE; --id 삭제되면 등록된 계좌들도 삭제

ALTER TABLE t_account
ADD CONSTRAINT chk_balance CHECK (balance >= 0);

ALTER TABLE t_account MODIFY(balance  DEFAULT 0);


--------------------------------------------------------------------------------

DROP TABLE t_code;

CREATE TABLE t_code
(
    code_category    VARCHAR2(20) NOT NULL,
    code_no    VARCHAR2(20) NOT NULL,
    code_name    VARCHAR2(40) NOT NULL
);

CREATE UNIQUE INDEX 엔터티1_PK3 ON t_code
( code_category,code_no );

ALTER TABLE t_code
 ADD CONSTRAINT 엔터티1_PK3 PRIMARY KEY ( code_category,code_no )
 USING INDEX 엔터티1_PK3;


--------------------------------------------------------------------------------

DROP TABLE t_member;

CREATE TABLE t_member
(
    id    VARCHAR2(50) NOT NULL,
    password    VARCHAR2(50) NOT NULL,
    name    VARCHAR2(20) NOT NULL,
    user_type    VARCHAR2(5) NOT NULL,
    email_id    VARCHAR2(50) NOT NULL,
    email_domain    VARCHAR2(50) NOT NULL,
    tel1    VARCHAR2(10) NOT NULL,
    tel2    VARCHAR2(10) NOT NULL,
    tel3    VARCHAR2(10) NOT NULL,
    post    VARCHAR2(10) NOT NULL,
    basic_address    VARCHAR2(100) NOT NULL,
    detail_address    VARCHAR2(100) NOT NULL,
    reg_date    VARCHAR2(50) NOT NULL
    
);

CREATE UNIQUE INDEX 엔터티1_PK ON t_member
( id );

ALTER TABLE t_member
 ADD CONSTRAINT 엔터티1_PK PRIMARY KEY ( id )
 USING INDEX 엔터티1_PK;
 
ALTER TABLE t_member MODIFY(reg_date  
DEFAULT to_char(sysdate - 0/24,'yyyy-mm-dd HH24:MI:SS'));

--ALTER TABLE t_member MODIFY (tel1 VARCHAR2(10));
--ALTER TABLE t_member MODIFY (tel2 VARCHAR2(10));
--ALTER TABLE t_member MODIFY (tel3 VARCHAR2(10));


desc t_member;


--------------------------------------------------------------------------------

DROP TABLE t_qna_board;

CREATE TABLE t_qna_board
(
    board_no    VARCHAR2(100) NOT NULL,
    title    VARCHAR2(100) NOT NULL,
    content    VARCHAR2(2000) NOT NULL,
    id    VARCHAR2(50) NOT NULL,
    view_cnt    NUMBER(38) NOT NULL,
    reg_date    VARCHAR2(50) NOT NULL
);

CREATE UNIQUE INDEX 엔터티1_PK4 ON t_qna_board
( board_no );

ALTER TABLE t_qna_board
 ADD CONSTRAINT 엔터티1_PK4 PRIMARY KEY ( board_no )
 USING INDEX 엔터티1_PK4;
 
CREATE SEQUENCE seq_t_qna_board_board_no NOCACHE;
 
ALTER TABLE t_qna_board MODIFY(view_cnt  DEFAULT 0);

ALTER TABLE t_qna_board MODIFY(reg_date  
DEFAULT to_char(sysdate - 0/24,'yyyy-mm-dd HH24:MI:SS'));

ALTER TABLE t_qna_board ADD CONSTRAINT t_qna_board_id_fk   
FOREIGN KEY(id) REFERENCES t_member(id) ON DELETE CASCADE; --id 외래키 설정

ALTER TABLE t_qna_board DROP CONSTRAINT t_qna_board_id_fk; --id 외래키 설정


ALTER TABLE t_qna_board ADD CONSTRAINT t_qna_board_id_fk2   
FOREIGN KEY(id) REFERENCES t_member(id) ON DELETE CASCADE; --id 외래키 설정


--------------------------------------------------------------------------------

DROP TABLE t_qna_board_file;

CREATE TABLE t_qna_board_file
(
    file_no    VARCHAR2(100) NOT NULL,
    file_ori_name    VARCHAR2(200) NOT NULL,
    file_save_name    VARCHAR2(200) NOT NULL,
    file_size    NUMBER(20) NOT NULL,
    board_no    VARCHAR2(100) NOT NULL
);

CREATE UNIQUE INDEX 엔터티1_1_PK4 ON t_qna_board_file
( file_no );

ALTER TABLE t_qna_board_file
 ADD CONSTRAINT 엔터티1_1_PK4 PRIMARY KEY ( file_no )
 USING INDEX 엔터티1_1_PK4;
 
ALTER TABLE t_qna_board_file ADD CONSTRAINT t_qna_board_file_board_no_fk   
FOREIGN KEY(board_no) REFERENCES t_qna_board(board_no) ON DELETE CASCADE; --t_qna_board 삭제시 t_qna_board_file도 삭제

 
CREATE SEQUENCE seq_t_qna_board_file_file_no NOCACHE;


--------------------------------------------------------------------------------

DROP TABLE t_transaction;

CREATE TABLE t_transaction
(
    transaction_date    VARCHAR2(50) NOT NULL,
    account_number    VARCHAR2(50) NOT NULL,
    counter_account_number    VARCHAR2(50) NOT NULL,
    transaction_type    VARCHAR2(10) NOT NULL,
    transaction_amount    NUMBER(38) NOT NULL,
    balance      NUMBER(38) NOT NULL
);

CREATE UNIQUE INDEX 엔터티1_PK2 ON t_transaction
( transaction_date,account_number,counter_account_number );

ALTER TABLE t_transaction
 ADD CONSTRAINT 엔터티1_PK2 PRIMARY KEY ( transaction_date,account_number,counter_account_number )
 USING INDEX 엔터티1_PK2;
 
-- ALTER TABLE t_transaction ADD CONSTRAINT t_transaction_account_number_fk
-- FOREIGN KEY(account_number) REFERENCES t_account(account_number);

-- ALTER TABLE t_transaction DROP CONSTRAINT t_transaction_account_number_fk;

commit;

ALTER TABLE t_transaction MODIFY(transaction_date  
DEFAULT to_char(sysdate - 0/24,'yyyy-mm-dd HH24:MI:SS'));

ALTER TABLE t_transaction
ADD CONSTRAINT chk_transaction_amount CHECK (transaction_amount > 0);


----데이터 삽입(insert)-------------------------------------------------------------------------------------------------------------
----t_member------------------------------------------------------------------------------------------------------
insert into t_member(id,password,name,user_type,email_id,email_domain,tel1,tel2,tel3,post,basic_address,detail_address)
    values('qwe', 'qwe', '나성주','U','nsj123','gmail.com','010','1231','6452','06172','서울시','서초구');
insert into t_member(id,password,name,user_type,email_id,email_domain,tel1,tel2,tel3,post,basic_address,detail_address) 
    values('asd', 'asd', '김성재','U','ksj123','gmail.com','010','6531','0452','08172','강원도','어딘가');
    

----t_account------------------------------------------------------------------------------------------------------
insert into t_account(account_number, account_bank, account_nickname, balance, id) 
    values('123-1231-4352','캐슬은행','야식','100000','qwe');
insert into t_account(account_number, account_bank, account_nickname, balance, id) 
    values('567-6451-456','하나은행','여행목돈','700000','qwe');
insert into t_account(account_number, account_bank, account_nickname, balance, id) 
    values('33423-43-8343','기업은행','주식','430000','asd');
insert into t_account(account_number, account_bank, account_nickname, balance, id) 
    values('3765-752-2345','국민은행','커피','700000','asd');
    
----t_qna_board------------------------------------------------------------------------------------------------------\
insert into t_qna_board(board_no, title,content,id) 
    values('1','입금은 어떻게하나요?','입금하는 방법좀 알려주세요 제발ㄹㄹㄹㄹㄹㄹ','asd');
insert into t_qna_board(board_no, title,content,id) 
    values('2','출금은 어떻게하나요?','출금하는 방법좀 알려주세요 제발ㄹㄹㄹㄹㄹㄹ','asd');
insert into t_qna_board(board_no, title,content,id) 
    values('3','이체는 어떻게하나요?','이체하는 방법좀 알려주세요 제발ㄹㄹㄹㄹㄹㄹ','qwe');
insert into t_qna_board(board_no, title,content,id) 
    values('4','계좌삭제는 어떻게하나요?','삭제하는 방법좀 알려주세요 제발ㄹㄹㄹㄹㄹㄹ','qwe');
insert into t_qna_board(board_no, title,content,id) 
    values('5','시간설정이 잘되나요??','되주세요 제발ㄹㄹㄹㄹㄹㄹ','qwe');
commit;

----t_transaction------------------------------------------------------------------------------------------------------\
insert into t_transaction(account_number, counter_account_number,transaction_type,transaction_amount) 
    values('123-1231-4352','33423-43-8343','D',100000);
insert into t_transaction(account_number, counter_account_number,transaction_type,transaction_amount) 
    values('123-1231-4352','33423-43-8343','W',80000);
insert into t_transaction(account_number, counter_account_number,transaction_type,transaction_amount) 
    values('33423-43-8343','123-1231-4352','W',80000);
insert into t_transaction(account_number, counter_account_number,transaction_type,transaction_amount) 
    values('33423-43-8343','123-1231-4352','D',230000);
    
commit;


select * from t_member;
select * from t_account;
rollback;
delete from t_account where account_number = '33423-43-8343';
select * from t_qna_board order by reg_date;
select * from t_qna_board order by to_number(board_no) DESC;
select * from t_qna_board_file;

select * from t_transaction order by transaction_date desc;

select * from t_qna_board_file;

select * from t_code;

select to_char(sysdate - 0/24,'yyyy-mm-dd HH24:MI:SS') from dual;


update t_account
            set balance = (select balance from t_account where account_number = '123-1231-4352') + 70 
            where account_number = '123-1231-4352';
            
delete from  t_member where id = '123';
            
commit;

update t_member set email_id = 'sdass', tel1 = '321' where id = 'qwe';









commit;
