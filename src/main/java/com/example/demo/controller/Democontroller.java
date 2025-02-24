package com.example.demo.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.EmployeeService;
import com.example.demo.entity.Employee;

@Controller
@RequestMapping("/employees")
public class Democontroller {
	private EmployeeService employeeService;
	public Democontroller(EmployeeService employeeService) {
		this.employeeService=employeeService;
	}
	
//	@GetMapping("/employees-list")
//    public String findAll(Model model){
//		
//		
//	        List<Employee> employees = employeeService.findAll();
//	        model.addAttribute("employees", employees);
//	        return "/employees/employees-list";
//    }
	@GetMapping("/employees-list")
    public String getAllEmployees(
            @RequestParam(name = "id", required = false) Long id,
            @RequestParam(name = "name", required = false) String name,
            Model model) {

        if (id != null) {
            Optional<Employee> employee = employeeService.findById(id);
            employee.ifPresent(value -> model.addAttribute("searchResult", value));
        } else if (name != null && !name.trim().isEmpty()) {
            List<Employee> employeesByName = employeeService.findByFirstName(name);
            model.addAttribute("searchByNameResults", employeesByName);
            System.out.println(employeesByName);        
            }

        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        return "/employees/employees-list";
    }
    
//	@GetMapping("/employees")
//    public String getEmployee(@RequestParam("employeeId") int employeeId,Model model) {
//
//        Employee theEmployee = employeeService.findById(employeeId);
//
//        if (theEmployee == null) {
//            throw new RuntimeException("Employee id not found - " + employeeId);
//        }
//        model.addAttribute("employee",theEmployee);
//        return "/employees/single";
//    }
	
	@GetMapping("/formForAdding")
    public String addEmployee(Model model) {


        Employee emp=new Employee();

        model.addAttribute("employee",emp);

        return "/employees/employee-form";
    }
	
	@GetMapping("/formForUpdating")
    public String updateEmployee(@RequestParam("employeeId") Long id,Model model) {

        Optional<Employee> emp=employeeService.findById(id);
        model.addAttribute("employee",emp);

        return "/employees/employee-form";
    }
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {

		employeeService.save(theEmployee);

		return "redirect:/employees/employees-list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId) {

		employeeService.deleteById(theId);

		
		return "redirect:/employees/employees-list";

	}
	
//	 @DeleteMapping("/employees/{employeeId}")
//	    public String deleteEmployee(@PathVariable("employeeId") int employeeId) {
//
//	        Employee tempEmployee = employeeService.findById(employeeId);
//
//	        
//
//	        if (tempEmployee == null) {
//	            throw new RuntimeException("Employee id not found - " + employeeId);
//	        }
//
//	        employeeService.deleteById(employeeId);
//
//	        return "Deleted employee id - " + employeeId;
//	    }


    

   

}
