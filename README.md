## CRUD 功能
1.查詢
```sql
SELECT p FROM ProductPrice p WHERE p.product_id = :product_id AND p.timestamp = :timestamp
\```
2.修改
```sql
UPDATE ProductPrice p SET p.price = :price WHERE p.product_id = :product_id AND p.timestamp = :timestamp
\```
3.新增
透過hibernate用save存入

4.刪除
```sql
DELETE FROM ProductPrice p WHERE p.product_id = :product_id AND p.timestamp = :timestamp
\```
