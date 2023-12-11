const formulario = document.querySelector("form");
const formNome = document.querySelector('.inputFormNome');
const formApelido = document.querySelector('.inputFormApelido');
const formCpf = document.querySelector('.inputFormCpf');
const formEmail = document.querySelector(".inputFormEmail");
const formSenha = document.querySelector(".inputFormSenha");

function cadastrar () {
    fetch("http://localhost:8080/usuarios",
        {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
            method: "POST",
            body: JSON.stringify({
                nome: formNome.value,
                apelido: formApelido.value,
                cpf: formCpf.value,
                email: formEmail.value,
                senha: formSenha.value
            })
        })
        .then(function (res) {console.log(res)})
        .catch(function (res) {console.log(res)})

}

function limpar() {
    formNome.value = "";
    formApelido.value = "";
    formCpf.value = "";
    formEmail.value = "";
    formSenha.value = "";
}

formulario.addEventListener('submit', function (event){
    event.preventDefault();
    window.location.href="login/home.html";
    cadastrar();
    limpar();
});