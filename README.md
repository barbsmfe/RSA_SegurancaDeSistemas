# RSA - Segurança De Sistemas

## Objetivo

O objetivo do trabalho é fazer um programa que:

1. Gera uma chave pública e uma chave privada para usar com RSA. Estas chavesdevemter um número de bits superior a 1000. Imprimir a chave pública e chave privada.
2. Dada uma mensagem M, cifre esta mensagem usando RSA com a chave pública gerada no item 1. Imprimir a mensagem cifrada C.
3. Dada uma mensagem C, decifre esta mensagem usando RSA com a chave privada gerada no item 1. Imprimir a mensagem decifrada.
4. O programa deve gerar, usando o pequeno teorema de Fermat,os números primos que comporão o módulo utilizado no RSA. Para cálculo do inverso de um número pode usar o algoritmo extendido de Euclides ou uma biblioteca pronta.

## Execução

### IDE

Basta entrar onde está a classe main e executar o programa, existe uma mensagem exemplo na classe Main que pode ser modificada a qualquer instante para razões de teste. Após a execução é só ver o resultado exibido em tela.

### Terminal

Para executar através do terminal basta entrar na pasta do projeto e usar o comando:

        gradle build

Isso irá gerar um arquivo .jar na pasta ./build/libs/, para executar esse arquivo entre nessa pasta e digite o comando: 

        java -jar RSA_SegurancaDeSistemas.jar

Agora é só apertar a tecla Enter e ver o resultado exibido em tela.
 
