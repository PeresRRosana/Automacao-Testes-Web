$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/BuscaPets.feature");
formatter.feature({
  "name": "Aplicação Pets - Automação Web",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@web"
    }
  ]
});
formatter.scenario({
  "name": "Acessar Aplicacao e realizar uma pesquisa",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@web"
    },
    {
      "name": "@0001"
    }
  ]
});
formatter.step({
  "name": "que acesso a aplicacao desejada",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.BuscaPetsSteps.que_acesso_a_aplicacao_desejada()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "realizo uma busca",
  "keyword": "When "
});
formatter.match({
  "location": "steps.BuscaPetsSteps.realizo_uma_busca()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "obtenho um resultado",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.BuscaPetsSteps.obtenho_um_resultado()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "fecho a aplicacao",
  "keyword": "And "
});
formatter.match({
  "location": "steps.BuscaPetsSteps.fecho_a_aplicacao()"
});
formatter.result({
  "status": "passed"
});
});