
public class ConstructorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Doctor d1=new Doctor();
		Doctor d2=new Doctor();
		Doctor d3;
		d3=new Doctor();
		d1.diagnose();
		d2.diagnose();
		d3.diagnose();

	}

}
class Doctor{
	Doctor() {//this is explicit constructor
		System.out.println("constructor invoked......");
		
	}
	void diagnose() {
		System.out.println("doctor is diagnosing..........");
	}
}
