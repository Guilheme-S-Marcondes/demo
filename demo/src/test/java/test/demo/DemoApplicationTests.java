package test.demo;

import java.util.regex.Pattern;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class DemoApplicationTests {

	private CarRepository repository;

	@PostMapping("/estacionamentos")
	public String receiveCar(@RequestBody String placa) {
        if (Pattern.matches("[A-Z]{3}\\d{4}", placa)){
            Car kuko = new Car(placa);
            repository.save(kuko);
            return "{\"status\":\"sucesso\",\"mensagem\":\"veiculo cadastrado com sucesso\",\"id\":"+kuko.getId()+"}";
        } else {
            return "{\"status\":\"erro\",\"mensagem\":\"placa inválida ou não enviada\"}";
        }
	}
	
    @GetMapping("/estacionamentos/{id}")
    public String getCar(@PathVariable int id){
        return repository.findById(id).orElseThrow(() -> new CarNotFoundException(id)).toString();
    }
	
    @PutMapping("/estacionamentos/{id}/saida")
    public String expelCar(@PathVariable int id){
        return repository.findById(id).orElseThrow(() -> new CarNotFoundException(id)).toString();
    }

    @PutMapping("/estacionamentos/{id}/pagamento")
    public String getPagamento(@PathVariable int id){
        return repository.findById(id).orElseThrow(() -> new CarNotFoundException(id)).toString();
    }
}
