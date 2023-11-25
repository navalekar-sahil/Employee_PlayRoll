import java.util.ArrayList;

abstract class Employee{
    private String name;
    private int id;
    public Employee(String name,int id){
        this.name=name;
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }

    public abstract double calculateSalery();

    @Override
    public String  toString(){

        return "Employee name   :"+name+"\nEmployee Id     : "+id+"\nEmployee Salery :"+calculateSalery();

    }
}
class FullTime_Employee extends Employee{
    private double salery;
    public FullTime_Employee(String name, int id,double salery) {
        super(name, id);
        this.salery=salery;
    }

    @Override
    public double calculateSalery() {
        return salery;
    }
}
class PartTime_Employee extends Employee{
    private int work_hour;
    private double hourly_rate;

    public PartTime_Employee(String name,int id,int work_hour,double hourly_rate ){
        super(name,id);
        this.work_hour=work_hour;
        this.hourly_rate=hourly_rate;
    }

    @Override
    public double calculateSalery() {
        return work_hour*hourly_rate;
    }
}
class Employee_PlayRoll{
    private ArrayList<Employee> employeeList;

    public Employee_PlayRoll(){
        employeeList=new ArrayList<>();
    }

    //Add Employee in list
    public void addEmployeee(Employee employee){
        employeeList.add(employee);

    }

    //remove Employee from list with selected index
    public void removeEmployee(int id){
        System.out.println();
        System.out.println("Employees are : ");
        System.out.println();
        for (Employee employee:employeeList) {
            if (employee.getId()==id){
               employeeList.remove(employee);
            }
        }
    }

    //show All employee from the list
    public void showEmpoyee(){
        for (Employee emp:employeeList) {
            System.out.println(emp+"\n");
        }
    }

}


public class Main {
    public static void main(String[] args) {
        //creating object of Employee_playRoll class
        Employee_PlayRoll employeePlayRoll=new Employee_PlayRoll();

        //create Full-time_Employee
        FullTime_Employee emp1=new FullTime_Employee("sahil",1,55000);

        //create Part-time_Employee
        PartTime_Employee emp2 =new PartTime_Employee("amit",2,50,90);
        FullTime_Employee emp3=new FullTime_Employee("sushil",3,10000);
        PartTime_Employee emp4 =new PartTime_Employee("sumit",4,53,70);


        //Add Employees in list
        employeePlayRoll.addEmployeee(emp1);
        employeePlayRoll.addEmployeee(emp2);
        employeePlayRoll.addEmployeee(emp3);
        employeePlayRoll.addEmployeee(emp4);

        // remove selected employee from the list
        employeePlayRoll.removeEmployee(3);

        //show all the Employee from the list
        employeePlayRoll.showEmpoyee();

    }
}