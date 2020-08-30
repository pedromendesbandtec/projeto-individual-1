package br.com.bandtec.projetoindividual1;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/instrumentos")
public class ControllerInstrumento {

    private List<Produto> produtos = new ArrayList<>();

    private boolean verificaInicio = true;

    @PostMapping("/cadastrar/violao")
    public void cadastrarViolao(@RequestBody Violao v) {
        produtos.add(v);
    }

    @PostMapping("/cadastrar/saxofone")
    public void cadastrarSaxofone(@RequestBody Saxofone s) {
        produtos.add(s);
    }

    @GetMapping("/listar/{instrumento}")
    public List<Produto> getProdutos(@PathVariable String instrumento) {

        if (verificaInicio == true) {
            produtos.add(new Violao(1234, "Violão Giannini", 300.0, 6));
            produtos.add(new Violao(4321, "Violão Tagima", 650.0, 12));
            produtos.add(new Saxofone(5678, "Saxofone Shelter", 800.0, "Tenor"));
            produtos.add(new Saxofone(8765, "Saxofone Yamaha", 1400.0, "Barítono"));
            verificaInicio = false;
        }

        switch (instrumento) {
            case "violao":
                List<Produto> violao = new ArrayList<>();
                for (Produto p : produtos) {
                    if (p instanceof Violao) {
                        violao.add(p);
                    }
                }
                return violao;

            case "saxofone":
                List<Produto> saxofone = new ArrayList<>();
                for (Produto p : produtos) {
                    if (p instanceof Saxofone) {
                        saxofone.add(p);
                    }
                }
                return saxofone;

            case "todos":
                return produtos;

            default:
                return new ArrayList<>();
        }

    }

    @DeleteMapping("/excluir/{id}")
    public void excluirInstrumento(@PathVariable int id) {
        produtos.remove(id - 1);
    }

}