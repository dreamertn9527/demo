package dreamertn9527.top.design.template;


/**
 * 模板模式
 * 应用场景：JDBC
 * 1. 加载驱动类DiverManager
 * 2. 建立连接
 * 3. 创建语句集(标准语句集、预处理语句集)(语句集：Mysql, Oracle, DB2) 此处不确定
 * 4. 执行语句集合
 * 5. 结果集ResultSet 游标
 *  ORM实现第三步和第五步
 * @author tangniannian
 *
 */
public class Main {

	public static void main(String[] args) {
		Coffee coffee = new Coffee();
		coffee.create();
	}
}
