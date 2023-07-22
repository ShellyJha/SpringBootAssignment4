package com.springboot.assignmentfive.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.assignmentfive.bean.Employee;

@RestController
public class EmployeeController {
	private static Integer EmployeeCount=0;
	public static Map<Integer,Employee> employeeMap=new HashMap<Integer,Employee>();
	@PostMapping("/saveEmployee")
	public String saveEmployee(@RequestBody Employee emp) {
         
         employeeMap.put(++EmployeeCount, emp);
         return "Employee saved successfully!!!!";
}
	@GetMapping("/getAllEmployees")
	public Map<Integer,Employee> getAllEmployee(){
		
		return employeeMap;
		
		
	}
	@GetMapping("/getIndividualEmployee/{id}")
	public Employee getOneEmployee(@PathVariable("id")Integer id) {
		Employee emp=employeeMap.get(id);
		return emp;
		
	}
	@DeleteMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable("id")Integer id){
		employeeMap.remove(id);
		return "Employee record deleted successfully!!!";
	}
	@PutMapping("/updateEmployee/{id}")
	public String updateEmployee(@PathVariable("id")Integer id,@RequestBody Employee emp){
		  if(employeeMap.containsKey(id)) {
			//Employee emp1=employeeMap.get(id);
			employeeMap.put(id, emp);
			return "Employee updated successfully!!!";
	}
		  else {
			  return "There is no employee record for given id";
		  }
		
		
		
		
	}
}
