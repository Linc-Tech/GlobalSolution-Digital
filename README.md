### Integrantes 


86501 - Emily Vasconcelos
<br>
84826 - Gabriel Carvalho Fernandes
<br>
85931 - Gabriel Lucas Alves Da Silva
<br>
86263 - Larissa Soares Santos Oliveira
<br>
86178 - Mateus Ramos Martins
<br>
86524 - Thalita Feitosa Da Silva

#### Link do Vídeo
https://youtu.be/r4OvShy6XQg

#### Configuração do backend

O nosso backend conta com o uso de uma lib chamada “lombok” e, ela é configurada de forma diferente quando utilizado com o Eclipse. Portanto, aconselhamos que faça a instalação do IntelliJ IDE para não correr riscos de falhas tendo em vista que ele executa essa configuração automaticamente. Caso contrário, siga o passo-a-passo desse site para configurar o lombok no Eclipse - https://dicasdejava.com.br/como-configurar-o-lombok-no-eclipse/.

#### IntelliJ IDE.

1. Abra o IntelliJ IDE
2. Clique em Open
3. Procure o projeto que irá importar e selecione o pom.xml dele
4. Clique em Open com o pom selecionado
5. Clique em Open as Project
6. E agora só aguarde as dependências serem baixadas (as vezes é comum aparecer um popup no canto inferior direito da tela pedindo sua permissão para instalar as dependências, rodar o projeto como Maven ou até mesmo para baixar a versão do Java que estamos utilizando caso, esteja rodando o projeto pela primeira vez)



   **Observações**

- O nosso projeto está sendo realizado em Maven, portanto, para importá-lo no IntelliJ é necessário encontrar o **pom.xml** da aplicação e selecioná-la, senão, a IDE não conseguirá baixar as dependências do Maven e reconhecê-lo como um projeto Maven.

#### Configurando o banco de dados

1. Em resources, renomeie as variaveis username e password no arquivo application.properties.
2. Configure-o com os dados do seu banco Oracle SQL da FIAP.
   1. Caso utilize não utilize o servidor da FIAP, mude a `datasource.url` para a sua esperada.
3. Rode o arquivo executável do projeto - `GlobalSolution`




