package io.github.dougllasfps;

import io.github.dougllasfps.domain.entity.Cliente;
import io.github.dougllasfps.domain.repository.Clientes;
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
    public CommandLineRunner init(@Autowired Clientes clientes){
        return args -> {

            System.out.println("Salvando cLientes");

            clientes.salvar(new Cliente("Jean"));
            clientes.salvar(new Cliente("Outro cliente"));

            List<Cliente> todosClientes = clientes.obterTodos();
            todosClientes.forEach(System.out::println);


            System.out.println("Atualizando Clientes");
            todosClientes.forEach(c -> {
                c.setNome(c.getNome() + " atualizado.");
                clientes.atualizar(c);
            });

            todosClientes = clientes.obterTodos();
            todosClientes.forEach(System.out::println);

            System.out.println("Buscando Clientes");
            clientes.buscarPorNome("Cli").forEach(System.out::println);

            System.out.println("Deletando Clientes");
            clientes.obterTodos().forEach(c -> {
//                clientes.deletar(c);
            });

            todosClientes = clientes.obterTodos();

            if(todosClientes.isEmpty()){
                System.out.println("Nenhum cliente encontrado");
            }else{
                todosClientes.forEach(System.out::println);
            }

        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
