/**
 * Object类中的equals方法用于检测一个对象是否等于另一个对象.-判断两个对象是否具有相同的引用
 * 大多数情况下 需要重写equals方法-检测对象状态是否相同
 */
 
 class Employee
 {
     ....
     public boolean equals(Object otherObject)   
     {
     //a quick test to see if the objects are identical
     if(this == otherObject) return true;

     //must return false if the explicit parameters is null
     if(getClass() != otherObject.getClass())
        return false;

     //now we know otherObject is non-null Employee
     Employee other = (Employee) otherObject;

     //test whether the fields have identical values
     return name.equals(other.name) && salary == other.salary && hireDay.equals(other.hireDay);
     
     }
 }
 
 /**
  * 值类型是存储在内存中的堆栈（以后简称栈），而引用类型的变量在栈中仅仅是存储引用类型变量的地址，而其本身则存储在堆中。
  *
  *==操作比较的是两个变量的值是否相等，对于引用型变量表示的是两个变量在堆中存储的地址是否相同，即栈中的内容是否相同
  *
  * equals操作表示的两个变量是否是对同一个对象的引用，即堆中的内容是否相同。
  *
  * ==比较的是2个对象的地址，而equals比较的是2个对象的内容。 显然，当equals为true时，==不一定为true
  */
  
  /**
   * 在子类中定义equals方法时,首先调用超类的equals.检测失败,对象不可能相等.
   * 超类中的域都相等,需要比较子类中的实例域
   */
   
   class Manager extends Employee
   {
    ...
    public boolean equals(Object otherObject)
    {
        if(!super.equals(otherObject)) return false;
        //super.equals checked that this and otherObject belong to the same class
        Manager other = (Manager) otherObject;
        return bonus == other.bonus;
    }
   }
  
  
//相等测试与继承
/**
 * equals方法特性:自反性 对称性 传递性 一致性
 * 对于任意非空引用-X.equals(null)应该返回false.
 *就对称性来说:-当参数不属于同一个类时需要考虑 e.quals(m)
 *e是一个Employee对象 m是一个Manager对象,并且两个对象有相同的薪水，姓名与雇佣日期.如果在Employee.equals中用instanceof检测,则返回true
 *这意味着反过来调用m.euqals(e)也需要返回true.这就使得Manager类受到了束缚.这个类的equals方法必须能够用自己与任何一个Employee对象进行比较
 *而不考虑经理的特有信息.
 *有两种不同的情况进行分析:
 *如果子类拥有自己的相等概念-那么根据对称性需求将强制采用getClass进行检测.
 *如果由超类决定相等的概念,那么可以使用instanceof进行检测,这样可以在不同子类的对象之间进行相等的比较.
 */
