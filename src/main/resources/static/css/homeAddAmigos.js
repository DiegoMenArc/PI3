document.addEventListener("DOMContentLoaded", function () {
    const input = document.getElementById("inputAmigo");
    const botao = document.getElementById("btnEnviar");
    const mensagem = document.getElementById("mensagemSucesso");
    const nomeUsuario = document.getElementById("nomeUsuario");

    if (!input || !botao) return;

    // Monitora a digitação para habilitar/desabilitar o botão
    input.addEventListener("input", function () {
        const valor = input.value.trim();
        botao.disabled = valor === ""; // O botão fica cinza/desativado se estiver vazio

        if (valor === "") {
            mensagem.style.display = "none";
        }
    });

    // Função separada para enviar o pedido (assim podemos usar no clique e no Enter)
    function enviarPedido() {
        const usuario = input.value.trim();

        if (usuario !== "") {
            nomeUsuario.textContent = usuario;
            mensagem.style.display = "block";

            // Limpa o input e desabilita o botão para evitar cliques duplos
            input.value = "";
            botao.disabled = true;
        }
    }

    // Dispara ao clicar no botão
    botao.addEventListener("click", enviarPedido);

    // Dispara ao apertar "Enter" dentro do input
    input.addEventListener("keydown", function (event) {
        // Verifica se a tecla foi o Enter e se o botão NÃO está desativado
        if (event.key === "Enter" && !botao.disabled) {
            event.preventDefault(); // Previne que a página recarregue caso você coloque isso dentro de um <form> futuramente
            enviarPedido();
        }
    });
});