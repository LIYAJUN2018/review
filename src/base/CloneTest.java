package base;

public class CloneTest implements Cloneable{
	
	private String name;
	private int age;
	private Ob1 ob1 ;
	
	
	public CloneTest(String name, int age, Ob1 ob1) {
		super();
		this.name = name;
		this.age = age;
		this.ob1 = ob1;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Ob1 getOb1() {
		return ob1;
	}
	public void setOb1(Ob1 ob1) {
		this.ob1 = ob1;
	}
	
	
	
	@Override
	public String toString() {
		return "CloneTest [name=" + name + ", age=" + age + ", ob1=" + ob1 + "]";
	}
	public static void main(String[] args)  {
		Ob1 ob12 = new Ob1("ob1", 20);
		CloneTest cloneTest = new CloneTest("ob", 22, ob12);
		System.out.println(cloneTest.toString());;
		Object clone = null;
		try {
			clone = cloneTest.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("clone is fail");
		}
		System.out.println(clone.toString());
	}

}

class Ob1 implements Cloneable{
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Ob1(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Ob1 [name=" + name + ", age=" + age + "]";
	}
	
}

class Father{
	public Father(int age) {
		
	}
}

class Son extends Father{

	public Son(int age) {
		super(age);
		// TODO Auto-generated constructor stub
	}

	
}