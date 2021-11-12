package br.com.TesteStoon.TesteStoom.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.TesteStoon.TesteStoom.Entity.Endereco;
import br.com.TesteStoon.TesteStoom.Repository.EnderecoRepositoy.EnderecoRepository;

public class EnderecoController {
	
    @Autowired
    private EnderecoRepository _enderecoRepository;
	
    @RequestMapping(value = "/endereco", method = RequestMethod.GET)
    public List<Endereco> Get() {
        return _enderecoRepository.findAll();
    }	
    
    @RequestMapping(value = "/endereco/{id}", method = RequestMethod.GET)
    public ResponseEntity<Endereco> GetById(@PathVariable(value = "id") long id)
    {
        Optional<Endereco> endereco = _enderecoRepository.findById(id);
        if(endereco.isPresent())
            return new ResponseEntity<Endereco>(endereco.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/endereco", method =  RequestMethod.POST)
    public Endereco Post( @RequestBody Endereco endereco)
    {
        return _enderecoRepository.save(endereco);
    }    
    
    @RequestMapping(value = "/endereco/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Endereco> Put(@PathVariable(value = "id") long id, @RequestBody Endereco newEndereco)
    {
        Optional<Endereco> oldEndereco = _enderecoRepository.findById(id);
        if(oldEndereco.isPresent()){
            Endereco endereco = oldEndereco.get();
            endereco.setStreetName(newEndereco.getStreetName());
            endereco.setCity(newEndereco.getCity());
            endereco.setComplement(newEndereco.getComplement());
            endereco.setCountry(newEndereco.getCountry());
            endereco.setLatitude(newEndereco.getLatitude());
            endereco.setLongitude(newEndereco.getLongitude());
            endereco.setNeighbourhood(newEndereco.getNeighbourhood());
            endereco.setNumber(newEndereco.getNumber());
            endereco.setZipcode(newEndereco.getZipcode());
            endereco.setState(newEndereco.getState());
            
            _enderecoRepository.save(endereco);
            return new ResponseEntity<Endereco>(endereco, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/endereco/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<Endereco> endereco = _enderecoRepository.findById(id);
        if(endereco.isPresent()){
        	_enderecoRepository.delete(endereco.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }    

}
