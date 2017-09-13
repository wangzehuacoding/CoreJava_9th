hashcode in String:
int hash = 0;
for(int i = 0; i < length(); i++)
  hash = 31 * hash + charAt(i);
  
//@overload hashcode in Employee
public int hashCode()
{
  return 7*Objects.hashCode(name)+11*new Double(aslary).hashCode() + 13*Objects.hashCode(hireDay);
}
//Or
public int hashCode()
{
  return Objects.hash(name,salary,hireDay);
}

