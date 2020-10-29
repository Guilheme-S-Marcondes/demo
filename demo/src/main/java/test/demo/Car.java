package test.demo;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {
    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String placa;
    private LocalDateTime entrada;
    private LocalDateTime saida;
    private boolean pagou;

    public Car(String placa){
        this.placa = placa;
        this.entrada = LocalDateTime.now();
        this.pagou = false;
    }
    
    public Car(){}

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return this.placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public LocalDateTime getEntrada() {
        return this.entrada;
    }

    public void setEntrada(LocalDateTime entrada) {
        this.entrada = entrada;
    }

    public LocalDateTime getSaida() {
        return this.saida;
    }

    public void setSaida(LocalDateTime saida) {
        this.saida = saida;
    }

    public boolean isPagou() {
        return this.pagou;
    }

    public void setPagou(boolean pagou) {
        this.pagou = pagou;
    }

    public long tempoPermanecia(){
        return entrada.until(saida, ChronoUnit.MINUTES);
    }

    public String toString(){
        return "{\"id\":"+this.id+","+
                "\"tempoPermanecia\":"+this.saida == null?"o veiculo nao saiu ainda":String.format(" %d minutos",tempoPermanecia())+","+
                "\"pago\":"+ Boolean.toString(this.pagou)+","+
                "\"saida\":"+this.saida == null?"false":"true"+","+"}";
    }

}
