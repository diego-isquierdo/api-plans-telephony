<h1>Api-planos-telefonia</h1>

<h2>API para efetuar Consulta, cadastro remoção e atualização de planos de telefonia</h2>

<h3>Funcionalidades</h3>
</br>
<h4>Consulta de Planos de telefonia</h4>
<p>Consulta por Primary Key</p>
    @GetMapping("/{id}")
    public ResponseEntity<PlanoDto> findById(@PathVariable Long id){
        Optional<Plano> plano = planoRepository.findById(id);
        return ResponseEntity.ok(new PlanoDto(plano.get()));
    }
</br>
</br>
<p>Consulta por Operadora</p>
<p>Consulta por Tipo de plano</p>
 @GetMapping
    public ResponseEntity<Set<PlanoDto>> findByTipoOrOperadora(
        @RequestParam(required = false) String operadora,
        @RequestParam(required = false) String tipo
        //@RequestParam Long ddd
    ){
        Set<Plano> planos = new HashSet<>();

        if(operadora!=null) planos.addAll(planoRepository.findByOperadoraName(operadora));
        if(tipo!=null) planos.addAll(planoRepository.findByTipo(new StringToEnumConverter().convert(tipo)));

        return new ResponseEntity<>(PlanoDto.converter(planos), HttpStatus.OK);
    }
</br>
</br>
<h4>Cadastro de Planos de telefonia</h4>
<p>Castro de Plano via POST/JSON</p>
    @PostMapping
    @Transactional
    public ResponseEntity<Plano> cadastrar(@RequestBody PlanoForm form, UriComponentsBuilder uriBuilder){
        Plano plano = form.converter(operadoraRepository, dddRepository);
        planoRepository.save(plano);
        URI uri = uriBuilder.path("/plano/{id}").buildAndExpand(plano.getId()).toUri();

        return  ResponseEntity.created(uri).body(plano);
    }
</br>
</br>
<h4>Atualização de Planos de telefonia</h4>
<p>Atualização de Plano via PUT/JSON</p>
   @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<PlanoDto> atualizar(@PathVariable Long id, @RequestBody AtualizaPlanoForm form){
        if(planoRepository.findById(id).isPresent()){
            Plano plano = form.atualizar(id, planoRepository);
            return ResponseEntity.ok(new PlanoDto(plano));
        }
        return ResponseEntity.notFound().build();
    }
</br>
</br>
<h4>Remoção de Planos de telefonia</h4>
<p>Remoção de planos via DELETE, passando id por parâmetro</p>
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id){
        if(planoRepository.findById(id).isPresent()){
            planoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
