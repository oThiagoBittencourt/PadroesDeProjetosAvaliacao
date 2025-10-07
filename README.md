# Padrões De Projetos - Avaliação

### 📘 Questão 1 — Sistema de Cálculo de Tarifas

* **Cenário:** cálculo de tarifas para transporte terrestre, aéreo e marítimo, cada um com regras próprias.
* **Padrão:** Factory Method
* **Justificativa:** permite criar objetos de forma genérica, delegando às subclasses a responsabilidade pela instanciação específica. Isso garante flexibilidade para lidar com múltiplas modalidades sem expor detalhes de implementação.
* **Benefícios:**

  * Extensão fácil para novos tipos de transporte.
  * Redução de acoplamento.
  * Centralização da lógica de criação.

---

### 📘 Questão 2 — Plataforma de Pagamentos

* **Cenário:** integração de múltiplos meios de pagamento (Cartão, Boleto, PIX) com instância dinâmica de processadores.
* **Padrão:** Abstract Factory
* **Justificativa:** fornece uma interface para criar famílias de objetos relacionados sem expor suas classes concretas. Cada tipo de pagamento possui sua própria fábrica responsável pela criação dos processadores correspondentes, garantindo baixo acoplamento e maior flexibilidade.
* **Benefícios:**

  * Configuração dinâmica.
  * Baixo acoplamento.
  * Inclusão fácil de novos métodos de pagamento.

---

### 📘 Questão 3 — Sistema de Notícias e Assinaturas

* **Cenário:** notificação automática a leitores inscritos quando novas matérias são publicadas.
* **Padrão:** Observer
* **Justificativa:** estabelece uma relação 1:N entre objetos, onde um sujeito notifica automaticamente todos os observadores inscritos quando muda de estado. Isso mantém o sistema desacoplado e facilita a manutenção e expansão de funcionalidades de notificação.
* **Benefícios:**

  * Desacoplamento total.
  * Suporte a múltiplos tópicos e assinantes.
  * Extensões futuras fáceis (e-mail, push, etc.).

---

### 📘 Questão 4 — Relatórios de Vendas com Extensões

* **Cenário:** relatórios com funcionalidades opcionais (estatísticas, gráficos, exportação PDF) sem modificar o código básico.
* **Padrão:** Decorator
* **Justificativa:** possibilita adicionar funcionalidades dinamicamente a objetos existentes sem alterar sua estrutura. Cada recurso extra é implementado como um decorador, mantendo o código organizado, flexível e aberto a extensões futuras.
* **Benefícios:**

  * Respeita o Princípio Open/Closed.
  * Combinação dinâmica de recursos.
  * Baixo acoplamento e código reutilizável.

---

### 📘 Questão 5 — Modelos de Documentos Personalizáveis

* **Cenário:** modelos (currículos, relatórios, propostas) personalizáveis para cada cliente sem recriação.
* **Padrão:** Prototype
* **Justificativa:** permite criar novos objetos clonando instâncias existentes, evitando a necessidade de reconstrução. Cada modelo serve como base para gerar cópias personalizadas rapidamente, garantindo eficiência e flexibilidade.
* **Benefícios:**

  * Eficiência e rapidez.
  * Flexibilidade para modificações individuais.
  * Baixo acoplamento.
  * Reutilização de estruturas existentes.
