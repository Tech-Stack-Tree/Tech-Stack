
## JOIN
 - 1) 하나의 SQL명령문에 의해 여러 테이블에 저장된 데이터를 한번에 조회할 수 있는 기능
 -  2) 관계형 데이터베이스 분야의 표준
 -  3) 3) 두개 이상의 테이블을 '결합'한다는 의미 

 

 

 

## JOIN 종류

### INNER JOIN(교집합) => 다른 테이이블에서 데이터를 연결 

### EQUI_JOIN
- 1. Oracle JOIN : Oracle에서만 사용하는 쿼리 문장
```sql
         형식)

          SELECT 컬럼명, 컬렴명...

          FROM 테이블명, 테이블명 

          WHERE 테이블명.col=테이블명.col

          ***컬럼명이 다른 경우에는 테이블(별칭).

              생략이 가능

          emp, dept
```
 - 2. ANSI JOIN : 전체 데이터베이스에서 사용하는 쿼리
```sql
         형식)

           SELECT 컬럼명, 컬렴명...

           FROM 테이블명 (INNER)JOIN 테이블명

           ON 테이블명.col=테이블명.col
```

- 3. NATRUAL JOIN
  ```sql
         형식)

           SELECT 컬럼명, 컬럼명...

           FROM emp NATURAL JOIN dept;
  ```
 - 4. JOIN~USI
```sql
         형식)

           SELECT 컬럼명, 컬럼명...

           FROM emp JOIN dept USING(deptno);
```
### NON EQUI_JOIN

-  NON EQUI_JOIN 
  : =이 아닌 연산자 => 비교연산자, BETWEEN~AND, 



-  OUTER JOIN => 다른 테이블에서 데이터를 연결

 
-  SELF JOIN => 같은 테이블에서 데이터 연결
