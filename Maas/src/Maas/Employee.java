package Maas;

public class Employee {
    String name;
    int salary;
    int workHours;
    int hireYear;

    Employee(String name, int salary, int workHours, int hireYear ){
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }
    public int tax(int salary){
        if (this.salary>1000){
            return (salary/100)*3;
        } else {
            return salary;
        }
    }
    public int bonus(int workHours){
        int extra = workHours-40;
        int bonus = 0;
        for (int i=0; extra>i; i++){
            bonus += 30;
        }
        return bonus;
    }
    public int raiseSalary(int hireYear){ //present => 2021
        int yWorked = 2021-hireYear;
        if (yWorked > 9 && yWorked < 20){
            for (int i=0; yWorked>i; i++){
                salary += salary / 10;
            }
            return salary;
        } else if (yWorked<10){
            for (int i=0; i<yWorked; i++){
                salary += salary / 20;
            }
            return salary;
        } else { 
            for (int i=0; i<yWorked; i++){
                salary += (salary*3)/20; 
            } return salary;
        }
    }
    public String toString(){
        return "Employee ID\n" + "Der Name : " + this.name + "\nDas Gehalt : " + this.salary +
        "\nStunden/Woche : " + this.workHours + "\nAnfangjahr : " + this.hireYear +
        "\nSteuer : " + this.tax(this.salary) + "\nBonus : " + this.bonus(this.workHours) +
        "\nGehalt Erhöhung : " + (this.raiseSalary(this.hireYear) + this.bonus(this.workHours)) + 
        "\nEnd Gehalt : " + (this.bonus(this.workHours) + 
        this.raiseSalary(this.hireYear) - this.tax(this.salary)) +
        "\nTotal Gehalt : " + (this.raiseSalary(this.hireYear) + this.bonus(this.workHours))
        + this.salary;
    }
}
