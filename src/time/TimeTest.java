package time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.Period;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;
import java.util.TreeSet;

/**
 * java 8 的所有日期与时间类都是不可变类(被final修饰，像String一样)，
 * 每一次改变都会产生一个新的对象，所以，他们都是线程安全的。
 * 但是之前的Date类等是可变的，是线程不安全的。
 *
 * java 8 日期与时间API不仅把日期和时间分离开了，同时把时区也分离开了。
 * 以下三个类没有时区概念，仅表示本地的日期与时间:
 *    LocalDate: 年-月-日
 *    LocalTime: 时-分-秒
 *    LocalDateTime: 年-月-日 时-分-秒
 *
 * @author wuyuan
 * @date 2019/7/13
 * @version 1.0
 */
public class TimeTest {
    public static void main(String[] args) {
        //获取当前年月日
        LocalDate localDate1 = LocalDate.now();
        System.out.println(localDate1);
        System.out.println(localDate1.toString());
        System.out.println(localDate1.getYear() + "," + localDate1.getMonthValue() + "," + localDate1.getDayOfMonth());
        
        //传入年月日构造指定日期的localDate
        LocalDate localDate2 = LocalDate.of(2020, 2, 11);
        System.out.println(localDate2);
        
        //获取本月有多少天，本年有多少天，本年是不是闰年
        System.out.println(localDate1.lengthOfMonth());
        System.out.println(localDate1.lengthOfYear());
        System.out.println(localDate1.isLeapYear());
        
        
        System.out.println("--------------");
        
        //MonthDay只关注月和日是不是同一天，与年份无关，可以用来比较生日是否相同等
        MonthDay monthDay1 = MonthDay.now();
        MonthDay monthDay2 = MonthDay.of(7, 13);
        System.out.println(monthDay1.equals(monthDay2) ? "月日相同" : "月日不同");
        
        
        System.out.println("--------------");
        
        //YearMonth只关注年和月
        YearMonth yearMonth = YearMonth.now();
        System.out.println(yearMonth);
    
        
        System.out.println("--------------");
        
        //LocalTime关注的是时分秒
        LocalTime localTime1 = LocalTime.now();
        System.out.println(localTime1);
        
        //计算在现在时间上加2小时36分钟17秒是多会
        LocalTime localTime2 = localTime1.plusHours(2).plusMinutes(36).plusSeconds(17);
        System.out.println(localTime2);
        
        
        System.out.println("--------------");
        
        //获取所有时区名称
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        //创建一个treeSet，使时区名称按字典排序。这种写法是构造快写法，在类被创建时自动执行构造快中的代码，相当于类中的静态代码块。
        Set<String> treeSet = new TreeSet<String>() {
            {
                addAll(zoneIds);
            }
        };
        treeSet.forEach(System.out::println);
        
        
        System.out.println("--------------");
        
        //创建一个没有时区的本地日期与时间
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        
        //创建一个有本地时区的日期与时间
        ZonedDateTime zonedDateTime1 = ZonedDateTime.now();
        System.out.println(zonedDateTime1);
        
        //创建一个指定时区的zonedId并创建一个指定时区的日期与时间
        ZoneId zoneId = ZoneId.of("America/Merida");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zoneId);
        System.out.println(zonedDateTime);
    
        
        System.out.println("--------------");
    
        //Period用来计算两个日期与时间之间的间隔 -- 左闭右开
        Period period = Period.between(localDate1, localDate2);
        //获取日期间间隔多少年，多少月，多少天
        System.out.println(localDate1);
        System.out.println(localDate2);
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
        
    }
}
