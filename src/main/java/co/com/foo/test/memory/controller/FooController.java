package co.com.foo.test.memory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.foo.test.memory.service.IFooServices;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/v1/memory")
@Api(tags = "msserpartialbalance", produces = "application/json", value = "Api encargada de exponer los servicios del proyecto")
public class FooController {

	@Autowired
	private IFooServices service;

	@GetMapping
	public String getDummyValue() {
		return service.getDummyValue();
	}

}
