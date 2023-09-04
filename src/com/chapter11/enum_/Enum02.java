package com.chapter11.enum_;


/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/5/28 1:20
 */
public class Enum02 {
    public static void main(String[] args) {
        System.out.println(Season2.SPRING);
        System.out.println(Season2.SUMMER);
        System.out.println(Season2.AUTUMN);
        System.out.println(Season2.WINTER);

        Season2 spring = Season2.SPRING;
        System.out.println(spring.name());
        System.out.println(spring.ordinal());
        Season2[] values = Season2.values();
        for (Season2 season : values) {
            System.out.println(season);
        }
        System.out.println();

        System.out.println(Season2.valueOf("SPRING"));
        //System.out.println(Season2.valueOf("SSPRING"));

        System.out.println(spring.getDeclaringClass());

        for (Weekday weekday : Weekday.values()) {
            System.out.println(weekday);
        }
    }
}

enum Season2 {
    SPRING("春天", "温暖"),
    SUMMER("夏天", "炎热"),
    AUTUMN("秋天", "凉爽"),
    WINTER("冬天", "寒冷");
    private final String name;
    private final String desc;

    private Season2(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    @SuppressWarnings("all")
    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';

    }
}


enum Weekday {
    //枚举的对象必须放在枚举类的首行，且用逗号间隔，用分号结尾
    MON(1, "星期一"), //常量名(构造函数实参列表)
    TUE(2, "星期二"),
    WED(3, "星期三"),
    THU(4, "星期四"),
    FRI(5, "星期五"),
    SAT(6, "星期六"),
    SUN(0, "星期日");

    //属性最好都是final
    public final int dayValue;
    private final String desc;


    //构造函数（注意是private的）的好处在于编号是自定义的，而不依赖于顺序了
    private Weekday(int dayValue, String desc) {
        this.dayValue = dayValue;
        this.desc = desc;
    }

    //覆写了toString()方法用于输出中文名
    @Override
    public String toString() {
        return this.desc;
    }
}