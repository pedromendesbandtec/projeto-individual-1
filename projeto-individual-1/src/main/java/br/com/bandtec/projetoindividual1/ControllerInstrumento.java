package br.com.bandtec.projetoindividual1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/instrumentos")
public class ControllerInstrumento {

    private List<Produto> produtos = new ArrayList<>();

    private boolean verificaInicio = true;

    @PostMapping("/violao")
    public ResponseEntity cadastrarViolao(@RequestBody Violao v) {
        produtos.add(v);
        return ResponseEntity.created(null).build();
    }

    @PostMapping("/saxofone")
    public ResponseEntity cadastrarSaxofone(@RequestBody Saxofone s) {
        produtos.add(s);
        return ResponseEntity.created(null).build();
    }

    @GetMapping("/{instrumento}")
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

    @DeleteMapping("/{id}")
    public ResponseEntity excluirInstrumento(@PathVariable int id) {
        if (produtos.size() >= id) {
            produtos.remove(id - 1);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}