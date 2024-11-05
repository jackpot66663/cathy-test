## CRUD 功能
1.查詢
```SQL
@Query("SELECT p FROM ProductPrice p WHERE p.product_id = :product_id AND p.timestamp = :timestamp")
\```
2.修改
```SQL
@Query("UPDATE ProductPrice p SET p.price = :price WHERE p.product_id = :product_id AND p.timestamp = :timestamp")
\```
3.新增
```SQL
@Query("INSERT INTO ProductPrice (price,product_id,timestamp) (price,product_id,timestamp)
\```
也可透過hibernate用save存入

4.刪除
```SQL
@Query("DELETE FROM ProductPrice p WHERE p.product_id = :product_id AND p.timestamp = :timestamp")
\```
