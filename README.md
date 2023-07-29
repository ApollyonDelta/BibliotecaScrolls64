# BibliotecaScrolls64
Atividade semestral de Linguagem de Programação III de 2023/1

Tabela Jogador
● PK: Id
● Nome de Usuário
● Email
● Senha
● Data de Cadastro

Tabela Personagem
● PK: Id
● Nome do Personagem
● Raça
● Classe
● Conceito
● Vida
● Data de Criação
● Status {ATIVO, MORTO, EM HIATO, INATIVO}
● Sistema
● FK: Id Jogador

Jogador - 1:N - Personagem

Requisitos Funcionais
● RF 1: Permitir ao usuário cadastrar uma conta no sistema;
● RF 2: Permitir ao usuário realizar login em uma conta cadastrada;
● RF 3: Permitir ao usuário alterar seus dados cadastrais;
● RF 4: Permitir ao usuário excluir sua conta cadastrada;
● RF 5: Criar personagem informando os dados requisitados;
● RF 6: Editar nível e status do personagem;
● RF 7: Excluir o personagem criado;
● RF 8: Listar os personagens criados por jogador;
