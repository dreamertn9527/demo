package dreamertn9527.top.test;

import lombok.Data;

/**
 * 类描述:
 *
 * @author:tangniannian
 * @date:2018/7/30
 * @修改描述：
 * @modifier ${tags}
 */
public class User {

    private String name;

    private Integer age;

    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
