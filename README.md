# Descrição do problema
Uma empresa de distribuição e logística possui uma frota composta por N caminhões. Semanalmente,
esta empresa organiza suas entregas em M rotas, as quais devem ser distribuídas entre os caminhões
disponíveis. A empresa deseja fazer a distribuição de maneira que cada caminhão cumpra a mesma
quilometragem, evitando assim que ao final do período existam caminhões ociosos enquanto outros
ainda estão executando várias rotas. Se não for possível cumprir a mesma quilometragem, que a
diferença entre a quilometragem dos caminhões seja a menor possível, diminuindo o problema.

Por exemplo, suponha a existência de 3 caminhões e 10 rotas com as seguintes quilometragens: 35, 34,
33, 23, 21, 32, 35, 19, 26, 42. Dentre as distribuições D1 e D2 abaixo, D1 seria considerada melhor.
D1
Caminhão 1: rotas 21, 32, 42 – total 95km
Caminhão 2: rotas 35, 34, 26 – total 95km
Caminhão 3: rotas 23, 19, 35, 33 – total 110km
D2
Caminhão 1: rotas 35, 33, 32, 42 – total 142km
Caminhão 2: rotas 35, 19, 26 – total 80km
Caminhão 3: rotas 23, 34, 21 – total 78km

---

# Instruções para implementação

## Solução com Backtracking
Projetar e implementar uma solução para o problema apresentado utilizando backtracking. A
solução deve incluir uma estratégia de poda para soluções não promissoras.

Meedir o tempo de execução de conjuntos de tamanho crescente, até atingir um tamanho T que não consiga ser resolvido em até
30 segundos pelo algoritmo. Este teste deve ser realizado para 3 caminhões e começando com 6
rotas. Na busca do tempo limite de 30 segundos, faça o teste com 10 conjuntos de cada tamanho,
contabilizando a média das execuções.

## Solução com Algoritmo Guloso
Projetar e implementar soluções para o problema apresentado utilizando algoritmo guloso. Neste
caso, o grupo deve utilizar pelo menos duas estratégias gulosas diferentes na implementação,
comparando seus resultados.

Para este teste, utilize os mesmos conjuntos de tamanho T utilizados no backtracking. Em
seguida, aumente os tamanhos dos conjuntos de T em T até atingir o tamanho 10T, sempre
executando 10 testes de cada tamanho para utilizar a média.

### Solução com Divisão e Conquista
Projetar e implementar uma solução para o problema apresentado utilizando divisão e conquista.
O grupo deve decidir se vai utilizar o método demonstrado em aula ou outro à escolha.

Neste caso, utilize os mesmos conjuntos de tamanho T utilizados no backtracking.

## Solução com Programação Dinamica
Projetar e implementar uma solução para o problema apresentado utilizando programação
dinâmica. O grupo deve decidir se vai utilizar o método demonstrado em aula ou outro à escolha.

Aqui, utilize os mesmos conjuntos de teste do algoritmo guloso.

---

# Instruções para relatório
Criar um relatório técnico sobre as implementações. Este relatório deve conter (i) as explicações
sobre as decisões tomadas e o funcionamento de cada algoritmo implementado e (ii) a comparação
de resultados obtidos pelas implementações. Esta comparação deve se dar tanto em relação ao
tempo de execução como em relação à qualidade do resultado. Evite fazer comparações rasas ou
simplesmente demonstrar números. O trabalho pressupõe considerações acerca do problema, das
técnicas utilizadas, dos resultados esperados e obtidos.
