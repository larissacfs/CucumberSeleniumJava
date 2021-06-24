# language: pt
@login
Funcionalidade: Login
    Como um usuario
    Eu quero fazer login
    Para aceder a Secure Area

Contexto:
	Dado que eu acedi a página de login

Cenário: Login Sucesso
    Quando eu insiro credenciais válidas
    E eu clico no botão de login
    Então eu devo ser redirecionado a Secure Area
    
@LoginInsucesso
Cenário: Login Insucesso
    Quando eu insiro credenciais inválidas
    E eu clico no botão de login
    Então eu não devo ser redirecionado a Secure Area
    Mas devo permanecer na página de login

@esquema    
Esquema do Cenario: Login Insucesso
    Quando eu insiro "<username>" no campo de username
    E eu insiro "<password>" no campo de password
    E eu clico no botão de login
    Então eu não devo ser redirecionado a Secure Area
    Mas devo permanecer na página de login

    Exemplos:
	| username | password |
	| tomsmith | 1234     | 
	| tomsmith | admin123 |