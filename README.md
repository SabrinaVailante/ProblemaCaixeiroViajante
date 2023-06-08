# Problema do Caixeiro Viajante

Este repositório contém a implementação de um algoritmo aproximado para resolver o Problema do Caixeiro Viajante, desenvolvido como parte do trabalho final da disciplina Teoria de Grafos, no Instituto Cultural Newton Paiva Ferreira.

## Introdução

O Problema do Caixeiro Viajante (PCV) é um problema clássico de otimização combinatória. Ele consiste em encontrar a menor rota possível que um caixeiro viajante deve percorrer para visitar um conjunto de cidades uma única vez e retornar à cidade de origem.

Formalmente, dado um conjunto de cidades e as distâncias entre elas, o objetivo é encontrar a rota que minimize a distância total percorrida pelo caixeiro viajante, passando por todas as cidades exatamente uma vez e retornando à cidade de partida.

O PCV é considerado um problema NP-difícil, o que significa que não existe uma solução eficiente (polinomial) conhecida para resolvê-lo em todos os casos. Portanto, são utilizadas heurísticas e algoritmos aproximados para encontrar soluções subótimas, mas razoavelmente boas, para o PCV.

## Descrição do Algoritmo Implementado

O algoritmo implementado utiliza uma abordagem heurística conhecida como algoritmo guloso. Ele parte de uma cidade de origem selecionada pelo usuário e, em cada etapa, escolhe a cidade mais próxima não visitada para ser visitada em seguida. O processo continua até que todas as cidades tenham sido visitadas, e então o caixeiro retorna à cidade de origem, completando o ciclo.

## Funcionamento do Algoritmo

1. Carregamento dos Dados: O algoritmo carrega as distâncias entre as cidades a partir de um arquivo CSV fornecido pelo usuário.
2. Encontrar a Rota: O algoritmo inicia selecionando a cidade de origem fornecida pelo usuário e, em cada etapa, escolhe a cidade mais próxima não visitada para visitar em seguida. Esse processo continua até que todas as cidades tenham sido visitadas.
3. Retornar à Cidade de Origem: Após visitar todas as cidades, o caixeiro retorna à cidade de origem, formando um ciclo fechado.
4. Cálculo da Distância Total: O algoritmo calcula a distância total percorrida, somando as distâncias entre cada par de cidades adjacentes.

## Exemplos

O repositório contém exemplos de execução do algoritmo para diferentes conjuntos de cidades. Os resultados obtidos mostram as rotas encontradas e a distância total percorrida.

## Interface com o Usuário

A interação com o usuário é realizada por meio da linha de comando. Ao executar o programa, o usuário pode selecionar a cidade de origem e obter a rota encontrada pelo algoritmo, bem como a distância total percorrida.

## Implementação

O algoritmo foi implementado em Java, devido às suas vantagens, como ser uma linguagem de propósito geral, amplamente utilizada e com uma rica biblioteca padradorizada.
