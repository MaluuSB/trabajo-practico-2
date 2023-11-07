
// Expresiones regulares para validar diferentes campos
const rexNombreApellido = new RegExp("^[A-ZÑa-zñ ]{3,}$");
const rexAlias = new RegExp("^[A-Za-z0-9_-]{3,}$");
const rexContrasenia = new RegExp("^[A-Za-z0-9_-]{7,16}$");
const rexEmail = new RegExp("^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$");
const rexCelular = new RegExp("^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{3,6}$");

// Obtener referencias a elementos del DOM
const inputNombre = document.getElementById('nombre');
const inputApellido = document.getElementById('apellido');
const mensajeNombre = document.getElementById('mensaje-nombre');
const mensajeApellido = document.getElementById('mensaje-apellido');

const inputAlias = document.getElementById('alias');
const mensajeAlias = document.getElementById('mensaje-alias');

const inputContrasenia = document.getElementById('contrasenia');
const mensajeContrasenia = document.getElementById('mensaje-contrasenia');

const inputEmail1 = document.getElementById('email_principal');
const inputEmail2 = document.getElementById('email_secundario');
const mensajeEmail1 = document.getElementById('mensaje-email1');
const mensajeEmail2 = document.getElementById('mensaje-email2');

const inputCelular = document.getElementById('numero_celular');
const mensajeCelular = document.getElementById('mensaje-celular');

const inputTipoUsuario = document.getElementById('tipo_usuario');
const mensajeTipo = document.getElementById('mensaje-tipo');

// Funcion para actualizar la apariencia de los inputs segun si son validos o no
function actualizarInput(input,valor){

    if(valor){
        input.classList.remove("error-input");
        //mensajeMal.classList.remove("mostrar-p");
        //mensajeMal.classList.add("ocultar-p");
        
        input.classList.add("exito-input");
        //mensajeExito.classList.remove("ocultar-p");
        //mensajeExito.classList.add("mostrar-p");
    }else{
        input.classList.remove("exito-input");
        //mensajeExito.classList.remove("mostrar-p");
        //mensajeExito.classList.add("ocultar-p");

        input.classList.add("error-input");
        //mensajeMal.classList.remove("ocultar-p");
        //mensajeMal.classList.add("mostrar-p");
    }
}

// Funcion para validar los datos del usuario
function validarDatosUsuario(){
    let formularioValido = true;

    inputNombre.value.match(rexNombreApellido) != null ? actualizarInput(inputNombre,true) : (actualizarInput(inputNombre,false),formularioValido = false);
    inputApellido.value.match(rexNombreApellido) != null ? actualizarInput(inputApellido,true) : (actualizarInput(inputApellido,false),formularioValido = false);
    
    inputAlias.value.match(rexAlias) != null ? actualizarInput(inputAlias,true) : (actualizarInput(inputAlias,false),formularioValido = false);
    inputContrasenia.value.match(rexContrasenia) != null ? actualizarInput(inputContrasenia,true) : (actualizarInput(inputContrasenia,false),formularioValido = false);
    
    inputEmail1.value.match(rexEmail) != null ? actualizarInput(inputEmail1,true) : (actualizarInput(inputEmail1,false),formularioValido = false);
    inputEmail2.value.match(rexEmail) != null ? actualizarInput(inputEmail2,true) : (actualizarInput(inputEmail2,false),formularioValido = false);
    if (inputEmail1.value == inputEmail2.value){
        actualizarInput(inputEmail1,false);
        actualizarInput(inputEmail2,false);
        formularioValido = false;
    }

    inputCelular.value.match(rexCelular) != null ? actualizarInput(inputCelular,true) : (actualizarInput(inputCelular,false),formularioValido = false);

    if(inputTipoUsuario.value === "1" || inputTipoUsuario.value === "2")
        actualizarInput(inputTipoUsuario,true);
    else{
        actualizarInput(inputTipoUsuario,false);
        formularioValido = false;
    }

    return formularioValido;
}