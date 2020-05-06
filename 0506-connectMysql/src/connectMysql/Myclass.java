package connectMysql;

import java.sql.*;
/*先在工程下创建lib文件夹，然后导入mysql-connector-java-5.1.47.jar,
      然后右击该jar包，选择Build Path->add……
 */
/*mysql数据库的操作
C:\Users\lenovo>mysql -u root -p
Enter password: ******（123456）
//欢迎语

mysql> CREATE DATABASE testdatabase;	//建库

mysql> show databases;	//查询所有数据库，database后要有负数s
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| performance_schema |
| sys                |
| testdatabase       |
+--------------------+

mysql> use testdatabase		//使用testdatabase数据库

mysql> create table websites (		//建表
    -> id int,
    -> name varchar(20) comment '网站名',
    -> url varchar(20)
    -> );

mysql> desc websites;		//展示表
+-------+-------------+------+-----+---------+-------+
| Field | Type        | Null | Key | Default | Extra |
+-------+-------------+------+-----+---------+-------+
| id    | int(11)     | YES  |     | NULL    |       |
| name  | varchar(20) | YES  |     | NULL    |       |
| url   | varchar(20) | YES  |     | NULL    |       |
+-------+-------------+------+-----+---------+-------+

mysql> insert into websites (id,name,url) values	//插入两条数据
    -> (1,'百度','www.baidu.com'),
    -> (2,'淘宝','www.taobao.com');
 */
 
public class Myclass {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3306/testdatabase";
	 
	// MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
	//static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	//static final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB?useSSL=false&serverTimezone=UTC";
	 
	// 数据库的用户名与密码，需要根据自己的设置
	static final String USER = "root";
	static final String PASS = "123456";
	 
	public static void main(String[] args) {
	    Connection conn = null;
	    Statement stmt = null;
	    try {
	        // 注册 JDBC 驱动
	        Class.forName(JDBC_DRIVER);
	        
	        // 打开链接
	        System.out.println("连接数据库...");
	        conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        System.out.println("Connect Success!");
	        
	        stmt = conn.createStatement();
	        System.out.println(" 实例化Statement对象成功");
	        String sql;
	        sql = "SELECT id, name, url FROM websites";
	            
	        //执行查询
	        ResultSet rs = stmt.executeQuery(sql);
	        
	        // 展开结果集数据库
	        while (rs.next()) {
	            // 通过字段检索
	            int id  = rs.getInt("id");
	            String name = rs.getString("name");
	            String url = rs.getString("url");
	    
	            // 输出数据
	            System.out.print("ID: " + id);
	            System.out.print(", 站点名称: " + name);
	            System.out.print(", 站点 URL: " + url);
	            System.out.print("\n");
	        }
	         
	        // 完成后关闭
	        rs.close();
	        stmt.close();
	        conn.close();
        } catch (SQLException se) {
	        // 处理 JDBC 错误
	        se.printStackTrace();
        } catch (Exception e) {
	        // 处理 Class.forName 错误
	        e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (stmt!=null) stmt.close();
            } catch (SQLException se2) {
	           	// 什么都不做
            }
            try {
                if (conn != null) 
                	conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}

/*运行结果：
连接数据库...
Wed May 06 09:26:59 CST 2020 WARN: Establishing SSL connection without server's identity verification is not recommended. According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be established by default if explicit option isn't set. For compliance with existing applications not using SSL the verifyServerCertificate property is set to 'false'. You need either to explicitly disable SSL by setting useSSL=false, or set useSSL=true and provide truststore for server certificate verification.
Connect Success!
 实例化Statement对象成功
ID: 1, 站点名称: 百度, 站点 URL: www.baidu.com
ID: 2, 站点名称: 淘宝, 站点 URL: www.taobao.com
Goodbye!
 */