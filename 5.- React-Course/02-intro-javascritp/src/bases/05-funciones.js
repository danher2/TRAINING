const saludar = function(nombre){

    return `Hola, ${nombre}`;
}


//funciones flecha
const saludar2 = (nombre) =>{

    return `Hola, ${nombre}`;
}

//funcion flecha simplificada
const saludar3= nombre =>`Hola, ${nombre}`;
const saludar4= nombre =>`Hola Mundo`;





//console.log(saludar('Daniel'));

console.log(saludar);
console.log(saludar2('vegeta'));
console.log(saludar3('vegeta'));
console.log(saludar4());


const getUser = () =>{

    return{
        uid: 'ABCD1234',
        username: 'El_papi1234'
    }
}

//simplificado el return
const getUser2 = () =>({
        uid: 'ABCD1234',
        username: 'El_papi1234'
    })



console.log(getUser);
console.log(getUser2);

//Tarea
//1.-Transformar u una funcion de flecha
//2.-Tiene que retornar un objeto implicito
//3.-Pruebas

function getUsuarioActivo (nombre){

        return{
            uid: 'ABC567',
            username: nombre
       }
}

//tarea
const getUsuarioActivo2 = nombre => ({
    uid: 'ABC567',
    username: nombre
})

const usuarioActivo = getUsuarioActivo2('daniel');

console.log(usuarioActivo);



















