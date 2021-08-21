package com.liveasy.loads.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.liveasy.loads.storage.*;

@RestController
public class LoadsController {

    private final LoadRepository lr ;

    public LoadsController(LoadRepository lr)
    {
        this.lr = lr;
    }

    @GetMapping(path = "/")
    public String Index()
    {
        return "Welcome to loads api";
    }

	@PostMapping(path = "/load")
	public String Add(@RequestBody LoadEntity newLoad) {

		lr.save(newLoad);
        return "loads details added successfully";
	}

    @GetMapping(path = "/load")
    public List<LoadEntity> GetLoadsByShipperId(@RequestParam("shipperId") String shipperId)
    {
        return lr.FindByShipperId(shipperId);
    }

    @DeleteMapping(path = "/load/{loadId}")
    public String DeleteLoad(@PathVariable(value = "loadId") Long loadId)
    {
        lr.deleteById(loadId);
        return "deleted successfully";
    }

    @GetMapping(path = "/loads")
    public List<LoadEntity> GetAllLoads()
    {
        return lr.findAll();
    }

    @GetMapping(path = "/load/{loadId}")
    public LoadEntity GetLoadByLoadId(@PathVariable(value = "loadId") Long loadId)
    {
        Optional<LoadEntity> opt =  lr.findById(loadId);
        if(opt.isPresent())
        {
            return opt.get();
        }
        return null;
    }

    @PutMapping(path = "/load/{loadId}")
    public String Update(@PathVariable(value = "loadId") Long loadId,
                         @RequestBody LoadEntity newLoad)
    {
        newLoad.loadId = loadId;
        lr.save(newLoad);
        return " updated";
    }
}