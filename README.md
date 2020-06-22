<h1>Api-plans-telefonia</h1>

<h2>API para efetuar Consulta, cadastro remoção e atualização de plans de telefonia</h2>

<h3>Funcionalidades</h3>
</br>
<h4>Consulta de Planos de telefonia</h4>
<p>Consulta por Primary Key</p>
    @GetMapping("/{id}")
    public ResponseEntity<PlanoDto> findById(@PathVariable Long id){
        Optional<Plano> plan = planRepository.findById(id);
        return ResponseEntity.ok(new PlanoDto(plan.get()));
    }
</br>
</br>
<p>Consulta por Operadora</p>
<p>Consulta por Tipo de plan</p>
 @GetMapping
    public ResponseEntity<Set<PlanoDto>> findByTipoOrOperadora(
        @RequestParam(required = false) String operator,
        @RequestParam(required = false) String type
        //@RequestParam Long ddd
    ){
        Set<Plano> plans = new HashSet<>();

        if(operator!=null) plans.addAll(planRepository.findByOperadoraName(operator));
        if(type!=null) plans.addAll(planRepository.findByTipo(new StringToEnumConverter().convert(type)));

        return new ResponseEntity<>(PlanoDto.converter(plans), HttpStatus.OK);
    }
</br>
</br>
<h4>Cadastro de Planos de telefonia</h4>
<p>Castro de Plano via POST/JSON</p>
    @PostMapping
    @Transactional
    public ResponseEntity<Plano> cadastrar(@RequestBody PlanoForm form, UriComponentsBuilder uriBuilder){
        Plano plan = form.converter(operadoraRepository, dddRepository);
        planRepository.save(plan);
        URI uri = uriBuilder.path("/plan/{id}").buildAndExpand(plan.getId()).toUri();

        return  ResponseEntity.created(uri).body(plan);
    }
</br>
</br>
<h4>Atualização de Planos de telefonia</h4>
<p>Atualização de Plano via PUT/JSON</p>
   @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<PlanoDto> atualizar(@PathVariable Long id, @RequestBody AtualizaPlanoForm form){
        if(planRepository.findById(id).isPresent()){
            Plano plan = form.atualizar(id, planRepository);
            return ResponseEntity.ok(new PlanoDto(plan));
        }
        return ResponseEntity.notFound().build();
    }
</br>
</br>
<h4>Remoção de Planos de telefonia</h4>
<p>Remoção de plans via DELETE, passando id por parâmetro</p>
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id){
        if(planRepository.findById(id).isPresent()){
            planRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
