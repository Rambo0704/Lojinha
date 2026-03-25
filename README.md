

##  Estrutura do Projeto

```
org.example
│
├── models
│   ├── Cliente.java
│   ├── Produto.java
│   ├── Pedido.java
│   ├── ItemPedido.java
│   └── Pagamento.java
│
├── service
│   └── LojaService.java
│
├── external
│   └── PagamentoGateway.java
│
└── Main.java
```
* **models**: Contém as entidades do sistema.
* **service**: Contém a lógica de negócio.
* **external**: Simula integração com sistema externo de pagamento.
* **Main**: Responsável pela execução e interação com o usuário.

---

## Principais Decisões Arquiteturais

### ✔ Arquitetura Monolítica Cliente-Servidor

O sistema foi implementado como uma aplicação única (monolítica), onde toda a lógica está centralizada no backend.



## Uso do Padrão Singleton

### Onde foi aplicado

Na classe:

```
external/PagamentoGateway.java
```

---

### Justificativa do uso do Singleton

O padrão Singleton foi utilizado para garantir que exista **apenas uma instância** da classe responsável pela comunicação com o sistema externo de pagamento durante toda a execução da aplicação.

Isso é importante porque:

* Evita múltiplas conexões desnecessárias com o serviço externo
* Simula um recurso compartilhado (como APIs reais de pagamento)
* Garante consistência no processamento dos pagamentos
* Reduz consumo de recursos



