package com.example.demo.service;
import java.util.List;
import java.util.Optional;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	private EmployeeDao appDao;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDao appDaoobj) {
		appDao=appDaoobj;
	}
	@Override
	public List<Employee> findByFirstName(String firstName) {
        return appDao.findByFirstName(firstName);
    }
	@Override
	public List<Employee> findAll(){
		return appDao.findAll();
	}
	
	@Override
	public Optional<Employee> findById(Long theId) {
		return appDao.findById(theId);
	}
	
	@Override
    public Employee save(Employee theEmployee) {
        return appDao.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        appDao.deleteById(theId);
    }

//	 private final WebClient webClient;
//	    
//	    public EmployeeServiceImpl(WebClient.Builder webClientBuilder) {
//	        this.webClient = webClientBuilder.baseUrl("http://localhost:8080/employees").build();
//	    }
//	    @Override
//	    public List<Employee> findAll() {
//	        return webClient.get()
//	                .uri("/employees/employees-list")
//	                .retrieve()
//	                .bodyToFlux(Employee.class)
//	                .collectList()
//	                .block(); 
//	    }
//	    
//	    @Override
//	    public Optional<Employee> findById(Long id) {
//	        return Optional.ofNullable(
//	                webClient.get()
//	                        .uri("/{id}", id)
//	                        .retrieve()
//	                        .bodyToMono(Employee.class)
//	                        .block()
//	        );
//	    }
//	    
//	    @Override
//	    public List<Employee> findByFirstName(String firstName) {
//	        return webClient.get()
//	                .uri(uriBuilder -> uriBuilder.path("/search").queryParam("firstName", firstName).build())
//	                .retrieve()
//	                .bodyToFlux(Employee.class)
//	                .collectList()
//	                .block();
//	    }
//	    
//	    @Override
//	    public Employee save(Employee theEmployee) {
//	        return webClient.post()
//	                .uri("/")
//	                .bodyValue(theEmployee)
//	                .retrieve()
//	                .bodyToMono(Employee.class)
//	                .block();
//	    }
//	    
//	    @Override
//	    public void deleteById(int id) {
//	        webClient.delete()
//	                .uri("/{id}", id)
//	                .retrieve()
//	                .bodyToMono(Void.class)
//	                .block();
//	    }
}
