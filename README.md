## CRUD SQL語法
每個api後面會帶productid和timestamp參數

1.查詢 /api/search
```sql
SELECT p FROM ProductPrice p WHERE p.product_id = :product_id AND p.timestamp = :timestamp
```
2.修改 /api/update
```sql
UPDATE ProductPrice p SET p.price = :price WHERE p.product_id = :product_id AND p.timestamp = :timestamp
```
3.新增 /api/insert
- 透過hibernate用save存入

4.刪除 /api/delete
```sql
DELETE FROM ProductPrice p WHERE p.product_id = :product_id AND p.timestamp = :timestamp
```
5.計算漲跌 /api/rate
url後面帶productid以及兩個timestamp
- 判斷timestamp是否符合
- 判斷是否有找到timestamp下的product price
- 回傳json string
