package io.github.dougllasfps;

import io.github.dougllasfps.domain.entity.Cliente;
import io.github.dougllasfps.domain.entity.Pedido;
import io.github.dougllasfps.domain.repository.Clientes;
import io.github.dougllasfps.domain.repository.Pedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@RestController
public class VendasApplication extends SpringBootServletInitializer {

    @Value("${application.name}")
    private String applicationName;

    @GetMapping("/hello")
    public String helloWorld(){
        return applicationName;
    }

    @Bean
    public CommandLineRunner init(
            @Autowired Clientes clientes,
            @Autowired Pedidos pedidos){
        return args -> {

//            System.out.println("Salvando cLientes");
//
//            clientes.save(new Cliente("Jeannn"));
//            Cliente fulano = clientes.save(new Cliente("Outro clientenn"));
//
//            Pedido p = new Pedido();
//            p.setCliente(fulano);
//            p.setDataPedido(LocalDate.now());
//            p.setTotal(BigDecimal.valueOf(100));
//
//            pedidos.save(p);
//
//            pedidos.findByCliente(fulano).forEach(System.out::println);



//            Cliente cliente = clientes.findClienteFetchPedidos(fulano.getId());
//            System.out.println(cliente);
//            System.out.println(cliente.getPedidos());

//            List<Cliente> todosClientes = clientes.findAll();
//            todosClientes.forEach(System.out::println);

//
//            System.out.println("Atualizando Clientes");
//            todosClientes.forEach(c -> {
//                c.setNome(c.getNome() + " atualizado.");
//                clientes.save(c);
//            });
//
//            todosClientes = clientes.findAll();
//            todosClientes.forEach(System.out::println);
//
//            System.out.println("Buscando Clientes");
//            clientes.findByNomeLike("Cli").forEach(System.out::println);
//
//            System.out.println("Deletando Clientes");
//            clientes.findAll().forEach(c -> {
//                clientes.delete(c);
//            });
//
//            todosClientes = clientes.findAll();
//
//            if(todosClientes.isEmpty()){
//                System.out.println("Nenhum cliente encontrado");
//            }else{
//                todosClientes.forEach(System.out::println);
//            }

        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
