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
  
  
  
  
