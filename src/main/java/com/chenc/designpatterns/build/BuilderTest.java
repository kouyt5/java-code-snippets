package com.chenc.designpatterns.build;


/**
 * 构造者模式，内部类探索
 * @since 2021.7.21
 */
public class BuilderTest {

    private int age;
    private String name;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return this.age;
    }
    // 禁止外部初始化类
    private BuilderTest(){}

    public final static class Builder {
        private BuilderTest _builderTest = new BuilderTest();
        public BuilderTest build() {
            return this._builderTest;
        }

        public Builder age(int age) {
            this._builderTest.setAge(age);
            return this;
        }
        public Builder name(String name) {
            this._builderTest.setName(name);
            return this;
        }
    }

    public static void main(String[] args) {
        Builder builder = new BuilderTest.Builder();
    }
    
}
