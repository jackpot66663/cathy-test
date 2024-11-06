## API 資料 /api/getData
- 宣告一 RequestWrapper 發送符合api網址之格式之請求
- 獲得後端資料
- 寫入DB
## 架構
- Controller : 控制層，處理網頁請求，並調用對應服務層
- Service : 服務層，處理Product所有的業務邏輯
- Repo : 資料存取層，存取資料庫內容
- model : Java物件，存放對應的資料庫物件(ORM)
- bean : Java物件，存放頁面物件和對api所規範的request封裝物件

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
- 判斷timestamp是否符合邏輯
- 判斷是否有找到timestamp下的product price
- 回傳json string
