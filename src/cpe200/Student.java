package cpe200;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {

    // declare your attributes here

    private String student_name;
    private String student_id;
    private int year_of_birth;
    private boolean status;

    private static final String student_id_regex="^5([6-9]?)061([0-2]?)([0-9]{3})$";

    public Student(){
        this.student_name = "John Doe";
        this.student_id = "560610000";
        this.year_of_birth = 1990;
        this.status = false;
    }

    public Student(String name,String id) {
        this.student_name = name;
        if(this.isValidStudent_id(id)){
            this.student_id = id;
        }else{
            this.student_id = "560610000";
        }
        this.year_of_birth = 1990;
        this.status = false;
    }

    public Student(String name,String id,int year) {
        this.student_name = name;
        if(this.isValidStudent_id(id)){
            this.student_id = id;
        }else{
            this.student_id = "560610000";
        }
        if(this.isValidYOB(year)) {
            this.year_of_birth = year;
        }else{
            this.year_of_birth = 1990;
        }
        this.status = false;
    }

    public Student(String name,String id,int year,boolean status) {
        this.student_name = name;
        if(this.isValidStudent_id(id)){
            this.student_id = id;
        }else{
            this.student_id = "560610000";
        }
        if(this.isValidYOB(year)) {
            this.year_of_birth = year;
        }else{
            this.year_of_birth = 1990;
        }
        this.status = status;
    }

    public void setName(String name){
        if(name.equalsIgnoreCase("")) return;

        this.student_name = name;
    }

    public void setStudent_id(String id){
        if(id.equalsIgnoreCase("")) return;

        if(!this.isValidStudent_id(id)) return;

        this.student_id = id;
    }

    public void setYearOfBirth(int year){
        if(!this.isValidYOB(year)) return;

        this.year_of_birth = year;
    }

    public String getName(){
        return this.student_name;
    }

    public String getStudent_id(){
        return this.student_id;
    }

    public int getYearOfBirth(){

        return this.year_of_birth;

    }

    public boolean getStatus(){

        return this.status;

    }

    public boolean isActive(){
        return (this.status == true);
    }

    @Override
    public String toString() {
        String o = this.student_name + " ("
                + this.student_id + ") was born in "
                + this.year_of_birth + " is an ";

        if(this.isActive()==false){
            o = o + "INACTIVE ";
        }else{
            o = o + "ACTIVE ";
        }

        o = o + "student.";
        return o;
    }

    private boolean isValidStudent_id(String id) {

        Pattern r = Pattern.compile(this.student_id_regex);

        Matcher m = r.matcher(id);

        if (!m.find())  return false;

        return true;
    }

    private boolean isValidYOB(int yob) {

        if(yob < 1990)  return false;

        return true;
    }

}