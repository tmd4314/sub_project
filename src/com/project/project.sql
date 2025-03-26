--회원
create table tbl_user (
     user_id        varchar2(10) primary key,
     user_pw       varchar2(10) not null,
     user_name    varchar2(50) not null
);

--상품
create table product (
     product_code   varchar2(10)  primary key,
     product_name   varchar2(50) not null,
     price              varchar2(100) not null,
     user_id             varchar2(10) not null,
     write_date        date default sysdate,
     view_cnt         number default 0,
     quantity         number default 0
);



--리뷰
create table review (
    review_no           number primary key,
    product_code      varchar2(10) not null,
    review_content    varchar2(100) not null,
    user_id              varchar2(10) not null
);

create sequence review_seq;

--관리자
create table resident (
     residentr_id        varchar2(10) primary key,
     resident_pw       varchar2(10) not null,
     resident_name    varchar2(50) not null
);

-- 고정 회원 데이터(TEST)
insert into tbl_user(user_id,
                     user_pw,
                     user_name)
values('tmd4314',
       'dltmdals1@',
      '이승민');


-- 관리자 데이터
insert into resident(residentr_id,
                     resident_pw,
                     resident_name)
values('tmd4314',
       'dltmdals1@',
      '이승민');


-- 대용량 데이터 삽입
INSERT ALL
    INTO product (product_code, product_name, price, user_id, write_date) VALUES ('P001', '따뜻한 코트', 200000, '홍길동', current_timestamp)
    INTO product (product_code, product_name, price, user_id, write_date) VALUES ('P002', '가벼운 재킷', 150000, '이승민', current_timestamp)
    INTO product (product_code, product_name, price, user_id, write_date) VALUES ('P003', '겨울 모자', 30000, '홍길동', current_timestamp)
    INTO product (product_code, product_name, price, user_id, write_date) VALUES ('P004', '여름 반팔 티셔츠', 25000, '이승민', current_timestamp)
    INTO product (product_code, product_name, price, user_id, write_date) VALUES ('P005', '스포츠 신발', 80000, '홍길동', current_timestamp)
    INTO product (product_code, product_name, price, user_id, write_date) VALUES ('P006', '청바지', 70000, '이승민', current_timestamp)
    INTO product (product_code, product_name, price, user_id, write_date) VALUES ('P007', '정장 바지', 120000, '홍길동', current_timestamp)
    INTO product (product_code, product_name, price, user_id, write_date) VALUES ('P008', '운동화', 60000, '이승민', current_timestamp)
    INTO product (product_code, product_name, price, user_id, write_date) VALUES ('P009', '가죽 가방', 150000, '홍길동', current_timestamp)
    INTO product (product_code, product_name, price, user_id, write_date) VALUES ('P010', '스카프', 20000, '이승민', current_timestamp)
    INTO product (product_code, product_name, price, user_id, write_date) VALUES ('P011', '여성 블라우스', 50000, '홍길동', current_timestamp)
    INTO product (product_code, product_name, price, user_id, write_date) VALUES ('P012', '남성 셔츠', 55000, '이승민', current_timestamp)
    INTO product (product_code, product_name, price, user_id, write_date) VALUES ('P013', '운동복', 40000, '홍길동', current_timestamp)
    INTO product (product_code, product_name, price, user_id, write_date) VALUES ('P014', '양말', 5000, '이승민', current_timestamp)
    INTO product (product_code, product_name, price, user_id, write_date) VALUES ('P015', '벨트', 25000, '홍길동', current_timestamp)
    INTO product (product_code, product_name, price, user_id, write_date) VALUES ('P016', '모자', 15000, '이승민', current_timestamp)
    INTO product (product_code, product_name, price, user_id, write_date) VALUES ('P017', '블루투스 이어폰', 100000, '홍길동', current_timestamp)
    INTO product (product_code, product_name, price, user_id, write_date) VALUES ('P018', '휴대폰 케이스', 20000, '이승민', current_timestamp)
    INTO product (product_code, product_name, price, user_id, write_date) VALUES ('P019', '백팩', 30000, '홍길동', current_timestamp)
    INTO product (product_code, product_name, price, user_id, write_date) VALUES ('P020', '지갑', 60000, '이승민', current_timestamp)
    INTO product (product_code, product_name, price, user_id, write_date) VALUES ('P021', '스포츠 타올', 10000, '홍길동', current_timestamp)
    INTO product (product_code, product_name, price, user_id, write_date) VALUES ('P022', '여름 샌들', 30000, '이승민', current_timestamp)
    INTO product (product_code, product_name, price, user_id, write_date) VALUES ('P023', '가을 외투', 250000, '홍길동', current_timestamp)
    INTO product (product_code, product_name, price, user_id, write_date) VALUES ('P024', '겨울 장갑', 20000, '이승민', current_timestamp)
    INTO product (product_code, product_name, price, user_id, write_date) VALUES ('P025', '스포츠 양말', 10000, '홍길동', current_timestamp)
    INTO product (product_code, product_name, price, user_id, write_date) VALUES ('P026', '캐주얼 신발', 70000, '이승민', current_timestamp)
    INTO product (product_code, product_name, price, user_id, write_date) VALUES ('P027', '패딩', 300000, '홍길동', current_timestamp)
    INTO product (product_code, product_name, price, user_id, write_date) VALUES ('P028', '여성 핸드백', 120000, '이승민', current_timestamp)
    INTO product (product_code, product_name, price, user_id, write_date) VALUES ('P029', '남성 가죽 자켓', 180000, '홍길동', current_timestamp)
    INTO product (product_code, product_name, price, user_id, write_date) VALUES ('P030', '스포츠 자켓', 90000, '이승민', current_timestamp)
    INTO product (product_code, product_name, price, user_id, write_date) VALUES ('P031', '여성 스커트', 45000, '홍길동', current_timestamp)
    INTO product (product_code, product_name, price, user_id, write_date) VALUES ('P032', '남성 반바지', 40000, '이승민', current_timestamp)
    INTO product (product_code, product_name, price, user_id, write_date) VALUES ('P033', '겨울 부츠', 100000, '홍길동', current_timestamp)
    INTO product (product_code, product_name, price, user_id, write_date) VALUES ('P034', '여름 원피스', 50000, '이승민', current_timestamp)
    INTO product (product_code, product_name, price, user_id, write_date) VALUES ('P035', '운동 가방', 35000, '홍길동', current_timestamp)
    INTO product (product_code, product_name, price, user_id, write_date) VALUES ('P036', '스포츠 모자', 20000, '이승민', current_timestamp)
    INTO product (product_code, product_name, price, user_id, write_date) VALUES ('P037', '겨울 코트', 250000, '홍길동', current_timestamp)
    INTO product (product_code, product_name, price, user_id, write_date) VALUES ('P038', '여성 슬랙스', 60000, '이승민', current_timestamp)
    INTO product (product_code, product_name, price, user_id, write_date) VALUES ('P039', '남성 티셔츠', 30000, '홍길동', current_timestamp)
    INTO product (product_code, product_name, price, user_id, write_date) VALUES ('P040', '청재킷', 80000, '이승민', current_timestamp)
    INTO product (product_code, product_name, price, user_id, write_date) VALUES ('P041', '면바지', 70000, '홍길동', current_timestamp)
    INTO product (product_code, product_name, price, user_id, write_date) VALUES ('P042', '여성 점퍼', 95000, '이승민', current_timestamp)
    INTO product (product_code, product_name, price, user_id, write_date) VALUES ('P043', '남성 트레이닝복', 60000, '홍길동', current_timestamp)
    INTO product (product_code, product_name, price, user_id, write_date) VALUES ('P044', '스니커즈', 85000, '이승민', current_timestamp)
    INTO product (product_code, product_name, price, user_id, write_date) VALUES ('P045', '조끼', 40000, '홍길동', current_timestamp)
    INTO product (product_code, product_name, price, user_id, write_date) VALUES ('P046', '겨울 패딩', 300000, '이승민', current_timestamp)
    INTO product (product_code, product_name, price, user_id, write_date) VALUES ('P047', '여성 블랙 드레스', 150000, '홍길동', current_timestamp)
    INTO product (product_code, product_name, price, user_id, write_date) VALUES ('P048', '가을 코트', 300000, '이승민', current_timestamp)
    INTO product (product_code, product_name, price, user_id, write_date) VALUES ('P049', '남성 화이트 코트', 150000, '홍길동', current_timestamp)
    INTO product (product_code, product_name, price, user_id, write_date) VALUES ('P050', '여성 웜톤 코트', 300000, '이승민', current_timestamp)
