package com.example.app_catalogo_receitas.data

import com.example.app_catalogo_receitas.model.Categoria
import com.example.app_catalogo_receitas.model.Receita

object ReceitasDataSource {

    val receitas = listOf(
        Receita(
            id = 1,
            titulo = "Bolo de Cenoura",
            descricao = "Bolo com cobertura de chocolate.",
            ingredientes = listOf(
                "3 cenouras",
                "4 ovos",
                "1 xícara de óleo",
                "2 xícaras de açúcar",
                "2 e 1/2 xícaras de farinha",
                "1 colher de fermento"
            ),
            passos = listOf(
                "Bata no liquidificador a cenoura, os ovos e o óleo.",
                "Misture com o açúcar e a farinha.",
                "Adicione o fermento e asse por 40 minutos."
            ),
            categoria = Categoria.DOCES,
            tempo = "50 min",
            dificuldade = "Fácil",
            porcoes = 8
        ),
        Receita(
            id = 2,
            titulo = "Macarrão ao Alho e Óleo",
            descricao = "Prato rápido e saboroso.",
            ingredientes = listOf(
                "250 g de espaguete",
                "4 dentes de alho",
                "Azeite",
                "Sal",
                "Salsinha"
            ),
            passos = listOf(
                "Cozinhe o macarrão em água com sal.",
                "Doure o alho fatiado no azeite.",
                "Misture tudo e finalize com salsinha."
            ),
            categoria = Categoria.MASSAS,
            tempo = "20 min",
            dificuldade = "Fácil",
            porcoes = 2
        ),
        Receita(
            id = 3,
            titulo = "Panqueca Simples",
            descricao = "Ótima para café da manhã.",
            ingredientes = listOf(
                "1 ovo",
                "1 xícara de leite",
                "1 xícara de farinha",
                "1 pitada de sal"
            ),
            passos = listOf(
                "Misture todos os ingredientes.",
                "Frite uma concha da massa em frigideira untada.",
                "Vire quando dourar e sirva."
            ),
            categoria = Categoria.CAFE_DA_MANHA,
            tempo = "15 min",
            dificuldade = "Fácil",
            porcoes = 4
        ),
        Receita(
            id = 4,
            titulo = "Salada Caprese",
            descricao = "Tomate, muçarela e manjericão, simples e fresca.",
            ingredientes = listOf(
                "3 tomates maduros",
                "200 g de muçarela de búfala",
                "Folhas de manjericão",
                "Azeite",
                "Sal e pimenta a gosto"
            ),
            passos = listOf(
                "Corte os tomates e a muçarela em rodelas.",
                "Intercale as fatias em um prato e distribua o manjericão.",
                "Tempere com azeite, sal e pimenta."
            ),
            categoria = Categoria.SALADAS,
            tempo = "10 min",
            dificuldade = "Fácil",
            porcoes = 2
        ),
        Receita(
            id = 5,
            titulo = "Salada de Grão-de-bico",
            descricao = "Refrescante e rica em proteínas.",
            ingredientes = listOf(
                "2 xícaras de grão-de-bico cozido",
                "1 pepino em cubos",
                "1 tomate em cubos",
                "1/2 cebola roxa picada",
                "Suco de 1 limão",
                "Azeite e sal"
            ),
            passos = listOf(
                "Misture o grão-de-bico, o pepino, o tomate e a cebola.",
                "Tempere com limão, azeite e sal.",
                "Deixe na geladeira por 15 minutos antes de servir."
            ),
            categoria = Categoria.SALADAS,
            tempo = "25 min",
            dificuldade = "Fácil",
            porcoes = 4
        ),
        Receita(
            id = 6,
            titulo = "Strogonoff de Frango",
            descricao = "Clássico cremoso para o almoço.",
            ingredientes = listOf(
                "500 g de peito de frango em cubos",
                "1 cebola picada",
                "2 dentes de alho",
                "3 colheres de ketchup",
                "1 colher de mostarda",
                "1 caixinha de creme de leite",
                "1 lata de champignon"
            ),
            passos = listOf(
                "Refogue a cebola e o alho e acrescente o frango até dourar.",
                "Junte o ketchup, a mostarda e o champignon e cozinhe por 10 minutos.",
                "Desligue o fogo, misture o creme de leite e sirva com arroz."
            ),
            categoria = Categoria.PRATOS_PRINCIPAIS,
            tempo = "40 min",
            dificuldade = "Médio",
            porcoes = 4
        ),
        Receita(
            id = 7,
            titulo = "Feijoada Simples",
            descricao = "Feijão preto com carnes, para dias especiais.",
            ingredientes = listOf(
                "500 g de feijão preto",
                "300 g de carne seca dessalgada",
                "200 g de linguiça calabresa",
                "200 g de bacon",
                "1 cebola picada",
                "4 dentes de alho",
                "Folhas de louro"
            ),
            passos = listOf(
                "Cozinhe o feijão na pressão com as folhas de louro por 40 minutos.",
                "Refogue o bacon, a linguiça, a carne seca, a cebola e o alho.",
                "Junte tudo ao feijão e cozinhe por mais 20 minutos."
            ),
            categoria = Categoria.PRATOS_PRINCIPAIS,
            tempo = "1h 30 min",
            dificuldade = "Médio",
            porcoes = 6
        ),
        Receita(
            id = 8,
            titulo = "Espaguete à Carbonara",
            descricao = "Massa cremosa com ovos e bacon.",
            ingredientes = listOf(
                "250 g de espaguete",
                "150 g de bacon em cubos",
                "3 gemas",
                "1 ovo inteiro",
                "50 g de queijo parmesão ralado",
                "Pimenta-do-reino"
            ),
            passos = listOf(
                "Cozinhe o espaguete em água com sal.",
                "Frite o bacon até ficar crocante.",
                "Misture as gemas, o ovo e o parmesão.",
                "Escorra a massa, junte ao bacon e, fora do fogo, misture o creme de ovos."
            ),
            categoria = Categoria.MASSAS,
            tempo = "25 min",
            dificuldade = "Médio",
            porcoes = 2
        ),
        Receita(
            id = 9,
            titulo = "Brigadeiro",
            descricao = "O doce de festa mais querido do Brasil.",
            ingredientes = listOf(
                "1 lata de leite condensado",
                "1 colher de manteiga",
                "4 colheres de chocolate em pó",
                "Chocolate granulado"
            ),
            passos = listOf(
                "Misture o leite condensado, a manteiga e o chocolate em uma panela.",
                "Cozinhe mexendo até desgrudar do fundo.",
                "Deixe esfriar, enrole em bolinhas e passe no granulado."
            ),
            categoria = Categoria.DOCES,
            tempo = "30 min",
            dificuldade = "Fácil",
            porcoes = 20
        ),
        Receita(
            id = 10,
            titulo = "Tapioca com Queijo",
            descricao = "Rápida e sem glúten, boa para o café da manhã.",
            ingredientes = listOf(
                "4 colheres de goma de tapioca",
                "2 fatias de queijo muçarela",
                "1 pitada de sal"
            ),
            passos = listOf(
                "Espalhe a goma em uma frigideira quente e antiaderente.",
                "Quando firmar, coloque o queijo no centro.",
                "Dobre ao meio e deixe derreter por 1 minuto."
            ),
            categoria = Categoria.CAFE_DA_MANHA,
            tempo = "5 min",
            dificuldade = "Fácil",
            porcoes = 1
        )
    )

    fun porId(id: Int): Receita? = receitas.find { it.id == id }
}