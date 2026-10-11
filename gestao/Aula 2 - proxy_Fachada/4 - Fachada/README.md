# Padrao Fachada (Facade)

Para iniciar qualquer modo de jogo, o `Main` precisa conhecer e coordenar
corretamente ate 4 subsistemas do motor (`SistemaDeGraficos`,
`SistemaDeAudio`, `SistemaDeRede`, `SistemaDeSave`), sempre respeitando uma
ordem especifica de chamadas. Essa coordenacao esta duplicada em
`iniciarModoHistoria()`, `iniciarModoOnline()` e `iniciarModoTreino()`, e
qualquer mudanca na forma de inicializar o motor (por exemplo, uma nova
etapa obrigatoria) precisaria ser repetida em todos os metodos.

Refatore usando o padrao **Fachada (Facade)** para que o cliente (`Main`)
passe a depender de uma unica classe simples, sem conhecer os subsistemas
internos do motor de jogo. Siga os TODOs numerados no arquivo `Main.java`.