SELECT * FROM dual;

INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P001', '리뷰 테스트중입니다.', 'user01');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P001', '리뷰 테스트중입니다.', 'user02');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P001', '리뷰 테스트중입니다.', 'user01');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P001', '리뷰 테스트중입니다.', 'user03');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P001', '리뷰 테스트중입니다.', 'tmd4314');

INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P002', '리뷰 테스트중입니다.', 'user02');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P002', '리뷰 테스트중입니다.', 'user01');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P002', '리뷰 테스트중입니다.', 'user02');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P002', '리뷰 테스트중입니다.', 'user03');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P002', '리뷰 테스트중입니다.', 'tmd4314');

INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P003', '리뷰 테스트중입니다.', 'user01');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P003', '리뷰 테스트중입니다.', 'user02');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P003', '리뷰 테스트중입니다.', 'user03');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P003', '리뷰 테스트중입니다.', 'tmd4314');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P003', '리뷰 테스트중입니다.', 'user01');

INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P004', '리뷰 테스트중입니다.', 'user02');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P004', '리뷰 테스트중입니다.', 'user01');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P004', '리뷰 테스트중입니다.', 'user02');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P004', '리뷰 테스트중입니다.', 'user03');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P004', '리뷰 테스트중입니다.', 'tmd4314');

INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P005', '리뷰 테스트중입니다.', 'user01');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P005', '리뷰 테스트중입니다.', 'user02');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P005', '리뷰 테스트중입니다.', 'user01');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P005', '리뷰 테스트중입니다.', 'user03');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P005', '리뷰 테스트중입니다.', 'tmd4314');

INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P006', '리뷰 테스트중입니다.', 'user01');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P006', '리뷰 테스트중입니다.', 'user02');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P006', '리뷰 테스트중입니다.', 'user01');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P006', '리뷰 테스트중입니다.', 'user03');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P006', '리뷰 테스트중입니다.', 'tmd4314');

INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P007', '리뷰 테스트중입니다.', 'user02');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P007', '리뷰 테스트중입니다.', 'user01');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P007', '리뷰 테스트중입니다.', 'user03');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P007', '리뷰 테스트중입니다.', 'tmd4314');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P007', '리뷰 테스트중입니다.', 'user02');

INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P008', '리뷰 테스트중입니다.', 'user01');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P008', '리뷰 테스트중입니다.', 'user03');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P008', '리뷰 테스트중입니다.', 'user02');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P008', '리뷰 테스트중입니다.', 'tmd4314');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P008', '리뷰 테스트중입니다.', 'user01');

INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P009', '리뷰 테스트중입니다.', 'user02');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P009', '리뷰 테스트중입니다.', 'user01');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P009', '리뷰 테스트중입니다.', 'user03');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P009', '리뷰 테스트중입니다.', 'tmd4314');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P009', '리뷰 테스트중입니다.', 'user02');

INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P010', '리뷰 테스트중입니다.', 'user01');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P010', '리뷰 테스트중입니다.', 'user02');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P010', '리뷰 테스트중입니다.', 'user03');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P010', '리뷰 테스트중입니다.', 'tmd4314');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P010', '리뷰 테스트중입니다.', 'user01');

INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P011', '리뷰 테스트중입니다.', 'user02');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P011', '리뷰 테스트중입니다.', 'user01');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P011', '리뷰 테스트중입니다.', 'user03');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P011', '리뷰 테스트중입니다.', 'tmd4314');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P011', '리뷰 테스트중입니다.', 'user02');

INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P012', '리뷰 테스트중입니다.', 'user01');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P012', '리뷰 테스트중입니다.', 'user02');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P012', '리뷰 테스트중입니다.', 'user03');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P012', '리뷰 테스트중입니다.', 'tmd4314');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P012', '리뷰 테스트중입니다.', 'user01');

INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P013', '리뷰 테스트중입니다.', 'user02');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P013', '리뷰 테스트중입니다.', 'user01');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P013', '리뷰 테스트중입니다.', 'user03');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P013', '리뷰 테스트중입니다.', 'tmd4314');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P013', '리뷰 테스트중입니다.', 'user02');

INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P014', '리뷰 테스트중입니다.', 'user01');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P014', '리뷰 테스트중입니다.', 'user02');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P014', '리뷰 테스트중입니다.', 'user03');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P014', '리뷰 테스트중입니다.', 'tmd4314');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P014', '리뷰 테스트중입니다.', 'user01');

INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P015', '리뷰 테스트중입니다.', 'user02');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P015', '리뷰 테스트중입니다.', 'user01');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P015', '리뷰 테스트중입니다.', 'user03');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P015', '리뷰 테스트중입니다.', 'tmd4314');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P015', '리뷰 테스트중입니다.', 'user03');

INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P016', '리뷰 테스트중입니다.', 'user01');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P016', '리뷰 테스트중입니다.', 'user02');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P016', '리뷰 테스트중입니다.', 'user01');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P016', '리뷰 테스트중입니다.', 'user03');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P016', '리뷰 테스트중입니다.', 'tmd4314');

INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P017', '리뷰 테스트중입니다.', 'user02');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P017', '리뷰 테스트중입니다.', 'user01');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P017', '리뷰 테스트중입니다.', 'user03');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P017', '리뷰 테스트중입니다.', 'tmd4314');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P017', '리뷰 테스트중입니다.', 'user02');

INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P018', '리뷰 테스트중입니다.', 'user01');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P018', '리뷰 테스트중입니다.', 'user03');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P018', '리뷰 테스트중입니다.', 'user02');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P018', '리뷰 테스트중입니다.', 'tmd4314');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P018', '리뷰 테스트중입니다.', 'user01');

INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P019', '리뷰 테스트중입니다.', 'user02');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P019', '리뷰 테스트중입니다.', 'user01');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P019', '리뷰 테스트중입니다.', 'user03');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P019', '리뷰 테스트중입니다.', 'tmd4314');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P019', '리뷰 테스트중입니다.', 'user02');

INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P020', '리뷰 테스트중입니다.', 'user01');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P020', '리뷰 테스트중입니다.', 'user02');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P020', '리뷰 테스트중입니다.', 'user03');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P020', '리뷰 테스트중입니다.', 'tmd4314');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P020', '리뷰 테스트중입니다.', 'user01');

INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P021', '리뷰 테스트중입니다.', 'user02');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P021', '리뷰 테스트중입니다.', 'user01');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P021', '리뷰 테스트중입니다.', 'user03');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P021', '리뷰 테스트중입니다.', 'tmd4314');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P021', '리뷰 테스트중입니다.', 'user02');

INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P022', '리뷰 테스트중입니다.', 'user01');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P022', '리뷰 테스트중입니다.', 'user02');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P022', '리뷰 테스트중입니다.', 'user03');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P022', '리뷰 테스트중입니다.', 'tmd4314');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P022', '리뷰 테스트중입니다.', 'user01');

INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P023', '리뷰 테스트중입니다.', 'user02');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P023', '리뷰 테스트중입니다.', 'user01');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P023', '리뷰 테스트중입니다.', 'user03');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P023', '리뷰 테스트중입니다.', 'tmd4314');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P023', '리뷰 테스트중입니다.', 'user02');

INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P024', '리뷰 테스트중입니다.', 'user01');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P024', '리뷰 테스트중입니다.', 'user02');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P024', '리뷰 테스트중입니다.', 'user03');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P024', '리뷰 테스트중입니다.', 'tmd4314');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P024', '리뷰 테스트중입니다.', 'user01');

INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P025', '리뷰 테스트중입니다.', 'user02');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P025', '리뷰 테스트중입니다.', 'user01');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P025', '리뷰 테스트중입니다.', 'user03');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P025', '리뷰 테스트중입니다.', 'tmd4314');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P025', '리뷰 테스트중입니다.', 'user01');

INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P026', '리뷰 테스트중입니다.', 'user01');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P026', '리뷰 테스트중입니다.', 'user02');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P026', '리뷰 테스트중입니다.', 'user01');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P026', '리뷰 테스트중입니다.', 'user03');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P026', '리뷰 테스트중입니다.', 'tmd4314');

INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P027', '리뷰 테스트중입니다.', 'user02');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P027', '리뷰 테스트중입니다.', 'user01');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P027', '리뷰 테스트중입니다.', 'user03');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P027', '리뷰 테스트중입니다.', 'tmd4314');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P027', '리뷰 테스트중입니다.', 'user02');

INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P028', '리뷰 테스트중입니다.', 'user01');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P028', '리뷰 테스트중입니다.', 'user03');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P028', '리뷰 테스트중입니다.', 'user02');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P028', '리뷰 테스트중입니다.', 'tmd4314');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P028', '리뷰 테스트중입니다.', 'user01');

INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P029', '리뷰 테스트중입니다.', 'user02');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P029', '리뷰 테스트중입니다.', 'user01');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P029', '리뷰 테스트중입니다.', 'user03');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P029', '리뷰 테스트중입니다.', 'tmd4314');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P029', '리뷰 테스트중입니다.', 'user02');

INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P030', '리뷰 테스트중입니다.', 'user01');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P030', '리뷰 테스트중입니다.', 'user02');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P030', '리뷰 테스트중입니다.', 'user03');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P030', '리뷰 테스트중입니다.', 'tmd4314');
INSERT INTO review (review_no, product_code, review_content, user_id) VALUES (review_seq.NEXTVAL, 'P030', '리뷰 테스트중입니다.', 'user01');




    
    
commit;

select *
from   tbl_user;

select *
from   product;

select *
from   resident;

select *
from   review;

select review_seq.nextval from dual;

SELECT  p.product_code, 
	    p.product_name, 
	    p.price, 
        p.user_id, 
	    p.write_date, 
	    p.view_cnt, 
	    p.buy, 
	    r.review_no, 
	    r.review_content, 
	    r.user_id as reviewer_id 
FROM       product p 
left join  review r
on         p.product_code = r.product_code 
WHERE      p.product_code = 'a1';
