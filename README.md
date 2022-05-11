# 課題4

Spring Boot + Thymeleaf + MyBatis による MySQL への接続とデータ取得。

## 構成要件

- Java 17
- Gradle 7.4.2
- Spring Boot 2.6.7
- MySQL 8.0.29 ubuntu 0.20.04.3 for Linux
- MyBatis Spring Boot Starter 2.2.2

## 起動方法

1. このレポジトリをクローンする
1. MySQLを起動する（後述のテーブルを事前に用意する）
1. `gradle build` -> `gralde bootRun` でSpringを起動状態とする
1. ブラウザで `localhost8080` にアクセスする
1. 表示されるリンクを押してページ遷移する
1. いくつかのパターンのデータを抽出した結果が表示される

## テーブル構造と格納データ

### テーブル構造

| TABLE NAME<br>[players] | id | name | age | state |
| :-: | -- | ---- | --- | ----- |
| TYPE | INT(10)<br>PRIMARY KEY<br>AUTO_INCREMENT | VARCHAR(50)<br>NOT NULL | INT(10)<br>NOT NULL | VARCHAR(50)<br>NOT NULL |

### 格納データ

| id | name | age | state |
| - | - | - | - |
| 1 | Air Jordan | 59 | Brooklyn |
| 2 | Scotty Maurice Pippen Sr. | 56 | Arkansas |
| 3 | Dennis Keith Rodman | 60 | New Jersey |
| 4 | Toni Kukoc | 53 | Yugosravia:Split |
| 5 | Ron Harper | 58 | Ohio |

## 今回のウェブアプリの意図

- basketballplayer データベースの players テーブルから情報を読み出す（Read処理の実装）
  - MyBatis がマッピングするための `Player` クラスを `/entity/Player.java` に作成する
  - Mapper でSQLクエリを管理するため、複数のMapperメソッドの作成を試みる
- Controller の違いを利用して、HTMLのリンクから各種SQLを発行させる 
  - @Controller, @RestController アノテーションの違いを確認する
  - `localhost:8080` `localhost:8080/index` `localhost:8080/index.html` の3種のアクセスは全て同じ `/templates/index.html` を指す仕様とした
  - @RequestMapping (+ @GetMapping) により、いくつかのアクセスパスを用意して、ここでSQL発行メソッドを実行する

## 今回のウェブアプリの挙動

 - `localhost:8080` , `localhost:8080/index` , `localhost:8080/index.html` にアクセスすると、2回めのスリーピートを達成した当時のシカゴ・ブルズに所属した伝説的選手であるマイケル・ジョーダンについての説明（Wikipediaの引用）が表示される
 - 選手一覧をクリックすると `/players` にアクセスし、 `players` テーブルの全ての選手名のみを表示する
 - 「伝説のプレイヤー」を押すと `/jordan` にアクセスし、 `players` テーブルの id 1 に登録された選手の名前が、ただひとつ表示される
 - バスケットマンですから