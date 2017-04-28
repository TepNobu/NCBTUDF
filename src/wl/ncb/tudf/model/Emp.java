package wl.ncb.tudf.model;

public class Emp {

  private String emp_id;
  private String emp_name;
  private String emp_lname;
  private String title_id;
  
  public Emp(String emp_id,String emp_name){
	  this.emp_id = emp_id;
	  this.emp_name = emp_name;
  }

public String getEmp_id() {
	return emp_id;
}

public void setEmp_id(String emp_id) {
	this.emp_id = emp_id;
}

public String getEmp_name() {
	return emp_name;
}

public void setEmp_name(String emp_name) {
	this.emp_name = emp_name;
}

public String getEmp_lname() {
	return emp_lname;
}

public void setEmp_lname(String emp_lname) {
	this.emp_lname = emp_lname;
}

public String getTitle_id() {
	return title_id;
}

public void setTitle_id(String title_id) {
	this.title_id = title_id;
}
    
  
}
